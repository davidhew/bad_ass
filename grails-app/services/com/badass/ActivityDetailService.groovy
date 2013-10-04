package com.badass

class ActivityDetailService {
	
	def search(params){
		def criteria = ActivityDetail.createCriteria();
		def offset = 0
		def max = 20
		if(params.offset)
			offset = params.offset
		if(params.max)
			offset = params.max
		def results = criteria.list(max:max,offset:offset){
			and{
				if(params.name){
					like('name','%'+params.name+'%')
				}
				if(params.beginDate && params.endDate){
					between('actDate',params.beginDate,params.endDate+1)
				}
				if(params.user?.id){
					eq('user',User.get(params.user?.id))
				}
				//处理查询充值还是花销记录的逻辑
				if(params.amountType){
					if(params.amountType.equals("positive")){
						ge('amount',0)
					}else if(params.amountType.equals("negative")){
						le('amount',0)
					}
					
				}
			}
			
		}
	}

}
