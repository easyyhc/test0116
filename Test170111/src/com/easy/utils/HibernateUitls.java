/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018年1月2日
 *@Version:1.1.0
 */
public class HibernateUitls {

    private static SessionFactory sf;
    
    static{
     //1 创建,调用空参构造
     Configuration conf = new Configuration().configure();
     
     //2 根据配置信息,创建 SessionFactory对象
      sf = conf.buildSessionFactory();
    }
    
    //获得session => 获得全新session
    public static Session openSession(){
       //3 获得session
/*  Session不是线程安全的.
        是与数据库交互的桥梁:完成CRUD的操作:常用的方法:
        * save(Object obj);
        * update(Object obj);
        * delete(Object obj);
        * T get(Class c,Serializable s); 
        * T load(Class c,Serializable s);
        * saveOrUpdate(Object obj);
*/
       Session session = sf.openSession();
       
       return session;
     
    }
    //获得session => 获得与线程绑定的session
    public static Session getCurrentSession(){
     //3 获得session
     Session session = sf.getCurrentSession();
     
     return session;
    }
    
    
}
