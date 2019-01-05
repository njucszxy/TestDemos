import edu.stanford.nlp.simple.Sentence;

import java.util.List;

public class lemmatization {
    public static void main(String args[])
    {
        //lemmatization
        Sentence sentence = new Sentence("I was reading a book.");
        List<String> lemmas = sentence.lemmas();
        System.out.print("[");
        for(int i = 0;i < lemmas.size();i++) {
            System.out.print("\"");
            System.out.print(lemmas.get(i));
            System.out.print("\"");
            if(i != lemmas.size()-1)
                System.out.print(",");
        }
        System.out.print("]");
        System.out.println();
    }
}
