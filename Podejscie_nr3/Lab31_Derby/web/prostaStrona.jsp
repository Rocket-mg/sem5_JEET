<%-- 
    Document   : prostaStrona
    Created on : 2022-04-20, 18:28:26
    Author     : student
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="refresh" content="5; url=./index.html" />
        <title>Lab31-Derby</title>    
    </head>    
    <body>        
        <jsp:useBean id="dBean"class="Lab3.dataBean" scope="session" />        
        <jsp:setProperty name="dBean" property="przykladowaDana" value="<%=request.getParameter("text_field")%>" />        
        Zapisałem dane do Beana.<br>        
        Wyprowadzam dane z Beana:         
        <i><jsp:getProperty name="dBean" property="przykladowaDana" /></i><br>
        Wywołuję inną metodą Beana:        
        <i><%= dBean.Dopisz(" zł")%></i>
    </body>
</html>
