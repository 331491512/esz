package com.esuizhen.bigdata.service.ehr.impl;

import com.alibaba.fastjson.JSON;
import com.esuizhen.bigdata.common.followup.ExcelTemplate;
import com.esuizhen.bigdata.domain.ods.TVarSearch;
import com.esuizhen.bigdata.repository.ods.SearchInfoRepository;
import com.esuizhen.bigdata.service.ehr.AsyncSearchService;
import com.westangel.common.util.LogUtil;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Nidan on 2016年12月22 上午 11:04
 */
@Service
public class AsyncSearchServiceImpl implements AsyncSearchService {

    private TVarSearch search;

    private SearchInfoRepository searchInfoRepository;

    public TVarSearch getSearch() {
        return search;
    }

    public void setSearch(TVarSearch search) {
        this.search = search;
    }

    public SearchInfoRepository getSearchInfoRepository() {
        return searchInfoRepository;
    }

    public void setSearchInfoRepository(SearchInfoRepository searchInfoRepository) {
        this.searchInfoRepository = searchInfoRepository;
    }

    @Override
    public void run() {
        try {
            String sqlContent= ExcelTemplate.EXPORT_SQL_CONTENT.toString();
            String req=search.getReq();
            if(req!=null){
                Map<String,Object> searchMap= JSON.parseObject(req);
                searchMap.put("mergeFlag",1);
                Object userId=searchMap.get("userId");
                if (userId!=null){
                    searchMap.remove("userId");
                }
                if (searchMap.size()>0){
                    String whereCondition=ExcelTemplate.getWhereCondition(searchMap);
                    sqlContent+=whereCondition;
                }
            }
            search.setSqlContent(sqlContent);
            searchInfoRepository.save(search);
        } catch (Exception e) {
            LogUtil.logError.error(e.getMessage(),e);
        }
    }
}
