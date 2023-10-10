package vivek.min_vertex_cover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import models.CommonNode;
import models.HeapNode;
import models.NodeForVersion3;
import utility.Heap;

public class MinVertexCover3 {

	Map<Integer, NodeForVersion3> createGraph(int[][] edges) {

		Map<Integer, NodeForVersion3> graph = new HashMap<>();
		NodeForVersion3 temp1 = null, temp2 = null;

		for (int i = 0; i < edges.length; i++) {

			temp1 = graph.getOrDefault(edges[i][0], new NodeForVersion3(edges[i][0]));
			temp2 = graph.getOrDefault(edges[i][1], new NodeForVersion3(edges[i][1]));

			if (!temp1.track.contains(temp2)) {

				temp1.degree++;
				temp2.degree++;

				temp1.connected.addWithoutHeapify(temp2);
				temp2.connected.addWithoutHeapify(temp1);

				temp1.track.add(temp2);
				temp2.track.add(temp1);

				graph.put(edges[i][0], temp1);
				graph.put(edges[i][1], temp2);
			}
		}

		// System.out.println("Adjacency List="+ graph);
		return graph;
	}

	public int findMinimumVertexCover(int[][] edges, List<Integer> required, List<Integer> not_required) {

		if (edges == null || edges.length == 0)
			return 0;
		if (edges.length == 1)
			return 1;

		Map<Integer, NodeForVersion3> graph = createGraph(edges);

		int res = 0;

		// sorting main queue on the basis of connected lowest degree child/neighbour
		Comparator<CommonNode> comp = (a, b) -> {

			return a.degree - b.degree;
		};

		Heap queue = new Heap(new NodeForVersion3(-1), comp);

		graph.values().stream().forEach(value -> {
			queue.add(value);
			value.track.clear();
		});

		res = processQueue(queue, required, not_required);
//		System.out.println(required);
		return res;

	}

	// O( (log V) * (V^3) ) in worst case
	private int processQueue(Heap queue, List<Integer> required, List<Integer> not_required) {
		int res = 0;
		// System.out.println("received graph = "+queue);
		while (!queue.isEmpty()) { // V times
			NodeForVersion3 node = (NodeForVersion3) queue.peek();

			if (node.degree == 0) {
				queue.remove(node);
				not_required.add(node.value);

			} else {

				// find the minimum-degree-max-quantity-neighboured-parent among these lowest
				// degree nodes
				node = findNodeToPeek(queue);

				queue.remove(node); // O(log V) in worst case

				// O(V) in worst case
				Iterator<HeapNode> itr = node.connected.iterator();

				while (itr.hasNext()) { // V * log V

					NodeForVersion3 cN = (NodeForVersion3) itr.next().data;
					cN.connected.removeWithoutHeapify(node);

					// instead of directly heapifying, in all previous variations and current one-
					// first remove and then add.
					cN.degree--;

					queue.heapifyUp(cN);
				}

				required.add(node.value);
				res++;

				node.connected.clear();
				node.degree = 0;
				node.comparisonData = null;
//				node.connectedMap.clear();

			}
		}

		return res;
	}

	// O( V^2 * log V )
	/**
	 * @param queue
	 * @return
	 */
	private NodeForVersion3 findNodeToPeek(Heap queue) {

		NodeForVersion3 res = (NodeForVersion3) queue.poll(), temp = null, result = null;

		List<NodeForVersion3> list = new ArrayList<>();

		list.add(res);

		result = (NodeForVersion3) res.connected.peek();

		while (!queue.isEmpty() && res.degree == queue.peek().degree) {
			temp = (NodeForVersion3) queue.poll();
			list.add(temp);
		}

		Set<NodeForVersion3> candidateParents = new HashSet<>();

		candidateParents.addAll(
				list.stream().flatMap(x -> x.connected.getInternalHeap().stream().filter(y -> y.data.value != -1))
						.map(x -> (NodeForVersion3) x.data).collect(Collectors.toList()));
		candidateParents.stream().forEach(x -> {
			x.comparisonData = null;
		});

		List<NodeForVersion3> sortedParents = candidateParents.stream().sorted((n1, n2) -> {
			if (n1.comparisonData == null) {
				n1.comparisonData = getComparisonData(n1);
			}

			if (n2.comparisonData == null) {
				n2.comparisonData = getComparisonData(n2);
			}
			return compareComparisonData(n1, n2);

		}).collect(Collectors.toList());

		list.stream().forEach(x -> queue.add(x));
		/***
		 * List<NodeForVersion3> finalCandidates = new ArrayList<>();
		 * 
		 * if(sortedParents.size() > 1) { finalCandidates = sortedParents.stream()
		 * .filter(n1->{ NodeForVersion3 n2 = sortedParents.get(0);
		 * 
		 * return compareComparisonData(n1, n2) == 0 ? true : false;
		 * 
		 * }).collect(Collectors.toList());
		 * 
		 * if(finalCandidates.size()>1) { System.out.println("\n finalCandidates
		 * (value.degree) , sortedParents.size() = "+sortedParents.size()+" " + "\n
		 * queue.size = "+queue.getSize());
		 * 
		 * System.out.println("\n\n"+queue+"\n\n");
		 * queue.getInternalHeap().stream().filter(x->x.data.value!=-1) .forEach(x->{
		 * System.out.print(x.data.value+"."+x.data.degree+" = ");
		 * ((NodeForVersion3)x.data).connected.getInternalHeap().stream() .forEach(y->{
		 * System.out.print(y.data.value+"."+y.data.degree+", "); });
		 * System.out.println(); });
		 * 
		 * finalCandidates.stream().map(x->x.value+"."+x.degree+",
		 * ").forEach(System.out::print); System.out.println("\n result = "+
		 * sortedParents.get(0).value+"."+sortedParents.get(0).degree); } }
		 **/

		result = sortedParents.get(0);

		return result;
	}

	int compareComparisonData(NodeForVersion3 n1, NodeForVersion3 n2) {
		int i = 0, j = 0;

		// [i][0] is degree, [i][1] is quantity of that degree
		while (i < n1.comparisonData.length && j < n2.comparisonData.length) {
			if (n1.comparisonData[i][0] < n2.comparisonData[j][0]) {
				return -1;
			} else if (n1.comparisonData[i][0] > n2.comparisonData[j][0]) {
				return 1;
			} else {
				if (n1.comparisonData[i][1] > n2.comparisonData[j][1])
					return -1;
				else if (n1.comparisonData[i][1] < n2.comparisonData[j][1])
					return 1;
				else {
				}
			}

			i++;
			j++;
		}

		return -n1.connected.getSize() + n2.connected.getSize();

	}

	int[][] getComparisonData(NodeForVersion3 n1) {
		return n1.comparisonData = n1.connected.getInternalHeap().stream().map(x -> x.data).filter(x -> x.value != -1)
				.collect(Collectors.groupingBy(x -> x.degree, Collectors.counting())).entrySet().stream()
				.sorted((x, y) -> x.getKey() - y.getKey())
				.map(entry -> new int[] { entry.getKey(), entry.getValue().intValue() })
				.toArray(size -> new int[size][2]);
	}

}
