package com.badass.data

import com.badass.Activity
import com.badass.ActivityService

/**
 * 数据订正
 * @author david
 *
 * 将活动明细的actDate订正为和Activity的actDate一致
 */
class ActivityDetailActDateDataFix implements IDataFix{
	void dataFix(){
		List<Activity> acts = Activity.list();
		for(Activity act:acts){
			if(act.enterDate==null){
				//设置为现在
				act.enterDate=new Date();
				act.save(flush:true,failOnError:true);
			}
			for(detail in act.details){
				detail.actDate = act.actDate;
				detail.name = ActivityService.getDetailName(act.name,detail.user);
				if(detail.enterDate == null){
					detail.enterDate = act.enterDate;
				}
				detail.save(flush:true,failOnError:true)
			}
			
			}
	}
}
