package com.jiang.demo;

import com.jiang.demo.entity.SysZoningTable;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Data
public class ZoningDto {
    /**
     * 行政区划id
     */
    @Id
    private Long id;

    /**
     * 父级行政区划id
     */
    private Long pid;

    /**
     * 行政区划路劲
     */
    private String path;

    /**
     * 行政区划代码
     */
    private String code;

    /**
     * 行政区划名称
     */
    @Column(name = "code_name")
    private String codeName;

    /**
     * 行政区划类型 1-国家 2-地市 3-区县 4-乡镇 5-街道 6-村寨
     */
    @Column(name = "code_type")
    private Integer codeType;

    /**
     * 是否叶子节点 1-是 2-否
     */
    @Column(name = "is_leaf")
    private Integer isLeaf;

    /**
     * 是否展开 1-是 2-否
     */
    @Column(name = "is_expand")
    private Integer isExpand;

    /**
     * 排序
     */
    private Integer sort;

    private List<SysZoningTable> children;
}
