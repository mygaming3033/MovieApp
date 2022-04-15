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
        <title>Movies</title>
    </head>
    <body>
        <h1> Movie list </h1>
        <table>
                <tr>
                <th>Id</th>
                <th>Title</th>
                <th>Directed by</th>
                <th>Release year</th>
                <th>Running time</th>
                <th>Genres</th>
                <th>Screenings</th>
                <th>Action</th>
                </tr>
                <c:forEach var="mov" items="${movies}">
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
                <c:if test = "${screening.movieId == mov.id}">
                   <li>
                   <ul>
                   <li>Id: ${screening.id} </li>
                   <li>Hall: ${screening.hall} </li>
                   <li>Start time: ${screening.startTime} </li>
                   <li>End time: ${screening.endTime} </li>
                   </ul>
                   </li>
                </c:if>
                 </c:forEach>
                </ul>
                </td>
                <td>
                <input type=button onClick="location.href='movies/${mov.id}'" value="More">
                </td>
                </tr>
                </c:forEach>
                </table>

        <h2>Add new Movie</h2>
        <form:form id="addMovies" modelAttribute="movie" action="movies" method="post">
              <form:hidden path="id"/>
              <form:label path="name">Movie name:</form:label>
              <form:input path="name" name="name" id="name"/>
              <form:errors path="name" cssClass="error"/>
              <br><br>
              <form:label path="directedBy">Directed by:</form:label>
              <form:input path="directedBy" name="directedBy" id="directedBy"/>
              <form:errors path="directedBy" cssClass="error"/>
              <br><br>
              <form:label path="releaseYear">Release year:</form:label>
              <form:input path="releaseYear" name="releaseYear" id="releaseYear" type="number" value="2011"/>
              <form:errors path="releaseYear" cssClass="error"/>
              <br><br>
              <form:label path="runningTime">Running time:</form:label>
              <form:input path="runningTime" name="runningTime" id="runningTime" type="number" value="120"/>
              <form:errors path="runningTime" cssClass="error"/>
               <br><br>
               <form:label path="genres">Genres:</form:label>
               <form:checkbox path="genres" value="Mystery" />Mystery
               <form:checkbox path="genres" value="Thriller" />Thriller
               <form:checkbox path="genres" value="Romance" />Romance
               <form:checkbox path="genres" value="Horror" />Horror
               <form:errors path="genres" cssClass="error"/>
               <br><br>
              <form:button id="add" name="movies">Add new movie</form:button>
              </form:form>
    </body>
</html>
