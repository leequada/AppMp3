package com.example.mp3app.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Song implements Parcelable {

@SerializedName("Idbaihat")
@Expose
private String idbaihat;
@SerializedName("Tenbaihat")
@Expose
private String tenbaihat;
@SerializedName("Casi")
@Expose
private String casi;
@SerializedName("Hinhbaihat")
@Expose
private String hinhbaihat;
@SerializedName("Linkbaihat")
@Expose
private String linkbaihat;
@SerializedName("Likebaihat")
@Expose
private String likebaihat;

    protected Song(Parcel in) {
        idbaihat = in.readString();
        tenbaihat = in.readString();
        casi = in.readString();
        hinhbaihat = in.readString();
        linkbaihat = in.readString();
        likebaihat = in.readString();
    }

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };

    public String getIdbaihat() {
return idbaihat;
}

public void setIdbaihat(String idbaihat) {
this.idbaihat = idbaihat;
}

public String getTenbaihat() {
return tenbaihat;
}

public void setTenbaihat(String tenbaihat) {
this.tenbaihat = tenbaihat;
}

public String getCasi() {
return casi;
}

public void setCasi(String casi) {
this.casi = casi;
}

public String getHinhbaihat() {
return hinhbaihat;
}

public void setHinhbaihat(String hinhbaihat) {
this.hinhbaihat = hinhbaihat;
}

public String getLinkbaihat() {
return linkbaihat;
}

public void setLinkbaihat(String linkbaihat) {
this.linkbaihat = linkbaihat;
}

public String getLikebaihat() {
return likebaihat;
}

public void setLikebaihat(String likebaihat) {
this.likebaihat = likebaihat;
}

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(idbaihat);
        dest.writeString(tenbaihat);
        dest.writeString(casi);
        dest.writeString(hinhbaihat);
        dest.writeString(linkbaihat);
        dest.writeString(likebaihat);
    }
}