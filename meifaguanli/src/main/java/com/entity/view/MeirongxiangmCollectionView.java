package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeirongxiangmCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美容项目收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meirongxiangm_collection")
public class MeirongxiangmCollectionView extends MeirongxiangmCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String meirongxiangmCollectionValue;

	//级联表 美容项目
		/**
		* 美容项目名称
		*/

		@ColumnInfo(comment="美容项目名称",type="varchar(200)")
		private String meirongxiangmName;
		/**
		* 美容项目照片
		*/

		@ColumnInfo(comment="美容项目照片",type="varchar(200)")
		private String meirongxiangmPhoto;
		/**
		* 赞
		*/

		@ColumnInfo(comment="赞",type="int(11)")
		private Integer zanNumber;
		/**
		* 踩
		*/

		@ColumnInfo(comment="踩",type="int(11)")
		private Integer caiNumber;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double meirongxiangmNewMoney;
		/**
		* 美容项目类型
		*/
		@ColumnInfo(comment="美容项目类型",type="int(11)")
		private Integer meirongxiangmTypes;
			/**
			* 美容项目类型的值
			*/
			@ColumnInfo(comment="美容项目类型的字典表值",type="varchar(200)")
			private String meirongxiangmValue;
		/**
		* 购买获得积分
		*/

		@ColumnInfo(comment="购买获得积分",type="int(11)")
		private Integer meirongxiangmPrice;
		/**
		* 美容项目热度
		*/

		@ColumnInfo(comment="美容项目热度",type="int(11)")
		private Integer meirongxiangmClicknum;
		/**
		* 美容项目介绍
		*/

		@ColumnInfo(comment="美容项目介绍",type="longtext")
		private String meirongxiangmContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer meirongxiangmDelete;
	//级联表 用户
		/**
		* 用户名称
		*/

		@ColumnInfo(comment="用户名称",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 现有余额
		*/
		@ColumnInfo(comment="现有余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 现积分
		*/
		@ColumnInfo(comment="现积分",type="decimal(10,2)")
		private Double yonghuNewJifen;
		/**
		* 会员等级
		*/
		@ColumnInfo(comment="会员等级",type="int(11)")
		private Integer huiyuandengjiTypes;
			/**
			* 会员等级的值
			*/
			@ColumnInfo(comment="会员等级的字典表值",type="varchar(200)")
			private String huiyuandengjiValue;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yonghuDelete;



	public MeirongxiangmCollectionView() {

	}

	public MeirongxiangmCollectionView(MeirongxiangmCollectionEntity meirongxiangmCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, meirongxiangmCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getMeirongxiangmCollectionValue() {
		return meirongxiangmCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setMeirongxiangmCollectionValue(String meirongxiangmCollectionValue) {
		this.meirongxiangmCollectionValue = meirongxiangmCollectionValue;
	}


	//级联表的get和set 美容项目

		/**
		* 获取： 美容项目名称
		*/
		public String getMeirongxiangmName() {
			return meirongxiangmName;
		}
		/**
		* 设置： 美容项目名称
		*/
		public void setMeirongxiangmName(String meirongxiangmName) {
			this.meirongxiangmName = meirongxiangmName;
		}

		/**
		* 获取： 美容项目照片
		*/
		public String getMeirongxiangmPhoto() {
			return meirongxiangmPhoto;
		}
		/**
		* 设置： 美容项目照片
		*/
		public void setMeirongxiangmPhoto(String meirongxiangmPhoto) {
			this.meirongxiangmPhoto = meirongxiangmPhoto;
		}

		/**
		* 获取： 赞
		*/
		public Integer getZanNumber() {
			return zanNumber;
		}
		/**
		* 设置： 赞
		*/
		public void setZanNumber(Integer zanNumber) {
			this.zanNumber = zanNumber;
		}

		/**
		* 获取： 踩
		*/
		public Integer getCaiNumber() {
			return caiNumber;
		}
		/**
		* 设置： 踩
		*/
		public void setCaiNumber(Integer caiNumber) {
			this.caiNumber = caiNumber;
		}

		/**
		* 获取： 价格
		*/
		public Double getMeirongxiangmNewMoney() {
			return meirongxiangmNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setMeirongxiangmNewMoney(Double meirongxiangmNewMoney) {
			this.meirongxiangmNewMoney = meirongxiangmNewMoney;
		}
		/**
		* 获取： 美容项目类型
		*/
		public Integer getMeirongxiangmTypes() {
			return meirongxiangmTypes;
		}
		/**
		* 设置： 美容项目类型
		*/
		public void setMeirongxiangmTypes(Integer meirongxiangmTypes) {
			this.meirongxiangmTypes = meirongxiangmTypes;
		}


			/**
			* 获取： 美容项目类型的值
			*/
			public String getMeirongxiangmValue() {
				return meirongxiangmValue;
			}
			/**
			* 设置： 美容项目类型的值
			*/
			public void setMeirongxiangmValue(String meirongxiangmValue) {
				this.meirongxiangmValue = meirongxiangmValue;
			}

		/**
		* 获取： 购买获得积分
		*/
		public Integer getMeirongxiangmPrice() {
			return meirongxiangmPrice;
		}
		/**
		* 设置： 购买获得积分
		*/
		public void setMeirongxiangmPrice(Integer meirongxiangmPrice) {
			this.meirongxiangmPrice = meirongxiangmPrice;
		}

		/**
		* 获取： 美容项目热度
		*/
		public Integer getMeirongxiangmClicknum() {
			return meirongxiangmClicknum;
		}
		/**
		* 设置： 美容项目热度
		*/
		public void setMeirongxiangmClicknum(Integer meirongxiangmClicknum) {
			this.meirongxiangmClicknum = meirongxiangmClicknum;
		}

		/**
		* 获取： 美容项目介绍
		*/
		public String getMeirongxiangmContent() {
			return meirongxiangmContent;
		}
		/**
		* 设置： 美容项目介绍
		*/
		public void setMeirongxiangmContent(String meirongxiangmContent) {
			this.meirongxiangmContent = meirongxiangmContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getMeirongxiangmDelete() {
			return meirongxiangmDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setMeirongxiangmDelete(Integer meirongxiangmDelete) {
			this.meirongxiangmDelete = meirongxiangmDelete;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户名称
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户名称
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 现有余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 现有余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}

		/**
		* 获取： 现积分
		*/
		public Double getYonghuNewJifen() {
			return yonghuNewJifen;
		}
		/**
		* 设置： 现积分
		*/
		public void setYonghuNewJifen(Double yonghuNewJifen) {
			this.yonghuNewJifen = yonghuNewJifen;
		}
		/**
		* 获取： 会员等级
		*/
		public Integer getHuiyuandengjiTypes() {
			return huiyuandengjiTypes;
		}
		/**
		* 设置： 会员等级
		*/
		public void setHuiyuandengjiTypes(Integer huiyuandengjiTypes) {
			this.huiyuandengjiTypes = huiyuandengjiTypes;
		}


			/**
			* 获取： 会员等级的值
			*/
			public String getHuiyuandengjiValue() {
				return huiyuandengjiValue;
			}
			/**
			* 设置： 会员等级的值
			*/
			public void setHuiyuandengjiValue(String huiyuandengjiValue) {
				this.huiyuandengjiValue = huiyuandengjiValue;
			}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYonghuDelete() {
			return yonghuDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYonghuDelete(Integer yonghuDelete) {
			this.yonghuDelete = yonghuDelete;
		}


	@Override
	public String toString() {
		return "MeirongxiangmCollectionView{" +
			", meirongxiangmCollectionValue=" + meirongxiangmCollectionValue +
			", meirongxiangmName=" + meirongxiangmName +
			", meirongxiangmPhoto=" + meirongxiangmPhoto +
			", zanNumber=" + zanNumber +
			", caiNumber=" + caiNumber +
			", meirongxiangmNewMoney=" + meirongxiangmNewMoney +
			", meirongxiangmPrice=" + meirongxiangmPrice +
			", meirongxiangmClicknum=" + meirongxiangmClicknum +
			", meirongxiangmContent=" + meirongxiangmContent +
			", meirongxiangmDelete=" + meirongxiangmDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yonghuNewJifen=" + yonghuNewJifen +
			", yonghuDelete=" + yonghuDelete +
			"} " + super.toString();
	}
}
