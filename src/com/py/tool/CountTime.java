package com.py.tool;
import java.util.Date;
import java.text.SimpleDateFormat;

public class CountTime {
	public String currentlyTime() {//��ȡʱ��
		Date date = new Date();			//ʵ����Date�࣬��ȡϵͳʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		return sdf.format(date);
	}

}