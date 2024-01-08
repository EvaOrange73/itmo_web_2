<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<table id="table">
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>Результат</th>
        <th>Время отправки запроса</th>
        <th>Время работы скрипта</th>
    </tr>
    <c:forEach items="${points}" var="point">
        <tr>
          <td><c:out value="${point.x}" /></td>
          <td><c:out value="${point.y}" /></td>
          <td><c:out value="${point.r}" /></td>
          <td class="${point.result ? 'green': 'red'}">
            <c:out value="${point.result ? 'Точка попадает в область': 'Точка не попадает в область'}" />
          </td>
          <td><c:out value="${point.requestTime}" /></td>
          <td><c:out value="${point.processTime}" /></td>
        </tr>
      </c:forEach>
</table>