package com.jiang.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface CommonRepository <T> extends Mapper<T>, MySqlMapper<T> {
}
