package com.entity.vo;

import com.entity.MeirongshiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容师
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirongshi")
public class MeirongshiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 账户
     */

    @TableField(value = "username")
    private String username;


    /**
     * 密码
     */

    @TableField(value = "password")
    private String password;


    /**
     * 美容师名称
     */

    @TableField(value = "meirongshi_name")
    private String meirongshiName;


    /**
     * 联系方式
     */

    @TableField(value = "meirongshi_phone")
    private String meirongshiPhone;


    /**
     * 邮箱
     */

    @TableField(value = "meirongshi_email")
    private String meirongshiEmail;


    /**
     * 价格
     */

    @TableField(value = "meirongshi_new_money")
    private Double meirongshiNewMoney;


    /**
     * 美容师照片
     */

    @TableField(value = "meirongshi_photo")
    private String meirongshiPhoto;


    /**
     * 购买获得积分
     */

    @TableField(value = "meirongshi_price")
    private Integer meirongshiPrice;


    /**
     * 美容师类型
     */

    @TableField(value = "meirongshi_xingji_types")
    private Integer meirongshiXingjiTypes;


    /**
     * 美容师介绍
     */

    @TableField(value = "meirongshi_content")
    private String meirongshiContent;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 获取：账户
	 */

    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 设置：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 获取：密码
	 */

    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 设置：美容师名称
	 */
    public String getMeirongshiName() {
        return meirongshiName;
    }


    /**
	 * 获取：美容师名称
	 */

    public void setMeirongshiName(String meirongshiName) {
        this.meirongshiName = meirongshiName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getMeirongshiPhone() {
        return meirongshiPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setMeirongshiPhone(String meirongshiPhone) {
        this.meirongshiPhone = meirongshiPhone;
    }
    /**
	 * 设置：邮箱
	 */
    public String getMeirongshiEmail() {
        return meirongshiEmail;
    }


    /**
	 * 获取：邮箱
	 */

    public void setMeirongshiEmail(String meirongshiEmail) {
        this.meirongshiEmail = meirongshiEmail;
    }
    /**
	 * 设置：价格
	 */
    public Double getMeirongshiNewMoney() {
        return meirongshiNewMoney;
    }


    /**
	 * 获取：价格
	 */

    public void setMeirongshiNewMoney(Double meirongshiNewMoney) {
        this.meirongshiNewMoney = meirongshiNewMoney;
    }
    /**
	 * 设置：美容师照片
	 */
    public String getMeirongshiPhoto() {
        return meirongshiPhoto;
    }


    /**
	 * 获取：美容师照片
	 */

    public void setMeirongshiPhoto(String meirongshiPhoto) {
        this.meirongshiPhoto = meirongshiPhoto;
    }
    /**
	 * 设置：购买获得积分
	 */
    public Integer getMeirongshiPrice() {
        return meirongshiPrice;
    }


    /**
	 * 获取：购买获得积分
	 */

    public void setMeirongshiPrice(Integer meirongshiPrice) {
        this.meirongshiPrice = meirongshiPrice;
    }
    /**
	 * 设置：美容师类型
	 */
    public Integer getMeirongshiXingjiTypes() {
        return meirongshiXingjiTypes;
    }


    /**
	 * 获取：美容师类型
	 */

    public void setMeirongshiXingjiTypes(Integer meirongshiXingjiTypes) {
        this.meirongshiXingjiTypes = meirongshiXingjiTypes;
    }
    /**
	 * 设置：美容师介绍
	 */
    public String getMeirongshiContent() {
        return meirongshiContent;
    }


    /**
	 * 获取：美容师介绍
	 */

    public void setMeirongshiContent(String meirongshiContent) {
        this.meirongshiContent = meirongshiContent;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
