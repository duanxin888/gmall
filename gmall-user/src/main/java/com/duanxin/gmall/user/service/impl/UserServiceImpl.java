package com.duanxin.gmall.user.service.impl;


import com.duanxin.gmall.bean.UmsMember;
import com.duanxin.gmall.bean.UmsMemberReceiveAddress;
import com.duanxin.gmall.service.UserService;
import com.duanxin.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.duanxin.gmall.user.mapper.UserMapper;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

/**
 * User在Service层实现
 * @author duanxin
 * @version 1.0
 * @date 2019/8/11 17:50
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {
        return userMapper.selectAll();
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemeberId(Long id) {
        // UmsMemberReceiveAddress umsMemberReceiveAddress = new UmsMemberReceiveAddress();
        // umsMemberReceiveAddress.setMemberId(id);
        // return umsMemberReceiveAddressMapper.selectByExample(umsMemberReceiveAddress);
        // return umsMemberReceiveAddressMapper.select(umsMemberReceiveAddress);
        Example example = new Example(UmsMemberReceiveAddress.class);
        example.createCriteria().andEqualTo("memberId", id);
        return umsMemberReceiveAddressMapper.selectByExample(example);
    }
}
