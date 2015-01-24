/** 
 * The MIT License (MIT) 
 * Copyright (c) 2015 Vivek Shah
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
 * copies of the Software, and to permit persons to whom the Software is 
 * furnished to do so, subject to the following conditions:
 * 
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.

 * Author Vivek Shah <bonii at kernelspace.in>
 * RowColumnSetter.java created on Jan 24, 2015
 *
 **/
package strings;

import java.util.Scanner;

/**
 * Zero out a row (i) and column (j) if the the element at (i,j) is 0
 */
public class RowColumnSetter {
	int[][] matrix = null;

	public RowColumnSetter(int[][] matrix) {
		this.matrix = matrix;
	}

	public int[][] getMatrix() {
		return matrix;
	}

	public void processMatrix() {
		if (matrix == null || matrix[0] == null) { // We cannot infer the size
			return;
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[] zeroOutRow = new boolean[rows];
		boolean[] zeroOutColumn = new boolean[cols];

		for (int i = 0; i < rows; i++)
			zeroOutRow[i] = false;
		for (int i = 0; i < cols; i++)
			zeroOutColumn[i] = false;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				boolean zeroOut = (matrix[i][j] == 0);
				if (zeroOut) {
					zeroOutRow[i] = true;
					zeroOutColumn[j] = true;
				}
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] = ((zeroOutRow[i] || zeroOutColumn[j]) ? 0
						: matrix[i][j]);
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int rows = in.nextInt();
		int cols = in.nextInt();
		int[][] input = new int[rows][cols];

		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				input[i][j] = in.nextInt();

		RowColumnSetter setter = new RowColumnSetter(input);
		setter.processMatrix();

		int[][] result = setter.getMatrix();

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++)
				System.out.print(result[i][j] + " ");
			System.out.println();
		}

		in.close();
	}

}
