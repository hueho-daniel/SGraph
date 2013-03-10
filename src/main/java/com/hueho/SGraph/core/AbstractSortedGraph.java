package com.hueho.SGraph.core;

import java.util.LinkedHashSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.TreeMultimap;

/**
 * @author Hueho
 * 
 * @param <V>
 * @param <E>
 */
public abstract class AbstractSortedGraph<V extends ComparableVertex, E extends ComparableEdge<V>>
		extends AbstractGraph<V, E> {

	/**
	 * Create a new undirected graph
	 */
	public AbstractSortedGraph() {
		super(null, new LinkedHashSet<V>(), new LinkedHashSet<E>());
		this.adjacencyList = TreeMultimap.create();
	}

	@Override
	public ImmutableSortedSet<E> getAdjacentEdges(V vertex) {
		return ImmutableSortedSet.copyOf(this.adjacencyList.get(vertex));
	}

	@Override
	public ImmutableSet<V> getAdjacentVertices(V vertex) {
		ImmutableSet.Builder<V> builder = new ImmutableSet.Builder<>();
		for (E e : this.adjacencyList.get(vertex)) {
			builder.add(e.getTarget());
		}
		return builder.build();
	}

	@Override
	public ImmutableSortedSet<V> getVertices() {
		return ImmutableSortedSet.copyOf(this.vertices);
	}

	@Override
	public ImmutableSortedSet<E> getEdges() {
		return ImmutableSortedSet.copyOf(this.edges);
	}

}
