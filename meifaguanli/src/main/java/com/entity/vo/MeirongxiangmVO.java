package com.entity.vo;

import com.entity.MeirongxiangmEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirongxiangm")
public class MeirongxiangmVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 美容项目名称
     */

    @TableField(value = "meirongxiangm_name")
    private String meirongxiangmName;


    /**
     * 美容项目照片
     */

    @TableField(value = "meirongxiangm_photo")
    private String meirongxiangmPhoto;


    /**
     * 赞
     */

    @TableField(value = "zan_number")
    private Integer zanNumber;


    /**
     * 踩
     */

    @TableField(value = "cai_number")
    private Integer caiNumber;


    /**
     * 价格
     */

    @TableField(value = "meirongxiangm_new_money")
    private Double meirongxiangmNewMoney;


    /**
     * 美容项目类型
     */

    @TableField(value = "meirongxiangm_types")
    private Integer meirongxiangmTypes;


    /**
     * 购买获得积分
     */

    @TableField(value = "meirongxiangm_price")
    private Integer meirongxiangmPrice;


    /**
     * 美容项目热度
     */

    @TableField(value = "meirongxiangm_clicknum")
    private Integer meirongxiangmClicknum;


    /**
     * 美容项目介绍
     */

    @TableField(value = "meirongxiangm_content")
    private String meirongxiangmContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "meirongxiangm_delete")
    private Integer meirongxiangmDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow homeMain
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
	 * 设置：美容项目名称
	 */
    public String getMeirongxiangmName() {
        return meirongxiangmName;
    }


    /**
	 * 获取：美容项目名称
	 */

    public void setMeirongxiangmName(String meirongxiangmName) {
        this.meirongxiangmName = meirongxiangmName;
    }
    /**
	 * 设置：美容项目照片
	 */
    public String getMeirongxiangmPhoto() {
        return meirongxiangmPhoto;
    }


    /**
	 * 获取：美容项目照片
	 */

    public void setMeirongxiangmPhoto(String meirongxiangmPhoto) {
        this.meirongxiangmPhoto = meirongxiangmPhoto;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：价格
	 */
    public Double getMeirongxiangmNewMoney() {
        return meirongxiangmNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setMeirongxiangmNewMoney(Double meirongxiangmNewMoney) {
        this.meirongxiangmNewMoney = meirongxiangmNewMoney;
    }
    /**
	 * 设置：美容项目类型
	 */
    public Integer getMeirongxiangmTypes() {
        return meirongxiangmTypes;
    }


    /**
	 * 获取：美容项目类型
	 */

    public void setMeirongxiangmTypes(Integer meirongxiangmTypes) {
        this.meirongxiangmTypes = meirongxiangmTypes;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getMeirongxiangmPrice() {
        return meirongxiangmPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setMeirongxiangmPrice(Integer meirongxiangmPrice) {
        this.meirongxiangmPrice = meirongxiangmPrice;
    }
    /**
	 * 设置：美容项目热度
	 */
    public Integer getMeirongxiangmClicknum() {
        return meirongxiangmClicknum;
    }


    /**
	 * 获取：美容项目热度
	 */

    public void setMeirongxiangmClicknum(Integer meirongxiangmClicknum) {
        this.meirongxiangmClicknum = meirongxiangmClicknum;
    }
    /**
	 * 设置：美容项目介绍
	 */
    public String getMeirongxiangmContent() {
        return meirongxiangmContent;
    }


    /**
	 * 获取：美容项目介绍
	 */

    public void setMeirongxiangmContent(String meirongxiangmContent) {
        this.meirongxiangmContent = meirongxiangmContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getMeirongxiangmDelete() {
        return meirongxiangmDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setMeirongxiangmDelete(Integer meirongxiangmDelete) {
        this.meirongxiangmDelete = meirongxiangmDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow homeMain
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow homeMain
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
