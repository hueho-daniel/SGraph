package com.hueho.SGraph.core;

/**
 * @author Hueho
 * 
 */
public abstract class Vertex {

	private Integer verticeIndex;

	/**
	 * @return
	 */
	public Integer getVerticeIndex() {
		return this.verticeIndex;
	}

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
