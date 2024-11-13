<%@ taglib prefix="c" uri="jakarta.tags.core" %>

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <title>All Todos</title>
        <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <h1>Enter new Todo details</h1>
            <form action="" method="post">
                Description : <input type="text" name="description" required>
                <button class="btn btn-success" type="submit">Add</button>

            </form>
        </div>
        <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
        <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    </body>

    </html>