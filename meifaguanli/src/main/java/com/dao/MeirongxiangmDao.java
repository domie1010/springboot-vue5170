package com.dao;

import com.entity.MeirongxiangmEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.MeirongxiangmView;

/**
 * 美容项目 Dao 接口
 *
 * @author 
 */
public interface MeirongxiangmDao extends BaseMapper<MeirongxiangmEntity> {

   List<MeirongxiangmView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
