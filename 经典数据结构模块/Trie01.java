package p48;

import java.util.TreeMap;

/**
 * 字典树是一种高效的字符串查询结构，其优点在于时间复杂度只和【字符串的长度】相关，
 * 其缺点是空间浪费严重。相当于拿空间换时间的一种策略
 * @author Guozhu Zhu
 * @date 2019/2/15
 * @version 1.0
 *
 */
public class Trie01 {
	
	private class Node {
		private boolean isWord;
		public TreeMap<Character, Node> next;
		public Node(boolean isWord) {
			this.isWord = isWord;
			next = new TreeMap<Character, Node>();
		}
		public Node() {

			this(false);
		}
	}
	private Node root;
	public Trie01() {
		root = new Node();
	}
	
	//插入字符串
	public void insert(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				cur.next.put(c,  new Node());
			}
			cur = cur.next.get(c);
		}
		cur.isWord = true;
	}
	
	//查询是否存在某一单词
	public boolean search(String word) {
		Node cur = root;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return cur.isWord;
	}
	
	//判断是否是某一个前缀单词
	public boolean startsWith(String prefix) {
		Node cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);
			if (cur.next.get(c) == null) {
				return false;
			}
			cur = cur.next.get(c);
		}
		return true;
	}
	
	/* ========== Test ========== */
	public static void main(String[] args) {
		Trie01 trieTree = new Trie01();
		trieTree.insert("zhu");
		trieTree.insert("guo");
		trieTree.insert("lhu");
		System.out.println(trieTree.startsWith("zh"));
	}
	
}
