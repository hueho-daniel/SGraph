package com.hueho.SGraph.core;

import java.util.TreeMap;
import java.util.TreeSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.TreeMultimap;

/**
 * Abstract class with basic constructs for a graph with sorted data structures.
 * Uses {@link TreeMap} and {@link TreeSet} internally, so it isn't exactly
 * ultra fast. Useful if you need everything always sorted though.<br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link ComparableVertex}
 * @param <E>
 *            A class which extends {@link ComparableEdge}
 */
public abstract class AbstractSortedGraph<V extends ComparableVertex, E extends ComparableEdge<V>>
		extends AbstractGraph<V, E> {

	/**
	 * Create a new undirected graph
	 */
	public AbstractSortedGraph() {
		super(null, new TreeSet<V>(), new TreeSet<E>());
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
