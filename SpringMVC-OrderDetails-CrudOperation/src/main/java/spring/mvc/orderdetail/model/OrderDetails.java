package spring.mvc.orderdetail.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Order_Detail")
public class OrderDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int product_id;
	private String product_name;
	private String product_company;
	private int price;
	
	public OrderDetails(int product_id, String product_name, String product_company, int price) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_company = product_company;
		this.price = price;
	}
	
	public OrderDetails(String product_name, String product_company, int price) {
		super();
		this.product_name = product_name;
		this.product_company = product_company;
		this.price = price;
	}
	
	public OrderDetails() {
		super();
	}
	
	
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getProduct_company() {
		return product_company;
	}
	public void setProduct_company(String product_company) {
		this.product_company = product_company;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OrderDetails [product_id=" + product_id + ", product_name=" + product_name + ", product_company="
				+ product_company + ", price=" + price + "]";
	}
	
	
}
