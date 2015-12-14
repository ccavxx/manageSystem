package com.tmh.test.cheat;

import java.net.UnknownHostException;

import org.junit.Test;

import com.tmh.test.base.AbstractTest;
import com.tmh.utils.AgentIPUtils;
import com.tmh.utils.HtmlUtils;
import com.tmh.utils.SendPost;

/**
 * 作弊刷微信测试
 * className:CheatTest
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @mail 迎钱宝网络支付有限公司
 * @CreateTime:2015年12月8日-下午4:43:43
 * @Remark 备注说明
 */
public class CheatTest extends AbstractTest{
	
	/**
     * 陈小鸽朋友微信刷票
     * @MethodName:Chenxiaoge
     * @throws InterruptedException
     * @return void
     * @author TianMengHua
	 * @throws UnknownHostException 
     * @Date 2015年12月8日-下午1:44:04
     */
	@Test
    public void Chenxiaoge() throws InterruptedException, UnknownHostException{
        
    	for(int i=0;i<1000;i++){
    		
    		//北京市 BGP多线IP
    		AgentIPUtils.agentIP("183.131.151.208", "80"); 
    		
    		//测试当前实际IP
//    		String agentIP = HtmlUtils.getTextByTag("http://city.ip138.com/ip2city.asp", "body");
//    		System.err.println(agentIP);
    		
            //测试显示总投票数
//    		String num = HtmlUtils.getNodeListByTag("http://chengpin.weixmei.com/31cms/31cms/index.php?g=Wap&m=Vote&a=show&token=vjcbgt1414375209&id=65&wecha_id=obRw3t1r2D0I_hBQsI-zseAumHR0&tid=19",
//    	    		   "div", "class", "col-xs-6 counts_btn").elementAt(0).getChildren().asString();
//	        System.out.println("总票数:" + num);
	    	
	        //发送 POST 请求
	        int random = (int)(Math.random()*9000+1000);  //1000~9000之间的随机数
	        //随机生成微信id
	        String wecha_id = "HtBrVW7BU_AZL9I"+ random +"I-S_KvBH9" ;
	        String s =SendPost.sendPost("http://chengpin.weixmei.com/31cms/index.php?g=Wap&m=Vote&a=toupiao&token=vjcbgt1414375209&id=65&wecha_id=&tid=19",
	        		"wecha_id=" + wecha_id);
	        if(s.contains("投票成功,谢谢您的参与")){
	        	System.out.println("投票成功,谢谢您的参与");
	        }
	        if (s.contains("已经投过票了")) {
				System.out.println("已经投过票了");
			}
	        //随机等待0秒~10秒
//    		Thread.sleep(random);
    		
    		//人工制造异常切换IP
//    		AgentIPUtils.agentIP("127.0.0.1", "80"); 
//    		System.err.println("人工制造异常切换IP");
//    		AgentIPUtils.getIPAdressForHtml("http://city.ip138.com/ip2city.asp");
    	}
    }
    
}
