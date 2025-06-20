<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="auto"
    >  
     <el-row>
                    <el-col :span="12">
           <el-form-item v-if="flag=='meirongshi'"  label='美容师名称' prop="meirongshiName">
               <el-input v-model="ruleForm.meirongshiName"  placeholder='美容师名称' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='meirongshi'"  label='联系方式' prop="meirongshiPhone">
               <el-input v-model="ruleForm.meirongshiPhone"  placeholder='联系方式' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='meirongshi'"  label='邮箱' prop="meirongshiEmail">
               <el-input v-model="ruleForm.meirongshiEmail"  placeholder='邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='meirongshi'"  label='价格' prop="meirongshiNewMoney">
                 <el-input v-model="ruleForm.meirongshiNewMoney"  placeholder='价格' disabled style="width: 100px"></el-input>
                 <!--<a id="btn-recharge" @click="chongzhi" href="javascript:void(0)">点我充值</a>-->
                 <!--<a id="btn-recharge" @click="tixian" href="javascript:void(0)">点我提现</a>-->
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='meirongshi'" label='美容师照片' prop="meirongshiPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.meirongshiPhoto?$base.url+ruleForm.meirongshiPhoto:''"
                         @change="meirongshiPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='meirongshi'"  label='购买获得积分' prop="meirongshiPrice">
               <el-input v-model="ruleForm.meirongshiPrice"  placeholder='购买获得积分' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='meirongshi'"  label='美容师类型' prop="meirongshiXingjiTypes">
                 <el-select v-model="ruleForm.meirongshiXingjiTypes"  placeholder='请选择美容师类型'>
                     <el-option
                             v-for="(item,index) in meirongshiXingjiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item v-if="flag=='meirongshi'"  label="美容师介绍" prop="meirongshiContent">
                 <editor
                         style="min-width: 200px; max-width: 600px;"
                         v-model="ruleForm.meirongshiContent"
                         class="editor"
                         action="file/upload">
                 </editor>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户名称' prop="yonghuName">
               <el-input v-model="ruleForm.yonghuName"  placeholder='用户名称' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户手机号' prop="yonghuPhone">
               <el-input v-model="ruleForm.yonghuPhone"  placeholder='用户手机号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户身份证号' prop="yonghuIdNumber">
               <el-input v-model="ruleForm.yonghuIdNumber"  placeholder='用户身份证号' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'" label='用户头像' prop="yonghuPhoto">
                 <file-upload
                         tip="点击上传照片"
                         action="file/upload"
                         :limit="3"
                         :multiple="true"
                         :fileUrls="ruleForm.yonghuPhoto?$base.url+ruleForm.yonghuPhoto:''"
                         @change="yonghuPhotoUploadChange"
                 ></file-upload>
             </el-form-item>
         </el-col>
         <el-col :span="12">
           <el-form-item v-if="flag=='yonghu'"  label='用户邮箱' prop="yonghuEmail">
               <el-input v-model="ruleForm.yonghuEmail"  placeholder='用户邮箱' clearable></el-input>
           </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label='现有余额' prop="newMoney">
                 <el-input v-model="ruleForm.newMoney"  placeholder='现有余额' disabled style="width: 100px"></el-input>
                 <!--<a id="btn-recharge" @click="chongzhi" href="javascript:void(0)">点我充值</a>-->
                 <!--<a id="btn-recharge" @click="tixian" href="javascript:void(0)">点我提现</a>-->
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label='现积分' prop="yonghuNewJifen">
                 <el-input v-model="ruleForm.yonghuNewJifen"  placeholder='现积分' disabled style="width: 100px"></el-input>
                 <!--<a id="btn-recharge" @click="chongzhi" href="javascript:void(0)">点我充值</a>-->
                 <!--<a id="btn-recharge" @click="tixian" href="javascript:void(0)">点我提现</a>-->
             </el-form-item>
         </el-col>
         <el-col :span="12">
             <el-form-item v-if="flag=='yonghu'"  label='会员等级' prop="huiyuandengjiTypes">
                 <el-select v-model="ruleForm.huiyuandengjiTypes" disabled placeholder='请选择会员等级'>
                     <el-option
                             v-for="(item,index) in huiyuandengjiTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-form-item v-if="flag=='users'" label="用户名" prop="username">
             <el-input v-model="ruleForm.username"
                       placeholder="用户名"></el-input>
         </el-form-item>
         <el-col :span="12">
             <el-form-item v-if="flag!='users' &&( 1==2|| flag=='yonghu')"  label="性别" prop="sexTypes">
                 <el-select v-model="ruleForm.sexTypes" placeholder="请选择性别">
                     <el-option
                             v-for="(item,index) in sexTypesOptions"
                             v-bind:key="item.codeIndex"
                             :label="item.indexName"
                             :value="item.codeIndex">
                     </el-option>
                 </el-select>
             </el-form-item>
         </el-col>
         <el-col :span="24">
             <el-form-item>
                 <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
             </el-form-item>
         </el-col>
     </el-row>
    </el-form>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
        ruleForm: {},
        flag: '',
        usersFlag: false,
        // sexTypesOptions : [],
