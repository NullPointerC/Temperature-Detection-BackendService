package cn.homyit.wxapp.dao;

import cn.homyit.wxapp.pojo.DataSet;

import java.io.IOException;

/**
 * 获取数据集
 */
public interface DataSetDao {
    DataSet getDataSets() throws IOException;
}
