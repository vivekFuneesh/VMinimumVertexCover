
/**
 *	VMinimumVertexCover : Finds a minimum vertex cover for a given graph with exact algorithm in minimal time complexity.
 *	Copyright (C) 2023  Vivek Mangla
 *
 *	This program is free software: you can redistribute it and/or modify
 *	it under the terms of the GNU General Public License as published by
 *	the Free Software Foundation, either version 3 of the License, or
 *	(at your option) any later version.
 *
 *	This program is distributed in the hope that it will be useful,
 *	but WITHOUT ANY WARRANTY; without even the implied warranty of
 *	MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *	GNU General Public License for more details.
 *
 *	You should have received a copy of the GNU General Public License
 *	along with this program.  If not, see <https://www.gnu.org/licenses/>.
 *
 *	Contact me at vivek.funeesh@gmail.com for queries.
 * 
 * */

package vivek.min_vertex_cover;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import models.NodeForVersion1;
import utility.Heap;

public class MinVertexCover {

	//-- directed or undirected edges - same algo. for both 
	//-- edge to same will be discarded
	//-- for directed, direction doesn't matter for minimum "vertex" coverage.

	public int findMinimumVertexCover(int[][] edges, List<Integer> required, List<Integer> not_required) {
		if(edges==null || edges.length==0)return 0;
		if(edges.length==1)return 1;

		Map<Integer, NodeForVersion1> graph = createGraph(edges);
		
		int res=0;
		
		Heap queue = new Heap(new NodeForVersion1(-1));
		graph.values().stream().forEach(value->{queue.add(value);});
		
		res = processQueue(queue, required, not_required);		
	
		//no benefit for klaus witzel graph
		//List<Integer> newRequired = tryMinify(required, edges);
//		System.out.println("HI"+newRequired.size());

		return res;
	}
	
	
	List<Integer> tryMinify(List<Integer> required, int[][] edges) {
		
		Set<Integer> set = new HashSet<Integer>(required);

		return required.stream()
		.filter(vertex->isMandate(vertex.intValue(), edges, set))
		.collect(Collectors.toList());
	}
	
	boolean isMandate(int vertex, int[][] edges, Set<Integer> set) {
		
		set.remove(vertex);
		
		for(int i=0;i<edges.length;i++) {
			if(! (set.contains(edges[i][0]) || set.contains(edges[i][1])) ) {
				set.add(vertex);
				return true;
			}
		}
		
		return false;
	}

	Map<Integer, NodeForVersion1> createGraph(int[][] edges) {
		
		Map<Integer, NodeForVersion1> graph = new HashMap<>();
		NodeForVersion1 temp1 = null, temp2 = null;

		for(int i=0; i<edges.length; i++) {
			//		System.out.println(edges[i][0]+" = "+graph.containsKey(edges[i][0])+" &"+ edges[i][1]+" = "+
			//	graph.containsKey(edges[i][1]));
			temp1 = graph.getOrDefault(edges[i][0], new NodeForVersion1(edges[i][0]));
			temp2 = graph.getOrDefault(edges[i][1], new NodeForVersion1(edges[i][1]));
			//System.out.println("for edge"+ edges[i][0]+" - "+ edges[i][1]);
			//as in one step both edges are being considered, no need to check reverse edge separately
			//for directed graph, reverse edge will be considered irrespective of they actually are or not
			//because any one can come first irrespective of direction
			if(!temp1.connected.contains(temp2)) {

				temp1.connected.add(temp2);
				temp2.connected.add(temp1);

				temp1.degree++;
				temp2.degree++;

				graph.put(edges[i][0], temp1);
				graph.put(edges[i][1], temp2);
			}
		}
		//System.out.println("Adjacency List="+ graph);
		return graph;
	}
	
	
	
	/**
	 * worst case time is Sum(x log x), for x = [V, 1]; 
	 * 			= O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
	 * 			= O ( (V^2) * (log V) ) 
	 * Best Case = O (V log V)
	 * */
	
	
	int processQueue(Heap queue, List<Integer> required, List<Integer> not_required) {
		NodeForVersion1 node = null, connectedNode = null;
		int result = 0, operations=0;
		
//		System.out.println("--NEW GRAPH--"+queue+"---\n");
//		System.out.println("heap internal tracker = "+ queue.trackIndex);
		
		while(!queue.isEmpty()) {
			node = (NodeForVersion1)queue.peek();
//			System.out.println("Lowest degree node="+ node.value);
			if(node.degree==0) {
				not_required.add(node.value);
				queue.remove(node);
			} else {
				
				//take any parent of this node
				node = node.connected.iterator().next();
				//}
				//if node.degree!=1 that means there is a cycle, in that case parent will yield a leaf node or 
				//will render the graph state to make node in above step a leaf node.
				
//				System.out.println("Parent selected node="+ node.value);
				
				Iterator<NodeForVersion1> itr = node.connected.iterator();
				queue.remove(node);		//log(Vi), for ith loop
				//no.-of-neighbours, V-1 in worst-case-when-all-nodes-are-connected, 
				//where V keeps on decrementing by 1 in every outer loop
				while(itr.hasNext()) {	
					operations++;
					connectedNode = itr.next();
					connectedNode.degree--;

					connectedNode.connected.remove(node);
					queue.heapifyUp(connectedNode);	//log(Vi) in worst case, Vi is remaining nodes for ith outer loop
				}

				result++;
				required.add(node.value);
				node.degree=0;
				node.connected.clear(); //no need to keep this 
				
			}
		}
		System.out.println("required="+required+"\noperations="+operations);
		return result;
	}

}

