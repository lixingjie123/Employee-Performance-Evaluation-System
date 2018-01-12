package com.epes.demo.service;

import com.epes.demo.tool.IdGenerator;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
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
    private Logger logger = LoggerFactory.getLogger(this.getClass());
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
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String gatDate = simpleDateFormat.format(new Date());
        long date = Long.parseLong(gatDate);
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
     * 生成某类产品编号
     * @param  className
     * @return
     */
    public <T> String getCode(Class<T> className) throws NoSuchFieldException {
        try {
            // 获取该实体类的code_title
            Field field = className.getField("CODE_TITLE");
            String codeTitle = field.get(className).toString();
            // 添加生成的编号
            codeTitle += getId();
            return codeTitle;
        }catch (NoSuchFieldException e){
            logger.error(className.getSimpleName()+" class not found 'code_title' field");
            throw new NoSuchFieldException(className.getSimpleName() + " class not found 'code_title' field");
        }catch (IllegalAccessException ignored){
            logger.error(className.getSimpleName() + " class code_title Field Can't access");
            throw new NoSuchFieldException(className.getSimpleName() + " class code_title Field Can't access");
        }
    }

    /***
     * 生成带某编号头的编号
     * @param codetitle
     * @return
     */
    public String getCode(String codetitle){
        codetitle += getId();
        return codetitle;
    }

   /* public <T> void getCC(Class<T> className){
        //获取该实体所有属性
        Field[] allField = className.getDeclaredFields();
        for (Field field : allField){
            Annotation[] fieldAnnotations= field.getAnnotations();
            for (Annotation annotation : fieldAnnotations){
                System.out.println(field.getName() + " : " + annotation.toString());
            }
        }
    }*/
}
