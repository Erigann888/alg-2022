import java.util.Arrays;
import java.util.Random;

public class Main {

    public static final int ARRAY_SIZE = 50000;

    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[ARRAY_SIZE];
        int lo=0;
        int li=array.length-1;
        int[] checkArray = new int[ARRAY_SIZE];

        for(int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }

        System.arraycopy(array, 0, checkArray, 0, ARRAY_SIZE);
        System.out.println("Start user sort");
        long time = System.currentTimeMillis();
        sort(array, lo, li);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis()-time) / 1000d);
        System.out.println("Start java lib sort");
        time = System.currentTimeMillis();
        Arrays.sort(checkArray);
        System.out.format("sorted: %.3f seconds\r\n", (System.currentTimeMillis()-time) / 1000d);
        System.out.println("Check result");
        for(int i = 0; i < array.length; i++) {
            if(array[i] != checkArray[i]) {
                throw new RuntimeException("Error in index: "+i);
            }
        }
        System.out.println("OK");
    }

    public static void sort(int[] array, int lo, int li) {
    	
    	
    	 if (li <= lo)
    	        return;
    	    int mid = lo + (li - lo) / 2;
    	    sort(array, lo, mid);
    	    sort(array, mid + 1, li);

    	    int[] buf = Arrays.copyOf(array, array.length);

    	    for (int k = lo; k <= li; k++)
    	        buf[k] = array[k];

    	    int i = lo, j = mid + 1;
    	    for (int k = lo; k <= li; k++) {

    	        if (i > mid) {
    	            array[k] = buf[j];
    	            j++;
    	        } else if (j > li) {
    	            array[k] = buf[i];
    	            i++;
    	        } else if (buf[j] < buf[i]) {
    	            array[k] = buf[j];
    	            j++;
    	        } else {
    	            array[k] = buf[i];
    	            i++;
    	        }
    	    }
        }
    }
