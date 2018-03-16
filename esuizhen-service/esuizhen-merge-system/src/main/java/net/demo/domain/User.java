package net.demo.domain;

import javax.persistence.*;

/**
 * Created by fqc on 11/29/16.
 */
@Entity
@Table(name = "user", schema = "test_db")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "_name")
    private String name;

    public User() {

    }

    public User(String name) {
        this.name = name;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
