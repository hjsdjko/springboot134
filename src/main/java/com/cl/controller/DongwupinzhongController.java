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

import com.cl.entity.DongwupinzhongEntity;
import com.cl.entity.view.DongwupinzhongView;

import com.cl.service.DongwupinzhongService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 动物品种
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@RestController
@RequestMapping("/dongwupinzhong")
public class DongwupinzhongController {
    @Autowired
    private DongwupinzhongService dongwupinzhongService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DongwupinzhongEntity dongwupinzhong,
		HttpServletRequest request){
        EntityWrapper<DongwupinzhongEntity> ew = new EntityWrapper<DongwupinzhongEntity>();

		PageUtils page = dongwupinzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwupinzhong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DongwupinzhongEntity dongwupinzhong, 
		HttpServletRequest request){
        EntityWrapper<DongwupinzhongEntity> ew = new EntityWrapper<DongwupinzhongEntity>();

		PageUtils page = dongwupinzhongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dongwupinzhong), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DongwupinzhongEntity dongwupinzhong){
       	EntityWrapper<DongwupinzhongEntity> ew = new EntityWrapper<DongwupinzhongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dongwupinzhong, "dongwupinzhong")); 
        return R.ok().put("data", dongwupinzhongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DongwupinzhongEntity dongwupinzhong){
        EntityWrapper< DongwupinzhongEntity> ew = new EntityWrapper< DongwupinzhongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dongwupinzhong, "dongwupinzhong")); 
		DongwupinzhongView dongwupinzhongView =  dongwupinzhongService.selectView(ew);
		return R.ok("查询动物品种成功").put("data", dongwupinzhongView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DongwupinzhongEntity dongwupinzhong = dongwupinzhongService.selectById(id);
		dongwupinzhong = dongwupinzhongService.selectView(new EntityWrapper<DongwupinzhongEntity>().eq("id", id));
        return R.ok().put("data", dongwupinzhong);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DongwupinzhongEntity dongwupinzhong = dongwupinzhongService.selectById(id);
		dongwupinzhong = dongwupinzhongService.selectView(new EntityWrapper<DongwupinzhongEntity>().eq("id", id));
        return R.ok().put("data", dongwupinzhong);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DongwupinzhongEntity dongwupinzhong, HttpServletRequest request){
    	dongwupinzhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwupinzhong);
        dongwupinzhongService.insert(dongwupinzhong);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DongwupinzhongEntity dongwupinzhong, HttpServletRequest request){
    	dongwupinzhong.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(dongwupinzhong);
        dongwupinzhongService.insert(dongwupinzhong);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DongwupinzhongEntity dongwupinzhong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dongwupinzhong);
        dongwupinzhongService.updateById(dongwupinzhong);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dongwupinzhongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
