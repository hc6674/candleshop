package csec.vulnerable.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity 
@Table(name = "ecom_tag")
public class Tag {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "TAG_SEQ")
	@SequenceGenerator(name = "TAG_SEQ",sequenceName = "ECOM_TAG_SEQ",allocationSize = 1)
	private int id;
	@Column
	@NotEmpty
	private String name;
    @OneToMany(mappedBy = "tag",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<Product> products;
	
	public Tag(int id, String name, List<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
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
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
	
	
	

	
    
}
