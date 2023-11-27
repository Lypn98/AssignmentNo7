package No7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;


public class Dentaku extends Frame {
    Button bt0,bt00,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,btPlus,btMinus,btClear,btKakeru,btWaru,btTen,btEqual,btRoot;
    JTextField txt1 = new JTextField("");
    //演算子ボタンをおした後か否
    boolean Calc = false;
    //押された演算子ボタンの名前
    String CalculateButton = "";
    //元のテキストフィールドの数字
    double setField = 0.0;
    //setFieldに数値を入力したかを判断
    boolean Number = false;

    boolean root = false;

    public static void main(String[] args) {
        Dentaku dntk = new Dentaku();
    } 

    Dentaku(){
        super("Calculator");
        this.setSize(400,500);

        //GridBagLayoutのマネージャーの作成
        GridBagLayout GBag = new GridBagLayout();
        GridBagConstraints GCon = new GridBagConstraints();

        setLayout(GBag);

        GCon.fill = GridBagConstraints.BOTH;
        GCon.weightx = 1.0;
        GCon.weighty = 1.0;
        GCon.insets = new Insets(2,2,2,2);

        //1行目
        GCon.gridx = 0;
        GCon.gridy = 0;
        GCon.gridwidth = 250;
        GCon.gridheight = 50;
        txt1 = new JTextField("");
        GBag.setConstraints(txt1, GCon);
        add(txt1);

        //2行目
        GCon.gridx = 0; GCon.gridy = 50;
        GCon.gridwidth = 50; GCon.gridheight = 50;
        NumberButton bt7 = new NumberButton("7"); GBag.setConstraints(bt7, GCon); add(bt7);

        GCon.gridx = 50; GCon.gridy = 50;
        NumberButton bt8 = new NumberButton("8"); GBag.setConstraints(bt8, GCon); add(bt8);

        GCon.gridx = 100; GCon.gridy = 50;
        NumberButton bt9 = new NumberButton("9"); GBag.setConstraints(bt9, GCon); add(bt9);

        GCon.gridx = 150; GCon.gridy = 50;
        RootButton btroot = new RootButton("√"); GBag.setConstraints(btroot, GCon); add(btroot);

        GCon.gridx = 200; GCon.gridy = 50;
        btClear = new ClearButton("C"); GBag.setConstraints(btClear, GCon); add(btClear);

        //3行目
        GCon.gridwidth = 50; GCon.gridheight = 50;
        GCon.gridx = 0; GCon.gridy = 100;
        NumberButton bt4 = new NumberButton("4"); GBag.setConstraints(bt4, GCon); add(bt4);

        GCon.gridx = 50; GCon.gridy = 100;
        NumberButton bt5 = new NumberButton("5"); GBag.setConstraints(bt5, GCon); add(bt5);

        GCon.gridx = 100; GCon.gridy = 100;
        NumberButton bt6 = new NumberButton("6"); GBag.setConstraints(bt6, GCon); add(bt6);

        GCon.gridx = 150; GCon.gridy = 100;
        CalcButton btKakeru = new CalcButton("×"); GBag.setConstraints(btKakeru, GCon); add(btKakeru);

        GCon.gridx = 200; GCon.gridy = 100;
        CalcButton btWaru = new CalcButton("÷"); GBag.setConstraints(btWaru, GCon); add(btWaru);

        //4行目
        GCon.gridwidth = 50; GCon.gridheight = 50;
        GCon.gridx = 0; GCon.gridy = 150;
        NumberButton bt1 = new NumberButton("1"); GBag.setConstraints(bt1, GCon); add(bt1);

        GCon.gridx = 50; GCon.gridy = 150;
        NumberButton bt2 = new NumberButton("2"); GBag.setConstraints(bt2, GCon); add(bt2);

        GCon.gridx = 100; GCon.gridy = 150;
        NumberButton bt3 = new NumberButton("3"); GBag.setConstraints(bt3, GCon); add(bt3);

        GCon.gridx = 200; GCon.gridy = 150;
        CalcButton btMinus = new CalcButton("-"); GBag.setConstraints(btMinus, GCon); add(btMinus);

        GCon.gridwidth = 50; GCon.gridheight = 100;
        GCon.gridx = 150; GCon.gridy = 150;
        CalcButton btPlus = new CalcButton("+"); GBag.setConstraints(btPlus, GCon); add(btPlus);

        //5行目
        GCon.gridwidth = 50; GCon.gridheight = 50;
        GCon.gridx = 0; GCon.gridy = 200;
        NumberButton bt0 = new NumberButton("0"); GBag.setConstraints(bt0, GCon); add(bt0);

        GCon.gridx = 50; GCon.gridy = 200;
        NumberButton bt00 = new NumberButton("00"); GBag.setConstraints(bt00, GCon); add(bt00);

        GCon.gridx = 100; GCon.gridy = 200;
        NumberButton btTen = new NumberButton("."); GBag.setConstraints(btTen, GCon); add(btTen);

        GCon.gridx = 200; GCon.gridy = 200;
        CalcButton btEqual = new CalcButton("="); GBag.setConstraints(btEqual, GCon); add(btEqual); 

        this.setVisible(true);
    }
    //テキストフィールドに押された文字をつなげる
    public void Result(String c){
        if(!Calc){
            txt1.setText(txt1.getText() + c);
        }
        else{
            txt1.setText(c);
            Calc = false;
        }
    }
    //数字ボタンの定義
    class NumberButton extends JButton implements ActionListener {
        private static final long serialVersionUID = 1L;
        public NumberButton(String label) {
            super(label);
            addActionListener(this);  // ActionListener を登録
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            String NumberKey = this.getText();
            Result(NumberKey);
        }
    }

