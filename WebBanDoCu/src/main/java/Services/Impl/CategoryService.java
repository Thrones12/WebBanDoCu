package Services.Impl;

import java.util.List;
import DAO.ICategoryDAO;
import DAO.Impl.CategoryDAO;
import Models.Category;
import Models.User;
import Services.ICategoryService;

public class CategoryService implements ICategoryService{

	ICategoryDAO cateDAO = new CategoryDAO();
	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		return cateDAO.findAll();
	}

	@Override
	public void insert(Category category) {
		// TODO Auto-generated method stub
		cateDAO.insert(category);
	}

	@Override
	public void update(Category category) {
		// TODO Auto-generated method stub
		Category oldcate = cateDAO.findById(category.getCategory_id());
		oldcate.setCategory_id(category.getCategory_id());
		oldcate.setCategory_name(category.getCategory_name());
	}

	@Override
	public void delete(int category_id) {
		// TODO Auto-generated method stub
		cateDAO.delete(category_id);
	}

	@Override
	public Category findById(int category_id) {
		// TODO Auto-generated method stub
		return cateDAO.findById(category_id);
	}

}
