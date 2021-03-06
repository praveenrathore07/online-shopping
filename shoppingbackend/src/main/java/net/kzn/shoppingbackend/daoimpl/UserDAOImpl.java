package net.kzn.shoppingbackend.daoimpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public boolean addUser(User user) {
		
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().save(address);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().save(cart);
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
