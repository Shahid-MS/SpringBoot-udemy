<%@ include file="Common/header.jspf" %>
        <h1 class="text-center">Hello ${name}</h1>

        <div class="container">
            <p>Your Todos are : </p>
            <table class="table">
                <thead>
                    <tr>
                        <th>id</th>
                        <th>description</th>
                        <th>TargetDate</th>
                        <th>is done ?</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a></td>
                            <td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="add-todo" class="btn btn-success">Add Todo</a>
        </div>
        <%@ include file="Common/footer.jspf" %>