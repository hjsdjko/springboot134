package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DongwupinzhongDao;
import com.cl.entity.DongwupinzhongEntity;
import com.cl.service.DongwupinzhongService;
import com.cl.entity.view.DongwupinzhongView;

@Service("dongwupinzhongService")
public class DongwupinzhongServiceImpl extends ServiceImpl<DongwupinzhongDao, DongwupinzhongEntity> implements DongwupinzhongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DongwupinzhongEntity> page = this.selectPage(
                new Query<DongwupinzhongEntity>(params).getPage(),
                new EntityWrapper<DongwupinzhongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DongwupinzhongEntity> wrapper) {
		  Page<DongwupinzhongView> page =new Query<DongwupinzhongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DongwupinzhongView> selectListView(Wrapper<DongwupinzhongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DongwupinzhongView selectView(Wrapper<DongwupinzhongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
