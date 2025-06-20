package com.entity.model;

import com.entity.MeirongxiangmLiuyanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 美容项目留言
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class MeirongxiangmLiuyanModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 美容项目
     */
    private Integer meirongxiangmId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 留言内容
     */
    private String meirongxiangmLiuyanText;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：留言内容
	 */
    public String getMeirongxiangmLiuyanText() {
        return meirongxiangmLiuyanText;
    }


    /**
	 * 设置：留言内容
	 */
    public void setMeirongxiangmLiuyanText(String meirongxiangmLiuyanText) {
        this.meirongxiangmLiuyanText = meirongxiangmLiuyanText;
    }
    /**
	 * 获取：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：留言时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
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

    }
