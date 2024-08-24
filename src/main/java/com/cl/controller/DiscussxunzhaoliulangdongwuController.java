package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussxunzhaoliulangdongwuEntity;
import com.cl.entity.view.DiscussxunzhaoliulangdongwuView;

import com.cl.service.DiscussxunzhaoliulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 寻找流浪动物评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@RestController
@RequestMapping("/discussxunzhaoliulangdongwu")
public class DiscussxunzhaoliulangdongwuController {
    @Autowired
    private DiscussxunzhaoliulangdongwuService discussxunzhaoliulangdongwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu,
		HttpServletRequest request){
        EntityWrapper<DiscussxunzhaoliulangdongwuEntity> ew = new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>();

		PageUtils page = discussxunzhaoliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxunzhaoliulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<DiscussxunzhaoliulangdongwuEntity> ew = new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>();

		PageUtils page = discussxunzhaoliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxunzhaoliulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu){
       	EntityWrapper<DiscussxunzhaoliulangdongwuEntity> ew = new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussxunzhaoliulangdongwu, "discussxunzhaoliulangdongwu")); 
        return R.ok().put("data", discussxunzhaoliulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu){
        EntityWrapper< DiscussxunzhaoliulangdongwuEntity> ew = new EntityWrapper< DiscussxunzhaoliulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussxunzhaoliulangdongwu, "discussxunzhaoliulangdongwu")); 
		DiscussxunzhaoliulangdongwuView discussxunzhaoliulangdongwuView =  discussxunzhaoliulangdongwuService.selectView(ew);
		return R.ok("查询寻找流浪动物评论表成功").put("data", discussxunzhaoliulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu = discussxunzhaoliulangdongwuService.selectById(id);
		discussxunzhaoliulangdongwu = discussxunzhaoliulangdongwuService.selectView(new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussxunzhaoliulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu = discussxunzhaoliulangdongwuService.selectById(id);
		discussxunzhaoliulangdongwu = discussxunzhaoliulangdongwuService.selectView(new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussxunzhaoliulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu, HttpServletRequest request){
    	discussxunzhaoliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxunzhaoliulangdongwu);
        discussxunzhaoliulangdongwuService.insert(discussxunzhaoliulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu, HttpServletRequest request){
    	discussxunzhaoliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussxunzhaoliulangdongwu);
        discussxunzhaoliulangdongwuService.insert(discussxunzhaoliulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussxunzhaoliulangdongwu);
        discussxunzhaoliulangdongwuService.updateById(discussxunzhaoliulangdongwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussxunzhaoliulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussxunzhaoliulangdongwuEntity discussxunzhaoliulangdongwu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussxunzhaoliulangdongwuEntity> ew = new EntityWrapper<DiscussxunzhaoliulangdongwuEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussxunzhaoliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussxunzhaoliulangdongwu), params), params));
        return R.ok().put("data", page);
    }








}
