package com.cl.dao;

import com.cl.entity.DiscussxunzhaoliulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxunzhaoliulangdongwuView;


/**
 * 寻找流浪动物评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DiscussxunzhaoliulangdongwuDao extends BaseMapper<DiscussxunzhaoliulangdongwuEntity> {
	
	List<DiscussxunzhaoliulangdongwuView> selectListView(@Param("ew") Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);

	List<DiscussxunzhaoliulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);
	
	DiscussxunzhaoliulangdongwuView selectView(@Param("ew") Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);
	

}
