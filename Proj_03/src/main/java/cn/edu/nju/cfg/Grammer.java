package cn.edu.nju.cfg;

import cn.edu.nju.util.FileHelper;

import java.util.*;

public class Grammer {

    List<Rule> ruleList = new ArrayList<>();

    public Grammer(String ruleFilePath) {
        List<String> ruleStrs = FileHelper.readFile(ruleFilePath);

        for(String str : ruleStrs) {
            String [] first = str.split("->");
            String [] second = first[1].split(" ");
            ruleList.add(new Rule(first[0], second));
        }
    }

    public List<Rule> getRulesByRight(String right) {
        List<Rule> res = new ArrayList<>();
        for(Rule rule : ruleList) {
            if(rule.getRight()[0].equals(right)) {
                res.add(rule);
            }
        }
        return res;
    }

    public List<Rule> getRulesByLeft(String left) {
        List<Rule> res = new ArrayList<>();
        for(Rule rule : ruleList) {
            if(rule.getLeft().equals(left)) {
                res.add(rule);
            }
        }
        return res;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();

        for(Rule rule : ruleList) {
            str.append(rule);
            str.append("\n");
        }

        return str.toString();
    }
}
