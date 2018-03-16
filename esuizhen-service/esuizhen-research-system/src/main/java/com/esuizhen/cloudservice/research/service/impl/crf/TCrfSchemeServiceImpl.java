package com.esuizhen.cloudservice.research.service.impl.crf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.esuizhen.cloudservice.research.dao.crf.TCrfMedicationInfoDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfRadiotherapyPartInfoDao;
import com.esuizhen.cloudservice.research.dao.crf.TCrfSchemeDao;
import com.esuizhen.cloudservice.research.model.crf.TCrfMedicationInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfRadiotherapyPartInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeChemotherapyMedication;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOther;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeOtherInfo;
import com.esuizhen.cloudservice.research.model.crf.TCrfSchemeRadiotherapy;
import com.esuizhen.cloudservice.research.model.crf.TCrfScheme;
import com.esuizhen.cloudservice.research.service.crf.TCrfSchemeService;
import com.westangel.common.util.GeneralUtil;

@Service
@Transactional
public class TCrfSchemeServiceImpl implements TCrfSchemeService {

	@Autowired
	private TCrfSchemeDao crfSchemeDao;

	@Autowired
	private TCrfMedicationInfoDao crfMedicationInfoDao;

	@Autowired
	private TCrfRadiotherapyPartInfoDao crfRadiotherapyPartInfoDao;

	@Override
	public List<TCrfScheme> queryCrfSchemeChemotherapyMedicationDetail(String crfObserveId) {
		return crfSchemeDao.queryCrfObservationTreatmentSchemeMedicationByCrfObserveId(crfObserveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfSchemeChemotherapyMedicationDetail(
			TCrfSchemeChemotherapyMedication crfSchemeChemotherapyMedication) {
		// 删除用药信息
		crfMedicationInfoDao.deleteCrfObservationTreatmentSchemeMedicationByCrfObserveId(
				crfSchemeChemotherapyMedication.getCrfObserveId());

		// 删除方案信息
		crfSchemeDao.deleteCrfObservationTreatmentSchemeOptionsByCrfObserveId(
				crfSchemeChemotherapyMedication.getCrfObserveId());

		// 循环保存方案及用药信息
		for (int i = 0; i < crfSchemeChemotherapyMedication.getDataList().size(); i++) {
			TCrfScheme crfScheme = crfSchemeChemotherapyMedication.getDataList().get(i);
			String crfObserveSchemeId = GeneralUtil.generateUniqueID("OSCHE");
			crfScheme.setCrfObserveId(crfSchemeChemotherapyMedication.getCrfObserveId());
			crfScheme.setCrfObserveSchemeId(crfObserveSchemeId);
			crfScheme.setIndex(i);
			crfSchemeDao.insertCrfObservationTreatmentSchemeOptions(crfScheme);

			for (int j = 0; j < crfScheme.getMedicationList().size(); j++) {
				TCrfMedicationInfo crfMedicationInfo = crfScheme.getMedicationList().get(j);
				crfMedicationInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
				crfMedicationInfo.setCrfObserveSchemeId(crfObserveSchemeId);
				crfMedicationInfo.setIndex(j);
			}
			crfMedicationInfoDao
					.insertCrfObservationChemotherapyMedicationDetailOptionsList(crfScheme.getMedicationList());
		}
	}

	@Override
	public List<TCrfScheme> queryCrfSchemeRadiotherapyDetail(String crfObserveId) {
		return crfSchemeDao.queryCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId(crfObserveId);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveCrfSchemeRadiotherapyDetail(TCrfSchemeRadiotherapy crfSchemeRadiotherapy) {
		// 删除部位信息
		crfRadiotherapyPartInfoDao
				.deleteCrfObservationTreatmentSchemeRadiotherapyByCrfObserveId(crfSchemeRadiotherapy.getCrfObserveId());

		// 删除方案信息
		crfSchemeDao.deleteCrfObservationTreatmentSchemeOptionsByCrfObserveId(crfSchemeRadiotherapy.getCrfObserveId());

		// 循环保存方案及部位信息
		for (int i = 0; i < crfSchemeRadiotherapy.getDataList().size(); i++) {
			TCrfScheme crfScheme = crfSchemeRadiotherapy.getDataList().get(i);
			String crfObserveSchemeId = GeneralUtil.generateUniqueID("OSCHE");
			crfScheme.setCrfObserveId(crfSchemeRadiotherapy.getCrfObserveId());
			crfScheme.setCrfObserveSchemeId(crfObserveSchemeId);
			crfScheme.setIndex(i);
			crfSchemeDao.insertCrfObservationTreatmentSchemeOptions(crfScheme);

			for (int j = 0; j < crfScheme.getBodyPartList().size(); j++) {
				TCrfRadiotherapyPartInfo crfRadiotherapyPartInfo = crfScheme.getBodyPartList().get(j);
				crfRadiotherapyPartInfo.setCrfObserveItemId(GeneralUtil.generateUniqueID("OITEM"));
				crfRadiotherapyPartInfo.setCrfObserveSchemeId(crfObserveSchemeId);
				crfRadiotherapyPartInfo.setIndex(j);
			}
			crfRadiotherapyPartInfoDao.insertCrfObservationRadiotherapyDetailOptionsList(crfScheme.getBodyPartList());
		}
	}

	@Override
	public List<TCrfSchemeOtherInfo> queryCrfTreatmentSchemeOtherDetail(String crfObserveId) {
		return crfSchemeDao.queryCrfObservationTreatmentSchemeByCrfObserveId(crfObserveId);
	}

	@Override
	public void saveCrfTreatmentSchemeOtherDetail(TCrfSchemeOther crfSchemeOther) {
		crfSchemeDao.deleteCrfObservationTreatmentSchemeOptionsByCrfObserveId(crfSchemeOther.getCrfObserveId());
		// 循环保存方案及部位信息
		for (int i = 0; i < crfSchemeOther.getDataList().size(); i++) {
			TCrfSchemeOtherInfo crfSchemeOtherInfo = crfSchemeOther.getDataList().get(i);
			String crfObserveSchemeId = GeneralUtil.generateUniqueID("OSCHE");
			crfSchemeOtherInfo.setCrfObserveSchemeId(crfObserveSchemeId);
			crfSchemeOtherInfo.setCrfObserveId(crfSchemeOther.getCrfObserveId());
			crfSchemeOtherInfo.setIndex(i);
		}
		crfSchemeDao.insertCrfObservationTreatmentSchemeOptionsList(crfSchemeOther.getDataList());
	}
}
