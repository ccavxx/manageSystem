package com.tmh.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;

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
	 * @author TianMengHua
	 * @Date 2015年12月8日-下午5:03:44
	 */
	public static String decimals2(float decimals) {
		DecimalFormat dcmFmt = new DecimalFormat("0.00");
		return dcmFmt.format(decimals);
	}
	
	public static void main(String[] args) {
		System.err.println(decimals2percent(0.03789f)); ;
		System.out.println(decimals2(0.03789f));
	}
	
	
}
