package vivek.min_vertex_cover;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import models.CommonNode;
import models.NodeForVersion3;
import utility.Heap;

public class MinVertexCover3 {

	Map<Integer, NodeForVersion3> createGraph(int[][] edges) {

		Map<Integer, NodeForVersion3> graph = new HashMap<>();
		NodeForVersion3 temp1 = null, temp2 = null;

		for (int i = 0; i < edges.length; i++) {
			// System.out.println(edges[i][0]+" = "+graph.containsKey(edges[i][0])+" &"+
			// edges[i][1]+" = "+
			// graph.containsKey(edges[i][1]));
			temp1 = graph.getOrDefault(edges[i][0], new NodeForVersion3(edges[i][0]));
			temp2 = graph.getOrDefault(edges[i][1], new NodeForVersion3(edges[i][1]));
			// System.out.println("for edge"+ edges[i][0]+" - "+ edges[i][1]);
			// as in one step both edges are being considered, no need to check reverse edge
			// separately
			// for directed graph, reverse edge will be considered irrespective of they
			// actually are or not
			// because any one can come first irrespective of direction
			if (!temp1.connected.contains(temp2)) {

				temp1.degree++;
				temp2.degree++;

				temp1.connected.add(temp2);
				temp2.connected.add(temp1);

				graph.put(edges[i][0], temp1);
				graph.put(edges[i][1], temp2);
			}
		}

		// System.out.println("Adjacency List="+ graph);
		return graph;
	}

	Comparator<CommonNode> comp;

	public int findMinimumVertexCover(int[][] edges, List<Integer> required, List<Integer> not_required) {

		if (edges == null || edges.length == 0)
			return 0;
		if (edges.length == 1)
			return 1;

		Map<Integer, NodeForVersion3> graph = createGraph(edges);

		int res = 0;

		comp = (a, b) -> {
			if (a.degree == 0)
				return -1;
			if (b.degree == 0)
				return 1;

			NodeForVersion3 n1 = (NodeForVersion3) a, n2 = (NodeForVersion3) b;

			int lowChild1 = n1.connected.stream().sorted((x, y) -> x.degree - y.degree).findFirst().get().degree,
					lowChild2 = n2.connected.stream().sorted((x, y) -> x.degree - y.degree).findFirst().get().degree;

//			return lowChild1-lowChild2;

//System.out.println("----");
			n1.comparisonData = n1.connected.stream()
					// .peek(x->{System.out.print(x.getKey()+"-"+x.getValue()+" ");})
					.collect(Collectors.groupingBy(x -> x.degree, Collectors.counting())).entrySet().stream()
					.sorted((x, y) -> x.getKey() - y.getKey())
					.map(entry -> new int[] { entry.getKey(), entry.getValue().intValue() })
					.toArray(size -> new int[size][2]);

			n2.comparisonData = n2.connected.stream()
					.collect(Collectors.groupingBy(x -> x.degree, Collectors.counting())).entrySet().stream()
					.sorted((x, y) -> x.getKey() - y.getKey())
					.map(entry -> new int[] { entry.getKey(), entry.getValue().intValue() })
					.toArray(size -> new int[size][2]);

			if (n1.comparisonData[0][0] != lowChild1 || n2.comparisonData[0][0] != lowChild2) {
				System.out.println("SORTING AMBIGUITY");
				System.exit(1);
			}

			int i = 0, j = 0;

			/**
			 * 1st = few cases to check later: if 'a' = 1*5-2*3-3*5 : 'b' = 1*4-2*3-3*5-4*10
			 * then currently selecting 'a' because 'a' will lead to more number of "lowest"
			 * degree children.
			 * 
			 * 2nd = but 'b' can be selected on the ground that 'b' has more number of total
			 * degrees along with all available "lowest" degree nodes in one or more
			 * quantity.
			 * 
			 * this 2nd decision can be taken as separate variation, named as " var3` " i.e.
			 * var-3-bar , where bar represents alternate optional strategy and minimum
			 * among them can be selected.
			 * 
			 * Then final answer can be Minimum ( var3-solution , var3`-solution )
			 * 
			 * :- Note: this is not taken at every loop rather this is completely a separate
			 * variation/class-algorithm so final answer to be Minimum {
			 * set-calculated-by-var3, set-calculated-by-var3`}
			 * 
			 * my basic assumption, which is also the base of these variations, is that var3
			 * should give minimum instead of var3-bar.
			 */

			// [i][0] is degree, [i][1] is quantity of that degree
			while (i < n1.comparisonData.length && j < n2.comparisonData.length) {
				if (n1.comparisonData[i][0] < n2.comparisonData[j][0]) {
					return -1;
				} else if (n1.comparisonData[i][0] > n2.comparisonData[j][0]) {
					return 1;
				} else {
					if (n1.comparisonData[i][1] > n2.comparisonData[j][1])
						return -1;
					else if (n1.comparisonData[i][1] < n2.comparisonData[i][1])
						return 1;
					else {
					}
				}

				i++;
				j++;
			}

//			if both nodes have same connected ones 
//			then select one having maximum neighbors otherwise select any
//			if((i==j && n1.connected.size()!=n2.connected.size() ) || 
//					(i==n1.comparisonData.length && n1.connected.size() > n2.connected.size() ||
//					(j==n2.comparisonData.length && n1.connected.size() < n2.connected.size()) ) ) {
//				System.out.println("Ambiguity error found in comparison data and connected for "+n1.value +" and "+n2.value);
//				System.out.println("i= "+i+" j= "+j+" \n n1= "+n1+" \n n2= "+n2);
//				System.out.println(n1.comparisonData.length+" "+n2.comparisonData.length);
//
//				for(i=0;i<n1.comparisonData.length; i++) {
//					System.out.print(n1.comparisonData[i][0]+":"+n1.comparisonData[i][1]+"  ");
//				}System.out.println();
//
//				for(i=0;i<n2.comparisonData.length; i++) {
//					System.out.print(n2.comparisonData[i][0]+":"+n2.comparisonData[i][1]+"  ");
//				}System.out.println();
//				
//				System.exit(1);
//			}
//			if(i==n1.comparisonData.length)return 1;	//n2 has more, so should be at top
//			else if(j==n2.comparisonData.length)return -1; //n1 has more, so should be at top
//			
			return -n1.connected.size() + n2.connected.size();

		};

		Heap queue = new Heap(new NodeForVersion3(-1), comp);

		graph.values().stream().forEach(value -> {
			queue.add(value);
		});

		res = processQueue(queue, required, not_required);

		return res;

	}

