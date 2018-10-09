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
	
	public void priorityInsert(String input) {
		int i;
		if(numberOfItems == 0) {
			insert(input);
		} else {
			for(i= numberOfItems - 1; i>=0; i--) {
				if(Integer.parseInt(input) > Integer.parseInt(queueArr[i])) {
					queueArr[i+1] = queueArr[i];
				}else {
					break;
				}
			}
			queueArr[i+1] = input;
			rear++;
			numberOfItems++;
		}
	}
	
	public void remove() {
		if(numberOfItems > 0) {
			System.out.println("remove " + queueArr[front] + " from queue");
			queueArr[front] = "-1";
			front++;
			numberOfItems--;
		} else {
			System.out.println("sorry, queue empty");
		}
	}
	
	public void peek() {
		System.out.println("The first element is " + queueArr[front]);
	}
	
	public void displayTheQueue(){
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
			
			System.out.format("| %2s "+ " ", n);
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < queueSize; n++){
			
			
			if(queueArr[n].equals("-1")) System.out.print("|     ");
			
			else System.out.print(String.format("| %2s "+ " ", queueArr[n]));
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		// Number of spaces to put before the F
		
		int spacesBeforeFront = 3*(2*(front+1)-1);
		
		for(int k = 1; k < spacesBeforeFront; k++)System.out.print(" ");
		
		System.out.print("F");
		
		// Number of spaces to put before the R
		
		int spacesBeforeRear = (2*(3*rear)-1) - (spacesBeforeFront);
		
		for(int l = 0; l < spacesBeforeRear; l++)System.out.print(" ");
		
		System.out.print("R");
		
		System.out.println("\n");
	
	}
	
	public static void main(String args[]) {
		TheQueue queue = new TheQueue(10);
		queue.priorityInsert("12");
		queue.priorityInsert("10");
		queue.priorityInsert("11");
		queue.priorityInsert("13");
		
		queue.displayTheQueue();
		
		queue.remove();
		queue.displayTheQueue();
	}
}
