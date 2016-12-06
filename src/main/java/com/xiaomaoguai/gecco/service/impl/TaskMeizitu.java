package com.xiaomaoguai.gecco.service.impl;

import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.spring.SpringPipelineFactory;
import com.xiaomaoguai.gecco.common.utils.SpringContextUtil;
import com.xiaomaoguai.gecco.entity.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 说明 :
 * 作者 : WeiHui.jackson
 * 日期 : 2016/4/27 16:26
 * 版本 : 1.0.0
 */
@Service
public class TaskMeizitu  implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println("任务名称 = [" + scheduleJob.getName() + "]" + " 在 " + dateFormat.format(new Date()) + " 时运行");

        SpringPipelineFactory springPipelineFactory = SpringContextUtil.getBean("springPipelineFactory");

        //HttpGetRequest start = new HttpGetRequest("http://www.meizitu.com/");
        HttpGetRequest start = new HttpGetRequest("http://www.qichacha.com/search_index?key=%E6%B8%A9%E5%B7%9E%2C&index=0&statusCode=&registCapiBegin=&registCapiEnd=&sortField=&isSortAsc=&province=ZJ&startDateBegin=&startDateEnd=&cityCode=3&industryCode=&subIndustryCode=&tel=&email=&ajaxflag=true&p=1");
        start.setCharset("GBK");
        start.addCookie("_uab_collina","148066504263231145906176");
        start.addCookie("gr_user_id","92246a29-2e24-4d78-9e63-dbfc68f66225");
        start.addCookie("_umdata","2BA477700510A7DFBD405A9C7087136BBBCBF918250EB679A20BE75775611806CDC8A3E5B8C6D04CC94DC2314D10720904B02BDD0BB40B37D377B776CDBC2C92716F27C7A212F97A002F8B96EB31F59DFB114D9E23775EE0506D3ECB294101DAEEA6B27956624A9D");
        start.addCookie("PHPSESSID","g12is8q0ihhlt8492cqleqvg22");
        start.addCookie("CNZZDATA1254842228","853215651-1480660732-^%^7C1480660732");
        start.addCookie("gr_session_id_9c1eb7420511f8b2","80d78fb5-04c7-451d-8f0c-e08906c19c04");
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