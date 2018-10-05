package cn.edu.nju.dict;

import cn.edu.nju.util.FileHelper;

import java.util.*;
/**
 * Created by njucjc at 2018/9/29
 */
public class Dict {

    private Map<String, Word> dictMap = new HashMap<>();

    public Dict(String filePath) {
        List<String> dictList = FileHelper.readFile(filePath);

        for(String pattern : dictList) {
            String [] elements = pattern.split("\uF8F5");
            dictMap.put(elements[0], new Word(elements));
        }
    }

    public boolean isWord(String str) {
        return dictMap.containsKey(str);
    }

    public Word lookup(String word) {
        return dictMap.get(word);
    }

    public void print() {
        for(String key : dictMap.keySet()) {
            System.out.println(key);
        }
    }
}
