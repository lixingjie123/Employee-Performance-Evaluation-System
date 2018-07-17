package com.epes.demo;

import com.epes.demo.tool.BadWordUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;
import java.util.Set;

/**
 * Description:
 * Date: 2018/5/30
 * Time: 17:24
 *
 * @Author lixingjie
 * @Modifice
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadWordTest {


    @Test
    public void badWordTest() {
        Set<String> s = BadWordUtil.words;
        Map<String,String> map = BadWordUtil.wordMap;

        System.out.println("敏感词的数量：" + BadWordUtil.wordMap.size());
        String string = "枪支、习近平、太多的伤感情怀也许只局限于饲养基地 荧幕中的情节，主人公尝试着去用某种方式渐渐的很潇洒地释自杀指南怀那些自己经历的伤感。"
                + "然后法轮功 我们的扮演的角色就是跟随着主人公的喜红客联盟 怒哀乐而过于牵强的把自己的情感也附加于银幕情节中，然后感动就流泪，"
                + "难过就躺在某一个人的怀里尽情的阐述心扉或者手机卡复制器一个人一杯红酒一部电影在夜三级片 深人静的晚上，关上电话静静的发呆着。";
        System.out.println("待检测语句字数：" + string.length());
        long beginTime = System.currentTimeMillis();
        Set<String> set = BadWordUtil.getBadWord(string, 2);
        Boolean i = BadWordUtil.isContaintBadWord(string, 2);

        long endTime = System.currentTimeMillis();
        System.out.println("语句中包含敏感词的个数为：" + set.size() + "。包含：" + set);
        System.out.println("总共消耗时间为：" + (endTime - beginTime)+"ms");
    }
}
