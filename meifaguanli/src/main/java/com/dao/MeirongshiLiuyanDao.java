package com.dao;

import com.entity.MeirongshiLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongshiLiuyanView;

/**
 * 美容师留言 Dao 接口
 *
 * @author 
 */
public interface MeirongshiLiuyanDao extends BaseMapper<MeirongshiLiuyanEntity> {

   List<MeirongshiLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
