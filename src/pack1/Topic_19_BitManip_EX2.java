package pack1;

//Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary representation. 
//If the number can not be represented accurately in binary, print “ERROR”

public class Topic_19_BitManip_EX2 {

	public static void main(String[] args) {
		//String d = "3.72";
		String d="3.1015625";

		convertFloatingToBinary(d);

	}

	private static void convertFloatingToBinary(String d) {
		int integral = 0;
		double fractional = 0;
		int dotIndex = 0;
		if (d.contains(".")) {
			dotIndex = d.indexOf('.');
			fractional = Double.parseDouble(d.substring(dotIndex, d.length()));
		}
		integral = Integer.parseInt(d.substring(0, dotIndex));
		String integralBinary = "", fractionalBinary = "";
		int remainder = 0;
		while (integral != 0) {
			remainder = integral % 2;
			integralBinary = integralBinary + remainder;
			integral = integral / 2;
		}
		System.out.println(integralBinary);
		while (fractional != 0) {
			System.out.println(fractional);

			remainder = (int) (fractional * 2);
			System.out.println(remainder);
			fractionalBinary = fractionalBinary + remainder;
			if (fractionalBinary.length() > 32) {
				System.out.println("ERROR");
				break;
			}
			fractional = (fractional * 2) - (double) remainder;

//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println(integralBinary+"."+fractionalBinary);
	}
}
