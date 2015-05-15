package com.firm.manager.dao.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYSTEM_SEQUENCE_42128A84_F76E_4029_9803_453A487B23F5")
    @SequenceGenerator(name = "SYSTEM_SEQUENCE_42128A84_F76E_4029_9803_453A487B23F5", sequenceName = "SYSTEM_SEQUENCE_42128A84_F76E_4029_9803_453A487B23F5", allocationSize = 1)
    private Long id;

    private Date createTime;

    @Version
    private Date lastModified;

    private String login;

    private String password;

    private String rule;

    @PrePersist
    public void prePersist() {
        createTime = new Date();
        lastModified = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (createTime != null ? !createTime.equals(user.createTime) : user.createTime != null) return false;
        if (lastModified != null ? !lastModified.equals(user.lastModified) : user.lastModified != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return !(rule != null ? !rule.equals(user.rule) : user.rule != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (rule != null ? rule.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", rule='" + rule + '\'' +
                '}';
    }
}
