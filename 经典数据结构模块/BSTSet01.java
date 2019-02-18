package p50;

/**
 * 基于BSTMap实现的BSTSet
 * @author Guozhu Zhu
 * @date 2019/2/18
 * @version 1.0
 *
 */
public class BSTSet01<E extends Comparable<E>> {
    
	private BSTMap01<E, Object> bstmap;
	private Object obj;
	public BSTSet01() {
		bstmap = new BSTMap01<>();
		obj = new Object();
	}
	
	//添加一个元素
	public void add(E key) {
		bstmap.add(key, obj);
	}
	
	//删除某个元素
	public void remove(E e) {
		bstmap.remove(e);
	}
	
	//判断是否包含某一元素
	public boolean contains(E key) {
		return bstmap.contains(key);
	}
	
	//Set的长度
	public int getSize() {
		return bstmap.getSize();
	}
	
	//Set是否为空
	public boolean isEmpty() {
		return bstmap.isEmpty();
	}
	
}
