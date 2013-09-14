package com.badass.data

import com.badass.User
import com.badass.User.SEX
import com.bass.util.DateUtil


class InitUser implements IInitData{
	void populateData(){
		
			def user = new User()
			user.with{
				name="徐涛"
				nick="教主"
				birdthDate=DateUtil.generateSimpleDate("19780506");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130808");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="何维"
				nick="大维"
				birdthDate=DateUtil.generateSimpleDate("19820211");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130701");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="邹莹"
				nick="joe"
				birdthDate=DateUtil.generateSimpleDate("19820222");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130701");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="贾旭"
				nick="九日"
				birdthDate=DateUtil.generateSimpleDate("19820822");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="辛增峰"
				nick="辛工"
				birdthDate=DateUtil.generateSimpleDate("19830401");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="张萍"
				nick="萍姐"
				birdthDate=DateUtil.generateSimpleDate("19820222");
				sex=SEX.WOMAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="郭彪"
				nick="老二"
				birdthDate=DateUtil.generateSimpleDate("19810506");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="梁帅"
				nick="梁总"
				birdthDate=DateUtil.generateSimpleDate("19811231");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
			
			user = new User()
			user.with{
				name="倪炎石"
				nick="石头"
				birdthDate=DateUtil.generateSimpleDate("19820709");
				sex=SEX.MAN;
				joinDate = DateUtil.generateSimpleDate("20130801");
				
			}
			user.save(flush:true, failOnError: true);
		}
	}
