package com.hueho.SGraph.core2.model;

/**
 * A interface representing a single edge in a unsorted graph
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            The vertex type used by the edge
 */
public interface ComparableEdge<V extends ComparableVertex> extends
		Comparable<ComparableEdge<V>>, Edge<V> {

	/**
	 * Compares two edges in a graph.
	 * 
	 * @param that
	 *            another Edge
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(ComparableEdge<V> that);

}
