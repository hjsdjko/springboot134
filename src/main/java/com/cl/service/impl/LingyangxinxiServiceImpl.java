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


import com.cl.dao.LingyangxinxiDao;
import com.cl.entity.LingyangxinxiEntity;
import com.cl.service.LingyangxinxiService;
import com.cl.entity.view.LingyangxinxiView;

@Service("lingyangxinxiService")
public class LingyangxinxiServiceImpl extends ServiceImpl<LingyangxinxiDao, LingyangxinxiEntity> implements LingyangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LingyangxinxiEntity> page = this.selectPage(
                new Query<LingyangxinxiEntity>(params).getPage(),
                new EntityWrapper<LingyangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LingyangxinxiEntity> wrapper) {
		  Page<LingyangxinxiView> page =new Query<LingyangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<LingyangxinxiView> selectListView(Wrapper<LingyangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LingyangxinxiView selectView(Wrapper<LingyangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
