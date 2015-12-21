package kata.algorithms;

public class RBBinarySearchTreeTest {
	public void testNode() {
		RBBinarySearchTree.Node<Integer, Integer> node = new RBBinarySearchTree().new Node<>(10);
		assert(!node.hasChildren());
		assert(node.getLeft() == null);
		assert(node.getRight() == null);
		assert(node.getKey() == 10);
		assert(node.getValue() == null);

		RBBinarySearchTree.Node<Integer, Integer> node2 = new RBBinarySearchTree().new Node<>(10, 8);
		assert(node2.getValue() == 8);
	}

	public void testInsert() {
		RBBinarySearchTree rbbst = new RBBinarySearchTree();
		rbbst.insertAll(new int[] { 20, 10, 1, 35, 2, 22, 12, 8 });
		assert(rbbst.contains(20));
		assert(rbbst.contains(1));
		assert(rbbst.getSize() == 8);
	}

	public void testDelete() {
		RBBinarySearchTree rbbst = new RBBinarySearchTree();
		rbbst.insertAll(new int[] { 20, 18, 22, 24, 10, 1, 35, 2,  12, 8 });
		assert(rbbst.contains(35));	
		assert(rbbst.contains(22));
		assert(rbbst.getSize() == 10);

		rbbst.delete(22);
		rbbst.delete(35);
		rbbst.delete(1);

		assert(!rbbst.contains(35));	
		assert(!rbbst.contains(22));
		assert(rbbst.contains(2));
		assert(rbbst.getSize() == 7);
	}
}