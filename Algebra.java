// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if (x2 > 0) {
			for(int i = 0;i < x2;i++){
				x1++;
			}
		}
		if (x2 < 0) {
			for(int i = x2;i < 0;i++){
				x1--;
			}
		}

		return x1;
		}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if (x2 > 0) {
			for(int i = 0;i < x2;i++){
				x1--;
			}
		}
		if (x2 < 0) {
			for(int i = x2;i < 0;i++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int original = x1;
		for(int i = 0;i < x2 - 1;i++) {
			x1 = plus(x1,original);
		}
		if ((original > 0 && x2 > 0) || (original < 0 && x2 < 0)) {
			return x1;
		}
		if(x1 == 0 || x2 == 0){
			return 0;
		}
		return -x1;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int original = x;
		if (n >= 0) {
			for(int i = 0;i < n-1;i++){
				x = times(x, original);
			}
		}
		if(x < 0 || mod(n,2) != 0){
			return -x;
		}
		return x;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if (x2 != 0) {
			int numerator = x1;
			int denominator = x2;
			int counter = 0;
			while (x1 > 0) {
				counter++;
				x1 = minus(x1, x2);
			}
			if ( numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0) {
				return counter;
			}
			return -counter;
		}
		else {
			return -1;
		}

	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        while (x1 >= x2) {
			x1 = minus(x1, x2);
		}
		return x1;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int num = 1;
		if(x == 0){
			return 0;
		}
        if (x > 0) {
			while (times(num,num) < x) {
				num++;
			}
			if(times(num,num) > x){
				num--;
			}
			return num;
		}
		else{
			return -1;
		}
	}	   	  
}