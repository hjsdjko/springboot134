package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 动物领养
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-22 13:09:28
 */
@TableName("dongwulingyang")
public class DongwulingyangEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DongwulingyangEntity() {
		
	}
	
	public DongwulingyangEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 动物名称
	 */
					
	private String dongwumingcheng;
	
	/**
	 * 动物图片
	 */
					
	private String dongwutupian;
	
	/**
	 * 动物品种
	 */
					
	private String dongwupinzhong;
	
	/**
	 * 动物性别
	 */
					
	private String dongwuxingbie;
	
	/**
	 * 动物年龄
	 */
					
	private String dongwunianling;
	
	/**
	 * 动物详情
	 */
					
	private String dongwuxiangqing;
	
	/**
	 * 救助站名称
	 */
					
	private String jiuzhuzhanmingcheng;
	
	/**
	 * 负责人
	 */
					
	private String fuzeren;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	/**
	 * 发布时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date fabushijian;
	
	/**
	 * 领养状态
	 */
					
	private String lingyangzhuangtai;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：动物名称
	 */
	public void setDongwumingcheng(String dongwumingcheng) {
		this.dongwumingcheng = dongwumingcheng;
	}
	/**
	 * 获取：动物名称
	 */
	public String getDongwumingcheng() {
		return dongwumingcheng;
	}
	/**
	 * 设置：动物图片
	 */
	public void setDongwutupian(String dongwutupian) {
		this.dongwutupian = dongwutupian;
	}
	/**
	 * 获取：动物图片
	 */
	public String getDongwutupian() {
		return dongwutupian;
	}
	/**
	 * 设置：动物品种
	 */
	public void setDongwupinzhong(String dongwupinzhong) {
		this.dongwupinzhong = dongwupinzhong;
	}
	/**
	 * 获取：动物品种
	 */
	public String getDongwupinzhong() {
		return dongwupinzhong;
	}
	/**
	 * 设置：动物性别
	 */
	public void setDongwuxingbie(String dongwuxingbie) {
		this.dongwuxingbie = dongwuxingbie;
	}
	/**
	 * 获取：动物性别
	 */
	public String getDongwuxingbie() {
		return dongwuxingbie;
	}
	/**
	 * 设置：动物年龄
	 */
	public void setDongwunianling(String dongwunianling) {
		this.dongwunianling = dongwunianling;
	}
	/**
	 * 获取：动物年龄
	 */
	public String getDongwunianling() {
		return dongwunianling;
	}
	/**
	 * 设置：动物详情
	 */
	public void setDongwuxiangqing(String dongwuxiangqing) {
		this.dongwuxiangqing = dongwuxiangqing;
	}
	/**
	 * 获取：动物详情
	 */
	public String getDongwuxiangqing() {
		return dongwuxiangqing;
	}
	/**
	 * 设置：救助站名称
	 */
	public void setJiuzhuzhanmingcheng(String jiuzhuzhanmingcheng) {
		this.jiuzhuzhanmingcheng = jiuzhuzhanmingcheng;
	}
	/**
	 * 获取：救助站名称
	 */
	public String getJiuzhuzhanmingcheng() {
		return jiuzhuzhanmingcheng;
	}
	/**
	 * 设置：负责人
	 */
	public void setFuzeren(String fuzeren) {
		this.fuzeren = fuzeren;
	}
	/**
	 * 获取：负责人
	 */
	public String getFuzeren() {
		return fuzeren;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}
	/**
	 * 设置：发布时间
	 */
	public void setFabushijian(Date fabushijian) {
		this.fabushijian = fabushijian;
	}
	/**
	 * 获取：发布时间
	 */
	public Date getFabushijian() {
		return fabushijian;
	}
	/**
	 * 设置：领养状态
	 */
	public void setLingyangzhuangtai(String lingyangzhuangtai) {
		this.lingyangzhuangtai = lingyangzhuangtai;
	}
	/**
	 * 获取：领养状态
	 */
	public String getLingyangzhuangtai() {
		return lingyangzhuangtai;
	}

}
