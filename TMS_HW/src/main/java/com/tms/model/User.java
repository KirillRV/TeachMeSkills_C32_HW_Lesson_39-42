package com.tms.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Scope("prototype")
@Component
public class User {
    @Setter
    @Getter
    private Long id;
    @Getter
    @Setter
    private String firstname;
    @Getter
    @Setter
    private String secondName;
    @Getter
    @Setter
    private Integer age;
    @Setter
    @Getter
    private String email;
    @Setter
    @Getter
    private String sex;
    @Getter
    @Setter
    private String telephoneNumber;
    @Setter
    @Getter
    private Timestamp created;
    @Setter
    @Getter
    private Timestamp updated;
    private Boolean isDeleted;
    @Setter
    @Getter
    private Security securityInfo;

    public User() {}

    public User(Long id, String firstname, String secondName, Integer age, String email, String sex, String telephoneNumber, Timestamp created, Timestamp updated, Boolean isDeleted, Security securityInfo) {
        this.id = id;
        this.firstname = firstname;
        this.secondName = secondName;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.telephoneNumber = telephoneNumber;
        this.created = created;
        this.updated = updated;
        this.isDeleted = isDeleted;
        this.securityInfo = securityInfo;
    }


    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sex='" + sex + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", isDeleted=" + isDeleted +
                ", securityInfo=" + securityInfo +
                '}';
    }
}