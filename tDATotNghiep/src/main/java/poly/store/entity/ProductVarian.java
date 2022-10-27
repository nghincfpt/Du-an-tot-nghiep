package poly.store.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity @Table(name = "ProductVariants")
public class ProductVarian implements Serializable {

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@ManyToMany
	@JoinColumn(name = "imageID")
	String imageID;
	Integer quantity;
	Float price;
	Boolean discount;
	String evaluate;
	String CPU;
	String ram;
	String hardDrice;
	String screen;
	String connector;
	String operatingSystem;
	String design;
	String sizeVolume;
	String releaseTime;
	String rearCamera;
	String FronCamera;
	String capacity;
	String chips;
	String sim;
	String battery;
	
	@JsonIgnore
	@OneToMany(mappedBy = "ProductVariants")
	List<OrderDetail> orderDetails;
	

	
}
