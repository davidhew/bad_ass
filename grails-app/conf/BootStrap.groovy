import net.bull.javamelody.JdbcWrapper

import com.badass.data.InitUser



class BootStrap {
	def dataSource
	def initAll(){
		def initDataCollections
		initDataCollections = [
			new InitUser()
			
			
		]

		try {
			initDataCollections.each {it.populateData()}
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
		}
    }
	
    def destroy = {
    }
	
	
}
