package com.hueho.SGraph.core2;

import com.hueho.SGraph.core2.model.SimpleEdge;
import com.hueho.SGraph.core2.model.SimpleVertex;

/**
 * Class representing a basic directed graph implementation. <br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link SimpleVertex}
 * @param <E>
 *            A class which extends {@link SimpleEdge}
 */
public class DirectedGraph<V extends SimpleVertex, E extends SimpleEdge<V>> extends
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
	public DirectedGraph<V, E> shallowCopy() {
		DirectedGraph<V, E> copy = new DirectedGraph<>();
		this.auxShallowCopy(copy);
		return copy;
	}
}
