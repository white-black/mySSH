package com.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import net.sf.json.JSONObject;

public class AjaxTest {
	@Test
	public void test1(){
		String name = "张三";
		int age = 11;
		String position = "教师";
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("name", name);
		map.put("age",age);
		map.put("position", position);
		System.out.println(map);
		
		System.out.println("***");
		JSONObject json = JSONObject.fromObject(map);//将map对象转换成json类型数据
		System.out.println("....");
		System.out.println(json);
		String result = json.toString();//给result赋值，传递给页面
		System.out.println(result);
	}
}
