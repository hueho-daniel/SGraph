package com.hueho.SGraph.example.fleury;

import java.util.List;

import com.hueho.SGraph.core.UndirectedGraph;

/**
 * 
 * An example for the Fleury algorithm for finding Eulerian paths/cycles.
 * 
 * TODO: comment better
 * 
 * @author Daniel Gracia
 * 
 */
public class ExampleUndirectedGraph {

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		UndirectedGraph<Person, Relationship> graph = new UndirectedGraph<>();
		Person[] keep = new Person[5];
		for (int i = 0; i < 5; i++) {
			keep[i] = new Person("Numbah " + (i + 1));
			graph.addVertex(keep[i]);
		}

		graph.addEdge(new Relationship(keep[0], keep[1]));
		graph.addEdge(new Relationship(keep[1], keep[2]));
		graph.addEdge(new Relationship(keep[2], keep[3]));
		graph.addEdge(new Relationship(keep[3], keep[4]));
		graph.addEdge(new Relationship(keep[4], keep[0]));
		graph.addEdge(new Relationship(keep[0], keep[2]));
		graph.addEdge(new Relationship(keep[0], keep[3]));
		graph.addEdge(new Relationship(keep[1], keep[3]));
		graph.addEdge(new Relationship(keep[1], keep[4]));
		graph.addEdge(new Relationship(keep[2], keep[4]));

		List<Person> result = Fleury.execute(graph);
		System.out.print("Start -> ");
		for (Person p : result) {
			System.out.print(p.getName() + " -> ");
		}
		System.out.print("End");
	}

}
