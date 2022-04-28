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
 * BitUtility.java created on Feb 16, 2015
 *
 **/
package bitmanipulation;

import java.util.BitSet;
import java.util.Random;

/**
 * Helper functions for bit manipulation
 */
public class BitUtility {

	/**
	 * Count the number of differing bits in two byte arrays
	 * 
	 * @param value1
	 *            Input first value
	 * @param value2
	 *            Input second value
	 * @param rightAligned
	 *            flag to demarcate if the byte arrays are right or left aligned
	 * @return the number of bits two numbers differ in
	 */
	public static int numberOfDifferingBits(byte[] value1, byte[] value2,
			boolean rightAligned) {
		if (value1 == null && value2 == null) {
			return 0;
		} else if (value1 == null) {
			return sumOfBits(value2);
		} else if (value2 == null) {
			return sumOfBits(value1);
		}

		byte[] smaller, larger;

		if (value1.length < value2.length) {
			smaller = value1;
			larger = value2;
		} else {
			smaller = value2;
			larger = value1;
		}

		byte[] temp = new byte[larger.length];
		int displacement = rightAligned ? larger.length - smaller.length : 0;
		for (int i = 0; i < larger.length; i++) {
			temp[i] = (i < smaller.length) ? (byte) (smaller[i] ^ larger[i
					+ displacement]) : larger[i];
		}
		return sumOfBits(temp);
	}

	/**
	 * Returns the number of set bits(Hamming weight), uses bit manipulation
	 * operator, more efficient implementation would use BitSet
	 * 
	 * @param value
	 *            the input whose Hamming weight needs to be calculated
	 * @return the number of set bits
	 */
	public static int sumOfBits(byte[] value) {
		int counter = 0;
		for (byte aByte : value) {
			for (int i = 0; i < 8; i++) {
				counter += ((aByte & (0x01 << i)) >>> i);
			}
		}
		return counter;
	}

	/**
	 * Implementation of differing bits using BitSet
	 * 
	 * @param value1
	 *            Input first value
	 * @param value2
	 *            Input second value
	 * @return the number of bits differing in the two values
	 */
	private static int numberOfDifferingBitsUsingBitSet(byte[] value1,
			byte[] value2) {
		BitSet value1Set = BitSet.valueOf(value1);
		BitSet value2Set = BitSet.valueOf(value2);
		value1Set.xor(value2Set);
		return value1Set.cardinality();
	}

	public static void main(String[] args) {
		byte[] value1 = new byte[16], value2 = new byte[16];
		int trials = 10000;
		Random generator = new Random();
		while (trials-- > 0) {
			generator.nextBytes(value1);
			generator.nextBytes(value2);
			int bitCount1 = numberOfDifferingBits(value1, value2, true), bitCount2 = numberOfDifferingBitsUsingBitSet(
					value1, value2);
			if (bitCount1 != bitCount2) {
				throw new RuntimeException("Values do not match");
			}
		}
	}
}
