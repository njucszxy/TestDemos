import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.Token;

import java.util.List;

public class Tokenization {
    public static void main(String args[])
    {
        //tokenization
        Sentence sentence = new Sentence("Hard times come again no more.");
        List<String> words = sentence.words();
        System.out.print("[");
        for(int i = 0;i < words.size();i++) {
            System.out.print("\"");
            System.out.print(words.get(i));
            System.out.print("\"");
            if(i != words.size()-1)
                System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }
}
