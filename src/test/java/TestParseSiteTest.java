import htmlParser.parseSite.ParseSite;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import static org.junit.Assert.assertTrue;
/**
 * @author Putrenkov Pavel
 *
 */
public class TestParseSiteTest {
    
    private final static String INVALID_URL = "itstatii.blogspot.com/2016/10/iphone-4-macbook-air-2010.html";
    private final static String URL_FOR_PARSE = "http://itstatii.blogspot.com/2016/10/iphone-4-macbook-air-2010.html";
    private final static int ALL_WORD_NUMB = 268;
    private final static int WORD_NUMB = 184;

    public static void main(String[] args) {
        new TestParseSiteTest().testPut();
    }
    
    @Test
    public void testPut() {
        
        int count = 0, i = 0;
        try {
            TreeMap<String, Integer> startParse = new ParseSite(URL_FOR_PARSE).startParse();
            for (Map.Entry<String, Integer> nextWordCount : startParse.entrySet()) {
                count = count + nextWordCount.getValue();
                i++;
            }

        } catch (IOException e) {
            System.out.println ("Connect error or unknown url: " + URL_FOR_PARSE); 
        }
        System.out.println(count);
        System.out.println(i);
        assertTrue(count == ALL_WORD_NUMB);
        assertTrue(i == WORD_NUMB);

    }
    
    @Test (expected = IOException.class)
    public void testParseWithInvalidUrl () throws IOException {
        new ParseSite (INVALID_URL).startParse();
    }

}
