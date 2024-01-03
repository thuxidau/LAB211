package changebasenumber;
public class Number {
    private String value;
    private int base;

    public Number(String value, int base) {
        if(!checkValid(value, base)){
            throw new IllegalArgumentException("loi");}
        this.value = value;
        this.base = base;
    }
    
    private boolean checkValid(String value, int base){
        for (char c : value.toCharArray()) {
            if(Character.digit(c, base) < 0) {return false;}
        }
        return true;
    }
    
    public String conversion(int outputBase){
        long decimalValue = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(value.length() - 1 - i);
            int digit = Character.digit(c, base);
            decimalValue += digit * Math.pow(base, i);
        }
        StringBuilder result = new StringBuilder();
        while(decimalValue > 0){
            int newDigit = (int) (decimalValue % outputBase);
            result.insert(0, Character.forDigit(newDigit, outputBase));
            decimalValue /= outputBase;
        }
        return result.toString();
    }
}
