package arithmatic;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.*;

// head first design patterns


@SuppressWarnings("serial")
class ImagePanel extends JComponent {

    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}

public class GUI {

    Arithmatic m = new Arithmatic();
    String inputText = "";
    String outputText = "";
    ArrayList<Tag> tag = new ArrayList<Tag>();
    String filepath = "";
    int numberOfChar = 0;
    double code = 0.0;

    public GUI() throws Exception {
        /**
         * Frame setting*
         */

        JFrame frame = new JFrame("Multi Assignment 3");
        JPanel panel = new JPanel();
        frame.setBounds(150, 0, 800, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /**
         * Icon Image setting*
         */
        frame.setIconImage(ImageIO.read(new File("C:\\Users\\mohamed shaban\\Desktop\\arithmatic\\src\\arithmatic\\icon1.png")));

        /**
         * Border setting*
         */
        Border border = new LineBorder(Color.black, 4, true);
        panel.setBorder(border);

        /**
         * background setting*
         */
        try {
            frame.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\mohamed shaban\\Desktop\\arithmatic\\src\\arithmatic\\porsche.jpg")))));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /**
         * buttons*
         */
        JButton comp = new JButton("Compress");
        JButton compTofile = new JButton("Compress To File");
        JButton compFromfile = new JButton("Compress From File");
        JButton compFromTofile = new JButton("Compress From&To file");
        JButton calc_prop = new JButton("Calculate Prop");
        JButton propfromfile = new JButton("Get prop From file");
        JButton decomp = new JButton("Decompress");
        JButton decompTofile = new JButton("Decompress To File");
        JButton decompFromfile = new JButton("Decompress From file");
        JButton decompFromTofile = new JButton("Decompress From&To file");

        //button 1
        comp.setForeground(Color.white);
        comp.setBackground(Color.black);
        comp.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        comp.setBounds(500, 140, 250, 50);
        frame.add(comp);

        //button 2
        compTofile.setForeground(Color.white);
        compTofile.setBackground(Color.black);
        compTofile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        compTofile.setBounds(500, 200, 250, 50);
        frame.add(compTofile);

        //button 3
        compFromfile.setForeground(Color.white);
        compFromfile.setBackground(Color.black);
        compFromfile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        compFromfile.setBounds(500, 260, 250, 50);
        frame.add(compFromfile);

        //button 4
        calc_prop.setForeground(Color.white);
        calc_prop.setBackground(Color.black);
        calc_prop.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        calc_prop.setBounds(50, 360, 250, 50);
        frame.add(calc_prop);

        //button 5
        propfromfile.setForeground(Color.white);
        propfromfile.setBackground(Color.black);
        propfromfile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        propfromfile.setBounds(50, 420, 250, 50);
        frame.add(propfromfile);

        //button 6
        decomp.setForeground(Color.white);
        decomp.setBackground(Color.black);
        decomp.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        decomp.setBounds(500, 380, 250, 50);
        frame.add(decomp);

        //button 7
        decompTofile.setForeground(Color.white);
        decompTofile.setBackground(Color.black);
        decompTofile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        decompTofile.setBounds(500, 440, 250, 50);
        frame.add(decompTofile);

        //button 8
        compFromTofile.setForeground(Color.white);
        compFromTofile.setBackground(Color.black);
        compFromTofile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        compFromTofile.setBounds(500, 320, 250, 50);
        frame.add(compFromTofile);

        //button 9
        decompFromfile.setForeground(Color.white);
        decompFromfile.setBackground(Color.black);
        decompFromfile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        decompFromfile.setBounds(500, 500, 250, 50);
        frame.add(decompFromfile);

        decompFromTofile.setForeground(Color.white);
        decompFromTofile.setBackground(Color.black);
        decompFromTofile.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        decompFromTofile.setBounds(500, 560, 250, 50);
        frame.add(decompFromTofile);

        /**
         * Input label*
         */
        JLabel input = new JLabel("Input");
        input.setForeground(Color.black);
        input.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        input.setBounds(50, 150, 250, 50);
        frame.add(input);

        /**
         * Output label*
         */
        JLabel output = new JLabel("Output");
        output.setForeground(Color.black);
        output.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        output.setBounds(50, 250, 250, 50);
        frame.add(output);

        /**
         * Number Of Character label*
         */
        JLabel charno = new JLabel("Number of charcter");
        charno.setForeground(Color.black);
        charno.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        charno.setBounds(50, 50, 250, 50);
        frame.add(charno);

        /**
         * Input Text Field*
         */
        JTextField inputcode = new JTextField();
        inputcode.setForeground(Color.white);
        inputcode.setBackground(Color.black);
        inputcode.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        inputcode.setBounds(50, 200, 250, 50);
        frame.add(inputcode);

        /**
         * Output Text Field*
         */
        JTextField outcode = new JTextField();
        outcode.setForeground(Color.white);
        outcode.setBackground(Color.black);
        outcode.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        outcode.setBounds(50, 300, 250, 50);
        frame.add(outcode);

        /**
         * Number Of Character Text Field*
         */
        JTextField numofchar = new JTextField();
        numofchar.setForeground(Color.white);
        numofchar.setBackground(Color.black);
        numofchar.setFont(new Font("Comic Sans MS", Font.BOLD | Font.ITALIC, 18));
        numofchar.setBounds(50, 100, 50, 50);
        frame.add(numofchar);

        frame.setVisible(true);
        /**
         * action of button1*
         */
        comp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outcode.setText(String.valueOf(Arithmatic.Compression(tag, inputcode.getText())));

            }
        });

        compTofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showDialog(compTofile, "Choose file to compress in");
                try {
                    FileWriter fw = new FileWriter(jfc.getSelectedFile().toString());
                    fw.write(String.valueOf(Arithmatic.Compression(tag, inputcode.getText())));
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                }
            }
        });

        compFromfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showDialog(compFromfile, "Choose file to compress from");
                try {
                    FileReader fr = new FileReader(jfc.getSelectedFile().toString());
                    int i = 0;
                    do {
                        i = fr.read();
                        if (i != 0 && i != -1) {
                            inputText += (char) i;
                        }
                    } while (i != -1);
                    fr.close();

                    outcode.setText(String.valueOf(Arithmatic.Compression(tag, inputText)));
                } catch (IOException e1) {
                }
            }
        });

        compFromTofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                JFileChooser jfc2 = new JFileChooser();
                jfc.showDialog(compFromfile, "Choose file to compress from");
                jfc2.showDialog(compFromfile, "Choose file to compress to");
                try {
                    FileReader fr = new FileReader(jfc.getSelectedFile().toString());
                    int i = 0;
                    do {
                        i = fr.read();
                        if (i != 0 && i != -1) {
                            inputText += (char) i;
                        }
                    } while (i != -1);
                    fr.close();

                    outputText = String.valueOf(Arithmatic.Compression(tag, inputText));
                } catch (IOException e1) {
                }

                try {
                    FileWriter fw = new FileWriter(jfc2.getSelectedFile().toString());
                    fw.write(String.valueOf(outputText));
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                }
            }
        });

        decomp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                code = Double.parseDouble(inputcode.getText());
                outcode.setText(Arithmatic.Decompression(code, tag, Integer.parseInt(numofchar.getText())));
            }
        });

        decompTofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showDialog(compTofile, "Choose file to compress in");
                try {
                    FileWriter fw = new FileWriter(jfc.getSelectedFile().toString());
                    fw.write(Arithmatic.Decompression(Double.parseDouble(inputcode.getText()), tag, Integer.parseInt(numofchar.getText())));
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                }
            }
        });

        decompFromfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showDialog(compFromfile, "Choose file to compress from");
                try {
                    FileReader fr = new FileReader(jfc.getSelectedFile().toString());
                    int i = 0;
                    do {
                        i = fr.read();
                        if (i != 0 && i != -1) {
                            inputText += (char) i;
                        }
                    } while (i != -1);
                    fr.close();

                    outcode.setText(Arithmatic.Decompression(Double.parseDouble(inputText), tag, Integer.parseInt(numofchar.getText())));
                } catch (IOException e1) {
                }
            }
        });
        decompFromTofile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                JFileChooser jfc2 = new JFileChooser();
                jfc.showDialog(compFromfile, "Choose file to compress from");
                jfc2.showDialog(compFromfile, "Choose file to compress to");
                try {
                    FileReader fr = new FileReader(jfc.getSelectedFile().toString());
                    int i = 0;
                    do {
                        i = fr.read();
                        if (i != 0 && i != -1) {
                            inputText += (char) i;
                        }
                    } while (i != -1);
                    fr.close();

                    outputText = Arithmatic.Decompression(Double.parseDouble(inputText), tag, Integer.parseInt(numofchar.getText()));
                } catch (IOException e1) {
                }

                try {
                    FileWriter fw = new FileWriter(jfc2.getSelectedFile().toString());
                    fw.write((String) (outputText));
                    fw.flush();
                    fw.close();
                } catch (IOException e1) {
                }
            }
        });

        calc_prop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tag = Arithmatic.calcProp(inputcode.getText());
                Arithmatic.freqToProp(inputcode.getText(), tag);
            }
        });

        propfromfile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                jfc.showDialog(compFromfile, "Choose Propailty file");
                try {
                    tag = Arithmatic.getPropFromFile(jfc.getSelectedFile().toString());

                } catch (Exception e1) {
                }
            }
        });

    }
}
