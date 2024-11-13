<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Update Todo</title>
            <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
        </head>

        <body>
            <div class="container">
                <h1>Update Todo</h1>
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
                    <button class="btn btn-success" type="submit">Update</button>
                </form:form>
            </div>
        </body>

        </html>