package com.alex.utils;

public class ItemObject {
	private String nombre;
	private static int cantidad=0;
	
	public ItemObject() {
	}

	public ItemObject(String nombre){
		this.nombre = nombre;
		this.cantidad++;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	public String getNombre(){
		return this.nombre;
	}
}
