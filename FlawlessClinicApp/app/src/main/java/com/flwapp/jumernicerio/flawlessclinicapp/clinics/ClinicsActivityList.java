package com.flwapp.jumernicerio.flawlessclinicapp.clinics;

import com.flwapp.jumernicerio.flawlessclinicapp.BaseActivity;

/**
 * Created by Jumer Nicerio on 3/11/2016.
 */
public class ClinicsActivityList extends BaseActivity{

    public ClinicsActivityList (int image_id,String title,String header,String content)
    {
        this.setHeader(header);
        this.setImage_id(image_id);
        this.setTitles(title);
        this.setContent(content);
    }

    private int image_id;
    private String title,header,content;

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }


    public String getTitles() {
        return title;
    }

    public void setTitles(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
