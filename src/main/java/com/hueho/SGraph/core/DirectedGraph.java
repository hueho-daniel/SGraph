package com.hueho.SGraph.core;

/**
 * Class representing a basic directed graph implementation. <br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link Vertex}
 * @param <E>
 *            A class which extends {@link Edge}
 */
public class DirectedGraph<V extends Vertex, E extends Edge<V>> extends
		AbstractUnsortedGraph<V, E> {

	/**
	 * Create a new directed graph
	 */
	public DirectedGraph() {
		super();
	}

	/**
	 * Very expensive operation, use with care
	 */
	@Override
	public Integer inDegree(V vertex) {
		int degree = 0;
		for (E e : this.adjacencyList.values()) {
			if (e.getTarget() == vertex) {
				degree++;
			}
		}
		return degree;
	}

	@Override
	public Integer outDegree(V vertex) {
		return this.adjacencyList.get(vertex).size();
	}

	@Override
	public DirectedGraph<V, E> shallowCopy() {
		DirectedGraph<V, E> copy = new DirectedGraph<>();
		this.auxShallowCopy(copy);
		return copy;
	}
}
