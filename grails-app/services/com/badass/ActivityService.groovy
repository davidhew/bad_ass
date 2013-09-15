package com.badass

/**
 * 活动的 service 类
 * @author david
 *
 */
class ActivityService {
	
	def createActivity(Activity act){
		Set<User> users = act.actors;
		act.save();
		for(User user:users){
//			UserBalance uBalance = UserBalance.findByUser(user);
			
//			if(uBalance == null){
//				uBalance = new UserBalance(user:user,balance:0);
//			}
			
			ActivityDetail detail = new ActivityDetail();
			detail.user = user;
			detail.act = act;
			detail.amount = act.amount/users.size();
			detail.balance = user.balance+detail.amount;
			user.balance = detail.balance;
			detail.name = act.name;
			detail.act = act;
			detail.save();
			
			user.save();
		}
		
		
		return true;
		
	}

}
