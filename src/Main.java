import static Utility.XmlParser.jmxParser;

import Constants.Constants;

public class Main {
    public static void main(String[] args) {
        final String path = "C:\\path\\to\\jmeterLoadScript.jmx";

        jmxParser(path, Constants.TAG_RESULTCOLLECTOR);
        jmxParser(path, Constants.TAG_JPGC_RESULTCOLLECTOR);

    }
}
