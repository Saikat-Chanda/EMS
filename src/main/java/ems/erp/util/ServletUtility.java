package ems.erp.util;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




public class ServletUtility {

	public static void forward(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		RequestDispatcher rd = request.getRequestDispatcher(page);
		System.out.println(page);
		rd.forward(request, response);
	}

	public static void redirect(String page, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.sendRedirect(page);
	}


	public static String getErrorMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static String getMessage(String property, HttpServletRequest request) {
		String val = (String) request.getAttribute(property);
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

	public static void setErrorMessage(String msg, HttpServletRequest request) {
		
	}

	

	public static void setList(List list, HttpServletRequest request) {
		request.setAttribute("list", list);
	}

	public static List getList(HttpServletRequest request) {
		return (List) request.getAttribute("list");
	}

	
	public static void setPageNo(int pageNo, HttpServletRequest request) {
		request.setAttribute("pageNo", pageNo);
	}

	public static int getPageNo(HttpServletRequest request) {
		return (Integer) request.getAttribute("pageNo");
	}

	public static void setPageSize(int pageSize, HttpServletRequest request) {
		request.setAttribute("pageSize", pageSize);
	}

	public static int getPageSize(HttpServletRequest request) {
		return (Integer) request.getAttribute("pageSize");
	}

	public static void setOpration(String msg, HttpServletRequest request) {
		request.setAttribute("Opration", msg);
	}
	
	public static void setSize(int size, HttpServletRequest request) {
		request.setAttribute("size", size);
	}
	
	

	public static int getSize(HttpServletRequest request) {
		return (Integer) request.getAttribute("size");
	}

	public static String getOpration(HttpServletRequest request) {
		String val = (String) request.getAttribute("Opration");
		if (val == null) {
			return "";
		} else {
			return val;
		}
	}

}
