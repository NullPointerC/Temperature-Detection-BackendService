package cn.homyit.wxapp;

import cn.homyit.wxapp.controller.DataSetController;
import cn.homyit.wxapp.dao.DataSetDao;
import cn.homyit.wxapp.pojo.DataSet;
import cn.homyit.wxapp.service.DataSetService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class WxappApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private DataSetDao dataSetDao;
    @Test
    public void test01() throws IOException {
        DataSet dataSets = dataSetDao.getDataSets();
        System.out.println(dataSets);
    }

    @Autowired
    private DataSetService dataSetService;
    @Test
    public void test02() throws IOException {
        DataSet dataSets = dataSetService.getDataSets();
        System.out.println(dataSets);
    }


    @Autowired
    private DataSetController dataSetController;
    @Test
    public void test03() throws IOException {

        System.out.println(dataSetController.getInfo());
    }
}
