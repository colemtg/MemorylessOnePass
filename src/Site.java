public class Site {
    private final String name;
    private final int minLength;
    private final int maxLength;
    private final boolean specialChar;
    private final boolean number;
    private final boolean capital;
    private final int defaultMinLength = 6;
    private final int getDefaultMaxLength = 8;

    public Site(String name, int minLength, int maxLength, boolean specialChar, boolean number, boolean capital) {
        this.name = name;
        if(minLength>maxLength || minLength<defaultMinLength)
        {
            this.minLength=defaultMinLength;
            this.maxLength=getDefaultMaxLength;
        }
        else
        {
            this.minLength = minLength;
            this.maxLength = maxLength;
        }
        this.specialChar = specialChar;
        this.number = number;
        this.capital = capital;
    }

    public String getName() {
        return name;
    }

    public int getMinLength() {
        return minLength;
    }

    public int getMaxLength() {
        return maxLength;
    }

    public boolean isSpecialChar() {
        return specialChar;
    }

    public boolean isNumber() {
        return number;
    }

    public boolean isCapital() {
        return capital;
    }
}
