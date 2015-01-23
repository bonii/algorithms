package bitmanipulation;

public class NonZeroByteConverter {

	byte[] encode(byte[] src_bytes) {
		if(src_bytes == null) {
			return null;
		}
		byte[] output_bytes = new byte[src_bytes.length + (src_bytes.length/8) + 1];
		int index = 0;
		int counter = 0;
		byte previous_byte = 0x00;
		for(byte input_byte: src_bytes) {
			output_bytes[index] = (byte)(input_byte>>counter);
			output_bytes[index] = (byte) (output_bytes[index]| 0x01 | previous_byte<<(7-counter)); 
			previous_byte = (byte) (input_byte >> (counter+1));
			index++;
			counter++;
			if(counter == 7) {
				counter = 8;
				index++;
			}
		}
		output_bytes[index] = (byte) (output_bytes[index] | 0x01 | previous_byte<<(7-counter));
		return output_bytes;
	}
	
	byte[] decode(byte[] encoded_bytes) {
		return null;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		byte[] some_bytes = {0x05, 0x01};
		NonZeroByteConverter converter = new NonZeroByteConverter();
		for(byte some_byte:converter.encode(some_bytes)) {
			System.out.println(some_byte);
		}
	}

}
