package com.sktelecom.tdrive;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.sktelecom.tdrive.util.ZipcodeVO;

public class VoTestMain {

	@SuppressWarnings("null")
	public static void main(String[] args) {
//		Date d = new Date();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//        System.out.println("현재날짜 : "+ sdf.format(d));
		
		String textDate = "20070722";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = sdf.parse(textDate);
			
			SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
			String dateString = sdf1.format(date);
			System.out.println("test >>>>>>>>>>>> " + dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		if ("20160101".compareTo("20160102") > 0) {
			System.out.println("111111111111111");
		} else {
			System.out.println("222222222222222222222222");
			
		}
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date = df.parse("20160513");

			// 날짜 더하기
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1);
			System.out.println("start" + df.format(cal.getTime()));
			cal.add(Calendar.DATE, 30);;
			
			System.out.println("end" + df.format(cal.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
