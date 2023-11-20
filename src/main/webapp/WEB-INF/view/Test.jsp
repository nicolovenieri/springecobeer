<!DOCTYPE html>
<%
    String saluti = (String) request.getAttribute("saluti");
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ciao al Centro</title>
    <style>
        body {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            background-color: #f0f0f0;
        }

        .container {
            position: relative;
            text-align: center;
            font-family: 'Arial', sans-serif;
            font-size: 24px;
        }

        .background-characters {
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            z-index: -1;
            opacity: 0.3;
        }

        .character {
            font-size: 60px;
            color: #3498db;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="background-characters">
        <div class="character">+</div>
        <div class="character">*</div>
        <div class="character">@</div>
    </div>
    <%=saluti%>
</div>
</body>
</html>
