package Controllers.User;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Category;
import Models.Product;
import Services.ICategoryService;
import Services.IProductService;
import Services.Impl.CategoryService;
import Services.Impl.ProductService;

@WebServlet(urlPatterns = { "/home"})
public class HomeController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private ICategoryService cateService = new CategoryService();
	private IProductService proService = new ProductService();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		if (url.contains("home")) {
			getHome(req, resp);
		}
	}
	private void getHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> list_pro;
		if (req.getParameter("category_id") == null || req.getParameter("category_id").isEmpty()) {
			list_pro = proService.findAll(); 
		}
		else {
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			list_pro = proService.findByCategory(category_id);
		}
		req.setAttribute("listProduct", list_pro);
		
		req.setAttribute("listCategory", cateService.findAll());
		
		req.getRequestDispatcher("Views/user/home.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
