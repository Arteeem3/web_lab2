<%@ page import="java.util.List" %>
<%@ page import="data.Dot" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Results</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
<table id="table-sector">
    <thead id="table-header">
    <tr>
        <th>X</th>
        <th>Y</th>
        <th>R</th>
        <th>статус</th>
        <th>время</th>
    </tr>
    </thead>
    <tbody id = "table_body">
    <%
        List<Dot> points = (List<Dot>) request.getSession().getAttribute("result");
    %>
    <%
        if(points!=null){
            for (Dot point : points) {
    %>
    <tr>
        <td><%= String.valueOf(point.getX()) %></td>
        <td><%= String.valueOf(point.getY()) %></td>
        <td><%= String.valueOf( point.getR()) %></td>
        <td><%= point.isStatus() ? "Попадание" : "Промах" %></td>
        <td></td>
    </tr>
    <%
            }
        }

    %>
    </tbody>
</table>
</body>
</html>
