/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.lazy;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.easy.domain.Dwxx;
import com.easy.utils.HibernateUitls;



/**
 *@Title:
 *@Description:懒加载|延迟加载
 *@Author:yhc
 *@Since:2018年1月11日
 *@Version:1.1.0
 */
public class Test1 {
    
    @Test
    // get方法 : 立即加载.执行方法时立即发送sql语句查询结果
    public void fun1(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Dwxx dwxx = session.get(Dwxx.class, 1);
     
//     System.out.println(dwxx);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    // load方法(默认):是在执行时,不发送任何sql语句.返回一个对象.使用该对象时,才执行查询.
    // 延迟加载: 仅仅获得没有使用.不会查询.在使用时才进行查询.
    // 是否对类进行延迟加载: 可以通过在class元素上配置lazy属性来控制.
     //lazy:true  加载时,不查询.使用时才查询
     //lazy:false 加载时立即查询.
    public void fun2(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Dwxx dwxx = session.load(Dwxx.class, 1);
     System.out.println("111111111");
//     System.out.println(dwxx);
     //----------------------------------------------------
     tx.commit();
     session.close();
  
     
    }
}
