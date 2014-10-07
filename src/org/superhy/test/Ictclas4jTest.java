package org.superhy.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.ictclas4j.bean.SegResult;
import org.ictclas4j.segment.SegTag;

public class Ictclas4jTest {

	public static void main(String[] args) {

		try {
			SegTag st = new SegTag(1);
			String str = "";

			File f = new File("./file/test.txt");
			InputStreamReader isr = new InputStreamReader(
					new FileInputStream(f), "GBK");
			BufferedReader br = new BufferedReader(isr);
			String line;
			while ((line = br.readLine()) != null) {
				SegResult sr = st.split(line, true);
				System.out.println(sr.getFinalResult());
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
