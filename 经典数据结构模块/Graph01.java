package p55;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图邻接表的实现
 * @author Guozhu Zhu
 * @date 2019/3/25
 * @version 1.0
 *
 */
public class Graph01 {
	
	//图顶点的定义
	private static class Vertex {
		int data;
		public Vertex(int data) {
			this.data = data;
		}
	}
	
	//邻接表的定义
	private static class Graph {
		int size = 0;
		public Vertex[] vertexes;
		public LinkedList<Integer>[] adj;
		public Graph(int size) {
			this.size = size;
			vertexes = new Vertex[size];
			adj = new LinkedList[size];
			for (int i = 0; i < size; i++) {
				vertexes[i] = new Vertex(i);
				adj[i] = new LinkedList();
			}
		}
	}
	
	//DFS
	public void DFS(Graph graph, int start, boolean[] visited) {
		System.out.println(graph.vertexes[start].data);
		visited[start] = true;
		for (int index : graph.adj[start]) {
			if (!visited[index]) {
				DFS(graph, index, visited);
			}
		}
	}
	
	//BFS
	public void BFS(Graph graph, int start, boolean[] visited) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		while (!queue.isEmpty()) {
			int front = queue.poll();
			if (!visited[front]) {
				System.out.println(graph.vertexes[front].data);
				visited[front] = true;
				for (int index : graph.adj[front]) {
					queue.offer(index);
				}
			}
		}	
	}
	
	/* ========== Test ========== 
	 * 邻接表的数据
	 * [0] -> 1 -> 2 -> 3
	 * [1] -> 0 -> 3 -> 4
	 * [2] -> 0
	 * [3] -> 0 -> 1 -> 4 -> 5
	 * [4] -> 1 -> 3 -> 5
	 * [5] -> 3 -> 4
	 * */
	public static void main(String[] args) {
		Graph01 obj = new Graph01();
		Graph graph = new Graph(6);
		graph.adj[0].add(1);
		graph.adj[0].add(2);
		graph.adj[0].add(3);
		
		graph.adj[1].add(0);
		graph.adj[1].add(3);
		graph.adj[1].add(4);
		
		graph.adj[2].add(0);
		
		graph.adj[3].add(0);
		graph.adj[3].add(1);
		graph.adj[3].add(4);
		graph.adj[3].add(5);
		
		graph.adj[4].add(1);
		graph.adj[4].add(3);
		graph.adj[4].add(5);
		
		graph.adj[5].add(3);
		graph.adj[5].add(4);
		
		System.out.println("图的深度优先遍历:");
		obj.DFS(graph, 0, new boolean[graph.size]);
		System.out.println("图的广度优先遍历:");
		obj.BFS(graph, 0, new boolean[graph.size]);
	}

}