// 注册表 用户
    // 注册的类型字段 用户
        // 性别
        sexTypesOptions : [],
        // 会员等级
        huiyuandengjiTypesOptions : [],
// 注册表 美容师
    // 注册的类型字段 美容师
        // 美容师类型
        meirongshiXingjiTypesOptions : [],
    };
  },
  mounted() {
    //获取当前登录用户的信息
    var table = this.$storage.get("sessionTable");
    this.sessionTable = this.$storage.get("sessionTable");
    this.role = this.$storage.get("role");
    if (this.role != "管理员"){
    }

    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
// 注册表 用户
// 注册表 美容师
      } else {
        this.$message.error(data.msg);
      }
    });

// 注册表 用户 的级联表
// 注册表 美容师 的级联表

      this.$http({
          url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=sex_types`,
          method: "get"
      }).then(({ data }) => {
          if (data && data.code === 0) {
              this.sexTypesOptions = data.data.list;
          } else {
              this.$message.error(data.msg);
          }
      });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=meirongshi_xingji_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.meirongshiXingjiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
   this.$http({
       url: `dictionary/page?page=1&limit=100&sort=&order=&dicCode=huiyuandengji_types`,
       method: "get"
   }).then(({ data }) => {
       if (data && data.code === 0) {
          this.huiyuandengjiTypesOptions = data.data.list;
      } else {
          this.$message.error(data.msg);
      }
    });
  },
  methods: {
    chongzhi() {
      this.$router.replace({ path: "/pay" });
    },
    tixian() {
      let _this=this;
      this.$confirm(`确定要提现么?`, "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
      }).then(() => {
          _this.ruleForm.newMoney=0;
          _this.$http({
              url: `${this.$storage.get("sessionTable")}/update`,
              method: "post",
              data: this.ruleForm
          }).then(({ data }) => {
              if (data && data.code === 0) {
                  _this.$message({message: "提现成功",type: "success",duration: 1500,onClose: () => {}});
              } else {this.$message.error(data.msg);}
          });
      });
    },
    meirongshiPhotoUploadChange(fileUrls) {
        this.ruleForm.meirongshiPhoto = fileUrls;
    },
    yonghuPhotoUploadChange(fileUrls) {
        this.ruleForm.yonghuPhoto = fileUrls;
    },


    onUpdateHandler() {
                         if((!this.ruleForm.meirongshiName)&& 'meirongshi'==this.flag){
                             this.$message.error('美容师名称不能为空');
                             return
                         }

                         if((!this.ruleForm.meirongshiPhone)&& 'meirongshi'==this.flag){
                             this.$message.error('联系方式不能为空');
                             return
                         }

                             if( 'meirongshi' ==this.flag && this.ruleForm.meirongshiEmail&&(!isEmail(this.ruleForm.meirongshiEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.meirongshiPhoto)&& 'meirongshi'==this.flag){
                             this.$message.error('美容师照片不能为空');
                             return
                         }

                         if((!this.ruleForm.meirongshiPrice)&& 'meirongshi'==this.flag){
                             this.$message.error('购买获得积分不能为空');
                             return
                         }

                         if((!this.ruleForm.meirongshiXingjiTypes)&& 'meirongshi'==this.flag){
                             this.$message.error('美容师类型不能为空');
                             return
                         }

                         if((!this.ruleForm.meirongshiContent)&& 'meirongshi'==this.flag){
                             this.$message.error('美容师介绍不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuName)&& 'yonghu'==this.flag){
                             this.$message.error('用户名称不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuPhone&&(!isMobile(this.ruleForm.yonghuPhone))){
                                 this.$message.error(`手机应输入手机格式`);
                                 return
                             }
                         if((!this.ruleForm.yonghuIdNumber)&& 'yonghu'==this.flag){
                             this.$message.error('用户身份证号不能为空');
                             return
                         }

                         if((!this.ruleForm.yonghuPhoto)&& 'yonghu'==this.flag){
                             this.$message.error('用户头像不能为空');
                             return
                         }

                             if( 'yonghu' ==this.flag && this.ruleForm.yonghuEmail&&(!isEmail(this.ruleForm.yonghuEmail))){
                                 this.$message.error(`邮箱应输入邮箱格式`);
                                 return
                             }
                         if((!this.ruleForm.huiyuandengjiTypes)&& 'yonghu'==this.flag){
                             this.$message.error('会员等级不能为空');
                             return
                         }

        if((!this.ruleForm.sexTypes) && (1==2|| this.flag=='yonghu')){
            this.$message.error('性别不能为空');
            return
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
        this.$message.error(`用户名不能为空`);
        return	
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
