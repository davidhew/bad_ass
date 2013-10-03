package com.badass

import static org.junit.Assert.*

import org.hibernate.FlushMode
import org.junit.*

import com.bass.util.DateUtil

class ActivityServiceTests {

//	static transactional = true
	def activityService
	
	def actHolderID

	@Before
	void setUp() {
		//产生用户数据
//		new InitUser().populateData();
	}

	@After
	void tearDown() {
		//需要先删除关联的detail,
		//TODO:搞不定级联删除，只能用土办法来搞
	
//		ActivityDetail.executeQuery("delete from ActivityDetail a where a.act.id=:actID",[actID:actHolderID,flushMode:FlushMode.AUTO])
//		def actHolder = Activity.get(actHolderID)
//		actHolder.details.clear();
//		actHolder.save(flush:true);
//		actHolder.refresh();
//		def l = []
//		l += actHolder.details
//		
//		l.each { detail ->
//			actHolder.removeFromDetails(detail)
//			detail.delete(flush:true)
//			
//		}
//		actHolder.save(flush:true,failOnError:true);
//		actHolder.delete(flush:true,failOnError:true);
//		def acts = Activity.list()
//		for(act in acts){
//			act.delete(flush:true);
//		}
	}
	
	@Test
	void testCreateAct(){
		def userOne = User.findByNick("大维")
		double initBalance = userOne.balance
		Set<User> oldActUsers = new HashSet<User>(4);
		oldActUsers.add(User.findByNick("教主"));
		oldActUsers.add(User.findByNick("大维"));
		oldActUsers.add(User.findByNick("joe"));
		oldActUsers.add(User.findByNick("九日"));
		Activity act = new Activity();
		act.amount = -200;
		act.actDate = DateUtil.generateSimpleDate("20130724");
		act.name = "测试活动";
		act.actors = oldActUsers;
		act.comment = "";
		assert act.id == null
		activityService.createActivity(act);
		assert initBalance-50 == User.findByNick("大维").balance
		act = Activity.findByName(act.name);
		assert act.details.size()==4
		for(detail in act.details){
			assert detail.actDate.equals(act.actDate)
		}
		
	}
	
	@Test
	void testUpdateAct(){

		def userOne = User.findByNick("大维")
		double initBalance = userOne.balance
		Set<User> oldActUsers = new HashSet<User>(4);
		oldActUsers.add(User.findByNick("教主"));
		oldActUsers.add(User.findByNick("大维"));
		oldActUsers.add(User.findByNick("joe"));
		oldActUsers.add(User.findByNick("九日"));

		Set<User> newUsers = new HashSet<User>(5);
		newUsers.addAll(oldActUsers);
		newUsers.add(User.findByNick("梁总"));
		Activity oldAct = new Activity();
		oldAct.amount = -200;
		oldAct.actDate = DateUtil.generateSimpleDate("20130724");
		oldAct.name = "测试活动";
		oldAct.actors = oldActUsers;
		oldAct.comment = "";
		assert oldAct.id == null
		activityService.createActivity(oldAct);
		assert initBalance-50 == User.findByNick("大维").balance
		oldAct = Activity.findByName(oldAct.name);
		
		assert oldAct.id != null
		assert 4==oldAct.details.size()

		Activity newAct = new Activity();
		newAct.amount=200;
		newAct.actDate = DateUtil.generateSimpleDate("20130728");
		newAct.name = "新测试活动";
		newAct.actors = newUsers;
		newAct.comment="";
		activityService.updateAct(oldAct,newAct);
		assert oldAct.name.equals(newAct.name)
		assert oldAct.actDate.equals(DateUtil.generateSimpleDate("20130728"))
		assert 5==oldAct.details.size()
		assert initBalance+40 == User.findByNick("大维").balance
		for(ActivityDetail detail:oldAct.details){
			//活动detail的时间需要和活动的时间保持一致
			assert detail.actDate.equals(oldAct.actDate);
			//确保名字是正确的
			assert detail.name.equals(detail.user.nick + "-"+oldAct.name)
		}
		oldAct.save(failOnError:true,flush:true)
		oldAct.refresh()
//		oldAct = Activity.get(21)
		oldAct.delete(flush:true)
//		actHolderID = oldAct.id
	}
	
	

//	@Test
//	void testUpdateAct(){
//
//		Set<User> oldActUsers = new HashSet<User>(4);
//		oldActUsers.add(User.findByNick("教主"));
//		oldActUsers.add(User.findByNick("大维"));
//		oldActUsers.add(User.findByNick("joe"));
//		oldActUsers.add(User.findByNick("九日"));
//
//		Set<User> newUsers = new HashSet<User>(5);
//		newUsers.addAll(oldActUsers);
//
//		Activity oldAct = new Activity();
//		oldAct.amount = -200;
//		oldAct.actDate = DateUtil.generateSimpleDate("20130724");
//		oldAct.name = "测试活动";
//		oldAct.actors = oldActUsers;
//		oldAct.comment = "";
//		activityService.createActivity(oldAct);
//		oldAct = Activity.findByName(oldAct.name);
//		
//		assert oldAct.id != null
//		assertEquals 4,oldAct.details.size()
//
//		Activity newAct = new Activity();
//		newAct.amount=200;
//		newAct.actDate = DateUtil.generateSimpleDate("20130728");
//		newAct.name = "新测试活动";
//		newAct.actors = newUsers;
//		newAct.comment="";
//		activityService.updateAct(oldAct,newAct);
//		assert oldAct.name.equals(newAct.name)
//		assert oldAct.actDate.equals(DateUtil.generateSimpleDate("20130728"))
//		assert 5,oldAct.details.size()
//
//		for(ActivityDetail detail:oldAct.details){
//			//活动detail的时间需要和活动的时间保持一致
//			assert detail.actDate.equals(oldAct.actDate);
//			//确保名字是正确的
//			assert detail.name.equals(detail.user.nick + "-"+oldAct.name)
//		}
//		oldAct.delete(flush:true)
////		actHolderID = oldAct.id
//	}
}
