package com.jiang.demo.sys.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jiang.common.BaseException;
import com.jiang.common.ErrorType;
import com.jiang.common.Result;
import com.jiang.demo.sys.user.dao.SysUserInfoMapper;
import com.jiang.demo.sys.user.entity.SysUserInfo;
import com.jiang.demo.sys.user.service.SysUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserInfoController {
    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @GetMapping("/findAll")
    public Result findAll(){
        List<SysUserInfo> list = sysUserInfoService.findAll();
        log.info("取到数据:{}",list.get(0).getSysUserName());
        return Result.success(list);
    }

    @PostMapping("/addUser")
    public Result addUser(@RequestBody SysUserInfo sysUserInfo) {
        log.info("新增用户:{}",JSONObject.toJSONString(sysUserInfo));
        if(null == sysUserInfo){
            return Result.fail("用户信息不能为空!");
        }
        try{
            sysUserInfoMapper.insert(sysUserInfo);
        }catch(Exception e){
            log.error("新增用户异常",e);
            return Result.fail("新增用户失败!");
        }
        return Result.success("新增用户成功！");
    }
}
