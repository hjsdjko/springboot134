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


import com.cl.dao.JiuzhuliulangdongwuDao;
import com.cl.entity.JiuzhuliulangdongwuEntity;
import com.cl.service.JiuzhuliulangdongwuService;
import com.cl.entity.view.JiuzhuliulangdongwuView;

@Service("jiuzhuliulangdongwuService")
public class JiuzhuliulangdongwuServiceImpl extends ServiceImpl<JiuzhuliulangdongwuDao, JiuzhuliulangdongwuEntity> implements JiuzhuliulangdongwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhuliulangdongwuEntity> page = this.selectPage(
                new Query<JiuzhuliulangdongwuEntity>(params).getPage(),
                new EntityWrapper<JiuzhuliulangdongwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhuliulangdongwuEntity> wrapper) {
		  Page<JiuzhuliulangdongwuView> page =new Query<JiuzhuliulangdongwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiuzhuliulangdongwuView> selectListView(Wrapper<JiuzhuliulangdongwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhuliulangdongwuView selectView(Wrapper<JiuzhuliulangdongwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
