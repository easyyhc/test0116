/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.lazy;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.easy.domain.Dwxx;
import com.easy.domain.Jyxx1;
import com.easy.utils.HibernateUitls;






/**
 *@Title:
 *@Description:关联级别 延迟加载 & 抓取策略
 *@Author:yhc
 *@Since:2018年1月11日
 *@Version:1.1.0
 */
public class Test2 {
  //集合级别的关联
    //fetch:select 单表查询
    //lazy:true 使用时才加载集合数据.
    @Test
    public void fun1(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Dwxx dwxx = session.get(Dwxx.class, 1);
     
     Set<Jyxx1> jyxxset = dwxx.getJyxxset();//关联级别
     
     System.out.println(jyxxset);
     
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    //集合级别的关联
     //fetch:select 单表查询
     //lazy:false 立即记载集合数据
     @Test
     public void fun2(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      Dwxx dwxx = session.get(Dwxx.class, 1);
      
      Set<Jyxx1> jyxxset = dwxx.getJyxxset();//关联级别
      
      System.out.println(jyxxset);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     //集合级别的关联
     //fetch:select 单表查询
     //lazy:extra 超级(极其)懒惰.与懒加载效果基本一致. 如果只获得集合的size.只查询集合的size(count语句)
     @Test
     public void fun3(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      Dwxx dwxx = session.get(Dwxx.class, 1);
      
      Set<Jyxx1> jyxxset = dwxx.getJyxxset();//关联级别
      
      System.out.println(jyxxset.size());
      
      System.out.println(jyxxset);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     //集合级别的关联
     //fetch:join 多表查询
     //lazy:true|false|extra 失效.立即加载.
     @Test
     public void fun4(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      Dwxx dwxx = session.get(Dwxx.class, 1);
      
      Set<Jyxx1> jyxxset = dwxx.getJyxxset();//关联级别
      
      System.out.println(jyxxset.size());
      
      System.out.println(jyxxset);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     
     @Test
     //fetch: subselect 子查询
     //lazy: true 懒加载|false 立即加载
     public void fun5(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
       
      String  hql = "from Dwxx";
      
      Query query = session.createQuery(hql);
      
      List<Dwxx> list = query.list();
      
      for(Dwxx dwxx:list){
       System.out.println(dwxx);
       System.out.println(dwxx.getJyxxset().size());
       System.out.println(dwxx.getJyxxset());
      }
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     @Test
     //fetch: subselect 子查询
     //lazy: false 立即加载
     public void fun6(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
       
      String  hql = "from Dwxx";
      
      Query query = session.createQuery(hql);
      
      List<Dwxx> list = query.list();
      
      for(Dwxx dwxx:list){
          System.out.println(dwxx);
          System.out.println(dwxx.getJyxxset().size());
          System.out.println(dwxx.getJyxxset());
         }
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     @Test
     //fetch: subselect 子查询
     //lazy: extra 极其懒惰
     public void fun7(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
       
      String  hql = "from Dwxx";
      
      Query query = session.createQuery(hql);
      
      List<Dwxx> list = query.list();
      
      for(Dwxx dwxx:list){
          System.out.println(dwxx);
          System.out.println(dwxx.getJyxxset().size());
          System.out.println(dwxx.getJyxxset());
         }
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     @Test
     //fetch:select 单表查询
     //<many-to-one> 
     //lazy:proxy   默认值 默认采用one的一方lazy属性
      //dwxx-true 懒加载
     public void fun8(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      Jyxx1 jyxx1 = session.get(Jyxx1.class, 1);
      
      Dwxx dwxx = jyxx1.getDwxx();
      
      System.out.println(dwxx);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     @Test
     //fetch:join 多表
     //lazy: 失效  
     public void fun9(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      Jyxx1 jyxx1 = session.get(Jyxx1.class, 1);
      
      Dwxx dwxx = jyxx1.getDwxx();
      
      System.out.println(dwxx);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     @Test
     //fetch:select 单表查询
     //lazy:proxy  
      //dwxx-false 立即加载
     public void fun10(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
    Jyxx1 jyxx1 = session.get(Jyxx1.class, 1);
      
      Dwxx dwxx = jyxx1.getDwxx();
      
      System.out.println(dwxx);
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
     //抓取数量
     @Test
     public void fun11(){
      Session session = HibernateUitls.openSession();
      Transaction tx = session.beginTransaction();
      //----------------------------------------------------
      
      String hql = "from Dwxx ";
      Query query = session.createQuery(hql);
      List<Dwxx> list = query.list();
      
      for(Dwxx dwxx:list){
       System.out.println(dwxx.getJyxxset());
      }
      
      //----------------------------------------------------
      tx.commit();
      session.close();
      
     }
}
