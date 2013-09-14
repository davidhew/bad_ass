package com.badass

/**
 * 为了简单起见，单独搞一张表来存放用户的当前余额
 * @author david
 *
 */
class UserBalance {
	User user;
	double balance;
	
	static constraints = {
		user nullable: false
		
	}

}
