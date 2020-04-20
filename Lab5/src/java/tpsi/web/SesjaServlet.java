/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tpsi.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ua39472
 */
@WebServlet(name = "SesjaServlet", urlPatterns = {""})
public class SesjaServlet extends HttpServlet {
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int liczba;
        
        HttpSession session = request.getSession();
        
        if (session.getAttribute("liczba") == null)
        {
            liczba = 1;
        }
        else
        {
            liczba = (Integer)session.getAttribute("liczba");
            liczba = liczba + 1;
        }
        session.setAttribute("liczba", liczba);
        
        String imie = request.getParameter("imie");
        String nazwisko = request.getParameter("nazwisko");
        String email = request.getParameter("email");
        
        Student osoba = new Student(imie, nazwisko, email);
        
        List<Student> lista = new ArrayList<>();
        
        if (session.getAttribute("lista") != null)
        {
            lista = (List<Student>)session.getAttribute("lista");
        }

        lista.add(osoba);
        session.setAttribute("lista", lista);
        
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        int liczba;
        HttpSession session = request.getSession();
        
        if (session.getAttribute("liczba") == null)
        {
            liczba = 1;
        }
        else
        {
            liczba = (Integer)session.getAttribute("liczba");
            liczba = liczba + 1;
        }
        
        session.setAttribute("liczba", liczba);
        
        request.getRequestDispatcher("hello.jsp").forward(request, response);
    }
}
