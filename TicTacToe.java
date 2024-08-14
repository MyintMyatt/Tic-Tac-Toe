package com.tic_tac_toe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.io.IOException;

public class TicTacToe {
    private int[][] data = new int[3][3];
    @FXML
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, restart;
    @FXML
    private Label label;
    @FXML
    private Line line1, line2, line3, line4, line5, line6, line7, line8;
    private int i = 0;
    private boolean flag = true;
    private String text = "";

    public void btn0Action(ActionEvent event) {
        showResult(btn0, i, 0, 0);
    }

    public void btn1Action(ActionEvent event) {
        showResult(btn1, i, 0, 1);
    }

    public void btn2Action(ActionEvent event) {
        showResult(btn2, i, 0, 2);
    }

    public void btn3Action(ActionEvent event) {
        showResult(btn3, i, 1, 0);
    }

    public void btn4Action(ActionEvent event) {
        showResult(btn4, i, 1, 1);
    }

    public void btn5Action(ActionEvent event) {
        showResult(btn5, i, 1, 2);
    }

    public void btn6Action(ActionEvent event) {
        showResult(btn6, i, 2, 0);
    }

    public void btn7Action(ActionEvent event) {
        showResult(btn7, i, 2, 1);
    }

    public void btn8Action(ActionEvent event) {
        showResult(btn8, i, 2, 2);
    }

    public void restart(ActionEvent event) throws IOException {
        new Main().start((Stage) ((Node) event.getSource()).getScene().getWindow());
    }

    public void showResult(Button btn, int i1, int row, int col) {
        if (flag) {
            allBtnAction(btn, i1, row, col);
        }
        if (checkResult() == 1) {
            flag = false;
            setBtnColor(text);
            label.setText("Player 1 wins");
        } else if (checkResult() == 2) {
            flag = false;
            setBtnColor(text);
            label.setText("Player 2 wins");
        } else if (i == 8) {
            label.setText("Draw");
        }
        i++;
    }

    public void allBtnAction(Button btn, int i, int row, int col) {
        Button b = btn;
        if (b.getText() == "") {
            if (i % 2 == 0) {
                data[row][col] = 1;
                b.setText("O");
            } else {
                data[row][col] = 2;
                b.setText("X");
            }
        }
    }

    public int checkResult() {
        int winner = 0;
        if (data[0][0] == data[1][1]) {
            if (data[1][1] == data[2][2]) {
                if (data[2][2] == 1) {
                    winner = 1;
                } else if (data[2][2] == 2) {
                    winner = 2;
                }
                if (winner != 0) {
                    text = "001122";
                }
            }
        }
        if (winner == 0) {
            if (data[0][2] == data[1][1]) {
                if (data[1][1] == data[2][0]) {
                    if (data[2][0] == 1) {
                        winner = 1;
                    } else if (data[2][0] == 2) {
                        winner = 2;
                    }
                    if (winner != 0) {
                        text = "021120";
                    }
                }
            }
        }
        if (winner == 0) {
            int k = 0;
            for (int j = 0; j < data.length; j++) {
                if (data[j][k] == data[j][k + 1]) {
                    if (data[j][k + 1] == data[j][k + 2]) {
                        if (data[j][k] == 1) {
                            winner = 1;
                        } else if (data[j][k] == 2) {
                            winner = 2;
                        }
                        if (winner != 0) {
                            text = j + "row";
                            break;
                        }
                    }
                }
                if (data[k][j] == data[k + 1][j]) {
                    if (data[k + 1][j] == data[k + 2][j]) {
                        if (data[k][j] == 1) {
                            winner = 1;
                        } else if (data[k][j] == 2) {
                            winner = 2;
                        }
                        if (winner != 0) {
                            text = j + "col";
                            break;
                        }
                    }
                }
            }
        }
        return winner;
    }

    public void setBtnColor(String st) {
        switch (st) {
            case "001122":
                line1.setVisible(true);
                break;
            case "021120":
                line2.setVisible(true);
                break;
            case "0row":
                line3.setVisible(true);
                break;
            case "1row":
                line4.setVisible(true);
                break;
            case "2row":
                line5.setVisible(true);
                break;
            case "0col":
                line6.setVisible(true);
                break;
            case "1col":
                line7.setVisible(true);
                break;
            case "2col":
                line8.setVisible(true);
                break;
        }
    }
}