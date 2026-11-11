
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Weather App</title>
</head>
<body>

<h1>Weather App</h1>

<h2>Search Weather by ZIP Code</h2>

<form action="weather" method="GET">

  <label for="location">ZIP Code:</label>

  <input
          type="text"
          id="location"
          name="location"
          placeholder="Enter ZIP code"
          pattern="[0-9]{5}"
          maxlength="5"
          required
  >

  <button type="submit">Get Weather</button>

</form>

<!-- Display error messages -->
<c:if test="${not empty error}">
  <p>${error}</p>
</c:if>

<!-- Display weather information -->
<c:if test="${not empty weather}">

  <h2>Weather Information</h2>

  <p><strong>City:</strong> ${weather.location.name}</p>

  <p><strong>Region:</strong> ${weather.location.region}</p>

  <p><strong>Country:</strong> ${weather.location.country}</p>

  <p>
    <strong>Temperature:</strong>
      ${weather.current.tempC} °C /
      ${weather.current.tempF} °F
  </p>

  <p>
    <strong>Conditions:</strong>
      ${weather.current.condition.text}
  </p>

  <p>
    <strong>Humidity:</strong>
      ${weather.current.humidity}%
  </p>

  <p>
    <strong>Wind Speed:</strong>
      ${weather.current.windKph} km/h
  </p>

  <p>
    <strong>Wind Direction:</strong>
      ${weather.current.windDir}
  </p>

</c:if>

</body>
</html>
