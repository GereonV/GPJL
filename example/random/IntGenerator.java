package example.random;

import gpjl.random.IntegerGenerator;
import gpjl.random.IntegerRange;
import gpjl.random.InvalidRangeException;

public class IntGenerator {

    public static void main(String[] args) throws InvalidRangeException {
        IntegerGenerator random = new IntegerGenerator(new IntegerRange(1, 3)); //creates a new IntegerGenerator-Object
        for(int i = 0; i < 6; i++)
            System.out.println(random.nextInt(true));
        for(int i = 0; i < 5; i++)
            System.out.println(random.nextInt(false));
        random.getRange().setMax(6);    //change one Range-Attribute
        for(int i = 0; i < 6; i++)
            System.out.println(random.nextInt(true));
    }
    
}
