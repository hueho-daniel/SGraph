package com.hueho.SGraph.example.fleury;

import com.hueho.SGraph.core.Vertex;

@SuppressWarnings("javadoc")
public class Pessoa extends Vertex {

	private String nome;

	public Pessoa(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return this.getVerticeIndex() + ": " + this.nome;
	}

}
