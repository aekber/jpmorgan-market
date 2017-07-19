package com.jpmorgan.assesment.marketreport;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Locale;

import org.jpmorgan.assignment.Instruction;
import org.junit.Test;

public class InstructionTest {

    SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

    @Test
    public void testSettlementDateIsWorkingDay() throws Exception {

        Instruction i1 = new Instruction("entity1;B;1.50;TRY;12 Dec 2016;24 Jul 2017;50;42.6");
        Instruction i2 = new Instruction("entity2;S;2.50;TRY;13 Nov 2016;23 Jul 2017;150;85.9");
        Instruction i3 = new Instruction("entity3;B;3.50;AED;14 Oct 2016;19 Feb 2017;20;23.4");
        Instruction i4 = new Instruction("entity4;S;4.50;SAR;15 Sep 2016;23 Jul 2017;30;2.22");

        assertEquals("Monday is not holiday", dateFormat.format(i1.getSettlementDate()),"24 Jul 2017");
        assertEquals("Sunday is holiday", dateFormat.format(i2.getSettlementDate()),"24 Jul 2017");
        assertEquals("Friday is holiday in arabic system", dateFormat.format(i3.getSettlementDate()),"19 Feb 2017");
        assertEquals("Sunday is not holiday in arabic system", dateFormat.format(i4.getSettlementDate()),"23 Jul 2017");
    }

}