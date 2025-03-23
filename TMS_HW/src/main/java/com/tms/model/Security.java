package com.tms.model;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Getter
@Scope("prototype")
@Component
public class Security {
    private Long id;
    private String login;
    private String password;
    private Role role;
    private Timestamp created;
    private Timestamp updated;
    private Long userId;

    public Security() {}

    public Security(Long id, String login, String password, Role role, Timestamp created, Timestamp updated, Long userId) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.created = created;
        this.updated = updated;
        this.userId = userId;
    }


    public void setId(Long id) {
        this.id = id; }

    public void setLogin(String login) {
        this.login = login; }

    public void setPassword(String password) {
        this.password = password; }

    public void setRole(Role role) {
        this.role = role; }

    public void setCreated(Timestamp created) {
        this.created = created; }

    public void setUpdated(Timestamp updated) {
        this.updated = updated; }

    public void setUserId(Long userId) {
        this.userId = userId; }

    @Override
    public String toString() {
        return "Security{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", created=" + created +
                ", updated=" + updated +
                ", userId=" + userId +
                '}';
    }
}