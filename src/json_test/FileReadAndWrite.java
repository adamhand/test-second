package json_test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadAndWrite {
    public static void main(String args[]) {
        FileReadAndWrite fileReadAndWrite = new FileReadAndWrite();
        String filePath = "C:\\Users\\adamhand\\Desktop\\a.txt";

        System.out.println(readTxtFileIntoStringArrList(filePath));
    }

    /**
     * 功能：Java读取txt文件的内容 步骤：1：先获得文件句柄 2：获得文件句柄当做是输入一个字节码流，需要对这个输入流进行读取
     * 3：读取到输入流后，需要读取生成字节流 4：一行一行的输出。readline()。 备注：需要考虑的是异常情况
     *
     * @param filePath 文件路径[到达文件:如： D:\aa.txt]
     * @return 将这个文件按照每一行切割成数组存放到list中。
     */
    public static List<String> readTxtFileIntoStringArrList(String filePath) {
        List<String> list = new ArrayList<String>();
        try {
            String encoding = "utf-8";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { // 判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);// 考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null) {
                    System.out.println(lineTxt);
                    list.add(lineTxt);
                }
                bufferedReader.close();
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }

        return list;
    }
}