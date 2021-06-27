package cn.homyit.wxapp.pojo;

import lombok.Data;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 * 对每一项指标值的封装
 */
@Data
public class IndexRange {
    /*指标名称*/
    private String indexName;

    /*指标范围*/
    private String range;
}
