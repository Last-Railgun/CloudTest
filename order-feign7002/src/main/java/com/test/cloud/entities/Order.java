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
@TableName("t_order")
public class Order extends Model<Order> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 产品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 数量
     */
    @TableField("count")
    private Integer count;

    /**
     * 金额
     */
    @TableField("money")
    private Long money;

    /**
     * 订单状态: 0:创建中; 1:已完结
     */
    @TableField("status")
    private Integer status;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
