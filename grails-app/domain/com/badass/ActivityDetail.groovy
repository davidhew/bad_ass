package com.badass

/**
 * 活动明细，是到会员-活动维度，也就是如果一个活动有n个会员参加，则会拆分成n条明细，每条明细
 * 会记录该会员自己应该承担的金额，同时在明细里面，也会记录该会员截止到目前为止，总的余额是多少
 * @author david
 *
 */
class ActivityDetail {
	
	//对应的会员
	User user;
	
	//活动名称，和Activity中的name 冗余，提高性能，避免为了知道活动名称而去走activity表
	String name;
	//活动发生时间
	Date actDate = new Date();
	//录入时间
	Date enterDate = new Date();
	
	//对应到该会员身上的费用
	double amount;
	
	//该会员的余额
	double balance;
	
	static belongsTo = [act: Activity]
	
	static constraints = {
		amount blank: false, nullable: false
		name maxSize:128,blank: false, nullable: false
		user nullable: false
		actDate nullable: false
		enterDate nullable: false
		
	}
	
}
