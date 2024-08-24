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


import com.cl.dao.XunzhaoliulangdongwuDao;
import com.cl.entity.XunzhaoliulangdongwuEntity;
import com.cl.service.XunzhaoliulangdongwuService;
import com.cl.entity.view.XunzhaoliulangdongwuView;

@Service("xunzhaoliulangdongwuService")
public class XunzhaoliulangdongwuServiceImpl extends ServiceImpl<XunzhaoliulangdongwuDao, XunzhaoliulangdongwuEntity> implements XunzhaoliulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunzhaoliulangdongwuEntity> page = this.selectPage(
                new Query<XunzhaoliulangdongwuEntity>(params).getPage(),
                new EntityWrapper<XunzhaoliulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XunzhaoliulangdongwuEntity> wrapper) {
		  Page<XunzhaoliulangdongwuView> page =new Query<XunzhaoliulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<XunzhaoliulangdongwuView> selectListView(Wrapper<XunzhaoliulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XunzhaoliulangdongwuView selectView(Wrapper<XunzhaoliulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
