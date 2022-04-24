<%-- 
    Document   : wynik
    Created on : 2022-04-24, 02:07:19
    Author     : student
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>

<!DOCTYPE html>
<f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Wynik</title>
    </head>
    <body>
    <h:form id="formularz1">
        <c:import url="WEB-INF/wyniki.xml" var="baza"/>
        <x:parse doc="${baza}" var="wynik"/>
        
        
        <h1>Nawiększa liczba:</h1>
        <h3><h:outputText value="Max z wygenerowanych liczb wynosi #{Max.max}" /></h3>
        
        <h:commandButton value="Powrót" action="return"/>
        <h:form id="wyloguj">
            <h:commandButton value="Wyloguj" action="wyloguj" />
            </h:form>
        
        <h1>Poprzednie wyniki</h1>
        <ol>
            <x:forEach select="$wynik/results/wynik" var="zasob"> 
                <li>
                    <b><x:out select="wynik"/></b>  
                </li>
            </x:forEach>
        </ol>
        </h:form>
    </body>
</html>
</f:view>
