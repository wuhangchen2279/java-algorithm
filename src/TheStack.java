import java.util.Arrays;

public class TheStack {
	private String[] stackArr;
	private int stackSize;
	private int topOfStack = -1;

	public TheStack(int size) {
		// TODO Auto-generated constructor stub
		stackSize = size;
		stackArr = new String[stackSize];
		Arrays.fill(stackArr, "-1");
	}
	
	public void push(String input) {
		if(topOfStack + 1 < stackSize) {
			topOfStack ++;
			stackArr[topOfStack] = input;
		} else {
			System.out.println("stack is full");
		}
		displayStack();
		System.out.println("Push " + input + " to the stack");
	}
	
	public String pop() {
		if(topOfStack >=0) {
			displayStack();
			System.out.println("POP " + stackArr[topOfStack] + " was removed from stack");
			stackArr[topOfStack] = "-1";
			return stackArr[topOfStack --];
		} else {
			displayStack();
			System.out.println("the stack is empty");
			return "-1";
		}
	}
	
	public String peek() {
		displayStack();
		System.out.println("Peek " + stackArr[topOfStack] + "is at the top of array");
		return stackArr[topOfStack];
	}
	
	public void displayStack(){
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++){
			
			System.out.format("| %2s "+ " ", n);
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < stackSize; n++){
			
			
			
			if(stackArr[n].equals("-1")) System.out.print("|     ");
			
			else System.out.print(String.format("| %2s "+ " ", stackArr[n]));
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 61; n++)System.out.print("-");
		
		System.out.println();
	
}
	
	public static void main(String[] args) {
		TheStack theStack = new TheStack(10);
		theStack.push("10");
		theStack.push("15");
		theStack.peek();
		theStack.pop();
		theStack.displayStack();
	}
}
