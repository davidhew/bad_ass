
<%@ page import="com.badass.Activity" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activity.label', default: 'Activity')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-activity" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-activity" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
					    <g:sortableColumn property="name" title="${message(code: 'name.label', default: 'Name')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'amount.label', default: 'Amount')}" />
					
						<g:sortableColumn property="actDate" title="${message(code: 'actDate.label', default: 'Act Date')}" />
					
						<g:sortableColumn property="comment" title="${message(code: 'comment.label', default: 'Comment')}" />
						
					</tr>
				</thead>
				<tbody>
				<g:each in="${activityInstanceList}" status="i" var="activityInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${activityInstance.id}">${fieldValue(bean: activityInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: activityInstance, field: "amount")}</td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${activityInstance.actDate}" /></td>
					
						<td>${fieldValue(bean: activityInstance, field: "comment")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${activityInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
