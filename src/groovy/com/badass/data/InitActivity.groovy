package com.badass.data

import org.codehaus.groovy.grails.commons.ApplicationHolder

import com.badass.Activity
import com.badass.User

class InitActivity {
	def activityService = ApplicationHolder.getApplication().getMainContext().activityService
	void populateData(){
		def users = User.list();
		20.times { i ->
			Activity act = new Activity();
			act.name = "测试活动"+i
			Set<User> userSet = new HashSet<User>(5)
			userSet.addAll(users)
			act.actors = userSet
			act.actDate = new Date().plus(-i)
			act.amount = 100 * i
			act.comment = "";

			activityService.createActivity(act)
		}
	}
}
