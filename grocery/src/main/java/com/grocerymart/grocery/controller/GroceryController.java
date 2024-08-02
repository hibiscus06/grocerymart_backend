package com.grocerymart.grocery.controller;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerymart.grocery.model.GroceryModel;
import com.grocerymart.grocery.repository.GroceryRepo;
import com.grocerymart.grocery.request.GroceryRequest;
import com.razorpay.*;

@RestController
public class GroceryController {
	@Autowired
	private GroceryRepo repo;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/add_item")
	public GroceryModel addItem(@RequestBody GroceryRequest grocery) {
		GroceryModel g = new GroceryModel();
		if(grocery.getImage()!=null) {
			byte[] image = Base64.getDecoder().decode(grocery.getImage()); 

			g.setId(grocery.getId());
			g.setCategory(grocery.getCategory());
			g.setName(grocery.getName());
			g.setPrice(grocery.getPrice());
			g.setWeight(grocery.getWeight());
			g.setImage(image);
		}
		else {
			
		}
		return repo.save(g);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/get_items")
	public List<GroceryModel> getItems(){
		return repo.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/user/createorder")
	@ResponseBody
	public String createOrder(@RequestBody Map<String,Object> data) throws Exception 
	{
		System.out.print(data);
		int amt = Integer.parseInt(data.get("amount").toString());
		var client = new RazorpayClient("rzp_test_uUUpZhisIywk8A","wKjoDUrVrZdYPklG4qc3FPn9");
		JSONObject ob = new JSONObject();
		ob.put("amount", amt*100);
		ob.put("currency", "INR");
		Order order = client.orders.create(ob);
		return order.toString();
	}
	
	@GetMapping("/users")
	public String getUser() {
		 System.out.println("getting users");
		 return "Users";
	}
	
}
