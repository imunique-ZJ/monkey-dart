package loopz.monkeydart.domain;

public class Target {
	private int id;
	private String value;
	private String name;
	private String category;
	
	public Target() {
		super();
	}
	
	public Target(int id, String value, String name, String category) {
		setId(id);
		setValue(value);
		setName(name);
		setCategory(category);
	}
	
	public Target setId(int id) {
		this.id = id;
		return this;
	}
	
	public int getId() {
		return id;
	}
	
	public Target setValue(String value) {
		this.value = value;
		return this;
	}
	
	public String getValue() {
		return value;
	}
	
	public Target setName(String name) {
		this.name = name;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Target setCategory(String category) {
		this.category = category;
		return this;
	}
	
	public String getCategory() {
		return category;
	}
}
