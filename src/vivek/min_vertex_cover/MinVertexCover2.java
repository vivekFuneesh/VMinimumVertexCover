
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import models.HeapNode;
import models.NodeForVersion2;
import utility.Heap;

public class MinVertexCover2 {

	//-- directed or undirected edges - same algo. for both 
	//-- edge to same will be discarded
	//-- for directed, direction doesn't matter for minimum "vertex" coverage.

	public int findMinimumVertexCover(int[][] edges, List<Integer> required, List<Integer> not_required) {
		if(edges==null || edges.length==0)return 0;
		if(edges.length==1)return 1;

		int res=0;
		Map<Integer, NodeForVersion2> graph = new HashMap<>();
		NodeForVersion2 temp1 = null, temp2 = null;

		for(int i=0; i<edges.length; i++) {
			//		System.out.println(edges[i][0]+" = "+graph.containsKey(edges[i][0])+" &"+ edges[i][1]+" = "+
			//	graph.containsKey(edges[i][1]));
			temp1 = graph.getOrDefault(edges[i][0], new NodeForVersion2(edges[i][0]));
			temp2 = graph.getOrDefault(edges[i][1], new NodeForVersion2(edges[i][1]));
			//System.out.println("for edge"+ edges[i][0]+" - "+ edges[i][1]);
			//as in one step both edges are being considered, no need to check reverse edge separately
			//for directed graph, reverse edge will be considered irrespective of they actually are or not
			//because any one can come first irrespective of direction
			if(!temp1.track.contains(temp2)) {

				temp1.connected.add(temp2);
				temp2.connected.add(temp1);
				
				//can also use stream grouping function at start for edges[][], to remove this track overhead
				temp1.track.add(temp2); //this only required to remove duplicacy
				temp2.track.add(temp1); 

				temp1.degree++;
				temp2.degree++;

				graph.put(edges[i][0], temp1);
				graph.put(edges[i][1], temp2);
			}
		}
	//	System.out.println("Adjacency List="+ graph);
		Heap queue = new Heap(new NodeForVersion2(-1));
		graph.values().stream().forEach(value->{value.track.clear(); queue.add(value);});
		
		res = processQueue(queue, required, not_required);
		
		return res;
	}
	
	/**
	 * worst case time is V * Sum(x log x + x log x), for x = [V, 1]; 
	 * 			= V * O (1/2 * V^2 log V - 1/4 * V^2 + V ) = O ((V^2)*(log V))
	 * 			= V * O ( (V^2) * (log V) )
	 *  		= O(V^3 log V) in worst case
	 * Best Case = O (V^2 log V)
	 * */
	

