package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 美容项目订单
 *
 * @author 
 * @email
 */
@TableName("meirongxiangm_order")
public class MeirongxiangmOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirongxiangmOrderEntity() {

	}

	public MeirongxiangmOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单编号
     */
    @ColumnInfo(comment="订单编号",type="varchar(200)")
    @TableField(value = "meirongxiangm_order_uuid_number")

    private String meirongxiangmOrderUuidNumber;


    /**
     * 美容项目
     */
    @ColumnInfo(comment="美容项目",type="int(11)")
    @TableField(value = "meirongxiangm_id")

    private Integer meirongxiangmId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="预约时间",type="timestamp")
    @TableField(value = "meirongxiangm_order_time")

    private Date meirongxiangmOrderTime;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "meirongxiangm_order_true_price")

    private Double meirongxiangmOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "meirongxiangm_order_types")

    private Integer meirongxiangmOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "meirongxiangm_order_payment_types")

    private Integer meirongxiangmOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 设置：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单编号
	 */
    public String getMeirongxiangmOrderUuidNumber() {
        return meirongxiangmOrderUuidNumber;
    }
    /**
	 * 设置：订单编号
	 */

    public void setMeirongxiangmOrderUuidNumber(String meirongxiangmOrderUuidNumber) {
        this.meirongxiangmOrderUuidNumber = meirongxiangmOrderUuidNumber;
    }
    /**
	 * 获取：美容项目
	 */
    public Integer getMeirongxiangmId() {
        return meirongxiangmId;
    }
    /**
	 * 设置：美容项目
	 */

    public void setMeirongxiangmId(Integer meirongxiangmId) {
        this.meirongxiangmId = meirongxiangmId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getMeirongxiangmOrderTime() {
        return meirongxiangmOrderTime;
    }
    /**
	 * 设置：预约时间
	 */

    public void setMeirongxiangmOrderTime(Date meirongxiangmOrderTime) {
        this.meirongxiangmOrderTime = meirongxiangmOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getMeirongxiangmOrderTruePrice() {
        return meirongxiangmOrderTruePrice;
    }
    /**
	 * 设置：实付价格
	 */

    public void setMeirongxiangmOrderTruePrice(Double meirongxiangmOrderTruePrice) {
        this.meirongxiangmOrderTruePrice = meirongxiangmOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getMeirongxiangmOrderTypes() {
        return meirongxiangmOrderTypes;
    }
    /**
	 * 设置：订单类型
	 */

    public void setMeirongxiangmOrderTypes(Integer meirongxiangmOrderTypes) {
        this.meirongxiangmOrderTypes = meirongxiangmOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getMeirongxiangmOrderPaymentTypes() {
        return meirongxiangmOrderPaymentTypes;
    }
    /**
	 * 设置：支付类型
	 */

    public void setMeirongxiangmOrderPaymentTypes(Integer meirongxiangmOrderPaymentTypes) {
        this.meirongxiangmOrderPaymentTypes = meirongxiangmOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "MeirongxiangmOrder{" +
            ", id=" + id +
            ", meirongxiangmOrderUuidNumber=" + meirongxiangmOrderUuidNumber +
            ", meirongxiangmId=" + meirongxiangmId +
            ", yonghuId=" + yonghuId +
            ", meirongxiangmOrderTime=" + DateUtil.convertString(meirongxiangmOrderTime,"yyyy-MM-dd") +
            ", meirongxiangmOrderTruePrice=" + meirongxiangmOrderTruePrice +
            ", meirongxiangmOrderTypes=" + meirongxiangmOrderTypes +
            ", meirongxiangmOrderPaymentTypes=" + meirongxiangmOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
