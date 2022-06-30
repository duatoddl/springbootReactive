package com.example.demo.vo;

public class Dish {
	
	private String description;
	private boolean delivered = false;
	
	public static Dish deliver(Dish dish) {
		Dish deliveredDish = new Dish(dish.description);
		deliveredDish.delivered = true;
		return deliveredDish;
	}
	
	public Dish(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isDelivered() {
		return this.delivered;
	}
	
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	@Override
	public String toString() {
		return "Dish { desciption = " + this.description + ", delivered = " + this.delivered + "}";
	}

}
