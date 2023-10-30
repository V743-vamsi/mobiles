package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
@Id
private Integer sno;
private String productname;
private Integer price;
public Integer getSno() {
	return sno;
}
public void setSno(Integer sno) {
	this.sno = sno;
}
public String getCustomername() {
	return productname;
}
public void setCustomername(String customername) {
	this.productname = customername;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String toString() {
	return "Product[sno="+sno+",productname="+productname+",price="+price+"]";
	
}

}