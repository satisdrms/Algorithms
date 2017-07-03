package string_work;

public class str_sort implements Comparable<str_sort> {

	String s;

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public int compareTo(str_sort s) {
		return  Integer.parseInt(this.s)-Integer.parseInt(s.getS()) ;

	}

}
