package cn.homyit.wxapp.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 * 对数据的进一步封装,包括含有的指标名称,指标的检测范围,以及对每个时间戳SimpleData的封装
 */
@Data
public class DataSet {

    /*对所有指标的封装*/
    private List<IndexRange> indexes;

    /*对每一个时间戳数据的封装*/
    private List<SimpleData> datas;
}
