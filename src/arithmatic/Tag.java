package arithmatic;

import java.util.ArrayList;

public class Tag {

    private char ch;
    private double freq = 0;
    private double lowRange = 0;
    private double highRange = 0;
    private double lastlowRange = 0;
    private double lasthighRange = 0;

    /**
     * constructor*
     */
    public Tag() {
    }

    public Tag(char ch, double freq) {
        this.ch = ch;
        this.freq = freq;
    }

    /**
     * Setter & Getter*
     */
    //setter
    public void setCurrentRanges(double low, double high) {
        this.lowRange = low;
        this.highRange = high;
    }

    public void setlastRanges(double lastlow, double lasthigh) {
        this.lastlowRange = lastlow;
        this.lasthighRange = lasthigh;
    }

    public void setAllRanges(double low, double high, double lastlow, double lasthigh) {
        this.lowRange = low;
        this.highRange = high;
        this.lastlowRange = lastlow;
        this.lasthighRange = lasthigh;
    }

    public void set_charchter(char ch) {
        this.ch = ch;
    }

    public void set_freq(double freq) {
        this.freq = freq;
    }

    public void set_data(char ch, double freq) {
        this.ch = ch;
        this.freq = freq;
    }
    //getter

    public double getlowRanges() {
        return this.lowRange;
    }

    public double getHightRanges() {
        return this.highRange;
    }

    public double getlastlowRanges() {
        return this.lastlowRange;
    }

    public double getlastHightRanges() {
        return this.lasthighRange;
    }

    public char get_charchter() {
        return this.ch;
    }

    public double get_freq() {
        return this.freq;
    }

    /**
     * other methods*
     */
    public int getIndex(char search, ArrayList<Tag> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get_charchter() == search) {
                return i;
            }  //a 0 .1 
        }
        return -1;
    }

    public void increaseFreq() {
        this.freq++;
    }

    public void printTag() {
        System.out.println("-info:" + this.ch + "==>" + this.freq);
        System.out.println("-current:" + this.lowRange + "==>" + this.highRange);
        System.out.println("-last:" + this.lastlowRange + "==>" + this.lasthighRange);
        System.out.println();
    }

    /**
     * here*
     */
    public void changeToProp(int textsize) {
        this.freq = (double) this.freq / textsize;
    }
}
