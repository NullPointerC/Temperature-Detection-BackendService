package cn.homyit.wxapp.controller;

import cn.homyit.wxapp.service.DataSetService;
import cn.homyit.wxapp.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 */
@RestController
public class DataSetController {
    @Autowired
    private DataSetService dataSetService;

    @GetMapping("/getInfo")
    public Result getInfo() throws IOException {
        return Result.success(dataSetService.getDataSets());
    }
}