    //演算子ボタンの定義
    class CalcButton  extends JButton implements ActionListener{
        private static final long serialVersionUID = 1L;

       public CalcButton(String label) {
            super(label);
            addActionListener(this);  // ActionListener を登録
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(Number){
                double resultValue = (Double.valueOf(txt1.getText())).doubleValue();

                if(CalculateButton.equals("+")){
                    setField = setField + resultValue;
                }
                else if(CalculateButton.equals("-")){
                    setField = setField - resultValue;
                }
                else if(CalculateButton.equals("×")){
                    setField = setField * resultValue;
                }
                else if(CalculateButton.equals("÷")){
                    setField = setField / resultValue;
                }
                else if(CalculateButton.equals("√")){
                    setField = (double)Math.sqrt(resultValue);
                }
                //計算結果をテキストフィールドに表示
                txt1.setText(String.valueOf(setField));
            }
                CalculateButton = this.getText();
                setField = (Double.valueOf(txt1.getText())).doubleValue();
                Calc = true;
                if(CalculateButton.equals("=")){
                    Number = false;
                }
                else{
                    Number = true;
                }
            }
    }
    //√のボタン
    class RootButton  extends JButton implements ActionListener{
        private static final long serialVersionUID = 1L;

       public RootButton(String label) {
            super(label);
            addActionListener(this);  // ActionListener を登録
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            if(root){
                double resultValue = (Double.valueOf(txt1.getText())).doubleValue();

                if(CalculateButton.equals("√")){
                    setField = (double)Math.sqrt(resultValue);
                }
                //計算結果をテキストフィールドに表示
                txt1.setText(String.valueOf(setField));
            }
                CalculateButton = this.getText();
                setField = (Double.valueOf(txt1.getText())).doubleValue();
                Calc = false;
                if(CalculateButton.equals("=")){
                    root = false;
                }
                else{
                    root = true;
                }
            }
    }
    

    //クリアボタンの定義
    class ClearButton  extends Button implements ActionListener{
        private static final long serialVersionUID = 1L;

       public ClearButton(String label) {
            super("C");
            addActionListener(this);  // ActionListener を登録
        }
    
        @Override
        public void actionPerformed(ActionEvent e) {
            //演算子ボタンを推した後か否
            Calc = false;
            //押された演算子ボタンの名前
            txt1.setText("");
            //元のテキストフィールドの数字
            setField = 0;
            //setFieldに数値を入力したかを判断
            Number = false;
            
        }
    }
}
