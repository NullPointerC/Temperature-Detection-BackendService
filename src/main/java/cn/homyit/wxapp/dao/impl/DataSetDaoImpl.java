package cn.homyit.wxapp.dao.impl;

import cn.homyit.wxapp.dao.DataSetDao;
import cn.homyit.wxapp.pojo.DataSet;
import cn.homyit.wxapp.pojo.IndexRange;
import cn.homyit.wxapp.pojo.SimpleData;
import cn.homyit.wxapp.utils.ExcelUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 * 从文件中读取数据并且封装成为数据集
 */
@Repository
@Slf4j
public class DataSetDaoImpl implements DataSetDao {
    private static String path = "data.xlsx";
    @Override
    public DataSet getDataSets() throws IOException {
        //File file = ResourceUtils.getFile(path);
        ClassPathResource classPathResource = new ClassPathResource(path);
        InputStream inputStream = classPathResource.getInputStream();
        File somethingFile = File.createTempFile("test", ".xlsx");
        FileUtils.copyInputStreamToFile(inputStream,somethingFile);
        IOUtils.closeQuietly(inputStream);
        FileInputStream fis = new FileInputStream(somethingFile);
        //1. 获取工作簿
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        //2. 获取工作表
        XSSFSheet sheet = workbook.getSheetAt(0);
        //3.获取行
        int lastRowNum = sheet.getLastRowNum();
        //创建数据集对象以及指标列表和单行数据列表
        DataSet dataSet = new DataSet();
        List<IndexRange> indexes = new LinkedList();
        List<SimpleData> datas = new LinkedList<>();
        dataSet.setIndexes(indexes);
        dataSet.setDatas(datas);
        for(int i = 0;i<lastRowNum;i++) {
            Row row = sheet.getRow(i);
            //读取监控的指标的名称
            if(i==1) {
                int lastCellNum = row.getLastCellNum();
                for(int j = 0;j<lastCellNum;j++) {
                    IndexRange indexRange = new IndexRange();
                    Cell cell = row.getCell(j);
                    String value = ExcelUtils.getCellValueByCell(cell);
                    if(value == null ||value.equals("")) {
                        continue;
                    }else{
                        indexRange.setIndexName(value);
                        indexes.add(indexRange);
                    }
                }
            }
            //读取监控的指标的最大/最小值
            if(i==2) {
                int lastCellNum = row.getLastCellNum();
                for(int j = 0;j<lastCellNum;j++) {
                    Cell cell = row.getCell(j);
                    String value = ExcelUtils.getCellValueByCell(cell);
                    if(value == null ||value.equals("")) {
                        continue;
                    }else{
                        indexes.get(j-1).setRange(value);
                    }
                }
            }
            if(i>2) {
                int lastCellNum = row.getLastCellNum();
                SimpleData simpleData = new SimpleData();
                for(int j = 0;j<lastCellNum;j++) {
                    if (j == 0) {
                        Cell cell = row.getCell(j);
                        String value = ExcelUtils.getCellValueByCell(cell);
                        if(value == null ||value.equals("")) {
                            continue;
                        }else{
                            simpleData.setTimeStamp(value);
                        }
                    }
                    if (j == 1) {
                        Cell cell = row.getCell(j);
                        String value = ExcelUtils.getCellValueByCell(cell);
                        if(value == null ||value.equals("")) {
                            continue;
                        }else{
                            simpleData.setTemperature(value);
                        }
                    }
                    if (j == 2) {
                        Cell cell = row.getCell(j);
                        String value = ExcelUtils.getCellValueByCell(cell);
                        if(value == null ||value.equals("")) {
                            continue;
                        }else{
                            simpleData.setPhValue(value);
                        }
                    }
                }
                datas.add(simpleData);
            }
        }
        return dataSet;
    }
}
