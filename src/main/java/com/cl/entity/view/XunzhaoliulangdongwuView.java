package com.cl.entity.view;

import com.cl.entity.XunzhaoliulangdongwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 寻找流浪动物
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@TableName("xunzhaoliulangdongwu")
public class XunzhaoliulangdongwuView  extends XunzhaoliulangdongwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public XunzhaoliulangdongwuView(){
	}
 
 	public XunzhaoliulangdongwuView(XunzhaoliulangdongwuEntity xunzhaoliulangdongwuEntity){
 	try {
			BeanUtils.copyProperties(this, xunzhaoliulangdongwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
