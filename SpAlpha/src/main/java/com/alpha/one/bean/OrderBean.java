package com.alpha.one.bean;

import java.util.Date;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderBean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank(message = "order ID error") 
	private static int Oid=1;
	
	@Column(name ="Maincourse")
	@NotBlank(message = "select valid maincourse")  @NotNull(message = "select valid maincourse") @NotEmpty(message = "select valid maincourse")
	private String Maincourse;//"burger";
	
	@Column(name ="quantity")
	@NotBlank(message = "select valid quantity")  @Min(1) 
	private String Quantity;//"1";
	
	@Column(name ="total")
	@DecimalMin("0.0") 
	private double Total=0.0;
	
	@Column(name ="odate")
	@DateTimeFormat()
	private Date odate;
	
	
	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		this.Total = total;
	}

	public Date getOdate() {
		return odate;
	}

	public void setOdate(Date odate) {
		this.odate = odate;
	}

	public OrderBean() {}
	
	public OrderBean( String maincourse, String quantity,double total ) {
		super();
		Oid++;
		this.Maincourse = maincourse;
		this.Quantity = quantity;
		
		this.Total = total;
	}
	public int getOid() {
		return Oid;
	}
	public void setOid(int oid) {
		Oid = oid;
	}
	public String getMaincourse() {
		return Maincourse;
	}
	public void setMaincourse(String maincourse) {
		this.Maincourse = maincourse;
	}
	public String getQuantity() {
		return Quantity;
	}
	public void setQuantity(String quantity) {
		this.Quantity = quantity;
	}
	
	
	
}
