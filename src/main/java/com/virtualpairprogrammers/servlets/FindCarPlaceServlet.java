package com.virtualpairprogrammers.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.virtualpairprogrammers.domain.Car;
import com.virtualpairprogrammers.domain.User;
import com.virtualpairprogrammers.services.CarService;
import com.virtualpairprogrammers.services.UserService;
import com.virtualpairprogrammers.genericclass.Reference;

public class FindCarPlaceServlet extends HttpServlet{

private UserService userService;
private CarService carService;

public FindCarPlaceServlet() {
userService = new UserService();
carService = new CarService();
}


public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
User user = userService.getLoggedUser();
String username = user.getUsername();

List<Car> cars = carService.getAllCarModel(username, true);
Reference<List<Car>> mycars = new Reference<List<Car>>(cars);

request.setAttribute("cars", cars);

if(request.getParameter("latitude") != null)
{
String latitude = request.getParameter("latitude");
String longitude = request.getParameter("longitude");

//get all near places from server

String zoom = request.getParameter("zoom");
request.setAttribute("latitude",latitude);
request.setAttribute("longitude",longitude);
request.setAttribute("zoom",zoom);

}

getServletContext().getRequestDispatcher("/findCarPlace.jsp").forward(request, response);
}

}