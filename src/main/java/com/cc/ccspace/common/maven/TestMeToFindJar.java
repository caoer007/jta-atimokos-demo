package com.cc.ccspace.common.maven;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.CodeSource;
import java.security.ProtectionDomain;

/**
     * @author : chenxh
     * @date: 13-10-31
     */
    public class TestMeToFindJar {

        /**
         * 获取类所有的路径
         * @param cls
         * @return
         */
        public static String where(final Class cls) {
            if (cls == null)throw new IllegalArgumentException("null input: cls");
            URL result = null;
            final String clsAsResource = cls.getName().replace('.', '/').concat(".class");
            final ProtectionDomain pd = cls.getProtectionDomain();
            if (pd != null) {
                final CodeSource cs = pd.getCodeSource();
                if (cs != null) result = cs.getLocation();
                if (result != null) {
                    if ("file".equals(result.getProtocol())) {
                        try {
                            if (result.toExternalForm().endsWith(".jar") ||
                                    result.toExternalForm().endsWith(".zip"))
                                result = new URL("jar:".concat(result.toExternalForm())
                                        .concat("!/").concat(clsAsResource));
                            else if (new File(result.getFile()).isDirectory())
                                result = new URL(result, clsAsResource);
                        }
                        catch (MalformedURLException ignore) {}
                    }
                }
            }
            if (result == null) {
                final ClassLoader clsLoader = cls.getClassLoader();
                result = clsLoader != null ?
                        clsLoader.getResource(clsAsResource) :
                        ClassLoader.getSystemResource(clsAsResource);
            }
            return result.toString();
        }

    public static void main(String[] args) {
        System.out.println("cc");
       /*
       alt +f8动态执行
         TestMeToFindJar.where(org.objectweb.asm.ClassVisitor.class)
         就可以找打类的具体磁盘路径了，如果不是刷新下maven的缓存
      */
        System.out.println("dd");
    }

    }

