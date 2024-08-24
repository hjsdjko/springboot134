package com.cl.entity.view;

import com.cl.entity.DongwupinzhongEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 动物品种
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@TableName("dongwupinzhong")
public class DongwupinzhongView  extends DongwupinzhongEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DongwupinzhongView(){
	}
 
 	public DongwupinzhongView(DongwupinzhongEntity dongwupinzhongEntity){
 	try {
			BeanUtils.copyProperties(this, dongwupinzhongEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
