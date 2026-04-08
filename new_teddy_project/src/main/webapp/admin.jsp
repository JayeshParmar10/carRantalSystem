<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f4f4f4;
            text-align: center;
             background: linear-gradient(135deg, #EBF4DD, #A98B76);
       
        }
        .container {
            margin-top: 100px;
        }
        .card {
            background: white;
            padding: 20px;
            width: 400px;
            margin: auto;
            border-radius: 8px;
            box-shadow: 0px 0px 10px gray;
        }
        a {
            display: block;
            margin: 10px;
            padding: 10px;
            background: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a:hover {
            background: #9F8383;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="card">
        <h2>Welcome Admin</h2>
        
        <form action="" mathod="post">
        <a href="addProduct.jsp">Add Product</a>
        <a href="AdminViewProducts">View Products</a>
        <a href="DeleteProductServlet">Delete Product</a>
        <a href="AdminLogOut">Logout</a>
         
    </div>
    </form>
    
</div>

</body>
</html>