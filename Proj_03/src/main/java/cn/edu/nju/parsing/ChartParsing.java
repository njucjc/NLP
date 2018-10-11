package cn.edu.nju.parsing;

import cn.edu.nju.cfg.Grammer;
import cn.edu.nju.cfg.NonActiveEdge;
import cn.edu.nju.cfg.Rule;
import cn.edu.nju.converter.Converter;
import cn.edu.nju.converter.RuleBasedConverter;
import cn.edu.nju.dict.Dict;

import java.util.List;
import java.util.Stack;

public class ChartParsing {

    Grammer grammer;

    Dict dict;

    Converter converter;

 //   Stack<NonActiveEdge> agenda;

 //   List<NonActiveEdge> nonActiveEdgeList;


    public ChartParsing(String dictFilePath, String irregFilePath, String rulePath) {

        this.grammer = new Grammer(rulePath);

        this.dict = new Dict(dictFilePath);

        this.converter = new RuleBasedConverter(irregFilePath);

    }

    public void parsing(String sentence) {

    }
}
