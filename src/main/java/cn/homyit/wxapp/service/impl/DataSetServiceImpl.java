package cn.homyit.wxapp.service.impl;

import cn.homyit.wxapp.dao.DataSetDao;
import cn.homyit.wxapp.pojo.DataSet;
import cn.homyit.wxapp.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 */
@Service
public class DataSetServiceImpl implements DataSetService {

    @Autowired
    private DataSetDao dataSetDao;
    @Override
    public DataSet getDataSets() throws IOException {
        return dataSetDao.getDataSets();
    }
}
