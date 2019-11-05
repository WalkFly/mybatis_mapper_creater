package cn.com.zx.main;

import cn.com.zx.main.entity.*;
import cn.com.zx.main.util.JavaToSqlName;
import cn.com.zx.main.util.ReflectMember;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.Set;

public class mainClass{

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, IOException {
        Class clazz = SysPara.class;

        Map map = ReflectMember.getClassMember(clazz);
        String userPath = System.getProperty("user.dir");
        String filePath = userPath + "/src/main/resources/mapper/";
        File file = new File(filePath + clazz.getSimpleName()+"Mapper.xml");
        if(file.exists()){
            file.delete();
        }
        OutputStream out = new FileOutputStream(file , true);
        createBeginFile(out , clazz.getSimpleName());
        createBaseMapper(out , clazz , map);

        createSelectConditionMapper(out , map , clazz);
        selectPageConditionMapper(out , map , clazz);
        InsertFrontConditionMapper(out , map , clazz);
        insertBehindConditionMapper(out , map , clazz);
        updateConditionMapper(out , map , clazz);
        createBaseFunction(out , map , clazz);
        out.flush();
    }

    public static void createBeginFile(OutputStream out , String className) throws IOException {
        out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes());
        out.write("\r\n".getBytes());
        out.write("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">".getBytes());
        out.write("\r\n".getBytes());
        out.write("\r\n".getBytes());
        out.write(("<mapper namespace=\"cn.com.soyea.nb.rrmp.device.dao." + className +"Dao\">").getBytes());
        out.write("\r\n".getBytes());
        out.write(("  <sql id=\"table\">"+className.toLowerCase() + "</sql>").getBytes());
        out.write("\r\n".getBytes());
    }

