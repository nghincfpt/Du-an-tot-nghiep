package poly.store.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "status")
public class Status implements Serializable {
	

	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	
	String confirm;
	String handle;
	String transport;
	String deliver;
	String cancel;
	
//	@JsonIgnore
//	@OneToOne(mappedBy = "status")
//	List<Order> orders;
//	


	

}
