package com.epes.demo.service;

import com.epes.demo.tool.IDGenerator;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: lixingjie
 * Date: 2018-01-04
 * Time: 16:13
 */
public class IDService {
    private  IDGenerator idGenerator = new IDGenerator(1l,31l);


    private long getId(){
        return idGenerator.nextId();
    }


    @NotNull
    private String getDate(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String c=sdf.format(new Date());
        long date = Long.parseLong(c);
        return Long.toHexString(date);
    }

    public String getIDToHexString(){
        //新生成的时间节点ID
        long id = getId();
        String hexId =Long.toHexString(id);
        //在id末尾添加当前时间标识
        hexId +=getDate();
        return hexId;
    }
}
