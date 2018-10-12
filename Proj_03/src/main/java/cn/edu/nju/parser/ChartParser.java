package cn.edu.nju.parser;

import cn.edu.nju.cfg.Grammer;
import cn.edu.nju.cfg.Rule;
import cn.edu.nju.converter.Converter;
import cn.edu.nju.converter.RuleBasedConverter;
import cn.edu.nju.dict.Dict;
import cn.edu.nju.dict.Word;
import cn.edu.nju.position.Position;

import java.util.*;

public class ChartParser {

    Grammer grammer;

    Dict dict;

    Converter converter;




    public ChartParser(String dictFilePath, String irregFilePath, String rulePath) {

        this.grammer = new Grammer(rulePath);

        this.dict = new Dict(dictFilePath);

        this.converter = new RuleBasedConverter(irregFilePath);


    }

    public void parsing(String sentence) {
        String [] words = parseSentence(sentence);

        Stack<Edge> agenda = new Stack<>();
        List<Edge> chart = new ArrayList<>();
        List<Edge> activeEdges = new ArrayList<>();

        int index = 0;
        boolean error = false;

        do {
            if(agenda.empty()) {
                if(index >= words.length) {
                    break;
                }
                else {
                    Set<String> attrs = getWordAtrrs(words[index++]);

                    if(attrs.isEmpty()) {
                        System.out.println(words[index - 1] + "is not a word.");
                        error = true;
                        break;
                    }

                    for(String attr : attrs) {
                        agenda.push(new Edge(null, attr, new Position(index -1, index)));
                    }
                }
            }

            Edge e = agenda.pop();

            //增加活动边
            List<Rule> ruleList = grammer.getRulesByFirstRight(e.getName());
            for(Rule rule : ruleList) {
                Edge edge = new Edge(rule, rule.getLeft(), new Position(e.getPos()));
                if(rule.getRightLength() != 1) { //X -> C X1 X2...

                    activeEdges.add(edge);
                }
                else { //X -> C
                    agenda.push(edge);
                }
            }

            //加入非活动边
            chart.add(e);

            //扩展已有活动边
            for(Edge edge : activeEdges) {
                String next = edge.getNext();
                Position curPos = edge.getPos();

                if(e.getName().equals(next) && curPos.getEnd() == e.getPos().getStart()) {
                    Edge tmp = new Edge(edge);
                    tmp.setPos(new Position(curPos.getStart(), e.getPos().getEnd()));

                    if(tmp.isDone()) {
                        agenda.push(tmp);
                    }
                    else {
                        activeEdges.add(tmp);
                    }
                }
            }


        } while (true);

        if(!error) {
            printChart(words.length, chart);
        }

    }

    private void printChart(int len, List<Edge> chart) {
        Edge edge = findEdge("S",new Position(0, len), chart);
        Queue<Edge> queue = new LinkedList<>();
        queue.offer(edge);
        while(!queue.isEmpty()) {
            Edge e = queue.poll();
            if(e != null) {
                Rule rule = e.getRule();
                if(rule == null) {
                    continue;
                }


                String [] right = rule.getRight();
                Position [] rightPos = e.getRightPos();

                assert right.length == rightPos.length;
                System.out.print(e.getName() + "(" + e.getPos().getStart() + "," +  e.getPos().getEnd() + ")" + "->");
                for(int i = 0; i < right.length; i++) {
                    System.out.print(right[i] + "(" + rightPos[i].getStart() + "," + rightPos[i].getEnd() + ") ");
                    queue.offer(findEdge(right[i], rightPos[i], chart));
                }
                System.out.println();

            }
            else {
                System.out.println("This sentence is illegal.");
                break;
            }

        }
    }


    private Edge findEdge(String name, Position pos, List<Edge> chart) {

        for(Edge e : chart) {
            if(e.getName().equals(name) && pos.equals(e.getPos())) {
                return e;
            }
        }
        return null;
    }


    private String [] parseSentence(String sentence) {
        return sentence.split(" ");
    }

    private Set<String> getWordAtrrs(String word) {
        Set<String> res = new HashSet<>();

        List<String> candidates = converter.convert(word);
        candidates.add(word);


        Iterator<String> it = candidates.iterator();
        while(it.hasNext()) {
            String str = it.next();
            boolean isWord = dict.isWord(str);

            if(isWord) {
                Word w = dict.lookup(str);
                if(word.endsWith("ing") || word.endsWith("ed")) {
                    if(!w.isVerb() && !str.equals(word)) {
                        it.remove();
                    }
                }
            }
            else {
                it.remove();
            }
        }

        for(String c : candidates) {
            Set<String> properties = dict.lookup(c).getProperties();
            if(properties.contains("adj.")) {
                res.add("ADJ");
            }

            if(properties.contains("none.") || properties.contains("n.")) {
                res.add("N");
            }

            if(properties.contains("v.") || properties.contains("vi.") || properties.contains("vt.")) {
                res.add("V");
            }

            if(properties.contains("art.")) {
                res.add("ART");
            }
        }


        return res;
    }
}
