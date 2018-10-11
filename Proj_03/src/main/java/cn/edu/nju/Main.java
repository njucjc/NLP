package cn.edu.nju;

import cn.edu.nju.converter.Converter;
import cn.edu.nju.converter.RuleBasedConverter;
import cn.edu.nju.dict.Dict;

public class Main {
    public static void main(String[] args) {
        Dict dict = new Dict(args[0]); //dict_ec.txt
        Converter converter = new RuleBasedConverter(args[1]); //irregular_vebs.txt

        
    }
}
