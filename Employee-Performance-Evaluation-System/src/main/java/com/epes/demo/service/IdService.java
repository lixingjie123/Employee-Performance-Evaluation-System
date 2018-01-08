package com.epes.demo.service;

import com.epes.demo.tool.IdGenerator;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * @author lixingjie
 * Date: 2018-01-05
 * Time: 15:39
 */
public class IdService {
    private IdGenerator idGenerator = new IdGenerator(1,2);


    private long getId(){
        return idGenerator.nextId();
    }


    /**
     * 获取当前时间的十六进制数：yyyy MM dd HH mm ss
     *
     * @return
     */
    @NotNull
    private String getDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String c=sdf.format(new Date());
        long date = Long.parseLong(c);
        return Long.toHexString(date);
    }

    /**
     * 获取生成ID的十六进制数
     *
     * @return
     */
    public String getIDToHexString(){
        //新生成的时间节点ID
        long id = getId();
        return Long.toHexString(id);
    }

    /**
     * 生成产品编号
     * @param src 编号头
     * @return
     */
    public String getCode(String src){
        src +=getIDToHexString();
        return src;
    }
}
