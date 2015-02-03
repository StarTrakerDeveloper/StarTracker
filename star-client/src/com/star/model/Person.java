package com.star.model;

import java.io.Serializable;

/**
 * 联系人实体
 * @ClassName: Person.java 
 * @Description: 通讯录中的联系人实体信息，字段待完善
 * @author Lee
 * @email lijunlong42@126.com  
 * @date 2014-12-24 上午11:59:01
 */
public class Person implements Serializable
{
	private static final long serialVersionUID = -3240654772960951674L;
	//人员id
	private Long id;
	//人员姓名
	private String name;
	//人员姓名拼音
	private String pinyin;
	//人员姓名拼音首字母
	private String sortletter;
	//人员头像
	private Long photoId;
	// 电话号码
	private String phoneNum;
	
	public String getSortletter()
	{
		return sortletter;
	}
	public void setSortletter(String sortletter)
	{
		this.sortletter = sortletter;
	}
	private boolean check = false;
	public String getPinyin()
	{
		return pinyin;
	}
	public void setPinyin(String pinyin)
	{
		this.pinyin = pinyin;
	}
	public Long getId()
	{
		return id;
	}
	public void setId(Long id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public boolean isCheck()
	{
		return check;
	}
	public void setCheck(boolean check)
	{
		this.check = check;
	}
	public Long getPhotoId() {
		return photoId;
	}
	public void setPhotoId(Long photoId) {
		this.photoId = photoId;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	
}
