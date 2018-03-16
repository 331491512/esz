package com.westangel.commonservice.multimedia.util.image;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Tools {

	
	public static String getFielName(){
		return dateFormatString(new Date()) + "-" + String.valueOf(new Random().nextInt(Integer.MAX_VALUE));
	}
	
	public static String dateFormatString(Date date) {
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		return df.format(date);
	}
}
