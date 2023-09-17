package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import test.models.TestEdgeNodeFromFileMatrix;

public class EdgesMatrixToList {

	public static void main(String[] arg) throws IOException {
		readEdgesFromFile("test-cases\\test-case-20-witzel-Graph.txt");
	}

	public static TestEdgeNodeFromFileMatrix readEdgesFromFile(String fileName) throws IOException {
		File file = new File(fileName);

		BufferedReader reader = new BufferedReader(new FileReader(file));

		int noOfVertex = Integer.valueOf(reader.readLine().trim()), i = 0, count = 0;
		String line = "";
		Integer[] temp = new Integer[noOfVertex];

		List<Integer[]> list = new ArrayList<>();

		while (reader.ready() && i < noOfVertex) {

			temp = Arrays.stream(reader.readLine().trim().split(" ")).map(str -> str.trim())
					.filter(str -> str.length() != 0).map(str -> Integer.valueOf(str)).toArray(Integer[]::new);

			for (int j = 0; j < temp.length; j++) {
				if (i == j || temp[j] == 0) {
					continue;
				}
				list.add(new Integer[] { i, j });
			}

			i++;

		}

		int[][] edges = list.stream().map(arr -> Stream.of(arr).mapToInt(x -> x).toArray())
				.toArray(size -> new int[size][2]);

		// for(i=0;i<edges.length;i++) {System.out.println(edges[i][0]+" ->
		// "+edges[i][1]);}
		int vertexCoverSize = Integer.valueOf(reader.readLine().trim());
		// System.out.println(vertexCoverSize + " "+edges.length);
		reader.close();

		TestEdgeNodeFromFileMatrix node = new TestEdgeNodeFromFileMatrix(edges, noOfVertex, vertexCoverSize);

		return node;
	}

}
