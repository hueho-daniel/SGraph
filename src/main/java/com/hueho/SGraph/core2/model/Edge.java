package com.hueho.SGraph.core2.model;

/**
 * A interface representing a single edge in a graph.
 * Used for markup.
 * 
 * @author Daniel Gracia
 * 
 */
public interface Edge<V extends Vertex> {
	
	/**
	 * @return the source of this edge
	 */
	public V getSource();

	/**
	 * @return the target of this edge
	 */
	public V getTarget();

}
