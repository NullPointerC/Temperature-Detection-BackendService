package cn.homyit.wxapp.service;

import cn.homyit.wxapp.pojo.DataSet;

import java.io.IOException;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 */
public interface DataSetService {
    DataSet getDataSets() throws IOException;
}
