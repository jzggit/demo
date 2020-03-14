package com.jiang.demo.sys.user.dao;

import com.jiang.common.CommonRepository;
import com.jiang.demo.sys.user.entity.SysUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface SysUserInfoMapper extends CommonRepository<SysUserInfo> {
    List<SysUserInfo> findAll();
}
