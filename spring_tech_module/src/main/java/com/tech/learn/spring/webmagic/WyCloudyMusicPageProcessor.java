package com.tech.learn.spring.webmagic;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 * Created by heliqing on 2017/6/6.
 */
public class WyCloudyMusicPageProcessor implements PageProcessor {
    private Site site=Site.me().setRetryTimes(3).setSleepTime(1000); //设置重试次数和休眠时间

    @Override
    public void process(Page page) {
        page.putField("picUrl",page.getHtml().css("ul.m-cvrlst m-cvrlst-alb4 f-cb").links().regex(".*jpg\\?").all());
        if(page.getResultItems().get("picUrl")==null){
            page.setSkip(true);
        }
        System.out.println("-------------------------"+page.getResultItems().get("picUrl"));
//        if(page.getHtml().xpath("//[@class='u-page'/a/class()]").toString().indexOf("js-disabled")!=-1)
//        page.addTargetRequest();
    }

    @Override
    public Site getSite() {
        return site;
    }
    public static void main(String[] args) {

        Spider.create(new WyCloudyMusicPageProcessor())
                //从"https://github.com/code4craft"开始抓
                .addUrl("http://music.163.com/#/artist/album?id=6452&limit=12&offset=0")
                        //开启5个线程抓取
                .thread(5)
                        //启动爬虫
                .run();
    }
}
