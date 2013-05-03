package com.trainingplus.server;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingplus.server.dao.IClubDAO;
import com.trainingplus.server.dao.TplusDAOFactory;
import com.trainingplus.server.dao.TplusDAOFactory.IPersonDAO;
import com.trainingplus.server.dao.TplusDAOFactory.ISeasonDAO;
import com.trainingplus.server.model.Club;
import com.trainingplus.server.model.Person;
import com.trainingplus.server.model.Season;

@SuppressWarnings("serial")
public class Trainingplus_serverServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		IClubDAO clubDAO = TplusDAOFactory.getClubDAO();
		ISeasonDAO seasonDAO = TplusDAOFactory.getSeasonDAO();

		// Simple create
		Club barca = new Club("Barcelone");
		barca.setColor("blue");
		clubDAO.put(barca);
		
		Season s1112 = new Season(new Date(), new Date());
		seasonDAO.put(s1112);
		
		try {
			clubDAO.subscribeClubToASeason(barca, s1112);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		resp.getWriter().println("----Training+ API----");
		resp.getWriter().println("-- Clubs : ");
		IClubDAO dao = TplusDAOFactory.getClubDAO();
		for (Club c : dao.listAll())
			resp.getWriter().print(c.getName()+" ("+c.getColor()+") - ");
		
		IPersonDAO pdao = TplusDAOFactory.getPersonDAO();
		resp.getWriter().println("-- People : ");
		for (Person p : pdao.listAll())
			resp.getWriter().println(p.getName()+" "+p.getFirstName()+"");
				
	}
}
