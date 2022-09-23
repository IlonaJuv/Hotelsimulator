package testi;

import java.util.Random;

public class Utils {
    public static int getRandomNumber(int low, int high){
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }
}
