package cn.edu.nju.segment;

import cn.edu.nju.dict.Dict;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by njucjc at 2018/10/5
 */
public class BMMSegment implements Segment {

    Dict dict;

    public BMMSegment(Dict dict) {
        this.dict = dict;
    }

    public List<String> segment(String phrase) {
        List<String> res = new LinkedList<>();
        int len = phrase.length();
        int i = len;
        while (i > 0) {
            int start = i - MAX_LEN;
            if(start < 0) {
                start = 0;
            }

            String subPhrase = phrase.substring(start, i);
            for(int j = 0; j < subPhrase.length(); j++) {
                String key = subPhrase.substring(j);
                if(dict.contains(key) || (j == subPhrase.length() - 1)) {
                    res.add(0, key);
                    i -= key.length();
                    break;
                }
            }
        }
        return res;
    }
}
