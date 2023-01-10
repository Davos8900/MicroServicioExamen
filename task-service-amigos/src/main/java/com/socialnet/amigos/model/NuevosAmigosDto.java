package com.socialnet.amigos.model;

public class NuevosAmigosDto {
	private String amigoTag1;
	private String amigoTag2;
	private String fecha;
	
	public NuevosAmigosDto() {
		
	}
	
	public NuevosAmigosDto(String amigoTag1, String amigoTag2, String fecha) {
		super();
		this.amigoTag1 = amigoTag1;
		this.amigoTag2 = amigoTag2;
		this.fecha = fecha;
	}
	
	public String getAmigoTag1() {
		return amigoTag1;
	}
	public void setAmigoTag1(String amigoTag1) {
		this.amigoTag1 = amigoTag1;
	}
	public String getAmigoTag2() {
		return amigoTag2;
	}
	public void setAmigoTag2(String amigoTag2) {
		this.amigoTag2 = amigoTag2;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
