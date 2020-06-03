package tictac;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class game implements ActionListener
{
JFrame f;
JPanel p;
JButton b[]=new JButton[9];
JButton b1;
JLabel l1,l2,l3,l4;
ImageIcon ic1,ic2,ic3,ic4,ic5;
game()
{
	f=new JFrame("TIC TAC TOE");
	f.setSize(1000,1000);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	f.setLayout(null);
	f.getContentPane().setBackground(Color.BLACK);
 
	p=new JPanel();
	p.setLayout(new GridLayout(3,3,10,10));
	p.setSize(400,400);
	p.setLocation(270,130);
	p.setBackground(Color.BLACK);
	l1=new JLabel("GAME ON",JLabel.CENTER);
	
	l1.setBounds(339,30,250,50);
	l1.setFont(new Font("comics MS",Font.ITALIC,50));
	l1.setForeground(Color.MAGENTA);
	ic1=new ImageIcon(new ImageIcon("image//x.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH));		
	l3=new JLabel(ic1,JLabel.CENTER);
	l3.setBounds(260,30,70,70);
	l3.setIcon(ic1);
	ic2=new ImageIcon(new ImageIcon("image//o.png").getImage().getScaledInstance(60,60,Image.SCALE_SMOOTH));
	l4=new JLabel(ic2,JLabel.CENTER);
	l4.setBounds(600,30,70,70);
	l4.setIcon(ic2);
	ic3=new ImageIcon(new ImageIcon("image//tl.jpg").getImage().getScaledInstance(500,100,Image.SCALE_SMOOTH));
	l2=new JLabel(ic3,JLabel.CENTER);
	l2.setIcon(ic3);
	l2.setBounds(220,550,500,150);
	ic4=new ImageIcon(new ImageIcon("image//bx.jpg").getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
	ic5=new ImageIcon(new ImageIcon("image//ob.jpg").getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH));
b1=new JButton("REFRESH");
b1.setFont(new Font("Arial",Font.BOLD,10));
b1.setForeground(Color.BLACK);
b1.setBounds(800,300,100,50);
b1.setBackground(Color.red);


	
	
	for(int i=0;i<9;i++)
	{
		b[i]=new JButton();
	    b[i].addActionListener(this);
	    b[i].setFont(new Font("Arial",Font.ITALIC,1));
	    b[i].setBackground(Color.DARK_GRAY);
		p.add(b[i]);
		f.add(l3);
		}
	f.add(p);
	f.add(l1);
	f.add(l2);
	f.add(b1);
	f.add(l4);
	b1.addActionListener(this);
	f.setVisible(true);
}
void refresh()
{
	for(int i=0;i<9;i++)
	{
	b[i].setText("");
	b[i].setIcon(null);
	b[i].setEnabled(true);
	}
}
int fl=0,c=0;
public void actionPerformed(ActionEvent ev)
{
	if(ev.getActionCommand().equals("REFRESH"))
	{
		refresh();
		return;
	}
	
 if(fl==0&&((JButton)ev.getSource()).getText().length()==0)
		{
			((JButton)ev.getSource()).setText("x");
			((JButton)ev.getSource()).setIcon(ic4);
			c++;
			fl=1;
		}
		else  if(fl==1&&((JButton)ev.getSource()).getText().length()==0){
			((JButton)ev.getSource()).setText("o");
			((JButton)ev.getSource()).setIcon(ic5);
			c++;
			fl=0;
		}
	
		if(b[0].getText().equals(b[1].getText())&& b[1].getText().equals(b[2].getText())&& !b[0].getText().equals(""))
	{
JOptionPane.showMessageDialog(null,"win");
refresh();
	}
if(b[3].getText().equals(b[4].getText())&& b[4].getText().equals(b[5].getText())&& !b[3].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}
if(b[6].getText().equals(b[7].getText())&& b[7].getText().equals(b[8].getText())&& !b[6].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();	}

if(b[0].getText().equals(b[3].getText())&& b[3].getText().equals(b[6].getText())&& !b[0].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}
if(b[1].getText().equals(b[4].getText())&& b[4].getText().equals(b[7].getText())&& !b[1].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}
if(b[2].getText().equals(b[5].getText())&& b[5].getText().equals(b[8].getText())&& !b[2].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}
if(b[0].getText().equals(b[4].getText())&& b[4].getText().equals(b[8].getText())&& !b[0].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}
if(b[2].getText().equals(b[4].getText())&& b[4].getText().equals(b[6].getText())&& !b[2].getText().equals(""))
{
JOptionPane.showMessageDialog(null,"win");
refresh();
}	
if(c == 9)
{
	JOptionPane.showMessageDialog(null,"Draw");
	refresh();
}
}
public static void main(String args[])
{
new game();
}
}