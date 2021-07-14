package com.example.mp3app.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chude {

@SerializedName("IDChude")
@Expose
private String iDChude;
@SerializedName("Tenchude")
@Expose
private String tenchude;
@SerializedName("Hinhanhchude")
@Expose
private String hinhanhchude;

public String getIDChude() {
return iDChude;
}

public void setIDChude(String iDChude) {
this.iDChude = iDChude;
}

public String getTenchude() {
return tenchude;
}

public void setTenchude(String tenchude) {
this.tenchude = tenchude;
}

public String getHinhanhchude() {
return hinhanhchude;
}

public void setHinhanhchude(String hinhanhchude) {
this.hinhanhchude = hinhanhchude;
}

}