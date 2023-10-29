package task2;

public class SinglyLinkedList<E> {
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size;

	public SinglyLinkedList() {
		super();
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public E first() {
		return this.head.getData();
	}

	public E last() {
		return this.tail.getData();
	}

	public void addFirst(E e) {
		Node<E> newest = new Node<E>(e);

		if (head == null) {
			head = newest;
			tail = newest;
		} else {
			newest.setNext(head);
			head = newest;
		}

		size++;
	}

	public void addLast(E e) {
		Node<E> newest = new Node<E>(e);

		if (head == null) {
			head = newest;
			tail = newest;
		} else {
			tail.setNext(newest);
			tail = newest;
		}

		size++;
	}

	public E removeFirst() {
		if (head == null) {
			return null;
		} else {
			E remove_E = head.getData();
			head = head.getNext();
			size--;
			return remove_E;
		}
	}

	public E removeLast() {
		if (head == null) { // Trường hợp không có Node nào
			return null;
		} else if (head.getNext() == null) { // Trường hợp có 1 Node
			E remove_E = head.getData();
			head = null;
			tail = null;
			size--;
			return remove_E;
		} else {

			// Trường hợp có 2 Node trở lên
			Node<E> current = head;
			Node<E> previous = null;

			while (current.getNext() != null) {
				previous = current;
				current = current.getNext();
			}

			E remove_E = current.getData();
			previous.setNext(null);
			tail = previous;
			size--;
			return remove_E;
		}
	}

	public String toString() {
		if (head == null) {
			return "Singly Linked List is empty !";
		} else {
			StringBuilder sb = new StringBuilder();

			Node<E> current = head;
			while (current != null) {
				sb.append(current.getData() + " --> ");
				current = current.getNext();
			}
			sb.append("null");
			return sb.toString();
		}

	}

	public static void main(String[] args) {
		SinglyLinkedList<String> strLinkedList = new SinglyLinkedList<>();
		System.out.println("Initial size: " + strLinkedList.size());
		System.out.println("Empty: " + strLinkedList.isEmpty());
		strLinkedList.addFirst("Táo");
		strLinkedList.addLast("Lê");
		strLinkedList.addFirst("Nho");
		strLinkedList.addLast("Hồng");

		System.out.println("Size after adding: " + strLinkedList.size());
		System.out.println("Empty: " + strLinkedList.isEmpty());

		String first_E = strLinkedList.first();
		System.out.println("First: " + first_E);
		String last_E = strLinkedList.last();
		System.out.println("Last: " + last_E);

		System.out.println(strLinkedList.toString());
		
		System.out.println("Remove first: " + strLinkedList.removeFirst());
		System.out.println("Remove last: " + strLinkedList.removeLast());
		
		System.out.println(strLinkedList.toString());
	}

}
