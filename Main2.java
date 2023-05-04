
import javax.swing.*;
import javax.swing.plaf.ButtonUI;
import java.awt.*;
import java.awt.event.*;

class Main2 extends JFrame
{
    JTextField guess, bestscore, totalguess;
    ButtonListener buttonListener;
    ButtonListener2 buttonListener2;
    ButtonListener3 buttonListener3;
    JLabel inputlabel,guesslabel,trylabel,bestscorelabel,totalguesslabel,imglabel,titlelabel;

    int rand=(int) (Math.random()*100);
    int count=0;
    public Main2()
    {
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.WHITE);

	    titlelabel = new JLabel(" ROUND 3 ");
	    titlelabel.setForeground(Color.RED);
        titlelabel.setFont(new Font("SERIF",Font.BOLD,28));
        titlelabel.setSize(270,40);
        titlelabel.setLocation(170,10);

        guesslabel = new JLabel("Guess the Number ?");
        guesslabel.setForeground(Color.BLUE);
        guesslabel.setFont(new Font("SANSSERIF",Font.PLAIN,24));
        guesslabel.setSize(270,20);
        guesslabel.setLocation(120,90);

        inputlabel=new JLabel("Enter a number between 1-100");
        inputlabel.setFont(new Font("MONOSPACE",Font.PLAIN,14));
        inputlabel.setSize(270,20);
        inputlabel.setLocation(130,130);

        trylabel = new JLabel("Try and guess it !");
        trylabel.setFont(new Font("DIALOG",Font.ITALIC,20));
	    trylabel.setForeground(Color.RED);
        trylabel.setSize(290,40);
        trylabel.setLocation(150,190);

        guess = new JTextField(10);
        guess.setSize(60,20);
        guess.setLocation(190,160);

        bestscore = new JTextField(10);
        bestscore.setSize(30,20);
        bestscore.setLocation(340,50);

        bestscorelabel = new JLabel("Best Score");
        bestscorelabel.setFont(new Font("monospace",Font.PLAIN,14));
        bestscorelabel.setSize(270,20);
        bestscorelabel.setLocation(380,50);

        totalguess = new JTextField(10);
        totalguess.setSize(30,20);
        totalguess.setLocation(10,50);

        totalguesslabel = new JLabel("Total Guesses");
        totalguesslabel .setFont(new Font("dialog input",Font.PLAIN,14));
        totalguesslabel.setSize(270,20);
        totalguesslabel.setLocation(50,50);

      
        JButton guessbutton =new JButton("Guess");
        guessbutton.setSize(100,30);
        guessbutton.setLocation(170,240);
        guessbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener = new ButtonListener();
        guessbutton.addActionListener(buttonListener);

        JButton giveupbutton = new JButton("Give up!");
        giveupbutton.setSize(100,30);
        giveupbutton.setLocation(110,280);
        giveupbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener2 = new ButtonListener2();
        giveupbutton.addActionListener(buttonListener2);

        JButton playagainbutton = new JButton("Play Again!");
        playagainbutton.setSize(100,30);
        playagainbutton.setLocation(230,280);
        playagainbutton.setBackground(Color.LIGHT_GRAY);
        buttonListener3 = new ButtonListener3();
        playagainbutton.addActionListener(buttonListener3);


        c.add(bestscorelabel);
        c.add(totalguesslabel);
        c.add(trylabel);
        c.add(guesslabel);
        c.add(inputlabel);
        c.add(guess);
        c.add(bestscore);
        c.add(totalguess);
        c.add(guessbutton);
        c.add(giveupbutton);
        c.add(playagainbutton);
	    c.add(titlelabel);

        bestscore.setEditable(false);
        totalguess.setEditable(false);
        
        setTitle("GUESS THE NUMBER");
        setSize(500,400);
        setLocation(300,200);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private class ButtonListener implements ActionListener
    {
        int bestScore=100;
        public void actionPerformed(ActionEvent e)
        {   
            int a = Integer.parseInt(guess.getText());
            count=count+1;

            if (count ==5)
            {
            	trylabel.setText("You lose the game play again !");
            	count =0;
             }

            else {
            	if(a<rand)
            	{
            		trylabel.setText(a+" is low, try again!!");
            		}
            	else if(a>rand)
            	{
            		trylabel.setText(a+" is high, try again!!");
            		}
            	else
            	{
            		trylabel.setText("Your guess is correct, You win!!");
            		if(count==1)
            		{
            			bestScore=100;
            			bestscore.setText(bestScore+"");
            			}
            		else if (count*10<bestScore) {
            			bestScore = 100 - count*10;
            			bestscore.setText(bestScore+"");
            			}
            		else {
            			
            			bestscore.setText("" + bestScore);
            			}
            		}
            	guess.setEditable(true);
            	}
            guess.requestFocus();
            guess.selectAll();
            totalguess.setText(count+"");
            }
        }

    private class ButtonListener2 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            totalguess.setText("");
            trylabel.setText("The correct answer is "+rand+"!!");
            guess.setText("");
            guess.setEditable(false);
        }
    }

    private class ButtonListener3 implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            rand=(int) (Math.random()*100);
            guess.setText("");
            totalguess.setText("");
            trylabel.setText("Try and guess it !");
            totalguess.setText("");
            count=0;
            guess.setEditable(true);
            guess.requestFocus();
        }
    }
    

    public static void main(String[] args)
    {
        new Main2();
    }
}
