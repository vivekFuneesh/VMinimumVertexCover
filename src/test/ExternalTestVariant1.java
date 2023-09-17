package test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;

import test.models.TestEdgeNodeFromFileMatrix;
import utility.EdgesMatrixToList;
import vivek.min_vertex_cover.MinVertexCover;

public class ExternalTestVariant1 {

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
	public void testCase0() {
		edges = new int[][] { { 2, 4 }, { 6, 4 }, { 4, 5 }, { 2, 3 }, { 3, 5 }, { 3, 6 }, { 5, 6 }, { 2, 6 },
				{ 2, 5 } };
		assertEquals(3, minVertexCover.findMinimumVertexCover(edges, required, not_required));
		System.out.println("after test 2, required=" + required);
	}

	@Test
	@Order(1)
	public void testCase1() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-1.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(2)
	public void testCase2() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-2-Kuratowski-Bipartite-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(3)
	public void testCase3() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-3-octahedron.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(4)
	public void testCase4() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-4-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(5)
	public void testCase5() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-5-wheel-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(6)
	public void testCase6() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-6-cube.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(7)
	public void testCase7() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-7-peterson-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(8)
	public void testCase8() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-8-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(9)
	public void testCase9() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-9-grotzsch-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(10)
	public void testCase10() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-10-herschel-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(11)
	public void testCase11() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-11-icosahedron-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(12)
	public void testCase12() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-12-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(13)
	public void testCase13() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-13-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(14)
	public void testCase14() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-14-ramsey-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(15)
	public void testCase15() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-15-folkman-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(16)
	public void testCase16() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-16-dodecahedron-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(17)
	public void testCase17() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-17-tutte-coxeter-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(18)
	public void testCase18() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-18-thomassen-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(19)
	public void testCase19() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-19-berge-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(20)
	public void testCase20() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-20-witzel-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

	@Test
	@Order(21)
	public void testCase21() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-21.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("after test 2, required=" + required + " \n" + required.size());
	}

}
