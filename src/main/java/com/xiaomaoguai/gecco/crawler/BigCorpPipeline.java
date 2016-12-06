package com.xiaomaoguai.gecco.crawler;

import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.xiaomaoguai.gecco.constant.CurrencyType;
import com.xiaomaoguai.gecco.constant.Status;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2016/12/2.
 */
//@Service
@PipelineName("bigCorpPipeline")
public class BigCorpPipeline implements Pipeline<CorpList> {

    @Override
    public void process(CorpList bean) {
        //System.out.println(bean);
        processCorpInfo(bean);

        HttpRequest currRequest = bean.getRequest();

        //下一页继续抓取
        int currPage = bean.getCurrPage();
        int nextPage = currPage + 1;
        double d=(double)bean.getCount()/(double)10;
        int totalPage = (int)(d>50?50:Math.ceil(d));
        if(nextPage <= totalPage) {
            String nextUrl;
            String currUrl = currRequest.getUrl();
            if(currUrl.contains("p")) {
                nextUrl = StringUtils.replaceOnce(currUrl, "p=" + currPage, "p=" + nextPage);
            } else {
                nextUrl = currUrl + "&" + "p=" + nextPage;
            }
            DeriveSchedulerContext.into(currRequest.subRequest(nextUrl));
        }
    }

    /**
     *  处理得到的企业列表
     *
     * @param bean 单个页面上获取的企业信息
     */
    private void processCorpInfo(CorpList bean) {
        List<CorpDetail> list=bean.getList();
        list.stream().filter(s -> s.getCorpName().endsWith("公司")).forEach(this::processDetailInfo);
    }

    /**
     * 处理获取得到的企业详细信息
     *
     * @param corpDetail 单个企业信息
     */
    private void processDetailInfo(CorpDetail corpDetail) {
        String id= UUID.randomUUID().toString().replace("-","");
        corpDetail.setId(id);

        String capital=corpDetail.getCapital();
        //获取
        String[] regCapital=getRegCap(capital);

        //String data=JSON.toJSONString(corpDetail)+",";//json格式数据
        //corpDetail.getClass().getDeclaredFields();
        //sql格式数据
        StringBuilder data =new StringBuilder("INSERT INTO comp_baseinfo(id,compName,address,startDate,status,regCapital,currencyTypeID,hostName) VALUES (")
                .append(formatSqlValue(corpDetail.getId()))
                .append(formatSqlValue(corpDetail.getCorpName()))
                .append(formatSqlValue(corpDetail.getTitle()))
                .append(formatSqlValue(corpDetail.getDate()))
                .append(formatSqlValue(getStatuesCode(corpDetail.getState())))
                .append(regCapital[0].trim()).append(",")
                .append(formatSqlValue(getCurrencyCode(regCapital[1]).trim()))
                .append("'").append(corpDetail.getName()).append("'")
                .append(")  ON DUPLICATE KEY UPDATE createTime=createTime;");

        try {
            String s= URLDecoder.decode(corpDetail.getKeyWord(),"utf-8");
            Path path = Paths.get("d:/" + s + ".sql");
            if (!(Files.exists(path))){
                 //content= StringUtils.replace(Files.readAllLines(Paths.get("d:/"+s+".json"), Charset.defaultCharset()).toString(),"]","")+JSON.toJSONString(corpDetail)+",";
                Files.createFile(path);
            }


            //System.out.println(data);
            //Files类普通流写文件
           // OutputStream writer = Files.newOutputStream(Paths.get("d:/"+s+".json"));
            //writer.write(data.getBytes(),0, data.length());

            //使用FileOutputStream,有中文会乱码,解决方法是使用OutputStreamWriter将字节流转换为字符流写入，同时指定utf-8编码。
            OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream(new File("d:/"+s+".sql"), true),"utf-8");
            BufferedWriter bufw= new BufferedWriter(oStreamWriter);
            bufw.append(data);
            bufw.newLine();
            bufw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] getRegCap(String capital) {
        String[] regCapital={"null","null"};
        if(capital.contains("万元")){
            //regCapital.split();
            regCapital= StringUtils.split(capital,"万元");
        }else if(capital.contains("万")){
            regCapital=StringUtils.split(capital,"万");
        }
        return regCapital;
    }

    public static void main(String[] args) {
        //System.out.println(StringUtils.split("10万元人民币","万元")[1]);
        final char c='d';
        System.out.println(Integer.toBinaryString(c));
        //c='中';
        System.out.println(Integer.toBinaryString(c));
        //StringBuilder stringBuilder=new StringBuilder(32);
        //System.arraycopy();

        new BigPic(){
            private char v=c;
            @Override
            public List<String> getPics() {
                return super.getPics();
            }
        };
    }

    private String getStatuesCode (String name){
        for (Status st:Status.values()) {
            if (st.getText().equals(name)) {
                return st.getStatusCode();
            }
        }
        return "";
    }
    private String getCurrencyCode(String text){
        for (CurrencyType st:CurrencyType.values()) {
            if (st.getText().equals(text)) {
                return st.getCurrencyTypeCode();
            }
        }
        return "";
    }

    private String formatSqlValue(String s){
       return s==null?"null,":"'"+s+"',";
    }
}
