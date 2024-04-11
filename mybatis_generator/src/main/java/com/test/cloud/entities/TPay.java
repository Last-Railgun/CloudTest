package com.test.cloud.entities;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 支付交易表
 * </p>
 *
 * @author LastRailgun
 * @since 2024-04-11
 */
@Getter
@Setter
@TableName("t_pay")
public class TPay extends Model<TPay> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 支付流水号
     */
    @TableField("pay_no")
    private String payNo;

    /**
     * 订单流水号
     */
    @TableField("order_no")
    private String orderNo;

    /**
     * 用户账号ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 交易金额
     */
    @TableField("amount")
    private BigDecimal amount;

    /**
     * 删除标志，默认0不删除，1删除
     */
    @TableField("deleted")
    private Byte deleted;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
