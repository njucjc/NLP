package cn.edu.nju;

import cn.edu.nju.dict.Dict;
import cn.edu.nju.segment.FBSegment;
import cn.edu.nju.segment.Segment;

import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		if(args.length >= 1) {
			Dict dict = new Dict(args[0]);
			Segment segment = new FBSegment(dict);

			Scanner input = new Scanner(System.in);
			String in;
			do {
				System.out.print("Please input a sentence >> ");
				in = input.nextLine();
				if("exit()".equals(in)) {
					break;
				}

				List<String> res = segment.segment(in);
				for(String e : res) {
					System.out.print(e + "/");
				}
				System.out.println();
			} while (true);
		}
		else {
			System.out.println("Usage: java Main dict.txt");
		}

	}
}