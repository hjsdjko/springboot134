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

import com.cl.entity.JiuzhuliulangdongwuEntity;
import com.cl.entity.view.JiuzhuliulangdongwuView;

import com.cl.service.JiuzhuliulangdongwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 救助流浪动物
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@RestController
@RequestMapping("/jiuzhuliulangdongwu")
public class JiuzhuliulangdongwuController {
    @Autowired
    private JiuzhuliulangdongwuService jiuzhuliulangdongwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuzhuliulangdongwuEntity jiuzhuliulangdongwu,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			jiuzhuliulangdongwu.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiuzhuliulangdongwuEntity> ew = new EntityWrapper<JiuzhuliulangdongwuEntity>();

		PageUtils page = jiuzhuliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhuliulangdongwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuzhuliulangdongwuEntity jiuzhuliulangdongwu, 
		HttpServletRequest request){
        EntityWrapper<JiuzhuliulangdongwuEntity> ew = new EntityWrapper<JiuzhuliulangdongwuEntity>();

		PageUtils page = jiuzhuliulangdongwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuzhuliulangdongwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuzhuliulangdongwuEntity jiuzhuliulangdongwu){
       	EntityWrapper<JiuzhuliulangdongwuEntity> ew = new EntityWrapper<JiuzhuliulangdongwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuzhuliulangdongwu, "jiuzhuliulangdongwu")); 
        return R.ok().put("data", jiuzhuliulangdongwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuzhuliulangdongwuEntity jiuzhuliulangdongwu){
        EntityWrapper< JiuzhuliulangdongwuEntity> ew = new EntityWrapper< JiuzhuliulangdongwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuzhuliulangdongwu, "jiuzhuliulangdongwu")); 
		JiuzhuliulangdongwuView jiuzhuliulangdongwuView =  jiuzhuliulangdongwuService.selectView(ew);
		return R.ok("查询救助流浪动物成功").put("data", jiuzhuliulangdongwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuzhuliulangdongwuEntity jiuzhuliulangdongwu = jiuzhuliulangdongwuService.selectById(id);
		jiuzhuliulangdongwu = jiuzhuliulangdongwuService.selectView(new EntityWrapper<JiuzhuliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", jiuzhuliulangdongwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuzhuliulangdongwuEntity jiuzhuliulangdongwu = jiuzhuliulangdongwuService.selectById(id);
		jiuzhuliulangdongwu = jiuzhuliulangdongwuService.selectView(new EntityWrapper<JiuzhuliulangdongwuEntity>().eq("id", id));
        return R.ok().put("data", jiuzhuliulangdongwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuzhuliulangdongwuEntity jiuzhuliulangdongwu, HttpServletRequest request){
    	jiuzhuliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuzhuliulangdongwu);
        jiuzhuliulangdongwuService.insert(jiuzhuliulangdongwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuzhuliulangdongwuEntity jiuzhuliulangdongwu, HttpServletRequest request){
    	jiuzhuliulangdongwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuzhuliulangdongwu);
        jiuzhuliulangdongwuService.insert(jiuzhuliulangdongwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JiuzhuliulangdongwuEntity jiuzhuliulangdongwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuzhuliulangdongwu);
        jiuzhuliulangdongwuService.updateById(jiuzhuliulangdongwu);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<JiuzhuliulangdongwuEntity> list = new ArrayList<JiuzhuliulangdongwuEntity>();
        for(Long id : ids) {
            JiuzhuliulangdongwuEntity jiuzhuliulangdongwu = jiuzhuliulangdongwuService.selectById(id);
            jiuzhuliulangdongwu.setSfsh(sfsh);
            jiuzhuliulangdongwu.setShhf(shhf);
            list.add(jiuzhuliulangdongwu);
        }
        jiuzhuliulangdongwuService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuzhuliulangdongwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
