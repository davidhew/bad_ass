<%@ page import="com.badass.ActivityDetail" %>



<div class="fieldcontain ${hasErrors(bean: activityDetailInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="activityDetail.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: activityDetailInstance, field: 'amount')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityDetailInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="activityDetail.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="128" required="" value="${activityDetailInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityDetailInstance, field: 'user', 'error')} required">
	<label for="user">
		<g:message code="activityDetail.user.label" default="User" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="user" name="user.id" from="${com.badass.User.list()}" optionKey="id" required="" value="${activityDetailInstance?.user?.id}" class="many-to-one"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityDetailInstance, field: 'balance', 'error')} required">
	<label for="balance">
		<g:message code="activityDetail.balance.label" default="Balance" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="balance" value="${fieldValue(bean: activityDetailInstance, field: 'balance')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityDetailInstance, field: 'date', 'error')} required">
	<label for="date">
		<g:message code="activityDetail.date.label" default="Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="date" precision="day"  value="${activityDetailInstance?.date}"  />
</div>

