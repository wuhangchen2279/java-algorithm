public class BinarySerach {

    public boolean searchInterative(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        while(left<=right) {
            int mid = (left + right) / 2;
            if(x == arr[mid]) {
                return true;
            } else if(x < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }

    public boolean searchRecursive(int[] arr, int x, int left, int right) {
        if(left > right) {
            return false;
        }

        int mid = (left + right) / 2;
        if(x == arr[mid]) {
            return true;
        } else if(x < arr[mid]) {
            return searchRecursive(arr, x, left, mid-1);
        } else {
            return searchRecursive(arr, x, mid+1, right);
        }
    }

    public void searchRecursive(int[] arr, int x) {
        searchRecursive(arr, x, 0, arr.length - 1);        
    }
}