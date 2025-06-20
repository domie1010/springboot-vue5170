
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
 * 美容师留言
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongshiLiuyan")
public class MeirongshiLiuyanController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongshiLiuyanController.class);

    private static final String TABLE_NAME = "meirongshiLiuyan";

    @Autowired
    private MeirongshiLiuyanService meirongshiLiuyanService;


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
        PageUtils page = meirongshiLiuyanService.queryPage(params);

        //字典表数据转换
        List<MeirongshiLiuyanView> list =(List<MeirongshiLiuyanView>)page.getList();
        for(MeirongshiLiuyanView c:list){
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
        MeirongshiLiuyanEntity meirongshiLiuyan = meirongshiLiuyanService.selectById(id);
        if(meirongshiLiuyan !=null){
            //entity转view
            MeirongshiLiuyanView view = new MeirongshiLiuyanView();
            BeanUtils.copyProperties( meirongshiLiuyan , view );//把实体数据重构到view中
            //级联表 美容师
            //级联表
            MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiLiuyan.getMeirongshiId());
            if(meirongshi != null){
            BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setMeirongshiId(meirongshi.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(meirongshiLiuyan.getYonghuId());
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
    public R save(@RequestBody MeirongshiLiuyanEntity meirongshiLiuyan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongshiLiuyan:{}",this.getClass().getName(),meirongshiLiuyan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            meirongshiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("美容师".equals(role))
            meirongshiLiuyan.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        meirongshiLiuyan.setCreateTime(new Date());
        meirongshiLiuyan.setInsertTime(new Date());
        meirongshiLiuyanService.insert(meirongshiLiuyan);

        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongshiLiuyanEntity meirongshiLiuyan, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meirongshiLiuyan:{}",this.getClass().getName(),meirongshiLiuyan.toString());
        MeirongshiLiuyanEntity oldMeirongshiLiuyanEntity = meirongshiLiuyanService.selectById(meirongshiLiuyan.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            meirongshiLiuyan.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("美容师".equals(role))
//            meirongshiLiuyan.setMeirongshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(meirongshiLiuyan.getMeirongshiLiuyanText()) || "null".equals(meirongshiLiuyan.getMeirongshiLiuyanText())){
                meirongshiLiuyan.setMeirongshiLiuyanText(null);
        }

            meirongshiLiuyanService.updateById(meirongshiLiuyan);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeirongshiLiuyanEntity> oldMeirongshiLiuyanList =meirongshiLiuyanService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        meirongshiLiuyanService.deleteBatchIds(Arrays.asList(ids));

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
            List<MeirongshiLiuyanEntity> meirongshiLiuyanList = new ArrayList<>();//上传的东西
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
                            MeirongshiLiuyanEntity meirongshiLiuyanEntity = new MeirongshiLiuyanEntity();
//                            meirongshiLiuyanEntity.setMeirongshiId(Integer.valueOf(data.get(0)));   //美容师 要改的
//                            meirongshiLiuyanEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            meirongshiLiuyanEntity.setMeirongshiLiuyanText(data.get(0));                    //留言内容 要改的
//                            meirongshiLiuyanEntity.setInsertTime(date);//时间
//                            meirongshiLiuyanEntity.setCreateTime(date);//时间
                            meirongshiLiuyanList.add(meirongshiLiuyanEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        meirongshiLiuyanService.insertBatch(meirongshiLiuyanList);
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
        PageUtils page = meirongshiLiuyanService.queryPage(params);

        //字典表数据转换
        List<MeirongshiLiuyanView> list =(List<MeirongshiLiuyanView>)page.getList();
        for(MeirongshiLiuyanView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongshiLiuyanEntity meirongshiLiuyan = meirongshiLiuyanService.selectById(id);
            if(meirongshiLiuyan !=null){


                //entity转view
                MeirongshiLiuyanView view = new MeirongshiLiuyanView();
                BeanUtils.copyProperties( meirongshiLiuyan , view );//把实体数据重构到view中

                //级联表
                    MeirongshiEntity meirongshi = meirongshiService.selectById(meirongshiLiuyan.getMeirongshiId());
                if(meirongshi != null){
                    BeanUtils.copyProperties( meirongshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "username", "password", "newMoney", "yonghuId"
, "meirongshiId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setMeirongshiId(meirongshi.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(meirongshiLiuyan.getYonghuId());
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
    public R add(@RequestBody MeirongshiLiuyanEntity meirongshiLiuyan, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongshiLiuyan:{}",this.getClass().getName(),meirongshiLiuyan.toString());
        meirongshiLiuyan.setCreateTime(new Date());
        meirongshiLiuyan.setInsertTime(new Date());
        meirongshiLiuyanService.insert(meirongshiLiuyan);

            return R.ok();
        }

}

