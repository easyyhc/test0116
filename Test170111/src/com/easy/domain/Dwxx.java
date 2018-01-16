/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.domain;

import java.util.HashSet;
import java.util.Set;



/**
 *@Title:
 *@Description:单位信息
 *@Author:yhc
 *@Since:2018年1月9日
 *@Version:1.1.0
 */
public class Dwxx {
    
   public Dwxx() {
        super();
    }
public Dwxx(String dwdm, String dwmc) {
        super();
        this.dwdm = dwdm;
        this.dwmc = dwmc;
    }
private Integer id ;
   private String dwdm ;
   private String dwmc;
   private String dwszds;
   private String dwszdq;
   private String dwszdjd;
   private String dwzt;
   private String dwbz;
//   表示一对多的关系
   private Set<Jyxx1> jyxxset=new HashSet<Jyxx1>();
  
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
public String getDwdm() {
    return dwdm;
}
public void setDwdm(String dwdm) {
    this.dwdm = dwdm;
}
public String getDwmc() {
    return dwmc;
}
public void setDwmc(String dwmc) {
    this.dwmc = dwmc;
}
public String getDwszds() {
    return dwszds;
}
public void setDwszds(String dwszds) {
    this.dwszds = dwszds;
}
public String getDwszdq() {
    return dwszdq;
}
public void setDwszdq(String dwszdq) {
    this.dwszdq = dwszdq;
}
public String getDwszdjd() {
    return dwszdjd;
}
public void setDwszdjd(String dwszdjd) {
    this.dwszdjd = dwszdjd;
}
public String getDwzt() {
    return dwzt;
}
public void setDwzt(String dwzt) {
    this.dwzt = dwzt;
}
public String getDwbz() {
    return dwbz;
}
public void setDwbz(String dwbz) {
    this.dwbz = dwbz;
}
@Override
public String toString() {
    return "Dwxx [id=" + id + ", dwdm=" + dwdm + ", dwmc=" + dwmc + ", dwszds="
            + dwszds + ", dwszdq=" + dwszdq + ", dwszdjd=" + dwszdjd + ", dwzt="
            + dwzt + ", dwbz=" + dwbz + "]";
}

}
