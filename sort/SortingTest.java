package sort;

import static org.junit.Assert.*;
import static sort.Sorting.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SortingTest {

  ArrayList<String> testEmpty = new ArrayList<String>(Arrays.asList(""));
  ArrayList<String> sUnsorted = new ArrayList<String>(Arrays.asList("f", "h", "d", "b", "c", "e", "i", "a", "l", "g"));
  ArrayList<String> sSorted = new ArrayList<String>(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "l"));
  ArrayList<String> sInverse = new ArrayList<String>(Arrays.asList("l", "i", "h", "g", "f", "e", "d", "c", "b", "a"));
  ArrayList<String> sAlmost = new ArrayList<String>(Arrays.asList("a", "b", "c", "e", "d", "h", "g", "f", "i", "l"));
  ArrayList<String> sRepeated = new ArrayList<String>(Arrays.asList("a", "a", "e", "f", "c", "c", "e", "g", "h", "g"));

  ArrayList<Integer> iUnsorted = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 5, 2, 7, 9, 8, 6, 0));
  ArrayList<Integer> iSorted = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
  ArrayList<Integer> iInverse = new ArrayList<Integer>(Arrays.asList(9, 8, 7, 6, 5, 4, 3, 2, 1));
  ArrayList<Integer> iAlmost = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 9, 8, 6, 5, 7));
  ArrayList<Integer> iRepeated = new ArrayList<Integer>(Arrays.asList(0, 5, 7, 1, 1, 0, 5, 3, 6, 4, 8, 9));

  @Test
  public void testInsertionSortOnEmpty() {
    insertionSort(testEmpty);
    assertTrue(isSorted(testEmpty));
  }

  @Test
  public void testInsertionSortOnUnsortedString() {
    insertionSort(sUnsorted);
    assertTrue(isSorted(sUnsorted));
  }

  @Test
  public void testInsertionSortOnSortedString() {
    insertionSort(sSorted);
    assertTrue(isSorted(sSorted));
  }

  @Test
  public void testInsertionSortOnInverseString() {
    insertionSort(sInverse);
    assertTrue(isSorted(sInverse));
  }

  @Test
  public void testInsertionSortOnAlmostString() {
    insertionSort(sAlmost);
    assertTrue(isSorted(sAlmost));
  }

  @Test
  public void testInsertionSortOnRepeatedString() {
    insertionSort(sRepeated);
    assertTrue(isSorted(sRepeated));
  }
  
  @Test
  public void testInsertionSortOnUnsortedInteger() {
    insertionSort(iUnsorted);
    assertTrue(isSorted(iUnsorted));
  }

  @Test
  public void testInsertionSortOnSortedOnInteger() {
    insertionSort(iSorted);
    assertTrue(isSorted(iSorted));
  }

  @Test
  public void testInsertionSortOnInverseInteger() {
    insertionSort(iInverse);
    assertTrue(isSorted(iInverse));
  }

  @Test
  public void testInsertionSortOnAlmostInteger() {
    insertionSort(iAlmost);
    assertTrue(isSorted(iAlmost));
  }

  @Test
  public void testInsertionSortOnRepeatedInteger() {
    insertionSort(iRepeated);
    assertTrue(isSorted(iRepeated));
  }

  @Test
  public void testInsertionBinSortOnEmpty() {
    insertionBinSort(testEmpty);
    assertTrue(isSorted(testEmpty));
  }

  @Test
  public void testInsertionBinSortOnUnsortedString() {
    insertionBinSort(sUnsorted);
    assertTrue(isSorted(sUnsorted));
  }

  @Test
  public void testInsertionBinSortOnSortedString() {
    insertionBinSort(sSorted);
    assertTrue(isSorted(sSorted));
  }

  @Test
  public void testInsertionBinSortOnInverseString() {
    insertionBinSort(sInverse);
    assertTrue(isSorted(sInverse));
  }

  @Test
  public void testInsertionBinSortOnAlmostString() {
    insertionBinSort(sAlmost);
    assertTrue(isSorted(sAlmost));
  }

  @Test
  public void testInsertionBinSortOnRepeatedString() {
    insertionBinSort(sRepeated);
    assertTrue(isSorted(sRepeated));
  }
  
  @Test
  public void testInsertionBinSortOnUnsortedInteger() {
    insertionBinSort(iUnsorted);
    assertTrue(isSorted(iUnsorted));
  }

  @Test
  public void testInsertionBinSortOnSortedOnInteger() {
    insertionBinSort(iSorted);
    assertTrue(isSorted(iSorted));
  }

  @Test
  public void testInsertionBinSortOnInverseInteger() {
    insertionBinSort(iInverse);
    assertTrue(isSorted(iInverse));
  }

  @Test
  public void testInsertionBinSortOnAlmostInteger() {
    insertionBinSort(iAlmost);
    assertTrue(isSorted(iAlmost));
  }

  @Test
  public void testInsertionBinSortOnRepeatedInteger() {
    insertionBinSort(iRepeated);
    assertTrue(isSorted(iRepeated));
  }
  
  @Test
  public void testMergeSortBasicOnEmpty() {
    mergeSortBasic(testEmpty);
    assertTrue(isSorted(testEmpty));
  }

  @Test
  public void testMergeSortBasicOnUnsortedString() {
    mergeSortBasic(sUnsorted);
    assertTrue(isSorted(sUnsorted));
  }

  @Test
  public void testMergeSortBasicOnSortedString() {
    mergeSortBasic(sSorted);
    assertTrue(isSorted(sSorted));
  }

  @Test
  public void testMergeSortBasicOnInverseString() {
    mergeSortBasic(sInverse);
    assertTrue(isSorted(sInverse));
  }

  @Test
  public void testMergeSortBasicOnAlmostString() {
    mergeSortBasic(sAlmost);
    assertTrue(isSorted(sAlmost));
  }

  @Test
  public void testMergeSortBasicOnRepeatedString() {
    mergeSortBasic(sRepeated);
    assertTrue(isSorted(sRepeated));
  }
  
  @Test
  public void testMergeSortBasicOnUnsortedInteger() {
    mergeSortBasic(iUnsorted);
    assertTrue(isSorted(iUnsorted));
  }

  @Test
  public void testMergeSortBasicOnSortedOnInteger() {
    mergeSortBasic(iSorted);
    assertTrue(isSorted(iSorted));
  }

  @Test
  public void testMergeSortBasicOnInverseInteger() {
    mergeSortBasic(iInverse);
    assertTrue(isSorted(iInverse));
  }

  @Test
  public void testMergeSortBasicOnAlmostInteger() {
    mergeSortBasic(iAlmost);
    assertTrue(isSorted(iAlmost));
  }

  @Test
  public void testMergeSortBasicOnRepeatedInteger() {
    mergeSortBasic(iRepeated);
    assertTrue(isSorted(iRepeated));
  }
  
  @Test
  public void testMergeSortNoGarbageOnEmpty() {
    mergeSortNoGarbage(testEmpty);
    assertTrue(isSorted(testEmpty));
  }

  @Test
  public void testMergeSortNoGarbageOnUnsortedString() {
    mergeSortNoGarbage(sUnsorted);
    assertTrue(isSorted(sUnsorted));
  }

  @Test
  public void testMergeSortNoGarbageOnSortedString() {
    mergeSortNoGarbage(sSorted);
    assertTrue(isSorted(sSorted));
  }

  @Test
  public void testMergeSortNoGarbageOnInverseString() {
    mergeSortNoGarbage(sInverse);
    assertTrue(isSorted(sInverse));
  }

  @Test
  public void testMergeSortNoGarbageOnAlmostString() {
    mergeSortNoGarbage(sAlmost);
    assertTrue(isSorted(sAlmost));
  }

  @Test
  public void testMergeSortNoGarbageOnRepeatedString() {
    mergeSortNoGarbage(sRepeated);
    assertTrue(isSorted(sRepeated));
  }
  
  @Test
  public void testMergeSortNoGarbageOnUnsortedInteger() {
    mergeSortNoGarbage(iUnsorted);
    assertTrue(isSorted(iUnsorted));
  }

  @Test
  public void testMergeSortNoGarbageOnSortedOnInteger() {
    mergeSortNoGarbage(iSorted);
    assertTrue(isSorted(iSorted));
  }

  @Test
  public void testMergeSortNoGarbageOnInverseInteger() {
    mergeSortNoGarbage(iInverse);
    assertTrue(isSorted(iInverse));
  }

  @Test
  public void testMergeSortNoGarbageOnAlmostInteger() {
    mergeSortNoGarbage(iAlmost);
    assertTrue(isSorted(iAlmost));
  }

  @Test
  public void testMergeSortNoGarbageOnRepeatedInteger() {
    mergeSortNoGarbage(iRepeated);
    assertTrue(isSorted(iRepeated));
  }
  
}
