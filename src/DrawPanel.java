import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;
import java.util.EmptyStackException;

class DrawPanel extends JPanel {

    private int drawMode;
    private String A;
    private String Rule;
    private double a, a1;
    private int n;
    private int x,x2,y,y2;
    private int d;

    public void setA(String A) {
        this.A = A;
    }
    public void setRule(String Rule) {
        this.Rule = Rule;
    }
    public void seta(double a) {
        this.a = a;
    }
    public void setn(int n) {
        this.n = n;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setD(int d) {
        this.d = d;
    }

    public DrawPanel(){
        setLayout(null);
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.black));
        drawMode = 0;
    }

    public void setDrawMode(int x){
        drawMode = x;
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        switch (drawMode) {
            case 1:
                a1=90;
                Paint(A, Rule, n, g);
                break;
        }
    }

    public void Paint(String A, String Rule, int n, Graphics g){
        Stack st=new Stack();
        ArrayList<String> arrayA = new ArrayList<String>();
        String[] masA = A.split("");
        for (int i=0;i<masA.length;i++) {
            arrayA.add(masA[i]);
        }
        ArrayList<String> arrayRule = new ArrayList<String>();
        String[] masRule = Rule.split("");
        for (int i=0;i<masRule.length;i++) {
            arrayRule.add(masRule[i]);
        }

        for (int j=1;j<=n;j++) {
            ArrayList<String> array = new ArrayList<String>();
            for (int i = 0; i < arrayA.size(); i++) {
                if (Objects.equals(arrayA.get(i), "F")) {
                    array.addAll(arrayRule);
                } else
                    array.add(arrayA.get(i));
            }
            arrayA = array;
        }

        for (int i=0; i<arrayA.size();i++){
            switch (arrayA.get(i)) {
                case "F":
                    x2=  (x+(int)(Math.sin(Math.toRadians(a1))*d));
                    y2=  (y+(int)(Math.cos(Math.toRadians(a1))*d));
                    g.drawLine(x,y,x2,y2);
                    x = x2; y = y2;
                    break;
                case "+":
                    a1=a1-a;
                    break;
                case "-":
                    a1=a1+a;
                    break;
                case "[":
                    st.push(x);
                    st.push(y);
                    st.push(a1);
                    break;
                case "]":
                    a1= (double) st.pop();
                    y= (int) st.pop();
                    x= (int) st.pop();
                    break;
            }
        }
    }
}
