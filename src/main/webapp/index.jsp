<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather &amp; Attire Recommendation API - Documentation</title>
    <link rel="stylesheet" href="https://unpkg.com/swagger-ui-dist@5.17.14/swagger-ui.css" />
    <style>
        body { margin: 0; padding: 0; font-family: sans-serif; }
        .attribution-footer {
            text-align: center;
            padding: 20px;
            color: #555;
            font-size: 14px;
            border-top: 1px solid #eee;
            margin-top: 30px;
        }
    </style>
</head>
<body>
<div id="swagger-ui"></div>

<footer class="attribution-footer">
    Weather data provided by <a href="https://weatherapi.com" target="_blank" rel="noopener noreferrer">WeatherAPI.com</a>
</footer>

<script src="https://unpkg.com/swagger-ui-dist@5.17.14/swagger-ui-bundle.js"></script>
<script>
    window.onload = function () {
        window.ui = SwaggerUIBundle({
            url: '${pageContext.request.contextPath}/api/openapi.json',
            dom_id: '#swagger-ui',
            deepLinking: true
        });
    };
</script>
</body>
</html>
