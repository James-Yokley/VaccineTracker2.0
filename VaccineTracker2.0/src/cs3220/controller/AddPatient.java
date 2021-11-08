package cs3220.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Patient;
import cs3220.model.VaccineListEntry;

@WebServlet("/AddPatient")
public class AddPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddPatient() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		request.setAttribute("entries", entries); 
		request.getRequestDispatcher("/WEB-INF/AddPatient.jsp").forward(request, response); 
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Patient> patients = (List<Patient>) getServletContext().getAttribute("patients");
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		String patientName = request.getParameter("patient"); 
		String vaxName = request.getParameter("vaccineName"); 
		int vaxId = 0; 
		for(VaccineListEntry entry : entries) {
			if(vaxName.equals(entry.getName())){
				vaxId = entry.getId();
				entry.setDosesLeft(entry.getDosesLeft() - 1);
			}
		}
		Patient newPatient = new Patient(patientName, vaxId, false); 
		newPatient.setDate(LocalDate.now());
		patients.add(newPatient); 
		response.sendRedirect("PatientList");
		
	}

}
