package org.jpmorgan.assignment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.jpmorgan.assignment.util.WorkingDay;

/**
 * This class holds intsruction details
 * @author ekber
 *
 */
public class Instruction {
    
	private String entity;
    private InstructionType instructionType;
    private double agreedFx;
    private String currency;
    private Date instructionDate;
    private Date settlementDate;
    private int units;
    private double pricePerUnit;

    public Instruction(String input) throws Exception {
        String[] instructionElements = input.split(";");
        SimpleDateFormat dateParser = new SimpleDateFormat("dd MMM yyyy", Locale.ENGLISH);

        this.entity = instructionElements[0];
        this.instructionType = InstructionType.get(instructionElements[1].equals("B") ? "outgoing" : "incoming");
        this.agreedFx = Double.parseDouble(instructionElements[2]);
        if (this.agreedFx < 0.0)
            throw new IllegalArgumentException("Exchange rate is invalid : " + this.agreedFx);
        
        this.currency = instructionElements[3];
        this.instructionDate = dateParser.parse(instructionElements[4]);
        this.settlementDate = WorkingDay.getClosestWorkingDay(this.currency, dateParser.parse(instructionElements[5]));
        if (this.instructionDate.after(this.settlementDate))
            throw new IllegalArgumentException("Settlement date is invalid : " + this.settlementDate);
        
        this.units = Integer.parseInt(instructionElements[6]);
        if (this.units <= 0)
            throw new IllegalArgumentException("Units is invalid : " + this.units);
        
        this.pricePerUnit = Double.parseDouble(instructionElements[7]);
        if (this.pricePerUnit <= 0.0)
            throw new IllegalArgumentException("PricePerUnit is valid : " + this.pricePerUnit);
    }

    public double getTradeAmount() {
        return this.agreedFx * this.units * this.pricePerUnit;
    }

	public String getEntity() {
		return entity;
	}

	public InstructionType getInstructionType() {
		return instructionType;
	}

	public double getAgreedFx() {
		return agreedFx;
	}

	public String getCurrency() {
		return currency;
	}

	public Date getInstructionDate() {
		return instructionDate;
	}

	public Date getSettlementDate() {
		return settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	@Override
	public String toString() {
		return this.entity + " for " + this.instructionType.getAbbreviation() + ", settlement date : " + this.settlementDate;
	}
}
