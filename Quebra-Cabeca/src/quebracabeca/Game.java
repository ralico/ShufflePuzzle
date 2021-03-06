package quebracabeca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 *Object responsible for the game logic
 *Implements Serializable to sava the game in the disk
 */
public class Game implements Serializable{
    private Board board = new Board();
    private Ranking info;
    private int shuffleTipe = 0;
    String imgFolder = new String();
    
    public Game() {
        loadInfo();
    }

    /**
    *Method to sstart the game
    */
    public void startGame(){
        board = new Board();
        board.shuffle(shuffleTipe);
    }
    
    /**
     * Method to define the Shuffle Tipe, Even or odd
     *@param tipo Receivers the Shuffle tipe, one for odd and two for even
     */
    public void setShuffleTipe(int tipe){
        shuffleTipe = tipe;
    }
    
    /**
     *Method to get the ranking
     *@return Returns a String with all ranking values.
     */
    public String getRanking(){
        loadInfo();
        return info.getRanking();
    }
    
    /**
     *Method to save all information in disk
     *@throws 
     */
    public void saveInfo(){
        try {
            String url;
            url = System.getProperty("user.dir");
            File file = new File(url + "GuardaInfo.txt");
            FileOutputStream fOut = new FileOutputStream(file);
            ObjectOutputStream objOut = new ObjectOutputStream(fOut);
            objOut.writeObject(info);
        } catch (Exception e) {
            System.out.println("Error saving in file :" + e.getMessage());
            System.out.println(e.getCause());
        }    
    }
    
    /**
     *Method to retrieve informations from disk
     */
    public void loadInfo(){
        try {
            String url;
            url = System.getProperty("user.dir");
            File file = new File(url + "GuardaInfo.txt");
            FileInputStream fIn = new FileInputStream(file);
            ObjectInputStream objIn = new ObjectInputStream(fIn);
            info = (Ranking)objIn.readObject();
            System.out.println("Recuperou");
        } catch (Exception e) {
            info = new Ranking();
            System.out.println("Error loading file :" + e.getMessage());
            System.out.println(e.getCause());
        }    
    }
    
    //#########################################################################
    //Methods Declaration
    /**
     *Method to shuffle the puzzle 
     *@param tipe receives the shuffle one for odd and two for even
     */
    public void shuffle(int tipe){
        board.shuffle(tipe);
    }
    
    /**
     *Method to move the piece
     *@param n 
     *
     */
    public int getMovePice(int n){
        int movePice;

        movePice = board.getMovePeca(n);

        if(movePice>=0){
            if(getWinner()){
                JOptionPane.showMessageDialog(null, "Congratulations you are the winner! \n" + "\n Points = " + board.getPunctuation(), "Congratulations", 1);
            }else{
                //
            }
        }
        return movePice;
    }
    
    /**
     *M�todo que retorna 
     *@return Retorna 
     */
    public boolean getWinner(){
        boolean win;
        win = board.getWinner();

        if(win==true){
            info.addRanking(getPoints());
            saveInfo();
            return  true;
        }
        return false;
    }

    public double getPoints(){
        return board.getPunctuation();
    }
    
    //Returns the column from piece n
    public int getCol(int n){
        return board.getCol(n);
    }
    
    //Returns the line from piece n
    public int getLine(int n){
        return board.getRow(n);
    }
    
    //Returns the value from the piece n
    public int getRealValue(int n){
        return board.getRealValue(n);
    }
    
    //Returns the position N of a piece in the line lin and column col
    public int getPositionN(int lin, int col){
        return board.getPositionN(lin, col);
    }
    
    public void cleanRanking(){
        info.clearRanking();
        saveInfo();
    }
    
    public void setImgFolder(String pasta){
        imgFolder = pasta;
    }
    
    public String getImgFolder(){
        return imgFolder;
    }
}
