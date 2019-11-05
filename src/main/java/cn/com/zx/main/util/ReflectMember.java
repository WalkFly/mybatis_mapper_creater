package cn.com.zx.main.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ReflectMember {

    public static Map getClassMember(Class clazz) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
         Field[] field = clazz.getDeclaredFields();
        Map<String , String> memberMap = new HashMap<String, String>();
        for (int j = 0; j < field.length; j++) {     //遍历所有属性
            String name = field[j].getName();    //获取属性的名字
            String type = field[j].getGenericType().toString();    //获取属性的类型
            if (type.equals("class java.lang.String")) {   //如果type是类类型，则前面包含"class "，后面跟类名
                memberMap.put(name , "String");
            }
            if (type.equals("class java.lang.Integer")) {
                memberMap.put(name , "Integer");
            }
            if (type.equals("class java.lang.Short")) {
                memberMap.put(name , "Short");
            }
            if (type.equals("class java.lang.Double")) {
                memberMap.put(name , "Double");
            }
            if (type.equals("class java.lang.Boolean")) {
                memberMap.put(name , "Boolean");
            }
            if (type.equals("class java.util.Date")) {
                memberMap.put(name , "Date");
            }
            if (type.equals("class java.lang.Byte")) {
                memberMap.put(name , "Byte");
            }
            if (type.equals("class java.lang.Long")) {
                memberMap.put(name , "Long");
            }
            if (type.equals("class java.lang.Float")) {
                memberMap.put(name , "float");
            }

        }
        return memberMap;
    }

}
