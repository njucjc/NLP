package cn.edu.nju;


import cn.edu.nju.converter.Converter;
import cn.edu.nju.converter.RuleBasedConverter;
import cn.edu.nju.dict.Dict;
import cn.edu.nju.dict.Word;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		if(args.length >= 2) {
			Converter converter = new RuleBasedConverter(args[0]);
			Dict dict = new Dict(args[1]);

			Scanner input = new Scanner(System.in);

			do {
				System.out.print("Please input a word >> ");
				String in = input.nextLine();

				if("exit()".equals(in)) {
					break;
				}

				List<String> tmp = converter.convert(in);


				tmp.add(in);

				boolean isFind = false;

				for(String str : tmp) {
					boolean isWord = dict.isWord(str);
					if(isWord) {
						Word w = dict.lookup(str);
						if(in.endsWith("ing") || in.endsWith("ed")) {
							if(w.isVerb() || str.equals(in)) {
								isFind = true;
								System.out.println(w);
							}
						}
						else {
							isFind = true;
							System.out.println(w);
						}

					}
				}

				if(!isFind) {
					System.out.println("Sorry, " + "'" + in + "'" + " is not a word.");
				}

			}while (true);

		}
		else {
			System.out.println("Usage: java Main irregular dict");
		}

	}
}