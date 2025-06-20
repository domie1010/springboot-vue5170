package com.dao;

import com.entity.MeirongshiCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongshiCollectionView;

/**
 * 美容师收藏 Dao 接口
 *
 * @author 
 */
public interface MeirongshiCollectionDao extends BaseMapper<MeirongshiCollectionEntity> {

   List<MeirongshiCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
