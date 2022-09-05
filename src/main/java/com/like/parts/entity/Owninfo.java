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
 * 零部件出入库
 */
@Data
@TableName(value = "owninfo")//数据库中表名为partsinfo依然可以正常写入
public class Owninfo implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*零部件名称*/
    private String dname;

    /*出库/入库*/
    private String type;

    /*数量*/
    private Integer count;

    /*操作人*/
    private String operator;

    /*操作时间*/
    private Date createtime;


}
