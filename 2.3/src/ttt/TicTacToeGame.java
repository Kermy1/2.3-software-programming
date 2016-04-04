package ttt;

import java.util.Random;
class TicTacToe
{
	private static final int HUMAN        = 0; 
	private static final int COMPUTER     = 1; 
	public  static final int EMPTY        = 2;

	public  static final int HUMAN_WIN    = 0;
	public  static final int DRAW         = 1;
	public  static final int UNCLEAR      = 2;
	public  static final int COMPUTER_WIN = 3;

	private int[][] board = new int[3][3];
    private Random random=new Random();  
	private int side=random.nextInt(2);  
	private int position=UNCLEAR;
	private char computerChar,humanChar;

	// Constructor
	public TicTacToe()
	{
		clearBoard();
		initSide();
	}
	
	private void initSide()
	{
	    if (this.side==COMPUTER) { computerChar='X'; humanChar='O'; }
		else                     { computerChar='O'; humanChar='X'; }
    }
    
    public void setComputerPlays()
    {
        this.side=COMPUTER;
        initSide();
    }
    
    public void setHumanPlays()
    {
        this.side=HUMAN;
        initSide();
    }

	public boolean computerPlays()
	{
	    return side==COMPUTER;
	}

	public int chooseMove()
	{
	    Best best=chooseMove(COMPUTER);
	    return best.row*3+best.column;
	    //return 0;
    }
    
    // Find optimal move
	public Best chooseMove(int side)
	{
		int opp;              // The other side
		Best reply;           // Opponent's best reply
		int simpleEval;       // Result of an immediate evaluation
		int bestRow = 0;
		int bestColumn = 0;
		int value;

		if((simpleEval = positionValue()) != UNCLEAR){
			return new Best(simpleEval);
		}

		if(side==COMPUTER){
			opp = HUMAN;
			value = Integer.MIN_VALUE;
			
		}else{
			opp = COMPUTER;
			value = Integer.MAX_VALUE;
		}
		for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(squareIsEmpty(i, j)){
                    TicTacToe copy = this.copy();
                    copy.place(i, j, side);
                    reply = copy.chooseMove(opp);
                    if(side==COMPUTER){
                    	if(value < reply.val){
                            value = reply.val;
                            bestRow = i;
                            bestColumn = j;
                        }
                    }
                    if(side==HUMAN){
                    	if(value > reply.val){
                            value = reply.val;
                            bestRow = i;
                            bestColumn = j;
                        }
                    }
                }
            }
        }
		//System.out.println(side+": "+value+" "+bestRow+","+bestColumn);
	    return new Best(value, bestRow, bestColumn);
    }
	private TicTacToe copy(){
        TicTacToe copy = new TicTacToe();
        if(this.computerPlays()){
            copy.setComputerPlays();
        } else {
            copy.setHumanPlays();
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                copy.place(i, j, board[i][j]);
            }
        }
        return copy;
    }
   
    //check if move ok
    public boolean moveOk(int move)
    {
 	return (move>=0 && move <=8 && board[move/3][ move%3] == EMPTY);
 	//return true;
    }
    
    // play move
    public void playMove(int move)
    {
		board[move/3][ move%3] = this.side;
		if (side==COMPUTER) this.side=HUMAN;  else this.side=COMPUTER;
	}


	// Simple supporting routines
	public void clearBoard()
	{
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){				
				place(i,j,EMPTY);
			}
		}
	}


	private boolean boardIsFull()
	{
		boolean check = true;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){				
				if(squareIsEmpty(i,j)){
					check = false;
				}
			}
		}
		return check;
	}

	// Returns whether 'side' has won in this position
	public  boolean isAWin(int side)
	{
	    int state = positionValue();
	    if((state==COMPUTER_WIN&&side==COMPUTER)||(state==HUMAN_WIN&&side==HUMAN)){
	    	return true;
	    }else{
	    	return false;
	    }
    }

	// Play a move, possibly clearing a square
	private void place(int row, int column, int piece)
	{
		board[row][column] = piece;
	}

	private boolean squareIsEmpty(int row, int column)
	{
		return board[ row ][ column ] == EMPTY;
	}

	// Compute static value of current position (win, draw, etc.)
	public int positionValue()
	{
		//horizontal rows check
		for(int i=0; i<3; i++){
			if(board[i][0]!=EMPTY&&board[i][0]==board[i][1]&&board[i][0]==board[i][2]){
				if(board[i][0]==HUMAN){
					return HUMAN_WIN;
				}else if(board[i][0]==COMPUTER){
					return COMPUTER_WIN;
				}
			}
		}
		//vertical rows check
		for(int i=0; i<3; i++){
			if(board[0][i]!=EMPTY&&board[0][i]==board[1][i]&&board[0][i]==board[2][i]){
				if(board[0][i]==HUMAN){
					return HUMAN_WIN;
				}else if(board[0][i]==COMPUTER){
					return COMPUTER_WIN;
				}
			}
		}
		//diagonal line check
		if(board[0][0]!=EMPTY&&board[0][0]==board[1][1]&&board[0][0]==board[2][2]){
			if(board[0][0]==HUMAN){
				return HUMAN_WIN;
			}else if(board[0][0]==COMPUTER){
				return COMPUTER_WIN;
			}
		}
		if(board[0][2]!=EMPTY&&board[0][2]==board[1][1]&&board[0][2]==board[2][0]){
			if(board[0][2]==HUMAN){
				return HUMAN_WIN;
			}else if(board[0][2]==COMPUTER){
				return COMPUTER_WIN;
			}
		}
		
		if(boardIsFull()){
			return DRAW;
		}
		return UNCLEAR;
	}
	
	
	public String toString()
	{
		String display = "";
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(board[i][j]==HUMAN){ 
					display += humanChar; 
				}else if(board[i][j]==COMPUTER){
					display += computerChar;
				}else if(board[i][j]==EMPTY){
					display += ".";
				}
			}
			display += "\n";
		}
		return display;   
		//return "...\n...\n...\n";   
	}  
	
	public boolean gameOver()
	{
	    this.position=positionValue();
	    return this.position!=UNCLEAR;
    }
    
    public String winner()
    {
        if      (this.position==COMPUTER_WIN) return "computer";
        else if (this.position==HUMAN_WIN   ) return "human";
        else                                  return "nobody";
    }
    
	
	private class Best
    {
       int row;
       int column;
       int val;

       public Best( int v )
         { this( v, 0, 0 ); }
      
       public Best( int v, int r, int c )
        { val = v; row = r; column = c; }
    } 
	
	
}

