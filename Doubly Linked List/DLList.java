
public class DLList<E> 
{
	private Node<E> header;
	private Node<E> trailer;
	private int size;
	
	public DLList()
	{
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, null, header);
		header.next = trailer;
		size = 0;
	}
	
	/**
	 * This method inserts value v in a new node between first and second
	 * @param v value to insert
	 * @param first first node
	 * @param second second node
	 */
	private void insertBetween(E v, Node<E> first, Node<E> second)
	{
		Node<E> newNode = new Node<>(v, second, first);
		second.prev = newNode;
		first.next = newNode;
		size++;
	}
	
	/**
	 * Removes the node between first and second. Throws illegalStateException
	 * if the list is empty
	 * @param first first node
	 * @param second second node
	 * @return the value deleted
	 */
	private E removeBetween(Node<E> first, Node<E> second) throws IllegalStateException
	{
		if(header.next == trailer) //if(size == 0)
		{
			throw new IllegalStateException("Cannot delete from empty list");
		}
		E valueToReturn = first.next.value;
				
		first.next = second;
		second.prev = first;
		size--;
		
		return valueToReturn;
	}
	
	public void insertAtHead(E v)
	{
		insertBetween(v, header, header.next);
	}
	
	public void insertAtTail(E v)
	{
		insertBetween(v, trailer.prev, trailer);
	}
	
	public E removeHead() throws IllegalStateException
	{
		return removeBetween(header, header.next);
	}
	
	public E removeTail() throws IllegalStateException
	{
		return removeBetween(trailer.prev, trailer);
	}
	
	public String toString()
	{
		if(size == 0)
		{
			return "list is empty!";
		}
		String r = "";
		Node<E> temp = header.next;
		while(temp != trailer)
		{
			r += temp.toString() + " ";
			temp = temp.next;
		}
		return r;
	}
	
	public void printBackward()
	{
		if(size == 0)
		{
			System.out.println("list is empty!");
		}
		
		Node<E> temp = trailer.prev;
		while(temp != header)
		{
			System.out.print(temp + " ");
			temp = temp.prev;
		}
		System.out.println();

	}
	
	private static class Node<T>
	{
		private T value;
		private Node<T> next;
		private Node<T> prev;
		
		public Node(T v, Node<T> n, Node<T> p)
		{
			value = v;
			next = n;
			prev = p;
		}
		
		public String toString()
		{
			return value.toString();
		}
	}

}
