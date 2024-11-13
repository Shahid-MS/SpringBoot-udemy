<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>All Todos</title>
        <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>

    <body>
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
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>