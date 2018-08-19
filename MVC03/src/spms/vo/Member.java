package spms.vo;

import java.util.Date;

public class Member {
	protected int mno;
	protected String email;
	protected String pwd;
	protected String mname;
	protected Date cdate;
	protected Date mdate;
	
	public Member setMno(int mno){
		this.mno = mno;
		return this;
	}
	
	public int getMno(){
		return mno;
	}
	
	public Member setEmail(String email){
		this.email = email;
		return this;
	}
	
	public String getEmail(){
		return email;
	}
	
	public Member setName(String name){
		this.mname = name;
		return this;
	}
	
	public String getName(){
		return mname;
	}
	
	public Member setPwd(String pwd){
		this.pwd = pwd;
		return this;
	}
	
	public String getPwd(){
		return pwd;
	}
	
	public Member setCdate(Date cdate){
		this.cdate = cdate;
		return this;
	}
	
	public Date getCdate(){
		return cdate;
	}
	
	public Member setMdate(Date mdate){
		this.mdate = mdate;
		return this;
	}
	
	public Date getMdate(){
		return mdate;
	}
}


