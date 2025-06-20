package com.entity.vo;

import com.entity.MeirongshiOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容师预约
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirongshi_order")
public class MeirongshiOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "meirongshi_order_uuid_number")
    private String meirongshiOrderUuidNumber;


    /**
     * 美容师
     */

    @TableField(value = "meirongshi_id")
    private Integer meirongshiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "meirongshi_order_time")
    private Date meirongshiOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "meirongshi_order_true_price")
    private Double meirongshiOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "meirongshi_order_types")
    private Integer meirongshiOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "meirongshi_order_payment_types")
    private Integer meirongshiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单编号
	 */
    public String getMeirongshiOrderUuidNumber() {
        return meirongshiOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setMeirongshiOrderUuidNumber(String meirongshiOrderUuidNumber) {
        this.meirongshiOrderUuidNumber = meirongshiOrderUuidNumber;
    }
    /**
	 * 设置：美容师
	 */
    public Integer getMeirongshiId() {
        return meirongshiId;
    }


    /**
	 * 获取：美容师
	 */

    public void setMeirongshiId(Integer meirongshiId) {
        this.meirongshiId = meirongshiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getMeirongshiOrderTime() {
        return meirongshiOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setMeirongshiOrderTime(Date meirongshiOrderTime) {
        this.meirongshiOrderTime = meirongshiOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getMeirongshiOrderTruePrice() {
        return meirongshiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setMeirongshiOrderTruePrice(Double meirongshiOrderTruePrice) {
        this.meirongshiOrderTruePrice = meirongshiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getMeirongshiOrderTypes() {
        return meirongshiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setMeirongshiOrderTypes(Integer meirongshiOrderTypes) {
        this.meirongshiOrderTypes = meirongshiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getMeirongshiOrderPaymentTypes() {
        return meirongshiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setMeirongshiOrderPaymentTypes(Integer meirongshiOrderPaymentTypes) {
        this.meirongshiOrderPaymentTypes = meirongshiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
