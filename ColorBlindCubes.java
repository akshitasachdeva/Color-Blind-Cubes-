import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
class ColorBlindCubes implements ActionListener
{
JFrame fr;
JDialog d;
JButton b1[]=new JButton[64];
JButton b2,b3;
Timer t1,t2;
JTextField tf1,tf2;
JLabel lb1,lb2,lb3,lb4;
int x=80,y=100,count=60,s=0,time=0,count1=0;
int r=(int)(Math.random()*64);
String score;
ColorBlindCubes()
{
System.out.println(r);
fr=new JFrame("Color Blind Cubes");
fr.setSize(400,400);
fr.setLayout(null);
for(int i=0;i<64;i++)
{
b1[i]=new JButton();
b1[i].setBounds(x,y,30,30);
b1[i].setOpaque(true);
if((i+1)==r)
{
b1[i].setBackground(Color.gray);
}
else
{
b1[i].setBackground(Color.darkGray);
}
fr.add(b1[i]);
b1[i].addActionListener(this);
x+=30;
if((i+1)%8==0)
{
x=80;
y+=30;
}
}
tf1=new JTextField();
tf1.setBounds(100,65,30,30);
fr.add(tf1);
tf2=new JTextField();
tf2.setBounds(250,65,30,30);
fr.add(tf2);
lb3=new JLabel("Time left:");
lb3.setBounds(100,35,70,30);
fr.add(lb3);
lb4=new JLabel("Scores:");
lb4.setBounds(250,35,70,30);
fr.add(lb4);
d=new JDialog(fr);
d.setSize(300,300);
d.setLayout(null);
lb1=new JLabel("Your Score is");
lb1.setBounds(100,100,100,70);
lb1.setVisible(false);
d.add(lb1);
lb2=new JLabel();
lb2.setBounds(130,130,100,50);
lb2.setVisible(false);
d.add(lb2);
b2=new JButton("Close");
b2.setBounds(100,215,100,30);
d.add(b2);
b2.addActionListener(this);

d.setVisible(false);
t1=new Timer(650,this);
t1.start();
t2=new Timer(300,this);
t2.start();
fr.setVisible(true);
}
public static void main(String s[])
{
new ColorBlindCubes();
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==b1[r-1])
{
b1[r-1].setBackground(Color.darkGray);
r=(int)(Math.random()*64);
b1[r-1].setBackground(Color.gray);
s++;
tf2.setText(s+" ");
}
if(e.getSource()==t1)
{
if(count!=0)
{
tf1.setText(count+" ");
count--;
}
}
if(count==0) 
{
score=tf2.getText();
lb2.setText(score);
d.setVisible(true);
}
if(e.getSource()==t2)
{
if(count1==0)
{
lb1.setVisible(true);
lb2.setVisible(true);
count1=1;
}
else if(count1==1)
{
lb1.setVisible(false);
lb2.setVisible(false);
count1=0;
}
}
if(e.getSource()==b2)
{
System.exit(1);
}
}
}
 
