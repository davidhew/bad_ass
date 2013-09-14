<%@ page import="com.badass.Activity" %>



<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'amount', 'error')} required">
	<label for="amount">
		<g:message code="activity.amount.label" default="Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="amount" value="${fieldValue(bean: activityInstance, field: 'amount')}" required=""/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="activity.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="128" required="" value="${activityInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'actDate', 'error')} required">
	<label for="actDate">
		<g:message code="activity.actDate.label" default="Act Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="actDate" precision="day"  value="${activityInstance?.actDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'actors', 'error')} ">
	<label for="actors">
		<g:message code="activity.actors.label" default="Actors" />
		
	</label>
	<g:select name="actors" from="${com.badass.User.list()}" multiple="multiple" optionKey="id" size="5" value="${activityInstance?.actors*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: activityInstance, field: 'comment', 'error')} ">
	<label for="comment">
		<g:message code="activity.comment.label" default="Comment" />
		
	</label>
	<g:textField name="comment" value="${activityInstance?.comment}"/>
</div>

