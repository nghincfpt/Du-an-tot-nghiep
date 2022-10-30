package poly.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Pays")
public class Pay implements Serializable {
	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String PayType;
	
	@JsonIgnore
	@OneToMany(mappedBy = "payid")
	List<Order> orders;

	

}
