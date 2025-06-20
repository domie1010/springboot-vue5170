
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 美容师预约
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongshiOrder")
public class MeirongshiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongshiOrderController.class);

    private static final String TABLE_NAME = "meirongshiOrder";

    @Autowired
    private MeirongshiOrderService meirongshiOrderService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private MeirongshiService meirongshiService;//美容师
    @Autowired
    private MeirongshiCollectionService meirongshiCollectionService;//美容师收藏
    @Autowired
    private MeirongshiLiuyanService meirongshiLiuyanService;//美容师留言
    @Autowired
    private MeirongxiangmService meirongxiangmService;//美容项目
    @Autowired
    private MeirongxiangmCollectionService meirongxiangmCollectionService;//美容项目收藏
    @Autowired
    private MeirongxiangmLiuyanService meirongxiangmLiuyanService;//美容项目留言
    @Autowired
    private MeirongxiangmOrderService meirongxiangmOrderService;//美容项目订单
    @Autowired
    private NewsService newsService;//公告通知
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("美容师".equals(role))
            params.put("meirongshiId",request.getSession().getAttribute("userId"));
        CommonUtil.checkMap(params);
        PageUtils page = meirongshiOrderService.queryPage(params);

        //字典表数据转换
        List<MeirongshiOrderView> list =(List<MeirongshiOrderView>)page.getList();
        for(MeirongshiOrderView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongshiOrderEntity meirongshiOrder = meirongshiOrderService.selectById(id);
        if(meirongshiOrder !=null){
            //entity转view
            MeirongshiOrderView view = new MeirongshiOrderView();
            BeanUtils.copyProperties( meirongshiOrder , view );//把实体数据重构到view中
            //级联表 美容师
            //级联表
            MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiOrder.getMeirongshiId());
            if(meirongshi != null){
            BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMeirongshiId(meirongshi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(meirongshiOrder.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody MeirongshiOrderEntity meirongshiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongshiOrder:{}",this.getClass().getName(),meirongshiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            meirongshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("美容师".equals(role))
            meirongshiOrder.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        meirongshiOrder.setCreateTime(new Date());
        meirongshiOrder.setInsertTime(new Date());
        meirongshiOrderService.insert(meirongshiOrder);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongshiOrderEntity meirongshiOrder, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meirongshiOrder:{}",this.getClass().getName(),meirongshiOrder.toString());
        MeirongshiOrderEntity oldMeirongshiOrderEntity = meirongshiOrderService.selectById(meirongshiOrder.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            meirongshiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("美容师".equals(role))
//            meirongshiOrder.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            meirongshiOrderService.updateById(meirongshiOrder);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeirongshiOrderEntity> oldMeirongshiOrderList =meirongshiOrderService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        meirongshiOrderService.deleteBatchIds(Arrays.asList(ids));

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //.eq("time", new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
        try {
            List<MeirongshiOrderEntity> meirongshiOrderList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            MeirongshiOrderEntity meirongshiOrderEntity = new MeirongshiOrderEntity();
//                            meirongshiOrderEntity.setMeirongshiOrderUuidNumber(data.get(0));                    //订单编号 要改的
//                            meirongshiOrderEntity.setMeirongshiId(Integer.valueOf(data.get(0)));   //美容师 要改的
//                            meirongshiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            meirongshiOrderEntity.setMeirongshiOrderTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            meirongshiOrderEntity.setMeirongshiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            meirongshiOrderEntity.setMeirongshiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            meirongshiOrderEntity.setMeirongshiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            meirongshiOrderEntity.setInsertTime(date);//时间
//                            meirongshiOrderEntity.setCreateTime(date);//时间
                            meirongshiOrderList.add(meirongshiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单编号
                                if(seachFields.containsKey("meirongshiOrderUuidNumber")){
                                    List<String> meirongshiOrderUuidNumber = seachFields.get("meirongshiOrderUuidNumber");
                                    meirongshiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> meirongshiOrderUuidNumber = new ArrayList<>();
                                    meirongshiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("meirongshiOrderUuidNumber",meirongshiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单编号
                        List<MeirongshiOrderEntity> meirongshiOrderEntities_meirongshiOrderUuidNumber = meirongshiOrderService.selectList(new EntityWrapper<MeirongshiOrderEntity>().in("meirongshi_order_uuid_number", seachFields.get("meirongshiOrderUuidNumber")));
                        if(meirongshiOrderEntities_meirongshiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MeirongshiOrderEntity s:meirongshiOrderEntities_meirongshiOrderUuidNumber){
                                repeatFields.add(s.getMeirongshiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        meirongshiOrderService.insertBatch(meirongshiOrderList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = meirongshiOrderService.queryPage(params);

        //字典表数据转换
        List<MeirongshiOrderView> list =(List<MeirongshiOrderView>)page.getList();
        for(MeirongshiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongshiOrderEntity meirongshiOrder = meirongshiOrderService.selectById(id);
            if(meirongshiOrder !=null){


                //entity转view
                MeirongshiOrderView view = new MeirongshiOrderView();
                BeanUtils.copyProperties( meirongshiOrder , view );//把实体数据重构到view中

                //级联表
                    MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiOrder.getMeirongshiId());
                if(meirongshi != null){
                    BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeirongshiId(meirongshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(meirongshiOrder.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody MeirongshiOrderEntity meirongshiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongshiOrder:{}",this.getClass().getName(),meirongshiOrder.toString());
            MeirongshiEntity meirongshiEntity = meirongshiService.selectById(meirongshiOrder.getMeirongshiId());
            if(meirongshiEntity == null){
                return R.error(511,"查不到该美容师");
            }
            // Double meirongshiNewMoney = meirongshiEntity.getMeirongshiNewMoney();

            if(false){
            }
            else if(meirongshiEntity.getMeirongshiNewMoney() == null){
                return R.error(511,"价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - meirongshiEntity.getMeirongshiNewMoney()*1;//余额
            buyJifen = new BigDecimal(meirongshiEntity.getMeirongshiPrice()).multiply(new BigDecimal(1)).doubleValue();//所获积分
            if(balance<0)
                return R.error(511,"余额不够支付");
            meirongshiOrder.setMeirongshiOrderTypes(101); //设置订单状态为已支付
            meirongshiOrder.setMeirongshiOrderTruePrice(meirongshiEntity.getMeirongshiNewMoney()*1); //设置实付价格
            meirongshiOrder.setYonghuId(userId); //设置订单支付人id
            meirongshiOrder.setMeirongshiOrderUuidNumber(String.valueOf(new Date().getTime()));
            meirongshiOrder.setMeirongshiOrderPaymentTypes(1);
            meirongshiOrder.setInsertTime(new Date());
            meirongshiOrder.setCreateTime(new Date());
                meirongshiOrderService.insert(meirongshiOrder);//新增订单
            //更新第一注册表
            yonghuEntity.setNewMoney(balance);//设置金额
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() + buyJifen); //设置总积分
            yonghuService.updateById(yonghuEntity);


            return R.ok();
    }


    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

            MeirongshiOrderEntity meirongshiOrder = meirongshiOrderService.selectById(id);//当前表service
            Integer meirongshiOrderPaymentTypes = meirongshiOrder.getMeirongshiOrderPaymentTypes();
            Integer meirongshiId = meirongshiOrder.getMeirongshiId();
            if(meirongshiId == null)
                return R.error(511,"查不到该美容师");
            MeirongshiEntity meirongshiEntity = meirongshiService.selectById(meirongshiId);
            if(meirongshiEntity == null)
                return R.error(511,"查不到该美容师");
            Double meirongshiNewMoney = meirongshiEntity.getMeirongshiNewMoney();
            if(meirongshiNewMoney == null)
                return R.error(511,"美容师价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
            return R.error(511,"用户金额不能为空");
            Double zhekou = 1.0;
            // 获取折扣
            Wrapper<DictionaryEntity> dictionary = new EntityWrapper<DictionaryEntity>()
                    .eq("dic_code", "huiyuandengji_types")
                    .eq("dic_name", "会员等级类型")
                    .eq("code_index", yonghuEntity.getHuiyuandengjiTypes())
                    ;
            DictionaryEntity dictionaryEntity = dictionaryService.selectOne(dictionary);
            if(dictionaryEntity != null ){
                zhekou = Double.valueOf(dictionaryEntity.getBeizhu());
            }

            //判断是什么支付方式 1代表余额 2代表积分
            if(meirongshiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = meirongshiEntity.getMeirongshiNewMoney() * 1  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                buyJifen = new BigDecimal(meirongshiEntity.getMeirongshiPrice()).multiply(new BigDecimal(1)).doubleValue();
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额
                if(yonghuEntity.getYonghuNewJifen() - buyJifen <0 )
                    return R.error("积分已经消费,无法退款！！！");
                yonghuEntity.setYonghuNewJifen(yonghuEntity.getYonghuNewJifen() - buyJifen); //设置现积分


            }


            meirongshiOrder.setMeirongshiOrderTypes(102);//设置订单状态为已退款
            meirongshiOrderService.updateAllColumnById(meirongshiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            meirongshiService.updateById(meirongshiEntity);//更新订单中美容师的信息

            return R.ok();
    }

    /**
     * 完成
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id  , HttpServletRequest request){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        MeirongshiOrderEntity  meirongshiOrderEntity = meirongshiOrderService.selectById(id);
        meirongshiOrderEntity.setMeirongshiOrderTypes(103);//设置订单状态为已完成
        meirongshiOrderService.updateById( meirongshiOrderEntity);

        return R.ok();
    }


}

