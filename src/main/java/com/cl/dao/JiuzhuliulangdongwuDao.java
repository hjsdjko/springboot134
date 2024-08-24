package com.cl.dao;

import com.cl.entity.JiuzhuliulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiuzhuliulangdongwuView;


/**
 * 救助流浪动物
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface JiuzhuliulangdongwuDao extends BaseMapper<JiuzhuliulangdongwuEntity> {
	
	List<JiuzhuliulangdongwuView> selectListView(@Param("ew") Wrapper<JiuzhuliulangdongwuEntity> wrapper);

	List<JiuzhuliulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<JiuzhuliulangdongwuEntity> wrapper);
	
	JiuzhuliulangdongwuView selectView(@Param("ew") Wrapper<JiuzhuliulangdongwuEntity> wrapper);
	

}
