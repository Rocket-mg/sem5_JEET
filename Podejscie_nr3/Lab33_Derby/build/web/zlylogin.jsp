<%-- 
    Document   : zlylogin
    Created on : 2022-04-24, 00:03:22
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html>
 <f:view>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>JSF zly login</title>
    </head>
    <body>
            <h1><h:outputText value="Błąd logowania"/></h1>
            <h:form id="formularz_error">
            <h:outputText value="Podana nazwa użytkownika: #{logowanie.nazwa}
            jest nieprawidłowa, lub podano błędne dla niej hasło! " /><br />
            <h:commandButton value="Spróbuj ponownie" action="retry" />
       
            </h:form>
    </body>
 </html>
</f:view>
