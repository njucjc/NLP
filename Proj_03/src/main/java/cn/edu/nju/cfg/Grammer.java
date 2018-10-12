package cn.edu.nju.cfg;

import cn.edu.nju.util.FileHelper;

import java.util.*;

public class Grammer {

    List<Rule> ruleList = new ArrayList<>();

    public Grammer(String ruleFilePath) {
        List<String> ruleStrs = FileHelper.readFile(ruleFilePath);

        int count = 0;
        for(String str : ruleStrs) {
            String [] first = str.split("->");
            String [] second = first[1].split(" ");
            ruleList.add(new Rule(first[0], second, count));
            count++;
        }
    }

    public List<Rule> getRulesByFirstRight(String right) {
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

    public Rule getRuleByNo(int no) {
        return ruleList.get(no);
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
