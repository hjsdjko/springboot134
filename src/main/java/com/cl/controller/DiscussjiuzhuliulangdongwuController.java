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

import com.cl.entity.DiscussjiuzhuliulangdongwuEntity;
import com.cl.entity.view.DiscussjiuzhuliulangdongwuView;

import com.cl.service.DiscussjiuzhuliulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 救助流浪动物评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@RestController
@RequestMapping("/discussjiuzhuliulangdongwu")
public class DiscussjiuzhuliulangdongwuController {
    @Autowired
    private DiscussjiuzhuliulangdongwuService discussjiuzhuliulangdongwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu,
		HttpServletRequest request){
        EntityWrapper<DiscussjiuzhuliulangdongwuEntity> ew = new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>();

		PageUtils page = discussjiuzhuliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiuzhuliulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<DiscussjiuzhuliulangdongwuEntity> ew = new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>();

		PageUtils page = discussjiuzhuliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiuzhuliulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu){
       	EntityWrapper<DiscussjiuzhuliulangdongwuEntity> ew = new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussjiuzhuliulangdongwu, "discussjiuzhuliulangdongwu")); 
        return R.ok().put("data", discussjiuzhuliulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu){
        EntityWrapper< DiscussjiuzhuliulangdongwuEntity> ew = new EntityWrapper< DiscussjiuzhuliulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussjiuzhuliulangdongwu, "discussjiuzhuliulangdongwu")); 
		DiscussjiuzhuliulangdongwuView discussjiuzhuliulangdongwuView =  discussjiuzhuliulangdongwuService.selectView(ew);
		return R.ok("查询救助流浪动物评论表成功").put("data", discussjiuzhuliulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu = discussjiuzhuliulangdongwuService.selectById(id);
		discussjiuzhuliulangdongwu = discussjiuzhuliulangdongwuService.selectView(new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussjiuzhuliulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu = discussjiuzhuliulangdongwuService.selectById(id);
		discussjiuzhuliulangdongwu = discussjiuzhuliulangdongwuService.selectView(new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", discussjiuzhuliulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu, HttpServletRequest request){
    	discussjiuzhuliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiuzhuliulangdongwu);
        discussjiuzhuliulangdongwuService.insert(discussjiuzhuliulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu, HttpServletRequest request){
    	discussjiuzhuliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussjiuzhuliulangdongwu);
        discussjiuzhuliulangdongwuService.insert(discussjiuzhuliulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussjiuzhuliulangdongwu);
        discussjiuzhuliulangdongwuService.updateById(discussjiuzhuliulangdongwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussjiuzhuliulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussjiuzhuliulangdongwuEntity discussjiuzhuliulangdongwu, HttpServletRequest request,String pre){
        EntityWrapper<DiscussjiuzhuliulangdongwuEntity> ew = new EntityWrapper<DiscussjiuzhuliulangdongwuEntity>();
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
		PageUtils page = discussjiuzhuliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussjiuzhuliulangdongwu), params), params));
        return R.ok().put("data", page);
    }








}
