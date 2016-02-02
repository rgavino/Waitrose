
import java.io.File;
import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;
 
import org.custommonkey.xmlunit.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
 
public class ComparisonTest extends junit.framework.TestCase {
 
    String myXmlReference = "/var/lib/jenkins/workspace/Waitrose POC/src/oata/reference.xml";
    String myXmlCompare = "/var/lib/jenkins/workspace/Waitrose POC/src/oata/comparison.xml";

    public void testToCompareXMLFiles() {

        File fr1 = null;
        File fr2 = null;
            fr1 = new File(myXmlReference);
            fr2 = new File(myXmlCompare);
 
        try {
            Diff diff = new Diff(fr1, fr2);
            System.out.println("Similar? " + diff.similar());
            System.out.println("Identical? " + diff.identical());

            assertTrue("They are identicle", diff.identical());

            DetailedDiff detDiff = new DetailedDiff(diff);
            List differences = detDiff.getAllDifferences();
            for (Object object : differences) {
                Difference difference = (Difference)object;
                System.out.println("***********************");
                System.out.println(difference);
                System.out.println("***********************");
            }


        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}