    public static void createBaseMapper(OutputStream out , Class clazz , Map<String , String> map) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write(("  <resultMap id=\"" + simpleName + "Map\" type=\"" + simpleName +"\">").getBytes());
        out.write("\r\n".getBytes());
        out.write("    <id column=\"id\" property=\"id\" jdbcType=\"BIGINT\"/>".getBytes());
        out.write("\r\n".getBytes());
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            if(!key.equals("id")){
                String sqlName = JavaToSqlName.classNameToSqlName(key);
                String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
                out.write(("    <result column=\"" + sqlName + "\" property=\"" + key + "\" jdbcType=\""+ sqlType + "\"/>").getBytes());
                out.write("\r\n".getBytes());
            }
        }
        appendBaseMapperStr(out);
    }

    public static void appendBaseMapperStr(OutputStream out) throws IOException {
        out.write("    <result column=\"create_by\" property=\"createBy\" jdbcType=\"VARCHAR\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("    <result column=\"create_time\" property=\"createTime\" jdbcType=\"TIMESTAMP\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("    <result column=\"modified_by\" property=\"modifiedBy\" jdbcType=\"VARCHAR\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("    <result column=\"modified_time\" property=\"modifiedTime\" jdbcType=\"TIMESTAMP\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("    <result column=\"remark\" property=\"remark\" jdbcType=\"VARCHAR\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("    <result column=\"valid_state\" property=\"validState\" jdbcType=\"TINYINT\"/>".getBytes());
        out.write("\r\n".getBytes());
        out.write("  </resultMap>".getBytes());
    }

    public static void createSelectConditionMapper(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        out.write("\r\n".getBytes());
        out.write("  <sql id=\"select_condition_sql\">".getBytes());
        String simpleName = clazz.getSimpleName();
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            String sqlName = JavaToSqlName.classNameToSqlName(key);
            String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
            if(map.get(key).equals("String")){
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null and " +key +" != ''\">and " + sqlName + "=#{" + key + ",jdbcType=" + sqlType+"}</if>").getBytes());
            }else{
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null \">and " + sqlName + "=#{" + key + ",jdbcType=" + sqlType+"}</if>").getBytes());
            }
        }


        out.write("\r\n".getBytes());
        out.write("    <if test=\"cm.createBy != null and createBy != ''\">and create_by=#{cm.createBy,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.createTime != null \">and create_time=#{cm.createTime,jdbcType=TIMESTAMP}</if>\n".getBytes());
        out.write("    <if test=\"cm.modifiedBy != null and modifiedBy != ''\">and modified_by=#{cm.modifiedBy,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.modifiedTime != null \">and modified_time=#{cm.modifiedTime,jdbcType=TIMESTAMP}</if>\n".getBytes());
        out.write("    <if test=\"cm.remark != null and remark != ''\">and remark=#{cm.remark,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.validState != null \">and valid_state=#{cm.validState,jdbcType=TINYINT}</if>\n".getBytes());
        out.write("  </sql>\n".getBytes());
    }

    public static void selectPageConditionMapper(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write("\r\n".getBytes());
        out.write("  <sql id=\"select_page_condition_sql\">".getBytes());
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            String sqlName = JavaToSqlName.classNameToSqlName(key);
            String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
            if(map.get(key).equals("String")){
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"cm." + key + " != null and cm." +key +" != ''\">and " + sqlName + "=#{cm." + key + ",jdbcType=" + sqlType+"}</if>").getBytes());
            }else{
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"cm." + key + " != null \">and " + sqlName + "=#{cm." + key + ",jdbcType=" + sqlType+"}</if>").getBytes());
            }
        }
        out.write("\r\n".getBytes());
        out.write("    <if test=\"cm.createBy != null and cm.createBy != ''\">and create_by=#{cm.createBy,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.createTime != null \">and create_time=#{cm.createTime,jdbcType=TIMESTAMP}</if>\n".getBytes());
        out.write("    <if test=\"cm.modifiedBy != null and modifiedBy != ''\">and modified_by=#{cm.modifiedBy,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.modifiedTime != null \">and modified_time=#{cm.modifiedTime,jdbcType=TIMESTAMP}</if>\n".getBytes());
        out.write("    <if test=\"cm.remark != null and cm.remark != ''\">and remark=#{cm.remark,jdbcType=VARCHAR}</if>\n".getBytes());
        out.write("    <if test=\"cm.validState != null \">and valid_state=#{cm.validState,jdbcType=TINYINT}</if>\n".getBytes());
        out.write("  </sql>\n".getBytes());
    }

    public static void InsertFrontConditionMapper(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write("\r\n".getBytes());
        out.write("  <sql id=\"insert_front_condition_sql\">".getBytes());
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            String sqlName = JavaToSqlName.classNameToSqlName(key);
            String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
            if(map.get(key).equals("String")){
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null and " +key +" != ''\">" + sqlName + ",</if>").getBytes());
            }else{
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null \">" + sqlName + ",</if>").getBytes());
            }
        }
        out.write("\r\n".getBytes());
        out.write("    <if test=\"createBy != null and createBy != ''\">create_by,</if>\n".getBytes());
        out.write("    <if test=\"createTime != null \">create_time,</if>\n".getBytes());
        out.write("    <if test=\"modifiedBy != null and modifiedBy != ''\">modified_by,</if>\n".getBytes());
        out.write("    <if test=\"modifiedTime != null \">modified_time,</if>\n".getBytes());
        out.write("    <if test=\"remark != null and remark != ''\">remark,</if>\n".getBytes());
        out.write("    <if test=\"validState != null \">valid_state,</if>\n".getBytes());
        out.write("  </sql>\n".getBytes());
    }

    public static void insertBehindConditionMapper(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write("\r\n".getBytes());
        out.write("  <sql id=\"insert_behind_condition_sql\">".getBytes());
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            String sqlName = JavaToSqlName.classNameToSqlName(key);
            String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
            if(map.get(key).equals("String")){
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null and " +key +" != ''\">#{" + key + ",jdbcType=" + sqlType+"},</if>").getBytes());
            }else{
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null\">#{" + key + ",jdbcType=" + sqlType+"},</if>").getBytes());
            }
        }
        out.write("    <if test=\"createBy != null and createBy != ''\">#{createBy,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"createTime != null \">#{createTime,jdbcType=TIMESTAMP},</if>\n".getBytes());
        out.write("    <if test=\"modifiedBy != null and modifiedBy != ''\">#{modifiedBy,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"modifiedTime != null \">#{modifiedTime,jdbcType=TIMESTAMP},</if>\n".getBytes());
        out.write("    <if test=\"remark != null and remark != ''\">#{remark,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"validState != null \">#{validState,jdbcType=TINYINT},</if>\n".getBytes());
        out.write("  </sql>\n".getBytes());
    }

    public static void updateConditionMapper(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write("\r\n".getBytes());
        out.write("  <sql id=\"update_condition_sql\">".getBytes());
        Set<String> keySet = map.keySet();
        for(String key : keySet){
            String sqlName = JavaToSqlName.classNameToSqlName(key);
            String sqlType = JavaToSqlName.javaTypeToSqlType(map.get(key));
            if(map.get(key).equals("String")){
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null and " +key +" != ''\">" + sqlName + "=#{" + key + ",jdbcType=" + sqlType+"},</if>").getBytes());
            }else{
                out.write("\r\n".getBytes());
                out.write(("    <if test=\"" + key + " != null \">" + sqlName + "=#{" + key + ",jdbcType=" + sqlType+"},</if>").getBytes());
            }
        }
        out.write("    <if test=\"createBy != null and createBy != ''\">create_by=#{createBy,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"createTime != null \">create_time=#{createTime,jdbcType=TIMESTAMP},</if>\n".getBytes());
        out.write("    <if test=\"modifiedBy != null and modifiedBy != ''\">modified_by=#{modifiedBy,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"modifiedTime != null \">modified_time=#{modifiedTime,jdbcType=TIMESTAMP},</if>\n".getBytes());
        out.write("    <if test=\"remark != null and remark != ''\">remark=#{remark,jdbcType=VARCHAR},</if>\n".getBytes());
        out.write("    <if test=\"validState != null \">valid_state=#{validState,jdbcType=TINYINT},</if>\n".getBytes());
        out.write("  </sql>\n".getBytes());
    }

    public static void createBaseFunction(OutputStream out , Map<String , String> map , Class clazz) throws IOException {
        String simpleName = clazz.getSimpleName();
        out.write(("  <insert id=\"insert\" parameterType=\""+simpleName +"\">insert into\n").getBytes());
        out.write("    <include refid=\"table\"/>\n".getBytes());
        out.write("    <trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">\n".getBytes());
        out.write("      <include refid=\"insert_front_condition_sql\"/>\n".getBytes());
        out.write("    </trim>\n".getBytes());
        out.write("    <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">\n".getBytes());
        out.write("      <include refid=\"insert_behind_condition_sql\"/>\n".getBytes());
        out.write("    </trim>\n".getBytes());
        out.write("  </insert>\n".getBytes());
        out.write(("  <update id=\"update\" parameterType=\""+simpleName+"\">update\n").getBytes());
        out.write("    <include refid=\"table\"/>\n".getBytes());
        out.write("    <trim prefix=\"set\" suffixOverrides=\",\">\n".getBytes());
        out.write("      <include refid=\"update_condition_sql\"/>\n".getBytes());
        out.write("    </trim>where id = #{id, jdbcType=BIGINT}\n".getBytes());
        out.write("  </update>\n".getBytes());
        out.write("  <delete id=\"deleteById\" parameterType=\"java.lang.Long\">update\n".getBytes());
        out.write("    <include refid=\"table\"/>set valid_state = 0 where id = #{id, jdbcType=BIGINT}\n".getBytes());
        out.write("  </delete>\n".getBytes());
        out.write(("  <select id=\"listPage\" parameterType=\"java.util.Map\" resultMap=\""+simpleName + "Map\">select * from\n").getBytes());
        out.write("    <include refid=\"table\"/>\n".getBytes());
        out.write("    <where>\n".getBytes());
        out.write("      <include refid=\"select_condition_sql\"/>\n".getBytes());
        out.write("    </where> order by id desc\n".getBytes());
        out.write("  </select>\n".getBytes());
        out.write(("  <select id=\"listBy\" parameterType=\"java.util.Map\" resultMap=\""+simpleName+"Map\">select * from \n").getBytes());
        out.write("    <include refid=\"table\"/>\n".getBytes());
        out.write("    <where>\n".getBytes());
        out.write("      <include refid=\"select_condition_sql\"/>\n".getBytes());
        out.write("    </where> order by id desc\n".getBytes());
        out.write("  </select>\n".getBytes());
        out.write(("  <select id=\"getById\" parameterType=\"java.lang.Long\" resultMap=\""+simpleName+"Map\">select * from\n").getBytes());
        out.write("    <include refid=\"table\"/>where id = #{id, jdbcType=BIGINT}\n".getBytes());
        out.write("  </select>\n".getBytes());
        out.write("</mapper>\n".getBytes());
    }
}
