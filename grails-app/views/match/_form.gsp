<%@ page import="com.badass.Match" %>



<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="match.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" maxlength="128" required="" value="${matchInstance?.name}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'comment', 'error')} ">
	<label for="comment">
		<g:message code="match.comment.label" default="Comment" />
		
	</label>
	<g:textField name="comment" value="${matchInstance?.comment}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'actorsA', 'error')} ">
	<label for="actorsA">
		<g:message code="match.actorsA.label" default="Actors A" />
		
	</label>
	<g:select name="actorsA" from="${com.badass.User.list()}" multiple="multiple" optionKey="id" size="5" value="${matchInstance?.actorsA*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'actorsB', 'error')} ">
	<label for="actorsB">
		<g:message code="match.actorsB.label" default="Actors B" />
		
	</label>
	<g:select name="actorsB" from="${com.badass.User.list()}" multiple="multiple" optionKey="id" size="5" value="${matchInstance?.actorsB*.id}" class="many-to-many"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'matchDate', 'error')} required">
	<label for="matchDate">
		<g:message code="match.matchDate.label" default="Match Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="matchDate" precision="day"  value="${matchInstance?.matchDate}"  />
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'place', 'error')} ">
	<label for="place">
		<g:message code="match.place.label" default="Place" />
		
	</label>
	<g:textField name="place" value="${matchInstance?.place}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: matchInstance, field: 'win', 'error')} ">
	<label for="win">
		<g:message code="match.win.label" default="Win" />
		
	</label>
	<g:checkBox name="win" value="${matchInstance?.win}" />
</div>

