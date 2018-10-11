package cn.edu.nju.dict;

import java.util.*;

/**
 * Created by njucjc at 2018/9/29
 */
public class Word {

    //从词性到解释的Map
    private Map<String, String> explains  = new HashMap<>();;

    private String word;

    public Word(String [] elements) {

        //String [] elements = pattern.split("\uF8F5");
        for(int i = 1; i + 1 < elements.length; i += 2) {
            this.explains.put(elements[i], elements[i + 1]);
        }

        this.word = elements[0];
    }

    public boolean isVerb() {
        return explains.containsKey("v.") || explains.containsKey("vi.") || explains.containsKey("vt.");
    }

    public Set<String> getProperties() {
        return explains.keySet();
    }


    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(this.word + ":\n");

        for(String key : explains.keySet()) {
            str.append(key);
            str.append("\t");
            str.append(explains.get(key));
            str.append("\n");
        }

        return str.toString();
    }
}
