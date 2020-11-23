package spring.mvc.orderdetail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spring.mvc.orderdetail.model.OrderDetails;
import spring.mvc.orderdetail.service.OrderDetailService;

@Controller
public class OrderDetailController {
	
	@Autowired
	private OrderDetailService orderDetailService;
	
	@RequestMapping(value="/")
	public ModelAndView listOrderDetail(ModelAndView model) throws IOException {
		List<OrderDetails> listOrderDetail = orderDetailService.getAllOderDetails();
		model.addObject("listOrderDetail",listOrderDetail);
		model.setViewName("home");
		return model;
	}
	
	@RequestMapping (value ="/newOrder", method = RequestMethod.GET)
	public ModelAndView AddNewOrder(ModelAndView model) {
		OrderDetails orderDetail = new OrderDetails();
		model.addObject("orderDetail",orderDetail);
		model.setViewName("OrderDetailForm");	
		return model;
		
	}
	
	 @RequestMapping(value = "/saveOrderDetail", method = RequestMethod.POST)
	    public ModelAndView saveOrder(@ModelAttribute("orderDetail") OrderDetails orderDetail) {
	     int id=orderDetail.getProduct_id();   
	     System.out.println("Id "+id);
		 if (orderDetail.getProduct_id() == 0) 
	        {
	        	orderDetailService.addOrder(orderDetail);
	        } 
	        else 
	        {
	        	orderDetailService.updateOrderDetail(orderDetail);
	        }
	        return new ModelAndView("redirect:/");
	    }
	 
	 @RequestMapping(value = "/deleteOrder", method = RequestMethod.GET)
	    public ModelAndView deleteOrder(HttpServletRequest request) {
	        int orderId = Integer.parseInt(request.getParameter("product_id"));
	        orderDetailService.deleteOrder(orderId);;
	        return new ModelAndView("redirect:/");
	    }
	 
	 @RequestMapping(value = "/editOrder", method = RequestMethod.GET)
	    public ModelAndView editOrder(HttpServletRequest request) {
	        int orderId = Integer.parseInt(request.getParameter("product_id"));
	        OrderDetails orderDetail = orderDetailService.getOrder(orderId);
	        ModelAndView model = new ModelAndView("OrderDetailForm");
	        model.addObject("orderDetail", orderDetail);
	 
	        return model;
	    }
}
