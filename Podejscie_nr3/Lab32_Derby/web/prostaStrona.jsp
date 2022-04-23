<%-- 
    Document   : prostaStrona
    Created on : 2022-04-20, 21:22:28
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lab32-Derby</title>
    </head>
    <body>
        <h1>Lista pracowników</h1>
        <c:import url="ludzie.xml" var="baza" />
         <%! String id_pracownika, referer;%>
         <% id_pracownika = request.getParameter("id_pracownika");%>
        <%
            pageContext.setAttribute("id_pracownika", id_pracownika);
            referer = request.getHeader("referer");
        %>
       <x:parse doc="${baza}" var="wynik"/>
        <ol>
         <x:forEach select="$wynik/ludzie/czlowiek[@id=$id_pracownika]" var="zasob">
         <tr>
         <li><b><x:out select="nazwisko" /></b> 
         <x:out select="imie" /></li>
         </tr>
         </x:forEach>
        </ol>
    </body>
</html>
