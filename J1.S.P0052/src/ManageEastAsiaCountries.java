import java.util.*;
public class ManageEastAsiaCountries {
    private ArrayList<EastAsiaCountries> countryList = new ArrayList<>();
    
    public void addCountryInformation(EastAsiaCountries country) throws Exception{
        countryList.add(country);
    }
    
    private int searchIndex = 0;
    public EastAsiaCountries getRecentlyEnteredInformation() throws Exception{
        return countryList.get(searchIndex);
    }
    
    public void displayCountry() throws Exception{
        searchIndex = 0;
        for (EastAsiaCountries eastAsiaCountries : countryList) {
            getRecentlyEnteredInformation().display();
            searchIndex++;
        }
    }
    
    public ManageEastAsiaCountries searchInformationByName (String name) throws Exception{
        ManageEastAsiaCountries eas = new ManageEastAsiaCountries();
        boolean check = true;
        for (EastAsiaCountries ea : countryList) {
            if(ea.getCountryName().contains(name)){
                eas.addCountryInformation(ea);
                check = false;
            }
        }
        if(check) return null;
        return eas;
    }
    
    public ManageEastAsiaCountries sortInformationByAscendingOrder() throws Exception{
        Collections.sort(countryList, new Comparator<EastAsiaCountries>() {
            @Override
            public int compare(EastAsiaCountries o1, EastAsiaCountries o2) {
                return o1.getCountryName().compareTo(o2.getCountryName());
            }
        });
        ManageEastAsiaCountries meas = new ManageEastAsiaCountries();
        for (EastAsiaCountries ea : countryList) {
            meas.addCountryInformation(ea);
        }
        return meas;
    }
    
    public void displayAllCountry(){
        for (EastAsiaCountries eas : countryList) {
            eas.display();
        }
    }
    
    public boolean checkEmptyList(){
        if(countryList.isEmpty()) return true;
        else return false;
    }
}