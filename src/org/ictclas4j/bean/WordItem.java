package org.ictclas4j.bean;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

/**
 * ����.���������ݡ����ȡ������Ƶ��
 * 
 * @author sinboy
 * 
 */
public class WordItem {
	private String word;
	private int len;//���ڴ����ϴ洢���ֽڳ���
	private int handle;// �����������ʶ�ʵĴ���
	private int freq;// Ƶ�ȣ�����˵���ôʳ��������Ͽ��еĴ��������
	
	WordItem() {
		
	}
	
	WordItem(String _word,int _len,int _handle,int _freq) {
		word=_word;
		len=_len;
		handle=_handle;
		freq=_freq;
	}
	
	public int getFreq() {
		return freq;
	}

	public void setFreq(int frequency) {
		this.freq = frequency;
	}

	public int getHandle() {
		return handle;
	}

	public void setHandle(int handle) {
		this.handle = handle;
	}

	public int getLen() {
		return len;
	}

	public void setLen(int len) {
		this.len = len;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
	public String toString() {

		return ReflectionToStringBuilder.toString(this);

	}
	 

}
