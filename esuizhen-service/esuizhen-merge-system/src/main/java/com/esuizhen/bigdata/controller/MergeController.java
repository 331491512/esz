package com.esuizhen.bigdata.controller;

import com.esuizhen.bigdata.bean.MergeLogResult;
import com.esuizhen.bigdata.bean.MergePatientReq;
import com.esuizhen.bigdata.bean.PatientInfoReq;
import com.esuizhen.bigdata.bean.PatientResult;
import com.esuizhen.bigdata.common.ResponseResult;
import com.esuizhen.bigdata.common.RestResultGenerator;
import com.esuizhen.bigdata.repository.followup.VarPatientMedicalRepository;
import com.esuizhen.bigdata.repository.user.UPatientRepository;
import com.esuizhen.bigdata.service.EntityBakService;
import com.esuizhen.bigdata.service.MergeService;
import com.esuizhen.bigdata.service.RollBackMergeService;
import com.esuizhen.bigdata.service.user.MergeLogService;
import com.esuizhen.bigdata.service.user.PatientMergeService;
import com.esuizhen.bigdata.service.user.PatientService;
import com.westangel.common.bean.ErrorMessage;
import com.westangel.common.bean.Page;
import com.westangel.common.bean.TMsgResponse;
import com.westangel.common.util.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by fqc on 16/11/28.
 */
