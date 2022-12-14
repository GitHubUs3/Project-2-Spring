package com.project2.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ItemId")
	private int id;
	
	@Column(name = "Name")
	@NotBlank
	private String name;
	
	@Column(name = "Price")
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY) // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "StoreId")
	@JsonIgnore
	private Store store;
	
	@ManyToOne(fetch = FetchType.LAZY) 
	@JoinColumn(name = "CategoryId") 
	@JsonIgnore
	private Category category;

	public Item() {
		super();
	}

	public Item(int id, String name, float price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price2) {
		this.price = price2;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", price=" + price + ", store=" + store + ", category=" + category
				+ "]";
	}
	
	
}
