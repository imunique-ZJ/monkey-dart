package loopz.monkeydart.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomGenerator {
	
	private static ThreadLocal<RandomNumber> RandomHolder
		= new ThreadLocal<RandomNumber>() {
			public RandomNumber initialValue() {
				return RandomNumber.newInstance();
			}
		};
	
	public int getRandom() {
		return RandomHolder.get().getRandomNumber();
	}
	
	public void setNumberRange(int range) {
		RandomHolder.get().setNumberRange(range);
	}
	
	public int getNumberRamge() {
		return RandomHolder.get().getNumberRange();
	}
	
	private static class RandomNumber {
		private Set<Integer> randomSet = new HashSet<Integer>();
		private int numberRange;
		private Random rand = new Random();
		
		public static RandomNumber newInstance() {
			return new RandomNumber();
		}
		
		public RandomNumber() {
			numberRange = 10;
		}
		
		public void setNumberRange(int numberRange) {
			this.numberRange = numberRange;
		}
		
		public int getNumberRange() {
			return numberRange;
		}
		
		public int getRandomNumber() {
			int num = 0;
			do {
				num = rand.nextInt(numberRange);
			} while (!randomSet.add(num) && randomSet.size() <= numberRange);
			return num;
		}
	}
}
