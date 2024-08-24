package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DiscussjiuzhuliulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussjiuzhuliulangdongwuView;


/**
 * 救助流浪动物评论表
 *
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DiscussjiuzhuliulangdongwuService extends IService<DiscussjiuzhuliulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiuzhuliulangdongwuView> selectListView(Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);
   	
   	DiscussjiuzhuliulangdongwuView selectView(@Param("ew") Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper);
   	

}

