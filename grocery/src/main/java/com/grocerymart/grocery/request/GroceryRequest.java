package com.grocerymart.grocery.request;

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

public class GroceryRequest {
	private int id;
	private String name;
    private float price;
	private String category;
	private String image;
	private String weight;

}
