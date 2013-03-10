package com.hueho.SGraph.core;

/**
 * A extended version of the Vertex class, for use with sorted graphs. Mostly a
 * markup for the original class, to be honest. Needed so people won't forget to
 * implement both the compareTo and equals method. For that matter, you can
 * override hashCode, and NEED to override equals
 * 
 * @author Daniel Gracia
 * @see Vertex
 * 
 */

public abstract class ComparableVertex extends Vertex implements
		Comparable<ComparableVertex> {

	/**
	 * Compares two edges in a graph.
	 * 
	 * @param that
	 *            another ComparableVertex
	 * @return true if they are equal, false otherwise
	 */
	public abstract boolean equals(ComparableVertex that);

}
