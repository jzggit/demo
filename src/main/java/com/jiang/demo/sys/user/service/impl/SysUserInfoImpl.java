package com.jiang.demo.sys.user.service.impl;


import com.jiang.demo.sys.user.dao.SysUserInfoMapper;
import com.jiang.demo.sys.user.entity.SysUserInfo;
import com.jiang.demo.sys.user.service.SysUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class SysUserInfoImpl implements SysUserInfoService {
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;
    @Override
    public List<SysUserInfo> findAll() {
        List<SysUserInfo> list = sysUserInfoMapper.findAll();
        log.info("list:{}",list.size());
        return list;
    }
}
