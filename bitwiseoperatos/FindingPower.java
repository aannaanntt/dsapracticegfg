package bitwiseoperatos;

public class FindingPower {
	
	public static void main(String[] args) {
		
		int base =3;
		int power =6;
		int ans =1;
		while(power>0) {
			int lastDigit = power & 1;
			if(lastDigit ==1) {
				ans *=  base;
			}
			
			base *=base;
			power = power >>1;
			
			
		}
		System.out.println(ans);
		
	}

}
