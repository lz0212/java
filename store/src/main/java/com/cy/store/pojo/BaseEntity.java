package com.cy.store.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 作为实体类的基类，实现Serializable接口  格式化快捷键是:Ctrl+Alt+L
 */
public class BaseEntity implements Serializable {

    public String createdUser;
    public Date createdTime;
    public String modifiedUser;
    public Date modifiedTime;

    public BaseEntity() {
    }

    public BaseEntity(String createdUser, Date createdTime, String modifiedUser, Date modifiedTime) {
        this.createdUser = createdUser;
        this.createdTime = createdTime;
        this.modifiedUser = modifiedUser;
        this.modifiedTime = modifiedTime;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BaseEntity that = (BaseEntity) o;

        if (createdUser != null ? !createdUser.equals(that.createdUser) : that.createdUser != null) {
            return false;
        }
        if (createdTime != null ? !createdTime.equals(that.createdTime) : that.createdTime != null) {
            return false;
        }
        if (modifiedUser != null ? !modifiedUser.equals(that.modifiedUser) : that.modifiedUser != null) {
            return false;
        }
        return modifiedTime != null ? modifiedTime.equals(that.modifiedTime) : that.modifiedTime == null;
    }

    @Override
    public int hashCode() {
        int result = createdUser != null ? createdUser.hashCode() : 0;
        result = 31 * result + (createdTime != null ? createdTime.hashCode() : 0);
        result = 31 * result + (modifiedUser != null ? modifiedUser.hashCode() : 0);
        result = 31 * result + (modifiedTime != null ? modifiedTime.hashCode() : 0);
        return result;
    }
}
