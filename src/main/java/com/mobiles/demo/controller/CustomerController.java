package com.mobiles.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Customer;
import com.example.demo.Entity.Product;
import com.example.demo.paymentException.paymentException;
import com.example.demo.repo.OnlineServiceImpl;
import com.example.demo.repo.ProductRepo;

@RestController
public class CustomerController {
		@Autowired
		
		OnlineServiceImpl onlineserviceimpl;
		@Autowired
		ProductRepo prepo;

		public ProductRepo getPrepo() {
			return prepo;
		}

		public void setPrepo(ProductRepo prepo) {
			this.prepo = prepo;
		}

		public OnlineServiceImpl getOnlineServiceimpl() {
			return onlineserviceimpl;
		}

		public void setServiceimpl(OnlineServiceImpl onlineserviceimpl) {
			this.onlineserviceimpl = onlineserviceimpl;
		}
		
		

		public OnlineServiceImpl getOnlineserviceimpl() {
			return onlineserviceimpl;
		}

		public void setOnlineserviceimpl(OnlineServiceImpl onlineserviceimpl) {
			this.onlineserviceimpl = onlineserviceimpl;
		}

		@GetMapping("/getcustomer")
		public ResponseEntity<List<Customer>> getb(){
			List<Customer> customer=onlineserviceimpl.getcustomer();
			return new ResponseEntity<>(customer,HttpStatus.OK);
		}
		
		@PostMapping("/customer")
		public ResponseEntity<String> inbus(@RequestBody Customer c ){
			String s=onlineserviceimpl.insertcustomer(c);
			return new ResponseEntity<>(s,HttpStatus.CREATED);
		}
		
		@PutMapping("/customerupdate")
		public ResponseEntity<String> upbus(@RequestBody Customer c ){
			String s=onlineserviceimpl.updatecustomer(c);
			return new ResponseEntity<>(s,HttpStatus.CREATED);
		}
		
		@DeleteMapping("/customerdelete/{cid}")
		public ResponseEntity<String>incustomer(@PathParam("cid")Integer cid){
		String s=onlineserviceimpl.deletecustomer(cid);
		return new ResponseEntity<>(s,HttpStatus.OK);
		
		}
		
		@GetMapping("/getProducts")
		public ResponseEntity<List<Product>> getf(){
			List<Product> product= prepo.findAll();
			return new ResponseEntity<>(product,HttpStatus.OK);
		}
	    

		@GetMapping("/getproduct/{sno}")
		public ResponseEntity<Optional<Product>> inproduct(@PathVariable("sno") Integer sno){
		Optional<Product> product=prepo.findById(sno);
		//OrderConformation order =new OrderConformation();
		//String s = order.payment(f.getAmt());
		return new ResponseEntity<>(product,HttpStatus.OK);
		}
		
		@GetMapping("/product/{productname}")
		public ResponseEntity<Product> inproduct(@PathVariable("productname")String productname){
		Product product=prepo.findByproductname(productname);
		return new ResponseEntity<>(product,HttpStatus.OK);
		}	
		
		@GetMapping("orderconform/price/{price}/option/{option}")
		public ResponseEntity<String>price(@PathVariable("price")Integer price,@PathVariable("option")Integer option, String productname) throws paymentException{
			Product product=prepo.findByproductname(productname);
					 int actualamt=product.getPrice();
					String s=Orderconformation.payment(price, option, actualamt);
			return new ResponseEntity<>(s,HttpStatus.OK);
			
			
			

		

	}
	}