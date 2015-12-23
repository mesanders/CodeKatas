public class LinkedList<T> {

	public class Node<T> {
		private Node<T> next;
		private Node<T> prev;

		public boolean hasNext() {
			return true;	
		}
	}
}