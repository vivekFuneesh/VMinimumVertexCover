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
		System.out.println(" required=" + required);
	}

	@Test
	@Order(1)
	public void testCase1() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-1.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(2)
	public void testCase2() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-2-Kuratowski-Bipartite-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(3)
	public void testCase3() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-3-octahedron.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(4)
	public void testCase4() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-4-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(5)
	public void testCase5() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-5-wheel-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(6)
	public void testCase6() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-6-cube.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(7)
	public void testCase7() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-7-peterson-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(8)
	public void testCase8() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-8-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(9)
	public void testCase9() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-9-grotzsch-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(10)
	public void testCase10() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-10-herschel-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(11)
	public void testCase11() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-11-icosahedron-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(12)
	public void testCase12() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-12-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(13)
	public void testCase13() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-13-bondy-murty-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(14)
	public void testCase14() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-14-ramsey-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(15)
	public void testCase15() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-15-folkman-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(16)
	public void testCase16() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-16-dodecahedron-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(17)
	public void testCase17() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-17-tutte-coxeter-graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(18)
	public void testCase18() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-18-thomassen-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(19)
	public void testCase19() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-19-berge-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(20)
	public void testCase20() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromFile("test-cases\\test-case-20-witzel-Graph.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	@Test
	@Order(21)
	public void testCase21() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList.readEdgesFromFile("test-cases\\test-case-21.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println(" required=" + required + " \n" + required.size());
	}

	// below giving 240, required ?
	@Test
	@Order(22)
	public void testCase22() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-22-dsjc250.5.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 425, required 420
	@Test
	@Order(23)
	public void testCase23() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-23-frb30-15-2.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 425, required 420
	@Test
	@Order(24)
	public void testCase24() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-24-frb30-15-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 426, required 420
	@Test
	@Order(25)
	public void testCase25() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-25-frb30-15-3.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 425, required 420
	@Test
	@Order(26)
	public void testCase26() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-26-frb30-15-5.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1485, required 1475
	@Test
	@Order(27)
	public void testCase27() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-27-frb59-26-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1487, required 1475
	@Test
	@Order(28)
	public void testCase28() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-28-frb59-26-2.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1487, required 1475
	@Test
	@Order(29)
	public void testCase29() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-29-frb59-26-3.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 910, required 900
	@Test
	@Order(30)
	public void testCase30() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-30-frb45-21-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 908, required 900
	@Test
	@Order(31)
	public void testCase31() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-31-frb45-21-2.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 909, required 900
	@Test
	@Order(32)
	public void testCase32() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-32-frb45-21-3.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 909, required 900
	@Test
	@Order(33)
	public void testCase33() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-33-frb45-21-4.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1109, required 1100
	@Test
	@Order(34)
	public void testCase34() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-34-frb50-23-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1107, required 1100
	@Test
	@Order(35)
	public void testCase35() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-35-frb50-23-2.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1108, required 1100
	@Test
	@Order(36)
	public void testCase36() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-36-frb50-23-3.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1107, required 1100
	@Test
	@Order(37)
	public void testCase37() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-37-frb50-23-4.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1108, required 1100
	@Test
	@Order(38)
	public void testCase38() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-38-frb50-23-5.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1229, required 1219
	@Test
	@Order(39)
	public void testCase39() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-39-frb53-24-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1228, required 1219
	@Test
	@Order(40)
	public void testCase40() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-40-frb53-24-2.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1354, required 1344
	@Test
	@Order(41)
	public void testCase41() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-41-frb56-25-1.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	// below giving 1356, required 1344
	@Test
	@Order(42)
	public void testCase42() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\test-case-42-frb56-25-2.cnf");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	@Test
	@Order(43)
	public void testCase43() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\mat-tepper-test-cases\\brock200_2.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	@Test
	@Order(44)
	public void testCase44() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\mat-tepper-test-cases\\brock800_2.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}

	@Test
	@Order(45)
	public void testCase45() throws IOException {

		TestEdgeNodeFromFileMatrix node = EdgesMatrixToList
				.readEdgesFromListFile("test-cases\\mat-tepper-test-cases\\johnson8-2-4.txt");

		assertEquals(node.getMinimumCoverSize(),
				minVertexCover.findMinimumVertexCover(node.getEdges(), required, not_required));
		System.out.println("not confirmed-- , required=" + required + " \n" + required.size());
	}
}
