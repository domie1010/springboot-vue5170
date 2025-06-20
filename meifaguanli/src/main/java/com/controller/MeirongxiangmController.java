
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
 * 美容项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongxiangm")
public class MeirongxiangmController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongxiangmController.class);

    private static final String TABLE_NAME = "meirongxiangm";

    @Autowired
    private MeirongxiangmService meirongxiangmService;


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
    private MeirongshiOrderService meirongshiOrderService;//美容师预约
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
        params.put("meirongxiangmDeleteStart",1);params.put("meirongxiangmDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = meirongxiangmService.queryPage(params);

        //字典表数据转换
        List<MeirongxiangmView> list =(List<MeirongxiangmView>)page.getList();
        for(MeirongxiangmView c:list){
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
        MeirongxiangmEntity meirongxiangm = meirongxiangmService.selectById(id);
        if(meirongxiangm !=null){
            //entity转view
            MeirongxiangmView view = new MeirongxiangmView();
            BeanUtils.copyProperties( meirongxiangm , view );//把实体数据重构到view中
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
    public R save(@RequestBody MeirongxiangmEntity meirongxiangm, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongxiangm:{}",this.getClass().getName(),meirongxiangm.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MeirongxiangmEntity> queryWrapper = new EntityWrapper<MeirongxiangmEntity>()
            .eq("meirongxiangm_name", meirongxiangm.getMeirongxiangmName())
            .eq("zan_number", meirongxiangm.getZanNumber())
            .eq("cai_number", meirongxiangm.getCaiNumber())
            .eq("meirongxiangm_types", meirongxiangm.getMeirongxiangmTypes())
            .eq("meirongxiangm_price", meirongxiangm.getMeirongxiangmPrice())
            .eq("meirongxiangm_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongxiangmEntity meirongxiangmEntity = meirongxiangmService.selectOne(queryWrapper);
        if(meirongxiangmEntity==null){
            meirongxiangm.setZanNumber(1);
            meirongxiangm.setCaiNumber(1);
            meirongxiangm.setMeirongxiangmClicknum(1);
            meirongxiangm.setMeirongxiangmDelete(1);
            meirongxiangm.setInsertTime(new Date());
            meirongxiangm.setCreateTime(new Date());
            meirongxiangmService.insert(meirongxiangm);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongxiangmEntity meirongxiangm, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meirongxiangm:{}",this.getClass().getName(),meirongxiangm.toString());
        MeirongxiangmEntity oldMeirongxiangmEntity = meirongxiangmService.selectById(meirongxiangm.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(meirongxiangm.getMeirongxiangmPhoto()) || "null".equals(meirongxiangm.getMeirongxiangmPhoto())){
                meirongxiangm.setMeirongxiangmPhoto(null);
        }
        if("".equals(meirongxiangm.getMeirongxiangmContent()) || "null".equals(meirongxiangm.getMeirongxiangmContent())){
                meirongxiangm.setMeirongxiangmContent(null);
        }

            meirongxiangmService.updateById(meirongxiangm);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeirongxiangmEntity> oldMeirongxiangmList =meirongxiangmService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<MeirongxiangmEntity> list = new ArrayList<>();
        for(Integer id:ids){
            MeirongxiangmEntity meirongxiangmEntity = new MeirongxiangmEntity();
            meirongxiangmEntity.setId(id);
            meirongxiangmEntity.setMeirongxiangmDelete(2);
            list.add(meirongxiangmEntity);
        }
        if(list != null && list.size() >0){
            meirongxiangmService.updateBatchById(list);
        }

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
            List<MeirongxiangmEntity> meirongxiangmList = new ArrayList<>();//上传的东西
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
                            MeirongxiangmEntity meirongxiangmEntity = new MeirongxiangmEntity();
//                            meirongxiangmEntity.setMeirongxiangmName(data.get(0));                    //美容项目名称 要改的
//                            meirongxiangmEntity.setMeirongxiangmPhoto("");//详情和图片
//                            meirongxiangmEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            meirongxiangmEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            meirongxiangmEntity.setMeirongxiangmNewMoney(data.get(0));                    //价格 要改的
//                            meirongxiangmEntity.setMeirongxiangmTypes(Integer.valueOf(data.get(0)));   //美容项目类型 要改的
//                            meirongxiangmEntity.setMeirongxiangmPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            meirongxiangmEntity.setMeirongxiangmClicknum(Integer.valueOf(data.get(0)));   //美容项目热度 要改的
//                            meirongxiangmEntity.setMeirongxiangmContent("");//详情和图片
//                            meirongxiangmEntity.setMeirongxiangmDelete(1);//逻辑删除字段
//                            meirongxiangmEntity.setInsertTime(date);//时间
//                            meirongxiangmEntity.setCreateTime(date);//时间
                            meirongxiangmList.add(meirongxiangmEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        meirongxiangmService.insertBatch(meirongxiangmList);
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
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<MeirongxiangmView> returnMeirongxiangmViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("meirongxiangmYesnoTypes",2);
        PageUtils pageUtils = meirongxiangmOrderService.queryPage(params1);
        List<MeirongxiangmOrderView> orderViewsList =(List<MeirongxiangmOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(MeirongxiangmOrderView orderView:orderViewsList){
            Integer meirongxiangmTypes = orderView.getMeirongxiangmTypes();
            if(typeMap.containsKey(meirongxiangmTypes)){
                typeMap.put(meirongxiangmTypes,typeMap.get(meirongxiangmTypes)+1);
            }else{
                typeMap.put(meirongxiangmTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("meirongxiangmTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("meirongxiangmYesnoTypes",2);
            PageUtils pageUtils1 = meirongxiangmService.queryPage(params2);
            List<MeirongxiangmView> meirongxiangmViewList =(List<MeirongxiangmView>)pageUtils1.getList();
            returnMeirongxiangmViewList.addAll(meirongxiangmViewList);
            if(returnMeirongxiangmViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("meirongxiangmYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = meirongxiangmService.queryPage(params);
        if(returnMeirongxiangmViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnMeirongxiangmViewList.size();//要添加的数量
            List<MeirongxiangmView> meirongxiangmViewList =(List<MeirongxiangmView>)page.getList();
            for(MeirongxiangmView meirongxiangmView:meirongxiangmViewList){
                Boolean addFlag = true;
                for(MeirongxiangmView returnMeirongxiangmView:returnMeirongxiangmViewList){
                    if(returnMeirongxiangmView.getId().intValue() ==meirongxiangmView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnMeirongxiangmViewList.add(meirongxiangmView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnMeirongxiangmViewList = returnMeirongxiangmViewList.subList(0, limit);
        }

        for(MeirongxiangmView c:returnMeirongxiangmViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnMeirongxiangmViewList);
        return R.ok().put("data", page);
    }

    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = meirongxiangmService.queryPage(params);

        //字典表数据转换
        List<MeirongxiangmView> list =(List<MeirongxiangmView>)page.getList();
        for(MeirongxiangmView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongxiangmEntity meirongxiangm = meirongxiangmService.selectById(id);
            if(meirongxiangm !=null){

                //点击数量加1
                meirongxiangm.setMeirongxiangmClicknum(meirongxiangm.getMeirongxiangmClicknum()+1);
                meirongxiangmService.updateById(meirongxiangm);

                //entity转view
                MeirongxiangmView view = new MeirongxiangmView();
                BeanUtils.copyProperties( meirongxiangm , view );//把实体数据重构到view中

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
    public R add(@RequestBody MeirongxiangmEntity meirongxiangm, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongxiangm:{}",this.getClass().getName(),meirongxiangm.toString());
        Wrapper<MeirongxiangmEntity> queryWrapper = new EntityWrapper<MeirongxiangmEntity>()
            .eq("meirongxiangm_name", meirongxiangm.getMeirongxiangmName())
            .eq("zan_number", meirongxiangm.getZanNumber())
            .eq("cai_number", meirongxiangm.getCaiNumber())
            .eq("meirongxiangm_types", meirongxiangm.getMeirongxiangmTypes())
            .eq("meirongxiangm_price", meirongxiangm.getMeirongxiangmPrice())
            .eq("meirongxiangm_clicknum", meirongxiangm.getMeirongxiangmClicknum())
            .eq("meirongxiangm_delete", meirongxiangm.getMeirongxiangmDelete())
//            .notIn("meirongxiangm_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongxiangmEntity meirongxiangmEntity = meirongxiangmService.selectOne(queryWrapper);
        if(meirongxiangmEntity==null){
                meirongxiangm.setZanNumber(1);
                meirongxiangm.setCaiNumber(1);
            meirongxiangm.setMeirongxiangmClicknum(1);
            meirongxiangm.setMeirongxiangmDelete(1);
            meirongxiangm.setInsertTime(new Date());
            meirongxiangm.setCreateTime(new Date());
        meirongxiangmService.insert(meirongxiangm);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