//@CrossOrigin(origins = "*", maxAge = 3600)
@Controller
public class MergeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MergeController.class);
    @Autowired
    MergeService mergeService;
    @Autowired
    RollBackMergeService rollBackMergeService;

    @Autowired
    UPatientRepository uPatientRepository;
    @Autowired
    VarPatientMedicalRepository varPatientMedicalRepository;
    @Autowired
    private EntityBakService entityBakService;

    /**
     * 消息资源
     */
    @Autowired
    private MessageSource messageSource;
    @Autowired
    private PatientService patientService;
    @Autowired
    private PatientMergeService patientMergeService;
    @Autowired
    private MergeLogService mergeLogService;


    @Deprecated
    @RequestMapping("v1")
    public ResponseResult executeMerge() throws Exception {

        //数据模拟 开始-------------------------------
        List<Long> patientIds = new ArrayList<>();
        // db43 416179L 467612L 394765L 被合并患者的联系人数为0
        //db43 396082L,397250L,400885L
        // db43 385146,385712,419040
        // db221 654228,676029,741730
        //patientIds.add(654228L);
        //patientIds.add(676029L);
        //patientIds.add(741730L);

        patientIds.add(396082L);
        patientIds.add(397250L);
        patientIds.add(400885L);


        //合并时前端用户编辑传来的患者姓名、性别、出生日期、身份证号码
        String trueName = "zhangsan";
        Integer sex = 1;
        //Date birthday = Date.from(Instant.now());
        String identification = "88888888888888888"; //其中身份证号只在user表中，其它的两者都需要更新

        MergePatientReq beanInfo = new MergePatientReq();
        beanInfo.setTrueName(trueName);
        beanInfo.setSex(sex);
        //beanInfo.setBirthDate(birthday);
        beanInfo.setIdentification(identification);

        //数据模拟 结束---------------------------------
        LOGGER.info("用户选择要合并的患者--->{}", patientIds);
        Map<String, Object> votedMap = mergeService.vote(patientIds);
        List<Long> otherPatientIds = (List<Long>) votedMap.get("otherPatientIds");
        Long goalPatientId = (Long) votedMap.get("goalPatientId");
        LOGGER.info("选举出目标患者为--->{}", goalPatientId);

        mergeService.execute(goalPatientId, otherPatientIds, beanInfo, "10000");//patientId 569543
        return RestResultGenerator.genResult("ok");
    }

    /**
     * select a.goalpatientid, count(a.patientid) cn, GROUP_CONCAT(a.patientid)
     * from uuid_patient_merge a
     * where a.repeatflag = 1
     * GROUP BY a.goalpatientid
     * having cn>2
     * order by a.goalpatientid
     * em->392606L,425728L,427454L
     * ;
     * 传递过来的otherPatientIds是保证为一组需要合并的，也就是说是过滤过的
     * <p>
     * @return
     * @throws InterruptedException
     */
    @RequestMapping(value = "/patient/merge",method = RequestMethod.POST)
    @ResponseBody
    public TMsgResponse executeMerge(@RequestBody MergePatientReq req, Locale locale) throws Exception {

        TMsgResponse<String> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            Long goalPatientId = req.getGoalPatientId();
            List<Long> otherPatientIds = req.getOtherPatientIds();
            mergeService.execute(goalPatientId, otherPatientIds, req, String.valueOf(req.getOperatorId()));
        } catch (Exception ex) {
            LOGGER.info("-->合并失败");
            LOGGER.info("记录错误日志中....");
            try {
                entityBakService.log(req, 0);
            } catch (Exception e) {
                LOGGER.info("-->日志添加失败");
            }
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
            LOGGER.error(ex.getMessage(), ex);
        }
        return msg;
    }

    /**
     * 回退合并
     * json -> {goalPatientId:1000,operatorId:3}
     * json -> {"goalPatientId":389775,"operatorId":3}
     *
     * @param req
     * @param locale
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/rollback",method = RequestMethod.POST)
    @ResponseBody
    public TMsgResponse rollBackMerge(@RequestBody MergePatientReq req, Locale locale) throws Exception {
        TMsgResponse<String> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            Long targetPatientId = req.getGoalPatientId();
            Long operatorId = req.getOperatorId();
            LOGGER.info("用户选择要回退合并的患者--->{}", targetPatientId);
            rollBackMergeService.executeRollBackMerge(targetPatientId, operatorId);
        } catch (Exception ex) {
            LOGGER.info("回退合并失败");
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
            LOGGER.error(ex.getMessage(), ex);
        }
        return msg;
    }

    @RequestMapping(value = "/patients",method = RequestMethod.POST)
    @ResponseBody
    public TMsgResponse<Map<String, Object>> mergePatientList(@RequestBody PatientInfoReq req, Locale locale) {
        //设置返回成功代码及提示消息
        TMsgResponse<Map<String, Object>> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            int searchId = patientService.saveMiddlePatientMerge(req, "/merge/patients", req.getUserId());
            int preTotalCount = patientService.queryPreMergePatientCount();
            int afterPatientCount = patientService.queryAfterMergePatientCount();
            Map<String, Object> resultMap = new HashMap<String, Object>();
            resultMap.put("searchId", searchId);
            resultMap.put("preMergePatientCount", afterPatientCount + preTotalCount);
            resultMap.put("afterMergePatientCount", preTotalCount);
            msg.setResult(resultMap);
        } catch (Exception ex) {
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
        }
        return msg;
    }

    @RequestMapping(value = "/back/{patientId}",method = RequestMethod.GET)
    @ResponseBody
    public TMsgResponse exportPatient(@PathVariable("patientId") Long patientId, Locale locale) {
        //设置返回成功代码及提示消息
        TMsgResponse<String> msg = new TMsgResponse<String>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            patientMergeService.updatePatientSimilarState(patientId);
        } catch (Exception ex) {
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
        }
        return msg;
    }

    /*@RequestMapping(value = "/patient/merge",method = RequestMethod.POST)
    @ResponseBody
    public TMsgResponse exportPatient(@RequestBody MergePatientReq req, Locale locale) {
        //设置返回成功代码及提示消息
        TMsgResponse<String> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            int result = patientMergeService.mergePatientInfo(req);
            if (result < 1) {
                msg.respCode = ErrorMessage.E1404.code;
                msg.respMsg = messageSource.getMessage(ErrorMessage.E1404.info, null, locale);
            }
        } catch (Exception ex) {
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
            LOGGER.error(ex.getMessage(), ex);

        }
        return msg;
    }*/

    @RequestMapping(value = "/logs",method = RequestMethod.GET)
    @ResponseBody
    public TMsgResponse<Page<MergeLogResult>> selectMergePatientLog(Integer num, Integer page, Locale locale) {
        //设置返回成功代码及提示消息
        TMsgResponse<Page<MergeLogResult>> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            msg.setResult(mergeLogService.selectMergePatientLogList(num, page));
        } catch (Exception ex) {
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
        }
        return msg;
    }

    @RequestMapping(value = "/goalpatient",method = RequestMethod.POST)
    @ResponseBody
    public TMsgResponse<PatientResult> electionTargetPatient(@RequestBody PatientInfoReq req, Locale locale) {
        //设置返回成功代码及提示消息
        TMsgResponse<PatientResult> msg = new TMsgResponse<>();
        msg.respCode = ErrorMessage.SUCCESS.code;
        msg.respMsg = messageSource.getMessage(ErrorMessage.SUCCESS.info, null, locale);
        try {
            msg.setResult(patientMergeService.electionTargetPatient(req.getPatientIds()));
        } catch (Exception ex) {
            //设置错误代码及提示消息
            msg.respCode = ErrorMessage.E1417.code;
            msg.respMsg = messageSource.getMessage(ErrorMessage.E1417.info, null, locale);
            LogUtil.logError.error(ex.getMessage(), ex);
            LOGGER.error(ex.getMessage(), ex);
        }
        return msg;

    }

}
