package task1;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {

	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of elements is full
	public void growSize() {
		int newCapacity = elements.length * 2;
		E[] newElements = (E[]) new Object[newCapacity];
		newElements = Arrays.copyOf(elements, newCapacity);

	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}

		elements[size++] = e;
		return true; // add thành công
	}

	public E get(int i) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i];
		}
	}

	public E set(int i, E e) {
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			return elements[i] = e;
		}
	}

	public void add(int i, E e) {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException();
		} else {
			if (size == elements.length) {
				growSize();
			}
			for (int j = size; j > i; j--) {
				elements[j] = elements[j - 1];
			}

			elements[i] = e;
			size++;
		}
	}

	public E remove(int i) {
		E elementRemove= elements[i];
		if (i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		} else {
			for (int j = i; j < size - 1; j++) {
				elements[j] = elements[j + 1];
			}

			size--;
		}
		return elementRemove;
	}

	public void show() {
		for (int i = 0; i < size; i++) {
			System.out.print(elements[i] + " ");
		}

		System.out.println();
	}

	// Then implements other methods as in Java Collection Framework -
	// ArrayList.java

	public int indexOf(E e) {
		for (int i = 0; i < size; i++) {
			if (elements[i].equals(e)) {
				return i;
			}
		}
		return -1;
	}

	public int lastIndexOf(E e) {
		for (int i = size - 1; i >= 0; i--) {
			if (elements[i].equals(e)) {
				return i;
			}
		}

		return -1;
	}

	public void clear() {
		for (int i = 0; i < size; i++) {
			remove(elements[i]);
		}
		
		size=0;
		System.out.println("Cleared");
		
		
	}

	// sử dụng copyOf hay vì trả về this.elements trực tiếp vì đảm bảo rằng mảng ban
	// đầu không
	// bị ảnh hưởng bởi bất kỳ sửa đổi nào trên mảng được trả

	public E[] toArray() {
		return Arrays.copyOf(elements, size);
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> arrayList_clone = new MyArrayList<>();
		arrayList_clone.elements = Arrays.copyOf(this.elements, this.elements.length);
		arrayList_clone.size = this.size;
		return arrayList_clone;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (o != null && o.equals(elements[i])) {
				return true;
			}
		}
		return false;
	}

	public boolean remove(E e) {
		if(contains(e)) {
          int indexE= indexOf(e);				
			remove(indexE);
			return true;
		}
		return false;
	}
	
    public void sort(Comparable<E> com) {
    	
    }
	
	public static void main(String[] args) {

		Integer[] arr = { 1, 3, 5, 7, 0, 5 };
		MyArrayList<Integer> integerList = new MyArrayList<>();
		System.out.println("Initial size: " + integerList.size);

		for (Integer integer : arr) {
			integerList.add(integer);
		}

		System.out.println("Size after adding elements: " + integerList.size);
		System.out.println("Empty: " + integerList.isEmpty());

		System.out.println("Elements[0]: " + integerList.get(0));
		System.out.println("Elements[4]: " + integerList.get(4));
//		System.out.println("Elements[4]: "+integerList.get(99999));
		System.out.println("Elements[1]: " + integerList.get(1));
		System.out.println("Set(1,11): " + integerList.set(1, 11));

		System.out.println("add(6,19): ");
		integerList.add(6, 19);
		integerList.show();
		System.out.println(Arrays.toString(integerList.toArray()));

		System.out.println("==================");

		System.out.println(integerList.remove(3));
		integerList.show();
		System.out.println(integerList.remove(0));
		integerList.show();

		System.out.println("Index of value 0: " + integerList.indexOf(0));
		System.out.println("Last index of number 5: "+integerList.lastIndexOf(5));

		System.out.println(Arrays.toString(integerList.toArray()));

		MyArrayList<Integer> integerList_clone = integerList.clone();
		integerList_clone.add(9);
		integerList_clone.show();

		System.out.println("Contains(11) in integerList: " + integerList.contains(11));
		System.out.println(integerList.remove((Integer)19));
		integerList.show();
		
		System.out.println(integerList_clone.remove((Integer)9));
		integerList_clone.show();
		
		integerList_clone.clear();
		System.out.println(Arrays.toString(integerList_clone.toArray()));
		
	}

}
