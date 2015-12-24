package kata.algorithms;

public class LinkedListTest {
	public void testNode() {
		LinkedList<Integer>.Node<Integer> node = new LinkedList<Integer>().new Node<>(10);
		assert(node.getValue() == 10);
		assert(node.getPrev() == null);
		assert(node.getNext() == null);
	}

	public void testInsert() {
		LinkedList<Integer> llist = populateList();
		
		assert(llist.contains(20));
		assert(llist.contains(10));
		assert(llist.contains(25));
	}

	public void testRemove() {
		LinkedList<Integer> llist = populateList();
		
		assert(!llist.isEmpty());
		assert(llist.contains(20));
		assert(llist.getSize() == 4);
		
		llist.remove(20);

		assert(!llist.contains(20));
		assert(llist.contains(25));
		
		llist.remove(25);
		llist.remove(35);
		llist.remove(10);

		assert(llist.isEmpty());
		assert(llist.getSize() == 0);	
	}

	public void testClear() {
		LinkedList<Integer> llist = populateList();

		llist.clear();
		assert(llist.isEmpty());
	}

	public void testPopTop() {
		LinkedList<Integer> llist = populateList();

		int top = llist.popTop();
		assert(top == 20);
		assert(llist.getSize() == 3);

		while(!llist.isEmpty()) {
			llist.popTop();
		}

		assert(llist.isEmpty());
	}

	public void testPopBottom() {
		LinkedList<Integer> llist = populateList();

		int bottom = llist.popBottom();
	
		assert(bottom == 10);
		assert(llist.getSize() == 3);

		while(!llist.isEmpty()) {
			llist.popBottom();
		}

		assert(llist.isEmpty());
	}

	public LinkedList<Integer> populateList() {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		
		assert(!llist.contains(20));
		assert(llist.isEmpty());
		llist.insert(20);
		llist.insert(25);
		llist.insert(35);
		llist.insert(10);

		return llist;
	}
}