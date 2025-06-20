package com.dao;

import com.entity.MeirongxiangmCollectionEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongxiangmCollectionView;

/**
 * 美容项目收藏 Dao 接口
 *
 * @author 
 */
public interface MeirongxiangmCollectionDao extends BaseMapper<MeirongxiangmCollectionEntity> {

   List<MeirongxiangmCollectionView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
