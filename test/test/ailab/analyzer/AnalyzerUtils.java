package test.ailab.analyzer;

import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;

public class AnalyzerUtils {

	public static void displayToken(String str, Analyzer a) {
		TokenStream stream = a.tokenStream("content", new StringReader(str));

		// 创建一个属性，这个属性会添加流中，随着这个TokenStream增加
		try {
			while (stream.next() != null) {
				System.out.println(stream.next().term());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
