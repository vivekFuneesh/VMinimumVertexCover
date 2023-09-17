package test.models;

public class TestEdgeNodeFromFileMatrix {

	private int[][] edges;
	private int noOfVertex;
	private int minimumCoverSize;

	public TestEdgeNodeFromFileMatrix(int[][] edges, int noOfVertex, int minimumCoverSize) {
		super();
		this.edges = edges;
		this.noOfVertex = noOfVertex;
		this.minimumCoverSize = minimumCoverSize;
	}

	public int[][] getEdges() {
		return edges;
	}

	public int getNoOfVertex() {
		return noOfVertex;
	}

	public int getMinimumCoverSize() {
		return minimumCoverSize;
	}

}
