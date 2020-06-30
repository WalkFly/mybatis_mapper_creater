package cn.com.zx.main.util;

public class JavaToSqlName {

    public static String classNameToSqlName(String className){
        char[] chars = className.toCharArray();
        StringBuffer result = new StringBuffer();
        int j = 0;
        for(int i = 0 ; i < chars.length ; i ++){
            //判断是否是大写
            //排除第一次大写导致直接插入_
            if(i != 0){
                if(chars[i] >= 65 && chars[i] <= 90 ){
                    //若是大写，则先截取该部分字符,并转换为小写
                    result.append(className.substring(j ,i).toLowerCase()).append("_");
                    j =i;
                }
            }
        }
        //拼接最后一部分和无大写的情况（）
        result.append(className.substring(j ,className.length()).toLowerCase());
        return result.toString();
    }

    public static String javaTypeToSqlType(String javaType) {
        if(javaType.equals("String")){
            return "VARCHAR";
        }
        if(javaType.equals("Integer")){
            return "INTEGER";
        }
        if(javaType.equals("Byte")){
            return "TINYINT";
        }
        if(javaType.equals("Date")){
            return "TIMESTAMP";
        }
        if(javaType.equals("Boolean")){
            return "BOOLEAN";
        }
        if(javaType.equals("Long")){
            return "BIGINT";
        }
        if(javaType.equals("Float")){
            return "FLOAT";
        }
        if(javaType.equals("Short")){
            return "SMALLINT";
        }
        if(javaType.equals("Double")){
            return "DOUBLE";
        }
        return null;
    }
}