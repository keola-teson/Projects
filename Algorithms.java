
public class Algorithms
{
	private static final int length = 5, maximum = 20, minimum = 1;
	private static int[] numbers = createRandomArray(length, maximum, minimum);
	private static int[] numbersCopy = copyArray(numbers);
	
	public static void main(String[] args)
	{
		main();
	}
	
	private static int[] createRandomArray(int length, int maximum, int minimum)
	{
		int[] array = new int[length];
		for (int i = 0; i < length; i++)
		{
			array[i] = (int)(Math.random() * maximum + minimum);
		}
		
		return array;
	}
	private static void printArray(int[] array)
	{
		for (int i : array)
		{
			System.out.print(i + " ");
		}
		System.out.println("\b");
	}
	private static void swap(int[] array, int index1, int index2)
	{
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	private static int[] copyArray(int[] array)
	{
		int[] copy = new int[array.length];
		
		for (int i = 0; i < array.length; i++)
		{
			copy[i] = array[i];
		}
		
		return copy;
	}
	private static void main()
	{
		System.out.println("Original array: "); printArray(numbers);
		
		System.out.println("\nThe smallest number in the array: \n" + returnSmallest(numbers));
		System.out.println("\nThe index of the smallest number: \n" + returnIndexOfSmallest(numbers));
		System.out.println("\nThe average of the array: \n" + averageEachElement(numbers));
		
		changeFiveToZeros(numbers);
		System.out.println("\nChanging the consecutive 5s: "); printArray(numbers);
		
		System.out.println("\nIs there three numbers in a row?: \n" + isThreeInARow(numbers));
		int random = (int)(Math.random() * maximum + minimum);
		System.out.println("\nThe amount of times " + random + " shows up: \n" + returnAmount(numbers, random));
		
		reverseArray(numbers);
		System.out.println("\nReversed array: "); printArray(numbers);
		
		shiftElemsRight(numbers);
		System.out.println("\nEvery number shifted to the right: "); printArray(numbers);
		
		insertionSort(numbers);
		System.out.println("\nSorted array (using insertion sort): "); printArray(numbers);
		
		System.out.println("\nArray reset: "); printArray(numbersCopy);
		selectionSort(numbersCopy);
		System.out.println("\nSorted array (using selection sort): "); printArray(numbersCopy);
	}
	
	/**
	 * Method to return the smallest item in the array
	 * @param array
	 * @return the smallest number in the array
	 */
	public static int returnSmallest(int[] array)
	{
		//the first number in the array
		int smallest = array[0];
		
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//checks if the current element of the loop is smaller than the original smallest number
			if (array[i] < smallest)
			{
				//changes the smallest value to the current element
				smallest = array[i];
			}
		}
		
		return smallest;
	}
	
	/**
	 * Method to return the index of the smallest item in the array
	 * @param array
	 * @return the index of the smallest item in the array
	 */
	public static int returnIndexOfSmallest(int[] array)
	{
		//int to return
		int index = 0;
		//the first number in the array
		int smallest = array[0];
		
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//checks if the current element of the loop is smaller than the original smallest number
			if (array[i] < smallest)
			{
				//changes the smallest value to the current element
				smallest = array[i];
				//changes the index value to the current value of j
				index = i;
			}
		}
		
		return index;
	}
	
	/**
	 * Method to return the average of each element
	 * @param array
	 * @return a sum of every number / the length of the array
	 */
	public static int averageEachElement(int[] array)
	{
		//int to return
		int sum = 0;
		
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//adds the current number to sum
			sum += array[i];
		}
		
		//divides the value of sum by the length of the array and returns it
		return sum / array.length;
	}
	
	/**
	 * Method to change two consecutive 5s to 0s
	 * @param array
	 */
	public static void changeFiveToZeros(int[] array)
	{
		//loops through the array - 1
		for (int i = 0; i < array.length - 1; i++)
		{
			//checks if the current and the next numbers are both 5
			if (array[i] == 5 && array[i + 1] == 5)
			{
				//changes both values to 5
				array[i] = 0;
				array[i + 1] = 0;
			}
		}
	}
	
	/**
	 * Method to return true or false is there is an item that appears three in a row
	 * @param array
	 * @return true or false
	 */
	public static boolean isThreeInARow(int[] array)
	{
		//loops through the array - 2 elements
		for (int i = 0; i < array.length - 2; i++)
		{
			//checks if the current next and next after that are the same
			if (array[i + 2] == array[i] && array[i + 1] == array[i])
			{
				//returns true. breaks the loop
				return true;
			}
		}
		//if there wasn't a three in a row, return false
		return false;
	}
	
	/**
	 * Method to return the amount of times the passed number appears in the passed array
	 * @param array
	 * @param findMe
	 * @return a count of the passed number in the array
	 */
	public static int returnAmount(int[] array, int findMe)
	{
		int count = 0;
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//checks if the current number is the same as the findMe number
			if (array[i] == findMe)
			{
				//increments count
				count++;
			}
		}
		
		return count;
	}
	
	/**
	 * Method to reverse the array
	 * @param array
	 */
	public static void reverseArray(int[] array)
	{
		//a copy of the passed array
		int[] copy = new int[array.length];
		
		//copies each element into the new array
		for (int i = 0; i < array.length; i++)
		{
			copy[i] = array[i];
		}
		
		//loops through the array going backwards
		for (int i = array.length - 1; i >= 0; i--)
		{
			//changes the current element in the passed array to the reversed current element in the array
			array[i] = copy[(array.length - 1) - i];
		}
	}
	
	/**
	 * Method to shift every element in the array to the right
	 * @param array
	 */
	public static void shiftElemsRight(int[] array)
	{
		//stores the last number in the array
		int last = array[array.length - 1];
		
		//loops from the last element in the array to the second
		for (int i = array.length - 1; i > 0; i--)
		{
			//changes the current element to the previous elements
			array[i] = array[i - 1];
		}
		
		//changes the first element to the last element
		array[0] = last;
	}
	
	/**
	 * Method to sort the passed array using insertion sort algorithm
	 * @param array
	 */
	public static void insertionSort(int[] array)
	{
		//loops through the array from the second element
		for (int i = 1; i < array.length; i++)
		{
			//loops from the current element at i to the first element
			//also checks if the current element is smaller than the previous element
			for (int j = i; j > 0 && array[j] < array[j - 1]; j--)
			{
				//swaps the current and previous element (calls the swap method)
				swap(array, j, j - 1);
			}
		}
	}
	
	/**
	 * Method to sort the passed array using the selection sort algorithm
	 * @param array
	 */
	public static void selectionSort(int[] array)
	{
		//loops through the array
		for (int i = 0; i < array.length; i++)
		{
			//stores the smallest number in the array
			int smallest = array[i];
			//loops through the array starting at the element at i
			for (int j = i; j < array.length; j++)
			{
				//checks if the current element in the nested loop is smaller than the value in smallest
				if (array[j] < smallest)
				{
					//changes smallest
					smallest = array[j];
					//swaps them
					swap(array, i, j);
				}
			}
		}
	}
}
