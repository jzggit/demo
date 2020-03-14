package com.jiang.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_zoning_table")
public class SysZoningTable implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public SysZoningTable(Long id, Long pid, String path, String code, String codeName, Integer codeType, Integer isLeaf, Integer isExpand, Integer sort) {
        this.id = id;
        this.pid = pid;
        this.path = path;
        this.code = code;
        this.codeName = codeName;
        this.codeType = codeType;
        this.isLeaf = isLeaf;
        this.isExpand = isExpand;
        this.sort = sort;
    }

    public SysZoningTable() {
        super();
    }

    /**
     * 获取行政区划id
     *
     * @return id - 行政区划id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置行政区划id
     *
     * @param id 行政区划id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取父级行政区划id
     *
     * @return pid - 父级行政区划id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级行政区划id
     *
     * @param pid 父级行政区划id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取行政区划路劲
     *
     * @return path - 行政区划路劲
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置行政区划路劲
     *
     * @param path 行政区划路劲
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 获取行政区划代码
     *
     * @return code - 行政区划代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置行政区划代码
     *
     * @param code 行政区划代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取行政区划名称
     *
     * @return code_name - 行政区划名称
     */
    public String getCodeName() {
        return codeName;
    }

    /**
     * 设置行政区划名称
     *
     * @param codeName 行政区划名称
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName == null ? null : codeName.trim();
    }

    /**
     * 获取行政区划类型 1-国家 2-地市 3-区县 4-乡镇 5-街道 6-村寨
     *
     * @return code_type - 行政区划类型 1-国家 2-地市 3-区县 4-乡镇 5-街道 6-村寨
     */
    public Integer getCodeType() {
        return codeType;
    }

    /**
     * 设置行政区划类型 1-国家 2-地市 3-区县 4-乡镇 5-街道 6-村寨
     *
     * @param codeType 行政区划类型 1-国家 2-地市 3-区县 4-乡镇 5-街道 6-村寨
     */
    public void setCodeType(Integer codeType) {
        this.codeType = codeType;
    }

    /**
     * 获取是否叶子节点 1-是 2-否
     *
     * @return is_leaf - 是否叶子节点 1-是 2-否
     */
    public Integer getIsLeaf() {
        return isLeaf;
    }

    /**
     * 设置是否叶子节点 1-是 2-否
     *
     * @param isLeaf 是否叶子节点 1-是 2-否
     */
    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    /**
     * 获取是否展开 1-是 2-否
     *
     * @return is_expand - 是否展开 1-是 2-否
     */
    public Integer getIsExpand() {
        return isExpand;
    }

    /**
     * 设置是否展开 1-是 2-否
     *
     * @param isExpand 是否展开 1-是 2-否
     */
    public void setIsExpand(Integer isExpand) {
        this.isExpand = isExpand;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}