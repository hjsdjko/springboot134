package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiuzhuliulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiuzhuliulangdongwuView;


/**
 * 救助流浪动物
 *
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface JiuzhuliulangdongwuService extends IService<JiuzhuliulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuzhuliulangdongwuView> selectListView(Wrapper<JiuzhuliulangdongwuEntity> wrapper);
   	
   	JiuzhuliulangdongwuView selectView(@Param("ew") Wrapper<JiuzhuliulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuzhuliulangdongwuEntity> wrapper);
   	

}

