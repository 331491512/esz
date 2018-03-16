package com.esuizhen.server.sync.dao.server;

import java.util.LinkedHashMap;

/**
 * Created by Nidan on 2017年03月21 下午 11:40
 */
public interface UuidRelationshipDao {

    public String getUuidFinalBypatientUuid(LinkedHashMap<String,Object> map);
}
