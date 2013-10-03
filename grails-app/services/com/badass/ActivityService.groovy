package com.badass

import com.bass.util.LanguageUtil

/**
 * 活动的 service 类
 * @author david
 *
 */
class ActivityService {
	
	/**
	 * 还没完全吃透grails和hibernate
	 * 所以对于act的编辑，采取这样的逻辑，让oldAct代表在数据库存在的，已经持久化的要修改的活动；
	 * 而newAct代表了用户对oldAct的修改后的信息，但是newAct 没有持久化
	 * @param oldAct
	 * @param newAct
	 * @return
	 */
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
		
		//把新的编辑后的活动属性拷贝给oldAct
		oldAct.properties = newAct.properties;
		for(User newU:newUsers){
			//很可能oldU里面有和newU重合的，则其金额在上面发生了改变
			newU.refresh();
			generateActDetail(oldAct, newU, newUsers.size())
			newU.save();
		}

		
		oldAct.enterDate = new Date();
		oldAct.save(failOnError:true);
		
		return true;
	}
	

	
	def createActivity(Activity act){
		Set<User> users = act.actors;
		
		for(User user:users){
			
			generateActDetail(act, user, users.size())
			
		}
		act.save(failOnError:true);
		
	}
	
	def generateActDetail(Activity act,User user, int userCount){
		ActivityDetail detail = new ActivityDetail();
		detail.user = user;
		detail.act = act;
		detail.amount = act.amount/userCount;
		detail.balance = user.balance+detail.amount;
		user.balance = detail.balance;
		detail.name = getDetailName(act.name,user);
		detail.act = act;
		detail.actDate = act.actDate;
		act.addToDetails(detail);
		
	}
	
	static def getDetailName(String actName,User user){
		
		return user.nick + "-" + actName; 
	}
	

}
