package com.badass

import org.junit.After
import org.junit.Before
import org.junit.Test

class ActivityDetailServiceTests {

	def activityDetailService;
	@Before
	void setUp(){
		
	}
	
	@After
	void tearDown() {
		
	}
	
	@Test
	void testSearchAll(){
		def controller = new ActivityDetailController()
		
		controller.params.name = "活动";
		def result = activityDetailService.search(controller.params)
		
		assert 20*User.list().size(), result.size()
	}
	
	@Test
	void testSearchByDateRanges(){
		def controller = new ActivityDetailController()
		
		controller.params.beginDate = new Date().plus(-1)
		def result = activityDetailService.search(controller.params)
		
		assert 2*User.list().size(), result.size()
	}
	
}
