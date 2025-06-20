
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
 * 美容师
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/meirongshi")
public class MeirongshiController {
    private static final Logger logger = LoggerFactory.getLogger(MeirongshiController.class);

    private static final String TABLE_NAME = "meirongshi";

    @Autowired
    private MeirongshiService meirongshiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private MeirongshiCollectionService meirongshiCollectionService;//美容师收藏
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
        PageUtils page = meirongshiService.queryPage(params);

        //字典表数据转换
        List<MeirongshiView> list =(List<MeirongshiView>)page.getList();
        for(MeirongshiView c:list){
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
        MeirongshiEntity meirongshi = meirongshiService.selectById(id);
        if(meirongshi !=null){
            //entity转view
            MeirongshiView view = new MeirongshiView();
            BeanUtils.copyProperties( meirongshi , view );//把实体数据重构到view中
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
    public R save(@RequestBody MeirongshiEntity meirongshi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,meirongshi:{}",this.getClass().getName(),meirongshi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<MeirongshiEntity> queryWrapper = new EntityWrapper<MeirongshiEntity>()
            .eq("username", meirongshi.getUsername())
            .or()
            .eq("meirongshi_phone", meirongshi.getMeirongshiPhone())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongshiEntity meirongshiEntity = meirongshiService.selectOne(queryWrapper);
        if(meirongshiEntity==null){
            meirongshi.setCreateTime(new Date());
            meirongshi.setPassword("123456");
            meirongshiService.insert(meirongshi);
            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody MeirongshiEntity meirongshi, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,meirongshi:{}",this.getClass().getName(),meirongshi.toString());
        MeirongshiEntity oldMeirongshiEntity = meirongshiService.selectById(meirongshi.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(meirongshi.getMeirongshiPhoto()) || "null".equals(meirongshi.getMeirongshiPhoto())){
                meirongshi.setMeirongshiPhoto(null);
        }
        if("".equals(meirongshi.getMeirongshiContent()) || "null".equals(meirongshi.getMeirongshiContent())){
                meirongshi.setMeirongshiContent(null);
        }

            meirongshiService.updateById(meirongshi);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<MeirongshiEntity> oldMeirongshiList =meirongshiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        meirongshiService.deleteBatchIds(Arrays.asList(ids));

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
            List<MeirongshiEntity> meirongshiList = new ArrayList<>();//上传的东西
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
                            MeirongshiEntity meirongshiEntity = new MeirongshiEntity();
//                            meirongshiEntity.setUsername(data.get(0));                    //账户 要改的
//                            meirongshiEntity.setPassword("123456");//密码
//                            meirongshiEntity.setMeirongshiName(data.get(0));                    //美容师名称 要改的
//                            meirongshiEntity.setMeirongshiPhone(data.get(0));                    //联系方式 要改的
//                            meirongshiEntity.setMeirongshiEmail(data.get(0));                    //邮箱 要改的
//                            meirongshiEntity.setMeirongshiNewMoney(data.get(0));                    //价格 要改的
//                            meirongshiEntity.setMeirongshiPhoto("");//详情和图片
//                            meirongshiEntity.setMeirongshiPrice(Integer.valueOf(data.get(0)));   //购买获得积分 要改的
//                            meirongshiEntity.setMeirongshiXingjiTypes(Integer.valueOf(data.get(0)));   //美容师类型 要改的
//                            meirongshiEntity.setMeirongshiContent("");//详情和图片
//                            meirongshiEntity.setCreateTime(date);//时间
                            meirongshiList.add(meirongshiEntity);


                            //把要查询是否重复的字段放入map中
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //联系方式
                                if(seachFields.containsKey("meirongshiPhone")){
                                    List<String> meirongshiPhone = seachFields.get("meirongshiPhone");
                                    meirongshiPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> meirongshiPhone = new ArrayList<>();
                                    meirongshiPhone.add(data.get(0));//要改的
                                    seachFields.put("meirongshiPhone",meirongshiPhone);
                                }
                        }

                        //查询是否重复
                         //账户
                        List<MeirongshiEntity> meirongshiEntities_username = meirongshiService.selectList(new EntityWrapper<MeirongshiEntity>().in("username", seachFields.get("username")));
                        if(meirongshiEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MeirongshiEntity s:meirongshiEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //联系方式
                        List<MeirongshiEntity> meirongshiEntities_meirongshiPhone = meirongshiService.selectList(new EntityWrapper<MeirongshiEntity>().in("meirongshi_phone", seachFields.get("meirongshiPhone")));
                        if(meirongshiEntities_meirongshiPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(MeirongshiEntity s:meirongshiEntities_meirongshiPhone){
                                repeatFields.add(s.getMeirongshiPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        meirongshiService.insertBatch(meirongshiList);
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
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        MeirongshiEntity meirongshi = meirongshiService.selectOne(new EntityWrapper<MeirongshiEntity>().eq("username", username));
        if(meirongshi==null || !meirongshi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        String token = tokenService.generateToken(meirongshi.getId(),username, "meirongshi", "美容师");
        R r = R.ok();
        r.put("token", token);
        r.put("role","美容师");
        r.put("username",meirongshi.getMeirongshiName());
        r.put("tableName","meirongshi");
        r.put("userId",meirongshi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody MeirongshiEntity meirongshi, HttpServletRequest request) {
//    	ValidatorUtils.validateEntity(user);
        Wrapper<MeirongshiEntity> queryWrapper = new EntityWrapper<MeirongshiEntity>()
            .eq("username", meirongshi.getUsername())
            .or()
            .eq("meirongshi_phone", meirongshi.getMeirongshiPhone())
            ;
        MeirongshiEntity meirongshiEntity = meirongshiService.selectOne(queryWrapper);
        if(meirongshiEntity != null)
            return R.error("账户或者联系方式已经被使用");
        meirongshi.setMeirongshiNewMoney(0.0);
        meirongshi.setCreateTime(new Date());
        meirongshiService.insert(meirongshi);

        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id, HttpServletRequest request) {
        MeirongshiEntity meirongshi = meirongshiService.selectById(id);
        meirongshi.setPassword("123456");
        meirongshiService.updateById(meirongshi);
        return R.ok();
    }

	/**
	 * 修改密码
	 */
	@GetMapping(value = "/updatePassword")
	public R updatePassword(String  oldPassword, String  newPassword, HttpServletRequest request) {
        MeirongshiEntity meirongshi = meirongshiService.selectById((Integer)request.getSession().getAttribute("userId"));
		if(newPassword == null){
			return R.error("新密码不能为空") ;
		}
		if(!oldPassword.equals(meirongshi.getPassword())){
			return R.error("原密码输入错误");
		}
		if(newPassword.equals(meirongshi.getPassword())){
			return R.error("新密码不能和原密码一致") ;
		}
        meirongshi.setPassword(newPassword);
		meirongshiService.updateById(meirongshi);
		return R.ok();
	}



    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        MeirongshiEntity meirongshi = meirongshiService.selectOne(new EntityWrapper<MeirongshiEntity>().eq("username", username));
        if(meirongshi!=null){
            meirongshi.setPassword("123456");
            meirongshiService.updateById(meirongshi);
            return R.ok();
        }else{
           return R.error("账号不存在");
        }
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrMeirongshi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        MeirongshiEntity meirongshi = meirongshiService.selectById(id);
        if(meirongshi !=null){
            //entity转view
            MeirongshiView view = new MeirongshiView();
            BeanUtils.copyProperties( meirongshi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }


    /**
    * 个性推荐
    */
    @IgnoreAuth
    @RequestMapping("/gexingtuijian")
    public R gexingtuijian(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("gexingtuijian方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        CommonUtil.checkMap(params);
        List<MeirongshiView> returnMeirongshiViewList = new ArrayList<>();

        //查询订单
        Map<String, Object> params1 = new HashMap<>(params);params1.put("sort","id");params1.put("yonghuId",request.getSession().getAttribute("userId"));
        params1.put("shangxiaTypes",1);
        params1.put("meirongshiYesnoTypes",2);
        PageUtils pageUtils = meirongshiOrderService.queryPage(params1);
        List<MeirongshiOrderView> orderViewsList =(List<MeirongshiOrderView>)pageUtils.getList();
        Map<Integer,Integer> typeMap=new HashMap<>();//购买的类型list
        for(MeirongshiOrderView orderView:orderViewsList){
            Integer meirongshiTypes = orderView.getMeirongshiXingjiTypes();
            if(typeMap.containsKey(meirongshiTypes)){
                typeMap.put(meirongshiTypes,typeMap.get(meirongshiTypes)+1);
            }else{
                typeMap.put(meirongshiTypes,1);
            }
        }
        List<Integer> typeList = new ArrayList<>();//排序后的有序的类型 按最多到最少
        typeMap.entrySet().stream().sorted((o1, o2) -> o2.getValue() - o1.getValue()).forEach(e -> typeList.add(e.getKey()));//排序
        Integer limit = Integer.valueOf(String.valueOf(params.get("limit")));
        for(Integer type:typeList){
            Map<String, Object> params2 = new HashMap<>(params);params2.put("meirongshiTypes",type);
            params2.put("shangxiaTypes",1);
            params2.put("meirongshiYesnoTypes",2);
            PageUtils pageUtils1 = meirongshiService.queryPage(params2);
            List<MeirongshiView> meirongshiViewList =(List<MeirongshiView>)pageUtils1.getList();
            returnMeirongshiViewList.addAll(meirongshiViewList);
            if(returnMeirongshiViewList.size()>= limit) break;//返回的推荐数量大于要的数量 跳出循环
        }
        params.put("shangxiaTypes",1);
        params.put("meirongshiYesnoTypes",2);
        //正常查询出来商品,用于补全推荐缺少的数据
        PageUtils page = meirongshiService.queryPage(params);
        if(returnMeirongshiViewList.size()<limit){//返回数量还是小于要求数量
            int toAddNum = limit - returnMeirongshiViewList.size();//要添加的数量
            List<MeirongshiView> meirongshiViewList =(List<MeirongshiView>)page.getList();
            for(MeirongshiView meirongshiView:meirongshiViewList){
                Boolean addFlag = true;
                for(MeirongshiView returnMeirongshiView:returnMeirongshiViewList){
                    if(returnMeirongshiView.getId().intValue() ==meirongshiView.getId().intValue()) addFlag=false;//返回的数据中已存在此商品
                }
                if(addFlag){
                    toAddNum=toAddNum-1;
                    returnMeirongshiViewList.add(meirongshiView);
                    if(toAddNum==0) break;//够数量了
                }
            }
        }else {
            returnMeirongshiViewList = returnMeirongshiViewList.subList(0, limit);
        }

        for(MeirongshiView c:returnMeirongshiViewList)
            dictionaryService.dictionaryConvert(c, request);
        page.setList(returnMeirongshiViewList);
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
        PageUtils page = meirongshiService.queryPage(params);

        //字典表数据转换
        List<MeirongshiView> list =(List<MeirongshiView>)page.getList();
        for(MeirongshiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Integer id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        MeirongshiEntity meirongshi = meirongshiService.selectById(id);
            if(meirongshi !=null){


                //entity转view
                MeirongshiView view = new MeirongshiView();
                BeanUtils.copyProperties( meirongshi , view );//把实体数据重构到view中

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
    public R add(@RequestBody MeirongshiEntity meirongshi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,meirongshi:{}",this.getClass().getName(),meirongshi.toString());
        Wrapper<MeirongshiEntity> queryWrapper = new EntityWrapper<MeirongshiEntity>()
            .eq("username", meirongshi.getUsername())
            .or()
            .eq("meirongshi_phone", meirongshi.getMeirongshiPhone())
//            .notIn("meirongshi_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        MeirongshiEntity meirongshiEntity = meirongshiService.selectOne(queryWrapper);
        if(meirongshiEntity==null){
            meirongshi.setCreateTime(new Date());
            meirongshi.setPassword("123456");
        meirongshiService.insert(meirongshi);

            return R.ok();
        }else {
            return R.error(511,"账户或者联系方式已经被使用");
        }
    }

}

