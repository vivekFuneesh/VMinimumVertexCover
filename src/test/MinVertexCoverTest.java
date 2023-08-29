
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

package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import vivek.min_vertex_cover.MinVertexCover;


public class MinVertexCoverTest {

	private MinVertexCover minVertexCover = null;
	private int[][] edges = null;
	private List<Integer> required = null, not_required = null;
	
	@Before
	public void initialize() {
		
		minVertexCover = new MinVertexCover();
		required = new ArrayList<>();
		not_required = new ArrayList<>();
	}
	
	@Test
	@Order(1)
	public void testNullEdges() {
//		PriorityQueue<Node> connected = new PriorityQueue<>((a,b)->a.value-b.value);
//		connected.add(new Node(2));
//		connected.add(new Node(3));
//		connected.add(new Node(3));
//		connected.add(new Node(2));
//		connected.add(new Node(2));
//		connected.add(new Node(11));
//		connected.add(new Node(10));
//		connected.add(new Node(2));
//		connected.add(new Node(5));
//		System.out.println(connected);
//		
//		Heap heap = new Heap(new NodeWithConnectedInHeap(-1));
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(2,2));System.out.println(heap);
//		
//		NodeWithConnectedInHeap n =NodeWithConnectedInHeap.instantiateWithDegree(3,3);
//		heap.add(n);System.out.println(heap);
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(3,3));System.out.println(heap);
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(2,2));System.out.println(heap);
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(2,2));
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(11,11));
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(10,10));
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(2,2));
//		heap.add(NodeWithConnectedInHeap.instantiateWithDegree(5,5));
//		System.out.println("-->> "+heap);
//		
//		heap.remove(n);
//		System.out.println("-->> "+heap);
//		
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//		pq.add(10);pq.add(2);pq.add(5);pq.add(6);pq.add(4);
//		System.out.println(pq);
		assertEquals(0, minVertexCover.findMinimumVertexCover(null, new ArrayList<>(), new ArrayList<>()));
	}

	@Test
	@Order(2)
	public void testCase2() {
		edges = new int[][] {
			{2,4},
			{6, 4},
			{4,5},
			{2,3},
			{3, 5},
			{3,6},
			{5,6},
			{2,6},
			{2,5}
		};
		assertEquals(3, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("after test 2, required="+required);
	}
	
	@Test
	@Order(3)
	public void testCase3() {
		edges = new int[][] {
			{20,22},
			{22, 25},
			{20,8},
			{4,8},
			{12, 8},
			{12,10},
			{12,14}
		};
		assertEquals(3, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println(required);
	}
	
	@Test
	@Order(4)
	public void testCase4() {
		edges = new int[][] {
			{2,4},
			{6, 4},
			{4,5},
			{2,3},
			{3, 5},
			{3,6}
		};
		assertEquals(2, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println(required);
	}
	
	@Test
	@Order(5)
	public void testCase5() {
		edges = new int[][] {
			{2,4},
			{6, 4},
			{4,5},
			{2,3},
			{3, 5}
		};
		assertEquals(2, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println(required);
	}

	@Test
	@Order(6)
	public void testCase6() {
		edges = new int[][] {
			{1,2},{1,5},
			{2,4},{2,3},
			{6, 3},
			{6,4},{6,5},{6,7},
			{4,5},{4,7},
			{5,7},
			{7,8},{7,9},{7,10},
			{8,10},{8,9},
			{9,10}
		};
		assertEquals(6, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println(required);
	}
}