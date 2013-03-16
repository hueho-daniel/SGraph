package com.hueho.SGraph.core2.model;

/**
 * A interface representing a single vertex in a unsorted graph.
 * 
 * @author Daniel Gracia
 * 
 */
public interface SimpleVertex extends Vertex {

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();
}
