package Entity;

public class SponsoredAd {
    public String adName;
    public String introText;
    public String destinationURL;
    public String adImage;
    private int sponsoredId;
    private int sponsoredAdId;
    
    public SponsoredAd(){
    }
    
    public SponsoredAd(int sponsoredId ,String adName , String introText , String destinationURL , String adImage ){
    
        this.adName =adName;
        this.introText= introText;
        this.destinationURL=destinationURL;
        this.adImage=adImage;
        this.sponsoredId=sponsoredId; //this is the id of the sponsored provider
    }
    
    
    public void SponsoredAd(int sponsoredId, String destinationURL){
        this.sponsoredId=sponsoredId;
        this.destinationURL=destinationURL;
    }
    
    
    public void SponosredAd(int sponsoredId, String adName , String destinationURL, String adImage){
        this.sponsoredId=sponsoredId;
        this.adName=adName;
        this.destinationURL=destinationURL;
        this.adImage=adImage;
    }
    
    
    public void sponsoredAd( int sponsoredId , String destinationURL , String adImage){
        this.sponsoredId=sponsoredId;
        this.destinationURL=destinationURL;
        this.adImage=adImage;
    }
    
    public String getadName(){
    return adName;
    }
    
    public String getintroText(){
    return introText;
    }
    
    public int getsponsoredId(){
    return sponsoredId;
    }
    
    public String getadImage(){
    return adImage;
    }
    
    public int getsponsoredAdId(){
    return sponsoredAdId;
    }
    
    public void setsponsoredId(int sponsoredId)
    {
    this.sponsoredId=sponsoredId;
    }
    
     public void setsponsoredAdId(int sponsoredAdId){
         this.sponsoredAdId=sponsoredAdId;
    }
     
    public void setadImage(String adImage){
        this.adImage=adImage;
    }
    
    public void setintroText(String introText){
        this.introText=introText;
    }
    
    public void setdestinationURL(String destinationURL){
        this.destinationURL=destinationURL;
    }
     public String getdestinationURL(){
         return destinationURL;
     }
    }
    
    
