package com.cl.dao;

import com.cl.entity.DiscussjiuzhuliulangdongwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiuzhuliulangdongwuView;


/**
 * 救助流浪动物评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DiscussjiuzhuliulangdongwuDao extends BaseMapper<DiscussjiuzhuliulangdongwuEntity> {
	
	List<DiscussjiuzhuliulangdongwuView> selectListView(@Param("ew") Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);

	List<DiscussjiuzhuliulangdongwuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);
	
	DiscussjiuzhuliulangdongwuView selectView(@Param("ew") Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);
	

}
