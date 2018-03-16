package com.esuizhen.bigdata.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by fqc on 16/11/9.
 */
@Entity(name = "author")
//@Audited
//@AuditTable(value = "author_aud",schema = "user_db_audit",catalog = "user_db_audit")
public class Author implements Serializable {//extends DefaultRevisionEntity
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    //@RevisionNumber
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private Long authorId;
    //@Column(name= "firstName")
    private String firstName;
    private String lastName;
    private String title;

    /**
     * @CreatedDate
     * @CreatedBy
     * @LastModifiedDate
     * @LastModifiedBy
     */
    private String userId;
    private Date created_time;
    private Date updated_time = new Date();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public Date getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(Date updated_time) {
        this.updated_time = updated_time;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
