package com.like.parts.entity;

/**
 * @author like
 * @create 2022-06-06-13:48
 */

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 问题零部件
 */
@Data
@TableName(value = "problem")//数据库中表名为partsinfo依然可以正常写入
public class Problem implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*零部件名称*/
    private String dname;

    /*问题零部件数量*/
    private Integer dcount;

    /*零部件单价*/
    private Float dprice;

    /*问题原因*/
    private String reason;

    /*操作时间*/
    private Date createtime;


}
