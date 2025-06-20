import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import meirongshi from '@/views/modules/meirongshi/list'
    import meirongshiCollection from '@/views/modules/meirongshiCollection/list'
    import meirongshiLiuyan from '@/views/modules/meirongshiLiuyan/list'
    import meirongshiOrder from '@/views/modules/meirongshiOrder/list'
    import meirongxiangm from '@/views/modules/meirongxiangm/list'
    import meirongxiangmCollection from '@/views/modules/meirongxiangmCollection/list'
    import meirongxiangmLiuyan from '@/views/modules/meirongxiangmLiuyan/list'
    import meirongxiangmOrder from '@/views/modules/meirongxiangmOrder/list'
    import news from '@/views/modules/news/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryHuiyuandengji from '@/views/modules/dictionaryHuiyuandengji/list'
    import dictionaryMeirongshiCollection from '@/views/modules/dictionaryMeirongshiCollection/list'
    import dictionaryMeirongshiOrder from '@/views/modules/dictionaryMeirongshiOrder/list'
    import dictionaryMeirongshiOrderPayment from '@/views/modules/dictionaryMeirongshiOrderPayment/list'
    import dictionaryMeirongshiXingji from '@/views/modules/dictionaryMeirongshiXingji/list'
    import dictionaryMeirongxiangm from '@/views/modules/dictionaryMeirongxiangm/list'
    import dictionaryMeirongxiangmCollection from '@/views/modules/dictionaryMeirongxiangmCollection/list'
    import dictionaryMeirongxiangmOrder from '@/views/modules/dictionaryMeirongxiangmOrder/list'
    import dictionaryMeirongxiangmOrderPayment from '@/views/modules/dictionaryMeirongxiangmOrderPayment/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryHuiyuandengji',
        name: '会员等级类型',
        component: dictionaryHuiyuandengji
    }
    ,{
        path: '/dictionaryMeirongshiCollection',
        name: '收藏表类型',
        component: dictionaryMeirongshiCollection
    }
    ,{
        path: '/dictionaryMeirongshiOrder',
        name: '订单类型',
        component: dictionaryMeirongshiOrder
    }
    ,{
        path: '/dictionaryMeirongshiOrderPayment',
        name: '订单支付类型',
        component: dictionaryMeirongshiOrderPayment
    }
    ,{
        path: '/dictionaryMeirongshiXingji',
        name: '美容师类型',
        component: dictionaryMeirongshiXingji
    }
    ,{
        path: '/dictionaryMeirongxiangm',
        name: '美容项目类型',
        component: dictionaryMeirongxiangm
    }
    ,{
        path: '/dictionaryMeirongxiangmCollection',
        name: '收藏表类型',
        component: dictionaryMeirongxiangmCollection
    }
    ,{
        path: '/dictionaryMeirongxiangmOrder',
        name: '订单类型',
        component: dictionaryMeirongxiangmOrder
    }
    ,{
        path: '/dictionaryMeirongxiangmOrderPayment',
        name: '订单支付类型',
        component: dictionaryMeirongxiangmOrderPayment
    }
    ,{
        path: '/dictionaryNews',
        name: '公告类型',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/meirongshi',
        name: '美容师',
        component: meirongshi
      }
    ,{
        path: '/meirongshiCollection',
        name: '美容师收藏',
        component: meirongshiCollection
      }
    ,{
        path: '/meirongshiLiuyan',
        name: '美容师留言',
        component: meirongshiLiuyan
      }
    ,{
        path: '/meirongshiOrder',
        name: '美容师预约',
        component: meirongshiOrder
      }
    ,{
        path: '/meirongxiangm',
        name: '美容项目',
        component: meirongxiangm
      }
    ,{
        path: '/meirongxiangmCollection',
        name: '美容项目收藏',
        component: meirongxiangmCollection
      }
    ,{
        path: '/meirongxiangmLiuyan',
        name: '美容项目留言',
        component: meirongxiangmLiuyan
      }
    ,{
        path: '/meirongxiangmOrder',
        name: '美容项目订单',
        component: meirongxiangmOrder
      }
    ,{
        path: '/news',
        name: '公告通知',
        component: news
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
