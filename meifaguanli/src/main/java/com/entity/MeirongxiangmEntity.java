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
 * 美容项目
 *
 * @author 
 * @email
 */
@TableName("meirongxiangm")
public class MeirongxiangmEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirongxiangmEntity() {

	}

	public MeirongxiangmEntity(T t) {
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
     * 美容项目名称
     */
    @ColumnInfo(comment="美容项目名称",type="varchar(200)")
    @TableField(value = "meirongxiangm_name")

    private String meirongxiangmName;


    /**
     * 美容项目照片
     */
    @ColumnInfo(comment="美容项目照片",type="varchar(200)")
    @TableField(value = "meirongxiangm_photo")

    private String meirongxiangmPhoto;


    /**
     * 赞
     */
    @ColumnInfo(comment="赞",type="int(11)")
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @ColumnInfo(comment="踩",type="int(11)")
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 价格
     */
    @ColumnInfo(comment="价格",type="decimal(10,2)")
    @TableField(value = "meirongxiangm_new_money")

    private Double meirongxiangmNewMoney;


    /**
     * 美容项目类型
     */
    @ColumnInfo(comment="美容项目类型",type="int(11)")
    @TableField(value = "meirongxiangm_types")

    private Integer meirongxiangmTypes;


    /**
     * 购买获得积分
     */
    @ColumnInfo(comment="购买获得积分",type="int(11)")
    @TableField(value = "meirongxiangm_price")

    private Integer meirongxiangmPrice;


    /**
     * 美容项目热度
     */
    @ColumnInfo(comment="美容项目热度",type="int(11)")
    @TableField(value = "meirongxiangm_clicknum")

    private Integer meirongxiangmClicknum;


    /**
     * 美容项目介绍
     */
    @ColumnInfo(comment="美容项目介绍",type="longtext")
    @TableField(value = "meirongxiangm_content")

    private String meirongxiangmContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "meirongxiangm_delete")

    private Integer meirongxiangmDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间     homeMain
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
	 * 获取：美容项目名称
	 */
    public String getMeirongxiangmName() {
        return meirongxiangmName;
    }
    /**
	 * 设置：美容项目名称
	 */

    public void setMeirongxiangmName(String meirongxiangmName) {
        this.meirongxiangmName = meirongxiangmName;
    }
    /**
	 * 获取：美容项目照片
	 */
    public String getMeirongxiangmPhoto() {
        return meirongxiangmPhoto;
    }
    /**
	 * 设置：美容项目照片
	 */

    public void setMeirongxiangmPhoto(String meirongxiangmPhoto) {
        this.meirongxiangmPhoto = meirongxiangmPhoto;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 设置：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 设置：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：价格
	 */
    public Double getMeirongxiangmNewMoney() {
        return meirongxiangmNewMoney;
    }
    /**
	 * 设置：价格
	 */

    public void setMeirongxiangmNewMoney(Double meirongxiangmNewMoney) {
        this.meirongxiangmNewMoney = meirongxiangmNewMoney;
    }
    /**
	 * 获取：美容项目类型
	 */
    public Integer getMeirongxiangmTypes() {
        return meirongxiangmTypes;
    }
    /**
	 * 设置：美容项目类型
	 */

    public void setMeirongxiangmTypes(Integer meirongxiangmTypes) {
        this.meirongxiangmTypes = meirongxiangmTypes;
    }
    /**
	 * 获取：购买获得积分
	 */
    public Integer getMeirongxiangmPrice() {
        return meirongxiangmPrice;
    }
    /**
	 * 设置：购买获得积分
	 */

    public void setMeirongxiangmPrice(Integer meirongxiangmPrice) {
        this.meirongxiangmPrice = meirongxiangmPrice;
    }
    /**
	 * 获取：美容项目热度
	 */
    public Integer getMeirongxiangmClicknum() {
        return meirongxiangmClicknum;
    }
    /**
	 * 设置：美容项目热度
	 */

    public void setMeirongxiangmClicknum(Integer meirongxiangmClicknum) {
        this.meirongxiangmClicknum = meirongxiangmClicknum;
    }
    /**
	 * 获取：美容项目介绍
	 */
    public String getMeirongxiangmContent() {
        return meirongxiangmContent;
    }
    /**
	 * 设置：美容项目介绍
	 */

    public void setMeirongxiangmContent(String meirongxiangmContent) {
        this.meirongxiangmContent = meirongxiangmContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getMeirongxiangmDelete() {
        return meirongxiangmDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setMeirongxiangmDelete(Integer meirongxiangmDelete) {
        this.meirongxiangmDelete = meirongxiangmDelete;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间     homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间     homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Meirongxiangm{" +
            ", id=" + id +
            ", meirongxiangmName=" + meirongxiangmName +
            ", meirongxiangmPhoto=" + meirongxiangmPhoto +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", meirongxiangmNewMoney=" + meirongxiangmNewMoney +
            ", meirongxiangmTypes=" + meirongxiangmTypes +
            ", meirongxiangmPrice=" + meirongxiangmPrice +
            ", meirongxiangmClicknum=" + meirongxiangmClicknum +
            ", meirongxiangmContent=" + meirongxiangmContent +
            ", meirongxiangmDelete=" + meirongxiangmDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
