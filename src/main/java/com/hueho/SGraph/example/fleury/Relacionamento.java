package com.hueho.SGraph.example.fleury;

import com.hueho.SGraph.core.Edge;

@SuppressWarnings("javadoc")
public class Relacionamento extends Edge<Pessoa> {

	public Relacionamento(Pessoa a, Pessoa b) {
		this.setSource(a);
		this.setTarget(b);
	}

	public Pessoa getSentidor() {
		return this.getSource();
	}

	public Pessoa getSentido() {
		return this.getTarget();
	}

	@Override
	public String toString() {
		return "(" + this.getSource().toString() + ") -> ("
				+ this.getTarget().toString() + ")";
	}

}
