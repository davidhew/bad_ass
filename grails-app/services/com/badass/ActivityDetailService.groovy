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
			}
			
		}
	}

}
