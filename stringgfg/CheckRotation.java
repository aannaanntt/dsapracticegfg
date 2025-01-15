package stringgfg;

public class CheckRotation {

	public static void main(String[] args) {
		String str1 = "ABCD";
		String str2 ="CDAB";
		
		System.out.println(isRotation(str1,str2));
	}

	private static boolean isRotation(String str1, String str2) {
		if(str1.length() != str2.length()) {
			return false;
		}
		
		return (str1 + str2).indexOf(str2) > 0;
		
	}
}
