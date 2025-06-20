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
 * 美容师
 *
 * @author 
 * @email
 */
@TableName("meirongshi")
public class MeirongshiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirongshiEntity() {

	}

	public MeirongshiEntity(T t) {
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
     * 账户
     */
    @ColumnInfo(comment="账户",type="varchar(200)")
    @TableField(value = "username")

    private String username;


    /**
     * 密码
     */
    @ColumnInfo(comment="密码",type="varchar(200)")
    @TableField(value = "password")

    private String password;


    /**
     * 美容师名称
     */
    @ColumnInfo(comment="美容师名称",type="varchar(200)")
    @TableField(value = "meirongshi_name")

    private String meirongshiName;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "meirongshi_phone")

    private String meirongshiPhone;


    /**
     * 邮箱
     */
    @ColumnInfo(comment="邮箱",type="varchar(200)")
    @TableField(value = "meirongshi_email")

    private String meirongshiEmail;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "meirongshi_new_money")

    private Double meirongshiNewMoney;


    /**
     * 美容师照片
     */
    @ColumnInfo(comment="美容师照片",type="varchar(200)")
    @TableField(value = "meirongshi_photo")

    private String meirongshiPhoto;


    /**
     * 购买获得积分
     */
    @ColumnInfo(comment="购买获得积分",type="int(11)")
    @TableField(value = "meirongshi_price")

    private Integer meirongshiPrice;


    /**
     * 美容师类型
     */
    @ColumnInfo(comment="美容师类型",type="int(11)")
    @TableField(value = "meirongshi_xingji_types")

    private Integer meirongshiXingjiTypes;


    /**
     * 美容师介绍
     */
    @ColumnInfo(comment="美容师介绍",type="longtext")
    @TableField(value = "meirongshi_content")

    private String meirongshiContent;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }
    /**
	 * 设置：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }
    /**
	 * 设置：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：美容师名称
	 */
    public String getMeirongshiName() {
        return meirongshiName;
    }
    /**
	 * 设置：美容师名称
	 */

    public void setMeirongshiName(String meirongshiName) {
        this.meirongshiName = meirongshiName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getMeirongshiPhone() {
        return meirongshiPhone;
    }
    /**
	 * 设置：联系方式
	 */

    public void setMeirongshiPhone(String meirongshiPhone) {
        this.meirongshiPhone = meirongshiPhone;
    }
    /**
	 * 获取：邮箱
	 */
    public String getMeirongshiEmail() {
        return meirongshiEmail;
    }
    /**
	 * 设置：邮箱
	 */

    public void setMeirongshiEmail(String meirongshiEmail) {
        this.meirongshiEmail = meirongshiEmail;
    }
    /**
	 * 获取：价格
	 */
    public Double getMeirongshiNewMoney() {
        return meirongshiNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setMeirongshiNewMoney(Double meirongshiNewMoney) {
        this.meirongshiNewMoney = meirongshiNewMoney;
    }
    /**
	 * 获取：美容师照片
	 */
    public String getMeirongshiPhoto() {
        return meirongshiPhoto;
    }
    /**
	 * 设置：美容师照片
	 */

    public void setMeirongshiPhoto(String meirongshiPhoto) {
        this.meirongshiPhoto = meirongshiPhoto;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getMeirongshiPrice() {
        return meirongshiPrice;
    }
    /**
	 * 设置：购买获得积分
	 */

    public void setMeirongshiPrice(Integer meirongshiPrice) {
        this.meirongshiPrice = meirongshiPrice;
    }
    /**
	 * 获取：美容师类型
	 */
    public Integer getMeirongshiXingjiTypes() {
        return meirongshiXingjiTypes;
    }
    /**
	 * 设置：美容师类型
	 */

    public void setMeirongshiXingjiTypes(Integer meirongshiXingjiTypes) {
        this.meirongshiXingjiTypes = meirongshiXingjiTypes;
    }
    /**
	 * 获取：美容师介绍
	 */
    public String getMeirongshiContent() {
        return meirongshiContent;
    }
    /**
	 * 设置：美容师介绍
	 */

    public void setMeirongshiContent(String meirongshiContent) {
        this.meirongshiContent = meirongshiContent;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Meirongshi{" +
            ", id=" + id +
            ", username=" + username +
            ", password=" + password +
            ", meirongshiName=" + meirongshiName +
            ", meirongshiPhone=" + meirongshiPhone +
            ", meirongshiEmail=" + meirongshiEmail +
            ", meirongshiNewMoney=" + meirongshiNewMoney +
            ", meirongshiPhoto=" + meirongshiPhoto +
            ", meirongshiPrice=" + meirongshiPrice +
            ", meirongshiXingjiTypes=" + meirongshiXingjiTypes +
            ", meirongshiContent=" + meirongshiContent +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
