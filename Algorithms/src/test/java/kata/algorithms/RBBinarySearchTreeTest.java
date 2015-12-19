package kata.algorithms;

public class RBBinarySearchTreeTest {
	public void testNode() {
		RBBinarySearchTree.Node<Integer, Integer> node = new RBBinarySearchTree().new Node<>(10);
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
}