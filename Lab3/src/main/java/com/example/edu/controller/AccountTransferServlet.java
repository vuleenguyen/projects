package com.example.edu.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs544.exercise5_3.bank.service.AccountService;

@WebServlet("/transfer")
public class AccountTransferServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private AccountService acccountService = AccountService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		String amount = request.getParameter("amount");
		String toAccount = request.getParameter("toAccount");
		String description = request.getParameter("description");
		
		acccountService.transferFunds(Long.parseLong(accountNumber), Long.parseLong(toAccount),
				Double.parseDouble(amount), description);
		response.sendRedirect("account");
	}
}
