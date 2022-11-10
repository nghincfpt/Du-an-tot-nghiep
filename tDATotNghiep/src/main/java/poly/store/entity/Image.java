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
@Entity @Table(name = "Images")
public class Image implements Serializable{

	@Id	
	String id;
	String name;
	String size;
	String type;
	
	@JsonIgnore
	@OneToMany(mappedBy = "image")
	List<ProductVarian> productVariants;
	
	@JsonIgnore
	@OneToMany(mappedBy = "images")
	List<Product> product;	
}
