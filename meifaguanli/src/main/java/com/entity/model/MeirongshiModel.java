package com.entity.model;

import com.entity.MeirongshiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容师
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongshiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 美容师名称
     */
    private String meirongshiName;


    /**
     * 联系方式
     */
    private String meirongshiPhone;


    /**
     * 邮箱
     */
    private String meirongshiEmail;


    /**
     * 价格
     */
    private Double meirongshiNewMoney;


    /**
     * 美容师照片
     */
    private String meirongshiPhoto;


    /**
     * 购买获得积分
     */
    private Integer meirongshiPrice;


    /**
     * 美容师类型
     */
    private Integer meirongshiXingjiTypes;


    /**
     * 美容师介绍
     */
    private String meirongshiContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
