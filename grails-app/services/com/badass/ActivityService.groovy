package com.badass

import com.bass.util.LanguageUtil

/**
 * 活动的 service 类
 * @author david
 *
 */
class ActivityService {
	
	
	def updateAct(Activity oldAct,Activity newAct){
		
		Set<User> oldUsers = oldAct.actors;
		Set<User> newUsers = newAct.actors;
		double oldDetailAmount = oldAct.amount/oldUsers.size();
		double newDetailAmount = newAct.amount/newUsers.size();
		//就的活动消费做反向操作
		for(User oldU:oldUsers){
			oldU.balance-=oldDetailAmount;
			oldU.save(flush:true);
		}
		
		//删除旧的活动detail
		oldAct.details.clear()
		oldAct.actors.clear();
		
		for(User newU:newUsers){
			//很可能oldU里面有和newU重合的，则其金额在上面发生了改变
			newU.refresh();
			ActivityDetail detail = new ActivityDetail();
			detail.user = newU;
			detail.act = newAct;
			detail.amount = newDetailAmount;
			detail.balance = newU.balance+detail.amount;
			newU.balance = detail.balance;
			detail.name = newAct.name;
			detail.act = newAct;
			oldAct.addToDetails(detail)
			oldAct.addToActors(newU)
			newU.save();
		}
		oldAct.save();
		
		return true;
	}
	
	def createActivity(Activity act){
		Set<User> users = act.actors;
		
		for(User user:users){
			
			ActivityDetail detail = new ActivityDetail();
			detail.user = user;
			detail.act = act;
			detail.amount = act.amount/users.size();
			detail.balance = user.balance+detail.amount;
			user.balance = detail.balance;
			detail.name = act.name;
			detail.act = act;
			act.addToDetails(detail);
			
			user.save();
		}
		act.save();
	}
	

}
