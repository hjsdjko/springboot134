package com.cl.dao;

import com.cl.entity.JiuzhuzhanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiuzhuzhanView;


/**
 * 救助站
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface JiuzhuzhanDao extends BaseMapper<JiuzhuzhanEntity> {
	
	List<JiuzhuzhanView> selectListView(@Param("ew") Wrapper<JiuzhuzhanEntity> wrapper);

	List<JiuzhuzhanView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhuzhanEntity> wrapper);
	
	JiuzhuzhanView selectView(@Param("ew") Wrapper<JiuzhuzhanEntity> wrapper);
	

}
