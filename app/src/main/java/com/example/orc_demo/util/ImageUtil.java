package com.example.orc_demo.util;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

public class ImageUtil {

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static String loadAsBase64(String imgFile)
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理

        File file = new File(imgFile);
        if(!file.exists()){
            System.out.println("文件不存在");
            return null;
        }
        InputStream in = null;
        byte[] data = null;
        //读取图片字节数组
        try
        {
            in = new FileInputStream(imgFile);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        //对字节数组Base64编码
        return Base64.getEncoder().encodeToString(data);//返回Base64编码过的字节数组字符串
    }
}
