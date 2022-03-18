package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    void searchForExistingElem_singleElemSequence_findsItsPosition() {
        int key=11;
        int [] seq = {11};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }
    @Test
    void searchForNotExistingElem_singleElemSequence() {
        int key=11;
        int [] seq = {7};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }
    @Test
    void searchForExistingElem_multiElemSequence_ElemIsOnFirstPosition() {
        int key=2;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }
    @Test
    void searchForExistingElem_multiElemSequence_ElemIsOnLastPosition() {
        int key=10;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(5,searchResult.getPosition());
    }
    @Test
    void searchForExistingElem_multiElemSequence_ElemIsOnMiddlePosition() {
        int key=6;
        int [] seq = {2,4,6,8,10};
        int center = (seq.length-1)/2 + 1;
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(center,searchResult.getPosition());
    }
    @Test
    void searchForNotExistingElem_multiElemSequence() {
        int key=5;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }

    @Test
    void searchForIllegalArgumentException() {
        int key=3;
        int [] seq = {};
        try{
            SearchResult searchResult=BinarySearch.search(key,seq);

            fail("expected IllegalArgumentException");
        }catch (IllegalArgumentException e){

        }

    }
}
