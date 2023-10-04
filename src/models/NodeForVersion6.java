package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class NodeForVersion6 extends CommonNode{
	public Set<NodeForVersion6> connected = new HashSet<>();

	// degree - Number of such connected Nodes
	public Map<Integer, Integer> connectedMap = new HashMap<>();

	/**
	 * Instead of using array, use a string s.t. 111122223333.. and compare them
	 * that will be fast to implement though slow to compare
	 */
	public int[][] comparisonData = null;

	public NodeForVersion6(int v) {
		this.value = v;
	}

	@Override
	public boolean equals(Object o) {
		return this.value == ((NodeForVersion3) o).value;
	}

	@Override
	public String toString() {
		return this.value + "=" + connected.stream().map(x -> x.value + "." + x.degree).collect(Collectors.toList());
	}

}
