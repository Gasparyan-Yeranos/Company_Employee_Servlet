package com.example.company_employee_servlet.servlet;

import com.example.company_employee_servlet.manager.CompanyManager;
import com.example.company_employee_servlet.manager.EmployeeManager;
import com.example.company_employee_servlet.model.Company;
import com.example.company_employee_servlet.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/updateEmployee")
public class UpdateEmployeeServlet extends HttpServlet{
    private EmployeeManager employeeManager = new EmployeeManager();
    private CompanyManager companyManager = new CompanyManager();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("employee", employeeManager.getById(id));
        req.setAttribute("companies", companyManager.getAll());
        req.getRequestDispatcher("WEB-INF/updateEmployee.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String email = req.getParameter("email");
        Company company = companyManager.getById(Integer.parseInt(req.getParameter("company")));
        Employee employee = new Employee(id, name, surname, email, company);
        employeeManager.update(employee);
        resp.sendRedirect("/employees");
    }
}
