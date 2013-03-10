package com.hueho.SGraph.example.fleury;

import com.hueho.SGraph.core.Vertex;

@SuppressWarnings("javadoc")
public class Person extends Vertex {

	private String name;

	public Person(String nome) {
		this.setName(nome);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.getVerticeIndex() + ": " + this.name;
	}

}
