package co.edu.javeriana.myapp.server.myappserver.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import co.edu.javeriana.myapp.server.myappserver.OfferService;

@Entity
public class University {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String Name;
	private String Domain;

	@OneToMany(mappedBy="institution")
	private List<RegisteredUser> students;
	
	@OneToMany(mappedBy="branch")
	private List<Offer> offers;

	/* ------------------------------ */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public List<RegisteredUser> getStudents() {
		return students;
	}

	public void setStudents(List<RegisteredUser> students) {
		this.students = students;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}
	
	

}
