import java.util.*;

public class checkerDemo{
	public static void main(String[] args){
		//
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\t\t\t\tCHECKERS\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"); //for intro
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
		//
		Scanner inputC = new Scanner(System.in);
		Scanner inputSP = new Scanner(System.in);
		String choice = "asdf"; //the string choice must not be equal to null nor a nor b so that the program will work properly
		String[][] board = new String[12][12];
		int fl1,fl2,omc=0;
		String tab = "\t\t";
		String[] bor = {"Black","Red"};
		piece player = new piece();
		king playerking = new king();
		String sp,sd;
		boolean eat,kingable,kingpiece=false;
		//
		for(fl1=0;fl1<12;fl1++){ //this part will put the black and white floor on the board
			for(fl2=0;fl2<12;fl2++){
				if((fl1+fl2)%2==1){
					board[fl1][fl2]="   ";
				}
				else{
					board[fl1][fl2]="---";
				}
			}
		}
		//
		System.out.println(tab +"    a   b   c   d   e   f   g   h"); //this part is just to display what the board looks like
		for(fl1=2;fl1<10;fl1++){
			System.out.print(tab + (10-fl1) + " ");
			for(fl2=2;fl2<10;fl2++){
				System.out.print("|" + board[fl1][fl2]);
			}
			System.out.println("| " + (10-fl1) + "\n");
		}
		System.out.println(tab +"    a   b   c   d   e   f   g   h");
		//
		player.newGame(board); //this will call the function that will 'assemble' the pieces to the checker board
		//
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			Thread.currentThread().interrupt();
		}
		//
		System.out.print("\n" + tab + "\tAssembling pieces...\n" + tab);
		for(int junk1=0;junk1<35;junk1++){
			try{
				Thread.sleep(35);
			}catch(InterruptedException e){  //this part is just for the 'loading screen' effect.
				Thread.currentThread().interrupt();
			}
			System.out.print(">");
		}
		System.out.println("\n\n\n");
		//
		while(choice.equals("b")==false){ //this is the backbone of the game sequence
			
			System.out.println(tab +"    a   b   c   d   e   f   g   h"); //this part is just to display what the board looks like at the moment
			for(fl1=2;fl1<10;fl1++){
				System.out.print(tab + (10-fl1) + " ");
				for(fl2=2;fl2<10;fl2++){
				System.out.print("|" + board[fl1][fl2]);
				}
				System.out.println("| " + (10-fl1) + "\n");
			}
			System.out.println(tab +"    a   b   c   d   e   f   g   h");
			
			System.out.print("Current Player: " + bor[omc%2] + "\t\t\t\t\t" + bor[omc%2] + "\n\t\t\t[a] Move\t[b] Quit\nChoice: ");
			choice = inputC.nextLine();
			switch(choice){
				case "a":
					System.out.print("Select piece to move: ");
					sp = inputSP.nextLine();
					if(sp.length()!=2){
						System.out.println("Invalid Input. Try Again.\t\t!!!!!\t\tInvalid Input. Try Again");
						break;
					}
					System.out.print("Move to position: ");
					Scanner inputSD = new Scanner(System.in);
					sd = inputSD.nextLine();
					if(sd.length()!=2){
						System.out.println("Invalid Input. Try Again.\t\t!!!!!\t\tInvalid Input. Try Again");
						break;
					}
					kingpiece = playerking.checkpiece(sp,board,omc); //this will call the function which will determine if the selected piece is a King.
					eat = player.toeatornottoeat(sp,sd,board,omc); //this will call the function which will determine if a piece will eat or just move (only applicable for non-king pieces).
					if(kingpiece==true){
						omc = playerking.moveking(sp,sd,board,omc); //if the piece is a king, this will call the function for king movements.
					}
					else{
						if(eat==false){ //
							omc = player.move(sp,sd,board,omc); 
						}
						else{
							omc = player.eat(sp,sd,board,omc);
						} //the variable 'omc', stands for overall movement count, is used for the switching between black and red through using the mod(%) which only has two possible values: 0 or 1.
					}
					playerking.checktopromote(sd,board,omc-1); //this will call the function that will check if there are promotions for the pieces
					player.wincheck(board); //this will call the function that will check if there is already a winner
				break;
				
				case "b":
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" + bor[omc%2] + " player resigns.");
				break;
				
				default:
					System.out.println("Invalid Input. Try Again.\t\t!!!!!\t\tInvalid Input. Try Again"); //this will catch the unwanted input.
				break;
			}
		}
		//
		System.out.print("Press 'Enter' to proceed.");  //this code is used so that the whole program will not exit immediately
		String junk2 = inputC.nextLine();
	}
}