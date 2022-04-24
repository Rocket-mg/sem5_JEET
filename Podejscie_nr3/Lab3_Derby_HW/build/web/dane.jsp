<%-- 
    Document   : dane
    Created on : 2022-04-24, 01:35:18
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>


<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Data</title>
        </head>
        <body>
                <h:form id="oblicz_max">
                <h:outputText value="Wpisz liczbę losowych elementów:"/><br/>
                <h:inputText id="number" value="#{Max.number}" maxlength="3" converter="javax.faces.Integer" /><br/><br/>
                <h:commandButton value="Oblicz" action="oblicz"/>
            </h:form>
        </body>
    </html>
</f:view>
