package test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import vivek.min_vertex_cover.MinVertexCover3;

public class MinVertexCover3Test {

	private MinVertexCover3 minVertexCover = null;
	private int[][] edges = null;
	private List<Integer> required = null, not_required = null;

	@Before
	public void initialize() {

		minVertexCover = new MinVertexCover3();
		required = new ArrayList<>();
		not_required = new ArrayList<>();
	}

	@Test
	@Order(1)
	public void testNullEdges() {
		assertEquals(0, minVertexCover.findMinimumVertexCover(null, new ArrayList<>(), new ArrayList<>()));
	}

	@Test
	@Order(2)
	public void testCase2() {
		edges = new int[][] { { 2, 4 }, { 6, 4 }, { 4, 5 }, { 2, 3 }, { 3, 5 }, { 3, 6 }, { 5, 6 }, { 2, 6 },
				{ 2, 5 } };
		assertEquals(3, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println(" required=" + required);
	}

	@Test
	@Order(3)
	public void testCase3() {
		edges = new int[][] { { 20, 22 }, { 22, 25 }, { 20, 8 }, { 4, 8 }, { 12, 8 }, { 12, 10 }, { 12, 14 } };
		assertEquals(3, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(4)
	public void testCase4() {
		edges = new int[][] { { 2, 4 }, { 6, 4 }, { 4, 5 }, { 2, 3 }, { 3, 5 }, { 3, 6 } };
		assertEquals(2, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(5)
	public void testCase5() {
		edges = new int[][] { { 2, 4 }, { 6, 4 }, { 4, 5 }, { 2, 3 }, { 3, 5 } };
		assertEquals(2, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(6)
	public void testCase6() {
		edges = new int[][] { { 1, 2 }, { 1, 5 }, { 2, 4 }, { 2, 3 }, { 6, 3 }, { 6, 4 }, { 6, 5 }, { 6, 7 }, { 4, 5 },
				{ 4, 7 }, { 5, 7 }, { 7, 8 }, { 7, 9 }, { 7, 10 }, { 8, 10 }, { 8, 9 }, { 9, 10 } };
		assertEquals(6, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(7)
	public void testCase7() {
		edges = new int[][] { { 1, 4 }, { 1, 3 }, { 2, 5 }, { 2, 6 }, { 7, 3 }, { 5, 4 }, { 4, 8 }, { 9, 5 }, { 6, 10 },
				{ 8, 7 }, { 12, 7 }, { 11, 8 }, { 11, 9 }, { 9, 10 }, { 14, 10 }, { 11, 13 }, { 12, 13 }, { 13, 14 },
				{ 12, 15 }, { 14, 16 }, { 15, 16 } };
		assertEquals(9, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(8)
	public void testCase8() {
		edges = new int[][] { { 1, 2 }, { 1, 8 }, { 2, 3 }, { 3, 4 }, { 7, 8 }, { 2, 6 }, { 4, 5 }, { 7, 6 },
				{ 6, 5 } };
		assertEquals(4, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

	@Test
	@Order(9)
	public void testCase9() {
		edges = new int[][] { { 1, 2 }, { 1, 11 }, { 3, 4 }, { 4, 5 }, { 3, 7 }, { 5, 6 }, { 2, 13 }, { 7, 13 },
				{ 13, 12 }, { 6, 7 }, { 6, 8 }, { 11, 12 }, { 12, 8 }, { 11, 10 }, { 8, 9 }, { 9, 10 } };
		assertEquals(7, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("required = "+required);
	}

}
