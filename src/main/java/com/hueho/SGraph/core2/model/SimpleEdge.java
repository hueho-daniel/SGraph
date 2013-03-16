package com.hueho.SGraph.core2.model;

/**
 * A interface representing a single edge in a unsorted graph
 * 
 * @author Daniel Gracia
 *
 * @param <V> The vertex type used by the edge
 */
public interface SimpleEdge<V extends SimpleVertex> extends Edge<V> {
	
	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();
}
