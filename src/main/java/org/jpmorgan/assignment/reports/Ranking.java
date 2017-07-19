package org.jpmorgan.assignment.reports;

import org.jpmorgan.assignment.InstructionType;

/**
 * This class holds ranking report details.
 * @author ekber
 *
 */
public class Ranking implements Comparable<Ranking> {
	
    private String entity;
    private double amount = 0;
    private String instructionType;

    public Ranking(String entity, double amount, InstructionType instructionType) {
        this.entity = entity;
        this.amount = amount;
        this.instructionType = instructionType.getAbbreviation();
    }

	public String getEntity() {
		return entity;
	}

	public double getAmount() {
		return amount;
	}

	public String getInstructionType() {
		return instructionType;
	}
	
	public double addAmount(double newAmount) {
		return amount += newAmount;
	}

	@Override
	public int compareTo(Ranking o) {
        if (o.getAmount() > this.amount)
            return -1;

        if (o.getAmount() < this.amount)
            return 1;

        return 0;
	}
	
	@Override
	public String toString() {
		return this.entity + " for " + this.instructionType + " : $" + String.format("%.2f", this.amount);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		result = prime * result + ((instructionType == null) ? 0 : instructionType.hashCode());
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
		Ranking other = (Ranking) obj;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		if (instructionType == null) {
			if (other.instructionType != null)
				return false;
		} else if (!instructionType.equals(other.instructionType))
			return false;
		return true;
	}
	

}
