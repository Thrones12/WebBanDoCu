package Services;

import java.util.List;

import Models.Cart;

public interface ICartSerive {

	List<Cart> findAll();

	void insert(Cart cart);

	void update(Cart cart);

	void delete(int cart_id);

	Cart findById(int cart_id);
}
