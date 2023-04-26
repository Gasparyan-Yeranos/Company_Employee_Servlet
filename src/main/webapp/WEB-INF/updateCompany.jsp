<%@ page import="java.util.List" %>
<%@ page import="com.example.company_employee_servlet.model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Company</title>
</head>
<% Company company = (Company) request.getAttribute("company"); %>
<% List<String> countries = (List<String>) request.getAttribute("countryList"); %>
<body>
<a href="/companies"> Back </a>

<h2>Update Company</h2>
<form action="/updateCompany" method="post">
    id: <%=company.getId()%><br><br>
    <input name="id" type="hidden" value="<%=company.getId()%>">
    old name: <%=company.getName()%><br>
    new name: <input type="text" name="name" value="<%=company.getName()%>"><br><br>
    old country: <%=company.getCountry()%><br>
    new country:
    <select name="country"%>">
        <% for (String country : countries) { %>
        <option value="<%=country%>"><%=country%></option>
        <% }%>
    </select><br>
    <input type="submit" value="update">
</form>
</body>
</html>