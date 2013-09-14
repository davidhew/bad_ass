<%@ page import="com.badass.User" %>



<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'nick', 'error')} required">
	<label for="nick">
		<g:message code="user.nick.label" default="Nick" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="nick" maxlength="32" required="" value="${userInstance?.nick}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="user.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="32" required="" value="${userInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'birdthDate', 'error')} required">
	<label for="birdthDate">
		<g:message code="user.birdthDate.label" default="Birdth Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="birdthDate" precision="day"  value="${userInstance?.birdthDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'joinDate', 'error')} required">
	<label for="joinDate">
		<g:message code="user.joinDate.label" default="Join Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="joinDate" precision="day"  value="${userInstance?.joinDate}"  />
</div>


<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'sex', 'error')} required">
	<label for="sex">
		<g:message code="user.sex.label" default="Sex" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="sex" from="${com.badass.User$SEX?.values()}" keys="${com.badass.User$SEX.values()*.name()}" required="" value="${userInstance?.sex?.name()}"/>
</div>

