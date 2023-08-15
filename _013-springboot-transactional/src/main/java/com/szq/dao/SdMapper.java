package com.szq.dao;

import com.szq.model.Sd;

public interface SdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sd row);

    int insertSelective(Sd row);

    Sd selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sd row);

    int updateByPrimaryKey(Sd row);
}