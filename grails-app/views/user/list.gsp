
<%@ page import="com.badass.User" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-user" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
				<thead>
					<tr>
					
						<g:sortableColumn property="nick" title="${message(code: 'nick.label', default: 'Nick')}" />
					
						<g:sortableColumn property="name" title="${message(code: 'user.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="birdthDate" title="${message(code: 'birdthDate.label', default: 'Birdth Date')}" />
					
						<g:sortableColumn property="joinDate" title="${message(code: 'user.joinDate.label', default: 'Join Date')}" />
					
						<g:sortableColumn property="balance" title="${message(code: 'balance.label', default: 'Balance')}" />
					
						<g:sortableColumn property="sex" title="${message(code: 'sex.label', default: 'Sex')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${userInstanceList}" status="i" var="userInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${userInstance.id}">${fieldValue(bean: userInstance, field: "nick")}</g:link></td>
					
						<td>${fieldValue(bean: userInstance, field: "name")}</td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${userInstance.birdthDate}" /></td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${userInstance.joinDate}" /></td>
					
						<td>${fieldValue(bean: userInstance, field: "balance")}</td>
					
						<td>${fieldValue(bean: userInstance, field: "sex")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${userInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
