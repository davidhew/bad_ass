import net.bull.javamelody.JdbcWrapper

import com.badass.data.ActivityDetailActDateDataFix
import com.badass.data.InitActivity
import com.badass.data.InitUser



class BootStrap {
	def dataSource
	def initAll(){
		def initDataCollections
		initDataCollections = [
			new InitUser(),
			new InitActivity()
			
			
		]

		try {
			initDataCollections.each {it.populateData()}
		} catch (Throwable t) {
			log.error(t, t)
		}
	}
	
	def dataFixAll(){
		def dataFixCollections
		dataFixCollections = [
			new ActivityDetailActDateDataFix()
		]

		try {
			dataFixCollections.each {it.dataFix()}
		} catch (Throwable t) {
			log.error(t, t)
		}
	}
	
	
	
    def init = { servletContext ->
		dataSource.targetDataSource = JdbcWrapper.SINGLETON.createDataSourceProxy(dataSource.targetDataSource)
		environments {
			development {
				initAll()
				
			}
			test{
				initAll()
			}
//			非常态，只有要做数据订正时才开启
//			datafix{
//				dataFixAll()
//			}
		}
    }
	
    def destroy = {
    }
	
	
}
