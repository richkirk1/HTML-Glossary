import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map2;
import components.sequence.Sequence;
import components.sequence.Sequence2L;
import components.set.Set;
import components.set.Set2;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 *
 * @author Rich Kirk
 *
 */
public class GlossaryTest {

    /**
     * Easy, base test of Glossary's parseFile method.
     */
    @Test
    public void test_parseFile_1() {
        SimpleReader input = new SimpleReader1L("data/test.txt");
        Map<String, String> map = new Map2<>();
        map.add("test", "definition is cool");
        Map<String, String> temp = Glossary.parseFile(input);
        assertEquals(map, temp);
    }

    /**
     * Procedural test of Glossary's parseFile method.
     */
    @Test
    public void test_parseFile_2() {
        SimpleReader input = new SimpleReader1L("data/terms.txt");
        Map<String, String> map = new Map2<>();
        map.add("meaning",
                "something that one wishes to convey, especially by language");
        map.add("term", "a word whose definition is in a glossary");
        map.add("word",
                "a string of characters in a language, which has at least one character");
        map.add("definition",
                "a sequence of words that gives meaning to a term");
        map.add("glossary",
                "a list of difficult or specialized terms, with their definitions,"
                        + "usually near the end of a book");
        map.add("language",
                "a set of strings of characters, each of which has meaning");
        map.add("book", "a printed or written literary work");
        Map<String, String> temp = Glossary.parseFile(input);
        assertEquals(map, temp);
    }

    /**
     * Base test case for Glossary's alphabetize method.
     */
    @Test
    public void test_alphabetize_1() {
        Set<String> terms = new Set2<>();
        terms.add("a");
        Set<String> tempSet = new Set2<>();
        tempSet.add("a");
        Sequence<String> termSeq = Glossary.alphabetize(terms);
        Sequence<String> tempSeq = new Sequence2L<>();
        tempSeq.add(0, "a");
        assertEquals(tempSet, terms);
        assertEquals(termSeq, tempSeq);
    }

    /**
     * Procedural test case for Glossary's alphabetize method.
     */
    @Test
    public void test_alphabetize_2() {
        Set<String> terms = new Set2<>();
        terms.add("a");
        terms.add("q");
        terms.add("e");
        terms.add("c");
        Set<String> tempSet = new Set2<>();
        tempSet.add("a");
        tempSet.add("q");
        tempSet.add("e");
        tempSet.add("c");
        Sequence<String> termSeq = Glossary.alphabetize(terms);
        Sequence<String> tempSeq = new Sequence2L<>();
        tempSeq.add(0, "a");
        tempSeq.add(1, "c");
        tempSeq.add(2, "e");
        tempSeq.add(2 + 1, "q");
        assertEquals(terms, tempSet);
        assertEquals(termSeq, tempSeq);
    }

    /**
     * Procedural test case for Glossary's alphabetize method given by CSE 2221.
     */
    @Test
    public void test_alphabetize_3() {
        Set<String> terms = new Set2<>();
        terms.add("meaning");
        terms.add("term");
        terms.add("word");
        terms.add("definition");
        terms.add("glossary");
        terms.add("language");
        terms.add("book");
        Set<String> tempSet = new Set2<>();
        tempSet.add("meaning");
        tempSet.add("term");
        tempSet.add("word");
        tempSet.add("definition");
        tempSet.add("glossary");
        tempSet.add("language");
        tempSet.add("book");
        Sequence<String> termSeq = Glossary.alphabetize(terms);
        Sequence<String> tempSeq = new Sequence2L<>();
        tempSeq.add(0, "book");
        tempSeq.add(1, "definition");
        tempSeq.add(2, "glossary");
        tempSeq.add(2 + 1, "language");
        tempSeq.add(2 + 2, "meaning");
        tempSeq.add(2 + 2 + 1, "term");
        tempSeq.add(2 + 2 + 2, "word");
        assertEquals(terms, tempSet);
        assertEquals(termSeq, tempSeq);
    }

