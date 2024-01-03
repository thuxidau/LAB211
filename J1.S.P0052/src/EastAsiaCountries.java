public class EastAsiaCountries extends Country{
    String countryTerrain;

    public EastAsiaCountries() {
    }

    public String getCountryTerrain() {
        return countryTerrain;
    }

    public void setCountryTerrain(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryTerrain) {
        this.countryTerrain = countryTerrain;
    }

    public EastAsiaCountries(String countryCode, String countryName, double totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }
    
    public EastAsiaCountries createCountry(){
        Validation Validation = new Validation();
    
        System.out.print("Enter code of country: ");
        setCountryCode(Validation.checkInputString());
        
        System.out.print("Enter name of country: ");
        setCountryName(Validation.checkInputString());
        
        System.out.print("Enter total area: ");
        setTotalArea(Validation.checkInputDouble());
        
        System.out.print("Enter terrain of country: ");
        setCountryTerrain(Validation.checkInputString());
        
        return new EastAsiaCountries(countryCode, countryName, totalArea, countryTerrain);
    }
    
    @Override
    public void display() {
        super.display(); 
        System.out.printf("%-15s\n", countryTerrain);
    }
}
