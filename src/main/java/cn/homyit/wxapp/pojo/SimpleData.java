package cn.homyit.wxapp.pojo;

import lombok.Data;

/**
 * @author Ziqiang CAO
 * @email 1213409187@qq.com
 * 普通行对象,代表每一行的数据,包括时间戳,温度,ph值
 */
@Data
public class SimpleData {
    /*时间戳*/
    private String timeStamp;

    /*温度值*/
    private String temperature;

    /*ph值*/
    private String phValue;
}
