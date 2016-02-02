
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
 
    public static void main(String[] args) {
        URL url1 = ComparisonTest.class.getResource("/var/lib/jenkins/workspace/Waitrose POC/src/oata/reference.xml");
        URL url2 = ComparisonTest.class.getResource("/var/lib/jenkins/workspace/Waitrose POC/src/oata/comparison.xml");
        FileReader fr1 = null;
        FileReader fr2 = null;
        try {
            fr1 = new FileReader(url1.getPath());
            fr2 = new FileReader(url2.getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
 
        try {
            Diff diff = new Diff(fr1, fr2);
            System.out.println("Similar? " + diff.similar());
            System.out.println("Identical? " + diff.identical());
 
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