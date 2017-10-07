package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.annotation.*;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.HtmlBean;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.sun.javafx.geom.Path2D;
import com.xiaomaoguai.gecco.common.utils.SpringContextUtil;

import java.util.List;

/**
 * Created by Administrator on 2016/12/2.
 */

@Gecco(matchUrl = "http://www.qichacha.com/search_index?key={key}&index=0&statusCode={statusCode}&registCapiBegin={registCapiBegin}&registCapiEnd={registCapiEnd}&sortField={sortField}&isSortAsc={isSortAsc}&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p={p}", pipelines = { "consolePipeline", "bigCorpPipeline" })
public class CorpList implements HtmlBean {
    private static final long serialVersionUID =665662335318691812L;

    @Request
    private HttpRequest request;

    @RequestParameter("key")
    private String keyWord;

    @HtmlField(cssPath="#searchlist > table > tbody > tr")
    private List<CorpDetail> list;

    /*@Text
    @HtmlField(cssPath="body > div.text-left.m-t-lg.m-b-lg > ul > li.active > a")*/
    @RequestParameter("p")
    private int currPage;

    @Text
    @HtmlField(cssPath = "#countOld > span:nth-child(1)")
    private int count;

    @Override
    public String toString() {
        return "CorpList{" +
                "list=" + list +
                ", currPage=" + currPage +
                '}';
    }
    public int getCurrPage() {
        return currPage;
    }
    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public List<CorpDetail> getList() {
        return list;
    }

    public void setList(List<CorpDetail> list) {
        this.list = list;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {

        SpringPipelineFactory springPipelineFactory = SpringContextUtil.getBean("springPipelineFactory");
        //龙港
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E9%BE%99%E6%B8%AF%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //柳市镇
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E6%9F%B3%E5%B8%82%E9%95%87%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //乐成镇
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E4%B9%90%E6%88%90%E9%95%87%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //虹桥镇
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E8%99%B9%E6%A1%A5%E9%95%87%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //钱库
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E9%92%B1%E5%BA%93%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //金乡
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E9%87%91%E4%B9%A1%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=20&registCapiBegin=&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //平阳注册资本
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E5%B9%B3%E9%98%B3%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=20&registCapiBegin=1000&registCapiEnd=5000&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //泰顺县
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E6%B3%B0%E9%A1%BA%E5%8E%BF%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=20&registCapiBegin=5000&registCapiEnd=&sortField=&isSortAsc=&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //瓯海区
        //HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E7%93%AF%E6%B5%B7%E5%8C%BA%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=20&registCapiBegin=5000&registCapiEnd=&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");

        //瑞安市
        HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E7%91%9E%E5%AE%89%E5%B8%82%2C%E5%85%AC%E5%8F%B8&index=0&statusCode=20&registCapiBegin=1&registCapiEnd=499&sortField=startdate&isSortAsc=false&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");


        //


        //
        start.setCharset("GBK");
        start.addCookie("_uab_collina","148066504263231145906176");
        start.addCookie("gr_user_id","92246a29-2e24-4d78-9e63-dbfc68f66225");
        start.addCookie("_umdata","2BA477700510A7DFBD405A9C7087136BBBCBF918250EB679A20BE75775611806CDC8A3E5B8C6D04CC94DC2314D10720904B02BDD0BB40B37D377B776CDBC2C92716F27C7A212F97A9210A7C005CE7E073C2C3BB80124BC6C796AE16874D0061B");
        start.addCookie("PHPSESSID","t6drjduie99ijoa6f9ur9fqst2");
        start.addCookie("CNZZDATA1254842228","853215651-1480660732-%7C1480993071");
        start.addCookie("gr_session_id_9c1eb7420511f8b2","f6da0e24-ce3e-4717-98dd-b2042166715a");
        GeccoEngine.create()
                .pipelineFactory(springPipelineFactory)
                .classpath("com.xiaomaoguai.gecco.crawler")
                .start(start)
                .thread(1)
                .interval(15000)
                .loop(false)
                .start();
    }
}
