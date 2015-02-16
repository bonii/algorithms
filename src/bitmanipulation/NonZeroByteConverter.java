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
 * NonZeroByteConverter created on Jan 30, 2015
 *
 **/
package bitmanipulation;

import java.util.Arrays;

/**
 * Encode and decode a byte array so that it does not contain a zero byte
 */
public class NonZeroByteConverter {
	private byte[] input = null;
	private byte[] output = null;

	public NonZeroByteConverter(byte[] input) {
		this.input = input;
	}

	public void encode() {
		if (input == null) {
			return;
		}
		output = new byte[input.length + (input.length / 8) + 1]; // For every
																	// 8th byte
																	// I need an
																	// extra
																	// byte
		int index = 0, counter = 0;
		byte previous_byte = 0b00000000;
		int i=0;
		while (i<input.length) {
			output[index] = 0b00000001;
			output[index] |= previous_byte;
			if(counter == 8) {
				counter = 0;
				previous_byte = 0b00000000;
			} else {
				byte input_byte = input[i];
				output[index] |= (input_byte >>> counter);
				previous_byte = (byte) (input_byte << (7 - counter));
				counter++;
				i++;
			}
			index++;
		}
		output[index] = (byte) (0b00000001 | previous_byte);
	}

	public void decode() {
		if (input == null) {
			return;
		}
		output = new byte[input.length - (input.length / 9) - 1];
		int index = 0, counter = 0;
		for (int i = 0; i < input.length-1; i++) {
			output[index] = 0b00000000;
			input[i] &= 0b11111110;
			output[index] |= (input[i] & (0b11111111 << counter));
			output[index] |= ((input[i + 1] & 0b11111110) >>> (7 - counter));
			if (counter == 7) {
				counter = 0;
				i++;
			} else {
				counter++;
			}
			index++;
		}
	}

	public byte[] getInput() {
		return input;
	}

	public void setInput(byte[] input) {
		this.input = input;
	}

	public byte[] getOutput() {
		return output;
	}

	public static void main(String[] args) {
		byte[] some_bytes = {0x05, 0x08, 0x00, 0x01, 0x51, 0x34, 0x34, 0x01, 0x21, (byte)0xff, 0x22, 0x23, 0x77 };
		NonZeroByteConverter converter = new NonZeroByteConverter(some_bytes);
		converter.encode();
		byte[] encoded = converter.getOutput();
		converter.setInput(encoded);
		converter.decode();
		byte[] decoded = converter.getOutput();
		for(int i=0;i<some_bytes.length;i++) {
			System.out.println(some_bytes[i] + " " + decoded[i]);
		}
		if (!Arrays.equals(some_bytes, decoded)) {
			throw new RuntimeException();
		}
	}

}
