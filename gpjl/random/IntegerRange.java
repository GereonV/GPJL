package gpjl.random;

/**
 * The {@code IntegerRange} represents a Range of Integer between a min-Value and a max-Value.
 * Recommended use is to using {@code min} and {@code max} inclusively.
 * 
 * @author  Gereon
 * @since   0.3
 * @version 1.0
 */
public class IntegerRange {

    /**
     * The min-Value.
     */
    private int min;

    /**
     * The max-Value.
     */
    private int max;

    /**
     * Initializes the min-Value and max-Value.
     * 
     * @param min the min-Value
     * @param max the max-Value
     * @throws InvalidRangeException if the max-Value is smaller than the min-Value
     */
    public IntegerRange(int min, int max) throws InvalidRangeException {
        if(getRangeSize(min, max) < 1)
            throw new InvalidRangeException("The specified Range is invalid, because the max-Value is lower than the min-Value.");
        this.min = min;
        this.max = max;
    }

    /**
     * Compares two IntegerRanges and ignoring {@code null}s.
     * 
     * @param obj the possibly equal {@code Object}
     * @return {@code true} if either they are the same object or equal by Value
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(this == obj)
            return true;
        if(obj.getClass() == getClass()) {
            IntegerRange range = (IntegerRange) obj;
            return range.min == min && range.max == max;
        }
        return false;
    }

    /**
     * Getter for the possible Integers in Range.
     * 
     * @return the total Range of this {@code IntegerRange}
     */
    public int getRangeSize() {
        return getRangeSize(min, max);
    }

    /**
     * Calculates possible Integers in Range.
     * 
     * @param min the min-Value
     * @param max the max-Value
     * @return {@code max - min + 1}
     */
    private int getRangeSize(int min, int max) {
        return max - min + 1;
    }

    /**
     * Getter for the min-Value.
     * 
     * @return the min-Value
     */
    public int getMin() {
        return min;
    }

    /**
     * Setter for the min-Value.
     * 
     * @param min the new min-Value
     * @return whether the new min-Value was valid
     */
    public boolean setMin(int min) {
        if(getRangeSize(min, max) < 1)
            return false;
        this.min = min;
        return true;
    }

    /**
     * Getter for the max-Value.
     * 
     * @return the max-Value
     */
    public int getMax() {
        return max;
    }

    /**
     * Setter for the max-Value.
     * 
     * @param max the new max-Value
     * @return whether the new max-Value was valid
     */
    public boolean setMax(int max) {
        if(getRangeSize(min, max) < 1)
            return false;
        this.max = max;
        return true;
    }

}
