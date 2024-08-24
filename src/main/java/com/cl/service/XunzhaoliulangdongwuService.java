package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.XunzhaoliulangdongwuEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.XunzhaoliulangdongwuView;


/**
 * 寻找流浪动物
 *
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface XunzhaoliulangdongwuService extends IService<XunzhaoliulangdongwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XunzhaoliulangdongwuView> selectListView(Wrapper<XunzhaoliulangdongwuEntity> wrapper);
   	
   	XunzhaoliulangdongwuView selectView(@Param("ew") Wrapper<XunzhaoliulangdongwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XunzhaoliulangdongwuEntity> wrapper);
   	

}

