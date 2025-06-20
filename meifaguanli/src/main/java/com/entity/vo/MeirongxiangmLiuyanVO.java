package com.entity.vo;

import com.entity.MeirongxiangmLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 美容项目留言
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("meirongxiangm_liuyan")
public class MeirongxiangmLiuyanVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


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
     * 留言内容
     */

    @TableField(value = "meirongxiangm_liuyan_text")
    private String meirongxiangmLiuyanText;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：留言内容
	 */
    public String getMeirongxiangmLiuyanText() {
        return meirongxiangmLiuyanText;
    }


    /**
	 * 获取：留言内容
	 */

    public void setMeirongxiangmLiuyanText(String meirongxiangmLiuyanText) {
        this.meirongxiangmLiuyanText = meirongxiangmLiuyanText;
    }
    /**
	 * 设置：留言时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：留言时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
