package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.VaccineListEntry;


@WebServlet("/NewVaccine")
public class NewVaccine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewVaccine() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NewVaccine.jsp").forward(request, response); 
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name"); 
		int doseCount = Integer.parseInt(request.getParameter("doseCount")); 
		var day = request.getParameter("dayCount"); 
		int dayCount = day == null || day.trim().length() == 0 ? 0: Integer.parseInt(day); 
		VaccineListEntry entry = new VaccineListEntry(name, doseCount, dayCount, 0, 0); 
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		entries.add(entry); 
		response.sendRedirect("VaccineList");
	}

}
