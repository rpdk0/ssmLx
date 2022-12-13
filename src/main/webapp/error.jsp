<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.time.Instant" %>
<%--
  Created by IntelliJ IDEA.
  User: 20342
  Date: 2022/12/12
  Time: 11:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>发生异常 <%=request.getAttribute("javax.servlet.error.status_code")%></title>
</head>
<body>
    <p>异常信息:<%Object s=  request.getAttribute("javax.servlet.error.message");if (s!=null)out.print(s);%> <%if (exception!=null && exception.toString()!=null)out.print(exception);%></p>
    <p>code:<%=request.getAttribute("javax.servlet.error.status_code")%></p>
    <p>异常路径:<%=request.getAttribute("javax.servlet.error.request_uri")%></p>
    <p><%=Instant.now()%></p>
</body>
</html>
