public class ArrayStructures {
	private int[] theArray = new int[50];
	
	private int arraySize = 10;
	
	public void generateRandomArray() {
		for(int i=0; i<arraySize; i++) {
			theArray[i] = (int) (Math.random()*10) + 10;
		}
	}
	
	public void printArray() {
		System.out.println("-----");
		for(int i=0; i<arraySize; i++) {
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
			System.out.println("-----");
		}
	}
	
	public void printHorzArray(int i, int j){
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + n + "  ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		for(int n = 0; n < arraySize; n++){
			
			System.out.print("| " + theArray[n] + " ");
			
		}
		
		System.out.println("|");
		
		for(int n = 0; n < 51; n++)System.out.print("-");
		
		System.out.println();
		
		// END OF FIRST PART
		
		
		// ADDED FOR BUBBLE SORT
		
		if(j != -1){
		
			// ADD THE +2 TO FIX SPACING
			
			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");
			
			System.out.print(j);
			
		}
		
		
		// THEN ADD THIS CODE
		
		if(i != -1){
			
			// ADD THE -1 TO FIX SPACING
			
			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");
			
			System.out.print(i);
			
		}
		
		System.out.println();
		
	}
	
	public int getValueAtIndex(int index) {
		if(index < arraySize) return theArray[index];
		return 0;
	}
	
	public boolean doesArrayContainThisValue(int searchValue) {
		for(int i=0; i < arraySize; i++) {
			if(theArray[i] == searchValue) {
				return true;
			}
		}
		return false;
	}
	
	public void deleteIndex(int index) {
		if(index < arraySize) {
			for(int i=index; i< arraySize-1; i++) {
				theArray[index] = theArray[index + 1];
			}
			arraySize --;
		}
	}
	
	public void insertValue(int value) {
		if(arraySize < 50) {
			theArray[arraySize] = value;
			arraySize ++;
		}
	}
	
	public String linearSearchForValue(int value) {
		boolean valInArr = false;
		String idxWithValue = "";
		
		for(int i=0; i<arraySize; i++) {
			if(theArray[i] == value) {
				valInArr = true;
				System.out.println(i + " ");
				idxWithValue += i + " ";
			}
			printHorzArray(i, -1);
		}
		
		if(!valInArr) {
			idxWithValue = "None";
			System.out.println(idxWithValue);
		}
		System.out.println();
		System.out.println("The value was found in the following: ");
		return idxWithValue;
	}
	
	public void bubbleSort() {
		for(int i=arraySize-1; i> 1; i--) {
			for(int j=0; j< i; j++) {
				if(theArray[j] > theArray[j+1]) {
					swapValues(j, j+1);
					printHorzArray(i, j);
				}
				printHorzArray(i, j);
			}
		}
	}
	
	public void selectionSort() {
		for(int x=0; x< arraySize; x ++) {
			int min = x;
			for(int y= x; y<arraySize; y++) {
				if(theArray[min] > theArray[y]) {
					min = y;
				}
			}
			swapValues(x, min);
			
			printHorzArray(x, -1);
		}
	}
	
	public void insertionSort() {
		for(int i=1; i<arraySize; i++ ) {
			int j=i;
			int toInsert = theArray[i];
			while((j > 0) && (theArray[j-1] >toInsert)) {
				theArray[j] = theArray[j-1];
				j--;
				printHorzArray(i, j);
			}
			
			theArray[j] = toInsert;
			printHorzArray(i, j);
			System.out.println("\nArray[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert);
		}
	}
	
	public void binarySearchForValue(int value) {
		int lowIdx = 0;
		int highIdx = arraySize - 1;
		
		while(lowIdx <= highIdx) {
			int middleIdx = (highIdx + lowIdx)/2;
			if(theArray[middleIdx] < value) {
				lowIdx = middleIdx + 1;
			} else if(theArray[middleIdx] >value) {
				highIdx = middleIdx - 1;
			} else {
				System.out.println("\n Found a match for " + value + " on index " + middleIdx);
				break;
			}
			
			printHorzArray(middleIdx, -1);
		}
	}
	
	public void swapValues(int firstVal, int secondVal) {
		int temp = theArray[firstVal];
		theArray[firstVal] = theArray[secondVal];
		theArray[secondVal] = temp;
	}
	
	public static void main(String[] args) {
		ArrayStructures newArray = new ArrayStructures();
		newArray.generateRandomArray();
//		newArray.printArray();
//		System.out.println(newArray.getValueAtIndex(3));
//		System.out.println(newArray.doesArrayContainThisValue(13));
//		newArray.deleteIndex(3);
//		newArray.printArray();
//		newArray.insertValue(40);
//		newArray.printArray();
//		newArray.linearSearchForValue(17);
//		newArray.bubbleSort();
//		System.out.println(newArray.linearSearchForValue(12));
//		newArray.bubbleSort();
//		newArray.binarySearchForValue(12);
//		newArray.selectionSort();
		newArray.insertionSort();
	}
}
