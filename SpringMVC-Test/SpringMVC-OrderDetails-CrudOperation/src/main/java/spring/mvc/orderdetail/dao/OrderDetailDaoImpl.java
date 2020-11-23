package spring.mvc.orderdetail.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.mvc.orderdetail.model.OrderDetails;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void addOrder(OrderDetails orderDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(orderDetail);
	}

	@SuppressWarnings("unchecked")
	public List<OrderDetails> getAllOderDetails() {
		// TODO Auto-generated method stub
		String s = "from OrderDetails";
		List<OrderDetails> orderDetail =sessionFactory.getCurrentSession().createQuery(s).list();

		return orderDetail;
	}

	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		OrderDetails orderDetail=(OrderDetails)sessionFactory.getCurrentSession().get(OrderDetails.class, orderId);
		if(orderDetail !=null)
		{
			this.sessionFactory.getCurrentSession().delete(orderDetail);
		}
	}

	public OrderDetails updateOrderDetail(OrderDetails orderDetail) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(orderDetail);
		return orderDetail;
	}

	public OrderDetails getOrder(int orderId) {
		// TODO Auto-generated method stub
		OrderDetails orderDetail=(OrderDetails) sessionFactory.getCurrentSession().get(OrderDetails.class, orderId);
		return orderDetail;
	}

}
