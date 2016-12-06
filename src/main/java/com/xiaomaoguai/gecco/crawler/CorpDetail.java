package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

/**
 * Created by Administrator on 2016/12/2.
 */
public class CorpDetail implements HtmlBean {

    private static final long serialVersionUID = 3018760488621382653L;

    private String id;


    @RequestParameter("key")
    private String keyWord;

    @Text
    @HtmlField(cssPath="td.tp2 > span > a")
    private String corpName;

    @Text
    @HtmlField(cssPath="td.tp2 > small:nth-child(2) > span")
    private String name;

    @Text
    @HtmlField(cssPath="td.tp2 > small:nth-child(4) > small")
    private String title;

    @Text
    @HtmlField(cssPath = "td.tp3.text-center")
    private String capital;

    @Text
    @HtmlField(cssPath = "td.tp4.text-center")
    private String date;

    @Text
    @HtmlField(cssPath = "td.tp5.text-center > a > span")
    private String state;


    public String getCorpName() {
        return corpName;
    }

    public void setCorpName(String corpName) {
        this.corpName = corpName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public String toString() {
        return "CorpDetail{" +
                "corpName='" + corpName + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", capital='" + capital + '\'' +
                ", date='" + date + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

}
