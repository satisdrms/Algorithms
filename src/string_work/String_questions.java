package string_work;

public class String_questions {
	public static void main(String[] args) {
		String s1 = new String("pankaj");
		String s2 = new String("PANKAJ");
		System.out.println(s1 = s2);
		
		
		String s1_1 = new String("abc");
		String s2_1 = new String("abc");
		System.out.println(s1_1 == s2_1);
		
		String s1_2 = "abc";
		StringBuffer s2_2 = new StringBuffer(s1);
		System.out.println(s1_2.equals(s2_2));

	}

}
