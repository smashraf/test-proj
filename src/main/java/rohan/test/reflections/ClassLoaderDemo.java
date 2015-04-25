package rohan.test.reflections;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ClassLoaderDemo extends URLClassLoader {

    public ClassLoaderDemo(URL[] urls, ClassLoader parent) {
        super(urls,parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        System.out.println("Loading class: " + name);
        return super.loadClass(name);
    }
    
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException {
        String url = "/u/rohan/workspace/test-proj";
        File file = new File(url);
        URL[] urls = new URL[] {file.toURL()};
        ClassLoader parent = ClassLoader.getSystemClassLoader();
        ClassLoader demoCL = new ClassLoaderDemo(urls, parent);
        demoCL.loadClass("java.lang.Class");
    }

}
