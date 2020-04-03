package com.jiang.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.jiang.common.Result;
import com.jiang.demo.entity.SysZoningTable;
import com.jiang.demo.mapper.SysZoningTableMapper;
import com.jiang.demo.service.ZoningService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sys/zoning")
public class ZoningController {
    @Autowired
    private SysZoningTableMapper sysZoningTableMapper;
    @Autowired
    private ZoningService zoningService;
    /**
     * @author:  jiangzg
     * @methodsName: findAll
     * @description: 获取行政区划树型表
     * @param:  Map
     * @return: Result
     * @throws:
     */
    @PostMapping("/getTreeTable")
    public Result getTreeTable(@RequestBody Map<String,Object> jsonMap){
        log.info("获取行政区划树型表参数:{}",JSONObject.toJSONString(jsonMap));
        List<SysZoningTable> list = sysZoningTableMapper.selectAll();
        List<SysZoningTable> listTree = zoningService.buildTree(list);
        return Result.success(listTree);
    }

    @PostMapping("/query")
    public Result query(@RequestBody SysZoningTable sysZoningTable){
        log.info("接收到参数{}", JSONObject.toJSONString(sysZoningTable));
        Example example = new Example(SysZoningTable.class);
        example.setOrderByClause("sort asc");
        example.createCriteria().andEqualTo("id",sysZoningTable.getId()).andEqualTo("pid",sysZoningTable.getPid())
        .andLike("path",sysZoningTable.getPath()).andEqualTo("code",sysZoningTable.getCode())
        .andEqualTo("codeName",sysZoningTable.getCodeName()).andEqualTo("codeType",sysZoningTable.getCodeType());
        List<SysZoningTable> list = sysZoningTableMapper.selectByExample(example);
        return Result.success(list);
    }

    @PostMapping("/importZoning")
    public Result uploadPlateWhite(@RequestParam("file") MultipartFile file){
        log.info("我进来了：{}",file.getOriginalFilename());
        return Result.success();
    }
}
