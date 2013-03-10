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
	 * @param alvo
	 */
	public static List<Pessoa> execute(
			UndirectedGraph<Pessoa, Relacionamento> alvo) {
		Pessoa p = Fleury.randP(alvo);
		List<Pessoa> trilha = Lists.newLinkedList();
		UndirectedGraph<Pessoa, Relacionamento> result = alvo.shallowCopy();

		while (result.degree(p) > 0) {
			UndirectedGraph<Pessoa, Relacionamento> tmp = Fleury
					.maiorComponenteConexo(result, p);
			Relacionamento r = null;
			for (Relacionamento rt : tmp.getAdjacentEdges(p)) {
				tmp.removeEdge(rt);
				if (Fleury.conexo(tmp)) {
					if (tmp.degree(selectNext(p, rt)) > 1) {
						r = rt;
						break;
					}
				}
				tmp.undoRemoveEdge();
			}
			if (r == null) {
				r = Fleury.randR(tmp, p);
			}
			
			p = selectNext(p, r);
			trilha.add(p);
			result.removeEdge(r);
		}

		return trilha;
	}

	private static boolean conexo(UndirectedGraph<Pessoa, Relacionamento> tmp) {
		return Fleury.encontrarConexos(tmp).keySet().size() == 1;
	}

	private static Pessoa selectNext(Pessoa p, Relacionamento r) {
		if (p == r.getTarget()) {
			return r.getSource();
		} else {
			return r.getTarget();
		}
	}

	private static UndirectedGraph<Pessoa, Relacionamento> maiorComponenteConexo(
			UndirectedGraph<Pessoa, Relacionamento> alvo, Pessoa p) {
		Multimap<Integer, Pessoa> comp = Fleury.encontrarConexos(alvo);
		if (comp.keySet().size() == 1)
			return alvo;
		else {
			Integer selected = null;
			for (Integer i : comp.keySet()) {
				if (comp.get(i).contains(p)) {
					selected = i;
					break;
				}
			}
			comp.removeAll(selected);
			UndirectedGraph<Pessoa, Relacionamento> result = alvo.shallowCopy();
			for (Pessoa dead : comp.values()) {
				result.removeVertex(dead);
			}
			return result;
		}

	}

	private static Multimap<Integer, Pessoa> encontrarConexos(
			UndirectedGraph<Pessoa, Relacionamento> tmp) {
		Multimap<Integer, Pessoa> result = LinkedHashMultimap.create();
		Integer count = 0;
		for (Pessoa pt : tmp.getVertices()) {
			if (!result.containsValue(pt)) {
				result.put(count, pt);
				Fleury.auxEncontrarConexos(tmp, tmp.getAdjacentVertices(pt),
						result, count);
			}
			count++;
		}
		return result;
	}

	private static void auxEncontrarConexos(
			UndirectedGraph<Pessoa, Relacionamento> tmp,
			ImmutableSet<Pessoa> alvo, Multimap<Integer, Pessoa> result,
			Integer count) {
		for (Pessoa pt : alvo) {
			if (!result.containsValue(pt)) {
				result.put(count, pt);
				Fleury.auxEncontrarConexos(tmp, tmp.getAdjacentVertices(pt),
						result, count);
			}
		}
	}

	private static Pessoa randP(UndirectedGraph<Pessoa, Relacionamento> alvo) {
		return alvo.getVertices().iterator().next();
	}

	private static Relacionamento randR(
			UndirectedGraph<Pessoa, Relacionamento> alvo, Pessoa p) {
		return alvo.getAdjacentEdges(p).iterator().next();
	}

}
