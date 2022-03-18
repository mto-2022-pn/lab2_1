package edu.iis.mto.bsearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BinarySearchTest {

    @BeforeEach
    void setUp() throws Exception {}

    @Test
    @DisplayName("Jest w sekwencji i dł.sekwencji = 1")
    void test1() {
        int key=11;
        int [] seq = {11};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }
    @Test
    @DisplayName("Nie ma w sekwencji i dł.sekwencji = 1")
    void test2() {
        int key=11;
        int [] seq = {7};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }
    @Test
    @DisplayName("Jest pierwszym elementem i dł.sekwencji > 1")
    void test3() {
        int key=2;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(1,searchResult.getPosition());
    }
    @Test
    @DisplayName("Jest ostatnim elementem i dł.sekwencji > 1")
    void test4() {
        int key=10;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(5,searchResult.getPosition());
    }
    @Test
    @DisplayName("Jest środkowym elementem i dł.sekwencji > 1")
    void test5() {
        int key=6;
        int [] seq = {2,4,6,8,10};
        int center = (seq.length-1)/2 + 1;
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertTrue(searchResult.isFound());
        assertEquals(center,searchResult.getPosition());
    }
    @Test
    @DisplayName("Nie ma w sekwencji i dł.sekwencji > 1")
    void test6() {
        int key=5;
        int [] seq = {2,4,6,8,10};
        SearchResult searchResult=BinarySearch.search(key,seq);
        assertFalse(searchResult.isFound());
        assertEquals(-1,searchResult.getPosition());
    }

}
