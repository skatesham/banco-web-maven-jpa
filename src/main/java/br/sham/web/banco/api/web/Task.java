package br.sham.web.banco.api.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Task {
	
	public String execute(HttpServletRequest request, HttpServletResponse response);

}
