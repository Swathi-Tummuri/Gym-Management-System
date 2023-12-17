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

import com.gms.bean.Batch;
import com.gms.service.BatchService;


/**
 * Servlet implementation class BatchController
 */
@WebServlet("/BatchController")
public class BatchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BatchController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	BatchService bs = new BatchService();
		List<Batch> listOfBatches = bs.findAllBatches();
		HttpSession hs = request.getSession();
		hs.setAttribute("obj", listOfBatches);
		response.sendRedirect("displayBatches.jsp");
	}

	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter pw = response.getWriter();
		// receive the value from form and convert to respective data type. 
		
		String operation = request.getParameter("operation");
		if(operation.equals("store")) 
		{
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			String timing = request.getParameter("timing");
			String instructor = request.getParameter("instructor");
			
			// convert those value to java bean class 
			Batch bch = new Batch();
			bch.setBatchid(batchid);
			bch.setTiming(timing);
			bch.setInstructor(instructor);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			BatchService bs = new BatchService();
			String result = bs.addBatch(bch);
			pw.println(result);
			RequestDispatcher rd = request.getRequestDispatcher("addBatch.jsp");
			rd.include(request, response);
		}
		else if(operation.equals("update")) 
		{
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			
			String instructor = request.getParameter("instructor");
			Batch bch = new Batch();
			bch.setBatchid(batchid);
			
			bch.setInstructor(instructor);
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			BatchService bs = new BatchService();
			String result = bs.updateBatch(bch);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("updateBatch.jsp");
			rd.include(request, response);
		}
		
		else if(operation.equals("delete")) 
		{
			int batchid = Integer.parseInt(request.getParameter("batchid"));
			
			// Then we can pass those value to service layer and base upon service layer result we can move to next view page. 
			BatchService bs = new BatchService();
			String result = bs.deleteBatch(batchid);
			pw.println(result);
			
			RequestDispatcher rd = request.getRequestDispatcher("deleteBatch.jsp");
			rd.include(request, response);
		}
		else 
		{
			pw.println("Wrong operation");
			RequestDispatcher rd = request.getRequestDispatcher("batch.html");
			rd.include(request, response);
		}
		response.setContentType("text/html");
	}

}
