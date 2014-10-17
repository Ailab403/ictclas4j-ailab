package test.ailab.analyzer;

import org.ailab.analyzer.ICTCLAS4jAnalyzer;
import org.apache.lucene.analysis.Analyzer;
import org.junit.Test;

public class ICTCLAS4jAnalyzerUtilTest {

	@Test
	public void testAnalyzer() {

		Analyzer a = new ICTCLAS4jAnalyzer();

		String txt = "中国娱乐网讯 郭美美在中国以炫富著称，韩国娱乐圈也多炫富女。富裕家庭出身的金景娥曾在电视上公开炫富，号称自己一身行头价值四亿韩元，收过最贵的礼物是价值三亿韩元的粉红色宾利跑车。更有可靠消息称金景娥胸前的一个钻石kitty项链就价值两亿韩元。";
		AnalyzerUtils.displayToken(txt, a);
	}
}
