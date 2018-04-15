package co.edu.javeriana.myapp.server.myappserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Offer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String product_name;
	private Integer inventory;
	private Double price;
	private String description;
	private String image_url;
	private String category;
	
	@ManyToOne
	@JsonIgnore
	private RegisteredUser univendedor;
	
	@ManyToOne
	@JsonIgnore
	private University branch;
	
	/* ----------------------------- */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public RegisteredUser getUnivendedor() {
		return univendedor;
	}

	public void setUnivendedor(RegisteredUser univendedor) {
		this.univendedor = univendedor;
	}

	public University getBranch() {
		return branch;
	}

	public void setBranch(University branch) {
		this.branch = branch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
