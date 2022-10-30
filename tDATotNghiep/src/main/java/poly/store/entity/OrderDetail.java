package poly.store.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Orderdetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToOne 
	@JoinColumn(name = "OrderID")
	Order order;
	
	@ManyToOne @JoinColumn(name = "ProductVariantID")
	ProductVarian productVariant;

	Boolean discount;
	Float price;
	Integer quantity;
	String note;
	
	@ManyToOne
	@JoinColumn(name = "Productid")
	Product product;
	

}
