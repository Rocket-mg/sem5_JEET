<%-- 
    Document   : prawaStrona
    Created on : 2021-12-10, 13:01:57
    Author     : student
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <jsp:useBean id="dBean" class="Lab3.PrzykladowaDana" scope="session" />
        <jsp:setProperty name="dBean" property="sampleProperty" value="100" />
        Zapisałem dane do Beana.<br>
        Wyprowadzam dane z Beana:
        <i><jsp:getProperty name="dBean" property="sampleProperty" /></i><br>
        Wywołuję inną metodę Beana:
        <i><%= dBean.Dopisz("zł")%></i>
        <%= request.getParameter ("cena")%>
    </body>
</html>
