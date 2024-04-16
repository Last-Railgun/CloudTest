package com.test.cloud.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-16
 */
@Getter
@Setter
@ToString
@TableName("t_account")
public class Account extends Model<Account> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 总额度
     */
    @TableField("total")
    private Long total;

    /**
     * 已用账户余额
     */
    @TableField("used")
    private Long used;

    /**
     * 剩余可用额度
     */
    @TableField("residue")
    private Long residue;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
