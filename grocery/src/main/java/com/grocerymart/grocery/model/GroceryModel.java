package com.grocerymart.grocery.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@AllArgsConstructor 
@NoArgsConstructor
@ToString
@Getter
@Setter

@Entity
@Table(name="GrocerData")
public class GroceryModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="name")
	String name;
	
	@Column(name = "price")
	private float price;
	
	@Column(name= "category")
	private String category;
	
	@Column(name="weight")
	private String weight;
	
	@Column(name = "image", length=50, columnDefinition = "LONGBLOB")
	@Lob
	private byte[] image;
	
	
}
