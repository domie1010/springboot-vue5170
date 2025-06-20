package com.entity.vo;

import com.entity.MeirongxiangmOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容项目订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirongxiangm_order")
public class MeirongxiangmOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单编号
     */

    @TableField(value = "meirongxiangm_order_uuid_number")
    private String meirongxiangmOrderUuidNumber;


    /**
     * 美容项目
     */

    @TableField(value = "meirongxiangm_id")
    private Integer meirongxiangmId;


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

    @TableField(value = "meirongxiangm_order_time")
    private Date meirongxiangmOrderTime;


    /**
     * 实付价格
     */

    @TableField(value = "meirongxiangm_order_true_price")
    private Double meirongxiangmOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "meirongxiangm_order_types")
    private Integer meirongxiangmOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "meirongxiangm_order_payment_types")
    private Integer meirongxiangmOrderPaymentTypes;


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
    public String getMeirongxiangmOrderUuidNumber() {
        return meirongxiangmOrderUuidNumber;
    }


    /**
	 * 获取：订单编号
	 */

    public void setMeirongxiangmOrderUuidNumber(String meirongxiangmOrderUuidNumber) {
        this.meirongxiangmOrderUuidNumber = meirongxiangmOrderUuidNumber;
    }
    /**
	 * 设置：美容项目
	 */
    public Integer getMeirongxiangmId() {
        return meirongxiangmId;
    }


    /**
	 * 获取：美容项目
	 */

    public void setMeirongxiangmId(Integer meirongxiangmId) {
        this.meirongxiangmId = meirongxiangmId;
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
    public Date getMeirongxiangmOrderTime() {
        return meirongxiangmOrderTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setMeirongxiangmOrderTime(Date meirongxiangmOrderTime) {
        this.meirongxiangmOrderTime = meirongxiangmOrderTime;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getMeirongxiangmOrderTruePrice() {
        return meirongxiangmOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setMeirongxiangmOrderTruePrice(Double meirongxiangmOrderTruePrice) {
        this.meirongxiangmOrderTruePrice = meirongxiangmOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getMeirongxiangmOrderTypes() {
        return meirongxiangmOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setMeirongxiangmOrderTypes(Integer meirongxiangmOrderTypes) {
        this.meirongxiangmOrderTypes = meirongxiangmOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getMeirongxiangmOrderPaymentTypes() {
        return meirongxiangmOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setMeirongxiangmOrderPaymentTypes(Integer meirongxiangmOrderPaymentTypes) {
        this.meirongxiangmOrderPaymentTypes = meirongxiangmOrderPaymentTypes;
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
