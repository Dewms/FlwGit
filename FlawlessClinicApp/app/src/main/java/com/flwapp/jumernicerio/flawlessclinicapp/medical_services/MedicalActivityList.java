package com.flwapp.jumernicerio.flawlessclinicapp.medical_services;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;

/**
 * Created by Jumer Nicerio on 3/15/2016.
 */
public class MedicalActivityList extends BaseActivity {

    public MedicalActivityList(String header, String titles, String prices, String contents)
    {
        this.setHeader(header);
        this.setTitles(titles);
        this.setPrices(prices);
        this.setContents(contents);
    }

    private String header,titles,prices,contents;

    public String getHeader() {return header;}

    public void setHeader(String header) {this.header = header;}

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }
}