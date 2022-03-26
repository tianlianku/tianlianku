package com.shiro.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("t_jigoods")
public class JiGoods implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "order_id",fill = FieldFill.INSERT)
    private String orderid;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String username;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String userphone;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String address;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String daoname;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String daophone;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String daoaddress;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Integer payprice;

    @TableField(fill = FieldFill.INSERT)
    private Date orderdate;

}
