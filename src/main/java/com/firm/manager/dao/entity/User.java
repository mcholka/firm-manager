package com.firm.manager.dao.entity;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYSTEM_SEQUENCE_DDA5AD50_FD02_41D5_951B_C4502F85BF2E")
    @SequenceGenerator(name = "SYSTEM_SEQUENCE_DDA5AD50_FD02_41D5_951B_C4502F85BF2E", sequenceName = "SYSTEM_SEQUENCE_DDA5AD50_FD02_41D5_951B_C4502F85BF2E", allocationSize = 1)
    private Long id;

    private String login;

    private String password;

    private String rule;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rule='" + rule + '\'' +
                '}';
    }
}
