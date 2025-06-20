package com.entity.model;

import com.entity.MeirongshiOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容师预约
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongshiOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单编号
     */
    private String meirongshiOrderUuidNumber;


    /**
     * 美容师
     */
    private Integer meirongshiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date meirongshiOrderTime;


    /**
     * 实付价格
     */
    private Double meirongshiOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer meirongshiOrderTypes;


    /**
     * 支付类型
     */
    private Integer meirongshiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
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
    public String getMeirongshiOrderUuidNumber() {
        return meirongshiOrderUuidNumber;
    }


    /**
	 * 设置：订单编号
	 */
    public void setMeirongshiOrderUuidNumber(String meirongshiOrderUuidNumber) {
        this.meirongshiOrderUuidNumber = meirongshiOrderUuidNumber;
    }
    /**
	 * 获取：美容师
	 */
    public Integer getMeirongshiId() {
        return meirongshiId;
    }


    /**
	 * 设置：美容师
	 */
    public void setMeirongshiId(Integer meirongshiId) {
        this.meirongshiId = meirongshiId;
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
    public Date getMeirongshiOrderTime() {
        return meirongshiOrderTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setMeirongshiOrderTime(Date meirongshiOrderTime) {
        this.meirongshiOrderTime = meirongshiOrderTime;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getMeirongshiOrderTruePrice() {
        return meirongshiOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setMeirongshiOrderTruePrice(Double meirongshiOrderTruePrice) {
        this.meirongshiOrderTruePrice = meirongshiOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getMeirongshiOrderTypes() {
        return meirongshiOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setMeirongshiOrderTypes(Integer meirongshiOrderTypes) {
        this.meirongshiOrderTypes = meirongshiOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getMeirongshiOrderPaymentTypes() {
        return meirongshiOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setMeirongshiOrderPaymentTypes(Integer meirongshiOrderPaymentTypes) {
        this.meirongshiOrderPaymentTypes = meirongshiOrderPaymentTypes;
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
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
