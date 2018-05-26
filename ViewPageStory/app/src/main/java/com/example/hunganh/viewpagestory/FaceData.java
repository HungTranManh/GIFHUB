package com.example.hunganh.viewpagestory;

public class FaceData {
    private int idImageFace;
    private Boolean Click;
    private String nameFace;

    public FaceData(int idImageFace, Boolean click, String nameFace) {
        this.idImageFace = idImageFace;
        Click = click;
        this.nameFace = nameFace;
    }

    public int getIdImageFace() {
        return idImageFace;
    }

    public void setIdImageFace(int idImageFace) {
        this.idImageFace = idImageFace;
    }

    public Boolean getClick() {
        return Click;
    }

    public void setClick(Boolean click) {
        Click = click;
    }

    public String getNameFace() {
        return nameFace;
    }

    public void setNameFace(String nameFace) {
        this.nameFace = nameFace;
    }
}
