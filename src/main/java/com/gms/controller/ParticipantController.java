package com.gms.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gms.bean.Participant;
import com.gms.service.ParticipantService;

/**
 * Servlet implementation class ParticipantController
 */
@WebServlet("/ParticipantController")
public class ParticipantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParticipantController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ParticipantService ps = new ParticipantService();
		List<Participant> listOfParticipants = ps.findAllParticipants();
		HttpSession hs = request.getSession();
		hs.setAttribute("obj", listOfParticipants);
		response.sendRedirect("displayParticipants.jsp");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		// receive the value from form and convert to respective data type. 
		
		String operation = request.getParameter("operation");
		if(operation.equals("store")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			int mobile = Integer.parseInt(request.getParameter("mobile"));
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			
			// convert those value to java bean class 
			Participant ppt = new Participant();
			ppt.setId(id);
			ppt.setName(name);
			ppt.setEmail(email);
			ppt.setMobile(mobile);
			ppt.setBatchid(batchid);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			ParticipantService ps = new ParticipantService();
			String result = ps.addParticipant(ppt);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addParticipant.jsp");
			rd.include(request, response);
		}
		else if(operation.equals("update")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			Participant ppt = new Participant();
			ppt.setId(id);
			
			ppt.setBatchid(batchid);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			ParticipantService ps = new ParticipantService();
			String result = ps.updateParticipant(ppt);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("updateParticipant.jsp");
			rd.include(request, response);
		}
		else if(operation.equals("delete")) 
		{
			int id = Integer.parseInt(request.getParameter("id"));
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			ParticipantService ps = new ParticipantService();
			String result = ps.deleteParticipant(id);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteParticipant.jsp");
			rd.include(request, response);
		}
		else 
		{
			pw.println("Wrong operation");
			RequestDispatcher rd = request.getRequestDispatcher("participant.html");
			rd.include(request, response);
		}
		response.setContentType("text/html");
	}
	
}
