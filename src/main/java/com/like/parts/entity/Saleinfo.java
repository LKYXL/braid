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
 * 销售记录
 */
@Data
@TableName(value = "saleinfo")//数据库中表名为partsinfo依然可以正常写入
public class Saleinfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*零部件名称*/
    private String dname;

    /*零部件编号*/
    private String dnumber;

    /*数量*/
    private Integer count;

    /*金额*/
    private Float total;

    /*操作人*/
    private String operator;

    /*操作时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;
    /*生产时间转换成年月日*/

    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }


}
