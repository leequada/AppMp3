package com.example.mp3app.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Theloai {

@SerializedName("IDtheloai")
@Expose
private String iDtheloai;
@SerializedName("IDchude")
@Expose
private String iDchude;
@SerializedName("Tentheloai")
@Expose
private String tentheloai;
@SerializedName("Hinhanhtheloai")
@Expose
private String hinhanhtheloai;

public String getIDtheloai() {
return iDtheloai;
}

public void setIDtheloai(String iDtheloai) {
this.iDtheloai = iDtheloai;
}

public String getIDchude() {
return iDchude;
}

public void setIDchude(String iDchude) {
this.iDchude = iDchude;
}

public String getTentheloai() {
return tentheloai;
}

public void setTentheloai(String tentheloai) {
this.tentheloai = tentheloai;
}

public String getHinhanhtheloai() {
return hinhanhtheloai;
}

public void setHinhanhtheloai(String hinhanhtheloai) {
this.hinhanhtheloai = hinhanhtheloai;
}

}