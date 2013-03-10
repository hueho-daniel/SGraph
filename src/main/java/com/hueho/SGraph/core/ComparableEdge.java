package com.hueho.SGraph.core;

/**
 * A extended version of the Edge class, for use with sorted graphs. Mostly a
 * markup for the original class, to be honest. Needed so people won't forget to
 * implement both the compareTo and equals method. For that matter, you can
 * override hashCode, and NEED to override equals
 * 
 * @author Daniel Gracia
 * @see Edge
 * 
 */
public abstract class ComparableEdge<V extends ComparableVertex> extends
		Edge<V> implements Comparable<ComparableEdge<V>> {

	protected ComparableEdge(V source, V target) {
		super(source, target);
	}

	/**
	 * Compares two edges in a graph.
	 * 
	 * @param that
	 *            another Edge
	 * @return true if they are equal, false otherwise
	 */
	public abstract boolean equals(Edge<V> that);

}
