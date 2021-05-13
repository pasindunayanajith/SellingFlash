
<html>
    <head>
        <title>GadgetBadget Login</title>
        <link rel="stylesheet" href="Views/login.css">
        <link rel="stylesheet" href="Views/style.css">
   
    <!-- Modernizr Js -->
    <script src="Components/modernizr-2.8.3.min.js"></script>   
    </head>


    <body>
<center>
    <div class="container">
        <div class="border">
        <h2>LOGIN</h2>
        <form action="admin/check.php" method="POST" enctype="multipart/form-data">
            
            <label>USER NAME</label><br>
            <input type="text" name="username" placeholder="Username" required><br>
            <label>PASSWORD</label><br>
            <input type="password" name="password" placeholder="Password" required><br>
            <label>
            <label>TYPE</label>
            <select id="country" class='select2' name="Category">
                <option value="user">User</option>
                <option value="Admin">Admin</option>    
            </select>
            <input type="checkbox" checked="checked" name="remember" class="check"> Remember me
            </label><br>
            <input type="submit" value="LOGIN" name="submit">
            <a href="home.jsp">HOME</a>
            
    
        </form>
        </div>
    </div>
</center>


</body>

</html>