package rohan.test.reflections;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;

public class AnonymousClassDemo {

    private static final void findClassFiles(File dir) {

        final String suffix = ".class";
        File[] fileList = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(suffix);
            }

        });

        for (File file : fileList) {
            System.out.println(file.getPath());
        }

        File[] subDirList = dir.listFiles(new FileFilter() {

            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        for (File file : subDirList) {
            findClassFiles(file);
        }

    }

    public static void main(String[] args) {
        findClassFiles(new File("/u/rohan/workspace/test-proj/"));
    }

}
