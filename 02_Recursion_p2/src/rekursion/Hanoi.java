/*
 * 
 */
package rekursion;

/**
 * @author mad
 */
public class Hanoi {

	public static void flyt(int n, int fra, int til){
		if (n==1) {
			System.out.println("Flyt fra " +fra +" til " + til);

		}
		else {
			int temp = 6 - fra - til;
			flyt(n-1,fra,temp);
			System.out.println("Flyt fra " + fra +" til " + til);
			flyt(n-1,temp,til);
		}
	}

	// antal flytninger er 2^(n) - 1
	public static int antalFlytninger(int n, int fra, int til){
		if (n==1) {
			return 1;
		}
		else {
			int temp = 6 - fra - til;
			return antalFlytninger(n - 1, fra, temp) + antalFlytninger(n - 1, temp, til) + 1;
		}
	}
	public static void main(String[] args) {
		flyt(4,1,3);
		System.out.println(antalFlytninger(4, 1, 3));
		
	}
}
