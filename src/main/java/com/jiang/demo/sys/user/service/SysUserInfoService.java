package com.jiang.demo.sys.user.service;


import com.jiang.demo.sys.user.entity.SysUserInfo;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Lenovo book
 */
@Service
public interface SysUserInfoService {
    List<SysUserInfo> findAll(Example example);
}
