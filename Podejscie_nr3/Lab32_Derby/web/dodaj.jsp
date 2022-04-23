<%-- 
    Document   : dodaj
    Created on : 2022-04-20, 22:04:41
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dodawanie pracownika</title>
    </head>
    <body>
       <c:import url="ludzie.xml" var="baza"/>
        <textarea><c:out value="${baza}" escapeXml="true"/></textarea>
         <%! String imie, nazwisko, referer;%>
         <% imie = request.getParameter("imie");%>
         <% nazwisko = request.getParameter("nazwisko");%>
        <%
            pageContext.setAttribute("id_pracownika", id_pracownika);
            referer = request.getHeader("referer");
        %>
    </body>
</html>
