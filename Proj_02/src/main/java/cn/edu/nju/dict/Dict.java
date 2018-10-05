package cn.edu.nju.dict;

import cn.edu.nju.util.FileHelper;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by njucjc at 2018/10/5
 */
public class Dict {
    Set<String> words = new TreeSet<String>();

    public Dict(String filePath) {
        List<String> rawLines = FileHelper.readFile(filePath);

        for(String line : rawLines) {
            String [] elements = line.split(",");
            words.add(elements[0]);
        }
    }

    public boolean contains(String word) {
        return words.contains(word);
    }
}
