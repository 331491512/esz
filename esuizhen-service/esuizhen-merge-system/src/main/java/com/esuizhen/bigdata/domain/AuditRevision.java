package com.esuizhen.bigdata.domain;

import com.esuizhen.bigdata.common.ConstantsUtils;
import com.esuizhen.bigdata.common.annotation.MergeDataUtils;
//import org.hibernate.envers.RevisionListener;
//import org.hibernate.envers.RevisionNumber;
//import org.hibernate.envers.RevisionTimestamp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 审计信息实体 20161223 和审计相关的暂停使用，原因是设计上的变动，而非不好
 */
@Entity
//@RevisionEntity() //如果没有设置，就是自动的REVINFO生成
//@RevisionEntity(AuditRevisionListener.class) //如果没有设置，就是自动的REVINFO生成
//@Table(name = "revision_info", schema = "user_db_audit", catalog = "user_db_audit")
public class AuditRevision {
    @Id
    @GeneratedValue
    //@RevisionNumber
    @Column(name = "revision_id")
    private long id;

    //@RevisionTimestamp
    @Column(name = "revision_timestamp")
    private Date timestamp;

    private String username;

    /**
     * 操作标记 merge
     */
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

////@Entity
////@RevisionEntity(AuditRevisionListener.class)
// class AuditEntity extends DefaultRevisionEntity {
//
//    private String username;
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//}

/*
class AuditRevisionListener implements RevisionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuditRevisionListener.class);

    @Override
    public void newRevision(Object revisionEntity) {
        final AuditRevision entity = (AuditRevision) revisionEntity;
        // normally you would set here the name of the current user
        entity.setUsername("冯琪超");
        //todo
        String annotation = "";
        // 带有merge标记的方法操作
        String className = ConstantsUtils.pkgController + "AuthorController";
        List list = null;
        try {
            Map classInfo = MergeDataUtils.getClassInfo(className);
            list = (List) classInfo.get("operationType");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.error("{} class not found", className);
        }

        list.forEach(o -> entity.setOperation(o.toString()));

    }
}*/
