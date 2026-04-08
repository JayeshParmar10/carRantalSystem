<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Teddy Bear Store - Contact Us</title>
    <style>
        body {
            margin: 0;
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(to right, white, lightblue);
        }

        .container {
            width: 80%;
            margin: 40px auto;
             background: linear-gradient(135deg, #EBF4DD, #A98B76);
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.1);
        }

        h1 {
            text-align: center;
            color: #15173D;
        }

        .contact-info {
            text-align: center;
            margin-bottom: 30px;
            color: #555;
        }

        .contact-info p {
            margin: 5px;
        }

        .form-group {
            margin-bottom: 15px;
        }

        label {
            font-weight: bold;
            color: #362F4F;
        }

        input, textarea {
            width: 100%;
            padding: 10px;
            border-radius: 8px;
            border: 1px solid #ccc;
            margin-top: 5px;
        }

        textarea {
            resize: none;
            height: 120px;
        }

        .btn {
            background-color: #280905;
            color: white;
            padding: 12px 25px;
            border: none;
            border-radius: 25px;
            cursor: pointer;
            font-size: 16px;
            transition: 0.3s;
        }

        .btn:hover {
            background-color: #e754a3;
        }

        .success {
            color: green;
            text-align: center;
            font-weight: bold;
            margin-bottom: 15px;
        }

        iframe {
            width: 100%;
            border-radius: 10px;
            margin-top: 20px;
        }

        footer {
            text-align: center;
            margin-top: 20px;
            color: #888;
        }
    </style>
</head>
<body>

<div class="container">
    <h1>🧸 Contact Teddy Bear Store</h1>

    <div class="contact-info">
        <p>📍 Inorbit Mall Alembic Road, Baroda, Gujarat, India</p>
        <p>📞 +91 98765 43210</p>
        <p>📧 support@teddybearstore.com</p>
        <p>🕒 Mon - Sat: 9 AM - 8 PM</p>
    </div>

    <% 
        String message = request.getParameter("success");
        if(message != null) {
    %>
        <div class="success">
            Thank you for contacting us! 🧸 We'll respond soon.
        </div>
    <% } %>

   <form action="ContactServlet" method="post">
        <div class="form-group">
            <label>Your Name</label>
            <input type="text" name="name" required>
        </div>

        <div class="form-group">
            <label>Email Address</label>
            <input type="email" name="email" required>
        </div>

        <div class="form-group">
            <label>Subject</label>
            <input type="text" name="subject" required>
        </div>

        <div class="form-group">
            <label>Your Message</label>
            <textarea name="message" required></textarea>
        </div>

        <div style="text-align:center;">
            <button type="submit" class="btn">Send Message 🧸</button>
        </div>
    </form>

    <!-- Gujarat Map -->
    <iframe 
        src="https://www.google.com/maps?q=subhanpra,Vadodara,Gujarat,India&output=embed"
        height="250" 
        allowfullscreen="" 
        loading="lazy">
    </iframe>

    <footer>
        © 2026 Teddy Bear Store | Made with ❤️ & Cuddles
    </footer>
</div>

</body>
</html>