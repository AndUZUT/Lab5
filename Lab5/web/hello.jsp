<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Web - laboratorium 5</title>
    </head>
    <body>
        <h1>Liczba wyświetleń: ${sessionScope.liczba}</h1>
        <h1>Lista osób: </h1>
        <table border = "1">
        <c:forEach items="${sessionScope.lista}" var="student">
            <tr>
                <td>${student.firstName}</td> <td>${student.lastName}</td> <td>${student.email}</td>
            </tr>
        </c:forEach>
        </table>
        <form method='post'>
            <h1>Dodaj studenta: </h1>
            <input type='text' name='imie'>
            <input type='text' name='nazwisko'>
            <input type='text' name='email'>
            <input type='submit'>
        </form>
    </body>
</html>
