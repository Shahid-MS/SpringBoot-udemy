<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
     <link rel="stylesheet" href="/webjars/bootstrap/5.1.3/css/bootstrap.min.css">
</head>

<body>
    <div class="container">
        <h1>Login</h1>
        <pre class="text-danger">${errorMessage}</pre>
        <form action="" method="post">
            <p>Name <input type="text" name="name"></p>
            <p>Password <input type="password" name="password"></p>
            <button  type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</body>

</html>