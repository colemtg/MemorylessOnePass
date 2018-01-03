public class Site {
    private final String name;
    private final int minLength;
    private final int maxLength;
    private final boolean specialChar;
    private final boolean number;
    private final boolean capital;

    public Site(String name, int minLength, int maxLength, boolean specialChar, boolean number, boolean capital) {
        this.name = name;
        this.minLength = minLength;
        this.maxLength = maxLength;
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
