/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.hql_criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.easy.domain.Dwxx;
import com.easy.utils.HibernateUitls;





/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018年1月11日
 *@Version:1.1.0
 */
public class Test2 {
    
    @Test
    //离线Criteria:没开启session时就可以拼装语句 关键词：DetachedCriteria
    public void fun1(){
        
      //Service/web层   凭空创建criteria
     DetachedCriteria dc  = DetachedCriteria.forClass(Dwxx.class);
     //----------------------------------------------------     
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     Criteria c = dc.getExecutableCriteria(session);   //gensession关联

     
     List<Dwxx> list = c.list();
     
     System.out.println(list);
     
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    // 条件语法
    public void fun2(){
        
        //Service/web层   凭空创建criteria
        DetachedCriteria dc  = DetachedCriteria.forClass(Dwxx.class);
        
        dc.add(Restrictions.idEq(1));//拼装条件(全部与普通Criteria一致)
        
        //----------------------------------------------------
        Session session = HibernateUitls.openSession();
        Transaction tx = session.beginTransaction();
        //----------------------------------------------------
        Criteria c = dc.getExecutableCriteria(session);
        
        List list = c.list();
        
        System.out.println(list);
        //----------------------------------------------------
        tx.commit();
        session.close();
     
    }
    
    @Test
    //复习 分页语法 - 与HQL一样
    public void fun3(){
        
        
        //Service/web层   凭空创建criteria
        DetachedCriteria dc  = DetachedCriteria.forClass(Dwxx.class);

        //----------------------------------------------------   
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Criteria c = dc.getExecutableCriteria(session);
     //limit ?,? 
     c.setFirstResult(0);
     c.setMaxResults(2);
     
     List<Dwxx> list = c.list();
     
     System.out.println(list);
     
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //排序语法 
    public void fun4(){
        //Service/web层   凭空创建criteria
        DetachedCriteria dc  = DetachedCriteria.forClass(Dwxx.class);
//        dc.addOrder(Order.asc("id"));
        dc.addOrder(Order.desc("id"));
        //----------------------------------------------------   
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Criteria c = dc.getExecutableCriteria(session);
     List<Dwxx> list = c.list();
     
     System.out.println(list);
     
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    


    @Test
    //模糊查询 
    public void fun5(){
        //Service/web层   凭空创建criteria
        DetachedCriteria dc  = DetachedCriteria.forClass(Dwxx.class);
        dc.add(Restrictions.like("dwmc", "%马路%"));//拼装条件(全部与普通Criteria一致)
        
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     
     Criteria c = dc.getExecutableCriteria(session);
     
     List list = c.list();
     System.out.println(list);
     
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    
}
