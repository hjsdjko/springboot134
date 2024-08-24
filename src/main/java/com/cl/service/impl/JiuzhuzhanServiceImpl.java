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


import com.cl.dao.JiuzhuzhanDao;
import com.cl.entity.JiuzhuzhanEntity;
import com.cl.service.JiuzhuzhanService;
import com.cl.entity.view.JiuzhuzhanView;

@Service("jiuzhuzhanService")
public class JiuzhuzhanServiceImpl extends ServiceImpl<JiuzhuzhanDao, JiuzhuzhanEntity> implements JiuzhuzhanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuzhuzhanEntity> page = this.selectPage(
                new Query<JiuzhuzhanEntity>(params).getPage(),
                new EntityWrapper<JiuzhuzhanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuzhuzhanEntity> wrapper) {
		  Page<JiuzhuzhanView> page =new Query<JiuzhuzhanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiuzhuzhanView> selectListView(Wrapper<JiuzhuzhanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuzhuzhanView selectView(Wrapper<JiuzhuzhanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
