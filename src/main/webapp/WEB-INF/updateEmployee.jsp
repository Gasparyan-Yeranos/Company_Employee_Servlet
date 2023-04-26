<%@ page import="java.util.List" %>
<%@ page import="com.example.company_employee_servlet.model.Company" %>
<%@ page import="com.example.company_employee_servlet.model.Employee" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Company</title>
</head>
<% Employee employee = (Employee) request.getAttribute("employee"); %>
<% List<Company> companies = (List<Company>) request.getAttribute("companies"); %>
<body>
<a href="/employees"> Back </a>

<h2>Update employee</h2>
<form action="/updateEmployee" method="post">
    id: <%=employee.getId()%><br><br>
    <input name="id" type="hidden" value="<%=employee.getId()%>">
    old name: <%=employee.getName()%><br>
    new name: <input type="text" name="name" value="<%=employee.getName()%>"><br><br>
    old surname: <%=employee.getSurname()%><br>
    new name: <input type="text" name="surname" value="<%=employee.getSurname()%>"><br><br>
    old email: <%=employee.getEmail()%><br>
    new email: <input type="text" name="email" value="<%=employee.getEmail()%>"><br><br>
    old company: <%=employee.getCompany().getId()%><br>
    new company:
    <select name="company"%>">
        <% for (Company company : companies) { %>
        <option value="<%=company.getId()%>"><%=company.getId()%></option>
        <% }%>
    </select><br>
    <input type="submit" value="update">
</form>
</body>
</html>