import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.filechooser.FileSystemView;

public class Ex14Tester
{
	public static int tests = 0;
	public static int passed = 0;
	public static int faild = 0;
	public static ArrayList<Integer> faildLines = new ArrayList<Integer>();

	public static String testLog = "";

	public static void main(String[] args)
	{
		assertEqualsInt("subStrC", "subStrC(\"c\", 'c') == 0", Ex14.subStrC("c", 'c'), 0, true);
		assertEqualsInt("subStrC", "subStrC(\"cc\", 'c') == 0", Ex14.subStrC("cc", 'c'), 0, true);
		assertEqualsInt("subStrC", "subStrC(\"ccc\", 'c') == 0", Ex14.subStrC("ccc", 'c'), 1, true);
		assertEqualsInt("subStrC", "subStrC(\"aacaa\", 'c') == 0", Ex14.subStrC("aacaa", 'c'), 0, true);
		assertEqualsInt("subStrC", "subStrC(\"caacaac\", 'c') == 0", Ex14.subStrC("caacaac", 'c'), 1, true);
		assertEqualsInt("subStrC", "subStrC(\"acacacacccac\", 'c') == 0", Ex14.subStrC("acacacacccac", 'c'), 5, true);
		assertEqualsInt("subStrC", "subStrC(\"acccacaacfdccadvsc\", 'c') == 0", Ex14.subStrC("acccacaacfdccadvsc", 'c'),
				6, true);
		assertEqualsInt("subStrC", "subStrC(\"\", 'c') == 0", Ex14.subStrC("", 'c'), 0, true);
		assertEqualsInt("subStrC", "subStrC(\"asdvssdf\", 'c') == 0", Ex14.subStrC("asdvssdf", 'c'), 0, true);

		String[] randText = { "qcccjfqcbeccccc", "cctcohqwjcrcfli", "cyylclsccwvvdch", "ckhafqcccbpccrc",
				"fcicezccccrcccr", "ucccccclvcacyqj", "ccorclgyeycckxw", "wcccwcjcbrdcjcc", "leczccczsccwcpa",
				"uqtiyjlyccccxcz", "qcbpcyrymtivcnz", "ocmgacnifcbqeic", "dydwgfsbiczdwnc", "cfctcyccccchcdl",
				"qsctcmgkjpxwyjc", "rcbtckmtupjtlcc", "ccrdwddxcaccrzc", "nqrcctcceshpscl", "crcsncdcjclcazh",
				"cicccukgscccovn", "cicccdccccfowlt", "civzcczwcfqcnzj", "cslzcdpcctcofzg", "jccxelndregcoql",
				"csjdwcaccocglbb", "ccgcuxukvcgmcqc", "wvkccccmcircecc", "ccafzqelvoccyfc", "coclaclccqqcjvc",
				"cccxadbcngtdcdv", "ccsbecfckdncmuv", "cwzfszccncccifc", "fcchtcqketojwbi", "czoccpccrcccbas",
				"ecbchpciumdercx", "qcccogvcmccqcos", "cxnrbyccocgcqmx", "thckcycctfllqcx", "ibirccrfmcmgszo",
				"pnhencqccealnzj" };

		Integer[] randSubStrCAnswer = { 7, 3, 3, 5, 7, 6, 3, 6, 5, 3, 1, 2, 0, 7, 1, 2, 4, 3, 4, 5, 6, 3, 3, 1, 3, 4, 6,
				3, 5, 3, 3, 5, 1, 6, 2, 5, 3, 3, 1, 1 };

		for (int i = 0; i < randText.length; i++)
		{
			String conditionString = String.format("subStrC(\"%s\", 'c') == %d", randText[i], randSubStrCAnswer[i]);
			assertEqualsInt("subStrC", conditionString, Ex14.subStrC(randText[i], 'c'), randSubStrCAnswer[i], true);
		}

		assertEqualsInt("subStrMaxC", "subStrMaxC(\"c\", 'c', 1) == 0", Ex14.subStrMaxC("c", 'c', 1), 0, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"cc\", 'c', 0) == 1", Ex14.subStrMaxC("cc", 'c', 0), 1, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"ccc\", 'c', 1) == 3", Ex14.subStrMaxC("ccc", 'c', 1), 3, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"aacaa\", 'c', 0) == 0", Ex14.subStrMaxC("aacaa", 'c', 0), 0, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"caacaac\", 'c', 10) == 3", Ex14.subStrMaxC("caacaac", 'c', 10), 3,
				true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"acacacacccac\", 'c', 2) == 9",
				Ex14.subStrMaxC("acacacacccac", 'c', 2), 15, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"acccacaacfdccadvsc\", 'c', 5) == 27",
				Ex14.subStrMaxC("acccacaacfdccadvsc", 'c', 5), 27, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"\", 'c', 3) == 0", Ex14.subStrMaxC("", 'c', 3), 0, true);
		assertEqualsInt("subStrMaxC", "subStrMaxC(\"asdvssdf\", 'c', 4) == 0", Ex14.subStrMaxC("asdvssdf", 'c', 3), 0,
				true);

		Integer[] randK = { 3, 0, 1, 0, 2, 4, 0, 5, 3, 1, 3, 2, 1, 0, 0, 3, 1, 5, 0, 4, 3, 5, 3, 1, 2, 2, 1, 4, 3, 0, 3,
				5, 5, 2, 1, 3, 4, 3, 0, 3 };
		Integer[] randSubStrMaxCAnswer = { 26, 4, 7, 6, 21, 25, 4, 27, 18, 7, 3, 6, 1, 8, 2, 6, 9, 10, 5, 20, 22, 10,
				10, 3, 9, 12, 13, 10, 18, 4, 10, 21, 3, 18, 5, 18, 10, 10, 2, 3 };

		for (int i = 0; i < randText.length; i++)
		{
			String conditionString = String.format("subStrMaxC(\"%s\", 'c', %d) == %d", randText[i], randK[i],
					randSubStrMaxCAnswer[i]);
			assertEqualsInt("subStrMaxC", conditionString, Ex14.subStrMaxC(randText[i], 'c', randK[i]),
					randSubStrMaxCAnswer[i], true);
		}

		//@formatter:off
		Integer[][] arr = 
				{
				{ 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0 }, { 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1 },
				{ 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 },
				{ 1, 1, 0, 0, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0 },
				{ 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 } };

		Integer[][] arrAfter = 
				{
				{ 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
				{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 },
				{ 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 }, 
				{ 3, 2, 1, 0, 1, 2, 1, 0, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 0, 1, 2, 1, 0, 1, 0, 0, 1, 0 }, 
				{ 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4 },
				{ 3, 2, 1, 0, 1, 0, 0, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5 },
				{ 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 2, 1, 0, 0, 1 },
				{ 4, 3, 2, 1, 0, 0, 1, 1, 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 1 },
				{ 2, 1, 0, 1, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7 },
				{ 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 },
				{ 2, 1, 0, 1, 1, 0, 1, 2, 3, 3, 2, 1, 0, 1, 2, 2, 1, 0, 1, 2 },
				{ 0, 1, 2, 3, 2, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 2, 3, 4, 5 },
				{ 2, 1, 0, 0, 1, 2, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },
				{ 7, 6, 5, 4, 3, 2, 1, 0, 0, 1, 2, 3, 4, 3, 2, 1, 0, 1, 1, 0 },
				{ 6, 5, 4, 3, 2, 1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 } };
		//@formatter:on

		for (int i = 0; i < arr.length; i++)
		{
			int[] asPremitive = Arrays.stream(arr[i]).mapToInt(Integer::intValue).toArray();
			Ex14.zeroDistance(asPremitive);
			Integer[] asObject = Arrays.stream(asPremitive).boxed().toArray(Integer[]::new);
			assertEqualsIntArray("zeroDistance", "zeroDistance(arr[" + i + "])", asObject, arrAfter[i], true);
		}

		assertBoolean("isTrans", "isTrans(\"abc\", \"aabbcc\")", Ex14.isTrans("abc", "aabbcc"), true);
		assertBoolean("isTrans", "isTrans(\"abbc\", \"aabbcc\")", Ex14.isTrans("abbc", "aabbcc"), true);
		assertBoolean("isTrans", "isTrans(\"aabbcc\", \"aabbcc\")", Ex14.isTrans("aabbcc", "aabbcc"), true);
		assertBoolean("isTrans", "isTrans(\"aabbccc\", \"aabbcc\")", Ex14.isTrans("aabbccc", "aabbcc"), false);
		assertBoolean("isTrans", "isTrans(\"a\", \"\")", Ex14.isTrans("a", ""), false);
		assertBoolean("isTrans", "isTrans(\"t\", \"tttt\")", Ex14.isTrans("t", "tttt"), true);
		assertBoolean("isTrans", "isTrans(\"ggdgg\", \"gddgg\")", Ex14.isTrans("ggdgg", "gddgg"), false);
		assertBoolean("isTrans", "isTrans(\"jjhhhllk\", \"jhhllk\")", Ex14.isTrans("jjhhhllk", "jhhllk"), false);
		assertBoolean("isTrans", "isTrans(\"ttrrryy\", \"ttttrrrrry\")", Ex14.isTrans("ttrrryy", "ttttrrrrry"), false);
		assertBoolean("isTrans", "isTrans(\"abc\", \"acb\")", Ex14.isTrans("abc", "acb"), false);
		assertBoolean("isTrans", "isTrans(\"abc\", \"acccbbb\")", Ex14.isTrans("abc", "acccbbb"), false);
		assertBoolean("isTrans", "isTrans(\"abbc\", \"aaabbbabbc\")", Ex14.isTrans("abbc", "aaabbbabbc"), false);
		assertBoolean("isTrans", "isTrans(\"abbc\", \"abbca\")", Ex14.isTrans("abbc", "abbca"), false);
		assertBoolean("isTrans", "isTrans(\"abbc\", \"abbcccca\")", Ex14.isTrans("abbc", "abbcccca"), false);
		assertBoolean("isTrans", "isTrans(\"\", \"\")", Ex14.isTrans("", ""), true);
		assertBoolean("isTrans", "isTrans(\"a\", \"\")", Ex14.isTrans("a", ""), false);
		assertBoolean("isTrans", "isTrans(\"\", \"a\")", Ex14.isTrans("", "a"), false);

		//@formatter:off
		Integer[][] countPathArr1 = {{20, 21, 32, 31, 65, 96}, {45, 30, 82, 79, 10, 52}, {51, 46, 96, 48, 45, 10}, {50, 13, 5, 95, 1, 37}};
		Integer[][] countPathArr2 = {{20, 97, 93, 15, 15, 61}, {37, 10, 36, 40, 93, 18}, {1, 12, 82, 85, 69, 25}, {12, 52, 95, 36, 7, 90}, {80, 84, 30, 97, 24, 50}, {46, 12, 56, 1, 70, 27}, {51, 6, 74, 7, 50, 48}, {10, 52, 23, 28, 75, 45}, {37, 26, 78, 90, 8, 64}, {97, 67, 2, 58, 92, 2}};
		Integer[][] countPathArr3 = {{10, 82, 51, 79, 20, 56, 1, 86, 60, 14, 3, 58, 36, 4, 95}, {10, 61, 16, 39, 12, 17, 81, 16, 34, 24, 47, 46, 74, 76, 25}, {50, 34, 38, 48, 4, 60, 3, 17, 57, 49, 78, 49, 31, 19, 85}, {67, 52, 38, 21, 20, 43, 98, 94, 7, 32, 23, 64, 47, 67, 96}, {53, 34, 3, 87, 32, 21, 53, 15, 8, 72, 30, 70, 87, 30, 40}, {25, 40, 78, 25, 6, 76, 6, 8, 74, 91, 65, 90, 15, 3, 32}, {84, 13, 76, 78, 10, 21, 68, 52, 83, 25, 37, 35, 60, 46, 62}, {31, 25, 23, 30, 26, 72, 49, 39, 94, 0, 75, 41, 53, 98, 14}, {64, 58, 59, 10, 43, 50, 4, 96, 84, 32, 0, 5, 36, 2, 96}, {1, 5, 37, 25, 48, 23, 70, 19, 41, 28, 37, 19, 70, 46, 31}, {61, 95, 75, 34, 80, 49, 98, 7, 8, 13, 73, 62, 87, 73, 53}, {49, 92, 70, 32, 58, 2, 89, 7, 23, 82, 26, 97, 5, 45, 79}, {76, 2, 64, 25, 97, 40, 7, 30, 30, 64, 95, 45, 75, 76, 53}, {23, 79, 32, 82, 74, 46, 43, 82, 16, 27, 54, 63, 32, 93, 13}, {27, 83, 73, 0, 49, 63, 78, 45, 3, 73, 45, 48, 69, 25, 16}, {28, 46, 90, 8, 29, 40, 50, 9, 60, 80, 28, 84, 51, 54, 76}, {13, 27, 35, 75, 5, 80, 74, 64, 68, 29, 38, 35, 14, 63, 59}, {41, 35, 10, 10, 57, 42, 98, 93, 59, 19, 40, 3, 35, 13, 17}, {0, 35, 12, 30, 98, 91, 86, 26, 74, 10, 7, 73, 21, 52, 28}, {89, 93, 82, 96, 24, 97, 92, 94, 6, 25, 51, 25, 51, 27, 82}};
		Integer[][] countPathArr4 = {{46, 70, 38}, {87, 83, 2}, {16, 40, 65}, {84, 58, 14}};
		Integer[][] countPathArr5 =	{{83, 17, 48}, {37, 95, 84}, {3, 90, 21}, {36, 75, 71}};
		Integer[][] countPathArr6 =	{{10, 1, 13, 71}, {10, 22, 17, 11}, {2, 7, 5, 25}, {39, 57, 91, 74}};
		Integer[][] countPathArr7 =	{{10, 20, 86, 30}, {20, 63, 21, 49}, {86, 12, 86, 5}, {18, 70, 29, 79}};
		Integer[][] countPathArr8 = {{68, 66, 19, 57}, {21, 4, 13, 58}, {0, 31, 15, 93}, {20, 47, 0, 72}};
		Integer[][] countPathArr9 = {{30, 18, 90, 50, 45, 31, 61}, {15, 29, 51, 5, 38, 63, 80}, {55, 61, 9, 63, 15, 26, 57}, {23, 30, 92, 89, 15, 89, 81}, {23, 71, 0, 43, 29, 97, 39}, {49, 44, 55, 20, 52, 41, 55}, {28, 44, 54, 70, 71, 23, 12}, {63, 41, 33, 32, 19, 67, 59}, {78, 80, 19, 19, 72, 54, 74}, {86, 19, 98, 85, 77, 19, 71}};
		Integer[][] countPathArr10 = {{20, 9, 10, 30, 15, 20, 23, 59, 15, 96}, {3, 78, 51, 80, 66, 38, 34, 85, 97, 8}, {31, 41, 64, 45, 12, 22, 17, 64, 92, 68}, {9, 86, 46, 30, 14, 33, 36, 88, 99, 97}, {30, 59, 43, 78, 12, 0, 79, 67, 46, 9}, {9, 43, 78, 99, 86, 97, 51, 54, 75, 35}, {86, 25, 24, 40, 38, 81, 50, 23, 76, 84}, {85, 45, 35, 11, 16, 8, 79, 16, 92, 9}, {93, 83, 53, 68, 56, 92, 31, 13, 71, 98}, {67, 75, 33, 71, 6, 81, 6, 70, 39, 35}};
		Integer[][] countPathArr11 = {{10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}, {10, 10, 10, 10, 10}};
		Integer[][] countPathArr12 = {{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}};
		Integer[][] countPathArr13 = {{2, 64, 3, 99, 43, 90, 83, 31, 53, 8, 76, 71, 43, 66, 25}};
		Integer[][] countPathArr14 = {{3}, {54}, {21}, {5}, {26}, {74}, {35}, {25}, {6}, {65}, {10}, {50}, {59}, {7}, {99}};
		Integer[][] countPathArr15 = {{3}};
		Integer[][] countPathArr16 = {{64}};
		Integer[][] countPathArr17 = {{30, 18, 90, 0, 45, 31, 61}, {15, 29, 51, 5, 38, 63, 80}, {55, 61, 9, 63, 15, 26, 57}, {23, 30, 92, 89, 15, 89, 81}, {23, 71, 0, 43, 29, 97, 39}, {49, 44, 55, 20, 52, 41, 55}, {28, 44, 54, 70, 71, 23, 12}, {63, 41, 33, 32, 19, 67, 59}, {78, 80, 19, 19, 72, 54, 74}, {86, 19, 98, 85, 77, 19, 71}};

		ArrayList<Integer[][]> countPathArrList = new ArrayList<Integer[][]>();
		countPathArrList.add(countPathArr1);
		countPathArrList.add(countPathArr2);
		countPathArrList.add(countPathArr3);
		countPathArrList.add(countPathArr4);
		countPathArrList.add(countPathArr5);
		countPathArrList.add(countPathArr6);
		countPathArrList.add(countPathArr7);
		countPathArrList.add(countPathArr8);
		countPathArrList.add(countPathArr9);
		countPathArrList.add(countPathArr10);
		countPathArrList.add(countPathArr11);
		countPathArrList.add(countPathArr12);
		countPathArrList.add(countPathArr13);
		countPathArrList.add(countPathArr14);
		countPathArrList.add(countPathArr15);
		countPathArrList.add(countPathArr16);
		countPathArrList.add(countPathArr17);

		ArrayList<Integer> countPathArrAnsList = new ArrayList<Integer>();
		countPathArrAnsList.add(3);
		countPathArrAnsList.add(6);
		countPathArrAnsList.add(10);
		countPathArrAnsList.add(0);
		countPathArrAnsList.add(0);
		countPathArrAnsList.add(3);
		countPathArrAnsList.add(3);
		countPathArrAnsList.add(0);
		countPathArrAnsList.add(4);
		countPathArrAnsList.add(5);
		countPathArrAnsList.add(70);
		countPathArrAnsList.add(70);
		countPathArrAnsList.add(1);
		countPathArrAnsList.add(1);
		countPathArrAnsList.add(1);
		countPathArrAnsList.add(1);
		countPathArrAnsList.add(2);

		ArrayList<String> countPathArrPathList = new ArrayList<String>();
		countPathArrPathList.add(
				"[0][0] -> [0][2] -> [2][5] -> [3][5]\r\n" + 
				"[0][0] -> [0][2] -> [3][4] -> [3][5]\r\n" + 
				"[0][0] -> [2][0] -> [3][5]");
		countPathArrPathList.add(
				"[0][0] -> [0][2] -> [9][5]\r\n" + 
				"[0][0] -> [2][0] -> [3][0] -> [5][1] -> [7][2] -> [9][5]\r\n" + 
				"[0][0] -> [2][0] -> [3][0] -> [4][2] -> [4][5] -> [9][5]\r\n" + 
				"[0][0] -> [2][0] -> [3][0] -> [4][2] -> [7][2] -> [9][5]\r\n" + 
				"[0][0] -> [2][0] -> [2][1] -> [4][2] -> [4][5] -> [9][5]\r\n" + 
				"[0][0] -> [2][0] -> [2][1] -> [4][2] -> [7][2] -> [9][5]");
		countPathArrPathList.add(
				"[0][0] -> [0][1] -> [8][3] -> [8][4] -> [11][8] -> [14][10] -> [19][14]\r\n" + 
				"[0][0] -> [0][1] -> [8][3] -> [8][4] -> [11][8] -> [13][11] -> [19][14]\r\n" + 
				"[0][0] -> [0][1] -> [8][3] -> [9][3] -> [11][8] -> [14][10] -> [19][14]\r\n" + 
				"[0][0] -> [0][1] -> [8][3] -> [9][3] -> [11][8] -> [13][11] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [7][2] -> [9][5] -> [11][8] -> [14][10] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [7][2] -> [9][5] -> [11][8] -> [13][11] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [8][4] -> [11][8] -> [14][10] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [8][4] -> [11][8] -> [13][11] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [9][3] -> [11][8] -> [14][10] -> [19][14]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [7][0] -> [8][3] -> [9][3] -> [11][8] -> [13][11] -> [19][14]");
		countPathArrPathList.add("None");
		countPathArrPathList.add("None");
		countPathArrPathList.add(
				"[0][0] -> [0][1] -> [1][1] -> [3][3] \r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [3][3] \r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [3][3]");
		countPathArrPathList.add(
				"[0][0]	 -> [0][1] -> [0][3] -> [3][3]\r\n" + 
				"[0][0] -> [0][1] -> [2][1] -> [3][3]\r\n" + 
				"[0][0] -> [1][0] -> [1][2] -> [3][3]");
		countPathArrPathList.add("None");
		countPathArrPathList.add(
				"[0][0] -> [0][3] -> [5][3] -> [5][5] -> [9][6]\r\n" + 
				"[0][0] -> [0][3] -> [5][3] -> [7][3] -> [9][6]\r\n" + 
				"[0][0] -> [3][0] -> [5][3] -> [5][5] -> [9][6]\r\n" + 
				"[0][0] -> [3][0] -> [5][3] -> [7][3] -> [9][6]");
		countPathArrPathList.add(
				"[0][0] -> [0][2] -> [0][3] -> [3][3] -> [3][6] -> [9][9]\r\n" + 
				"[0][0] -> [0][2] -> [0][3] -> [3][3] -> [6][3] -> [6][7] -> [9][9]\r\n" + 
				"[0][0] -> [0][2] -> [1][2] -> [6][3] -> [6][7] -> [9][9]\r\n" + 
				"[0][0] -> [2][0] -> [3][3] -> [3][6] -> [9][9]\r\n" + 
				"[0][0] -> [2][0] -> [3][3] -> [6][3] -> [6][7] -> [9][9]");
		countPathArrPathList.add(
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [0][4] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [4][0] -> [4][1] -> [4][2] -> [4][3] -> [4][4]");
		countPathArrPathList.add(
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [4][0] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [3][0] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [2][0] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [1][0] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [4][1] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [3][1] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [2][1] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [1][1] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [4][2] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [3][2] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [2][2] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [1][2] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [4][3] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [3][3] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [2][3] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [1][3] -> [1][4] -> [2][4] -> [3][4] -> [4][4]\r\n" + 
				"[0][0] -> [0][1] -> [0][2] -> [0][3] -> [0][4] -> [1][4] -> [2][4] -> [3][4] -> [4][4]");
		countPathArrPathList.add("[0][0] -> [0][2] -> [0][5] -> [0][14]");
		countPathArrPathList.add("[0][0] -> [3][0] -> [8][0] -> [14][0]");
		countPathArrPathList.add("[0][0]");
		countPathArrPathList.add("[0][0]");
		countPathArrPathList.add(
				"[0][0] -> [3][0] -> [5][3] -> [5][5] -> [9][6]\r\n" + 
				"[0][0] -> [3][0] -> [5][3] -> [7][3] -> [9][6]");

		//@formatter:on

		for (int i = 0; i < countPathArrList.size(); i++)
		{
			String message = String.format("Array:\r\n%sThe paths:\r\n%s", arrayDeepToString(countPathArrList.get(i)),
					countPathArrPathList.get(i));
			int[][] asPrimitive = new int[countPathArrList.get(i).length][countPathArrList.get(i)[0].length];

			for (int j = 0; j < countPathArrList.get(i).length; j++)
				for (int j2 = 0; j2 < countPathArrList.get(i)[0].length; j2++)
					asPrimitive[j][j2] = countPathArrList.get(i)[j][j2];

			assertEqualsInt("countPath", "countPath(countPathArr1) == " + countPathArrAnsList.get(i),
					Ex14.countPaths(asPrimitive), countPathArrAnsList.get(i), true, message);
		}

		results();
		exportLog("Ex14Tester");
	}

	public static void addTest(String methodTest, String conditionString, Object functionValue, Object expectedValue,
			boolean condition, boolean expectedResult, int stackTrace, String adiadditionalMessage)
	{
		int lineNum = Thread.currentThread().getStackTrace()[stackTrace].getLineNumber();
		testLog += "\n";
		testLog += addUnderline(String.format("Testing %s - Line %d:", methodTest, lineNum)) + "\r\n";
		testLog += String.format("Condition: %s -> %b\r\n", conditionString, condition);
		testLog += String.format("Expecting: %s\r\n", expectedResult);
		String methodString = functionValue instanceof Object[] ? arrayDeepToString((Object[]) functionValue)
				: functionValue.toString();
		testLog += String.format("Your %s method output: \r\n%s\r\n", methodTest, methodString);
		String expectString = expectedValue instanceof Object[] ? arrayDeepToString((Object[]) expectedValue)
				: expectedValue.toString();
		testLog += String.format("Expected method output: \r\n%s\r\n", expectString);
		testLog += adiadditionalMessage.length() == 0 ? "" : adiadditionalMessage + "\r\n";

		tests++;

		if (expectedResult == condition)
		{
			testLog += "Passed\r\n";
			passed++;
		}
		else
		{
			testLog += "Failed\r\n";
			faildLines.add(lineNum);
			faild++;
		}
	}

	public static String arrayDeepToString(Object[] arr)
	{
		String s = "";

		for (int i = 0; i < arr.length; i++)
			if (arr[i] instanceof Object[])
				s += arrayDeepToString((Object[]) arr[i]) + "\r\n";
			else
				s += arr[i].toString() + "\t";

		return s;
	}

	public static void assertEqualsInt(String methodTest, String conditionString, int functionValue, int expectedValue,
			boolean expectedResult)
	{
		addTest(methodTest, conditionString, functionValue, expectedValue, functionValue == expectedValue,
				expectedResult, 3, "");
	}

	public static void assertEqualsInt(String methodTest, String conditionString, int functionValue, int expectedValue,
			boolean expectedResult, String customMessage)
	{
		addTest(methodTest, conditionString, functionValue, expectedValue, functionValue == expectedValue,
				expectedResult, 3, customMessage);
	}

	public static void assertEqualsIntArray(String methodTest, String conditionString, Integer[] arr,
			Integer[] arrAfter, boolean expectedResult)
	{
		addTest(methodTest, conditionString, arr, arrAfter, Arrays.equals(arr, arrAfter), expectedResult, 3, "");
	}

	public static void assertBoolean(String methodTest, String conditionString, boolean functionValue,
			boolean expectedResult)
	{
		addTest(methodTest, conditionString, functionValue, expectedResult, functionValue, expectedResult, 3, "");
	}

	public static void results()
	{
		String resultLog = "";
		resultLog += addUnderline("Results:") + "\r\n";
		resultLog += String.format("You passed %d out of %d\r\n", passed, tests);

		if (faild > 0)
		{
			resultLog += String.format("You failed %d tests\r\n", faild);
			resultLog += String.format("Check the tests lines that you failed\r\n%s\r\n", faildLines);
		}
		else
			resultLog += "You are amazing :)\r\n";

		testLog = resultLog + testLog;
	}

	public static String addUnderline(String s)
	{
		return s + "\r\n" + new String(new char[s.length()]).replace("\0", "-");
	}

	public static void exportLog(String fileName)
	{
		try
		{
			String desktopPath = FileSystemView.getFileSystemView().getHomeDirectory().getPath();
			String filePath = String.format("%s\\%s.txt", desktopPath, fileName);

			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(testLog);
			bw.flush();
			bw.close();

			System.out.println("Check your desktop.");
			System.out.println("You should see a text file that named " + fileName);
		}
		catch (IOException e)
		{
			System.out.println("There was a problem when exporting the test result file");
			e.printStackTrace();
		}
	}

	public static String print2DArr(int[][] _arr)
	{
		String s = "";

		for (int i = 0; i < _arr.length; i++)
			s += Arrays.toString(_arr[i]) + "\r\n";

		return s;
	}

}
