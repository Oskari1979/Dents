package data;

public class Product {

	private int id;
	private String product_id;
	private String name;
	private int weight;
	private int energy;
	
	public Product () {
		super();
	}
	
	public Product(int id, String product_id, String name, int weight, int energy) {
		super();
		this.id=id;
		this.product_id=product_id;
		this.name=name;
		this.weight=weight;
		this.energy=energy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
}
