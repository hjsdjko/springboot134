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


import com.cl.dao.DiscussxunzhaoliulangdongwuDao;
import com.cl.entity.DiscussxunzhaoliulangdongwuEntity;
import com.cl.service.DiscussxunzhaoliulangdongwuService;
import com.cl.entity.view.DiscussxunzhaoliulangdongwuView;

@Service("discussxunzhaoliulangdongwuService")
public class DiscussxunzhaoliulangdongwuServiceImpl extends ServiceImpl<DiscussxunzhaoliulangdongwuDao, DiscussxunzhaoliulangdongwuEntity> implements DiscussxunzhaoliulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxunzhaoliulangdongwuEntity> page = this.selectPage(
                new Query<DiscussxunzhaoliulangdongwuEntity>(params).getPage(),
                new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper) {
		  Page<DiscussxunzhaoliulangdongwuView> page =new Query<DiscussxunzhaoliulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussxunzhaoliulangdongwuView> selectListView(Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxunzhaoliulangdongwuView selectView(Wrapper<DiscussxunzhaoliulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
