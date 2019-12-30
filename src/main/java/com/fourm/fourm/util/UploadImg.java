package com.fourm.fourm.util;

import com.fasterxml.jackson.databind.ser.Serializers;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.util.Base64Utils;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class UploadImg {

    public static String uploadBase64Image(String base64Data){
        /*base64格式
        * data:image/png;base64,xxx*/
        String dataPrix = "";
        String data = "";
        if(base64Data == null || "".equals(base64Data)){
            return null;
        }else {
            String[] d = base64Data.split("base64,");
            if (d != null && d.length == 2) {
                dataPrix = d[0];
                data = d[1];
            } else {
                return null;

            }
        }
        String suffix = "";
        if("data:image/jpeg;".equalsIgnoreCase(dataPrix)){//data:image/jpeg;base64,base64编码的jpeg图片数据
            suffix = ".jpg";
        } else if("data:image/x-icon;".equalsIgnoreCase(dataPrix)){//data:image/x-icon;base64,base64编码的icon图片数据
            suffix = ".ico";
        } else if("data:image/gif;".equalsIgnoreCase(dataPrix)){//data:image/gif;base64,base64编码的gif图片数据
            suffix = ".gif";
        } else if("data:image/png;".equalsIgnoreCase(dataPrix)){//data:image/png;base64,base64编码的png图片数据
            suffix = ".png";
        }else{
            return null;
        }
        String tempFileName = UUID.randomUUID().toString() + suffix;
        String imgFilePath = "/home/forum"+tempFileName;//新生成的图片
        //String imgFilePath = "E:/kankan/"+tempFileName;//新生成的图片
        //Base64 decoder = new Base64();
        try {
            //Base64解码
            byte[] b = Base64.decodeBase64(data);
            for(int i=0;i<b.length;++i) {
                if(b[i]<0) {
                    //调整异常数据
                    b[i]+=256;
                }
            }
            OutputStream out = new FileOutputStream(imgFilePath);
            out.write(b);
            out.flush();
            out.close();
            String imgUrl="http://111.229.39.131/forum/ForumArticleImages/"+tempFileName;
            //String imgUrl="http://127.0.0.1:1525/forum/ForumArticleImages/"+tempFileName;
            return imgUrl;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }



    }
}
