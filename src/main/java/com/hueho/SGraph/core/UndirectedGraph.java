package com.hueho.SGraph.core;

import com.google.common.collect.ImmutableSet;

/**
 * Class representing a basic undirected graph implementation. <br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link Vertex}
 * @param <E>
 *            A class which extends {@link Edge}
 */
public class UndirectedGraph<V extends Vertex, E extends Edge<V>> extends
		AbstractUnsortedGraph<V, E> {

	/**
	 * Create a new undirected graph
	 */
	public UndirectedGraph() {
		super();
	}

	@Override
	public boolean addEdge(E edge) {
		return super.addEdge(edge)
				&& this.adjacencyList.put(edge.getTarget(), edge);
	}

	@Override
	public boolean removeEdge(E edge) {
		return super.removeEdge(edge)
				&& this.adjacencyList.remove(edge.getTarget(), edge);
	};

	@Override
	public E undoRemoveEdge() {
		E e = super.undoRemoveEdge();
		this.adjacencyList.put(e.getTarget(), e);
		return e;
	}

	@Override
	public ImmutableSet<V> getAdjacentVertices(V vertex) {
		ImmutableSet.Builder<V> builder = new ImmutableSet.Builder<>();
		for (E e : this.adjacencyList.get(vertex)) {
			builder.add((vertex.equals(e.getTarget()) ? e.getSource() : e
					.getTarget()));
		}
		return builder.build();
	}

	@Override
	public Integer inDegree(V vertex) {
		return this.outDegree(vertex);
	}

	/**
	 * @param vertex
	 * @return the degree of the vertex in the graph
	 */
	public Integer degree(V vertex) {
		return this.outDegree(vertex);
	}

	@Override
	public UndirectedGraph<V, E> shallowCopy() {
		UndirectedGraph<V, E> copy = new UndirectedGraph<>();
		this.auxShallowCopy(copy);
		return copy;
	}

}
