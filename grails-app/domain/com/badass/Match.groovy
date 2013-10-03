package com.badass

/**
 * 比赛，用来记载一次比赛行为，为日后统计个人的得分排名以及参加活动的情况的数据来源
 * @author david
 *
 */
class Match {
	Date matchDate
	static hasMany = [actorsA: User,actorsB:User]
	String place
	//true 表示 actorsA获胜,flase表示actorsB获胜
	boolean win
	String name
	String comment
	
	def getActors(){
		StringBuilder strB = new StringBuilder();
		boolean first = true
		for(actor in actorsA){
			if(!first){
				strB.append(";")
				first = false;
			}
			strB.append(actor.nick)
			
		}
		strB.append(" vs ")
		first=true;
		
		for(actor in actorsB){
			if(!first){
				strB.append(",")
				first = false;
			}
			strB.append(actor.nick)
		}
		int length = strB.toString().length();
		if(length>20){
			length = 20
		}
		return strB.toString().substring(0, length)
	}
	static mapping = {
		//match是mysql的关键之，直接mapping行不通
		table "match_tbl"
	}
	
	static constraints = {
		name maxSize:128,blank: false, nullable: false
		comment nullable: true
		
	}
	

}
