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
 * 美容项目留言
 *
 * @author 
 * @email
 */
@TableName("meirongxiangm_liuyan")
public class MeirongxiangmLiuyanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public MeirongxiangmLiuyanEntity() {

	}

	public MeirongxiangmLiuyanEntity(T t) {
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
     * 美容项目
     */
    @ColumnInfo(comment="美容项目",type="int(11)")
    @TableField(value = "meirongxiangm_id")

    private Integer meirongxiangmId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 留言内容
     */
    @ColumnInfo(comment="留言内容",type="longtext")
    @TableField(value = "meirongxiangm_liuyan_text")

    private String meirongxiangmLiuyanText;


    /**
     * 留言时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="留言时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


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

    @Override
    public String toString() {
        return "MeirongxiangmLiuyan{" +
            ", id=" + id +
            ", meirongxiangmId=" + meirongxiangmId +
            ", yonghuId=" + yonghuId +
            ", meirongxiangmLiuyanText=" + meirongxiangmLiuyanText +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
