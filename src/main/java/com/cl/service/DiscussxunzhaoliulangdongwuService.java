package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussxunzhaoliulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussxunzhaoliulangdongwuView;


/**
 * 寻找流浪动物评论表
 *
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DiscussxunzhaoliulangdongwuService extends IService<DiscussxunzhaoliulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxunzhaoliulangdongwuView> selectListView(Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);
   	
   	DiscussxunzhaoliulangdongwuView selectView(@Param("ew") Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper);
   	

}

