package com.duanxin.gmall.user.controller;

import com.duanxin.gmall.bean.UmsMember;
import com.duanxin.gmall.bean.UmsMemberReceiveAddress;
import com.duanxin.gmall.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * User在Controller层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/8/11 17:48
 */
@RestController
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 根据会员id获取所有收货地址
     * @param [id]
     * @date 2019/8/12 15:38
     * @return java.util.List<com.duanxin.gmall.user.bean.UmsMemberReceiveAddress>
     **/
    @GetMapping("/getReceiveAddress/{id}")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(@PathVariable("id") Long id) {
        return userService.getReceiveAddressByMemeberId(id);
    }

    /**
     * 获取所有用户数据
     * @param []
     * @date 2019/8/12 8:13
     * @return List<UmsMember>
     **/
    @GetMapping("/umsMembers")
    @ResponseBody
    public List<UmsMember> getAllUser() {
        List<UmsMember> umsMemberList =  userService.getAllUser();
        return umsMemberList;
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

}
