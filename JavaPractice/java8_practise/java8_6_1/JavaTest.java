//编写一个程序，跟踪一组线程中最长的字符串，可以使用一个AtomicReference和一个合适的累加器
package java8_practise.java8_6_1;

import static java.lang.System.out;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

import sun.security.util.Length;

public class JavaTest {
    public static void main(String[] args) {
        try {
            String contents = new String(
                    Files.readAllBytes(Paths.get("D:\\ZhouShuai\\系统文档\\通达信系统\\日常运维\\日志\\20181119.log")),
                    StandardCharsets.UTF_8);
            final String[] words = contents.split("\\s");
            ExecutorService pool = Executors.newCachedThreadPool();
            int n = words.length;
            int threadNum = 50;
            AtomicReference<String> atoRef = new AtomicReference<String>();
            for (int i = 0; i < threadNum; i++) {
                int begin = i * n / threadNum;
                int end = (i + 1) * n / threadNum;
                pool.submit(() -> {
                    int max = 0;
                    for (int j = begin; j < end; j++) {
                        if (words[j].length() > max) {
                            max = words[j].length();
                            final String word = words[j];
                            //以下两个函数都可以
                            atoRef.updateAndGet(x -> x == null? word:x.length() > word.length() ? x : word);
                            // atoRef.getAndAccumulate(word,
                            // (preWord,newWord)->preWord == null ? newWord: newWord.length()>preWord.length()?newWord:preWord);
                        }
                    }
                });
            }
            pool.shutdown();
            while (pool.isTerminated() == false) {
                Thread.sleep(10);
            }
            System.out.println("over");
            System.out.println(atoRef.toString());
        } catch (Exception e) {
            out.println(e.getMessage());
        }
    }
}