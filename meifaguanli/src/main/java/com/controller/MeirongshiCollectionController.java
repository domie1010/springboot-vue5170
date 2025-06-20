
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
 * 美容师收藏
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongshiCollection")
public class MeirongshiCollectionController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongshiCollectionController.class);

    private static final String TABLE_NAME = "meirongshiCollection";

    @Autowired
    private MeirongshiCollectionService meirongshiCollectionService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private MeirongshiService meirongshiService;//美容师
    @Autowired
    private MeirongshiLiuyanService meirongshiLiuyanService;//美容师留言
    @Autowired
    private MeirongshiOrderService meirongshiOrderService;//美容师预约
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
        PageUtils page = meirongshiCollectionService.queryPage(params);

        //字典表数据转换
        List<MeirongshiCollectionView> list =(List<MeirongshiCollectionView>)page.getList();
        for(MeirongshiCollectionView c:list){
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
        MeirongshiCollectionEntity meirongshiCollection = meirongshiCollectionService.selectById(id);
        if(meirongshiCollection !=null){
            //entity转view
            MeirongshiCollectionView view = new MeirongshiCollectionView();
            BeanUtils.copyProperties( meirongshiCollection , view );//把实体数据重构到view中
            //级联表 美容师
            //级联表
            MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiCollection.getMeirongshiId());
            if(meirongshi != null){
            BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMeirongshiId(meirongshi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(meirongshiCollection.getYonghuId());
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
    public R save(@RequestBody MeirongshiCollectionEntity meirongshiCollection, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongshiCollection:{}",this.getClass().getName(),meirongshiCollection.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            meirongshiCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("美容师".equals(role))
            meirongshiCollection.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<MeirongshiCollectionEntity> queryWrapper = new EntityWrapper<MeirongshiCollectionEntity>()
            .eq("meirongshi_id", meirongshiCollection.getMeirongshiId())
            .eq("yonghu_id", meirongshiCollection.getYonghuId())
            .eq("meirongshi_collection_types", meirongshiCollection.getMeirongshiCollectionTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongshiCollectionEntity meirongshiCollectionEntity = meirongshiCollectionService.selectOne(queryWrapper);
        if(meirongshiCollectionEntity==null){
            meirongshiCollection.setInsertTime(new Date());
            meirongshiCollection.setCreateTime(new Date());
            meirongshiCollectionService.insert(meirongshiCollection);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongshiCollectionEntity meirongshiCollection, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meirongshiCollection:{}",this.getClass().getName(),meirongshiCollection.toString());
        MeirongshiCollectionEntity oldMeirongshiCollectionEntity = meirongshiCollectionService.selectById(meirongshiCollection.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            meirongshiCollection.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("美容师".equals(role))
//            meirongshiCollection.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            meirongshiCollectionService.updateById(meirongshiCollection);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeirongshiCollectionEntity> oldMeirongshiCollectionList =meirongshiCollectionService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        meirongshiCollectionService.deleteBatchIds(Arrays.asList(ids));

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
            List<MeirongshiCollectionEntity> meirongshiCollectionList = new ArrayList<>();//上传的东西
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
                            MeirongshiCollectionEntity meirongshiCollectionEntity = new MeirongshiCollectionEntity();
//                            meirongshiCollectionEntity.setMeirongshiId(Integer.valueOf(data.get(0)));   //美容师 要改的
//                            meirongshiCollectionEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            meirongshiCollectionEntity.setMeirongshiCollectionTypes(Integer.valueOf(data.get(0)));   //类型 要改的
//                            meirongshiCollectionEntity.setInsertTime(date);//时间
//                            meirongshiCollectionEntity.setCreateTime(date);//时间
                            meirongshiCollectionList.add(meirongshiCollectionEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        meirongshiCollectionService.insertBatch(meirongshiCollectionList);
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
        PageUtils page = meirongshiCollectionService.queryPage(params);

        //字典表数据转换
        List<MeirongshiCollectionView> list =(List<MeirongshiCollectionView>)page.getList();
        for(MeirongshiCollectionView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongshiCollectionEntity meirongshiCollection = meirongshiCollectionService.selectById(id);
            if(meirongshiCollection !=null){


                //entity转view
                MeirongshiCollectionView view = new MeirongshiCollectionView();
                BeanUtils.copyProperties( meirongshiCollection , view );//把实体数据重构到view中

                //级联表
                    MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiCollection.getMeirongshiId());
                if(meirongshi != null){
                    BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeirongshiId(meirongshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(meirongshiCollection.getYonghuId());
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
    public R add(@RequestBody MeirongshiCollectionEntity meirongshiCollection, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongshiCollection:{}",this.getClass().getName(),meirongshiCollection.toString());
        Wrapper<MeirongshiCollectionEntity> queryWrapper = new EntityWrapper<MeirongshiCollectionEntity>()
            .eq("meirongshi_id", meirongshiCollection.getMeirongshiId())
            .eq("yonghu_id", meirongshiCollection.getYonghuId())
            .eq("meirongshi_collection_types", meirongshiCollection.getMeirongshiCollectionTypes())
//            .notIn("meirongshi_collection_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongshiCollectionEntity meirongshiCollectionEntity = meirongshiCollectionService.selectOne(queryWrapper);
        if(meirongshiCollectionEntity==null){
            meirongshiCollection.setInsertTime(new Date());
            meirongshiCollection.setCreateTime(new Date());
        meirongshiCollectionService.insert(meirongshiCollection);

            return R.ok();
        }else {
            return R.error(511,"您已经收藏过了");
        }
    }

}

