/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.tbot;

import javax.swing.JPanel;

/**
 *
 * @author user
 */
public interface Sight {

  public void setBot(Brain bot);
  
  public void setDisplayer(BoardDisplayer displayer);

  public JPanel getOption();
  
  public void setActive(boolean active);
  
  public Board getBoard();
}
