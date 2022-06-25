import java.util.*;
public class LeontiefModel {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("How large is matrix D? (square matrix) ");
		int size = input.nextInt();
		System.out.println("Enter matrix D: ");
		double[][] matrixD = new double[size][size];
		for (int i = 0; i < matrixD.length; i++) {
			for (int j = 0; j < matrixD[i].length; j++) {
				matrixD[i][j] = input.nextDouble();
			}
		}
		System.out.println("Enter the initial guess vector x: ");
		double[] x = new double[size];
		for (int i = 0; i < x.length; i++) {
			x[i] = input.nextDouble();
		}
		System.out.println("Enter the constant vector c: ");
		double[] c = new double[size];
		for (int i = 0; i < c.length; i++) {
			c[i] = input.nextDouble();
		}
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
