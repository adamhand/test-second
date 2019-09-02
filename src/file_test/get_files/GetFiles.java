package file_test.get_files;

import java.io.File;
import java.util.ArrayList;

public class GetFiles {
    public void getFiles(ArrayList<File> fileList, String path) {
        File[] files = new File(path).listFiles();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];

            if (file.isFile()) {
                fileList.add(file);
            } else {
                getFiles(fileList, file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<File> fileList = new ArrayList<>();
        new GetFiles().getFiles(fileList, "C:\\Users\\adamhand\\Desktop\\11");

        for (File f : fileList) {
            System.out.println(f.getName());
        }
    }
}
