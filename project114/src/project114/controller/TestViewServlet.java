package project114.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import project114.model.Department;
import project114.model.Memo;
import project114.model.Person;
import project114.model.Position;
import project114.model.Role;
import project114.utility.SQLOperations;

/**
 * Servlet implementation class TestViewServlet
 */
@WebServlet("/view")
public class TestViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SessionFactory sessionFactory;
	
	public void init() {
		sessionFactory = 
				new Configuration().configure().buildSessionFactory();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			request.setAttribute("persons", SQLOperations.getAllPersons(sessionFactory));
			//request.setAttribute("memos", SQLOperations.getAllPersons(sessionFactory));
			getServletContext().getRequestDispatcher("/viewall.jsp")
			.forward(request, response);
			
		} catch(Exception e) {
			
		}

	}

}
