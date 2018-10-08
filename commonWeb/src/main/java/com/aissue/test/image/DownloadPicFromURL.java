package com.aissue.test.image;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadPicFromURL {

    public static void main(String[] args) {
        String url = "http://59.202.58.229/gat-photo/330122/50521413_330122_74206979_330122199007230310.jpg?Expires=33033447000&OSSAccessKeyId=cdvgHXmEI54qbhDf&Signature=DwVkXWG%2B0p5ioHvhYeextfi36kQ%3D";
        String path="d:/pic.jpg";
        downloadPicture(url,path);
    }
    //链接url下载图片
    private static void downloadPicture(String urlList,String path) {
        URL url = null;
        try {
            url = new URL(urlList);
            DataInputStream dataInputStream = new DataInputStream(url.openStream());

            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length;

            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
            }
            fileOutputStream.write(output.toByteArray());
            dataInputStream.close();
            fileOutputStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
