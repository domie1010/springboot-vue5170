package com.dao;

import com.entity.MeirongxiangmOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongxiangmOrderView;

/**
 * 美容项目订单 Dao 接口
 *
 * @author 
 */
public interface MeirongxiangmOrderDao extends BaseMapper<MeirongxiangmOrderEntity> {

   List<MeirongxiangmOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
