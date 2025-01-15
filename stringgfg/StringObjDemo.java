package stringgfg;

public class StringObjDemo {
	
	
	public static void main(String[] args) {
		String s1 = "Anant";
		String s2 = s1;
		s1="Mishra";
		
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
	}
}
