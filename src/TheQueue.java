import java.util.Arrays;

public class TheQueue {
	public String[] queueArr;
	private int queueSize;
	private int front, rear, numberOfItems = 0;
	
	public TheQueue(int size) {
		// TODO Auto-generated constructor stub
		queueSize = size;
		queueArr = new String[size];
		Arrays.fill(queueArr, "-1");
	}
	
	public void insert(String input) {
		if(numberOfItems +1 <= queueSize) {
			queueArr[rear] = input;
			
			rear++;
			
			numberOfItems++;
			
			System.out.println("Insert " + input + " was added to queue");
		} else {
			System.out.println("Sorry, queue full");
		}
	}
}
