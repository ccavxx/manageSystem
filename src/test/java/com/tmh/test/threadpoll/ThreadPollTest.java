package com.tmh.test.threadpoll;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.tmh.test.base.AbstractTest;

/**
 * 生产者消费者多线程测试
 * className:ThreadPollTest
 * @Description:TODO (文件说明：  功能，函数）
 * @author TianMengHua 
 * @CreateTime:2015年11月26日-上午10:53:04
 * @Remark 备注说明
 */
public class ThreadPollTest extends AbstractTest{
	
	@Autowired
	ThreadPoolTaskExecutor taskExecutor;
	
	//定义装苹果的篮子
	BlockingQueue<String> queue = new LinkedBlockingQueue<String>(1000);
	
	// 生产苹果，放入篮子   
    public void produce() throws InterruptedException{  
        // put方法放入一个苹果，若basket满了，等到basket有位置   
    	queue.put("An apple");  
    }  
    
    // 消费苹果，从篮子中取走   
    public String consume() throws InterruptedException{  
        // get方法取出一个苹果，若basket为空，等到basket有苹果为止   
        return queue.take();  
    } 
    
    @Test
    public void producerConsumerTest() {  
    	
        // 定义苹果生产者   
        class Producer implements Runnable {  
            public void run() {  
                try {  
                    while (true) {  
                        // 生产苹果   
                        produce();  
                        System.out.println("生产者生产苹果完毕："   
                                + System.currentTimeMillis() + "----" + Thread.currentThread());  
                        // 休眠300ms   
                        Thread.sleep(300);  
                    }  
                } catch (InterruptedException ex) {  
                }  
            }  
        }  
        
        // 定义苹果消费者   
        class Consumer implements Runnable {  
            public void run() {  
                try {  
                    while (true) {  
                        // 消费苹果   
                        consume();  
                        System.err.println("消费者消费苹果完毕："   
                                + System.currentTimeMillis() + "----" +Thread.currentThread());  
                        // 休眠1000ms   
                        Thread.sleep(900);  
                    }  
                } catch (InterruptedException ex) {  
                }  
            }  
        }  
        
        //线程数量,线程池的使用
        int ThreadNum = 100; 
        for(int i=0;i<ThreadNum;i++){
        	taskExecutor.execute(new Producer());
            taskExecutor.execute(new Consumer());
        }
        
        
        // 程序运行5s后，所有任务停止   
        try {  
            Thread.sleep(5000);
            System.out.println("剩余的苹果树" + queue.size());
        } catch (InterruptedException e) { 
        	
        }  
    }
	
}
