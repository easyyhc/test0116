/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.domain;

import java.util.HashSet;
import java.util.Set;

/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018年1月9日
 *@Version:1.1.0
 */


/**
 *@Title:
 *@Description:案件信息
 *@Author:yhc
 *@Since:2018年1月9日
 *@Version:1.1.0
 */
public class Ajxx {
   private Integer id;
   private String ajbh;
   private String ajlb;
   private String ajssdwdm;
   private String ajssdwmc;
   private String ajzt;
   private String ajjbxx;
   private Set<Jyxx1> jyxxset=new HashSet<Jyxx1>();;
   
   
  public Set<Jyxx1> getJyxxset() {
      return jyxxset;
  }
  public void setJyxxset(Set<Jyxx1> jyxxset) {
      this.jyxxset = jyxxset;
  }
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getAjbh() {
    return ajbh;
}
public void setAjbh(String ajbh) {
    this.ajbh = ajbh;
}
public String getAjlb() {
    return ajlb;
}
public void setAjlb(String ajlb) {
    this.ajlb = ajlb;
}
public String getAjssdwdm() {
    return ajssdwdm;
}
public void setAjssdwdm(String ajssdwdm) {
    this.ajssdwdm = ajssdwdm;
}
public String getAjssdwmc() {
    return ajssdwmc;
}
public void setAjssdwmc(String ajssdwmc) {
    this.ajssdwmc = ajssdwmc;
}
public String getAjzt() {
    return ajzt;
}
public void setAjzt(String ajzt) {
    this.ajzt = ajzt;
}
public String getAjjbxx() {
    return ajjbxx;
}
public void setAjjbxx(String ajjbxx) {
    this.ajjbxx = ajjbxx;
}

}
