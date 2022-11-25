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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Entity 
@Table(name = "Orders")
public class Order implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "OrderDate")
	Date createDate = new Date();
	String district;
	String status;
	String  address;
	String   email;
	String  province;
	String sdt;
	String wards;
	String pay;
	String name;
	
//	@OneToOne
//	@JoinColumn(name = "ID")
//	Status status;
	
	
	@ManyToOne
	@JoinColumn(name = "Username")
	public Account account;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderDetails;
	
}