    /**
     * Base test case for Glossary's method setOfTerms.
     */
    @Test
    public void test_setOfTerms_1() {
        Map<String, String> map = new Map2<>();
        map.add("a", "TEST");
        Map<String, String> tempMap = new Map2<>();
        tempMap.add("a", "TEST");
        Set<String> terms = new Set2<>();
        terms.add("a");
        Set<String> strOfTerms = Glossary.setOfTerms(map);
        assertEquals(map, tempMap);
        assertEquals(terms, strOfTerms);
    }

    /**
     * Procedural test case for Glossary's method setOfTerms.
     */
    @Test
    public void test_setOfTerms_2() {
        Map<String, String> map = new Map2<>();
        map.add("a", "TEST");
        map.add("q", "TEST");
        map.add("d", "TEST");
        map.add("b", "TEST");
        Map<String, String> tempMap = new Map2<>();
        tempMap.add("a", "TEST");
        tempMap.add("q", "TEST");
        tempMap.add("d", "TEST");
        tempMap.add("b", "TEST");
        Set<String> terms = new Set2<>();
        terms.add("a");
        terms.add("q");
        terms.add("d");
        terms.add("b");
        Set<String> strOfTerms = Glossary.setOfTerms(map);
        assertEquals(map, tempMap);
        assertEquals(terms, strOfTerms);
    }

    /**
     * Easy test case for Glossary's method stringToSequence.
     */
    @Test
    public void test_stringToSequence_1() {
        String str = "Hello, World";
        Sequence<String> seq = new Sequence2L<>();
        seq.add(0, "Hello");
        seq.add(1, ", ");
        seq.add(2, "World");
        Sequence<String> tempSeq = Glossary.stringToSequence(str);
        assertEquals(seq, tempSeq);
    }

    /**
     * Procedural test case for Glossary's method stringToSequence.
     */
    @Test
    public void test_stringToSequence_2() {
        String str = "a list \n\n that's,,, cool.";
        Sequence<String> seq = new Sequence2L<>();
        seq.add(0, "a");
        seq.add(1, " ");
        seq.add(2, "list");
        seq.add(2 + 1, " \n\n ");
        seq.add(2 + 2, "that's");
        seq.add(2 + 2 + 1, ",,, ");
        seq.add(2 + 2 + 2, "cool.");
        Sequence<String> tempSeq = Glossary.stringToSequence(str);
        assertEquals(seq, tempSeq);
    }

    /**
     * Easy test case for Glossary's method nextWordOrSeparator.
     */
    @Test
    public void test_nextWordOrSeparator_1() {
        Set<Character> separators = new Set2<>();
        separators.add(',');
        Set<Character> temp = new Set2<>();
        temp.add(',');
        String text = "The boy is, tired";
        String expected = "The boy is";
        int position = 0;
        String nextWordOrSeparator = Glossary.nextWordOrSeparator(text,
                position, separators);
        assertEquals(temp, separators);
        assertEquals(nextWordOrSeparator, expected);
    }

    /**
     * Procedural test case for Glossary's method nextWordOrSeparator.
     */
    @Test
    public void test_nextWordOrSeparator_2() {
        Set<Character> separators = new Set2<>();
        separators.add('a');
        Set<Character> temp = new Set2<>();
        temp.add('a');
        String text = "EHbjtyujhjnbhjnbhujmAAAAa";
        String expected = "bjtyujhjnbhjnbhujmAAAA";
        int position = 2;
        String nextWordOrSeparator = Glossary.nextWordOrSeparator(text,
                position, separators);
        assertEquals(temp, separators);
        assertEquals(nextWordOrSeparator, expected);
    }

    /**
     * Procedural test case for Glossary's method nextWordOrSeparator.
     */
    @Test
    public void test_nextWordOrSeparator_3() {
        Set<Character> separators = new Set2<>();
        separators.add('!');
        Set<Character> temp = new Set2<>();
        temp.add('!');
        String text = "hello!!!!!!!!world";
        String expected = "!!!!";
        int position = 9;
        String nextWordOrSeparator = Glossary.nextWordOrSeparator(text,
                position, separators);
        assertEquals(temp, separators);
        assertEquals(nextWordOrSeparator, expected);
    }
}
