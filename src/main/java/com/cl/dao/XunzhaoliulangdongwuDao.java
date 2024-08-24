package com.cl.dao;

import com.cl.entity.XunzhaoliulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XunzhaoliulangdongwuView;


/**
 * 寻找流浪动物
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface XunzhaoliulangdongwuDao extends BaseMapper<XunzhaoliulangdongwuEntity> {
	
	List<XunzhaoliulangdongwuView> selectListView(@Param("ew") Wrapper<XunzhaoliulangdongwuEntity> wrapper);

	List<XunzhaoliulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<XunzhaoliulangdongwuEntity> wrapper);
	
	XunzhaoliulangdongwuView selectView(@Param("ew") Wrapper<XunzhaoliulangdongwuEntity> wrapper);
	

}
