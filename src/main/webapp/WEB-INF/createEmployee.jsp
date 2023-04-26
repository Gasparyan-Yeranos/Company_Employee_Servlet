<%@ page import="java.util.List" %>
<%@ page import="com.example.company_employee_servlet.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create new company</title>
</head>
<%List<Company> companies = (List<Company>) request.getAttribute("companyList");%>
<body>
<a href="/employees"> Back </a>

<h2>
    Create New Employee
</h2>
<form action="/createEmployee" method="post">
    name: <input type="text" name="name"><br>
    surname: <input type="text" name="surname"><br>
    email: <input type="text" name="email"><br>
    company id:
    <select name="company">
        <% for (Company company : companies) { %>
        <option value="<%=company.getId()%>"><%=company.getId()%></option>
        <% }%>
    </select><br>
    <input type="submit" value="add">
</form>
</body>
</html>
