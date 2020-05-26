package mr.devfam.moonlight.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product implements Serializable{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private double currentPrice;
	private boolean promotion;
	private boolean selected;
	private boolean available;
	private String photoName;
	
	@ManyToOne
	private Category category;
	
	@Override
	public String toString() {
		return "(id : "+this.id+", name : "+this.name+", currentPrice : "+this.currentPrice+", photoName : "+this.photoName+")";
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(Long id, String name, String description, double currentPrice, boolean promotion, boolean selected,
			boolean available, String photoName, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.currentPrice = currentPrice;
		this.promotion = promotion;
		this.selected = selected;
		this.available = available;
		this.photoName = photoName;
		this.category = category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(double currentPrice) {
		this.currentPrice = currentPrice;
	}

	public boolean isPromotion() {
		return promotion;
	}

	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getPhotoName() {
		return photoName;
	}

	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
}
