package com.hueho.SGraph.example.fleury;

import java.util.List;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.hueho.SGraph.core.UndirectedGraph;

/**
 * @author Hueho
 * 
 */
public class Fleury {

	/**
	 * @param target
	 */
	public static List<Person> execute(
			UndirectedGraph<Person, Relationship> target) {
		Person p = Fleury.randomPerson(target);
		List<Person> trail = Lists.newLinkedList();
		UndirectedGraph<Person, Relationship> result = target.shallowCopy();

		while (result.degree(p) > 0) {
			UndirectedGraph<Person, Relationship> temp = Fleury
					.bigggestConnectedComponent(result, p);
			Relationship selected = null;
			for (Relationship subject : temp.getAdjacentEdges(p)) {
				temp.removeEdge(subject);
				if (Fleury.isConnected(temp)) {
					if (temp.degree(Fleury.selectNext(p, subject)) > 1) {
						selected = subject;
						break;
					}
				}
				temp.undoRemoveEdge();
			}
			if (selected == null) {
				selected = Fleury.randR(temp, p);
			}

			p = Fleury.selectNext(p, selected);
			trail.add(p);
			result.removeEdge(selected);
		}

		return trail;
	}

	private static boolean isConnected(UndirectedGraph<Person, Relationship> tmp) {
		return Fleury.findConnectedComponents(tmp).keySet().size() == 1;
	}

	private static Person selectNext(Person p, Relationship r) {
		if (p == r.getTarget())
			return r.getSource();
		else
			return r.getTarget();
	}

	private static UndirectedGraph<Person, Relationship> bigggestConnectedComponent(
			UndirectedGraph<Person, Relationship> target, Person p) {
		Multimap<Integer, Person> componentMap = Fleury
				.findConnectedComponents(target);
		if (componentMap.keySet().size() == 1)
			return target;
		else {
			Integer selected = null;
			for (Integer i : componentMap.keySet()) {
				if (componentMap.get(i).contains(p)) {
					selected = i;
					break;
				}
			}
			componentMap.removeAll(selected);
			UndirectedGraph<Person, Relationship> result = target.shallowCopy();
			for (Person dead : componentMap.values()) {
				result.removeVertex(dead);
			}
			return result;
		}

	}

	// TODO: find a non-stupid way to do that
	private static Multimap<Integer, Person> findConnectedComponents(
			UndirectedGraph<Person, Relationship> target) {
		Multimap<Integer, Person> result = LinkedHashMultimap.create();
		Integer count = 0;
		for (Person subject : target.getVertices()) {
			if (!result.containsValue(subject)) {
				result.put(count, subject);
				Fleury.auxiliarFindFunction(target,
						target.getAdjacentVertices(subject), result, count);
			}
			count++;
		}
		return result;
	}

	private static void auxiliarFindFunction(
			UndirectedGraph<Person, Relationship> tmp,
			ImmutableSet<Person> alvo, Multimap<Integer, Person> result,
			Integer count) {
		for (Person pt : alvo) {
			if (!result.containsValue(pt)) {
				result.put(count, pt);
				Fleury.auxiliarFindFunction(tmp, tmp.getAdjacentVertices(pt),
						result, count);
			}
		}
	}

	// Not really random, makes algorithm output easier to check though
	private static Person randomPerson(
			UndirectedGraph<Person, Relationship> alvo) {
		return alvo.getVertices().iterator().next();
	}

	// Same as above
	private static Relationship randR(
			UndirectedGraph<Person, Relationship> alvo, Person p) {
		return alvo.getAdjacentEdges(p).iterator().next();
	}

}
