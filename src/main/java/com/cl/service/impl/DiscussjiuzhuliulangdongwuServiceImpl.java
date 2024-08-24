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


import com.cl.dao.DiscussjiuzhuliulangdongwuDao;
import com.cl.entity.DiscussjiuzhuliulangdongwuEntity;
import com.cl.service.DiscussjiuzhuliulangdongwuService;
import com.cl.entity.view.DiscussjiuzhuliulangdongwuView;

@Service("discussjiuzhuliulangdongwuService")
public class DiscussjiuzhuliulangdongwuServiceImpl extends ServiceImpl<DiscussjiuzhuliulangdongwuDao, DiscussjiuzhuliulangdongwuEntity> implements DiscussjiuzhuliulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiuzhuliulangdongwuEntity> page = this.selectPage(
                new Query<DiscussjiuzhuliulangdongwuEntity>(params).getPage(),
                new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper) {
		  Page<DiscussjiuzhuliulangdongwuView> page =new Query<DiscussjiuzhuliulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussjiuzhuliulangdongwuView> selectListView(Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiuzhuliulangdongwuView selectView(Wrapper<DiscussjiuzhuliulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
