/**
 *@Copyright:Copyright (c) 2017 - 2100
 *@Company:easy
 */
package com.easy.domain;


/**
 *@Title:
 *@Description:
 *@Author:yhc
 *@Since:2018年1月15日
 *@Version:1.1.0
 */
public class DwJy {
    
   public DwJy() {
//        super();
    }
public DwJy(String jyname, String dwname) {
        super();
        this.jyname = jyname;
        this.dwname = dwname;
    }
   private String id;
   private String jyname;
   private String dwname;

   
   
public String getId() {
    return id;
}
public void setId(String id) {
    this.id = id;
}
public String getJyname() {
    return jyname;
}
public void setJyname(String jyname) {
    this.jyname = jyname;
}
public String getDwname() {
    return dwname;
}
public void setDwname(String dwname) {
    this.dwname = dwname;
}
   
   
}
