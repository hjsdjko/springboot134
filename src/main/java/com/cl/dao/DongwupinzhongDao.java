package com.cl.dao;

import com.cl.entity.DongwupinzhongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DongwupinzhongView;


/**
 * 动物品种
 * 
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
public interface DongwupinzhongDao extends BaseMapper<DongwupinzhongEntity> {
	
	List<DongwupinzhongView> selectListView(@Param("ew") Wrapper<DongwupinzhongEntity> wrapper);

	List<DongwupinzhongView> selectListView(Pagination page,@Param("ew") Wrapper<DongwupinzhongEntity> wrapper);
	
	DongwupinzhongView selectView(@Param("ew") Wrapper<DongwupinzhongEntity> wrapper);
	

}
