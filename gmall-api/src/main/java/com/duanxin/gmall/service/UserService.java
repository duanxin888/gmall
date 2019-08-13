package com.duanxin.gmall.service;


import com.duanxin.gmall.bean.UmsMember;
import com.duanxin.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

/**
 * User在Service层接口
 * @author duanxin
 * @version 1.0
 * @date 2019/8/11 17:49
 */
public interface UserService {
    /**
     * 获取用户数据
     * @param []
     * @date 2019/8/12 8:13
     * @return List<UmsMember>
     **/
    List<UmsMember> getAllUser();


    /**
     * 根据会员id获取收货地址
     * @param [id]
     * @date 2019/8/12 15:29
     * @return java.util.List<com.duanxin.gmall.user.bean.UmsMemberReceiveAddress>
     **/
    List<UmsMemberReceiveAddress> getReceiveAddressByMemeberId(Long id);
}
