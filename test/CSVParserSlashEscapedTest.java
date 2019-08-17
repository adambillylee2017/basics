import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by adamli on 8/27/16.
 */
public class CSVParserSlashEscapedTest {
    CSVParserSlashEscaped sol = new CSVParserSlashEscaped();

    @Test
    public void testParseNormal() throws Exception {
        assertEquals(sol.parseCSV("a,b,c").toString(), "[a, b, c]");
    }

    @Test
    public void testParseWithQuote() throws Exception {
        assertEquals(sol.parseCSV("a,\"b\",c").toString(), "[a, b, c]");
    }
    @Test
    public void testParseWithEscapeQuote() throws Exception {
        assertEquals(sol.parseCSV("a,\"\\\",b\",c").toString(), "[a, \"\",b\", c]");
    }

}