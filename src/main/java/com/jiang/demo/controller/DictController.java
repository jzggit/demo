package com.jiang.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiang.common.Result;
import com.jiang.demo.entity.SysDictionary;
import com.jiang.demo.mapper.SysDictionaryMapper;
import com.jiang.demo.sys.user.entity.SysUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/sys/dict")
public class DictController {
    @Autowired
    private SysDictionaryMapper sysDictionaryMapper;

    /**
     * @author:  jiangzg
     * @methodsName: getDictByType
     * @description: 根据字典类型获取字典数据
     * @param:  dictType
     * @return: Result
     * @throws:
     */
    @GetMapping("/getDictByType")
    public Result getDictByType(@RequestParam String dictType){
        log.info("字典类型参数：{}",dictType);
        Example example = new Example(SysDictionary.class);
        example.setOrderByClause("sort asc");
        example.createCriteria().andEqualTo("dictType",dictType);
        List<SysDictionary> list = sysDictionaryMapper.selectByExample(example);
        return Result.success(list);
    }
    /**
     * @author:  jiangzg
     * @methodsName: getDictList
     * @description: 获取字典列表
     * @param:  Map
     * @return: Result
     * @throws:
     */
    @PostMapping("/getDictList")
    public Result getDictList(@RequestBody Map<String,Object> jsonMap){
        log.info("字典列表参数:{}", JSONObject.toJSONString(jsonMap));
        Integer pageNum = jsonMap.get("page")==null?0: (Integer) jsonMap.get("page");
        Integer pageSize = jsonMap.get("limit")==null?0: (Integer) jsonMap.get("limit");
        SysDictionary sysDictionary = JSONObject.parseObject(JSONObject.toJSONString(jsonMap),SysDictionary.class);
        Example example = new Example(SysDictionary.class);
        example.setOrderByClause("dict_type asc ,sort asc");
        example.createCriteria().andEqualTo("dictType",sysDictionary.getDictType()).
                andEqualTo("dictKey",sysDictionary.getDictKey()).andEqualTo("dictValue",sysDictionary.getDictValue()).
                andEqualTo("isVail",sysDictionary.getIsVail());
        PageHelper.startPage(pageNum,pageSize);
        List<SysDictionary> list = sysDictionaryMapper.selectByExample(example);
        PageInfo<SysDictionary> pageInfo = new PageInfo<SysDictionary>(list);
        return Result.success(pageInfo);
    }
    /**
     * @author:  jiangzg
     * @methodsName: getDictList
     * @description: 保存字典数据
     * @param:  SysDictionary
     * @return: Result
     * @throws:
     */
    @PostMapping("/saveDict")
    public Result saveDict(@RequestBody SysDictionary SysDictionary){
        log.info("自带你保存参数:{}",JSONObject.toJSONString(SysDictionary));
        try {
            sysDictionaryMapper.insert(SysDictionary);
            return Result.success("保存成功！");
        }catch (Exception e){
            return Result.fail("保存失败！");
        }
    }
}
