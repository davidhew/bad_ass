package com.badass

/**
 * 活动，会导致协会整体以及个人在协会里资金余额发生变化的一个事件叫做一次活动
 * 1.协会集体打球，这是一个活动，打球的花费，会影响到大家在协会资金的余额
 * 2.会员个人充值了，也会被看作一次活动，因为这个活动会影响到他在协会资金的余额
 * 3.1和2其实应该通过类型区分开来，但是先暂时不区分，以后有需求了再进行区分
 * @author david
 *
 */
class Activity {
	
	//活动名称
	String name;
	
	//活动日期
	Date actDate = new Date();
	
	//参与者，至少会有一个人
	static hasMany = [actors: User]
	
	//对应的活动明细
	static hashMany = [details:ActivityDetail]
	
	//活动备注
	String comment;
	
	//活动的费用，用正值表明增加多少钱，负值表明要扣掉多少钱
	double amount;
	
	static constraints = {
		amount blank: false, nullable: false
		name maxSize:128,blank: false, nullable: false
		actDate nullable: false
		
	}
	
	
}