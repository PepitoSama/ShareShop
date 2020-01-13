package model.dao;

public class Couple {
	private String name;
	private String value;
	
	/**
	 * Couple constructor
	 * Create a Couple of two string user for database request
	 * @param name The column name
	 * @param value The value
	 */
	public Couple(String name, String value) {
		this.name =name;
		this.value = "'" + value + "'";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
