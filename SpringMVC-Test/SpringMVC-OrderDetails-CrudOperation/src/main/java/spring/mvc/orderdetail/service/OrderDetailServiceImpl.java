package spring.mvc.orderdetail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import spring.mvc.orderdetail.dao.OrderDetailDao;
import spring.mvc.orderdetail.model.OrderDetails;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;
	
	@Transactional
	public void addOrder(OrderDetails orderDetail) {
		// TODO Auto-generated method stub
		orderDetailDao.addOrder(orderDetail);

	}
	@Transactional
	public List<OrderDetails> getAllOderDetails() {
		// TODO Auto-generated method stub
		return orderDetailDao.getAllOderDetails();
	}
	@Transactional
	public void deleteOrder(Integer orderId) {
		// TODO Auto-generated method stub
		orderDetailDao.deleteOrder(orderId);
	}
	
	@Transactional
	public OrderDetails updateOrderDetail(OrderDetails orderDetail) {
		// TODO Auto-generated method stub
		return orderDetailDao.updateOrderDetail(orderDetail);
	}

	public OrderDetails getOrder(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDao.getOrder(orderId);
	}
}
