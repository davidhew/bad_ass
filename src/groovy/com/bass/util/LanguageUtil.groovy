package com.bass.util

class LanguageUtil {
	
	def copyProperties(source, target) {
		target.properties.each { key, value ->
			if (source.metaClass.hasProperty(source, key) && key != 'class' && key != 'metaClass' && key!='id') {
				target.setProperty(key, source.metaClass.getProperty(source, key))
			}
		}
	}

}
