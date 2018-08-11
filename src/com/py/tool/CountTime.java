package com.py.tool;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CountTime {
	public String currentlyTime() {//获取时间
		Date date = new Date();			//实例化Date类，获取系统时间
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		return sdf.format(date);
	}

}