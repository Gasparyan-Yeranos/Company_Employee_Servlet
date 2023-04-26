package com.example.company_employee_servlet.servlet;

import com.example.company_employee_servlet.manager.CompanyManager;
import com.example.company_employee_servlet.model.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/updateCompany")
public class UpdateCompanyServlet extends HttpServlet{
    private CompanyManager companyManager = new CompanyManager();
    List<String> countries = Arrays.asList("Armenia", "USA", "Russia", "China", "France", "other");
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        req.setAttribute("company", companyManager.getById(id));
        req.setAttribute("countryList", countries);
        req.getRequestDispatcher("WEB-INF/updateCompany.jsp").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String country = req.getParameter("country");
        Company company = new Company(id, name, country);
        companyManager.update(company);
        resp.sendRedirect("/companies");
    }
}
