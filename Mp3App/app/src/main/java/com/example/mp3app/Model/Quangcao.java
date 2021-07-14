package com.example.mp3app.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Quangcao implements Serializable {

@SerializedName("idqc")
@Expose
private String idqc;
@SerializedName("image")
@Expose
private String image;
@SerializedName("content")
@Expose
private String content;
@SerializedName("idsong")
@Expose
private String idsong;
@SerializedName("namesong")
@Expose
private String namesong;
@SerializedName("imagesong")
@Expose
private String imagesong;

public String getIdqc() {
return idqc;
}

public void setIdqc(String idqc) {
this.idqc = idqc;
}

public String getImage() {
return image;
}

public void setImage(String image) {
this.image = image;
}

public String getContent() {
return content;
}

public void setContent(String content) {
this.content = content;
}

public String getIdsong() {
return idsong;
}

public void setIdsong(String idsong) {
this.idsong = idsong;
}

public String getNamesong() {
return namesong;
}

public void setNamesong(String namesong) {
this.namesong = namesong;
}

public String getImagesong() {
return imagesong;
}

public void setImagesong(String imagesong) {
this.imagesong = imagesong;
}

}