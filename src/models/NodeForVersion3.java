package models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import utility.Heap;

public class NodeForVersion3 extends CommonNode {

	public Set<NodeForVersion3> track = null;

	// degree - Number of such connected Nodes
	// for further optimization use LinkedHashMap<Int, new Node{ Set<Node3>, int degree, int count}> for 
	// maintaining connected data instead of heap, comparisonData
//	public Map<Integer, Integer> connectedMap = new HashMap<>();

	public Heap connected = null;

	/**
	 * Instead of using array, use a string s.t. 111122223333.. and compare them
	 * that will be fast to implement though slow to compare
	 */
	public int[][] comparisonData = null;

	public NodeForVersion3(int v) {
		this.value = v;
		this.degree = 0;
		this.track = new HashSet<>();
		this.connected = new Heap(new NodeForVersion3(-1,0));		
	}
	
	public NodeForVersion3(int v, int d) {
		this.value=v;
		this.degree=d;
	}

	@Override
	public boolean equals(Object o) {
		return this.value == ((NodeForVersion3) o).value;
	}

	@Override
	public String toString() {
		return this.value + "=" + connected.getInternalHeap().stream().map(x -> x.data.value + "." + x.data.degree)
				.collect(Collectors.toList());
	}

}
