package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.DongwupinzhongEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwupinzhongView;


/**
 * 动物品种
 *
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DongwupinzhongService extends IService<DongwupinzhongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DongwupinzhongView> selectListView(Wrapper<DongwupinzhongEntity> wrapper);
   	
   	DongwupinzhongView selectView(@Param("ew") Wrapper<DongwupinzhongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DongwupinzhongEntity> wrapper);
   	

}

