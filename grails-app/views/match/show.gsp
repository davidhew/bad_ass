
<%@ page import="com.badass.Match" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'match.label', default: 'Match')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-match" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="list"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-match" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list match">
			
				<g:if test="${matchInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="match.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${matchInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.comment}">
				<li class="fieldcontain">
					<span id="comment-label" class="property-label"><g:message code="match.comment.label" default="Comment" /></span>
					
						<span class="property-value" aria-labelledby="comment-label"><g:fieldValue bean="${matchInstance}" field="comment"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.actorsA}">
				<li class="fieldcontain">
					<span id="actorsA-label" class="property-label"><g:message code="match.actorsA.label" default="Actors A" /></span>
					
						<g:each in="${matchInstance.actorsA}" var="a">
						<span class="property-value" aria-labelledby="actorsA-label"><g:link controller="user" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.actorsB}">
				<li class="fieldcontain">
					<span id="actorsB-label" class="property-label"><g:message code="match.actorsB.label" default="Actors B" /></span>
					
						<g:each in="${matchInstance.actorsB}" var="a">
						<span class="property-value" aria-labelledby="actorsB-label"><g:link controller="user" action="show" id="${a.id}">${a?.encodeAsHTML()}</g:link></span>
						</g:each>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.matchDate}">
				<li class="fieldcontain">
					<span id="matchDate-label" class="property-label"><g:message code="match.matchDate.label" default="Match Date" /></span>
					
						<span class="property-value" aria-labelledby="matchDate-label"><g:formatDate date="${matchInstance?.matchDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.place}">
				<li class="fieldcontain">
					<span id="place-label" class="property-label"><g:message code="match.place.label" default="Place" /></span>
					
						<span class="property-value" aria-labelledby="place-label"><g:fieldValue bean="${matchInstance}" field="place"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${matchInstance?.win}">
				<li class="fieldcontain">
					<span id="win-label" class="property-label"><g:message code="match.win.label" default="Win" /></span>
					
						<span class="property-value" aria-labelledby="win-label"><g:formatBoolean boolean="${matchInstance?.win}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${matchInstance?.id}" />
					<g:link class="edit" action="edit" id="${matchInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
