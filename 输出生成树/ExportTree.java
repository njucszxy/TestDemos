import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.process.DocumentPreprocessor;
import edu.stanford.nlp.trees.GrammaticalStructure;
import edu.stanford.nlp.trees.GrammaticalStructureFactory;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

public class ExportTree {
    public static void main(String args[])
    {
        String parserModel = "edu/stanford/nlp/models/lexparser/englishPCFG.ser.gz";
        String fileName = "test.txt";

        LexicalizedParser lp = LexicalizedParser.loadModel(parserModel);
        // This option shows loading, sentence-segmenting and tokenizing
        // a file using DocumentPreprocessor.
        TreebankLanguagePack tlp = lp.treebankLanguagePack();
        GrammaticalStructureFactory gsf = null;
        if (tlp.supportsGrammaticalStructures()) {
            gsf = tlp.grammaticalStructureFactory();
        }
        // You could also create a tokenizer here (as below) and pass it
        // to DocumentPreprocessor
        try {
            File outputFile = new File("testOutput.txt");
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(outputFile));

            for (List<HasWord> sentence : new DocumentPreprocessor(fileName)) {
                Tree parse = lp.apply(sentence);
                parse.pennPrint(printWriter);
                //parse.pennPrint();
                //System.out.println();

                if (gsf != null) {
                    GrammaticalStructure gs = gsf.newGrammaticalStructure(parse);
                    Collection tdl = gs.typedDependenciesCCprocessed();
                    //System.out.println(tdl);
                    //System.out.println();
                }
            }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
