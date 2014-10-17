package test.ailab.analyzer;

import org.ailab.analyzer.ICTCLAS4jAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.junit.Test;

public class ICTCLAS4jAnalyzerUtilTest {

	@Test
	public void testAnalyzer() {

		Analyzer a = new ICTCLAS4jAnalyzer();

		String txt = "�й�������Ѷ ���������й����Ÿ����ƣ���������ȦҲ���Ÿ�Ů����ԣ��ͥ����Ľ𾰶����ڵ����Ϲ����Ÿ����ų��Լ�һ����ͷ��ֵ���ں�Ԫ���չ����������Ǽ�ֵ���ں�Ԫ�ķۺ�ɫ�����ܳ������пɿ���Ϣ�ƽ𾰶���ǰ��һ����ʯkitty�����ͼ�ֵ���ں�Ԫ��";
		AnalyzerUtils.displayToken(txt, a);
	}
}
