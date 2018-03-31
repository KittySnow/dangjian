package cn.dlbdata.dangjian.common.util;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @packageName FileUtil
 * @anthor wayne QQ:353733479
 * @date 2018/3/31.
 * @change
 * @describe 文件处理工具
 */
public class FileUtil {

    /**
     * 上传文件
     * @param file 文件内容
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }
}
