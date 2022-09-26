package com.day12.controller;
import com.day12.model.DistanceModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/getsummary")

public class SummaryDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		int kms = Integer.parseInt(req.getParameter("kms"));
		String name = req.getParameter("name");
		String city = req.getParameter("city");
		
		DistanceModel d = new DistanceModel();
		
		d.setCity(city);
		d.setName(name);
		d.setKms(kms);

		int costPerKm  = d.getCostfromJson(d.getName());
		int cost = d.getKms()*costPerKm;
		String response = d.getSummaryJSONString(d, cost);
	 
		out.println(response);
		out.close();
	}	
	
}
