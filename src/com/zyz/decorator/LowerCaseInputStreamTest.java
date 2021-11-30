package com.zyz.decorator;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStreamTest {

    @Test
    public void TestLowerCaseInputStream() {
        int c;
        String dir = System.getProperty("user.dir");
        System.out.println(dir);
        try {
            InputStream in =
                    new LowerCaseInputStream(
                            new BufferedInputStream(
                                    new FileInputStream("src/com/zyz/decorator/test.txt")));
            while ((c = in.read()) >= 0) {
                System.out.print((char)c);
            }
            in.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
