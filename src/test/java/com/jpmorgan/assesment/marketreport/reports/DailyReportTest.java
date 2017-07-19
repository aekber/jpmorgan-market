package com.jpmorgan.assesment.marketreport.reports;

import org.jpmorgan.assignment.Instruction;
import org.jpmorgan.assignment.reports.DailyReport;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DailyReportTest {

    private static List<Instruction> list = new ArrayList<>();
    
    @BeforeClass 
    public static void prepareInstructions() throws Exception {
		String[] input = {  "Entity1;B;0.15;SGP;01 Jan 2017;02 Feb 2017;200;100.25",
				"Entity2;B;0.25;AED;05 Feb 2017;07 Jun 2017;450;150.5",
				"Entity3;S;0.35;AED;05 Mar 2017;13 Mar 2017;450;15.7",
				"Entity4;S;0.45;AED;27 Apr 2017;07 May 2017;150;15.7",
				"Entity5;S;0.55;AED;22 May 2017;12 Dec 2017;20;12.7",
				"Entity6;B;0.65;AED;13 Jun 2017;22 Oct 2017;350;150.5",
				"Entity7;B;0.75;AED;16 Jan 2017;14 Jun 2017;450;150.5",
				"Entity8;S;0.85;AED;14 Aug 2017;02 Feb 2018;450;15.7",
				"Entity9;S;0.95;AED;03 Sep 2017;07 Jan 2018;150;15.7",
				"Entity10;S;1.05;AED;05 Oct 2017;12 Dec 2017;20;12.7",
				"Entity11;B;1.15;AED;16 Nov 2017;07 Dec 2017;350;150.5",
				"Entity12;S;1.25;AED;02 Dec 2017;12 Dec 2017;20;12.7",
				"Entity13;B;1.35;AED;07 Jan 2017;06 May 2017;350;150.5",
				"Entity14;B;1.45;AED;08 Feb 2017;07 Aug 2017;450;150.5",
				"Entity15;S;1.55;AED;09 Jan 2017;05 Feb 2017;450;15.7",
				"Entity16;S;1.65;AED;10 Jun 2016;07 Jul 2016;150;15.7",
				"Entity17;S;1.75;AED;12 Jan 2016;12 Dec 2016;20;12.7",
				"Entity18;B;1.85;AED;05 Jul 2016;17 Jan 2017;350;150.5",
				"Entity19;B;1.95;AED;25 Aug 2016;27 May 2017;350;150.5",
				"Entity20;B;1.99;AED;15 Jan 2016;03 Feb 2016;50;11.7" };
		
		for (String s : input) {
			list.add(new Instruction(s));
		}
    }
    
    @Test
    public void testDailyReport() throws Exception {
        DailyReport dailyReport = new DailyReport(list);

        assertEquals("Daily Report",
        		dailyReport.getGeneratedReport(),
        		"Daily Incoming\n" +
        		"05 Feb 2017 for incoming : $10950,75\n" +
        		"04 Feb 2018 for incoming : $6005,25\n" +
        		"07 Jul 2016 for incoming : $3885,75\n" +
        		"13 Mar 2017 for incoming : $2472,75\n" +
        		"07 Jan 2018 for incoming : $2237,25\n" +
        		"07 May 2017 for incoming : $1059,75\n" +
        		"12 Dec 2017 for incoming : $723,90\n" +
        		"12 Dec 2016 for incoming : $444,50\n" +
                "\n" +
        		"Daily Outgoing\n" +
        		"28 May 2017 for outgoing : $102716,25\n" +
        		"07 Aug 2017 for outgoing : $98201,25\n" +
        		"17 Jan 2017 for outgoing : $97448,75\n" +
        		"07 May 2017 for outgoing : $71111,25\n" +
        		"07 Dec 2017 for outgoing : $60576,25\n" +
        		"14 Jun 2017 for outgoing : $50793,75\n" +
        		"22 Oct 2017 for outgoing : $34238,75\n" +
        		"07 Jun 2017 for outgoing : $16931,25\n" +
        		"02 Feb 2017 for outgoing : $3007,50\n" +
        		"03 Feb 2016 for outgoing : $1164,15\n"
        );
    }

}