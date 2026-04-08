<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teddy Collection</title>

<style>
    body{
        font-family: Arial, Helvetica, sans-serif;
        margin:0;
        padding:0;
         background: linear-gradient(135deg, #EBF4DD, #A98B76);
       
    }

    header{
        background: #222831;
        color: white;
        text-align: center;
        padding: 20px;
        font-size: 28px;
        letter-spacing: 1px;
    }

    .container{
        width: 90%;
        margin: 30px auto;
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
        gap: 25px;
    }

    .card{
        background: white;
        border-radius: 12px;
        box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        padding: 15px;
        text-align: center;
        transition: 0.3s ease;
    }

    .card:hover{
        transform: translateY(-8px);
    }

    .card img{
        width: 100%;
        height: 220px;
        object-fit: cover;
        border-radius: 10px;
    }

    .card h3{
        margin: 10px 0 5px;
        color: #333;
    }

    .price{
        color: #ff6f91;
        font-weight: bold;
        margin-bottom: 10px;
    }

    .desc{
        font-size: 14px;
        color: #666;
        margin-bottom: 15px;
    }

    button{
        background: #547792;
        border: none;
        padding: 10px 15px;
        color: white;
        border-radius: 6px;
        cursor: pointer;
        font-weight: bold;
        transition: 0.3s;
    }

    button:hover{
        background: #ff3e6c;
    }
</style>

</head>
<body>

<header>
    Teddy Collection 🧸
</header>

<div class="container">


    <!-- Product 1 -->
    <form action="addToCart" method="post" class="card">
        <img src="https://i.etsystatic.com/42405825/r/il/c527ae/4980575932/il_570xN.4980575932_iq8l.jpg">
        <h3>Small Teddy</h3>
        <p class="price">₹1599</p>
        <p class="desc">This teddy is very unique and super soft.</p>
        <input type="hidden" name="productName" value="Small Teddy">
        <input type="hidden" name="price" value="1599">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 2 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://5.imimg.com/data5/SELLER/Default/2024/10/456620289/US/LL/XJ/202150837/1-500x500.png">
        <h3>Big Teddy</h3>
        <p class="price">₹2999</p>
        <p class="desc">Large and fluffy teddy for warm hugs.</p>
        <input type="hidden" name="productName" value="Big Teddy">
        <input type="hidden" name="price" value="2999">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 3 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://img.pikbest.com/png-images/20241026/cute-pink-teddy-bear-toy-icon-design-fun_11006933.png!w700wp">
        <h3>Pink Teddy</h3>
        <p class="price">₹1899</p>
        <p class="desc">Cute pink teddy perfect for gifting.</p>
        <input type="hidden" name="productName" value="Pink Teddy">
        <input type="hidden" name="price" value="1899">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 4 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://img.freepik.com/premium-photo/cocoa-elegance-white-teddy-bear-adorned-with-brown-bow-white-clear-surface-png-transparent-background_94628-65428.jpg">
        <h3>White Teddy</h3>
        <p class="price">₹1799</p>
        <p class="desc">Soft white teddy with premium fabric.</p>
        <input type="hidden" name="productName" value="White Teddy">
        <input type="hidden" name="price" value="1799">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 5 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1Ngc4-DQ3vTagQlK0zQcGgpYIsXNa85UL5w&s">
        <h3>Heart Teddy</h3>
        <p class="price">₹2099</p>
        <p class="desc">Teddy holding a heart – best for surprises.</p>
        <input type="hidden" name="productName" value="Heart Teddy">
        <input type="hidden" name="price" value="2099">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 6 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://i.etsystatic.com/43201484/r/il/7958ae/5676773769/il_fullxfull.5676773769_7d0z.jpg">
        <h3>Couple Teddy</h3>
        <p class="price">₹3499</p>
        <p class="desc">Romantic teddy pair for special occasions.</p>
        <input type="hidden" name="productName" value="Couple Teddy">
        <input type="hidden" name="price" value="3499">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 7 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpnbdBtPzA2TXcJM8g5dxWlamshNIye2ePdA&s">
        <h3>Brown Classic Teddy</h3>
        <p class="price">₹1999</p>
        <p class="desc">Traditional brown teddy loved by everyone.</p>
        <input type="hidden" name="productName" value="Brown Classic Teddy">
        <input type="hidden" name="price" value="1999">
        <button type="submit">Add to Cart</button>
    </form>

    <!-- Product 8 -->
    <form action="buy.jsp" method="post" class="card">
        <img src="https://www.tinyminymo.com/cdn/shop/files/Cute-Teddy-Plush-Keychain-23_2048x.png?v=1770287530">
        <h3>Mini Pocket Teddy</h3>
        <p class="price">₹999</p>
        <p class="desc">Small and cute teddy you can carry anywhere.</p>
        <input type="hidden" name="productName" value="Mini Pocket Teddy">
        <input type="hidden" name="price" value="999">
        <button type="submit">Add to Cart</button>
    </form>

</div>

</body>
</html>