package com.hw2.cs603.model;

import javax.persistence.*;

/**
 * Java pojo class, initialize the table and database.
 */
@Entity
@Table(name = "posts_content")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "body")
    private String body;

    public Posts(String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public Posts() {

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
