package Entity;

public class SponsoredProvider {
    public String first_Name;
    public String last_Name;
    public String speciality;
    public int providerId;
    public int providerRating;
    public String providerImage;
    
    public SponsoredProvider(){
        
    }
    public SponsoredProvider(int providerId ,String first_Name , String last_Name , String speciality , String providerImage , int providerRating){
        this.providerId=providerId;
        this.first_Name=first_Name;
        this.last_Name=last_Name;
        this.speciality=speciality;
        this.providerImage=providerImage;
        this.providerRating=providerRating;
    }
    public String getfirst_Name(){
       return first_Name;
    }
    
    public String getLast_Name(){
        return last_Name;
    }
    
    public String getSpeciality(){
        return speciality;
    }
    
    public int getProviderRating(){
        return providerRating;
    }
    
    public int getProviderId(){
        return providerId;
    }
    
    public void setProviderId(int providerId){
        this.providerId=providerId;
    }
    
    public void setProviderRating(int providerRating){
        this.providerRating=providerRating;
    }
    
    public void setfirst_Name(String first_Name){
        this.first_Name=first_Name;
    }
    
    public void setlast_Name(String last_Name){
        this.last_Name=last_Name;
    }
    
    public void setSpeciality(String speciality){
        this.speciality=speciality;
    }
    
   
    
    
    
}
