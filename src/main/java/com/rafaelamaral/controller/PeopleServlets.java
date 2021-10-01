package com.rafaelamaral.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.rafaelamaral.model.People;
import com.rafaelamaral.repository.DAOPeopleRepository;

@WebServlet(urlPatterns = { "/insert", "/main", "/report" , "/delete" , "/select" , "/update" })
public class PeopleServlets extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private DAOPeopleRepository repository = new DAOPeopleRepository();
	
	private People people = new People();

	public PeopleServlets() {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		if (action.equals("/insert")) {
			createPeople(request, response);
		} else if (action.equals("/main")) {
			listPeoples(request, response);
		} else if (action.equals("/report")) {
			generateReport(request, response);
		}else if(action.equals("/delete")) {
			delete(request , response);
		}else if(action.equals("/select")) {
			selectPeople(request , response);
		}else if(action.equals("/update")) {
			update(request , response);
		}else {
			response.sendRedirect("index.jsp");

		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String idPeople = request.getParameter("id");
		people.setId(Long.parseLong(idPeople));
		
		people.setName(request.getParameter("name"));
		people.setEmail(request.getParameter("email"));
		
		repository.update(people);
		
		response.sendRedirect("main");
	}

	private void selectPeople(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String idPeople = request.getParameter("id");
		people.setId(Long.parseLong(idPeople));
		
		repository.selectPeople(people);
		
		request.setAttribute("id", people.getId());
		request.setAttribute("name", people.getName());
		request.setAttribute("email", people.getEmail());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("update.jsp");
		dispatcher.forward(request, response);
		
		
		
		
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String idPeople = request.getParameter("id");
	
		repository.remove(Long.parseLong(idPeople));
		
		response.sendRedirect("main");
	}

	private void listPeoples(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<People> list = repository.listAll();

		request.setAttribute("peoples", list);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("people.jsp");
		requestDispatcher.forward(request, response);

	}

	private void createPeople(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		People people = new People();

		people.setName(request.getParameter("name"));
		people.setEmail(request.getParameter("email"));

		repository.save(people);

		response.sendRedirect("main");

	}

	private void generateReport(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document document = new Document();

		try {

			response.setContentType("apllication/pdf");

			response.addHeader("Content-Disposition", "inline;filename=" + "peoples.pdf");

			PdfWriter.getInstance(document, response.getOutputStream());

			// Open document generate content
			document.open();
			document.add(new Paragraph("List of peoples"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));

			PdfPTable pdfPTable = new PdfPTable(3);
			PdfPCell colunmOne = new PdfPCell(new Paragraph("ID"));
			PdfPCell columnTwo = new PdfPCell(new Paragraph("Name"));
			PdfPCell columnThree = new PdfPCell(new Paragraph("E-mail"));

			pdfPTable.addCell(colunmOne);
			pdfPTable.addCell(columnTwo);
			pdfPTable.addCell(columnThree);

			ArrayList<People> list = repository.listAll();
			for (People people : list) {
				pdfPTable.addCell(people.getId().toString());
				pdfPTable.addCell(people.getName());
				pdfPTable.addCell(people.getEmail());
			}

			document.add(pdfPTable);
			document.close();

		} catch (Exception e) {
			System.out.println(e);
			document.close();
		}

	}

}
