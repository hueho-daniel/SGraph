package com.hueho.SGraph.example.fleury;

import com.hueho.SGraph.core.Edge;

@SuppressWarnings("javadoc")
public class Relationship extends Edge<Person> {

	public Relationship(Person source, Person target) {
		super(source, target);
	}

	@Override
	public String toString() {
		return "(" + this.getSource().toString() + ") -> ("
				+ this.getTarget().toString() + ")";
	}

}
