package poly.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Categories")
public class Category implements Serializable {

	@Id
	String id;
	String name;
	Integer   amount;
	String trademark;
	Float price;
	Float Price1;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;
}
