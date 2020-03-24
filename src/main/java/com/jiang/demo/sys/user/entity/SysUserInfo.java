package com.jiang.demo.sys.user.entity;

import lombok.Data;

import javax.persistence.Id;
import java.util.Date;

@Data
public class SysUserInfo {
    @Id
    private Long sysUserId;
    private String sysUserName;
    private Integer sysUserAge;
    private Integer sysUserSex;
    private String sysUserPhone;
    private String sysUserIdCard;
    private Integer sysUserCardType;
    private String sysUserEmail;
    private String sysUserQq;
    private String sysUserWx;
    private Integer sysUserLock;
    private Date sysLockDate;
    private Integer sysUserExpired;
    private Date sysExpiredDate;
    private Integer sysUserType;
    private Integer sysUserSort;
}
