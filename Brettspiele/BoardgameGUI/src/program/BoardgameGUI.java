package program;

import classes.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// TODO Java Doc schreiben
// TODO Spielhilfe implementieren
// TODO Ausgabe und Spielfeld in Datei speichern
// TODO Spiel alleine spielen lassen
// TODO Spielfeld besser darstellen ?! Einzelne Objekte?!
// TODO Fragen, wie struktuiere ich so eine Anwendung? --> Reddit?!
// TODO Anwendungsname Gnome 
/**
 * Main Class for the Boardgame. By running this class a new boardgameGUI will
 * be initalized.
 *
 * @author robert
 */
public class BoardgameGUI extends JFrame
{

    private Game game;

    private JMenuBar jMenuBar;
    private JMenu jMenuDatei;
    private JMenu jMenuSpiel;
    private JMenuItem jMenuDateiItemSchliessen;
    private JMenuItem jMenuDateiItemHilfe;

    private JMenuItem jMenuSpielNeuesSpiel;
    private JMenuItem jMenuSpielSpielNeustarten;
    private JMenuItem jMenuSpielSpielBeenden;

    private JLabel jLabelGamefield;
    private JLabel jLabelCommandline;

    private JTextArea jTextAreaGamefield;
    private JTextArea jTextAreaCommandline;

    private JScrollPane jScrollPaneTextAreaCommandline;

    private JButton jButtonNextRound;

    /**
     * Constructor for a new BoardgameGUI. Will auomatically init the components
     * with initComponents()
     *
     */
    public BoardgameGUI()
    {
        initComponents();
    }

    /**
     * This function will initalize alle components of the gui. After
     * initializing all of the components it will add them to the frame and init
     * the corresponding actionlisteners with initActionListeners()
     *
     */
    private void initComponents()
    {
//      Settings for the Gui (Name, Layout, Size, etc.)
        setTitle("Brettspiel");
        setLayout(null);
        setSize(500, 500);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

//      This part is only used to set the correct name for the application for linux based systems
        Toolkit xToolkit = Toolkit.getDefaultToolkit();
        java.lang.reflect.Field awtAppClassNameField = null;
        try
        {
            awtAppClassNameField = xToolkit.getClass().getDeclaredField("awtAppClassName");
            awtAppClassNameField.setAccessible(true);
            awtAppClassNameField.set(xToolkit, "Brettspiel");
        }
        catch (Exception ex)
        {
        }

        jMenuBar = new JMenuBar();
        setJMenuBar(jMenuBar);

        jMenuDatei = new JMenu("Datei");
        jMenuBar.add(jMenuDatei);

        jMenuSpiel = new JMenu("Spiel");
        jMenuBar.add(jMenuSpiel);

        jMenuDateiItemHilfe = new JMenuItem("Hilfe");
        jMenuDatei.add(jMenuDateiItemHilfe);

        jMenuDateiItemSchliessen = new JMenuItem("Schließen");
        jMenuDatei.add(jMenuDateiItemSchliessen);

        jMenuSpielNeuesSpiel = new JMenuItem("Neues Spiel");
        jMenuSpiel.add(jMenuSpielNeuesSpiel);

        jMenuSpielSpielNeustarten = new JMenuItem("Spiel neustarten");
        jMenuSpiel.add(jMenuSpielSpielNeustarten);

        jMenuSpielSpielBeenden = new JMenuItem("Spiel beenden");
        jMenuSpiel.add(jMenuSpielSpielBeenden);

        jLabelGamefield = new JLabel("Spielfeld");
        jLabelGamefield.setBounds(25, 25, 100, 25);
        add(jLabelGamefield);

        jTextAreaGamefield = new JTextArea();
        jTextAreaGamefield.setEditable(false);
        jTextAreaGamefield.setBounds(25, 50, 450, 150);
        add(jTextAreaGamefield);

        jTextAreaCommandline = new JTextArea();
        jTextAreaCommandline.setEditable(false);
        jTextAreaCommandline.setLineWrap(true);
        jTextAreaCommandline.setWrapStyleWord(true);
        jTextAreaCommandline.setBounds(25, 250, 450, 150);

        jScrollPaneTextAreaCommandline = new JScrollPane(jTextAreaCommandline);
        jScrollPaneTextAreaCommandline.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPaneTextAreaCommandline.setBounds(25, 250, 450, 150);
        add(jScrollPaneTextAreaCommandline);

        jLabelCommandline = new JLabel("Ausgabe");
        jLabelCommandline.setBounds(25, 225, 100, 25);
        add(jLabelCommandline);

        jButtonNextRound = new JButton("Runde spielen");
        jButtonNextRound.setBounds(150, 415, 200, 25);
        add(jButtonNextRound);
        jButtonNextRound.setVisible(false);

        setVisible(true);
        initActionListeners();
    }
    