	int processQueue(Heap queue, List<Integer> required, List<Integer> not_required) {
		NodeForVersion2 node = null, connectedNode = null;
		int result = 0, operations=0;
//		System.out.println("--NEW GRAPH--"+queue+"---\n");
//		System.out.println("heap internal tracker = "+ queue.trackIndex);
		
		
		while(!queue.isEmpty()) {
			node = (NodeForVersion2)queue.peek();
//			System.out.println("Lowest degree node="+ node.value);
			if(node.degree==0) {
				not_required.add(node.value);
				queue.remove(node);
			} else {
		//for a given lowest degree, find that parent (P) from all candidates having same degree, 
		//s.t. removal of that P will leave state to a minimal-edges-graph 
		//i.e find parent P with maximum degree, to remove		
				
//				System.out.println("before findNodeToPeek, queue = "+queue);
				node = findNodeToPeek(queue);
//				System.out.println("After findNodeToPeek, queue = "+queue);
				
				//if (node.degree == 1) {
				//take the parent of this node
				node = (NodeForVersion2) node.connected.peek(); //peeking only, will be polled in next loop
				//}
				//if node.degree!=1 that means there is a cycle, in that case parent will yield a leaf node or 
				//will render the graph state to yield a leaf node faster.
				
				//System.out.println("Parent selected node="+ node.value);
				Iterator<HeapNode> itr = node.connected.iterator();
//				System.out.println(itr.hasNext()); 
				
				//no.-of-neighbours, V-1 in worst-case-when-all-nodes-are-connected, 
				//where V keeps on decrementing by 1 in every outer loop
				queue.remove(node);
				while(itr.hasNext()) {
					
					connectedNode = (NodeForVersion2) itr.next().data;
//					System.out.println("processing "+ connectedNode.value);
					operations++;
					
					/**
					 * below step will make connected heap as non-max-heap of all 
					 * those nodes which have connectedNode as member
					 * in upcoming iterations, heapify() call will handle that inside findNodeToPeek()
					 * */
					connectedNode.degree--;
					
					
					//System.out.println("--removing "+node.value+" from "+connectedNode.value);
					connectedNode.connected.remove(node);  //log(Vi) in worst case, Vi is remaining nodes for ith outer loop
					queue.heapifyUp(connectedNode);  //log(Vi) in worst case, Vi is remaining nodes for ith outer loop
				}

				result++;
				required.add(node.value);
				node.degree=0;
				
				node.connected.clear();	//empty all connectedNode from this parent's neighbour-list
				
				//System.out.println("polled: "+ node.value+" with deg="+node.degree+" queue="+queue);
				//queue.remove(node);
			}
		}
		System.out.println("required="+required+"\noperations="+operations);
		return result;
	}
	
	//V * Sum( log Vij ), where Vi is the no. of Vertices at ith iteration of above outer loop and at jth iteration of
	//below main loop and j = [1, Ci], where 
	//Ci is the number of candidate nodes for a particular lowest degree at ith iteration of above outer loop
	
	//== V * O( (Ci) (Log Vi) ) in worst case. Ci can be Vi in worst case
	
	NodeForVersion2 findNodeToPeek(Heap queue) {	 //number of neighbours 
		NodeForVersion2 node = (NodeForVersion2) queue.poll();
		
		List<NodeForVersion2> list = new ArrayList<NodeForVersion2>();
		
		node.connected.heapify();//added overhead of O(V~j), where V~ is the no. of connected nodes of jth node
		checkForOtherMax(node); //though not required but still doing
		
		list.add(node);
		//System.out.print("candidate nodes= "+node.value+" ");
		
		NodeForVersion2 tmp = node, p1=null, tmp2=node;
		while(!queue.isEmpty() && node.degree == queue.peek().degree) {
			p1 = (NodeForVersion2)queue.poll();	//log (no. of remaining Vertices in main queue) 
			
			p1.connected.heapify();//commenting this giving 423 instead of 424 for external test-case-20
			checkForOtherMax(p1);
			
			list.add(p1);
			//System.out.print(p1.value+" ");
			//select candidate among lowest degree candidates whose parent/connected-one is having maximum degree
			tmp = tmp.connected.peek().degree > p1.connected.peek().degree ? tmp : p1; 
		}
		
//		if(tmp.connected.peek().degree < tmp2.connected.peek().degree) {
//			System.out.println("\n\n--selecting lesser degree--"+tmp.connected.peek()+" \nas compared to "+tmp2.connected.peek());
//		}
		
		
		list.stream().forEach(n-> queue.add(n));
		//System.out.println("\nselected node = "+tmp.value+" with deg = "+tmp.degree);
		return tmp;
	}
	
	void checkForOtherMax(NodeForVersion2 node) {
		Iterator<HeapNode> itr = node.connected.iterator();
		int deg = node.connected.peek().degree, deg1=0;
		while(itr.hasNext()) {
			NodeForVersion2 n = (NodeForVersion2 )itr.next().data;
			if(deg < n.degree)
			{
				System.out.println("\n\n----\n Found ambiguity in internal connected maxHeap for node=["+node.value+","+node.degree+"] "
			
					+ "with =["+
			n.value+", "+n.degree+"]\n  as "+ node+"and node.connected.peek()="+node.connected.peek()+"-----\n\n");
			break;	
			}
		}
	}

}
