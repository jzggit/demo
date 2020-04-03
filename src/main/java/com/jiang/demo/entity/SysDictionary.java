package com.jiang.demo.entity;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "sys_dictionary")
public class SysDictionary implements Serializable {
    @Id
    private Long id;

    /**
     * 字典类型
     */
    @Column(name = "dict_type")
    private String dictType;

    /**
     * 字典类型名称
     */
    @Column(name = "dict_type_name")
    private String dictTypeName;

    /**
     * 字典键
     */
    @Column(name = "dict_key")
    private String dictKey;

    /**
     * 字典值
     */
    @Column(name = "dict_value")
    private String dictValue;

    /**
     * 是否有效 1-启用 2-禁用
     */
    @Column(name = "is_vail")
    private Integer isVail;

    /**
     * 排序
     */
    private Integer sort;

    private static final long serialVersionUID = 1L;

    public SysDictionary(Long id, String dictType, String dictTypeName, String dictKey, String dictValue, Integer isVail, Integer sort) {
        this.id = id;
        this.dictType = dictType;
        this.dictTypeName = dictTypeName;
        this.dictKey = dictKey;
        this.dictValue = dictValue;
        this.isVail = isVail;
        this.sort = sort;
    }

    public SysDictionary() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取字典类型
     *
     * @return dict_type - 字典类型
     */
    public String getDictType() {
        return dictType;
    }

    /**
     * 设置字典类型
     *
     * @param dictType 字典类型
     */
    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim();
    }

    /**
     * 获取字典类型名称
     *
     * @return dict_type_name - 字典类型名称
     */
    public String getDictTypeName() {
        return dictTypeName;
    }

    /**
     * 设置字典类型名称
     *
     * @param dictTypeName 字典类型名称
     */
    public void setDictTypeName(String dictTypeName) {
        this.dictTypeName = dictTypeName == null ? null : dictTypeName.trim();
    }

    /**
     * 获取字典键
     *
     * @return dict_key - 字典键
     */
    public String getDictKey() {
        return dictKey;
    }

    /**
     * 设置字典键
     *
     * @param dictKey 字典键
     */
    public void setDictKey(String dictKey) {
        this.dictKey = dictKey == null ? null : dictKey.trim();
    }

    /**
     * 获取字典值
     *
     * @return dict_value - 字典值
     */
    public String getDictValue() {
        return dictValue;
    }

    /**
     * 设置字典值
     *
     * @param dictValue 字典值
     */
    public void setDictValue(String dictValue) {
        this.dictValue = dictValue == null ? null : dictValue.trim();
    }

    /**
     * 获取是否有效 1-启用 2-禁用
     *
     * @return is_vail - 是否有效 1-启用 2-禁用
     */
    public Integer getIsVail() {
        return isVail;
    }

    /**
     * 设置是否有效 1-启用 2-禁用
     *
     * @param isVail 是否有效 1-启用 2-禁用
     */
    public void setIsVail(Integer isVail) {
        this.isVail = isVail;
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