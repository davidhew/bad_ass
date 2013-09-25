
<%@ page import="com.badass.ActivityDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activityDetail.label', default: 'ActivityDetail')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-activityDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-activityDetail" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list activityDetail">
			
				<g:if test="${activityDetailInstance?.amount}">
				<li class="fieldcontain">
					<span id="amount-label" class="property-label"><g:message code="amount.label" default="Amount" /></span>
					
						<span class="property-value" aria-labelledby="amount-label"><g:fieldValue bean="${activityDetailInstance}" field="amount"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityDetailInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${activityDetailInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityDetailInstance?.user}">
				<li class="fieldcontain">
					<span id="user-label" class="property-label"><g:message code="actors.label" default="User" /></span>
					
						<span class="property-value" aria-labelledby="user-label"><g:link controller="user" action="show" id="${activityDetailInstance?.user?.id}">${activityDetailInstance?.user?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityDetailInstance?.balance}">
				<li class="fieldcontain">
					<span id="balance-label" class="property-label"><g:message code="balance.label" default="Balance" /></span>
					
						<span class="property-value" aria-labelledby="balance-label"><g:fieldValue bean="${activityDetailInstance}" field="balance"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${activityDetailInstance?.actDate}">
				<li class="fieldcontain">
					<span id="date-label" class="property-label"><g:message code="actDate.label" default="Date" /></span>
					
						<span class="property-value" aria-labelledby="date-label"><g:formatDate date="${activityDetailInstance?.actDate}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${activityDetailInstance?.id}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
