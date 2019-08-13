package com.duanxin.gmall.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 会员信息实体类
 * @author duanxin
 * @date 2019/8/13 8:47
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UmsMember implements Serializable {
    private Long id;

    private Long memberLevelId;

    private String username;

    private String password;

    private String nickname;

    private String phone;

    private Integer status;

    private Date createTime;

    private String icon;

    private Integer gender;

    private Date birthday;

    private String city;

    private String job;

    private String personalizedSignature;

    private Integer sourceType;

    private Integer integration;

    private Integer growth;

    private Integer luckyCount;

    private Integer historyIntegration;
}