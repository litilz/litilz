package com.ecommerce.litil.vo;

import java.util.List;
import java.util.Objects;

public class ProductVO {

	private Integer id;
	private String name;
	private String selling;
	private String original;
	private String discount;
	private String category;
	private String weight;
	private String image;
	private Boolean favourite;
	private int quantity;

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

	public String getSelling() {
		return selling;
	}

	public void setSelling(String selling) {
		this.selling = selling;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getFavourite() {
		return favourite;
	}

	public void setFavourite(Boolean favourite) {
		this.favourite = favourite;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public boolean equals ( Object o ) {
		if (this == o) return true;
		if (o == null || getClass () != o.getClass ()) return false;
		ProductVO productVO = (ProductVO) o;
		return Objects.equals ( id, productVO.id );
	}

	@Override
	public int hashCode () {
		return Objects.hash ( id );
	}
}
