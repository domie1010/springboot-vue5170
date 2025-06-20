package com.dao;

import com.entity.MeirongshiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongshiView;

/**
 * 美容师 Dao 接口
 *
 * @author 
 */
public interface MeirongshiDao extends BaseMapper<MeirongshiEntity> {

   List<MeirongshiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
