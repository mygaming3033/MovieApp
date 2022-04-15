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
        <title>Movie Info</title>
    </head>
    <body>
        <h1> Info about: ${mov.name}</h1>
        <table>
                <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Directed by</th>
                <th>Release year</th>
                <th>Running time</th>
                <th>Genres</th>
                <th>Screenings</th>
                </tr>
                <tr>
                <td>${mov.id}</td>
                <td>${mov.name}</td>
                <td>${mov.directedBy}</td>
                <td>${mov.releaseYear}</td>
                <td>${mov.runningTime}</td>
                <td>
                <c:forEach var="genre" items="${mov.genres}">
                ${genre}
                </c:forEach>
                </td>
                <td>
                <ul>
                  <c:forEach var="screening" items="${screenings}">
                   <li>
                   <ul>
                   <li>Id: ${screening.id} </li>
                   <li>Hall: ${screening.hall} </li>
                   <li>Start time: ${screening.startTime} </li>
                   <li>End time: ${screening.endTime} </li>
                   </ul>
                   </li>
                   </c:forEach>
                  </ul>
                </td>
                </tr>
                </table>

                <br>
                <hr>
                <br>
                <h2>Add new Screening</h2>
                        <form action="${mov.id}/screenings" method="post">
                              <label>Hall:</label>
                              <input name="hall" id="hall"/>
                              <br><br>
                              <label>Start time:</label>
                              <input name="startTime" id="startTime"/>
                               <br><br>
                              <input type="submit" value="Add screening">
                              </form>
                 <h2>${error_message}</h2>
    </body>
</html>
