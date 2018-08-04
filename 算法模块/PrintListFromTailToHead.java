package p19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.Vector;

/**
 * 从链表尾部->头部打印链表
 * @author Guozhu Zhu
 * @date 2018/8/5
 * @version 1.0
 *
 */
public class Test03 {
	
	public ListNode first;    //链表头
	
	public ListNode last;     //链表尾
	
	//链表节点的类结构
	private static class ListNode{
		int val;
		public ListNode next;
		public ListNode() {
		}
	}
	
	//单链表尾添加元素
    public boolean add(int e) {
        ListNode f = first;
    	ListNode newNode = new ListNode();
    	newNode.val = e;
        if (f != null) {
           last.next = newNode;
           last = newNode;
        } else {
        	first = newNode;
        	last = newNode;
        }
        return true;
    }

	//========Algorithm-Implement01========
	static ArrayList<Integer> arrayList=new ArrayList<Integer>();

    public static ArrayList<Integer> printListFromTailToHead01(ListNode listNode) {
        if(listNode!=null){
            printListFromTailToHead01(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
    
    //========Algorithm-Implement02========
    public static ArrayList<Integer> printListFromTailToHead02(ListNode listNode) {
    	ArrayList<Integer> resList = new ArrayList<>();
    	Stack<Integer> tempStack = new Stack<>();
    	
    	while (listNode != null) {
    		tempStack.push(listNode.val);
    		listNode = listNode.next;
    	}
    	
    	while (!tempStack.isEmpty()) {
    		resList.add(tempStack.pop());
    	}
    	
    	return resList;
    }
    
    //========Algorithm-Implement03========
    public static ArrayList<Integer> printListFromTailToHead03(ListNode listNode) {
    	ArrayList<Integer> resList = new ArrayList<>();
    	while (listNode != null) {
    		resList.add(listNode.val);
    		listNode = listNode.next;
    	}
    	Collections.reverse(resList);
    	return resList;
    }
    
    //========Test========
    public static void main(String[] args) {
    	Test03 list = new Test03();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	//ArrayList<Integer> res = printListFromTailToHead01(list.first);
    	//ArrayList<Integer> res = printListFromTailToHead02(list.first);
    	ArrayList<Integer> res = printListFromTailToHead03(list.first);
        for (int i : res) {
        	System.out.println(i);
        }
        System.out.println(arrayList.toString());
    }
   
}
