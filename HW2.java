import java.util.*;
 //Alexander Chatron-Michaud 260611509
public class HW2{
    
    /* Q3(b): Complete this method. Implement a iterative method to calculate factorial numbers */
    public static long factorial(int n){
        long fact = 1;
        for (int i=1; i<=n; i++) {
        	fact = fact*i;        	
        }
        return fact;
        
    }
    
    /* Q4(b): Complete this method. Implement a recursive method to calculate binomial coefficients */
    public static int BCoeffRec(int n, int k){

        int total = 0;
        if (n==k || k==0) { //base case
        	return 1;
        }
        //else if (k>n) {         Found this to be redundant
        //	return 0;
        //}
        else {
        	total = BCoeffRec(n-1,k) + BCoeffRec(n-1,k-1); //inductive step
        }
        return total;
    }
    
    /* Q4(c): Fill this method. Implement the explicit method to calculate binomial coefficients */
    public static long BCoeffExp(int n, int k){ 
        
        return ((factorial(n))/((factorial(n-k))*factorial(k)));
        
    }

    /* calculate execution time of BCoeffRec(n,k) */
    public static long TimeBcoeffRec(int n, int k){
        long startTime = System.nanoTime();
        int bc = BCoeffRec(n,k);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime) / 1;  // time in microseconds.
        
        return duration;
    }
    
    /* calculate execution time of BCoeffExp(n,k) */
    public static long TimeBcoeffExp(int n, int k){
        long startTime = System.nanoTime();
        long bc = BCoeffExp(n,k);
        long endTime = System.nanoTime();
        
        long duration = (endTime - startTime) / 1;  // time in microseconds.
        
        return duration;
    }
    
    
    /* Q4(d): Fill this method. Implement a recursive method to calculate binomial coefficients */
    public static void benchmark(int n){
        for (int i=0; i<=n; i++) {
        	System.out.print("(" + n + ", " + i + ")");
        	System.out.println("         " + TimeBcoeffRec(n,i) + "    " +TimeBcoeffExp(n,i));
        }       	
        
    }
    

    /*********************************************************************/
    /* Main                                                              */
    /*                                                                   */
    /* Note: You can comment the appropriate line below for testing each */
    /*       method individually                                         */
    /*                                                                   */
    /*********************************************************************/

    public static void main(String[] args){
        
        // This variable determines the upper bound of n for the test.
        int depthtest = 20;
        
        // Test for Question 3(b)
        System.out.println(">> Test factorial");
        for (int i=0; i<=depthtest; i++) {
            System.out.println(String.valueOf(i) + "! = " + String.valueOf(factorial(i)));
            
        }

        // Test for Question 4(b)
        System.out.println();
        System.out.println(">> Test of Binomial Coefficient Recursive");
        for (int n=0; n<=depthtest; n++) {
            for (int k=0; k<=n; k++) {
                int bcoeffval = BCoeffRec(n,k);
                System.out.print(String.valueOf(bcoeffval) + "\t");
            }
            System.out.println();
        }
        
        // Test for Question 4(c)
        System.out.println();
        System.out.println(">> Test of Binomial Coefficient Explicit");
        for (int n=0; n<=depthtest; n++) {
            for (int k=0; k<=n; k++) {
                long bcoeffval = BCoeffExp(n,k);
                
                System.out.print(String.valueOf(bcoeffval) + "\t");
            }
            System.out.println();
        }
        
        // Test for Question 4(d)
        System.out.println();
        System.out.println(">> Execution time benchmark");
        System.out.println(">> n=10");
        benchmark(10);
        System.out.println(">> n=20");
        benchmark(20);
        

   }
}
