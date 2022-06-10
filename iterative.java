import java.util.*;
public class iterative {
	public static void main(String[] args) {
		double[][] matrixD = 
			{
			{0, -(1.0/2.0), -(1.0/6.0)},
			{-(2.0/5.0), 0, -(2.0/5.0)},
			{-(1.0/4.0), -(1.0/4.0), 0}
			};
		double[] x = 
			{
			100, 
			100, 
			100
			};
		double[] c = 
			{
			(5/2.0), 
			10, 
			(5/2.0)
			};
		double[] temp = Arrays.copyOf(x, x.length);
		int count = 0;
		do {
			x = Arrays.copyOf(temp, x.length);
			temp = new double[x.length];
			for (int i = 0; i < matrixD.length; i++) {
				for (int j = 0; j < matrixD[i].length; j++) {
					temp[i] += matrixD[i][j] * x[j];
				}
				temp[i] += c[i];
			}
			if (count == 0) {
				System.out.println("Initial guess ");
				System.out.println("This is the column vector: " + Arrays.toString(x));
				for (int i = 0; i < x.length; i++) {
					System.out.println("x" + (i + 1) + " = " + x[i]);
				}
				System.out.println();
			}else {
				System.out.println("Iteration " + count);
				System.out.println("This is the column vector: " + Arrays.toString(x));
				for (int i = 0; i < x.length; i++) {
					System.out.println("x" + (i + 1) + " = " + x[i]);
				}
				System.out.println();
			}
			count += 1;
//			System.out.println(Arrays.toString(temp));
		}while (norm(temp, x) >= Math.pow(10, -6));
	}
	public static double norm(double[] temp, double[] x) {
		double[] diff = new double[x.length];
		for (int i = 0; i < x.length; i++) {
			diff[i] += temp[i] - x[i];
		}
		double sum = 0;
		for (int i = 0; i < diff.length; i++) {
			sum += diff[i];
		}
		return Math.abs(sum);
	}
}
