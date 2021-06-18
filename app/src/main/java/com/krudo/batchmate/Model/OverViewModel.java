package com.krudo.batchmate.Model;

public class OverViewModel {
    private String cName,tName,objOne,objTwo,objThree,url;

    public OverViewModel() {
    }

    public OverViewModel(String cName, String tName, String objOne, String objTwo, String objThree, String url) {
        this.cName = cName;
        this.tName = tName;
        this.objOne = objOne;
        this.objTwo = objTwo;
        this.objThree = objThree;
        this.url = url;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getObjOne() {
        return objOne;
    }

    public void setObjOne(String objOne) {
        this.objOne = objOne;
    }

    public String getObjTwo() {
        return objTwo;
    }

    public void setObjTwo(String objTwo) {
        this.objTwo = objTwo;
    }

    public String getObjThree() {
        return objThree;
    }

    public void setObjThree(String objThree) {
        this.objThree = objThree;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
