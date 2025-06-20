package com.entity.model;

import com.entity.MeirongxiangmEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongxiangmModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 美容项目名称
     */
    private String meirongxiangmName;


    /**
     * 美容项目照片
     */
    private String meirongxiangmPhoto;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 价格
     */
    private Double meirongxiangmNewMoney;


    /**
     * 美容项目类型
     */
    private Integer meirongxiangmTypes;


    /**
     * 购买获得积分
     */
    private Integer meirongxiangmPrice;


    /**
     * 美容项目热度
     */
    private Integer meirongxiangmClicknum;


    /**
     * 美容项目介绍
     */
    private String meirongxiangmContent;


    /**
     * 逻辑删除
     */
    private Integer meirongxiangmDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
