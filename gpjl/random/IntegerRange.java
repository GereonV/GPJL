package gpjl.random;

public class IntegerRange {

    private int min;
    private int max;

    public IntegerRange(int min, int max) throws InvalidRangeException {
        if(getRangeSize(min, max) < 1)
            throw new InvalidRangeException("The specified Range is invalid, because the max-Value is lower than the min-Value.");
        this.min = min;
        this.max = max;
    }

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

    public int getRangeSize() {
        return getRangeSize(min, max);
    }

    private int getRangeSize(int min, int max) {
        return max - min + 1;
    }

    public int getMin() {
        return min;
    }

    public boolean setMin(int min) throws InvalidRangeException {
        if(getRangeSize(min, max) < 1)
            return false;
        this.min = min;
        return true;
    }

    public int getMax() {
        return max;
    }

    public boolean setMax(int max) throws InvalidRangeException {
        if(getRangeSize(min, max) < 1)
            return false;
        this.max = max;
        return true;
    }

}
