package science.freeabyss.algorithm.util.io;

import science.freeabyss.algorithm.search.SequentialSearchST;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * 读取测试文件
 * Created by abyss on 09/07/2017.
 */
public class ReadFile {
    public static void readByLine(String filename, LineAction action) {
        try (FileReader reader = new FileReader(SequentialSearchST.class.getResource("/data/" + filename).getFile());
             BufferedReader buffer = new BufferedReader(reader)) {
            String line;
            while ((line = buffer.readLine()) != null) {
                action.action(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readWord(String filename, LineAction action) {
        try (FileReader reader = new FileReader(SequentialSearchST.class.getResource("/data/" + filename).getFile());
             BufferedReader buffer = new BufferedReader(reader)) {
            String line;
            while ((line = buffer.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    action.action(word);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface LineAction {
        void action(String line);
    }
}
