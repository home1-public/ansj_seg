package org.ansj.recognition;

import org.ansj.Nature;
import org.ansj.Term;

import java.util.Iterator;
import java.util.List;


/**
 * 基于规则的新词发现，身份证号码识别
 *
 * @author ansj
 *
 */
public class IDCardRecognition {
    private static final Nature ID_CARD_NATURE = new Nature("idcard");

    public static List<Term> recognition(List<Term> terms) {

        for (Term term : terms) {
            if ("m".equals(term.getNature().natureStr)) {

                if (term.getName().length() == 18) {
                    term.setNature(ID_CARD_NATURE);
                } else if (term.getName().length() == 17) {
                    Term to = term.getTo();
                    if ("x".equals(to.getName())) {
                        term.merage(to);
                        to.setName(null);
                        term.setNature(ID_CARD_NATURE);
                    }
                }

            }
        }

        for (Iterator<Term> iterator = terms.iterator(); iterator.hasNext();) {
            Term term = (Term) iterator.next();
            if (term.getName() == null) {
                iterator.remove();
            }
        }

        return terms;
    }
}