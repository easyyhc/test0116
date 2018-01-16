/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 *@Title:
 *@Description:警员信息
 *@Author:yhc
 *@Since:2018年1月8日
 *@Version:1.1.0
 */
public class Jyxx1 {
    private Integer id;
    private String jybh; //警员编号
    private String jyxm;//警员姓名
    private String jyxb;//警员性别
    private Date jycsrq;//警员出生日期
    private String jyjg;//警员籍贯
    private String jyzw;//警员职位

    private String jyzt;//警员状态
    private String jybz;//警员备注
    
    private String jyssdwdm;//警员所属单位代码
    private String jyssdwmc;//警员所属单位名称
    
    //表示多对一的关系
    private Dwxx dwxx;
    
    private Set<Ajxx> ajxxset=new HashSet<Ajxx>();

    public Set<Ajxx> getAjxxset() {
        return ajxxset;
    }
    public void setAjxxset(Set<Ajxx> ajxxset) {
        this.ajxxset = ajxxset;
    }
    
    

    public Dwxx getDwxx() {
        return dwxx;
    }
    public void setDwxx(Dwxx dwxx) {
        this.dwxx = dwxx;
    }
    public Integer getId() {
     return id;
    }
    public void setId(Integer id) {
     this.id = id;
    }
    public String getJybh() {
     return jybh;
    }
    public void setJybh(String jybh) {
     this.jybh = jybh;
    }
    public String getJyxm() {
     return jyxm;
    }
    public void setJyxm(String jyxm) {
     this.jyxm = jyxm;
    }
    public String getJyxb() {
     return jyxb;
    }
    public void setJyxb(String jyxb) {
     this.jyxb = jyxb;
    }
    public Date getJycsrq() {
     return jycsrq;
    }
    public void setJycsrq(Date jycsrq) {
     this.jycsrq = jycsrq;
    }
    public String getJyjg() {
     return jyjg;
    }
    public void setJyjg(String jyjg) {
     this.jyjg = jyjg;
    }
    public String getJyzw() {
     return jyzw;
    }
    public void setJyzw(String jyzw) {
     this.jyzw = jyzw;
    }
    public String getJyssdwdm() {
     return jyssdwdm;
    }
    public void setJyssdwdm(String jyssdwdm) {
     this.jyssdwdm = jyssdwdm;
    }
    public String getJyssdwmc() {
     return jyssdwmc;
    }
    public void setJyssdwmc(String jyssdwmc) {
     this.jyssdwmc = jyssdwmc;
    }
    public String getJyzt() {
     return jyzt;
    }
    public void setJyzt(String jyzt) {
     this.jyzt = jyzt;
    }
    public String getJybz() {
     return jybz;
    }
    public void setJybz(String jybz) {
     this.jybz = jybz;
    }
   
    
    
}
