public class Country {
    protected String countryCode;
    protected String countryName;
    protected double totalArea;

    public Country() {
    }

    public Country(String countryCode, String countryName, double totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getTotalArea() {
        return totalArea;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTotalArea(double totalArea) {
        this.totalArea = totalArea;
    }

    public void display(){
        System.out.printf("%-10s%-25s%-20s", countryCode, countryName, totalArea);
    }
}