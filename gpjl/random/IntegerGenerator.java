package gpjl.random;

import java.util.Random;

public class IntegerGenerator {

    private IntegerRange range;
    private Random random;
    private boolean[] storedInts;

    public IntegerGenerator(IntegerRange range) {
        this.range = range;
        random = new Random();
    }

    public IntegerGenerator(IntegerRange range, long seed) {
        this.range = range;
        random = new Random(seed);
    }

    public IntegerGenerator(IntegerRange range, Random random) {
        this.range = range;
        this.random = random;
    }

    public boolean isFull() {
        for(boolean b : storedInts)
            if(!b)
                return false;
        return true;
    }

    public int nextInt(boolean avoidDoubling) {
        int rangeSize = range.getRangeSize();
        if(avoidDoubling && (storedInts.length != rangeSize || isFull()))
            resetInts();
        int randomNumber = 0;
        do {
            randomNumber = random.nextInt(rangeSize);
        } while(avoidDoubling && storedInts[randomNumber]);
        storedInts[randomNumber] = true;
        return randomNumber + range.getMin();
    }

    public void resetInts() {
        storedInts = new boolean[range.getMax() - range.getMin() + 1];
    }

    public IntegerRange getRange() {
        return range;
    }

    public void setRange(IntegerRange range) {
        this.range = range;
    }
    
}
