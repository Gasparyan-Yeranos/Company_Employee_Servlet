package com.example.company_employee_servlet.servlet;

import com.example.company_employee_servlet.manager.EmployeeManager;
import com.example.company_employee_servlet.model.Company;
import com.example.company_employee_servlet.manager.CompanyManager;
import com.example.company_employee_servlet.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/createEmployee")
public class CreateEmployeeServlet extends HttpServlet {

    private EmployeeManager employeeManager = new EmployeeManager();
    private CompanyManager companyManager = new CompanyManager();
    List<Company> companies = companyManager.getAll();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("companyList", companies);
        req.getRequestDispatcher("WEB-INF/createEmployee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Company company = companyManager.getById(Integer.parseInt(req.getParameter("company")));
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setEmail(email);
        employee.setCompany(company);
        employeeManager.save(employee);
        resp.sendRedirect("/employees");
    }
}



