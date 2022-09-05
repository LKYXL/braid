package com.like.parts.entity;
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
 * @author like
 * @create 2022-06-06-13:48
 */


/**
 * 退货给供应商
 */
@Data
@TableName(value = "returnsupplier")//数据库中表名为partsinfo依然可以正常写入
public class Returnsupplier implements Serializable {
    /*主键*/
    @TableField(value = "id")
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /*退货零部件名称*/
    private String dname;

    /*数量*/
    private Integer dcount;

    /*供应商名称*/
    private  String sname;

    /*进货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;

    /*退货原因*/
    private String reason;

    /*退货时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /*进货时间转换成年月日*/
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }
    /*退货时间转换成年月日*/
    public String getCreatetimeStr(){
        return DateUtil.dateConvert(createtime);
    }


}
