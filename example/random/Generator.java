package example.random;

import gpjl.random.IntegerGenerator;
import gpjl.random.IntegerRange;
import gpjl.random.InvalidRangeException;

public class Generator {

    public static void main(String[] args) throws InvalidRangeException {
        IntegerGenerator random = new IntegerGenerator(new IntegerRange(1, 3));
        for(int i = 0; i < 6; i++)
            System.out.println(random.nextInt(true));
        for(int i = 0; i < 5; i++)
            System.out.println(random.nextInt(false));
        for(int i = 0; i < 6; i++)
            System.out.println(random.nextInt(true));
    }
    
}
