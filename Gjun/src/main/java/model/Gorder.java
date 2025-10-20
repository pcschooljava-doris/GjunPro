package model;

public class Gorder {
	private Integer id;
	private String name;
	private int lcd;
	private int ram;
	/**
	 * 
	 */
	public Gorder() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param name
	 * @param lcd
	 * @param ram
	 */
	public Gorder(String name, int lcd, int ram) {
		super();
		this.name = name;
		this.lcd = lcd;
		this.ram = ram;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLcd() {
		return lcd;
	}
	public void setLcd(int lcd) {
		this.lcd = lcd;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	
	
}
