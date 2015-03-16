<%@ page import="net.mngr.Project" %>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="project.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="name" pattern="${projectInstance.constraints.name.matches}" required="" value="${projectInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'code', 'error')} required">
	<label for="code">
		<g:message code="project.code.label" default="Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="code" pattern="${projectInstance.constraints.code.matches}" required="" value="${projectInstance?.code}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'deliveryDate', 'error')} required">
	<label for="deliveryDate">
		<g:message code="project.deliveryDate.label" default="Delivery Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="deliveryDate" precision="day"  value="${projectInstance?.deliveryDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'manager', 'error')} required">
	<label for="manager">
		<g:message code="project.manager.label" default="Manager" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="manager" required="" value="${projectInstance?.manager}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'phase', 'error')} required">
	<label for="phase">
		<g:message code="project.phase.label" default="Phase" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="phase" from="${net.mngr.Phase?.values()}" keys="${net.mngr.Phase.values()*.name()}" required="" value="${projectInstance?.phase?.name()}" />

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'techLead', 'error')} required">
	<label for="techLead">
		<g:message code="project.techLead.label" default="Tech Lead" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="techLead" required="" value="${projectInstance?.techLead}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: projectInstance, field: 'priority', 'error')} required">
    <label for="priority">
        <g:message code="project.priority.label" default="Priority" />
        <span class="required-indicator">*</span>
    </label>
    <g:field name="priority" type="number" min="1" value="${projectInstance.priority}" required=""/>

</div>

