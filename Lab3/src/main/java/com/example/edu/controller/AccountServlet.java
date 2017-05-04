package com.example.edu.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cs544.exercise5_3.bank.domain.Account;
import cs544.exercise5_3.bank.service.AccountService;

@WebServlet("/account")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AccountServlet() {
        super();
    }
    
    private AccountService accountService = AccountService.getInstance();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if ("insert".equals(action)) {
			request.getRequestDispatcher("resources/jsp/insert.jsp").forward(request, response);
		} else if ("detail".equals(action)) {
			String accountNumber = request.getParameter("accountNumber");
			Account account = accountService.getAccount(Long.parseLong(accountNumber));
			request.setAttribute("account", account);
			request.getRequestDispatcher("resources/jsp/detail.jsp").forward(request, response);
		} else if ("deposit".equals(action)) {
			String accountNumber = request.getParameter("accountNumber");
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("deposit", true);
			request.getRequestDispatcher("resources/jsp/processMoney.jsp").forward(request, response);
		} else if ("withdraw".equals(action)) {
			String accountNumber = request.getParameter("accountNumber");
			request.setAttribute("accountNumber", accountNumber);
			request.setAttribute("deposit", false);
			request.getRequestDispatcher("resources/jsp/processMoney.jsp").forward(request, response);
		} else if ("transfer".equals(action)) {
			String accountNumber = request.getParameter("accountNumber");
			request.setAttribute("accountNumber", accountNumber);
			Collection<Account> accounts = accountService.getAllAccounts();
			List<Long> allAccounts = custom(accounts);
			allAccounts.remove(Long.parseLong(accountNumber));
			request.setAttribute("accountList", allAccounts);
			request.getRequestDispatcher("resources/jsp/transferMoney.jsp").forward(request, response);
		} else {
			List<Account> accounts = (List<Account>) accountService.getAllAccounts();
			request.setAttribute("accounts", accounts);
			request.getRequestDispatcher("resources/jsp/listAccount.jsp").forward(request, response);
		}
	}

	private List<Long> custom(Collection<Account> allAccounts) {
		List<Long> result = new ArrayList<>();
		for(Account account : allAccounts) {
			result.add(account.getAccountnumber());
		}
		return result;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String accountNumber = request.getParameter("accountNumber");
		String accountName = request.getParameter("customerName");
		accountService.createAccount(Long.parseLong(accountNumber), accountName);
		response.sendRedirect("account");
	}
}
