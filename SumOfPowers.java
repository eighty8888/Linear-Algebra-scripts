import java.util.*;
public class SumOfPowers {
	public static void main(String[] args) {
		System.out.println("How large is matrix D? (square matrix) ");
		int size = input.nextInt();
		System.out.println("Enter matrix D: ");
		double[][] matrixD = new double[size][size];
		for (int i = 0; i < matrixD.length; i++) {
			for (int j = 0; j < matrixD[i].length; j++) {
				matrixD[i][j] = input.nextDouble();
			}
		}
		double[][] sum = {
				{1, 0},
				{0, 1}
		};
		int power = 100;
		double[][] temp = new double[size][size];
		for (int i = 0; i < matrixD.length; i++) {
			for (int j = 0; j < matrixD[i].length; j++) {
				temp[i][j] = matrixD[i][j];
			}
		}
		for (int i = 1; i <= power; i++) {
			DtoPowerOf(i, matrixD, temp);
			for (int j = 0; j < matrixD.length; j++) {
				for (int k = 0; k < matrixD[j].length; k++) {
					sum[j][k] += matrixD[j][k];
				}
			}
		}
		System.out.println(Arrays.deepToString(sum));
	}
	public static double[][] DtoPowerOf(int exp, double[][] D, double[][] temp){
		if (exp == 1) {
			return D;
		}else {
			double[][] dupli = new double[D.length][D.length];
			for (int r = 0; r < D.length; r++) {
				for (int c = 0; c < D[r].length; c++) {
					for (int j = 0; j < D[r].length; j++) {
						dupli[r][c] += D[r][j] * temp[j][c];
					}
				}
			}
			for (int i = 0; i < D.length; i++) {
				for (int j = 0; j < D.length; j++) {
					D[i][j] = dupli[i][j];
				}
			}
		}
		return D;
	}
}
