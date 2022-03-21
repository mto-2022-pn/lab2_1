package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

class BinarySearchTest {
    int seqLength;
    int[] seq;
    Random rand;

    @BeforeEach
    void setup() {
        rand = new Random();

        seqLength = rand.nextInt(998) + 2;
        seq = rand.ints(seqLength).toArray();

        Arrays.sort(seq);
    }

    @Test
    void seqLengthIsZero_throwsException() {
        int key = rand.nextInt();
        int[] zeroElemSeq = new int[0];

        Exception e = assertThrows(IllegalArgumentException.class, () -> BinarySearch.search(key, zeroElemSeq));
        assertEquals("Sequence is empty", e.getMessage());
    }

    @Test
    void seqLengthIsOne_keyInSeq() {
        int key = rand.nextInt();
        int[] singleElemSeq = {key};

        SearchResult result = BinarySearch.search(key, singleElemSeq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, singleElemSeq[result.getPosition()]);
    }

    @Test
    void seqLengthIsOne_keyNotInSeq() {
        int key = rand.nextInt();
        int[] singleElemSeq = {key + 1};

        SearchResult result = BinarySearch.search(key, singleElemSeq);

        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    void seqLengthGreaterThanOne_keyFirstInSeq() {
        int key = seq[0];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyLastInSeq() {
        int key = seq[seq.length - 1];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(seq.length - 1, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyInMiddleOfSeq() {
        int randomMiddleIndex = rand.nextInt(seq.length - 3) + 1;
        int key = seq[randomMiddleIndex];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertNotEquals(seq.length - 1, result.getPosition());
        assertNotEquals(0, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyNotInSeq() {
        int key = seq[0] - 1;

        SearchResult result = BinarySearch.search(key, seq);

        assertFalse(result.isFound());
        assertEquals(-1, result.getPosition());
    }

    @Test
    void seqLengthGreaterThanOne_keyInCenterOfSeq() {
        int centralIndex = (seq.length - 1) / 2;
        int key = seq[centralIndex];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(centralIndex, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyLeftToCenterOfSeq() {
        int leftToCentralIndex = ((seq.length - 1) / 2) - 1;
        int key = seq[leftToCentralIndex];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(leftToCentralIndex, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }

    @Test
    void seqLengthGreaterThanOne_keyRightToCenterOfSeq() {
        int rightToCentralIndex = ((seq.length - 1) / 2) + 1;
        int key = seq[rightToCentralIndex];

        SearchResult result = BinarySearch.search(key, seq);

        assertTrue(result.isFound());
        assertEquals(rightToCentralIndex, result.getPosition());
        assertEquals(key, seq[result.getPosition()]);
    }
}
