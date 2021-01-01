package testing;

import java.io.*;

/*
从网易云的缓存中获取mp3
将.UC文件按二进制字节流输出，每个字节与0xa3做异或运算，再将运算结果以二进制字节流写入文件，保存后缀名为.mp3
//        javac getMp3.java
//        java getMp3 E:/aaa.uc E:/aaa.mp3
*/
public class GetMp3FromNetEase {

    public static void main(String[] args) throws IOException {
        File file1 = new File(args[0]);//网易缓存的uc文件
        File file2 = new File(args[1]);//output的MP3地址

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2, true);//输出流对象，不覆盖之前保存的内容
        DataInputStream dis = new DataInputStream(fis);
        DataOutputStream dos = new DataOutputStream(fos);
        byte[] buf = new byte[1024];//从文件输入的数据
        int length;//获取的字节长度
        while ((length = dis.read(buf)) != -1) {
            for (int i = 0; i < length; i++) {
                buf[i] ^= 0xa3;//每个字节都与0xa3做异或运算
            }
            dos.write(buf);//将运算结果写入文件
        }
        dis.close();//关闭流对象
        dos.close();
        fis.close();
        fos.close();
        }
    }
