package com.hueho.SGraph.core;

/**
 * @author Hueho
 * 
 * @param <V>
 */
public abstract class Edge<V extends Vertex> {

	private V source;
	private V target;

	private Integer edgeIndex;

	/**
	 * @return
	 */
	public Integer getEdgeIndex() {
		return this.edgeIndex;
	}

	protected final void setEdgeIndex(Integer edgeIndex) {
		this.edgeIndex = edgeIndex;
	}

	/**
	 * @return
	 */
	public final V getSource() {
		return this.source;
	}

	/**
	 * @return
	 */
	public final V getTarget() {
		return this.target;
	}

	/**
	 * @param source
	 */
	public final void setSource(final V source) {
		this.source = source;
	}

	/**
	 * @param target
	 */
	public final void setTarget(V target) {
		this.target = target;
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
