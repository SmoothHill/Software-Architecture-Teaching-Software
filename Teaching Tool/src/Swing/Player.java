package Swing;

import FUN1.demo1;
import FUN2.Alphabetizer;
import FUN2.Input;
import FUN2.Output;
import FUN2.Shift;
import FUN3.KWICSubject;
import FUN4.Pipe;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Player extends JFrame {
    private JButton MSButton, OOButton, OBButton, PFButton;
    private JTextArea textAreaDesc;
    private JLabel imgLabel;
    private JTextArea textAreaCode;
    private JTextArea textAreaResult;

    public Player() {
        createUI();
    }

    private void createUI() {
        setTitle("软件体系结构教学软件");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 500);
        setLayout(new BorderLayout());

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        MSButton = new JButton("1. 主程序-子程序");
        OOButton = new JButton("2. 面向对象");
        OBButton = new JButton("3. 观察者");
        PFButton = new JButton("4. 管道-过滤器");
        buttonPanel.add(MSButton);
        buttonPanel.add(OOButton);
        buttonPanel.add(OBButton);
        buttonPanel.add(PFButton);

        // 创建文本区域和图片标签
        textAreaDesc = new JTextArea(5, 30);
        textAreaDesc.setEditable(false);
        textAreaDesc.setLineWrap(true);
        textAreaDesc.setWrapStyleWord(true);
        imgLabel = new JLabel();
        imgLabel.setHorizontalAlignment(JLabel.CENTER);
        imgLabel.setVerticalAlignment(JLabel.CENTER);
        textAreaCode = new JTextArea(10, 30);
        textAreaCode.setEditable(false);
        textAreaResult = new JTextArea(10, 30);
        textAreaResult.setEditable(false);

        // 添加按钮监听器
        MSButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runFUN1();
            }
        });

        OOButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runFUN2();
            }
        });

        OBButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runFUN3();
            }
        });

        PFButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                runFUN4();
            }
        });

        // 添加组件到窗口
        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(textAreaDesc), BorderLayout.CENTER);
        add(imgLabel, BorderLayout.EAST);
        add(new JScrollPane(textAreaResult), BorderLayout.SOUTH);
        add(new JScrollPane(textAreaCode), BorderLayout.WEST);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void runFUN1() {
        // 更新描述文本
        textAreaDesc.setText("主程序/子程序风格将系统组织成层次结构，\n包括一个主程序和一系列子程序，\n主要用于能够将系统功能依层次分解为多个顺序执行步骤的系统。");
        // 更新原理图标题
        textAreaDesc.setText("主程序-子程序原理图");
        // 加载图片
        ImageIcon icon = new ImageIcon("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\1.png");
        imgLabel.setIcon(icon);
        // 运行FUN1程序并显示结果
        try {
            demo1 kwic = new demo1();
            kwic.input("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\input.txt");
            kwic.shift();
            kwic.alphabetizer();
            kwic.output("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt");

            // 读取输出文件内容
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt"));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
            reader.close();
            String output2 = output.toString();
            textAreaResult.setText(output2);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 更新核心代码
        textAreaCode.setText("核心代码:\r\n" +
                "public static void main(String[] args) {\r\n" +
                "        demo1 kwic = new demo1();\r\n" +
                "        kwic.input(\"C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\input.txt\");\r\n" +
                "        kwic.shift();\r\n" +
                "        kwic.alphabetizer();\r\n" +
                "        kwic.output(\"C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt\");\r\n" +
                "    }");
    }

    private void runFUN2() {
        // 更新描述文本
        textAreaDesc.setText("面向对象式风格将系统组织为多个独立的对象，\\n每个对象封装其内部的数据，\\n并基于数据对外提供服务，\\n\"\n" +
                "\t\t\t\t\t+ \"适用于那些能够基于数据信息分解和组织的软件系统。");
        // 更新原理图标题
        textAreaDesc.setText("面向对象原理图");
        // 加载图片
        ImageIcon icon = new ImageIcon("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\2.png");
        imgLabel.setIcon(icon);
        // 运行FUN2程序并显示结果
        try {
            Input input = new Input();
            input.input("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\input.txt");
            Shift shift = new Shift(input.getLineTxt());
            shift.shift();
            Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
            alphabetizer.sort();
            Output output = new Output(alphabetizer.getKwicList());
            output.output("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt");

            // 读取输出文件内容
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt"));
            StringBuilder output2 = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output2.append(line).append("\n");
            }
            reader.close();
            textAreaResult.setText(output2.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 更新核心代码
        textAreaCode.setText("核心代码:\r\n"
                + "public static void main(String[] args) {\r\n"
                + "        Input input = new Input();\r\n"
                + "        input.input(\"images and other files/input.txt\");\r\n"
                + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                + "        shift.shift();\r\n"
                + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                + "        alphabetizer.sort();\r\n"
                + "        Output output = new Output(alphabetizer.getKwicList());\r\n"
                + "        output.output(\"images and other files/output.txt\");\r\n"
                + "    }");
    }

    private void runFUN3() {
        // 更新描述文本
        textAreaDesc.setText("观察者模式允许对象在其状态变化时通知多个观察者对象，使得这些观察者能够自动更新。");
        // 更新原理图标题
        textAreaDesc.setText("观察者模式原理图");
        // 加载图片
        ImageIcon icon = new ImageIcon("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\3.png");
        imgLabel.setIcon(icon);
        // 运行FUN3程序并显示结果
        try {
            KWICSubject kwicSubject = new KWICSubject();

            // 确保这些类是FUN3包中的类，并且它们的构造函数与调用匹配
            FUN3.Input input = new FUN3.Input("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\input.txt");
            FUN3.Shift shift = new FUN3.Shift(input.getLineTxt());
            FUN3.Alphabetizer alphabetizer = new FUN3.Alphabetizer(shift.getKwicList());
            FUN3.Output output = new FUN3.Output(alphabetizer.getKwicList(), "C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt");

            kwicSubject.addObserver(input);
            kwicSubject.addObserver(shift);
            kwicSubject.addObserver(alphabetizer);
            kwicSubject.addObserver(output);

            kwicSubject.startKWIC();

            // 读取输出文件内容
            BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt"));
            StringBuilder outputText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputText.append(line).append("\n");
            }
            reader.close();
            textAreaResult.setText(outputText.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 更新核心代码
        textAreaCode.setText("核心代码:\r\n"
                + "public static void main(String[] args) {\r\n"
                + "        //创建主题\r\n"
                + "        KWICSubject kwicSubject = new KWICSubject();\r\n"
                + "        //创建观察者\r\n"
                + "        Input input = new Input(\"images and other files/input.txt\");\r\n"
                + "        Shift shift = new Shift(input.getLineTxt());\r\n"
                + "        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());\r\n"
                + "        Output output = new Output(alphabetizer.getKwicList(), \"images and other files/output.txt\");\r\n"
                + "\r\n"
                + "        // 将观察者加入主题\r\n"
                + "        kwicSubject.addObserver(input);\r\n"
                + "        kwicSubject.addObserver(shift);\r\n"
                + "        kwicSubject.addObserver(alphabetizer);\r\n"
                + "        kwicSubject.addObserver(output);\r\n"
                + "        // 逐步调用各个观察者\r\n"
                + "        kwicSubject.startKWIC();\r\n"
                + "    }");
    }

    private void runFUN4() {
        // 更新描述文本
        textAreaDesc.setText("管道-过滤器模式将数据流从一个过滤器传递到下一个过滤器，\n每个过滤器执行特定的处理，\n直到最终的输出。");
        // 更新原理图标题
        textAreaDesc.setText("管道-过滤器模式原理图");
        // 加载图片
        ImageIcon icon = new ImageIcon("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\4.png");
        imgLabel.setIcon(icon);
        // 运行FUN4程序并显示结果
        try {
            File inFile = new File("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\input.txt");
            File outFile = new File("C:\\Users\\16258\\Desktop\\Teaching Tool\\src\\Picture_File\\output.txt");
            Pipe pipe1 = new Pipe();
            Pipe pipe2 = new Pipe();
            Pipe pipe3 = new Pipe();


            FUN4.Input input = new FUN4.Input(inFile, pipe1);
            FUN4.Shift shift = new FUN4.Shift(pipe1, pipe2);
            FUN4.Alphabetizer alphabetizer = new FUN4.Alphabetizer(pipe2, pipe3);
            FUN4.Output output = new FUN4.Output(outFile, pipe3);

            input.transform();
            shift.transform();
            alphabetizer.transform();
            output.transform();

            // 读取输出文件内容
            BufferedReader reader = new BufferedReader(new FileReader(outFile));
            StringBuilder outputText = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                outputText.append(line).append("\n");
            }
            reader.close();
            textAreaResult.setText(outputText.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // 更新核心代码
        textAreaCode.setText("核心代码:\r\n"
                + "public static void main(String[] args) throws IOException {\r\n"
                + "        File inFile = new File(\"images and other files/input.txt\");\r\n"
                + "        File outFile = new File(\"images and other files/output.txt\");\r\n"
                + "        Pipe pipe1 = new Pipe();\r\n"
                + "        Pipe pipe2 = new Pipe();\r\n"
                + "        Pipe pipe3 = new Pipe();\r\n"
                + "        Input input = new Input(inFile, pipe1);\r\n"
                + "        Shift shift = new Shift(pipe1, pipe2);\r\n"
                + "        Alphabetizer alphabetizer  = new Alphabetizer(pipe2, pipe3);\r\n"
                + "        Output output = new Output(outFile,pipe3);\r\n"
                + "        input.transform();\r\n"
                + "        shift.transform();\r\n"
                + "        alphabetizer.transform();\r\n"
                + "        output.transform();\r\n"
                + "    }");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Player();
            }
        });
    }
}
