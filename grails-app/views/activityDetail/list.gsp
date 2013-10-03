
<%@ page import="com.badass.ActivityDetail" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'activityDetail.label', default: 'ActivityDetail')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-activityDetail" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
			</ul>
		</div>
		<div id="list-activityDetail" class="content scaffold-list" role="main">
		<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:form action="search" method="post">
				<div class="dialog">
					<table>
						<tr class="prop">
							<td valign="top" class='name'>
								<lable for='name'>${message(code: 'name.label', default: 'Name')}</lable>
							</td>
							<td valign="top" class='value'>
								<input type="text" maxLength="30" name='name' value='${params?.name}'/>
							</td>
						</tr>
						<tr class='prop'>
						<td valign="top" class='name'>
								<lable for='date'>${message(code: 'actDate.label', default: 'Date')}</lable>
							</td>
							<td valign="top" class='value'>
								<g:datePicker name='beginDate' precision='day' value='${params?.beginDate ?params.beginDate:new Date().plus(-31)}'/> ~ <g:datePicker name='endDate' precision='day' value='${params?.endDate ? params.endDate:new Date().plus(1)}'/>
							</td>
							
							<td valign='top' class="menuButton">
								<input type='submit' value='${message(code:'search.lable', default :'Search')}' class="formbutton"/>
					       </td>
						</tr>
						
					  
					   </table>
					       
			</g:form>
			
			<table>
				<thead>
					<tr>
					
					<g:sortableColumn property="name" title="${message(code: 'name.label', default: 'Name')}" />
					
						<g:sortableColumn property="amount" title="${message(code: 'amount.label', default: 'Amount')}" />
					
					
						<th><g:message code="actors.label" default="User" /></th>
					
						<g:sortableColumn property="balance" title="${message(code: 'balance.label', default: 'Balance')}" />
					
						<g:sortableColumn property="actDate" format="yyyy-MM-dd" title="${message(code: 'actDate.label', default: 'Date')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${activityDetailInstanceList}" status="i" var="activityDetailInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${activityDetailInstance.id}">${fieldValue(bean: activityDetailInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: activityDetailInstance, field: "amount")}</td>
					
						<td>${fieldValue(bean: activityDetailInstance, field: "user")}</td>
					
						<td>${fieldValue(bean: activityDetailInstance, field: "balance")}</td>
					
						<td><g:formatDate format="yyyy-MM-dd" date="${activityDetailInstance.actDate}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${activityDetailInstanceTotal}" />
			</div>
		</div>
	</body>
</html>
