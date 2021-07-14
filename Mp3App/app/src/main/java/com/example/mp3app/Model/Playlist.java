package com.example.mp3app.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Playlist implements Serializable {

@SerializedName("Idplaylist")
@Expose
private String idplaylist;
@SerializedName("Namelaylist")
@Expose
private String namelaylist;
@SerializedName("Hinhanhlaylist")
@Expose
private String hinhanhlaylist;
@SerializedName("Iconplaylist")
@Expose
private String iconplaylist;

public String getIdplaylist() {
return idplaylist;
}

public void setIdplaylist(String idplaylist) {
this.idplaylist = idplaylist;
}

public String getNamelaylist() {
return namelaylist;
}

public void setNamelaylist(String namelaylist) {
this.namelaylist = namelaylist;
}

public String getHinhanhlaylist() {
return hinhanhlaylist;
}

public void setHinhanhlaylist(String hinhanhlaylist) {
this.hinhanhlaylist = hinhanhlaylist;
}

public String getIconplaylist() {
return iconplaylist;
}

public void setIconplaylist(String iconplaylist) {
this.iconplaylist = iconplaylist;
}

}