package org.jpmorgan.assignment.reports;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jpmorgan.assignment.InstructionType;

/**
 * This class holds daily report details.
 * @author ekber
 *
 */
public class Daily implements Comparable<Daily> {
	
    private String settlementDate;
    private double amount = 0;
    private String instructionType;

    public Daily(Date settlementDate, double amount, InstructionType instructionType) {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);
        this.settlementDate = dateFormat.format(settlementDate);
        this.amount = amount;
        this.instructionType = instructionType.getAbbreviation();
    }

	public String getSettlementDate() {
		return settlementDate;
	}

	public String getInstructionType() {
		return instructionType;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public double addAmount(double newAmount) {
		return amount += newAmount;
	}
	
	@Override
	public String toString() {
		return this.settlementDate + " for " + this.instructionType + " : $" + String.format("%.2f", this.amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((instructionType == null) ? 0 : instructionType.hashCode());
		result = prime * result + ((settlementDate == null) ? 0 : settlementDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Daily other = (Daily) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (instructionType == null) {
			if (other.instructionType != null)
				return false;
		} else if (!instructionType.equals(other.instructionType))
			return false;
		if (settlementDate == null) {
			if (other.settlementDate != null)
				return false;
		} else if (!settlementDate.equals(other.settlementDate))
			return false;
		return true;
	}

	@Override
	public int compareTo(Daily o) {
        if (o.getAmount() > this.amount)
            return -1;

        if (o.getAmount() < this.amount)
            return 1;

        return 0;
	}

}
