package com.codegym.b1ss3.model;

public class EmailSetting {
    private String language;
    private String size;
    private boolean filter;
    private String signature;

    public EmailSetting(String language, String size, boolean filter, String signature) {
        this.language = language;
        this.size = size;
        this.filter = filter;
        this.signature = signature;
    }

    public EmailSetting() {
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "EmailSetting{" +
                "language='" + language + '\'' +
                ", size='" + size + '\'' +
                ", filter=" + filter +
                ", signature='" + signature + '\'' +
                '}';
    }
}
