import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import org.apache.commons.lang3.ArrayUtils;

public class properties {
	
	public static  int squareIt(int x) {
		   return x * x;
		}


	public int[] billify(int[] x) {
	    int	length = x.length;
		for(int a = 0; a< length; a++) {
			x[a] = squareIt(x[a]);
		}
		int sum = IntStream.of(x).sum();
		x = ArrayUtils.add(x, sum);
		return x;
	}
	
	public int[] randomarr() {
		Random r = new Random();
		int range = r.nextInt(100) + 1;
		int [] ranarr=new int[range];
		for ( int a = 0; a< ranarr.length; a++) {
			ranarr[a] = r.nextInt(100) + 1;
		}
		System.out.println(Arrays.toString(ranarr));
		return ranarr;
		
	}
	
	
}
