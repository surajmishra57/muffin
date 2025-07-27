package org.example.lld_interview_problems.solutions.part_1_atm.dispenser;

public class NoteDispenser implements DispenseChain {
    private DispenseChain nextChain;
    private final int noteVale;
    private int numNotes;

    public NoteDispenser(int noteVale, int numNotes) {
        this.noteVale = noteVale;
        this.numNotes = numNotes;
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public synchronized void dispense(int amount) {
        if (amount >= noteVale) {
            int numToDispense = Math.min(amount / noteVale, this.numNotes);
            int remainingAmount = amount - (numToDispense * noteVale);

            if (numToDispense > 0) {
                System.out.println("Dispensing " + numToDispense + " x $" + noteVale + " note(s)");
                this.numNotes -= numToDispense;
            }

            if (remainingAmount > 0 && this.nextChain != null) {
                this.nextChain.dispense(remainingAmount);
            }
        } else if (this.nextChain != null) {
            this.nextChain.dispense(amount);
        }
    }

    @Override
    public synchronized boolean canDispense(int amount) {
        if (amount < 0) return false;
        if (amount == 0) return true;

        int numToUse = Math.min(amount / noteVale, this.numNotes);
        int remainingAmount = amount - (numToUse * noteVale);

        if (remainingAmount == 0) return true;
        if (this.nextChain != null) {
            return this.nextChain.canDispense(remainingAmount);
        }
        return false;
    }
}
