package org.ansj.recognition;

import org.ansj.Term;
import org.ansj.splitWord.ToAnalysis;
import org.junit.Test;

import java.util.List;

public class IDCardRecognitionTest {

    @Test
    public void test() {
        List<Term> parse = ToAnalysis.parse("我吃了一个西瓜，我今年25岁。这里有一万个东西，我的身份证号码是130722198506280057h");

        List<Term> recognition = IDCardRecognition.recognition(parse);

        System.out.println(recognition);
    }
}