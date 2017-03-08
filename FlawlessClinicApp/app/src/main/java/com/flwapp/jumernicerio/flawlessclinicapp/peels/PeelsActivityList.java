package com.flwapp.jumernicerio.flawlessclinicapp.peels;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;

/**
 * Created by Jumer Nicerio on 3/21/2016.
 */
public class PeelsActivityList  extends BaseActivity {

    public PeelsActivityList(int image_id,int image_id_details,String header, String titles, String prices, String contents)
    {
        this.setHeader(header);
        this.setImage_id(image_id);
        this.setImage_id_details(image_id_details);
        this.setTitles(titles);
        this.setPrices(prices);
        this.setContents(contents);
    }

    private int image_id,image_id_details;
    private String header,titles,prices,contents;

    public String getHeader() {return header;}

    public void setHeader(String header) {this.header = header;}

    public int getImage_id() {return image_id;}

    public void setImage_id(int image_id) {this.image_id = image_id;}

    public int getImage_id_details() {return image_id_details;}

    public void setImage_id_details(int image_id_details) {this.image_id_details = image_id_details;}

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
