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

import cs3220.model.VaccineListEntry;


@WebServlet("/VaccineList")
public class VaccineList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public VaccineList() {
        super();
        
    }


	public void init(ServletConfig config) throws ServletException {
		super.init(config); 
		
		List<VaccineListEntry> entries = new ArrayList<VaccineListEntry>(); 
		entries.add(new VaccineListEntry("Pfizer", 2, 21, 0, 0));
		entries.add(new VaccineListEntry("Johnson & Johnson", 1, 0, 0, 0)); 
		getServletContext().setAttribute("entries", entries);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/VaccineList.jsp").forward(request, response);
	}


}
