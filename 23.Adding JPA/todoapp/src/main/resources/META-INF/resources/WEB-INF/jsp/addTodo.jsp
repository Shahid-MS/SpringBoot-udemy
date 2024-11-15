<%@ include file="Common/header.jspf" %>
<div class="container">
    <h1>Enter new Todo details</h1>
    <form:form method="post" modelAttribute="todo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required" />
            <form:errors path="description" class="text-danger" />
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date</form:label>
            <form:input type="Date" path="targetDate" required="required" />
            <form:errors path="targetDate" class="text-danger" />
        </fieldset>
        <form:input type="hidden" path="id" />
        <form:input type="hidden" path="done" />
        <br>
        <button class="btn btn-success" type="submit">Add</button>
    </form:form>
</div>

<%@ include file="Common/footer.jspf" %>
