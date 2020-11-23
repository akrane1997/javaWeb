package spring.mvc.orderdetail.service;

import java.util.List;

import spring.mvc.orderdetail.model.OrderDetails;

public interface OrderDetailService {

	public void addOrder(OrderDetails orderDetail);
	 
    public List<OrderDetails> getAllOderDetails();
 
    public void deleteOrder(Integer orderId);
 
    public OrderDetails updateOrderDetail(OrderDetails orderDetail);
 
    public OrderDetails getOrder(int orderId);
}
