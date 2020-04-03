package com.jiang.demo.sys.user.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.common.BaseException;
import com.jiang.common.ErrorType;
import com.jiang.common.Result;
import com.jiang.demo.sys.user.dao.SysUserInfoMapper;
import com.jiang.demo.sys.user.entity.SysUserInfo;
import com.jiang.demo.sys.user.service.SysUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sys/user")
public class SysUserInfoController {
    @Autowired
    private SysUserInfoService sysUserInfoService;
    @Autowired
    private SysUserInfoMapper sysUserInfoMapper;

    @PostMapping("/findAll")
    public Result findAll(@RequestBody Map<String,Object> jsonMap){
        log.info("参数:{}",JSONObject.toJSONString(jsonMap));
        Integer pageNum = jsonMap.get("page")==null?0: (Integer) jsonMap.get("page");
        Integer pageSize = jsonMap.get("limit")==null?0: (Integer) jsonMap.get("limit");
        String sysUserName = jsonMap.get("sysUserName")==null?null: (String) jsonMap.get("sysUserName");
        Integer sysUserSex = jsonMap.get("sysUserSex")==null?null: (Integer) jsonMap.get("sysUserSex");
        if(!StringUtils.isEmpty(sysUserName)){
            sysUserName = sysUserName+"%";
        }
        Example example = new Example(SysUserInfo.class);
        example.createCriteria().andLike("sysUserName",sysUserName).andEqualTo("sysUserSex",sysUserSex);
        PageHelper.startPage(pageNum,pageSize);
        List<SysUserInfo> list = sysUserInfoService.findAll(example);
        PageInfo<SysUserInfo> pageInfo = new PageInfo<SysUserInfo>(list);
        log.info("取到数据:{}",JSONObject.toJSONString(pageInfo));
        return Result.success(pageInfo);
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

    @PostMapping("/login")
    public Result login(@RequestBody SysUserInfo sysUserInfo){
        log.info("登陆参数:{}",JSONObject.toJSONString(sysUserInfo));
        try {
            if (null == sysUserInfo) {
                return Result.fail("登陆失败，接收参数为空");
            }
            Example example = new Example(SysUserInfo.class);
            example.createCriteria().andEqualTo("sysUserName", sysUserInfo.getSysUserName()).
                    andEqualTo("sysUserPassword", sysUserInfo.getSysUserPassword());
            SysUserInfo sysUserInfo1 = sysUserInfoMapper.selectOneByExample(example);
            if (null == sysUserInfo1) {
                return Result.fail("用户名或密码错误");
            }
            Map<String,String> map = new HashMap<>();
            map.put("token",sysUserInfo.getSysUserName());
            map.put("msg","登陆成功");
            return Result.success(map);
        }catch (Exception e){
            log.error("登陆出错：",e);
            return Result.fail("登陆出错");
        }
    }

    //根据token获取用户信息
    @GetMapping("/getInfo")
    public Result getInfo(@RequestParam String token){
        log.info("token:{}",token);
        if(StringUtils.isEmpty(token)){
            return Result.fail("未获取到身份令牌");
        }
        Example example = new Example(SysUserInfo.class);
        example.createCriteria().andEqualTo("sysUserName", token);
        SysUserInfo sysUserInfo = sysUserInfoMapper.selectOneByExample(example);
        if(null == sysUserInfo){
            return Result.fail("用户数据不存在");
        }
        return Result.success(sysUserInfo);
    }
}
