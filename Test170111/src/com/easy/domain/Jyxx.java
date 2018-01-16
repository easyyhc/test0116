package com.easy.domain;

import java.util.Date;


//持久化类满足以下条件
/*1.无参构造器 :反射生成实例
 *2.私有属性：要有set get方法修饰 底层会将查到的结果封装
 *3.使用包装数据类型： 可以为空 例如实际业务中：钱  Double类，null为默认值（说明未存钱），而100-100=0是数值。
 *4.持久化类要有唯一的OID持久化类与主键对应：区分是否是同一个持久化类 hibernate中不允许出现两个oid相同的持久化对象
 *5.持久化类不要使用final修饰：cglib动态代理
 * */
public class Jyxx {
	private String id;
	private String jybh; //警员编号
	private String jyxm;//警员姓名
	private String jyxb;//警员性别
	private Date jycsrq;//警员出生日期
	private String jyjg;//警员籍贯
	private String jyzw;//警员职位
	private String jyzt;//警员状态
	private String jybz;//警员备注
	
 private String jyssdwmc;//警员所属单位名称
 private String jyssdwdm;//警员所属单位代码

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
    @Override
    public String toString() {
        return "Jyxx [id=" + id + ", jybh=" + jybh + ", jyxm=" + jyxm
                + ", jyxb=" + jyxb + ", jycsrq=" + jycsrq + ", jyjg=" + jyjg
                + ", jyzw=" + jyzw + ", jyssdwdm=" + jyssdwdm + ", jyssdwmc="
                + jyssdwmc + ", jyzt=" + jyzt + ", jybz=" + jybz + "]";
    }
	
	
	
}
