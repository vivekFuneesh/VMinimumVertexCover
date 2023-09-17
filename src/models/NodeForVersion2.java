
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

package models;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import utility.Heap;

public class NodeForVersion2 extends CommonNode {

	public Heap connected;
	public Set<NodeForVersion2> track;

	public NodeForVersion2(int val) {
		this.value = val;
		connected = new Heap(new NodeForVersion2(-1, 0), true);
		track = new HashSet<>();
	}

	private NodeForVersion2(int val, int deg) {
		this.value = val;
		this.degree = deg;
	}

	public static NodeForVersion2 instantiateWithDegree(int value, int degree) {
		NodeForVersion2 node = new NodeForVersion2(value);
		node.degree = degree;
		return node;
	}

	@Override
	public boolean equals(Object o) {
		// System.out.println("checking for"+ this.value +" == "+
		// ((NodeForVersion2)o).value);
		return this.value == ((NodeForVersion2) o).value;
	}

	@Override
	public String toString() {
		return value + "={" + connected.getInternalHeap().stream().map(x -> x.data.value).collect(Collectors.toList())
				+ "}";
	}

}