     /**
     * This Function will refresh the content of the jTextAreaGamefield, 
     * jTextAreaCommandline and the visibility and content of the jButtonNextRound
     *
     */
    private void refreshGUI()
    {
        jTextAreaGamefield.setText(game.getField());
        jTextAreaCommandline.setText(game.getOutput());
        if (game.isRunning() == false)
        {
            jButtonNextRound.setText("Erneut spielen");
        }
        else
        {
            jButtonNextRound.setVisible(true);
        }
    }

    /**
     * Main function of this class, initalizes a new BoardgameGUI
     * 
     * @param args 
     */
    public static void main(String[] args)
    {
        new BoardgameGUI();
    }

    private void initActionListeners()
    {
        jMenuDateiItemSchliessen.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuDateiItemSchliessenActionPerformed();
            }
        });

        jMenuDateiItemHilfe.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuDateiHilfeActionPerformed();
            }
        });

        jMenuSpielNeuesSpiel.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuSpielNeuesSpielActionPerformed();
            }
        });

        jMenuSpielSpielNeustarten.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuSpielSpielNeustartenActionPerformed();
            }
        });

        jMenuSpielSpielBeenden.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jMenuSpielSpielBeendenActionPerformed();
            }
        });

        jButtonNextRound.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                jButtonNextRoundActionPerformed();
            }
        });
    }

    private void jMenuDateiItemSchliessenActionPerformed()
    {
        System.exit(0);
    }

    private void jMenuSpielSpielNeustartenActionPerformed()
    {
        try
        {
            game.resetGame();
            JOptionPane.showMessageDialog(rootPane, "Spiel wurde zurück gesetzt!");
            jButtonNextRound.setText("Runde spielen");
            refreshGUI();
        }
        catch (Exception e)
        {

        }
    }

    private void jMenuSpielSpielBeendenActionPerformed()
    {
        if (game != null)
        {
            game = null;
            JOptionPane.showMessageDialog(rootPane, "Spiel wurde beendet!");
            jButtonNextRound.setVisible(false);
            jTextAreaGamefield.setText("");
            jTextAreaCommandline.setText("");
        }
    }

    private void jMenuDateiHilfeActionPerformed()
    {
        JOptionPane.showMessageDialog(rootPane, "Eine Hilfe wird demnächst implementiert.", "Hilfe", 1);
    }

    private void jButtonNextRoundActionPerformed()
    {
        if (game.isRunning() == true)
        {
            game.playRound();
        }
        else
        {
            game.restartGame();
        }
        refreshGUI();
    }

    private void jMenuSpielNeuesSpielActionPerformed()
    {
        initGame();
        if (game != null)
        {
            refreshGUI();
        }
    }

    private void initGame()
    {
        String input = null;
        int SpielerZahl = 0;

        input = JOptionPane.showInputDialog(rootPane, "Bitte geben Sie die Spieleranzahl an (2 - 6):", "Spieleranzahl", JOptionPane.INFORMATION_MESSAGE);

        if (input == null)
        {
            return;
        }

        try
        {
            SpielerZahl = Integer.parseInt(input);
        }
        catch (NumberFormatException e)
        {
            SpielerZahl = 0;
        }

        while (SpielerZahl < 2 || SpielerZahl > 6)
        {
            input = JOptionPane.showInputDialog(rootPane, "Bitte geben Sie die Spieleranzahl an (2 - 6):", "Spieleranzahl", JOptionPane.INFORMATION_MESSAGE);

            if (input == null)
            {
                return;
            }

            try
            {
                SpielerZahl = Integer.parseInt(JOptionPane.showInputDialog(rootPane, "Es wurde keine oder eine falsche Zahl eingegeben.\nBitte geben Sie die Spieleranzahl an (2 - 6):", "Spieleranzahl", JOptionPane.INFORMATION_MESSAGE));
            }
            catch (NumberFormatException e)
            {

            }
        }

        game = new Game(40, 2, 6);

        for (int i = 0; i < SpielerZahl; i++)
        {
            input = JOptionPane.showInputDialog(rootPane, "Bitte geben Sie den Spielernamen für Spieler " + (i + 1) + " ein:", "Name für Spieler " + (i + 1), JOptionPane.INFORMATION_MESSAGE);

            if (input == null)
            {
                game = null;
                return;
            }

            try
            {
                game.addPlayer(new Player(input));
            }
            catch (Exception e)
            {

            }
        }

        String playerlist = "";
        for (int j = 0; j < SpielerZahl; j++)
        {
            playerlist += "Spieler " + (j + 1) + ":  " + game.getPlayers().get(j) + "\n";
        }

        JOptionPane.showMessageDialog(rootPane, playerlist, "Spielerliste", JOptionPane.INFORMATION_MESSAGE);
    }

}
