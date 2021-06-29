package gpjl.random;

import java.util.Random;

/**
 * The {@code IntegerGenerator} generates pseudo-random Integers, while avoiding Duplication if requested.
 * 
 * @author  Gereon
 * @see     Random
 * @since   0.3
 * @version 1.0
 */
public class IntegerGenerator {

    /**
     * The Range of possible Integers.
     */
    private IntegerRange range;

    /**
     * A {@code Random} object, that generates the Integers.
     */
    private Random random;

    /**
     * This stores which Integers already got generated.
     */
    private boolean[] storedInts;


    /**
     * Initializes Range and produces a {@code Random} object with {@link Random#Random()}.
     * 
     * @param range the Range used for Generation
     */
    public IntegerGenerator(IntegerRange range) {
        this.range = range;
        random = new Random();
    }

    /**
     * Initializes Range and produces a {@code Random} object with {@link Random#Random(long)}.
     * 
     * @param range the Range used for Generation
     * @param seed the Seed for the {@code Random} object
     */
    public IntegerGenerator(IntegerRange range, long seed) {
        this.range = range;
        random = new Random(seed);
    }

    /**
     * Initializes Range and Random object.
     * 
     * @param range the Range used for Generation
     * @param random the Random object used for Generation
     */
    public IntegerGenerator(IntegerRange range, Random random) {
        this.range = range;
        this.random = random;
    }

    /**
     * Checks if all Integers within the Range have been generated already.
     * 
     * @return {@code true} if all {@code booleans} are true, {@code false} otherwise
     */
    public boolean isFull() {
        for(boolean b : storedInts)
            if(!b)
                return false;
        return true;
    }

    /**
     * Generates a new Integer.
     * 
     * @param avoidDoubling whether number repetition is dissallowed
     * @return a new pseudo-randomly generated Integer within Range
     */
    public int nextInt(boolean avoidDoubling) {
        int rangeSize = range.getRangeSize();
        if(avoidDoubling && (storedInts.length != rangeSize || isFull()))
            resetInts();
        int randomNumber = 0;
        do {
            randomNumber = random.nextInt(rangeSize);
        } while(avoidDoubling && storedInts[randomNumber]);
        if(avoidDoubling)
            storedInts[randomNumber] = true;
        return randomNumber + range.getMin();
    }

    /**
     * Resets the boolean array to all-{@code false} and the appropiate size.
     */
    public void resetInts() {
        storedInts = new boolean[range.getRangeSize()];
    }

    /**
     * Getter for the {@code Range} object.
     * 
     * @return {@link IntegerGenerator#range}
     */
    public IntegerRange getRange() {
        return range;
    }

    /**
     * Setter for the {@code Range} object.
     * 
     * @param range the new {@code Range} object
     */
    public void setRange(IntegerRange range) {
        this.range = range;
    }

    /**
     * Getter for the {@code Random} object.
     * 
     * @return {@link IntegerGenerator#random}
     */
    public Random getRandom() {
        return random;
    }

    /**
     * Setter for the {@code Random} object.
     * 
     * @param random the new {@code Random} object
     */
    public void setRandom(Random random) {
        this.random = random;
    }
    
}
