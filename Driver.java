package Project1;

import java.util.Scanner;

public class Driver {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Matrix a = Driver.getMatrix("first matrix");
		System.out.println(a);
		Matrix b = Driver.getMatrix("second matrix");
		System.out.println(b);
		int opChoice = pickoperation();
		Matrix c = executeoperation(a, b, opChoice);
		System.out.println(c);
	}

	public static Matrix getMatrix(String input) {
		int r, c;
		System.out.print("please enter the number of rows in" + input);
		r = scan.nextInt();
		System.out.print("please enter the number of columns in" + input);
		c = scan.nextInt();

		return Driver.choosematrixtype(r, c);
	}

	public static Matrix choosematrixtype(int row, int col) {
		System.out.println("choose type of matrix you would like to use:");
		System.out.println("1) sequential");
		System.out.println("2) parallel");

		int cho = scan.nextInt();

		if (cho == 1) {
			return new SequentialMatrix(row, col);
		}
		if (cho == 2) {
			return new ParallelMatrix(row, col);
		}
		return Driver.choosematrixtype(row, col);
	}

	public static Matrix Operation(Matrix a, Matrix b) {
		int op = Driver.pickoperation();
		boolean valid = false;
		do {
			valid = Driver.validate(a, b, op);
			if (!valid) {
				a = Driver.getMatrix("first matrix");
				System.out.print(a);
				b = Driver.getMatrix("second matrix");
				System.out.print(b);
				op = Driver.pickoperation();
			}

		} while (!valid);
		return Driver.executeoperation(a, b, op);
	}

	private static boolean validate(Matrix a, Matrix b, int op) {
		return false;
	}

	private static int pickoperation() {
		System.out.println("pick operation");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Hadamard");
		int input = scan.nextInt();

		return input;
	}

	private static Matrix executeoperation(Matrix a, Matrix b, int op) {
		if (op == 1) {
			return a.add(b);
		} else if (op == 2) {
			return a.subtract(b);
		} else if (op == 3) {
			return a.dotProduct(b);
		} else if (op == 4) {
			return a.HadamardProduct(b);
		}
		return null;
	}

}
