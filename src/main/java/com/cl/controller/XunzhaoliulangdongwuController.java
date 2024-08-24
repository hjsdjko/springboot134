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

import com.cl.entity.XunzhaoliulangdongwuEntity;
import com.cl.entity.view.XunzhaoliulangdongwuView;

import com.cl.service.XunzhaoliulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 寻找流浪动物
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@RestController
@RequestMapping("/xunzhaoliulangdongwu")
public class XunzhaoliulangdongwuController {
    @Autowired
    private XunzhaoliulangdongwuService xunzhaoliulangdongwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XunzhaoliulangdongwuEntity xunzhaoliulangdongwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xunzhaoliulangdongwu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XunzhaoliulangdongwuEntity> ew = new EntityWrapper<XunzhaoliulangdongwuEntity>();

		PageUtils page = xunzhaoliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunzhaoliulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XunzhaoliulangdongwuEntity xunzhaoliulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<XunzhaoliulangdongwuEntity> ew = new EntityWrapper<XunzhaoliulangdongwuEntity>();

		PageUtils page = xunzhaoliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xunzhaoliulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XunzhaoliulangdongwuEntity xunzhaoliulangdongwu){
       	EntityWrapper<XunzhaoliulangdongwuEntity> ew = new EntityWrapper<XunzhaoliulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xunzhaoliulangdongwu, "xunzhaoliulangdongwu")); 
        return R.ok().put("data", xunzhaoliulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XunzhaoliulangdongwuEntity xunzhaoliulangdongwu){
        EntityWrapper< XunzhaoliulangdongwuEntity> ew = new EntityWrapper< XunzhaoliulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xunzhaoliulangdongwu, "xunzhaoliulangdongwu")); 
		XunzhaoliulangdongwuView xunzhaoliulangdongwuView =  xunzhaoliulangdongwuService.selectView(ew);
		return R.ok("查询寻找流浪动物成功").put("data", xunzhaoliulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XunzhaoliulangdongwuEntity xunzhaoliulangdongwu = xunzhaoliulangdongwuService.selectById(id);
		xunzhaoliulangdongwu = xunzhaoliulangdongwuService.selectView(new EntityWrapper<XunzhaoliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", xunzhaoliulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XunzhaoliulangdongwuEntity xunzhaoliulangdongwu = xunzhaoliulangdongwuService.selectById(id);
		xunzhaoliulangdongwu = xunzhaoliulangdongwuService.selectView(new EntityWrapper<XunzhaoliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", xunzhaoliulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XunzhaoliulangdongwuEntity xunzhaoliulangdongwu, HttpServletRequest request){
    	xunzhaoliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunzhaoliulangdongwu);
        xunzhaoliulangdongwuService.insert(xunzhaoliulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XunzhaoliulangdongwuEntity xunzhaoliulangdongwu, HttpServletRequest request){
    	xunzhaoliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(xunzhaoliulangdongwu);
        xunzhaoliulangdongwuService.insert(xunzhaoliulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XunzhaoliulangdongwuEntity xunzhaoliulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xunzhaoliulangdongwu);
        xunzhaoliulangdongwuService.updateById(xunzhaoliulangdongwu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XunzhaoliulangdongwuEntity> list = new ArrayList<XunzhaoliulangdongwuEntity>();
        for(Long id : ids) {
            XunzhaoliulangdongwuEntity xunzhaoliulangdongwu = xunzhaoliulangdongwuService.selectById(id);
            xunzhaoliulangdongwu.setSfsh(sfsh);
            xunzhaoliulangdongwu.setShhf(shhf);
            list.add(xunzhaoliulangdongwu);
        }
        xunzhaoliulangdongwuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xunzhaoliulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
