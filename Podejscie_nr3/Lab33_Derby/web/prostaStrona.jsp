<%-- 
    Document   : prostaStrona
    Created on : 2022-04-20, 21:22:28
    Author     : student
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
 <f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
    </head>
    <body>
       <c:import url="ludzie.xml" var="baza" />
        <x:parse doc="${baza}" var="wynik"/>
        <ol>
            <x:forEach select="$wynik/ludzie/czlowiek" var="zasob">
             <li><b><x:out select="nazwisko" /></b>
             <x:out select="imie" /></li>
            </x:forEach>
            </ol>
        <h:form id="wyloguj">
            <h:commandButton value="Wyloguj" action="wyloguj" />
            </h:form>
    </body>
</html>
</f:view>
