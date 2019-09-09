public class king extends piece{
	//
	private int c,d,ctemp,dtemp,ccheck,dcheck;
	private int e,f,etemp,ftemp,echeck,fcheck;
	private int m,n,mtemp,ntemp;
	private String cdtemp,eftemp,pqtemp;
	private char[] atoh1 = {'a','b','c','d','e','f','g','h'};
	private char[] otoe1 = {'1','2','3','4','5','6','7','8'};
	private boolean validmove3;
	//
	//
	//
	public int moveking(String sp7, String sd7, String[][] board7, int omc7){ //this function is for king pieces. it is in charge of the movement of the king and how it eats.
		//
		char[] converter8 = sp7.toCharArray();
		for(dtemp=0;dtemp<8;dtemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh1[dtemp]==converter8[0]){
				d=dtemp;
				break;
			}
		}
		for(ctemp=0;ctemp<8;ctemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe1[ctemp]==converter8[1]){
				c=7-ctemp;
				break;
			}
		}
		c=c+2;
		d=d+2;
		//
		cdtemp = board7[c][d];
		ccheck = c;
		dcheck = d;
		//
		char[] converter0 = sd7.toCharArray();
		for(dtemp=0;dtemp<8;dtemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh1[dtemp]==converter0[0]){
				d=dtemp;
				break;
			}
		}
		for(ctemp=0;ctemp<8;ctemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe1[ctemp]==converter0[1]){
				c=7-ctemp;
				break;
			}
		}
		//
		c=c+2;
		d=d+2;
		//
		//
		if(omc7%2==0&&board7[ccheck][dcheck]=="RK "){
			System.out.println("Invalid Move.\t\t\t!!!!!\t\t\tInvalid Move."); //to check if the player selected the wrong piece
		}
		else if(omc7%2==1&&board7[ccheck][dcheck]=="BK "){ //to check if the player selected the enemy's piece
			System.out.println("Invalid Move.\t\t\t!!!!!\t\t\tInvalid Move.");
		}
		else{
			//
			if((c+d)%2==1){
				if(c!=ccheck){
					if(d!=dcheck){
						validmove3=true;
						//
						if(omc7%2==0){
							if(c<ccheck){
								if(d>dcheck){
									if(board7[c+1][d-1].equals(" R ")==true||board7[c+1][d-1].equals("RK ")==true){ //if black rightward up
										board7[c+1][d-1]="   ";
										System.out.println("A piece has been eaten.");
									}
								}
								else{
									if(board7[c+1][d+1].equals(" R ")==true||board7[c+1][d+1].equals("RK ")==true){ //if black leftward up
										board7[c+1][d+1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
										System.out.println("A piece has been eaten.");
									}
								}
							}
							else if(c>ccheck){
								if(d>dcheck){
									if(board7[c-1][d-1].equals(" R ")==true||board7[c-1][d-1].equals("RK ")==true){ //if black rightward down
										board7[c-1][d-1]="   ";
										System.out.println("A piece has been eaten.");
									}
								}
								else{
									if(board7[c-1][d+1].equals(" R ")==true||board7[c-1][d+1].equals("RK ")==true){ //if black leftward down
										board7[c-1][d+1]="   ";
										System.out.println("A piece has been eaten.");
									}
								}
							}
						}
						else{
							if(c>ccheck){
								if(d>dcheck){
									if(board7[c-1][d-1].equals(" B ")==true||board7[c-1][d-1].equals("BK ")==true){ //if red rightward down
										board7[c-1][d-1]="   ";
										System.out.println("A piece has been eaten.");
									}
								}
								else{
									if(board7[c-1][d+1].equals(" B ")==true||board7[c-1][d+1].equals("BK ")==true){ //if red leftward down
										board7[c-1][d+1]="   ";
										System.out.println("A piece has been eaten.");
									}
								}
							}
							else if(c<ccheck){
								if(d>dcheck){
									if(board7[c+1][d-1].equals(" B ")==true||board7[c+1][d-1].equals("BK ")==true){ //if red rightward up
										board7[c+1][d-1]="   ";
										System.out.println("A piece has been eaten.");
									}
									else{
										if(board7[c+1][d+1].equals(" B ")==true||board7[c+1][d+1].equals("BK ")==true){ //if red leftward up
											board7[c+1][d+1]="   "; //these if, else if and else statements will remove the piece that was eaten from the board
											System.out.println("A piece has been eaten.");
										}
									}
								}
							}
						}
					}
				}
			}
			else{
				validmove3=false;
			}
			//
			if(board7[c][d].equals(" R ")==true||board7[c][d].equals(" B ")==true||board7[c][d].equals("RK ")==true||board7[c][d].equals("BK ")==true){
				System.out.println("Invalid Move.\t\t\t!!!!!\t\t\tInvalid Move."); //this will prevent a piece from directly taking the position of a piece.
			}
			else if(validmove3==false){
				System.out.println("Invalid Move.\t\t\t!!!!!\t\t\tInvalid Move.");
			}
			else{
				if(validmove3==true){ //this condition means 'if the piece was able to move forward and sideward properly.'
					board7[ccheck][dcheck]="   "; //this will erase the past position of the piece.
					board7[c][d] = cdtemp; //ijtemp can be found at the top of this 'else' statement
					omc7++;
				}
			}
		}
	return omc7;
	}
	//
	//
	//
	
	public void checktopromote(String sd4,String[][] board4,int omc4){
		char[] converter6 = sd4.toCharArray(); //this part is for the selected destination
		for(ftemp=0;ftemp<8;ftemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh1[ftemp]==converter6[0]){
				f=ftemp;
				break;
			}
		}
		for(etemp=0;etemp<8;etemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe1[etemp]==converter6[1]){
				e=7-etemp;
				break;
			}
		}
		e=e+2;
		f=f+2;
		//
		if(omc4%2==0){ //if black
			if(e==2){
				if(f==3||f==5||f==7||f==9){
					if(board4[e][f]==" B "){
						board4[e][f]="BK ";
						System.out.println("A piece has been promoted!");
					}
				}
			}
		}
		else{ //if red
			if(e==9){
				if(f==2||f==4||f==6||f==8){
					if(board4[e][f]==" R "){
						board4[e][f]="RK ";
						System.out.println("A piece has been promoted!");
					}
				}
			}
		}
	}
	//
	//
	//
	public boolean checkpiece(String sp5,String[][] board5,int omc8){
		//
		char[] converter3 = sp5.toCharArray(); //this part is for the selected piece
		for(ntemp=0;ntemp<8;ntemp++){ //this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array
			if(atoh1[ntemp]==converter3[0]){
				n=ntemp;
				break;
			}
		}
		for(mtemp=0;mtemp<8;mtemp++){ //also this for loop is used so that the character in the selected piece would be converted to an integer to easily access the 2D array (same as above)
			if(otoe1[mtemp]==converter3[1]){
				m=7-mtemp;
				break;
			}
		}
		//
		m=m+2;
		n=n+2;
		//
		if(omc8%2==0){
			if(board5[m][n]=="BK "){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			if(board5[m][n]=="RK "){
				return true;
			}
			else{
				return false;
			}
		}
	}
}