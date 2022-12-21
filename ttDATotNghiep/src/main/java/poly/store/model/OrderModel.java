package poly.store.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class OrderModel {
	

	@Id
	private Long id;
	String district;
	String address;
	String  email;
	String  province;
	String sdt;
	String wards;
	String pay;
	private String status;
	
	
	public OrderModel(Long id, String district, String email, String province,String sdt,String wards,String pay, String status) {
		super();
		this.id = id;
		this.district = district;
		this.email = email;
		this.province = province;
		this.sdt = sdt;
		this.wards = wards;
		this.pay = pay;
		this.status = status;
	}
}
