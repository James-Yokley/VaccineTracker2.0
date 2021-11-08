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


@WebServlet("/FrontPage")
public class FrontPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FrontPage() {
        super();
    }

	public void init(ServletConfig config) throws ServletException {
		super.init(config); 
		
		List<VaccineListEntry> entries = new ArrayList<VaccineListEntry>(); 
		entries.add(new VaccineListEntry("Pfizer", 2, 21, 0, 0));
		entries.add(new VaccineListEntry("Johnson & Johnson", 1, 0, 0, 0)); 
		getServletContext().setAttribute("entries", entries);
		List<Patient> patients = new ArrayList<Patient>(); 
		patients.add(new Patient("John Doe", 2, 2021, 2, 18, true)); 
		patients.add(new Patient("Jane Doe", 2, 2021, 2, 18, false)); 
		patients.add(new Patient("Tom Smith", 1, 2021, 3, 12, false)); 
		patients.add(new Patient("Jim Lee", 1, 2021, 3, 12, false)); 
		for(Patient patient : patients) {
			for(VaccineListEntry entry : entries) {
				if(patient.getVaccineId() == entry.getId()) {
					patient.setNextDate(entry.getDayCount()); 
				}
			}
		}
		getServletContext().setAttribute("patients", patients);
		getServletContext().setAttribute("entries", entries);
	}
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/FrontPage.jsp").forward(request, response); 
	}

}
