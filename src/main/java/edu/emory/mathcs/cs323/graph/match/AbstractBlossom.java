/**
 * Copyright 2015, Emory University
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.emory.mathcs.cs323.graph.match;

import java.util.List;
import java.util.Set;

import edu.emory.mathcs.cs323.graph.Edge;
import edu.emory.mathcs.cs323.graph.Graph;
import edu.emory.mathcs.cs323.utils.Pair;

/**
 * @author Jinho D. Choi ({@code jinho.choi@emory.edu})
 */
public abstract class AbstractBlossom
{
	public List<Edge> findAugmentingPath(Graph graph, Match match)
	{
		return null;
	}
	
	/** @return the set of all vertices in the graph. */
	abstract Set<Integer> createUnmarkedVertices(Graph graph);
	
	/** @return the set of edges in the graph that are not in the match. */
	abstract Set<Edge> createUnmarkedEdges(Graph graph, Match match);
	
	/** @return the forest of singleton trees containing the free vertices. */
	abstract Forest createForest(Set<Integer> freeVertices);
	
	/** @return the set of vertices in the graph that are not in the match. */
	abstract Set<Integer> getFreeVertices(Graph graph, Match match);
	
	/** @return the edge in the unmarked edge set containing the unmarked vertex if exists; otherwise, null. */
	abstract Edge getUnmarkedEdge(Set<Edge> unmarkedEdges, int unmarkedVertex);
	
	/** @return the pair of contracted graph and match. */
	abstract Pair<Graph,Match> contract(Graph graph, Match match, List<Edge> blossom);
	
	/** @return the lifted path. */
	abstract List<Edge> lift(Graph originalGraph, Graph contractedGraph, List<Edge> blossom, List<Edge> contractedPath);
}
