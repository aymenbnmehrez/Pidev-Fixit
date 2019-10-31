/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author Koala girl
 */
public class ClientComment {
    private String  AdsName;
    private String  clientFirstname;
    private String  clientLastname;
    private String comment;
    private  int adId;
    private  int CommentId;
    private int provider_id;

    public int getCommentId() {
        return CommentId;
    }

    public void setCommentId(int CommentId) {
        this.CommentId = CommentId;
    }

    public int getProvider_id() {
        return provider_id;
    }

    public void setProvider_id(int provider_id) {
        this.provider_id = provider_id;
    }
    

    public String getClientFirstname() {
        return clientFirstname;
    }

    public void setClientFirstname(String clientFirstname) {
        this.clientFirstname = clientFirstname;
    }

    public ClientComment(String AdsName, String clientFirstname, String clientLastname, String comment) {
        this.AdsName = AdsName;
        this.clientFirstname = clientFirstname;
        this.clientLastname = clientLastname;
        this.comment = comment;
    }

    public String getClientLastname() {
        return clientLastname;
    }

    public void setClientLastname(String clientLastname) {
        this.clientLastname = clientLastname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ClientComment(String clientFirstname, String clientLastname, String comment) {
        this.clientFirstname = clientFirstname;
        this.clientLastname = clientLastname;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "ClientComment{" + "client=" + clientFirstname  + clientLastname + ", comment=" + comment + '}';
        
    }
    public String getAdsName() {
        return AdsName;
    }

    public void setAdsName(String AdsName) {
        this.AdsName = AdsName;
    }

    public int getAdId() {
        return adId;
    }

    public void setAdId(int adId) {
        this.adId = adId;
    }

    public ClientComment(String AdsName, String clientFirstname, String clientLastname, String comment, int adId) {
        this.AdsName = AdsName;
        this.clientFirstname = clientFirstname;
        this.clientLastname = clientLastname;
        this.comment = comment;
        this.adId = adId;
    }

    public ClientComment(String AdsName, String clientFirstname, String clientLastname, String comment, int adId, int CommentId,int provider_id) {
        this.AdsName = AdsName;
        this.clientFirstname = clientFirstname;
        this.clientLastname = clientLastname;
        this.comment = comment;
        this.adId = adId;
        this.CommentId = CommentId;
        this.provider_id = provider_id;
    }
    
}
