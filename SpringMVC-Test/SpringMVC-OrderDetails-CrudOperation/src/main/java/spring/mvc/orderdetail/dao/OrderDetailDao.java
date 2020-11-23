package spring.mvc.orderdetail.dao;

import java.util.List;

import spring.mvc.orderdetail.model.OrderDetails;



public interface OrderDetailDao {

	public void addOrder(OrderDetails orderDetail);
	 
    public List<OrderDetails> getAllOderDetails();
 
    public void deleteOrder(Integer orderId);
 
    public OrderDetails updateOrderDetail(OrderDetails orderDetail);
 
    public OrderDetails getOrder(int orderId);
}
