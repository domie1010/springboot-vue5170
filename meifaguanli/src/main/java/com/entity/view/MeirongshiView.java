package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeirongshiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美容师
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meirongshi")
public class MeirongshiView extends MeirongshiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 美容师类型的值
	*/
	@ColumnInfo(comment="美容师类型的字典表值",type="varchar(200)")
	private String meirongshiXingjiValue;




	public MeirongshiView() {

	}

	public MeirongshiView(MeirongshiEntity meirongshiEntity) {
		try {
			BeanUtils.copyProperties(this, meirongshiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 美容师类型的值
	*/
	public String getMeirongshiXingjiValue() {
		return meirongshiXingjiValue;
	}
	/**
	* 设置： 美容师类型的值
	*/
	public void setMeirongshiXingjiValue(String meirongshiXingjiValue) {
		this.meirongshiXingjiValue = meirongshiXingjiValue;
	}




	@Override
	public String toString() {
		return "MeirongshiView{" +
			", meirongshiXingjiValue=" + meirongshiXingjiValue +
			"} " + super.toString();
	}
}
