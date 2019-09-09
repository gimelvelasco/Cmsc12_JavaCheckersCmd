public class piece{
	//
	private int i,j,itemp,jtemp,icheck,jcheck;
	private int a,b,atemp,btemp,acheck,bcheck;
	private int x,y,xtemp,ytemp,xcheck,ycheck;
	private int p,q,pcounter,qcounter;
	private String ijtemp,abtemp,xytemp;
	private char[] atoh = {'a','b','c','d','e','f','g','h'};
	private char[] otoe = {'1','2','3','4','5','6','7','8'};
	private boolean validmove1,validmove2;
	//
	//
	//
	public void newGame(String[][] board1){ //this function will assemble the initial position of the pieces into the board
		board1[2][3]=" R ";
		board1[2][5]=" R ";
		board1[2][7]=" R ";				//mahirap po gamitan ng 'for' loop eh kaya inisa-isa ko nalang
		board1[2][9]=" R ";
		board1[3][2]=" R ";
		board1[3][4]=" R ";
		board1[3][6]=" R ";
		board1[3][8]=" R ";
		board1[4][3]=" R ";
		board1[4][5]=" R ";
		board1[4][7]=" R ";
		board1[4][9]=" R ";
		board1[7][2]=" B ";
		board1[7][4]=" B ";
		board1[7][6]=" B ";
		board1[7][8]=" B ";
		board1[8][3]=" B ";
		board1[8][5]=" B ";
		board1[8][7]=" B ";
		board1[8][9]=" B ";
		board1[9][2]=" B ";
		board1[9][4]=" B ";
		board1[9][6]=" B ";
		board1[9][8]=" B ";
	}
	//
	//
	//
	public int move(String sp1,String sd1,String[][] board1,int omc1){
		//
		char[] converter = sp1.toCharArray();
		for(jtemp=0;jtemp<8;jtemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh[jtemp]==converter[0]){
				j=jtemp;
				break;
			}
		}
		for(itemp=0;itemp<8;itemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe[itemp]==converter[1]){
				i=7-itemp;
				break;
			}
		}
		i=i+2;
		j=j+2;
		//
		if(board1[i][j]=="   "||board1[i][j]=="---"||board1[i][j]==""){
			System.out.println("No piece was selected.\t\t!!!!!\t\tNo piece was selected."); //to check if a piece was selected
		}
		//
		else{
			if(omc1%2==0&&board1[i][j]==" R "){
				System.out.println("Invalid Move.\t\t\t!!!!!\t\tInvalid Move."); //to check if the player selected the wrong piece
			}
			else if(omc1%2==1&&board1[i][j]==" B "){ //to check if the player selected the enemy's piece
				System.out.println("Invalid Move.\t\t\t!!!!!\t\tInvalid Move.");
			}
			else{
				ijtemp = board1[i][j];
				icheck = i;
				jcheck = j;
				char[] converter1 = sd1.toCharArray();
				for(jtemp=0;jtemp<8;jtemp++){ //this for loop is used so that the character of the selected destination would be converted to an integer to easily access the 2D array
					if(atoh[jtemp]==converter1[0]){
						if((j+1)==(jtemp+2)||(j-1)==(jtemp+2)){ //this 'if' statement's use is to check if the sideward movement of the piece is valid
							j=jtemp;
							j=j+2;
							validmove1=true;
						}
						else{
							System.out.println("Invalid Sideward Move.\t\t!!!!!\t\tInvalid Sideward Move.");
							validmove1=false;
						}
						break;
					}
				}
				for(itemp=0;itemp<8;itemp++){ //also this for loop is used so that the character would be converted to an integer to easily access the 2D array (same as above)
					if(otoe[itemp]==converter1[1]){
						if(omc1%2==0){ //the condition means 'if it's the black player's turn.'
							if((i-1)==(9-itemp)){ //this 'if' statement is used for checking if the forward movement of the piece is valid.
								i=7-itemp;
								i=i+2;
								validmove2=true;
							}
							else{
								System.out.println("Invalid Front/Backward Move.\t!!!!!\tInvalid Front/Backward Move.");
								validmove2=false;
							}
						}
						else{
							if((i+1)==(9-itemp)){
								i=7-itemp;
								i=i+2;
								validmove2=true;
							}
							else{
								System.out.println("Invalid Front/Backward Move.\t!!!!!\tInvalid Front/Backward Move.");
								validmove2=false;
							}
						}
						break;
					}
				}
				//
				
				//
				if(board1[i][j].equals(" R ")==true||board1[i][j].equals(" B ")==true||board1[i][j].equals("RK ")==true||board1[i][j].equals("BK ")==true){
					System.out.println("Invalid Move.\t\t\t!!!!!\t\t\tInvalid Move."); //this will prevent a piece from taking the position of its adjacent piece.
				}
				else if(validmove1==true&&validmove2==true){ //this condition means 'if the piece was able to move forward and sideward properly.'
					board1[icheck][jcheck]="   "; //this will erase the past position of the piece.
					board1[i][j] = ijtemp; //ijtemp can be found at the top of this 'else' statement
					omc1++;
				}
			}
		}
		return omc1;
	}
	//
	//
	//
	public int eat(String sp2,String sd2,String[][] board2,int omc2){
		//
		System.out.println("A piece has been eaten.");
		//
		board2[xcheck][ycheck]="   "; //this will erase the previous position of the piece that moved
		//
		if((xcheck-2==x)&&(ycheck-2==y)){ //if black leftward
			board2[xcheck-1][ycheck-1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
		}
		else if((xcheck-2==x)&&(ycheck+2==y)){ //if black rightward
			board2[xcheck-1][ycheck+1]="   ";
		}
		else if((xcheck+2==x)&&(ycheck-2==y)){ //if red leftward
			board2[xcheck+1][ycheck-1]="   ";
		}
		else{ //if red rightward
			board2[xcheck+1][ycheck+1]="   ";
		}
		//
		board2[x][y]=xytemp; //this will put the moved piece to the selected destination
		//
		omc2++;
		//
		return omc2;
	}
	//
	//
	//
	public boolean toeatornottoeat(String sp3,String sd3,String[][] board3,int omc3){
		//
		char[] converter4 = sp3.toCharArray(); //this part is for the selected piece
		for(ytemp=0;ytemp<8;ytemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh[ytemp]==converter4[0]){
				y=ytemp;
				break;
			}
		}
		for(xtemp=0;xtemp<8;xtemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe[xtemp]==converter4[1]){
				x=7-xtemp;
				break;
			}
		}
		//
		x=x+2;
		y=y+2;
		xytemp = board3[x][y];
		xcheck = x;
		ycheck = y;
		//
		char[] converter5 = sd3.toCharArray(); //this part is for the selected destination
		for(ytemp=0;ytemp<8;ytemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh[ytemp]==converter5[0]){
				y=ytemp;
				break;
			}
		}
		for(xtemp=0;xtemp<8;xtemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe[xtemp]==converter5[1]){
				x=7-xtemp;
				break;
			}
		}
		x=x+2;
		y=y+2;
		//
		if(omc3%2==0){//if black
			if(board3[x+1][y-1].equals(" R ")==true||board3[x+1][y+1].equals(" R ")==true||board3[x+1][y+1].equals("RK ")==true||board3[x+1][y-1].equals("RK ")==true){
				if(((xcheck-2==x)&&(ycheck-2==y))||((xcheck-2==x)&&(ycheck+2==y))){
					if(board3[x][y].equals("   ")==true){
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
		else{ //if red
			if(board3[x-1][y-1].equals(" B ")==true||board3[x-1][y+1].equals(" B ")==true||board3[x-1][y+1].equals("BK ")==true||board3[x-1][y-1].equals("BK ")==true){
				if(((xcheck+2==x)&&(ycheck-2==y))||((xcheck+2==x)&&(ycheck+2==y))){
					if(board3[x][y].equals("   ")==true){
						return true;
					}
					else{
						return false;
					}
				}
				else{
					return false;
				}
			}
			else{
				return false;
			}
		}
	}
	//
	//
	//
	public void wincheck(String[][] board8){ //this function will count the pieces of each player and determines who win when the other player has no more pieces.
		pcounter=0;
		qcounter=0;
		for(p=2;p<10;p++){
			for(q=2;q<10;q++){
				if(board8[p][q]==" B "||board8[p][q]=="BK "){
					pcounter++;
				}
				else if(board8[p][q]==" R "||board8[p][q]=="RK "){
					qcounter++;
				}
			}
		}
		if(pcounter==0){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nRed player Wins!\t\t\t\t\t\tRed player Wins!");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
			System.exit(0); //the program will exit when there already is a winner
		}
		else if(qcounter==0){
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\nBlack player Wins!\t\t\t\t\tBlack player Wins!");
			try{
				Thread.sleep(5000);
			}catch(InterruptedException e){
				Thread.currentThread().interrupt();
			}
			System.exit(0);
		}
	}
}