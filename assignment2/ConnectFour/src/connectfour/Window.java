package connectfour;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Window extends BaseWindow {

    private final int rows;
    private final int columns;
    private final Model model;
    private final JLabel label;
    private final MainWindow mainWindow;

    private final JButton[][] buttons;
    private final GridLayout grid;
    
    public Window(int rows,int columns, MainWindow mainWindow) {
        this.rows = rows;
        this.columns = columns;
        this.mainWindow = mainWindow;
        mainWindow.getWindowList().add(this);
        model = new Model(rows,columns);

        JPanel top = new JPanel();
        
        label = new JLabel();
        updateLabelText();
        
        JButton newGameButton = new JButton();
        newGameButton.setText("New game");
        newGameButton.addActionListener(e -> newGame());
        
        top.add(label);
        top.add(newGameButton);
        
        JPanel mainPanel = new JPanel();
        
        buttons = new JButton[rows][columns];
        grid = new GridLayout(rows,columns);
        mainPanel.setLayout(grid); 
        
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                buttons[i][j] = new JButton();
                buttons[i][j].addActionListener(new actionForButton());
                mainPanel.add(buttons[i][j]);
            }
        }    

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(top, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
    }
    
    private class actionForButton implements ActionListener{
        
        @Override
        public void actionPerformed(ActionEvent e){       
            for(int i=rows-1; i>=0; --i){
                for(int j=0; j<=columns-1; ++j){
                    if(buttons[i][j]== e.getSource()){
                        Player newValue = model.step(i, j);
                        if(newValue != model.getActualPlayer()){
                            buttons[model.getLastrow()][model.getLastcolumn()].setText(newValue.name());
                        }
                        updateLabelText();
            
                        Player winner = model.findWinner();
                        if (winner != Player.NOBODY) {
                            showGameOverMessage(winner);
                        }
                        
                        if (model.draw()) {
                            showGameDrawMessage();
                        }
                    }
                }
            }  
        }
    }

    private void showGameOverMessage(Player winner) {
        JOptionPane.showMessageDialog(this,
                "Game is over. Winner: " + winner.name());
        newGame();
    }
    
    private void showGameDrawMessage() {
        JOptionPane.showMessageDialog(this,
                "Game is over, it is draw. ");
        newGame();
    }
    
    private void newGame() {
        Window newWindow = new Window(rows, columns, mainWindow);
        newWindow.setVisible(true);
        
        this.dispose();
        mainWindow.getWindowList().remove(this);
    }
    
    private void updateLabelText() {
        label.setText("Current player: "
                + model.getActualPlayer().name());
    }

    @Override
    protected void doUponExit() {
        super.doUponExit();
        mainWindow.getWindowList().remove(this);
    }
    
}
