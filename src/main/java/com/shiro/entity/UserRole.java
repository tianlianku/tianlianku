package com.shiro.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user_role")
public class UserRole {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "user_id",fill = FieldFill.INSERT)
    private Integer userid;

    @TableField(value = "role_id",fill = FieldFill.INSERT_UPDATE)
    private Integer roleid;

}
