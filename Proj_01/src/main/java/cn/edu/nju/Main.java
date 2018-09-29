package cn.edu.nju;


import cn.edu.nju.converter.Converter;
import cn.edu.nju.converter.RuleBasedConverter;
import cn.edu.nju.dict.Dict;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		if(args.length >= 2) {
			Converter converter = new RuleBasedConverter(args[0]);
			Dict dict = new Dict(args[1]);
		//	dict.print();

			Scanner input = new Scanner(System.in);

			do {
				System.out.print("Please input a word >> ");
				String word = input.nextLine();
				List<String> tmp = converter.convert(word);
				tmp.add(word);

				boolean isFind = false;

				for(String str : tmp) {
					boolean isWord = dict.isWord(str);
					isFind |= isWord;

					if(isWord) {
						System.out.println(dict.lookup(str));
					}
				}

				if(!isFind) {
					System.out.println("Sorry, " + "'" + word + "'" + " is not a word.");
				}

			}while (true);

		}
		else {
			System.out.println("Usage: java Main irregular dict");
		}

	}
}