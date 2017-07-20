package org.jpmorgan.assignment;

import java.util.ArrayList;
import java.util.List;

import org.jpmorgan.assignment.reports.DailyReport;
import org.jpmorgan.assignment.reports.RankingReport;
import org.jpmorgan.assignment.reports.Report;

/**
 * Generate reports as daily and ranking
 * @author ekber
 *
 */
public class ReportGenerator {

	public static void main(String[] args) throws Exception {
		String[] input = {  "Entity1;B;0.15;SGP;01 Jan 2017;02 Feb 2017;200;100.25",
							"Entity2;B;0.25;TRY;05 Feb 2017;07 Jun 2017;450;150.5",
							"Entity3;S;0.35;USD;05 Mar 2017;13 Mar 2017;450;15.7",
							"Entity4;S;0.45;EUR;27 Apr 2017;07 May 2017;150;15.7",
							"Entity5;S;0.55;GBP;22 May 2017;12 Dec 2017;20;12.7",
							"Entity6;B;0.65;AED;13 Jun 2017;22 Oct 2017;350;150.5",
							"Entity7;B;0.75;SAR;16 Jan 2017;14 Jun 2017;450;150.5",
							"Entity8;S;0.85;CHF;14 Aug 2017;02 Feb 2018;450;15.7",
							"Entity9;S;0.95;TRY;03 Sep 2017;07 Jan 2018;150;15.7",
							"Entity10;S;1.05;USD;05 Oct 2017;12 Dec 2017;20;12.7",
							"Entity11;B;1.15;EUR;16 Nov 2017;07 Dec 2017;350;150.5",
							"Entity12;S;1.25;GBP;02 Dec 2017;12 Dec 2017;20;12.7",
							"Entity13;B;1.35;AED;07 Jan 2017;06 May 2017;350;150.5",
							"Entity14;B;1.45;SAR;08 Feb 2017;07 Aug 2017;450;150.5",
							"Entity15;S;1.55;TRY;09 Jan 2017;05 Feb 2017;450;15.7",
							"Entity16;S;1.65;USD;10 Jun 2016;07 Jul 2016;150;15.7",
							"Entity17;S;1.75;EUR;12 Jan 2016;12 Dec 2016;20;12.7",
							"Entity18;B;1.85;GBP;05 Jul 2016;17 Jan 2017;350;150.5",
							"Entity19;B;1.95;CHF;25 Aug 2016;27 May 2017;350;150.5",
							"Entity20;B;1.99;SAR;15 Jan 2016;03 Feb 2016;50;11.7" };

		List<Instruction> list = new ArrayList<Instruction>();

		for (String s : input) {
			list.add(new Instruction(s));
		}

		Report dailyReport = new DailyReport(list);
		dailyReport.generateReport();
		
		Report rankingReport = new RankingReport(list);
		rankingReport.generateReport();
	}
}
