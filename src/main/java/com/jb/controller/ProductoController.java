package com.jb.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jb.productdao.ProductoDAO;
import com.jb.productmodel.Producto;

@WebServlet("/producto")
public class ProductoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProductoController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		
		switch(opcion) {
		
			case "crear":
				RequestDispatcher requestDispatcherCrear = request.getRequestDispatcher("/views/crear.jsp");
				requestDispatcherCrear.forward(request, response);
				break;
				
			case "listar":
				try {
					ProductoDAO productoDAO = new ProductoDAO();
					List<Producto> lista = new ArrayList<>();
					lista = productoDAO.obtenerProductos();
					for (Producto producto : lista) {
						System.out.println(producto);
					}
					request.setAttribute("lista", lista);
					RequestDispatcher requestDispatcherListar = request.getRequestDispatcher("/views/listar.jsp");
					requestDispatcherListar.forward(request, response);					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
				
			case "editar":
				try {
					int id = Integer.parseInt(request.getParameter("id"));
					ProductoDAO productoDAO = new ProductoDAO();
					Producto p = new Producto();
					p = productoDAO.obtenerProducto(id);
					request.setAttribute("producto", p);
					RequestDispatcher requestDispatcherEditar = request.getRequestDispatcher("/views/editar.jsp");
					requestDispatcherEditar.forward(request, response);					
				} catch (SQLException e){
					e.printStackTrace();
				}
				break;
				
			case "eliminar":
				int id = Integer.parseInt(request.getParameter("id"));
				try {
					ProductoDAO productoDAO = new ProductoDAO();
					productoDAO.eliminar(id);
					System.out.println("Producto " + productoDAO + " eliminado statisfactoriamente...");
					RequestDispatcher requestDispatcherEliminar = request.getRequestDispatcher("/index.jsp");
					requestDispatcherEliminar.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}								
				break;
				
			default:
		}
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String opcion = request.getParameter("opcion");
		Date fechaActual = new Date();
		ProductoDAO productoDAO = new ProductoDAO();
		Producto producto = new Producto();
		
		switch(opcion) {
		
			case "guardar":
				producto.setNombre(request.getParameter("nombre"));
				producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
				producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
				producto.setFecha_crear(new java.sql.Date(fechaActual.getTime()));
				producto.setFecha_actualizar(new java.sql.Date(fechaActual.getTime()));
				try {
					productoDAO.guardar(producto);
					System.out.println("Producto " + producto + " guardado statisfactoriamente...");
					RequestDispatcher requestDispatcherGuardar = request.getRequestDispatcher("/index.jsp");
					requestDispatcherGuardar.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;

			case "meditar":
				producto.setId(Integer.parseInt(request.getParameter("id")));
				producto.setNombre(request.getParameter("nombre"));
				producto.setCantidad(Double.parseDouble(request.getParameter("cantidad")));
				producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
				producto.setFecha_actualizar(new java.sql.Date(fechaActual.getTime()));
				try {
					productoDAO.editar(producto);
					System.out.println("Producto " + producto + " actualizado statisfactoriamente...");
					RequestDispatcher requestDispatcherEditar = request.getRequestDispatcher("/index.jsp");
					requestDispatcherEditar.forward(request, response);
				} catch (SQLException e) {
					e.printStackTrace();
				}				
				break;				
				
			default:
		}
		// doGet(request, response);
	}

}