	// O( (log V) * (V^3) ) in worst case
	private int processQueue(Heap queue, List<Integer> required, List<Integer> not_required) {
		int res = 0;

		while (!queue.isEmpty()) { // V times
			NodeForVersion3 node = (NodeForVersion3) queue.peek();

			if (node.degree == 0) {
				queue.remove(node);
				not_required.add(node.value);
				queue.heapify();
			} else {
//				CommonNode n = queue.peek(), t=null, res1=null;
//				List<CommonNode> list  = new ArrayList<>();
//				while(!queue.isEmpty() && comp.compare(n, queue.peek()) ==0) {
//					t=queue.poll();
//					list.add(t);
//				}
//				boolean found = false;
//				for(int i=0;i<list.size();i++) {
//					
//					found=false;
//					
//					for(int j=0;j<list.size();j++) {
//						if(j==i)continue;
//						if( ((NodeForVersion3)list.get(j)).connected.contains((NodeForVersion3)list.get(i)) ) {
//							found=true;
//						}
//					}
//					if(!found) {
//						res1 = list.get(i);
//						break;
//					}
//					
//				}
//				if(res1!=null)node=(NodeForVersion3)res1;
//				
//				list.stream().forEach(x->{
//					queue.add((NodeForVersion3)x);
//				});
//				
//								
				queue.remove(node); // (V-1) * O(log V) in worst case

				// O(V) in worst case
				Iterator<NodeForVersion3> itr = node.connected.iterator();

				while (itr.hasNext()) { // V * V log V

					NodeForVersion3 cN = itr.next();
					cN.connected.remove(node);

					// instead of directly heapifying, in all previous variations and current one-
					// first remove and then add.
					cN.degree--;
				}

				required.add(node.value);
				res++;

				node.connected.clear();
				node.degree = 0;
				node.comparisonData = null;
				node.connectedMap.clear();

				queue.heapify(); // V times[ V Log V for sorting + V for comparison b/w any 2 nodes ] = (log V) *
									// (V^2)
			}
		}

		return res;
	}

}
