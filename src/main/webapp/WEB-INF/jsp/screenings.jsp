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
        <title>Screenings</title>
    </head>
    <body>
        <h1> Screening list </h1>
        <table>
                <tr>
                <th>Id</th>
                <th>MovieId</th>
                <th>Title</th>
                <th>Hall</th>
                <th>Start time</th>
                <th>End time</th>
                <th>Action</th>
                </tr>
                <c:forEach var="screening" items="${screenings}">
                <tr>
                <td>${screening.id}</td>
                <td>${screening.movieId}</td>


                <c:forEach var="mov" items="${movies}">
                <c:if test = "${screening.movieId == mov.id}">
                <td>${mov.name}</td>
                </c:if>
                </c:forEach>
                <td>${screening.hall}</td>
                <td>${screening.startTime}</td>
                <td>${screening.endTime}</td>
                <td><a href="http://localhost:8080/MovieApp/screenings/${screening.id}">Delete</a></td>
                </tr>
                </c:forEach>
                </table>
    </body>
</html>
