package com.app.trep.musify;

public class RadioModel {
    private String radioName;
    private String radioUrl;

    public RadioModel(String radioName, String radioUrl) {
        this.radioName = radioName;
        this.radioUrl = radioUrl;
    }

    public String getRadioName() {
        return radioName;
    }

    public void setRadioName(String radioName) {
        this.radioName = radioName;
    }

    public String getRadioUrl() {
        return radioUrl;
    }

    public void setRadioUrl(String radioUrl) {
        this.radioUrl = radioUrl;
    }
}
