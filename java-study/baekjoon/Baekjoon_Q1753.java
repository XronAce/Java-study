package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_Q1753 {
	public static class Edge {
		public int dest;
		public int weight;

		public Edge() {
			super();
		}

		public Edge(int dest, int weight) {
			super();
			this.dest = dest;
			this.weight = weight;
		}

		public int getDest() {
			return dest;
		}

		public void setDest(int dest) {
			this.dest = dest;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

	}

	public static ArrayList<ArrayList<Edge>> adjlist = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		for (int i = 0; i < V + 1; i++) {
			adjlist.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjlist.get(s).add(new Edge(d, w));
		}

		boolean[] isVisited = new boolean[V + 1];
		int[] distance = new int[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		distance[start] = 0;

		for (int i = 0; i < V; i++) {
			int nodeValue = Integer.MAX_VALUE;
			int nodeIdx = 0;

			for (int j = 1; j < V + 1; j++) {
				if (!isVisited[j] && distance[j] < nodeValue) {
					nodeValue = distance[j];
					nodeIdx = j;
				}
			}

			isVisited[nodeIdx] = true;

			for (int j = 0; j < adjlist.get(nodeIdx).size(); j++) {
				Edge adjEdge = adjlist.get(nodeIdx).get(j);

				if (distance[adjEdge.dest] > distance[nodeIdx] + adjEdge.weight) {
					distance[adjEdge.dest] = distance[nodeIdx] + adjEdge.weight;
				}
			}

		}

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(distance[i]);
			}
		}
	}
}
