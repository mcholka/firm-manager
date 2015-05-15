package com.firm.manager.dao.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Worker implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SYSTEM_SEQUENCE_4F9B6F1D_74B2_427A_A9B5_6B3283E79C94")
    @SequenceGenerator(name = "SYSTEM_SEQUENCE_4F9B6F1D_74B2_427A_A9B5_6B3283E79C94", sequenceName = "SYSTEM_SEQUENCE_4F9B6F1D_74B2_427A_A9B5_6B3283E79C94", allocationSize = 1)
    private Long id;
    @NotNull(message = "Imie i nazwisko sa wymagane")
    private String personalData;
    @NotNull(message = "Adres jest wymagany")
    private String address;
    private Date createTime;
    @Version
    private Date lastModified;
    private Date startWorkDate;
    private Date endWorkDate;
    private BigDecimal pay;
    private boolean stillWork;
    @NotNull(message = "Stanowisko jest wymagane")
    @Enumerated(EnumType.STRING)
    private Position position;
    private String phone;
    private String email;
    private boolean deleted;

    @PrePersist
    public void prePersist() {
        createTime = new Date();
        lastModified = new Date();
        deleted = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalData() {
        return personalData;
    }

    public void setPersonalData(String personalData) {
        this.personalData = personalData;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public Date getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(Date startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public Date getEndWorkDate() {
        return endWorkDate;
    }

    public void setEndWorkDate(Date endWorkDate) {
        this.endWorkDate = endWorkDate;
    }

    public BigDecimal getPay() {
        return pay;
    }

    public void setPay(BigDecimal pay) {
        this.pay = pay;
    }

    public boolean isStillWork() {
        return stillWork;
    }

    public void setStillWork(boolean stillWork) {
        this.stillWork = stillWork;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Worker worker = (Worker) o;

        if (stillWork != worker.stillWork) return false;
        if (deleted != worker.deleted) return false;
        if (id != null ? !id.equals(worker.id) : worker.id != null) return false;
        if (personalData != null ? !personalData.equals(worker.personalData) : worker.personalData != null)
            return false;
        if (address != null ? !address.equals(worker.address) : worker.address != null) return false;
        if (createTime != null ? !createTime.equals(worker.createTime) : worker.createTime != null) return false;
        if (lastModified != null ? !lastModified.equals(worker.lastModified) : worker.lastModified != null)
            return false;
        if (startWorkDate != null ? !startWorkDate.equals(worker.startWorkDate) : worker.startWorkDate != null)
            return false;
        if (endWorkDate != null ? !endWorkDate.equals(worker.endWorkDate) : worker.endWorkDate != null) return false;
        if (pay != null ? !pay.equals(worker.pay) : worker.pay != null) return false;
        if (position != worker.position) return false;
        if (phone != null ? !phone.equals(worker.phone) : worker.phone != null) return false;
        return !(email != null ? !email.equals(worker.email) : worker.email != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personalData != null ? personalData.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (lastModified != null ? lastModified.hashCode() : 0);
        result = 31 * result + (startWorkDate != null ? startWorkDate.hashCode() : 0);
        result = 31 * result + (endWorkDate != null ? endWorkDate.hashCode() : 0);
        result = 31 * result + (pay != null ? pay.hashCode() : 0);
        result = 31 * result + (stillWork ? 1 : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (deleted ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", personalData='" + personalData + '\'' +
                ", address='" + address + '\'' +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", startWorkDate=" + startWorkDate +
                ", endWorkDate=" + endWorkDate +
                ", pay=" + pay +
                ", stillWork=" + stillWork +
                ", position=" + position +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}
