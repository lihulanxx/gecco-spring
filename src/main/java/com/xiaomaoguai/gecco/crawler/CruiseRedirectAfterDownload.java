package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.annotation.GeccoClass;
import com.geccocrawler.gecco.downloader.AfterDownload;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.response.HttpResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 12/2/2016.
 */
//@Service
@GeccoClass(CorpList.class)
public class CruiseRedirectAfterDownload implements AfterDownload {

    @Override
    public void process(HttpRequest request, HttpResponse response) {
        String s =StringUtils.replace( response.getContent(),"<em>","");
        s=StringUtils.replace(s,"</em>","");
        response.setContent(s);
        //System.out.println(s);
    }

}
