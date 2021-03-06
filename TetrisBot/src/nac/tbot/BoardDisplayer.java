/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nac.tbot;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author nathaniel
 */
public class BoardDisplayer extends javax.swing.JPanel {

  public static final int GRID_SIZE = 18;
  private Dimension boardDimension;
  private Board board;

  /**
   * Creates new form MeasurePanel
   */
  public BoardDisplayer() {
    initComponents();
  }

  @Override
  public Dimension getPreferredSize() {
    if (boardDimension != null) {     
      return boardDimension;
    } else {
      return super.getPreferredSize();
    }
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    int height = getHeight();
    int width = getWidth();

    g2d.setColor(Color.red);
    g2d.setStroke(new BasicStroke(1F));

    int gridHeight = 18;
    int gridWidth = 18;

    for (int i = 1; i < 10; i++) {
      g2d.drawLine(i * gridWidth, 0, i * gridWidth, height);
    }

    for (int i = 1; i < 20; i++) {
      g2d.drawLine(0, i * gridHeight, width, i * gridHeight);
    }

    g2d.setStroke(new BasicStroke(1F));

    if (board != null) {

      boolean[][] data = board.getData();
      int rows = board.getRows();
      int cols = board.getColumns();

      for (int i = 0; i < rows; i++) {
        boolean[] row = data[i];
        for (int j = 0; j < cols; j++) {
          if (row[j]) {
            g2d.setColor(Color.black);
          } else {
            g2d.setColor(Color.white);
          }

          int rx = j * gridWidth + 5;
          int ry = i * gridHeight + 5;
          g2d.fillRect(rx, ry, 8, 8);

        }
      }
    }
  }

  public static int getBit(int n, int k) {
    return (n >> k) & 1;
  }

  public void updateDimension() {
    this.boardDimension = new Dimension(board.getColumns() * GRID_SIZE, board.getRows() * GRID_SIZE);
  }

  public void setBoard(Board board) {
    this.board = board;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 398, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 298, Short.MAX_VALUE)
    );
  }// </editor-fold>//GEN-END:initComponents
  // Variables declaration - do not modify//GEN-BEGIN:variables
  // End of variables declaration//GEN-END:variables
}
