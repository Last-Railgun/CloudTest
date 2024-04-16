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
@TableName("t_storage")
public class Storage extends Model<Storage> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 产品id
     */
    @TableField("product_id")
    private Long productId;

    /**
     * 总库存
     */
    @TableField("total")
    private Integer total;

    /**
     * 已用库存
     */
    @TableField("used")
    private Integer used;

    /**
     * 剩余库存
     */
    @TableField("residue")
    private Integer residue;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}
