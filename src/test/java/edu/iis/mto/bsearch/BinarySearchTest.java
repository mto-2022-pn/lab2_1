package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class BinarySearchTest {
    int[] sequenceWithOneElement = new int[]{13};
    int[] sequenceWithMultipleElements = new int[]{13,15,17,22,43,78,112,234,666};
    int[] emptySequence = new int[]{};
    int[] sequenceWithMultipleSameElements = new int[]{13, 13, 13, 13, 13, 13 };

    int validKeyInOneElementSequence = 13;
    int invalidKeyInOneElementSequence = 12;
    int elementInMultipleSameElementsSequence = 13;

    int positionNotFound = -1;

    int firstElementInMultipleElementsSequence = sequenceWithMultipleElements[0];
    int lastElementInMultipleElementsSequence = sequenceWithMultipleElements[sequenceWithMultipleElements.length-1];
    int middleElementInMultipleElementsSequence = sequenceWithMultipleElements[sequenceWithMultipleElements.length/2];
    int invalidKeyInMultipleElementsSequence = 555;

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void keyIsInSequenceWithOneElement() {
        SearchResult searchResult = BinarySearch.search(validKeyInOneElementSequence, sequenceWithOneElement);
        assertTrue(searchResult.isFound());
        assertEquals(validKeyInOneElementSequence, sequenceWithOneElement[searchResult.getPosition()]);
    }
    @Test
    void noKeyInSequenceWithOneElement() {
        SearchResult searchResult = BinarySearch.search(invalidKeyInOneElementSequence,sequenceWithOneElement);
        assertFalse(searchResult.isFound());
        assertEquals(positionNotFound,searchResult.getPosition());
    }
    @Test
    void keyIsFirstElementInSequenceWithMultipleElements(){
        SearchResult searchResult = BinarySearch.search(firstElementInMultipleElementsSequence,sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(firstElementInMultipleElementsSequence,sequenceWithMultipleElements[0]);
    }
    @Test
    void keyIsLastElementInSequenceWithMultipleElements(){
        SearchResult searchResult = BinarySearch.search(lastElementInMultipleElementsSequence,sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(lastElementInMultipleElementsSequence, sequenceWithMultipleElements[sequenceWithMultipleElements.length - 1]);
    }
    @Test
    void keyIsMiddleElementInSequenceWithMultipleElements(){
        SearchResult searchResult = BinarySearch.search(middleElementInMultipleElementsSequence,sequenceWithMultipleElements);
        assertTrue(searchResult.isFound());
        assertEquals(middleElementInMultipleElementsSequence,sequenceWithMultipleElements[sequenceWithMultipleElements.length/2]);
    }
    @Test
    void noKeyInSequenceWithMultipleElements(){
        SearchResult searchResult = BinarySearch.search(invalidKeyInMultipleElementsSequence,sequenceWithMultipleElements);
        assertFalse(searchResult.isFound());
        assertEquals(positionNotFound,searchResult.getPosition());
    }
    @Test
    void sequenceIsEmpty(){
        SearchResult searchResult = BinarySearch.search(validKeyInOneElementSequence,emptySequence);
        assertFalse(searchResult.isFound());
        assertEquals(positionNotFound,searchResult.getPosition());
    }
    @Test
    void sequenceHasMultipleSameElements()
    {
        SearchResult searchResult = BinarySearch.search(elementInMultipleSameElementsSequence, sequenceWithMultipleSameElements);
        assertTrue(searchResult.isFound());
        assertEquals(elementInMultipleSameElementsSequence,sequenceWithMultipleSameElements[searchResult.getPosition()]);
    }
}
