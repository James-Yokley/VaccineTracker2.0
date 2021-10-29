package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.VaccineListEntry;

@WebServlet("/EditVaccine")
public class EditVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public EditVaccine() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id")); 
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		VaccineListEntry entry = null; 
		for(VaccineListEntry e : entries)
			if(e.getId() == id) {
				entry = e; 
				break; 
			}
		request.setAttribute("entry", entry); 
		request.getRequestDispatcher("/WEB-INF/EditVaccine.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		int id = Integer.parseInt(request.getParameter("id")); 
		String name = request.getParameter("name"); 
		var dose = request.getParameter("doseCount"); 
		int doseCount = dose == null || dose.trim().length() == 0 ? 0: Integer.parseInt(dose); 
		var days = request.getParameter("dayCount"); 
		int dayCount = days == null || days.trim().length() == 0 ? 0: Integer.parseInt(days);
		for(VaccineListEntry entry : entries) {
			if(entry.getId() == id) {
				entry.editEntry(name, doseCount, dayCount);
				response.sendRedirect("VaccineList");
				return; 
			}
		}
		response.sendRedirect("VaccineList");
	}

}
