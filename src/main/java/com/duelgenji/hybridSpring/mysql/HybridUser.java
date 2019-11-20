package com.duelgenji.hybridSpring.mysql;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HybridUser extends AbstractPersistable<Long> {

    @Column(nullable = false, unique = true ,length = 100)
    private String userName;

    @Column(nullable = false, columnDefinition="varchar(500) default ''")
    private String remark = "";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
