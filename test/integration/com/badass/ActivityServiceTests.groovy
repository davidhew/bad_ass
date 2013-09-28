package com.badass

import static org.junit.Assert.*

import org.junit.*

import com.badass.data.InitUser
import com.bass.util.DateUtil

class ActivityServiceTests {

	static transactional = true
	def activityService

	@Before
	void setUp() {
		//产生用户数据
		new InitUser().populateData();
	}

	@After
	void tearDown() {
		// Tear down logic here
	}

	@Test
	void testUpdateAct(){

		Set<User> oldActUsers = new HashSet<User>(4);
		oldActUsers.add(User.findByNick("教主"));
		oldActUsers.add(User.findByNick("大维"));
		oldActUsers.add(User.findByNick("joe"));
		oldActUsers.add(User.findByNick("九日"));

		Set<User> newUsers = new HashSet<User>(5);
		newUsers.addAll(oldActUsers);

		Activity oldAct = new Activity();
		oldAct.amount = -200;
		oldAct.actDate = DateUtil.generateSimpleDate("20130724");
		oldAct.name = "测试活动";
		oldAct.actors = oldActUsers;
		oldAct.comment = "";
		activityService.createActivity(oldAct);
		oldAct = Activity.findByName(oldAct.name);
		
		assert oldAct.id != null
		assertEquals 4,oldAct.details.size()

		Activity newAct = new Activity();
		newAct.amount=200;
		newAct.actDate = DateUtil.generateSimpleDate("20130728");
		newAct.name = "新测试活动";
		newAct.actors = newUsers;
		newAct.comment="";
		activityService.updateAct(oldAct,newAct);
		assert oldAct.name.equals(newAct.name)
		assert oldAct.actDate.equals(DateUtil.generateSimpleDate("20130728"))
		assert 5,oldAct.details.size()

		for(ActivityDetail detail:oldAct.details){
			//活动detail的时间需要和活动的时间保持一致
			assert detail.actDate.equals(oldAct.actDate);
			//确保名字是正确的
			assert detail.name.equals(detail.user.nick + "-"+oldAct.name)
		}
	}
}
