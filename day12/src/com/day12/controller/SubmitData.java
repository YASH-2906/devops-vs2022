package com.day12.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.day12.model.DistanceModel;

@WebServlet("/submit")
public class SubmitData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		PrintWriter out = res.getWriter();
		//values fetched from client in string(text) form
		int kms = Integer.parseInt(req.getParameter("idis"));
		String name = req.getParameter("uname");
		String city = req.getParameter("ucity");
		String summary=req.getParameter("summary");
		
		DistanceModel d1 = new DistanceModel();
		d1.setCity(city);
		d1.setName(name);
		d1.setKms(kms);
		d1.setSummary(summary);
		
		
		DatabaseDaoImpl dao = new DaoDatabaseImpl();
		if( dao.saveData(d1))
		{
			out.println("Data Saved");
			out.close();
		}
	}

}
