
public class Factorial {

	public int fact(int n) {
		
		int f = 1;
		
		for(int i = n; i >= 1; i --)
			f = f * i;
		return f;
	}
}
