package com.hueho.SGraph.example.fleury;

import java.util.List;

import com.hueho.SGraph.core.UndirectedGraph;

/**
 * 
 * An example for the Fleury algorithm for finding Eulerian paths/cycles.
 * 
 * Using portuguese for variable and function names because yes.
 * TODO: translate later and comment better
 * 
 * @author Hueho
 *
 */
public class ExampleUndirectedGraph {

	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		UndirectedGraph<Pessoa, Relacionamento> grafo = new UndirectedGraph<>();
		Pessoa[] keep = new Pessoa[5];
		for (int i = 0; i < 5; i++) {
			keep[i] = new Pessoa("Número " + i);
			grafo.addVertex(keep[i]);
		}

		grafo.addEdge(new Relacionamento(keep[0], keep[1]));
		grafo.addEdge(new Relacionamento(keep[1], keep[2]));
		grafo.addEdge(new Relacionamento(keep[2], keep[3]));
		grafo.addEdge(new Relacionamento(keep[3], keep[4]));
		grafo.addEdge(new Relacionamento(keep[4], keep[0]));
		grafo.addEdge(new Relacionamento(keep[0], keep[2]));
		grafo.addEdge(new Relacionamento(keep[0], keep[3]));
		grafo.addEdge(new Relacionamento(keep[1], keep[3]));
		grafo.addEdge(new Relacionamento(keep[1], keep[4]));
		grafo.addEdge(new Relacionamento(keep[2], keep[4]));

		List<Pessoa> result = Fleury.execute(grafo);
		System.out.print("Ínicio -> ");
		for (Pessoa p : result) {
			System.out.print(p.getNome()  + " -> "); 
		}
		System.out.print("Fim");
	}

}
