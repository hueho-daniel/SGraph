package com.hueho.SGraph.core2;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.hueho.SGraph.core2.model.SimpleEdge;
import com.hueho.SGraph.core2.model.SimpleVertex;

/**
 * Abstract class with basic constructs for a graph with unsorted data
 * structures. Uses {@link LinkedHashMap} and {@link LinkedHashSet} internally.
 * Should be not dog-slow for most uses.<br>
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link SimpleVertex}
 * @param <E>
 *            A class which extends {@link SimpleEdge}
 */
public abstract class AbstractUnsortedGraph<V extends SimpleVertex, E extends SimpleEdge<V>>
		extends AbstractGraph<V, E> {

	/**
	 * Create a new graph
	 */
	public AbstractUnsortedGraph() {
		super(null, new LinkedHashSet<V>(), new LinkedHashSet<E>());
		this.adjacencyList = LinkedHashMultimap.create();
	}

	@Override
	public ImmutableSet<E> getAdjacentEdges(V vertex) {
		return ImmutableSet.copyOf(this.adjacencyList.get(vertex));
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
	public ImmutableSet<V> getVertices() {
		return ImmutableSet.copyOf(this.vertices);
	}

	@Override
	public ImmutableSet<E> getEdges() {
		return ImmutableSet.copyOf(this.edges);
	}
}
