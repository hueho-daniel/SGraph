package com.hueho.SGraph.core2;

import java.util.Collection;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multimap;
import com.hueho.SGraph.core2.model.Edge;
import com.hueho.SGraph.core2.model.SimpleEdge;
import com.hueho.SGraph.core2.model.SimpleVertex;
import com.hueho.SGraph.core2.model.Vertex;

/**
 * Abstract class with basic constructs for a graph implementation. <br>
 * Uses a adjacency list, plus individual collections for vertices and edges to
 * model the graph.
 * 
 * @author Daniel Gracia
 * 
 * @param <V>
 *            A class which extends {@link SimpleVertex}
 * @param <E>
 *            A class which extends {@link SimpleEdge}
 */
public abstract class AbstractGraph<V extends Vertex, E extends Edge<V>> {

	protected Multimap<V, E> adjacencyList;
	protected Collection<V> vertices;
	protected Collection<E> edges;
	protected E lastRemoved;

	protected AbstractGraph(Multimap<V, E> adjacencyList,
			Collection<V> vertices, Collection<E> edges) {
		this.adjacencyList = adjacencyList;
		this.vertices = vertices;
		this.edges = edges;
	}

	/**
	 * Add a single Vertex object to the graph, if it is not in the graph
	 * already.
	 * 
	 * @return {@code true} if successful, {@code false} otherwise
	 */
	public boolean addVertex(V vertex) {
		return this.vertices.add(vertex);
	}

	/**
	 * Add a single Edge object to the graph, if it is not in the graph already.
	 * 
	 * @return {@code true} if successful, {@code false} otherwise
	 */
	public boolean addEdge(E edge) {
		return this.edges.add(edge)
				&& this.adjacencyList.put(edge.getSource(), edge);
	}

	/**
	 * Removes a Vertex object to the graph, if it is still in the graph. <br>
	 * This method will also remove any dependent edge from the graph.
	 * 
	 * @return {@code true} if successful, {@code false} otherwise
	 */
	public boolean removeVertex(V vertex) {
		for (E e : this.adjacencyList.get(vertex)) {
			this.edges.remove(e);
		}
		return this.vertices.remove(vertex);
	}

	/**
	 * Removes a single Edge object to the graph, if it is still in the graph. <br>
	 * 
	 * @return {@code true} if successful, {@code false} otherwise
	 */
	public boolean removeEdge(E edge) {
		this.adjacencyList.remove(edge.getSource(), edge);
		if (this.edges.remove(edge)) {
			this.lastRemoved = edge;
			return true;
		} else
			return false;
	}

	/**
	 * Undo the last edge removal done by the {@link removeEdge()} method
	 * 
	 * @return the restored edge
	 */
	public E undoRemoveEdge() { // TODO should throw exception
		if (this.lastRemoved != null) {
			this.edges.add(this.lastRemoved);
			this.adjacencyList.put(this.lastRemoved.getSource(),
					this.lastRemoved);
			E result = this.lastRemoved;
			this.lastRemoved = null;
			return result;
		}
		return null;
	}

	/**
	 * @param vertex
	 * @return a {@link ImmutableCollection} of adjacent edges to the vertex
	 *         parameter
	 */
	public abstract ImmutableCollection<E> getAdjacentEdges(V vertex);

	/**
	 * 
	 * @param vertex
	 * @return a {@link ImmutableCollection} of adjacent vertices to the vertex
	 *         parameter
	 */
	public abstract ImmutableCollection<V> getAdjacentVertices(V vertex);

	/**
	 * 
	 * @param vertex
	 * @return the in-degree of the vertex
	 */
	public abstract Integer inDegree(V vertex);

	/**
	 * 
	 * @param vertex
	 * @return the out-degree of the vertex
	 */
	public Integer outDegree(V vertex) {
		return this.adjacencyList.get(vertex).size();
	}

	/**
	 * @return a {@link ImmutableCollection} containing all the vertices of the
	 *         graph
	 */
	public abstract ImmutableCollection<V> getVertices();

	/**
	 * @return a {@link ImmutableCollection} containing all the edges of the
	 *         graph
	 */
	public abstract ImmutableCollection<E> getEdges();

	/**
	 * Return a <b>structure copy</b> of this graph. <br>
	 * Removing or adding vertices and edges won't alter the original graph,
	 * however, modifying any internal parameter inside the vertices and edges
	 * objects will write-through to the original graph
	 * 
	 */
	public abstract AbstractGraph<V, E> shallowCopy();

	/**
	 * Helper function which can be used for {@code shallowCopy()}
	 * implementations
	 * 
	 * @param copy
	 *            a graph which will receive the values from this object
	 */
	protected void auxShallowCopy(AbstractGraph<V, E> copy) {
		copy.vertices.addAll(this.vertices);
		copy.edges.addAll(this.edges);
		copy.adjacencyList.putAll(this.adjacencyList);
	}

	/**
	 * @return the number of vertices in the graph
	 */
	public Integer getNumVertices() {
		return this.vertices.size();
	}

	/**
	 * @return the number of edges in the graph
	 */
	public Integer getNumEdges() {
		return this.edges.size();
	}

}
