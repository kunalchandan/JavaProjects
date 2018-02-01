package plan;

import java.util.Scanner;
class GamePlan{
	static String choice;
	static Scanner input = new Scanner (System.in);
	public static void main(String [] args){


		// Welcome message display
		System.out.println("Welcome to Yasaman's game plan!");

		System.out.printf("\n%s\n%s\n%s\n%s\n\n","You will be entering a new world now. One where your decision may either save you or cost you your life.",
				"You will be given two options. Choose wiseley, and remember that answering bonus questions might save your life or help you fine your way.", 
				"The game will begin now! If you ever feel like you dont wanna play anymore, enter '!' and I will get you out",
				"When choices are given to you, enter the letter of the desicion that best suits you (E.g. A, B, C). You may only enter one letter"
				);

		//Allows the user to choose a username
		System.out.print("Enter a name for your character (Choose wisely, you will not be able to change this afterwards): ");
		final String NAME = input.nextLine();
		//Displays the username and begins the game
		System.out.println("Username : " + NAME);
		System.out.println("________________________________________________Let's begin__________________________________________________________");
		senario1();



	}
	//Senarion which begins the story
	public static void senario1(){
		System.out.println(" ------------------------------------------------------------");
		System.out.println("|   It is the fist day of school, you are now in grade 12    |");
		System.out.println("|   It is up to you to skip the first day because it will    |");
		System.out.println("|   be all introductions or go and go to school just to      |");
		System.out.println("|   see the friends you have't seen the whole summer.        |");
		System.out.println(" ------------------------------------------------------------"); 
		System.out.printf("\n%s\n%s\n%s\n","Would you : " , "A. Stay home" , "B. Go to school");
		choice = input.nextLine();

		if (choice.equalsIgnoreCase("A")){
			senario1A();
		}else if(choice.equalsIgnoreCase("B")){
			senario1B();
		}else{
			System.out.println("That is not one of the options, please enter from the choices given");
		}


	}
	//Senario where the user stays home
	public static void senario1A(){
		System.out.println(" -----------------------------------------------------------------");
		System.out.println("|   It is now 10 o'clock, and after the great sleep you had       |");
		System.out.println("|   you are glad that you stayed home today instead.              |");
		System.out.println("|   As you walk around the kitchen, you find yourself getting     |");
		System.out.println("|   more and more hungry, and you can find anything that pleases  |");
		System.out.println("|   your tatste buds, so you decide to buy food.                  |");
		System.out.println(" -----------------------------------------------------------------");

		System.out.printf("\n%s\n%s\n%s\n\n","Would you : " , "A. Order delivery." , "B. Go out to eat.");
		choice = input.nextLine();

		if (choice.equalsIgnoreCase("A")){
			senario1AA();
		}else if(choice.equalsIgnoreCase("B")){
			senario1AB();
		}else{
			System.out.println("That is not one of the options, please enter from the choices given");
		}
	}
	//Senario where the user chooses to go to school
	public static void senario1B(){
		System.out.println(" -----------------------------------------------------------------------------------------------------------------");
		System.out.println("|   You managed to escape! If you had stayed home, due to many unfortunate events your life would have ended...   |");
		System.out.println(" -----------------------------------------------------------------------------------------------------------------");

	}
	//Senario where the player gets murdered by the delivery guy
	public static void senario1AA(){
		System.out.println(" ------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|    The delivery driver was having an off day. A very off day... and they happened to get your order wrong order.        |");
		System.out.println("|    Before you even get to finish your sentence, the delivery guy's eyes turn ice cold and he pulls out his shotgun.     |");
		System.out.println("|    You never thought something could hurt so much, as you laid on the cold snow that was built up at your front door.   |");
		System.out.println("|    Your blood started to pull under you and eventually drip down the stair case as you lost fell into nothingness.      |");
		System.out.println("|                                                         YOU DIED!                                                       |");
		System.out.println(" -------------------------------------------------------------------------------------------------------------------------");
	}
	//Senario where the user goes out to eat
	public static void senario1AB(){
		System.out.println(" ------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|    You head to the plaza to go and find something to eat. You suddenly became brave and decided to go to the         |");
		System.out.println("|    resturaung with the cute server. As you take a sit, he starts to make his way towards you, and your heart         |");
		System.out.println("|    starts to beat reallt fast. His voice sounds like honey but his breath has a hint of alcohol. Since he is a bit   |");
		System.out.println("|    older, you don't think it is a big deal, you were just surprised since he is at work right now. He takes your     |");
		System.out.println("|    oder, and after you ask for the bill he asks for your number and if you'd wanna grab a coffee after his shift     |");
		System.out.println("|    is done. As you stare into his beautiful blue eyes, you are wondering what to do.                                 |");
		System.out.println(" ------------------------------------------------------------------------------------------------------------------------");

		System.out.printf("\n%s\n%s\n%s\n\n","Would you : " , "A. Agree to meet him." , "B. Make and excuse and leave.");
		choice = input.nextLine();

		if (choice.equalsIgnoreCase("A")){
			senario1ABA();
		}else if(choice.equalsIgnoreCase("B")){
			senario1ABB();
		}else{
			System.out.println("That is not one of the options, please enter from the choices given");
		}
	}
	public static void senario1ABB(){
		System.out.println(" -------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("|    Days after, you are watching the news about a guy that has raped and kill four girls around your age. You are shocked      |");
		System.out.println("|    when you see the culprits face and name. It is the good looking server from the other day, and you have now realized       |");
		System.out.println("|    that as embarassing it was to lie about a girly emergancy that forced you to leave fast, it was the right thing to do.     |");
		System.out.println("|    You sink into your mother's arm, and she hugs you back knowing something must have gone terribly wrong, but she stays      |");
		System.out.println("|    Without saying a word, just being grateful that you are not one of them.                                                   |");
		System.out.println("|                                                          YOU SURVIVED!                                                        |");
		System.out.println(" -------------------------------------------------------------------------------------------------------------------------------");
	}
	public static void senario1ABA(){
	}
}