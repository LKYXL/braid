package com.like.parts.entity;

/**
 * @author like
 * @create 2022-06-06-13:48
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.like.parts.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 零部件信息
 */
@Data
@TableName(value = "partsinfo")//数据库中表名为partsinfo依然可以正常写入
public class Partsinfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*零部件名称*/
    private String name;
    /*供应商名称*/
    private String supplier;
    /*生产时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producetime;
    /*寿命（月）*/
    private String warranty;
    /*零部件编码*/
    private String number;
    /*价格*/
    private Float price;
    /*库存*/
    private Integer stock;
    /*生产时间转换成年月日*/
    //private String producetimeStr;
    public String getProducetimeStr(){
        return DateUtil.dateConvert(producetime);
    }


}
