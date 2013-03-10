package com.hueho.SGraph.core;

/**
 * A base abstract class representing a single edge in a graph. To use the
 * unsorted graph implementations, you need to create a class extending Edge,
 * representing a relationship between your Vertex objects. You also can't use
 * the default constructor for it. Because of how the graphs are implemented,
 * you usually doesn't need to do anything else.<br>
 * Once you create the edge, you can't change any of it endpoints. <br>
 * <br>
 * DO NOT OVERRIDE HASHCODE AND EQUALS IN YOUR EXTENDED CLASS.<br>
 * TODO: make it less sucky so people can override hashCode and equals if they
 * are using this class
 * 
 * @author Daniel Gracia
 * 
 */
public abstract class Edge<V extends Vertex> {

	private V source;
	private V target;

	private Integer edgeIndex;

	protected Edge(V source, V target) {
		this.source = source;
		this.target = target;
	}

	/**
	 * @return the internal edge index. You shouldn't need to use this.
	 */
	public Integer getEdgeIndex() {
		return this.edgeIndex;
	}

	/**
	 * Sets the internal edge index. Only for internal use.
	 */
	protected final void setEdgeIndex(Integer edgeIndex) {
		this.edgeIndex = edgeIndex;
	}

	/**
	 * @return the source of this edge
	 */
	public final V getSource() {
		return this.source;
	}

	/**
	 * @return the target of this edge
	 */
	public final V getTarget() {
		return this.target;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Edge) {
			Edge<V> that = (Edge<V>) obj;
			return that.edgeIndex == this.edgeIndex;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.edgeIndex;
	}

}
