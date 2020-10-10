package cn.com.lasong.plugin.idea.jar.jdcore;

import org.jd.core.v1.ClassFileToJavaSourceDecompiler;

import java.io.File;

/**
 * JDCore工具类
 */
public class JDHelper {
    private static final ClassFileToJavaSourceDecompiler decompiler = new ClassFileToJavaSourceDecompiler();
    private static final JDPrinter printer = new JDPrinter();
    private static JDClassLoader loader = new JDClassLoader();

    /**
     * 反编译class
     * @param entryName
     * @param path
     * @return
     */
    public static String decompile(String entryName, String path) {
        loader.appendClz(entryName, path);
        printer.clear();
        try {
            decompiler.decompile(loader, printer, entryName);
            return printer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 释放资源和缓存
     */
    public static void release() {
        loader.clear();
    }
}
