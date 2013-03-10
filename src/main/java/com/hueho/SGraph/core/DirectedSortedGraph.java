package com.hueho.SGraph.core;

/**
 * Class representing a basic directed graph implementation, with sorted
 * internal structures.<br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link ComparableVertex}
 * @param <E>
 *            A class which extends {@link ComparableEdge}
 */
public class DirectedSortedGraph<V extends ComparableVertex, E extends ComparableEdge<V>>
		extends AbstractSortedGraph<V, E> {

	/**
	 * Create a new sorted directed graph
	 */
	public DirectedSortedGraph() {
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
	public DirectedSortedGraph<V, E> shallowCopy() {
		DirectedSortedGraph<V, E> copy = new DirectedSortedGraph<>();
		this.auxShallowCopy(copy);
		return copy;
	}

}
