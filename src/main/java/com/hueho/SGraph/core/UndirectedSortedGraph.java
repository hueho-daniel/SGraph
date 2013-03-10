package com.hueho.SGraph.core;

import com.google.common.collect.ImmutableSet;

/**
 * @author Hueho
 * 
 * @param <V>
 * @param <E>
 */
public class UndirectedSortedGraph<V extends ComparableVertex, E extends ComparableEdge<V>>
		extends AbstractSortedGraph<V, E> {
	/**
	 * Create a new undirected graph
	 */
	public UndirectedSortedGraph() {
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
		return this.degree(vertex);
	}

	@Override
	public Integer outDegree(V vertex) {
		return this.degree(vertex);
	}

	/**
	 * @param vertex
	 * @return the degree of the vertex in the graph
	 */
	public Integer degree(V vertex) {
		return this.adjacencyList.get(vertex).size();
	}

	@Override
	public UndirectedSortedGraph<V, E> shallowCopy() {
		UndirectedSortedGraph<V, E> copy = new UndirectedSortedGraph<>();
		this.auxShallowCopy(copy);
		return copy;
	}
}
