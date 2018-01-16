/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.cache;

import java.util.Date;

import org.junit.Test;

/**
 *@Title:
 *@Description:二级缓存
 *@Author:yhc
 *@Since:2018年1月11日
 *@Version:1.1.0
 */
public class SecondlevelCache {

    //复习一级缓存  session级
    
    
//    二级缓存
/*    外置缓存(二级缓存): 一个可配置的缓存插件. 
 *  在默认情况下, SessionFactory 不会启用这个缓存插件.
 *  外置缓存中的数据是数据库数据的复制, 外置缓存的物理介质
 *  可以是内存或硬盘
*/
    @Test
  public void fun1(){
      
        
        /*
         * 这里是时间aaaaaaa！*/
      try {
          
          Date a = new Date();
        
          Thread.sleep(1000);
        
          Date b = new Date();
        
          long interval = (b.getTime() - a.getTime())/1000;
          
          
        
          System.out.println("两个时间相差"+interval+"秒");//会打印出相差3秒
        
         } catch (InterruptedException e) {
        
          e.printStackTrace();
      
  }
    }
    
    
}
