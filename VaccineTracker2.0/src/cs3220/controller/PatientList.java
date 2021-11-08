package cs3220.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import cs3220.model.Patient;
import cs3220.model.VaccineListEntry;


@WebServlet("/PatientList")
public class PatientList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PatientList() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries");
		List<Patient> patients = (List<Patient>) getServletContext().getAttribute("patients"); 
		request.setAttribute("entries", entries);
		request.setAttribute("patients", patients);
		
		request.getRequestDispatcher("/WEB-INF/PatientList.jsp").forward(request, response);
	}


}
