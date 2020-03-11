package utils.TestDataManagement;

public class FiscalInformationData {
    private String vendorName; //optional
    public String getVendorName(){return this.vendorName;}
    public void setVendorName(String value){this.vendorName = value;}

    private String streetNumber;// optional
    public String getStreetNumber(){return this.streetNumber;}
    public void setStreetNumber(String value){this.streetNumber = value;}

    private String streetName;//optional
    public String getStreetName(){return this.streetName;}
    public void setStreetName(String value){this.streetName = value;}

    private String cityName;//optional
    public String getCityName(){return this.cityName;}
    public void setCityName(String value){this.cityName = value;}

    private String siretNumber;//mandatory, require 14 chars
    public String getSiretNumber(){return this.siretNumber;}
    public void setSiretNumber(String value){this.siretNumber = value;}

    private String nafNumber;//mandatory, require 5 chars
    public String getNafNumber(){return this.nafNumber;}
    public void setNafNumber(String value){this.nafNumber = value;}

    private String tvaNumber;//mandatory, require 13 chars
    public String getTvaNumber(){return this.tvaNumber;}
    public void setTvaNumber(String value){ this.tvaNumber = value;}

}
