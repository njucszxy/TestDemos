import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.summary.TextRankKeyword;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TextRank {
    public static void main(String[] args)
    {
        try {
            String contents = FileUtils.readFileToString(new File("test.txt"), "UTF-8");
            List<String> keywordList = HanLP.extractKeyword(contents,10);
            PrintWriter printWriter = new PrintWriter("output.txt");
            printWriter.println(keywordList);
            printWriter.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
