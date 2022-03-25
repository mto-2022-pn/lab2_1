package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;


class BinarySearchTest {

    private static final int NOT_FOUND_ELEMENT = -1;
    private int[] seq;
    private Random random;

    @BeforeEach
    void setUp() throws Exception {
        random = new Random();
        seq = random.ints(random.nextInt(9999) + 2).toArray();
        Arrays.sort(seq);
    }

    @Test
    void seqNullThrowsException() {
        int key = random.nextInt();
        int[] seq = null;

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> {
                    SearchResult result = BinarySearch.search(key, seq);
                });

        assertEquals("Sequence is empty", e.getMessage());
    }

    @Test
    void seqEmptyThrowsException() {
        int key = random.nextInt();
        int[] seq = {};

        IllegalArgumentException e = assertThrows(
                IllegalArgumentException.class, () -> {
                    SearchResult result = BinarySearch.search(key, seq);
                });

        assertEquals("Sequence is empty", e.getMessage());
    }

    @Test
    void seqOneElementIsInSeq() {
        int key = random.nextInt();
        int[] seq = {key};

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqOneElementIsNotInSeq() {
        int key = random.nextInt();
        int[] seq = { key + 3};

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals(NOT_FOUND_ELEMENT, result.getPosition());
    }

    @Test
    void seqManyElementsKeyIsFirst() {
        int key = seq[0];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyIsLast() {
        int key = seq[seq.length - 1];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(seq.length - 1, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyIsMiddle() {
        int index = random.nextInt(seq.length - 3) + 1;
        int key = seq[index];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(index, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyIsNotInSeq() {
        int key = seq[0] - 1;

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals(NOT_FOUND_ELEMENT, result.getPosition());
    }

    @Test
    void seqManyElementsKeyInCenter() {
        int center = (seq.length - 1) / 2;
        int key = seq[center];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(center, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyInLeftToCenter() {
        int leftCenter = (seq.length - 1) / 2 - 1;
        int key = seq[leftCenter];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(leftCenter, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqManyElementsKeyInRightToCenter() {
        int rightCenter = (seq.length - 1) / 2 - 1;
        int key = seq[rightCenter];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(rightCenter, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }
}
