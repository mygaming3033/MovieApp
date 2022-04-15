<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored ="false" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <title>Movie</title>
    </head>
    <body>
        <h1> Movie added </h1>
        <p>Movie title: ${movie.name}</p>
        <p>Movie id: ${movie.id}</p>
        <p>Directed by: ${movie.directedBy}</p>
        <p>Release year: ${movie.releaseYear}</p>
        <p>Running time: ${movie.runningTime}</p>
        <p>Genres:</p>
        <ul>
           <c:forEach var="genre" items="${movie.genres}">
              <li>${genre}</li>
           </c:forEach>
        </ul>
        <br>
        <hr>
        <br>
        <h2>Add new Screening</h2>
        <form action="movies/${movie.id}/screenings" method="post">
           <label>Hall:</label>
           <input name="hall" id="hall"/>
           <br><br>
           <label>Start time:</label>
           <input name="startTime" id="startTime"/>
           <br><br>
           <input type="submit" value="Add screening">
        </form>
    </body>
</html>
