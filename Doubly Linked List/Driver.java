
public class Driver {

	public static void main(String[] args)
	{
		DLList<Integer> list = new DLList<>();
		
		System.out.println(list);
		list.printBackward();
		
		for(int i=0; i < 5; i++)
		{
			list.insertAtHead(i);
		}

		for(int i=10; i < 15; i++)
		{
			list.insertAtTail(i);
		}
		System.out.println(list);
		list.printBackward();
		
	}

}