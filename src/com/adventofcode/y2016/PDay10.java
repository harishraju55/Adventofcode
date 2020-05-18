package com.adventofcode.y2016;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PDay10 {
	
	static Map<Integer, List<Integer>> outputBin = new HashMap<>();
	
	static BiConsumer<List<Integer>, Bot> chipsOnWatch = (chips, bot) -> {
		List<Integer> spyOnChips = Arrays.asList(17, 61);
		Collections.sort(chips);
		Collections.sort(spyOnChips);
		
		if(chips.equals(spyOnChips)) {
			System.out.println("Bot "+ bot.botId +" is is responsible for comparing "+ spyOnChips.get(0) +" and "+ spyOnChips.get(1) +".");
		}
	};
	
	static Consumer<Map<Integer, List<Integer>>> diveIntoOutputBin = (outputBin) -> {
		List<Integer> outputIds = Arrays.asList(0, 1, 2);
		int total =  1;
		for(Entry<Integer, List<Integer>> entry : outputBin.entrySet()) {
			if(outputIds.contains(entry.getKey())) {
				total = total * entry.getValue().get(0);
			}
		}
		System.out.println("Multiplying the output contents "+ outputIds +" value is : " + total);
	};
	
	public static void main(String[] args) {
		
		
		// output is logged.
		String inputString = "bot 135 gives low to bot 27 and high to bot 166\r\n" + 
				"bot 57 gives low to bot 4 and high to bot 186\r\n" + 
				"bot 115 gives low to output 2 and high to bot 80\r\n" + 
				"bot 44 gives low to bot 175 and high to bot 88\r\n" + 
				"bot 167 gives low to bot 42 and high to bot 168\r\n" + 
				"bot 18 gives low to bot 32 and high to bot 89\r\n" + 
				"bot 199 gives low to bot 75 and high to bot 40\r\n" + 
				"bot 129 gives low to bot 178 and high to bot 147\r\n" + 
				"bot 163 gives low to bot 49 and high to bot 160\r\n" + 
				"value 2 goes to bot 143\r\n" + 
				"bot 176 gives low to bot 139 and high to bot 117\r\n" + 
				"bot 194 gives low to bot 11 and high to bot 37\r\n" + 
				"bot 99 gives low to bot 163 and high to bot 138\r\n" + 
				"value 53 goes to bot 9\r\n" + 
				"bot 159 gives low to output 1 and high to bot 207\r\n" + 
				"bot 0 gives low to bot 105 and high to bot 13\r\n" + 
				"bot 6 gives low to bot 66 and high to bot 116\r\n" + 
				"bot 81 gives low to bot 54 and high to bot 10\r\n" + 
				"bot 27 gives low to bot 188 and high to bot 199\r\n" + 
				"bot 186 gives low to bot 84 and high to bot 123\r\n" + 
				"bot 154 gives low to bot 21 and high to bot 107\r\n" + 
				"bot 188 gives low to bot 92 and high to bot 75\r\n" + 
				"bot 164 gives low to bot 115 and high to bot 28\r\n" + 
				"bot 106 gives low to bot 48 and high to bot 155\r\n" + 
				"bot 193 gives low to bot 101 and high to bot 110\r\n" + 
				"bot 136 gives low to bot 166 and high to bot 152\r\n" + 
				"bot 7 gives low to bot 156 and high to bot 24\r\n" + 
				"bot 103 gives low to bot 182 and high to bot 0\r\n" + 
				"bot 101 gives low to bot 16 and high to bot 72\r\n" + 
				"bot 86 gives low to bot 102 and high to bot 48\r\n" + 
				"bot 78 gives low to bot 177 and high to bot 113\r\n" + 
				"value 17 goes to bot 198\r\n" + 
				"bot 54 gives low to bot 161 and high to bot 111\r\n" + 
				"bot 46 gives low to bot 74 and high to bot 39\r\n" + 
				"bot 22 gives low to bot 56 and high to bot 161\r\n" + 
				"bot 5 gives low to bot 186 and high to bot 123\r\n" + 
				"bot 137 gives low to bot 202 and high to bot 85\r\n" + 
				"bot 202 gives low to bot 108 and high to bot 118\r\n" + 
				"bot 174 gives low to bot 0 and high to bot 21\r\n" + 
				"bot 119 gives low to bot 68 and high to bot 53\r\n" + 
				"bot 151 gives low to bot 83 and high to bot 164\r\n" + 
				"bot 160 gives low to bot 33 and high to bot 97\r\n" + 
				"bot 76 gives low to bot 40 and high to bot 120\r\n" + 
				"bot 60 gives low to bot 103 and high to bot 174\r\n" + 
				"bot 203 gives low to bot 120 and high to bot 132\r\n" + 
				"bot 157 gives low to bot 116 and high to bot 11\r\n" + 
				"bot 98 gives low to bot 208 and high to bot 16\r\n" + 
				"bot 142 gives low to bot 114 and high to bot 71\r\n" + 
				"bot 143 gives low to bot 198 and high to bot 146\r\n" + 
				"bot 30 gives low to bot 59 and high to bot 135\r\n" + 
				"bot 87 gives low to bot 39 and high to bot 104\r\n" + 
				"bot 161 gives low to bot 173 and high to bot 125\r\n" + 
				"bot 104 gives low to bot 34 and high to bot 68\r\n" + 
				"bot 70 gives low to bot 112 and high to bot 176\r\n" + 
				"bot 92 gives low to bot 122 and high to bot 46\r\n" + 
				"bot 148 gives low to bot 28 and high to bot 58\r\n" + 
				"bot 49 gives low to output 0 and high to bot 33\r\n" + 
				"bot 140 gives low to bot 136 and high to bot 134\r\n" + 
				"bot 16 gives low to bot 170 and high to bot 79\r\n" + 
				"bot 13 gives low to bot 204 and high to bot 22\r\n" + 
				"bot 189 gives low to bot 148 and high to bot 45\r\n" + 
				"bot 89 gives low to bot 73 and high to bot 86\r\n" + 
				"value 31 goes to bot 50\r\n" + 
				"bot 166 gives low to bot 199 and high to bot 76\r\n" + 
				"bot 178 gives low to output 5 and high to bot 159\r\n" + 
				"bot 58 gives low to bot 167 and high to bot 126\r\n" + 
				"bot 149 gives low to bot 180 and high to bot 153\r\n" + 
				"bot 131 gives low to bot 97 and high to bot 66\r\n" + 
				"bot 64 gives low to bot 192 and high to bot 44\r\n" + 
				"bot 117 gives low to bot 140 and high to bot 134\r\n" + 
				"bot 156 gives low to bot 174 and high to bot 154\r\n" + 
				"value 11 goes to bot 19\r\n" + 
				"bot 1 gives low to bot 26 and high to bot 144\r\n" + 
				"bot 171 gives low to output 7 and high to bot 150\r\n" + 
				"bot 31 gives low to bot 110 and high to bot 127\r\n" + 
				"value 5 goes to bot 162\r\n" + 
				"bot 9 gives low to bot 8 and high to bot 128\r\n" + 
				"bot 93 gives low to bot 109 and high to bot 188\r\n" + 
				"value 47 goes to bot 184\r\n" + 
				"bot 80 gives low to output 19 and high to bot 42\r\n" + 
				"bot 155 gives low to bot 149 and high to bot 52\r\n" + 
				"bot 108 gives low to output 14 and high to bot 47\r\n" + 
				"bot 165 gives low to bot 200 and high to bot 141\r\n" + 
				"bot 184 gives low to bot 162 and high to bot 20\r\n" + 
				"bot 50 gives low to bot 143 and high to bot 4\r\n" + 
				"bot 28 gives low to bot 80 and high to bot 167\r\n" + 
				"bot 66 gives low to bot 151 and high to bot 55\r\n" + 
				"bot 201 gives low to bot 124 and high to bot 41\r\n" + 
				"bot 204 gives low to bot 94 and high to bot 56\r\n" + 
				"bot 134 gives low to bot 152 and high to bot 203\r\n" + 
				"bot 51 gives low to bot 36 and high to bot 142\r\n" + 
				"bot 2 gives low to bot 52 and high to bot 201\r\n" + 
				"bot 183 gives low to bot 38 and high to bot 78\r\n" + 
				"bot 26 gives low to bot 142 and high to bot 69\r\n" + 
				"bot 182 gives low to bot 3 and high to bot 105\r\n" + 
				"bot 72 gives low to bot 79 and high to bot 209\r\n" + 
				"bot 8 gives low to bot 185 and high to bot 65\r\n" + 
				"bot 75 gives low to bot 46 and high to bot 87\r\n" + 
				"bot 38 gives low to bot 82 and high to bot 177\r\n" + 
				"bot 147 gives low to bot 159 and high to bot 207\r\n" + 
				"bot 195 gives low to bot 104 and high to bot 119\r\n" + 
				"bot 63 gives low to bot 126 and high to bot 172\r\n" + 
				"bot 144 gives low to bot 69 and high to bot 82\r\n" + 
				"bot 83 gives low to output 3 and high to bot 115\r\n" + 
				"bot 43 gives low to bot 194 and high to bot 91\r\n" + 
				"value 37 goes to bot 8\r\n" + 
				"bot 82 gives low to bot 193 and high to bot 31\r\n" + 
				"bot 150 gives low to output 18 and high to bot 49\r\n" + 
				"value 23 goes to bot 182\r\n" + 
				"bot 67 gives low to bot 61 and high to bot 165\r\n" + 
				"bot 77 gives low to bot 107 and high to bot 122\r\n" + 
				"bot 130 gives low to bot 141 and high to bot 30\r\n" + 
				"value 73 goes to bot 12\r\n" + 
				"bot 41 gives low to bot 99 and high to bot 208\r\n" + 
				"bot 170 gives low to bot 131 and high to bot 6\r\n" + 
				"bot 120 gives low to bot 195 and high to bot 132\r\n" + 
				"bot 118 gives low to bot 47 and high to bot 129\r\n" + 
				"bot 100 gives low to bot 150 and high to bot 163\r\n" + 
				"value 67 goes to bot 185\r\n" + 
				"bot 152 gives low to bot 76 and high to bot 203\r\n" + 
				"bot 162 gives low to bot 67 and high to bot 205\r\n" + 
				"value 7 goes to bot 32\r\n" + 
				"bot 121 gives low to bot 172 and high to bot 158\r\n" + 
				"bot 65 gives low to bot 57 and high to bot 5\r\n" + 
				"bot 122 gives low to bot 81 and high to bot 74\r\n" + 
				"bot 21 gives low to bot 13 and high to bot 17\r\n" + 
				"bot 23 gives low to bot 133 and high to bot 1\r\n" + 
				"bot 36 gives low to bot 201 and high to bot 114\r\n" + 
				"bot 138 gives low to bot 160 and high to bot 131\r\n" + 
				"bot 55 gives low to bot 164 and high to bot 148\r\n" + 
				"bot 123 gives low to bot 70 and high to bot 176\r\n" + 
				"value 61 goes to bot 61\r\n" + 
				"bot 107 gives low to bot 17 and high to bot 81\r\n" + 
				"bot 19 gives low to bot 60 and high to bot 156\r\n" + 
				"value 41 goes to bot 12\r\n" + 
				"value 29 goes to bot 18\r\n" + 
				"value 13 goes to bot 60\r\n" + 
				"bot 62 gives low to bot 20 and high to bot 64\r\n" + 
				"bot 40 gives low to bot 87 and high to bot 195\r\n" + 
				"bot 90 gives low to bot 64 and high to bot 112\r\n" + 
				"bot 69 gives low to bot 71 and high to bot 193\r\n" + 
				"bot 35 gives low to output 4 and high to bot 108\r\n" + 
				"bot 177 gives low to bot 31 and high to bot 113\r\n" + 
				"bot 59 gives low to bot 93 and high to bot 27\r\n" + 
				"bot 187 gives low to bot 89 and high to bot 94\r\n" + 
				"bot 73 gives low to output 9 and high to bot 102\r\n" + 
				"bot 45 gives low to bot 58 and high to bot 63\r\n" + 
				"bot 39 gives low to bot 23 and high to bot 34\r\n" + 
				"bot 110 gives low to bot 72 and high to bot 190\r\n" + 
				"bot 181 gives low to bot 15 and high to bot 93\r\n" + 
				"bot 95 gives low to bot 7 and high to bot 15\r\n" + 
				"bot 33 gives low to output 13 and high to bot 169\r\n" + 
				"bot 20 gives low to bot 205 and high to bot 192\r\n" + 
				"bot 158 gives low to bot 85 and high to bot 29\r\n" + 
				"bot 61 gives low to bot 14 and high to bot 200\r\n" + 
				"value 71 goes to bot 103\r\n" + 
				"bot 192 gives low to bot 130 and high to bot 175\r\n" + 
				"bot 112 gives low to bot 44 and high to bot 139\r\n" + 
				"bot 96 gives low to bot 144 and high to bot 38\r\n" + 
				"bot 32 gives low to output 11 and high to bot 73\r\n" + 
				"bot 180 gives low to output 10 and high to bot 171\r\n" + 
				"value 59 goes to bot 3\r\n" + 
				"bot 208 gives low to bot 138 and high to bot 170\r\n" + 
				"bot 198 gives low to bot 184 and high to bot 62\r\n" + 
				"bot 207 gives low to output 16 and high to output 8\r\n" + 
				"bot 196 gives low to bot 43 and high to bot 91\r\n" + 
				"bot 10 gives low to bot 111 and high to bot 133\r\n" + 
				"bot 168 gives low to bot 35 and high to bot 202\r\n" + 
				"bot 113 gives low to bot 127 and high to bot 196\r\n" + 
				"bot 169 gives low to output 20 and high to bot 83\r\n" + 
				"bot 3 gives low to bot 18 and high to bot 187\r\n" + 
				"bot 52 gives low to bot 153 and high to bot 124\r\n" + 
				"bot 190 gives low to bot 209 and high to bot 43\r\n" + 
				"bot 125 gives low to bot 2 and high to bot 36\r\n" + 
				"bot 173 gives low to bot 155 and high to bot 2\r\n" + 
				"bot 153 gives low to bot 171 and high to bot 100\r\n" + 
				"bot 34 gives low to bot 1 and high to bot 96\r\n" + 
				"bot 84 gives low to bot 90 and high to bot 70\r\n" + 
				"bot 12 gives low to bot 9 and high to bot 128\r\n" + 
				"bot 24 gives low to bot 154 and high to bot 77\r\n" + 
				"bot 179 gives low to bot 63 and high to bot 121\r\n" + 
				"bot 85 gives low to bot 118 and high to bot 29\r\n" + 
				"bot 11 gives low to bot 189 and high to bot 145\r\n" + 
				"bot 116 gives low to bot 55 and high to bot 189\r\n" + 
				"bot 132 gives low to bot 119 and high to bot 53\r\n" + 
				"bot 15 gives low to bot 24 and high to bot 109\r\n" + 
				"bot 102 gives low to output 15 and high to bot 197\r\n" + 
				"value 43 goes to bot 206\r\n" + 
				"bot 37 gives low to bot 145 and high to bot 25\r\n" + 
				"bot 53 gives low to bot 183 and high to bot 78\r\n" + 
				"bot 197 gives low to output 12 and high to bot 180\r\n" + 
				"bot 47 gives low to output 17 and high to bot 178\r\n" + 
				"bot 17 gives low to bot 22 and high to bot 54\r\n" + 
				"bot 56 gives low to bot 106 and high to bot 173\r\n" + 
				"bot 191 gives low to bot 135 and high to bot 136\r\n" + 
				"bot 127 gives low to bot 190 and high to bot 196\r\n" + 
				"bot 172 gives low to bot 137 and high to bot 158\r\n" + 
				"bot 4 gives low to bot 146 and high to bot 84\r\n" + 
				"bot 42 gives low to output 6 and high to bot 35\r\n" + 
				"bot 145 gives low to bot 45 and high to bot 179\r\n" + 
				"bot 133 gives low to bot 51 and high to bot 26\r\n" + 
				"bot 139 gives low to bot 88 and high to bot 117\r\n" + 
				"bot 105 gives low to bot 187 and high to bot 204\r\n" + 
				"bot 126 gives low to bot 168 and high to bot 137\r\n" + 
				"bot 128 gives low to bot 65 and high to bot 5\r\n" + 
				"bot 114 gives low to bot 41 and high to bot 98\r\n" + 
				"bot 14 gives low to bot 206 and high to bot 95\r\n" + 
				"bot 91 gives low to bot 37 and high to bot 25\r\n" + 
				"bot 206 gives low to bot 19 and high to bot 7\r\n" + 
				"value 19 goes to bot 14\r\n" + 
				"bot 185 gives low to bot 50 and high to bot 57\r\n" + 
				"bot 205 gives low to bot 165 and high to bot 130\r\n" + 
				"bot 109 gives low to bot 77 and high to bot 92\r\n" + 
				"bot 175 gives low to bot 30 and high to bot 191\r\n" + 
				"bot 29 gives low to bot 129 and high to bot 147\r\n" + 
				"bot 74 gives low to bot 10 and high to bot 23\r\n" + 
				"bot 94 gives low to bot 86 and high to bot 106\r\n" + 
				"bot 25 gives low to bot 179 and high to bot 121\r\n" + 
				"bot 71 gives low to bot 98 and high to bot 101\r\n" + 
				"bot 209 gives low to bot 157 and high to bot 194\r\n" + 
				"bot 88 gives low to bot 191 and high to bot 140\r\n" + 
				"bot 124 gives low to bot 100 and high to bot 99\r\n" + 
				"bot 97 gives low to bot 169 and high to bot 151\r\n" + 
				"bot 141 gives low to bot 181 and high to bot 59\r\n" + 
				"bot 146 gives low to bot 62 and high to bot 90\r\n" + 
				"bot 200 gives low to bot 95 and high to bot 181\r\n" + 
				"bot 79 gives low to bot 6 and high to bot 157\r\n" + 
				"bot 48 gives low to bot 197 and high to bot 149\r\n" + 
				"value 3 goes to bot 67\r\n" + 
				"bot 68 gives low to bot 96 and high to bot 183\r\n" + 
				"bot 111 gives low to bot 125 and high to bot 51";

		List<String> inputTokens = Arrays.asList(inputString.split("\\s*\\r\\n\\s*"));
		
		Map<Integer, Bot> masterInstructions = new HashMap<>();
		Map<Integer, List<Integer>> chipMovement = new HashMap<>();
		
		// process instructions from input string.
		processInstructions(inputTokens, masterInstructions, chipMovement);
		
		// process chips
		processChips(masterInstructions, chipMovement);
		
		// checking the output bin.
		diveIntoOutputBin.accept(outputBin);

	}
	
	private static void processChips(Map<Integer, Bot> masterInstructions, Map<Integer, List<Integer>> chipMovement) {
		// begin the chip movement through the robots line.
		boolean nextIter = true;
		while(nextIter) {
			Map<Integer, List<Integer>> tempChipMovement = new HashMap<>();
			for(Entry<Integer, List<Integer>> entry : chipMovement.entrySet()) {
				if(entry.getValue().size() == 2) {
					runLine(entry, tempChipMovement, masterInstructions);
				} else {
					tempChipMovement.computeIfAbsent(entry.getKey(), k -> new ArrayList<>()).addAll(entry.getValue());
				}
			}
			// check if there are robots with two chips in the line.
			nextIter = false;
			for(Entry<Integer, List<Integer>> entry : tempChipMovement.entrySet()) {
				if(entry.getValue().size() == 2) {
					nextIter = true;
				}
			}
			chipMovement = tempChipMovement;
		}
	}
	
	private static void runLine(Entry<Integer, List<Integer>> entry, Map<Integer, List<Integer>> tempChipMovement, Map<Integer, Bot> masterInstructions) {
		if(masterInstructions.get(entry.getKey()) != null) {
			Bot bot = masterInstructions.get(entry.getKey());
			List<Integer> chips = entry.getValue();
			Collections.sort(chips);
			
			chipsOnWatch.accept(chips, bot);
			
			if(bot.isLowerOutput()) {
				// goes to the output bin.
				outputBin.computeIfAbsent(bot.getLower(), k -> new ArrayList<>()).add(chips.get(0));
			} else {
				tempChipMovement.computeIfAbsent(bot.getLower(), k -> new ArrayList<>()).add(chips.get(0));
			}
			
			if(bot.isHigherOutput()) {
				// goes to the output bin.
				outputBin.computeIfAbsent(bot.getHigher(), k -> new ArrayList<>()).add(chips.get(1));
			} else {
				tempChipMovement.computeIfAbsent(bot.getHigher(), k -> new ArrayList<>()).add(chips.get(chips.size() - 1));
			}
		} else {
			System.out.println(" No Instructions found.. for the Bot : " + entry.getKey());
		}
		
	}
	
	private static void processInstructions(List<String> inputTokens, Map<Integer, Bot> mainInstructions, Map<Integer, List<Integer>> chipMovement) {
		Pattern numberPattern = Pattern.compile("[0-9]{1,3}");
		Pattern outputPattern = Pattern.compile("output [0-9]{1,3}");
		for (String token : inputTokens) {
			Matcher  numberMatcher = numberPattern.matcher(token);
			Matcher  outputMatcher = outputPattern.matcher(token);
			if(InputPattern.DECISION_INSTRUCTION.test(token)) {
				boolean lowOutput = false, highOutput = false;
				int botId = -1, lower = -1, higher = -1;
				int numCount = 1;
				while(numberMatcher.find()) {
					if(numCount == 1) botId = Integer.parseInt(numberMatcher.group());
					if(numCount == 2) lower = Integer.parseInt(numberMatcher.group());
					if(numCount == 3) higher = Integer.parseInt(numberMatcher.group());
					
					numCount++;
		        }
				int outputCount = 1;
				while(outputMatcher.find()) {
					if(outputCount == 1) lowOutput = true;
					if(outputCount == 2) highOutput = true;
					
					outputCount++;
		        }
				if(botId >= 0 && lower >= 0 && higher >= 0) {
					mainInstructions.put(botId, new Bot(botId, lower, higher, lowOutput, highOutput));
				}
			}
			if(InputPattern.CHIP_ASSIGNING_INSTRUCTION.test(token)) {
				int chipId = -1, botId = -1;
				int numCount = 1;
				while(numberMatcher.find()) {
					if(numCount == 1) chipId = Integer.parseInt(numberMatcher.group());
					if(numCount == 2) botId = Integer.parseInt(numberMatcher.group());
					
					numCount++;
		        }
				if(botId >= 0 && chipId >= 0) {
					chipMovement.computeIfAbsent(botId, k -> new ArrayList<>()).add(chipId);
				}
			}
		}
	}

	enum InputPattern implements Predicate<String> {
		DECISION_INSTRUCTION(token -> token.startsWith("bot")),
		CHIP_ASSIGNING_INSTRUCTION(token -> Pattern.compile("value [0-9]* goes to bot [0-9]*").matcher(token).matches());

		Predicate<String> predicate;
		
		InputPattern(Predicate<String> predicate) {
			this.predicate = predicate;
		}
		
		@Override
		public boolean test(String token) {
			return this.predicate.test(token);
		}
	}
	
	static class Bot {
		int botId;
		int lower;
		int higher;
		boolean lowerOutput;
		boolean higherOutput;
		
		public Bot(int botId, int lower, int higher, boolean lowerOutput, boolean higherOutput) {
			super();
			this.botId = botId;
			this.lower = lower;
			this.higher = higher;
			this.lowerOutput = lowerOutput;
			this.higherOutput = higherOutput;
		}
		public boolean isLowerOutput() {
			return lowerOutput;
		}
		public void setLowerOutput(boolean lowerOutput) {
			this.lowerOutput = lowerOutput;
		}
		public boolean isHigherOutput() {
			return higherOutput;
		}
		public void setHigherOutput(boolean higherOutput) {
			this.higherOutput = higherOutput;
		}
		public int getBotId() {
			return botId;
		}
		public void setBotId(int botId) {
			this.botId = botId;
		}
		public int getLower() {
			return lower;
		}
		public void setLower(int lower) {
			this.lower = lower;
		}
		public int getHigher() {
			return higher;
		}
		public void setHigher(int higher) {
			this.higher = higher;
		}
		@Override
		public String toString() {
			return "Bot [botId=" + botId + ", lower=" + lower + ", higher=" + higher + ", lowerOutput=" + lowerOutput
					+ ", higherOutput=" + higherOutput + "]";
		}
	}
}
