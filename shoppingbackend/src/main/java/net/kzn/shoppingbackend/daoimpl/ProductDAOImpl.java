package net.kzn.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.ProductDAO;
import net.kzn.shoppingbackend.dto.Category;
import net.kzn.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int productID) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, productID);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> list() {

		Query query = sessionFactory.getCurrentSession().createQuery("from Product",Product.class);
				
		return query.getResultList();

	}

	@Override
	public boolean add(Product product) {
		try {
			 sessionFactory.getCurrentSession().persist(product);
			 return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public boolean update(Product product) {

		try {
			 sessionFactory.getCurrentSession().update(product);
			 return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try {
			 sessionFactory.getCurrentSession().update(product);
			 return true;
		}
		catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return false;
	}

	@Override
	public List<Product> listActiveProducts() {
		
		String selectActiveProducts = "from Product where active = :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts,Product.class).setParameter("active", true).getResultList();
		
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategoryID = "from Product where active = :active and categoryId = :categoryId";
		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategoryID,Product.class).setParameter("active", true).setParameter("categoryId", categoryId).getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestActiveProducts = "from Product where active = :active order by id";
		return sessionFactory.getCurrentSession().createQuery(selectLatestActiveProducts,Product.class).setParameter("active", true).setFirstResult(0).setMaxResults(count).getResultList();

	}

}
