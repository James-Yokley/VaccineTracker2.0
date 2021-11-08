package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.Patient;
import cs3220.model.VaccineListEntry;

@WebServlet("/Received")
public class Received extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Received() {
        super();

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		List<Patient> patients = (List<Patient>) getServletContext().getAttribute("patients"); 
		var id = request.getParameter("patientId"); 
		int patientId = id == null || id.trim().length() == 0 ? 0: Integer.parseInt(id);
		var vId = request.getParameter("vaccineId"); 
		int vaccineId = vId == null || vId.trim().length() == 0 ? 0: Integer.parseInt(vId); 
		for(Patient patient : patients) {
			if(patient.getId() == patientId) {
					patient.setNextDate();
					patient.setReceivedSecond(true); 
				}
			}
		for(VaccineListEntry entry : entries) {
			if(entry.getId() == vaccineId) {
				entry.setDosesLeft(entry.getDosesLeft() - 1);
			}
		}
		response.sendRedirect("PatientList");
		
		
	}

}
