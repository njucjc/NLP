package cn.edu.nju.converter;

import cn.edu.nju.util.FileHelper;

import java.util.*;

/**
 * Created by njucjc at 2018/9/29
 */
public class RuleBasedConverter implements Converter {

    private Map<String, String> irregularWords = new HashMap<>();

    public RuleBasedConverter(String irregularFilePath) {
        List<String> irregularList = FileHelper.readFile(irregularFilePath);

        for(String pattern : irregularList) {
            String [] elements = pattern.split("\t");
            for(int i = 1; i < elements.length ; i++) {
                irregularWords.put(elements[i], elements[0]);
            }
        }

    }

    @Override
    public List<String> convert(String word) {

        List<String> res = new ArrayList<>();

        if(irregularWords.containsKey(word)) {
            res.add(irregularWords.get(word));
            return res;
        }

        if(word.endsWith("s")) { //*s -> * (SINGULAR3)
            res.add(word.substring(0, word.length() - 1));

            if(word.endsWith("es")) { //*es -> * (SINGULAR3)
                res.add(word.substring(0, word.length() - 2));

                if(word.endsWith("ies")) { //*ies -> *y (SINGULAR3)
                    res.add(word.substring(0, word.length() - 3) + "y");
                }
            }

        }
        else if(word.endsWith("ed")) {
            res.add(word.substring(0, word.length() - 2)); //*ed -> * (PAST)(VEN)
            res.add(word.substring(0, word.length() - 1)); //*ed -> *e (PAST)(VEN)

            if(word.endsWith("ied")) { //*ied -> *y (PAST)(VEN)
                res.add(word.substring(0, word.length() - 3) + "y");
            }

            if(word.length() > 4) { // *??ed -> *? (PAST)(VEN)
                String sub = word.substring(0, word.length() - 3);
                if(sub.charAt(sub.length() - 1) == word.charAt(word.length() - 3)) {
                    res.add(sub);
                }
            }
        }
        else if(word.endsWith("ing")) {
            res.add(word.substring(0, word.length() - 3)); //*ing -> * (PAST)(VEN)
            res.add(word.substring(0, word.length() - 3) + "e"); //*ing -> *e (PAST)(VEN)

            if(word.endsWith("ying")) { //*ying -> *ie (PAST)(VEN)
                res.add(word.substring(0, word.length() - 4) + "ie");
            }

            if(word.length() > 5) { // *??ing -> *? (PAST)(VEN)
                String sub = word.substring(0, word.length() - 4);

                if(sub.charAt(sub.length() - 1) == word.charAt(word.length() - 4)) {
                    res.add(sub);
                }
            }
        }

        return res;
    }
}
