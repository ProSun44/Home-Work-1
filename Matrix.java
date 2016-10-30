import java.util.Scanner;

public class Matrix {
	static Scanner input = new Scanner(System.in);
	
	static int[][] matrix1 = new int[3][3];     
	static int[][] matrix2 = new int[3][3];		
	static int[][] matrix3 = new int[3][3];		
	
	//1st row Multiplication 
	
	static Thread t1 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[0][j] += matrix1[0][i]*matrix2[i][j];
				}
			}
		}
	});
	
	// 2nd row Multiplication 
	
	static Thread t2 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[1][j] += matrix1[1][i]*matrix2[i][j];
				}
			}
		}
	});
	
	//3rd row Multiplication 
	
	static Thread t3 = new Thread(new Runnable() {
		public void run() {
			for (int j = 0; j < 3; j++) {
				for (int i = 0; i < 3; i++) {
					matrix3[2][j] += matrix1[2][i]*matrix2[i][j];
				}
			}
		}
	});
	
	// Method for starting The Threads 
	
    static void doSomething(){
    	t1.start();    
    	t2.start();	   
    	t3.start();   
    }
    
   
    
	public static void main(String[] args) {
		
		
		System.out.println("Give Matrix 1 : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix1[i][j] = input.nextInt();
			}
			
		}
		
		System.out.println("Give Matrix 2 : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrix2[i][j] = input.nextInt();
			}
			
		}
		 
		
		Matrix.doSomething();
		
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("The Final Matrix is : ");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix3[i][j] + " ");
			}
			System.out.println("");
		}
	}

}