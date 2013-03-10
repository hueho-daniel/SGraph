package com.hueho.SGraph.core;

/**
 * A base abstract class representing a single vertex in a graph. To use the
 * unsorted graph implementations, you need to make your class extends Vertex.
 * Because of how the graphs are implemented, you usually doesn't need to do
 * anything else.<br>
 * 
 * DO NOT OVERRIDE HASHCODE AND EQUALS IN YOUR EXTENDED CLASS TODO: make it less
 * sucky so people can override hashCode and equals if they are using this class
 * 
 * @author Daniel Gracia
 * 
 */
public abstract class Vertex {

	private Integer verticeIndex;

	/**
	 * @return the internal vertice index. Ideally, you should not need to use
	 *         it for anything
	 */
	public Integer getVerticeIndex() {
		return this.verticeIndex;
	}

	/**
	 * Sets the internal vertice index. Only for internal use.
	 */
	protected final void setVerticeIndex(Integer verticeIndex) {
		this.verticeIndex = verticeIndex;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Vertex) {
			Vertex that = (Vertex) obj;
			return that.verticeIndex == this.verticeIndex;
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return this.verticeIndex;
	}

}
