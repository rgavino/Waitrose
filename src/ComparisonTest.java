

 
public class ComparisonTest extends junit.framework.TestCase {
 
    String myXmlReference = "/var/lib/jenkins/workspace/Waitrose POC/src/oata/reference.xml";
    String myXmlCompare = "/var/lib/jenkins/workspace/Waitrose POC/src/oata/comparison.xml";

    public void testToCompareXMLFiles() {

        try {
            InputSource isRef = new InputSource(new FileInputStream(myXmlReference));
            InputSource isCom = new InputSource(new FileInputStream(myXmlCompare));

            Diff diff = new Diff(isRef, isCom);
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


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}