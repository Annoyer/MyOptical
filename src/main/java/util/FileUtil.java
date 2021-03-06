package util; /**
 * Created by Karn on 2016/12/17.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/****
 * 文件操作类
 */
public class FileUtil {

    /**
     * 删除指定目录下的所有文件
     *
     * @param folderPath 目录路径
     * @return true:删除成功
     * false:删除失败
     */
    public static boolean delAllFile(String folderPath) {
        boolean flag = false;
        File file = new File(folderPath);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            //File.separator 在windows下是"\",linux下是"/"
            if (folderPath.endsWith(File.separator)) {
                temp = new File(folderPath + tempList[i]);
            } else {
                temp = new File(folderPath + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(folderPath + File.separator + tempList[i]);// 先删除文件夹里面的文件
                delFolder(folderPath + File.separator + tempList[i]);// 再删除空文件夹
                flag = true;
            }
        }
        return flag;
    }

    /**
     * 删除指定文件
     *
     * @param filePath 指定文件的路径
     * @return true:删除成功 false:删除失败
     */
    public static boolean delFile(String filePath) {
        boolean flag = false;
        File file = new File(filePath);
        if (!file.exists()) {
            return flag;
        }
        flag = (new File(filePath)).delete();
        return flag;
    }

    /**
     * 删除指定文件夹(包括文件夹下的所有文件)
     *
     * @param folderPath 指定文件夹路径
     * @return true:删除成功 false:删除失败
     */
    public static boolean delFolder(String folderPath) {
        try {
            delAllFile(folderPath); // 删除完里面所有内容
            String filePath = folderPath;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            myFilePath.delete(); // 删除空文件夹
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 读取文本文件的内容
     *
     * @param curfile 文本文件路径
     * @return 返回文件内容
     */
    public static String readFile(String curfile) {
        File f = new File(curfile);
        try {
            if (!f.exists())
                throw new Exception();
            FileReader cf = new FileReader(curfile);
            BufferedReader is = new BufferedReader(cf);
            String filecontent = "";
            String str = is.readLine();
            while (str != null) {
                filecontent += str;
                str = is.readLine();
                if (str != null)
                    filecontent += "\n";
            }
            is.close();
            cf.close();
            return filecontent;
        } catch (Exception e) {
            System.err.println("不能读属性文件: " + curfile + " \n" + e.getMessage());
            return "";
        }
    }

    /**
     * 取指定文件的扩展名
     *
     * @param filePathName 文件路径
     * @return 扩展名
     */
    public static String getFileExt(String filePathName) {
        int pos = 0;
        pos = filePathName.lastIndexOf('.');
        if (pos != -1)
            return filePathName.substring(pos + 1, filePathName.length());
        else
            return "";
    }

    /**
     * 读取文件大小
     *
     * @param filename 指定文件路径
     * @return 文件大小
     */
    public static int getFileSize(String filename) {
        try {
            File fl = new File(filename);
            int length = (int) fl.length();
            return length;
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * 拷贝文件到指定目录
     *
     * @param srcPath  源文件路径
     * @param destPath 目标文件路径
     * @return true:拷贝成功 false:拷贝失败
     */
    public static boolean copyFile(String srcPath, String destPath) {
        try {
            File fl = new File(srcPath);
            int length = (int) fl.length();
            FileInputStream is = new FileInputStream(srcPath);
            FileOutputStream os = new FileOutputStream(destPath);
            byte[] b = new byte[length];
            is.read(b);
            os.write(b);
            is.close();
            os.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 新建文件
     *
     * @param filePathAndName 文本文件完整绝对路径及文件名
     * @param fileContent     文本文件内容
     * @return false 创建失败
     * true 创建成功
     */
    public static boolean createFile(String filePathAndName, String fileContent) {
        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            FileWriter resultFile = new FileWriter(myFilePath);
            PrintWriter myFile = new PrintWriter(resultFile);
            String strContent = fileContent;
            myFile.println(strContent);
            myFile.close();
            resultFile.close();
        } catch (Exception e) {
            System.out.println("创建文件操作出错:" + e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * 有编码方式的文件创建
     * @param filePathAndName 文本文件完整绝对路径及文件名
     * @param fileContent 文本文件内容
     * @param encoding 编码方式 例如 GBK 或者 UTF-8
     * @return
     */
    public static boolean createFile(String filePathAndName, String fileContent, String encoding) {

        try {
            String filePath = filePathAndName;
            filePath = filePath.toString();
            File myFilePath = new File(filePath);
            if (!myFilePath.exists()) {
                myFilePath.createNewFile();
            }
            PrintWriter myFile = new PrintWriter(myFilePath,encoding);
            String strContent = fileContent;
            myFile.println(strContent);
            myFile.close();
        }
        catch (Exception e) {
            System.out.println("创建文件操作出错:" + e.getMessage());
            return false;
        }
        return true;
    }
    /**
     * Function Name: scanDisk
     *
     * @return description:获取指定目录下的所有文件列表
     * Modification History:
     */
    public static List<File> scanDisk(File basedir) {
        List<File> ret = new ArrayList<File>();
        File[] tmp = basedir.listFiles();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i].isFile()) {
                ret.add(tmp[i]);
            }
        }
        return ret;
    }
}