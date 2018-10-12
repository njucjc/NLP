package cn.edu.nju;


import cn.edu.nju.parser.ChartParser;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if(args.length == 3) {

            ChartParser chartParser = new ChartParser(args[0], args[1], args[2]);

            do {
                Scanner input = new Scanner(System.in);
                String s = input.nextLine();
                if("exit()".equals(s)) {
                    break;
                }

                chartParser.parsing(s);

            }while (true);
        }
        else {
            System.out.println("Usage: java Main dict.txt irregular_verb.txt rule.txt");
        }

//        ChartParser chartParser = new ChartParser(args[0], args[1], args[2]);
//        chartParser.parsing("the cat caught a mouse");

        
    }
}
