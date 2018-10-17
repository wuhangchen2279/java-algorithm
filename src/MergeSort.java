public class MergeSort{

    public void mergesort(int[] array) {
        int n = array.length;
        if(n<2) {
            return;
        }
        int mid = n/2;
        int[] left = new int[mid];
        int[] right = new int[n-mid];
        for(int i=0; i<mid; i++) {
            left[i] = array[i];
        }
        for(int i=mid; i<n; i++) {
            right[i-mid] = array[i];
        }
        mergesort(left);
        mergesort(right);
        merge(left, right, array);
    }

    public void merge(int[] left, int[] right, int[] array) {
        int numOfLeft = left.length;
        int numOfRight = right.length;
        int i = 0, j = 0, k = 0;

        while(i < numOfLeft && j < numOfRight) {
            if(left[i] <= right[j]) {
                array[k] = left[i];
                k++;
                i++;
            } else {
                array[k] = right[j];
                k++;
                j++;
            }
        } 

        while(i < numOfLeft) {
            array[k] = left[i];
            i++;
            k++;
        }

        while(j< numOfRight) {
            array[k] = right[j];
            j++;
            k++; 
        }
    }
}