package com.badass

/**
 * 用户类/会员类
 * @author david
 *
 */
class User {
	//昵称，系统唯一
	String nick;
	
	//真实姓名
	String name;
	
	//出生年月，可以用来以后计算一些体育生理指标
	Date birdthDate;
	
	//加入协会时间
	Date joinDate;
	
	//性别
	SEX sex;
	
	//用户余额
	double balance = 0;
	
	public static final enum SEX{
		MAN(1,"男"),
		WOMAN(2,"女");
		
		String desc;
		int value;
		
		public SEX(int value,String desc){
			this.value = value;
			this.desc = desc;
		}
		
		public int getId(){
			return value;
		}
		
		public String toString(){
			return desc;
		}
	}
	
	static constraints = {
		nick maxSize:32,blank: false, nullable: false
		name maxSize:32,blank: false, nullable: false
		birdthDate nullable: false
		joinDate nullable: false
		
	}
	
	public String toString(){
		return nick;
	}

}
