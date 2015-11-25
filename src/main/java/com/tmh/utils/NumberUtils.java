package com.tmh.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.UUID;

/**
 * 
 * className:NumberUtils
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年10月17日-上午10:42:14
 * @Remark 备注说明
 */
public class NumberUtils extends org.apache.commons.lang3.math.NumberUtils{
	/**
	 * 将小数转成百分数
	 * @param decimals
	 * @return
	 */
	public static String decimals2percent(float decimals) {
		NumberFormat num = NumberFormat.getPercentInstance();
		num.setMaximumIntegerDigits(3);
		num.setMaximumFractionDigits(2);
		return num.format(decimals);
	}
	
	/**
	 * 将小数保存末两位
	 * @MethodName:decimals2
	 * @param decimals
	 * @return
	 * @return String
	 * @author kongwei
	 * @Date 2012-12-20-下午3:33:53
	 */
	public static String decimals2(float decimals) {
		DecimalFormat dcmFmt = new DecimalFormat("0.00");
		return dcmFmt.format(decimals);
	}
	
	public static Float decimals2float(float decimals) {
		DecimalFormat dcmFmt = new DecimalFormat("0.00");
		return Float.valueOf(dcmFmt.format(decimals));
	}
	
	//DecimalFormat dcmFmt = new DecimalFormat("0.00");
	
	public static String randomNum() {
		return String.valueOf(Math.random() * 1000000).replace(".", "9").substring(0, 6);
	}
	 
	/**
	 * 上传文件的重命名
	 * @MethodName:generatefileName
	 * @return
	 * @return String
	 * @author David.Cheng
	 * @Date 2012-11-21-下午5:27:28
	 */
	public static String generatefileName() {
		return UUID.randomUUID().toString().replace("-","u17");
	}
	
	public static void main(String[] args) {
		System.err.println(decimals2percent(0.03789f)); ;
		System.err.println(randomNum());
	}
	
	
}
