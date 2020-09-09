package arithmatic;

import java.awt.Color;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import javax.swing.*;

public class Arithmatic {

    public static void main(String[] args) throws Exception {
        /**
         * to color the title bar*
         */
        UIDefaults uiDefaults = UIManager.getDefaults();
        uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.black));
        uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.white));
        JFrame.setDefaultLookAndFeelDecorated(true);

        @SuppressWarnings("unused")
        GUI graph = new GUI();
    }

    public static double Compression(ArrayList<Tag> list, String text) {
        return setranges(list, text);
    }

    public static String Decompression(double code, ArrayList<Tag> tag, int numOfCharachter) {
        double lower = 0.0;
        double upper = 1;
        String result = "";

        /**
         * calculate the fist ranges*
         */
        tag.get(0).setlastRanges(0, tag.get(0).get_freq());
        for (int i = 1; i < tag.size() - 1; i++) {
            tag.get(i).setlastRanges(tag.get(i - 1).getlastHightRanges(), tag.get(i - 1).getlastHightRanges() + tag.get(i).get_freq());
        }
        tag.get(tag.size() - 1).setlastRanges(1 - (tag.get(tag.size() - 1).get_freq()), 1);

        /**
         * calculate ranges*
         */
        for (int i = 0; i < numOfCharachter; i++) {

            /**
             * set new ranges*
             */
            tag.get(0).setCurrentRanges(lower, (lower + ((upper - lower) * tag.get(0).getlastHightRanges())));
            for (int x = 1; x < tag.size() - 1; x++) {
                tag.get(x).setCurrentRanges(tag.get(x - 1).getHightRanges(), (lower + ((upper - lower) * tag.get(x).getlastHightRanges())));
            }
            tag.get(tag.size() - 1).setCurrentRanges((lower + ((upper - lower) * tag.get(tag.size() - 1).getlastlowRanges())), upper);

            /**
             * set scale*
             */
            for (int a = 0; a < tag.size(); a++) {
                if ((code > tag.get(a).getlowRanges()) && (code < tag.get(a).getHightRanges())) {
                    lower = tag.get(a).getlowRanges();
                    upper = tag.get(a).getHightRanges();
                    result += tag.get(a).get_charchter();
                }
            }
        }

        return result;
    }

    /**
     * calculate probability*
     */
    public static ArrayList<Tag> calcProp(String text) {
        ArrayList<Tag> result = new ArrayList<Tag>();
        for (int i = 0; i < text.length(); i++) {

            if (IsExist(text.charAt(i), result)) {
                result.get(get_index(text.charAt(i), result)).increaseFreq();
            } else {
                result.add(new Tag(text.charAt(i), 1));
            }

        }
        return result;
    }

    /**
     * Search Function*
     */
    public static boolean IsExist(char search, ArrayList<Tag> tag) {
        for (int i = 0; i < tag.size(); i++) {
            if ((tag.get(i).get_charchter()) == search) {
                return true;
            }
        }
        return false;
    }

    public static int get_index(char search, ArrayList<Tag> tag) {
        for (int i = 0; i < tag.size(); i++) {
            if ((tag.get(i).get_charchter()) == search) {
                return i;
            }
        }
        return 0;
    }

    public static void freqToProp(String text, ArrayList<Tag> tags) {
        for (int i = 0; i < tags.size(); i++) {
            tags.get(i).changeToProp(text.length());
        }
    }

    public static double setranges(ArrayList<Tag> tag, String text) {
        double lower = 0.0;
        double upper = 1;
        ArrayList<Tag> inputprop = new ArrayList<Tag>();

        /**
         * calculate the fist ranges*
         */
        tag.get(0).setlastRanges(0, tag.get(0).get_freq());
        for (int i = 1; i < tag.size() - 1; i++) {
            tag.get(i).setlastRanges(tag.get(i - 1).getlastHightRanges(),
                    tag.get(i - 1).getlastHightRanges() + tag.get(i).get_freq());
        }
        tag.get(tag.size() - 1).setlastRanges(1 - (tag.get(tag.size() - 1).get_freq()), 1);

        /**
         * calculate ranges*
         */
        int index = 0;
        for (int i = 0; i < text.length(); i++) {

            /**
             * set new ranges*
             */
            tag.get(0).setCurrentRanges(lower, (lower + ((upper - lower) * tag.get(0).getlastHightRanges())));
            for (int x = 1; x < tag.size() - 1; x++) {
                tag.get(x).setCurrentRanges(tag.get(x - 1).getHightRanges(), (lower + ((upper - lower) * tag.get(x).getlastHightRanges())));
            }
            tag.get(tag.size() - 1).setCurrentRanges((lower + ((upper - lower) * tag.get(tag.size() - 1).getlastlowRanges())), upper);

            /**
             * set scale*
             */
            index = getIndex(text.charAt(i), tag);
            lower = tag.get(index).getlowRanges();
            upper = tag.get(index).getHightRanges();

        }

        index = getIndex(text.charAt(text.length() - 1), tag);
        /**
         * here*
         */
        return ((double) ((tag.get(index).getHightRanges() - tag.get(index).getlowRanges()) / 2) + tag.get(index).getlowRanges());

    }

    public static int getIndex(char search, ArrayList<Tag> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get_charchter() == search) {
                return i;
            }
        }
        return -1;
    }

    public static ArrayList<Tag> getInputTags() {
        ArrayList<Tag> list = new ArrayList<Tag>();

        return list;
    }

    /**
     * File Part*
     */
    /**
     * For compression*
     */
    public static void CompressToFile(ArrayList<Tag> list, String text, String file) throws Exception {
        FileWriter filewriter = new FileWriter(file);

        filewriter.write(String.valueOf(setranges(list, text)));
        filewriter.flush();
        filewriter.close();
    }

    public static double CompresFromFile(ArrayList<Tag> list, String textfile) throws Exception {
        String text = "";
        FileReader filereader = new FileReader(textfile);

        int i = 0;
        do {
            i = filereader.read();
            if (i != 0 && i != -1) {
                text += (char) i;
            }
        } while (i != -1);
        filereader.close();

        return setranges(list, text);
    }

    public static ArrayList<Tag> getPropFromFile(String file) throws Exception {
        ArrayList<Tag> result = new ArrayList<Tag>();
        FileReader filereader = new FileReader(file);
        String text = "";
        String textfromfile = "";
        result.clear();
        int i = 0;
        do {
            i = filereader.read();
            if (i != 0 && i != -1) {
                textfromfile += (char) i;
            }
        } while (i != -1);
        filereader.close();

        for (int x = 0; x < textfromfile.length(); x++) {
            if (textfromfile.charAt(x) == ';') {
                result.add(fsfsTag(text));
                text = "";
            } else {
                text += textfromfile.charAt(x);
            }
        }

        return result;
    }

    /**
     * For decompression
     *
     * @throws Exception *
     */
    public static double getCodeFromFile(String file) throws Exception {
        FileReader filereader = new FileReader(file);
        String text = "";
        int i = 0;
        do {
            i = filereader.read();
            if (i != 0 && i != -1) {
                text += (char) i;
            }
        } while (i != -1);
        filereader.close();

        return Double.parseDouble(text);
    }

    public static Tag fsfsTag(String text) {
        System.out.println(text);
        Tag result = new Tag();
        result.set_charchter(text.charAt(0));

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '-') {
                result.set_freq(Double.parseDouble(text.substring(i + 1)));
            } else {
            }
        }
        return result;
    }
}
