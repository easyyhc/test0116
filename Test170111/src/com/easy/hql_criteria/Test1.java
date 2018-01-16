/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.hql_criteria;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.easy.domain.DwJy;
import com.easy.domain.Dwxx;
import com.easy.utils.HibernateUitls;


/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018年1月10日
 *@Version:1.1.0
 */
public class Test1 {

  //基本语法
    @Test
    public void fun1(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " from  com.easy.domain.Jyxx1 ";//完整写法
     String hql2 = " from  Jyxx1 "; //简单写法
     String hql3 = " from java.lang.Object "; //查出所有对象
     
     Query query = session.createQuery(hql3);
     
     List list = query.list();
     
     System.out.println(list);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    
    @Test
    //复习：排序
    public void fun2(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " from  Dwxx order by id asc ";//完整写法
     String hql2 = " from  Dwxx order by id desc ";//完整写法
     
     Query query = session.createQuery(hql1);
     
     List list = query.list();
     
     System.out.println(list);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }

    @Test
    //复习：条件查询
    public void fun3(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " from  Dwxx where id =? ";//完整写法
     String hql2 = " from  Dwxx where id = :id ";//完整写法
     
     Query query = session.createQuery(hql2);
     
   //  query.setParameter(0, 1);
     query.setParameter("id", 1);
     
     
     List list = query.list();
     
     System.out.println(list);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //复习：分页查询
    public void fun4(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " from  Dwxx  ";//完整写法
     
     Query query = session.createQuery(hql1);
     
     //limit ?,?
     // (当前页数-1)*每页条数
     query.setFirstResult(2);
     query.setMaxResults(2);
     
     List list = query.list();
     
     System.out.println(list);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //统计查询
    //count 计数
    //sum  求和
    //avg 平均数
    //max
    //min
    public void fun5(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " select count(*) from Dwxx    ";//完整写法
     String hql2 = " select sum(cust_id) from  Dwxx  ";//完整写法
     String hql3 = " select avg(cust_id) from  Dwxx  ";//完整写法
     String hql4 = " select max(cust_id) from  Dwxx  ";//完整写法
     String hql5 = " select min(cust_id) from  Dwxx  ";//完整写法
     
     Query query = session.createQuery(hql1);
     
     Number number  = (Number) query.uniqueResult();
     
     System.out.println(number);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    
    @Test
    //投影查询 select 成员变量名  from 类名
    public void fun6(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql1 = " select dwmc from  Dwxx  ";
     String hql2 = " select dwdm,dwmc from  Dwxx  ";
     //封装到dwxx对象中，需要有对应参数类型的构造函数
     String hql3 = " select new Dwxx(dwdm,dwmc) from  Dwxx  ";
     
     Query query = session.createQuery(hql3);
     
     List list = query.list();
     
     System.out.println(list);

     
     //----------------------------------------------------
     tx.commit();
     session.close();
    }
    
//    多表查询语法
  //回顾-原生SQL
    // 交叉连接-笛卡尔积(避免)
   //  select * from jjyxx t1,jdwxx t2
    // 内连接
   //  |-隐式内连接
   //   select * from jjyxx t1,jdwxx t2 where t1.dwid = t2.id
   //  |-显式内连接
   //   select * from jjyxx t1 inner  join jdwxx t2 on t1.dwid = t2.id
    // 外连接
   //  |- 左外
   //   select * from jjyxx t1 left outer join  jdwxx t2 on t1.dwid = t2.id
   //  |- 右外
   //   select * from jjyxx t1 right outer join jdwxx t2 on t1.dwid = t2.id
   //---------------------------------------------------------------------
   //HQL的多表查询
     //内连接(迫切)
     //外连接
   //   |-左外(迫切)
   //   |-右外(迫切)
    
    @Test
    //HQL 内连接 => 将连接的两端对象分别返回.放到数组中.
    public void fun7(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 inner join t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Object[]> list = query.list();
     
     for(Object[] arr : list){
      System.out.println(Arrays.toString(arr));
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //HQL 迫切内连接 => 帮我们进行封装.返回值就是一个对象
    public void fun8(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 inner join fetch t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Dwxx> list = query.list();
     
     System.out.println(list);
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //HQL 左外连接 => 将连接的两端对象分别返回.放到数组中.
    public void fun9(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 left join t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Object[]> list = query.list();
     
     for(Object[] arr : list){
      System.out.println(Arrays.toString(arr));
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    @Test
    //HQL 迫切左外连接 => 将连接的两端对象帮我们进行封装.返回值就是一个对象
    public void fun10(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 left join fetch t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Dwxx> list = query.list();
     
     for(Dwxx arr : list){
      System.out.println(arr);
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    @Test
    //HQL 右外连接 => 将连接的两端对象分别返回.放到数组中.
    public void fun11(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 right join t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Object[]> list = query.list();
     
     for(Object[] arr : list){
      System.out.println(Arrays.toString(arr));
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    @Test
    //HQL 迫切右外连接 => 将连接的两端对象帮我们进行封装.返回值就是一个对象
    public void fun12(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " from Dwxx t1 right join fetch t1.jyxxset ";
     
     Query query = session.createQuery(hql);
     
     List<Dwxx> list = query.list();
     
     for(Dwxx arr : list){
      System.out.println(arr);
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
    @Test
    //HQL 两个字段来自不同对象（表） 
    public void fun13(){
     Session session = HibernateUitls.openSession();
     Transaction tx = session.beginTransaction();
     //----------------------------------------------------
     String hql = " select new DwJy(t1.dwmc,t2.jyxm) from Dwxx t1 inner join  t1.jyxxset t2";
           //join后不能加fetch！！！
     
     Query query = session.createQuery(hql);
     
     List<DwJy> list = query.list();
     
     for(DwJy arr : list){
      System.out.println(arr);
     }
     //----------------------------------------------------
     tx.commit();
     session.close();
     
    }
    
}
