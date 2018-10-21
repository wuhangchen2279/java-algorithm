public class Recursion {
    public int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public int fibonacci(int n) {
        if(n<=1) {
            return n;
        }
        int f1 = 0;
        int f2 = 1;
        int f = 0;
        for(int i=2; i<n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f; 
        }

        return f;
    }

    
 }