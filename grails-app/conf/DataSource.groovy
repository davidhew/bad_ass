dataSource {
	pooled = true
	driverClassName = "com.mysql.jdbc.Driver"
	dialect = org.hibernate.dialect.MySQL5DBDialect
	properties {
		maxActive = 50
		maxIdle = 25
		minIdle = 5
		initialSize = 5
		minEvictableIdleTimeMillis = 60000
		timeBetweenEvictionRunsMillis = 60000
		maxWait = 10000
		validationQuery = "/* ping */"

	}
}
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = false
	cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
	development {
		dataSource {
			//dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			dbCreate = "create-drop"
			logSql = true
			url = "jdbc:mysql://localhost/bad_ass?useUnicode=true&amp;characterEncoding=utf-8"
			username = "pure_water"
			password = "1345&*eqte"
		}

	
	}
	test {
		dataSource {
			//dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			dbCreate = "create-drop"
			logSql = true
			url = "jdbc:mysql://localhost/bad_ass?useUnicode=true&amp;characterEncoding=utf-8"
			username = "pure_water"
			password = "1345&*eqte"
		}

	
	}

// 非常态，只有真正要做数据订正时才开启
	datafix {
		dataSource {
			//dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			dbCreate = "update"
			logSql = true
			url = "jdbc:mysql://localhost/bad_ass?useUnicode=true&amp;characterEncoding=utf-8"
			username = "pure_water"
			password = "1345&*eqte"
		}

	
	}
	localtest {
		dataSource {
			//dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
			//url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000"
			dbCreate = "create-drop"
			logSql = true
			url = "jdbc:mysql://localhost/bad_ass?useUnicode=true&amp;characterEncoding=utf-8"
			username = "pure_water"
			password = "1345&*eqte"
		}
	}

	datadump {
		dataSource {
			dbCreate = "create-drop"
			logSql = true
			url = "jdbc:mysql://localhost/ccclubs"
			username = "root"
			password = "ccclubs2013"
		}

	}

	production {
		dataSource {
			dbCreate = "update"
			url = "jdbc:mysql://localhost/bad_ass_prod?useUnicode=true&amp;characterEncoding=utf-8"
			username = "pure_water"
			password = "1345&*eqte"

		}
	}
	
}