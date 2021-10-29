package cs3220.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs3220.model.VaccineListEntry;


@WebServlet("/NewDoses")
public class NewDoses extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public NewDoses() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries");
		request.setAttribute("entries", entries);
		request.getRequestDispatcher("/WEB-INF/NewDoses.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VaccineListEntry> entries = (List<VaccineListEntry>) getServletContext().getAttribute("entries"); 
		String vaccineName = request.getParameter("doseName");
		var received = request.getParameter("dosesReceived");
		int doseReceieved = received == null || received.trim().length() == 0 ? 0: Integer.parseInt(received); 
		for(VaccineListEntry entry: entries) {
			if(entry.getName().equals(vaccineName)) {
				entry.addDoses(doseReceieved, doseReceieved);
			}
		}
		response.sendRedirect("VaccineList"); 
	}

}
