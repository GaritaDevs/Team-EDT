<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Weather &amp; Attire API — Consumer Guide</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
            text-align: center;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
        }
    </style>
</head>
<body>

<h1>Weather &amp; Attire Recommendation API</h1>
<p>
    A RESTful web service providing real-time weather conditions and automated attire recommendations
    for any valid US ZIP code. All endpoints return structured <code>application/json</code> responses.
</p>

<div>
    <strong>Base URL:</strong> <code>${pageContext.request.contextPath}/api</code><br>
    <strong>Interactive Web Client:</strong> <a href="weather.jsp" target="_blank">Launch Weather &amp; Attire Web App in New Tab</a>
</div>

<h2>Authentication &amp; Headers</h2>
<ul>
    <li><strong>Authentication:</strong> None required for consumers.</li>
    <li><strong>Response Format:</strong> <code>Content-Type: application/json</code></li>
</ul>

<h2>Path Parameters</h2>
<table>
    <thead>
    <tr>
        <th>Parameter</th>
        <th>Type</th>
        <th>Description</th>
        <th>Example</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td><code>{location}</code></td>
        <td>String</td>
        <td>5-digit US ZIP code.</td>
        <td>60601</td>
    </tr>
    </tbody>
</table>

<h2>Available Endpoints</h2>
<table>
    <thead>
    <tr>
        <th>Method</th>
        <th>Endpoint</th>
        <th>Description</th>
        <th>Live Test</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>GET</td>
        <td><code>/api/current/{location}</code></td>
        <td>Returns the complete current weather and location payload.</td>
        <td><a href="${pageContext.request.contextPath}/api/current/60601" target="_blank">Try in New Tab</a></td>
    </tr>
    <tr>
        <td>GET</td>
        <td><code>/api/current/{location}/location</code></td>
        <td>Returns geographic coordinates, region, country, and local time.</td>
        <td><a href="${pageContext.request.contextPath}/api/current/60601/location" target="_blank">Try in New Tab</a></td>
    </tr>
    <tr>
        <td>GET</td>
        <td><code>/api/current/{location}/temperature</code></td>
        <td>Returns Fahrenheit/Celsius temperatures, feels-like temp, humidity, and condition text.</td>
        <td><a href="${pageContext.request.contextPath}/api/current/60601/temperature" target="_blank">Try in New Tab</a></td>
    </tr>
    <tr>
        <td>GET</td>
        <td><code>/api/current/{location}/wind</code></td>
        <td>Returns wind speed (MPH/KPH), direction, gusts, and precipitation.</td>
        <td><a href="${pageContext.request.contextPath}/api/current/60601/wind" target="_blank">Try in New Tab</a></td>
    </tr>
    <tr>
        <td>GET</td>
        <td><code>/api/current/{location}/attire</code></td>
        <td>Returns a weather summary alongside clothing recommendations based on feels-like temperature and conditions.</td>
        <td><a href="${pageContext.request.contextPath}/api/current/60601/attire" target="_blank">Try in New Tab</a></td>
    </tr>
    </tbody>
</table>

<h2>Example Request &amp; Response</h2>
<h3>Request</h3>
<pre>GET ${pageContext.request.contextPath}/api/current/60601/attire
Accept: application/json</pre>

<h3>Success Response (<code>200 OK</code>)</h3>
<pre>{
  "location": "Chicago",
  "temp_f": 42.0,
  "condition": "Light rain",
  "attire_suggestion": "Warm jacket or coat, long pants, and closed-toe shoes.  Bring an umbrella or rain jacket."
}</pre>

<h2>Error Handling</h2>
<p>If a location cannot be found or the upstream weather provider returns no data, the service responds with an HTTP <code>404 Not Found</code> JSON object:</p>
<pre>{
  "error": "Weather data not found for location: 00000"
}</pre>

</body>
</html>
