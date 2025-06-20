package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.MeirongshiCollectionEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 美容师收藏
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("meirongshi_collection")
public class MeirongshiCollectionView extends MeirongshiCollectionEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 类型的值
	*/
	@ColumnInfo(comment="类型的字典表值",type="varchar(200)")
	private String meirongshiCollectionValue;

	//级联表 美容师
		/**
		* 美容师名称
		*/

		@ColumnInfo(comment="美容师名称",type="varchar(200)")
		private String meirongshiName;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String meirongshiPhone;
		/**
		* 邮箱
		*/

		@ColumnInfo(comment="邮箱",type="varchar(200)")
		private String meirongshiEmail;
		/**
		* 价格
		*/
		@ColumnInfo(comment="价格",type="decimal(10,2)")
		private Double meirongshiNewMoney;
		/**
		* 美容师照片
		*/

		@ColumnInfo(comment="美容师照片",type="varchar(200)")
		private String meirongshiPhoto;
		/**
		* 购买获得积分
		*/

		@ColumnInfo(comment="购买获得积分",type="int(11)")
		private Integer meirongshiPrice;
		/**
		* 美容师类型
		*/
		@ColumnInfo(comment="美容师类型",type="int(11)")
		private Integer meirongshiXingjiTypes;
			/**
			* 美容师类型的值
			*/
			@ColumnInfo(comment="美容师类型的字典表值",type="varchar(200)")
			private String meirongshiXingjiValue;
		/**
		* 美容师介绍
		*/

		@ColumnInfo(comment="美容师介绍",type="longtext")
		private String meirongshiContent;
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



	public MeirongshiCollectionView() {

	}

	public MeirongshiCollectionView(MeirongshiCollectionEntity meirongshiCollectionEntity) {
		try {
			BeanUtils.copyProperties(this, meirongshiCollectionEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 类型的值
	*/
	public String getMeirongshiCollectionValue() {
		return meirongshiCollectionValue;
	}
	/**
	* 设置： 类型的值
	*/
	public void setMeirongshiCollectionValue(String meirongshiCollectionValue) {
		this.meirongshiCollectionValue = meirongshiCollectionValue;
	}


	//级联表的get和set 美容师

		/**
		* 获取： 美容师名称
		*/
		public String getMeirongshiName() {
			return meirongshiName;
		}
		/**
		* 设置： 美容师名称
		*/
		public void setMeirongshiName(String meirongshiName) {
			this.meirongshiName = meirongshiName;
		}

		/**
		* 获取： 联系方式
		*/
		public String getMeirongshiPhone() {
			return meirongshiPhone;
		}
		/**
		* 设置： 联系方式
		*/
		public void setMeirongshiPhone(String meirongshiPhone) {
			this.meirongshiPhone = meirongshiPhone;
		}

		/**
		* 获取： 邮箱
		*/
		public String getMeirongshiEmail() {
			return meirongshiEmail;
		}
		/**
		* 设置： 邮箱
		*/
		public void setMeirongshiEmail(String meirongshiEmail) {
			this.meirongshiEmail = meirongshiEmail;
		}

		/**
		* 获取： 价格
		*/
		public Double getMeirongshiNewMoney() {
			return meirongshiNewMoney;
		}
		/**
		* 设置： 价格
		*/
		public void setMeirongshiNewMoney(Double meirongshiNewMoney) {
			this.meirongshiNewMoney = meirongshiNewMoney;
		}

		/**
		* 获取： 美容师照片
		*/
		public String getMeirongshiPhoto() {
			return meirongshiPhoto;
		}
		/**
		* 设置： 美容师照片
		*/
		public void setMeirongshiPhoto(String meirongshiPhoto) {
			this.meirongshiPhoto = meirongshiPhoto;
		}

		/**
		* 获取： 购买获得积分
		*/
		public Integer getMeirongshiPrice() {
			return meirongshiPrice;
		}
		/**
		* 设置： 购买获得积分
		*/
		public void setMeirongshiPrice(Integer meirongshiPrice) {
			this.meirongshiPrice = meirongshiPrice;
		}
		/**
		* 获取： 美容师类型
		*/
		public Integer getMeirongshiXingjiTypes() {
			return meirongshiXingjiTypes;
		}
		/**
		* 设置： 美容师类型
		*/
		public void setMeirongshiXingjiTypes(Integer meirongshiXingjiTypes) {
			this.meirongshiXingjiTypes = meirongshiXingjiTypes;
		}


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

		/**
		* 获取： 美容师介绍
		*/
		public String getMeirongshiContent() {
			return meirongshiContent;
		}
		/**
		* 设置： 美容师介绍
		*/
		public void setMeirongshiContent(String meirongshiContent) {
			this.meirongshiContent = meirongshiContent;
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
		return "MeirongshiCollectionView{" +
			", meirongshiCollectionValue=" + meirongshiCollectionValue +
			", meirongshiName=" + meirongshiName +
			", meirongshiPhone=" + meirongshiPhone +
			", meirongshiEmail=" + meirongshiEmail +
			", meirongshiNewMoney=" + meirongshiNewMoney +
			", meirongshiPhoto=" + meirongshiPhoto +
			", meirongshiPrice=" + meirongshiPrice +
			", meirongshiContent=" + meirongshiContent +
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
