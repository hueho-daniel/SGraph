package com.hueho.SGraph.core2.model;

/**
 * A interface representing a single vertex in a sorted graph.
 * 
 * @author Daniel Gracia
 * 
 */
public interface ComparableVertex extends Comparable<ComparableVertex>, Vertex {

	/**
	 * Compares two edges in a graph.
	 * 
	 * @param that
	 *            another ComparableVertex
	 * @return true if they are equal, false otherwise
	 */
	public boolean equals(ComparableVertex that);

}
