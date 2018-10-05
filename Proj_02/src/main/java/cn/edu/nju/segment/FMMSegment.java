package cn.edu.nju.segment;

import cn.edu.nju.dict.Dict;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by njucjc at 2018/10/5
 */
public class FMMSegment implements Segment {

    Dict dict;

    public FMMSegment(Dict dict) {
        this.dict = dict;
    }

    public List<String> segment(String phrase) {
        List<String> res = new ArrayList<>();

        int len = phrase.length();
        int i = 0;
        while (i < len) {
            int end = i + MAX_LEN;
            if(end > len) {
                end = len;
            }

            String subPhrase = phrase.substring(i, end);
            for(int j = subPhrase.length(); j > 0; j--) {
                String key = subPhrase.substring(0, j);
                if(dict.contains(key) || j == 1) {
                    res.add(key);
                    i += key.length();
                    break;
                }
            }
        }

        return res;
    }
}
