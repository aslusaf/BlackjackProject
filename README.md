### BlackjackProject

#### Description:
This is a program allows the user to play a very basic version of BlackJack.

#### Information:
The card values are as follows:
- Suits are irrelevant to scoring.
- Cards 2 - 10 are worth their respective values in points.
- Face cards, with the exception of Aces, are worth 10 points.
- Aces are always worth 11 points (there are no soft Aces).
- BlackJack is a hand that equals exactly 21 points.
- A "Bust" is when a hand is worth more than 21 points.
- The dealer will only show their second card when it's the dealers turn.
- The dealer must "Hit" on hands under 17 points, and must stay on hands worth 17 or more points.
- The winner will be the hand worth the most points that is not a "Bust".
- In the event of a tie, the house always wins.
- In the event the user is dealt an initial hand that results in BlackJack, the user will automatically win (except in the event of a tie).

#### Instructions:

- Run the program.
- The user will be presented with a menu.
- Select from the options to either "Hit" or "Stay":
  1. When the user chooses to "Hit", they will draw a card.
  2. When the user chooses to "Stay", they will cease drawing any more cards and their turn ends.
- The user's turn ends when the user gets BlackJack, "Busts", or chooses to stay.
- The user will be presented a menu.
- Select from the options to either continue playing, or quit:
  1. "Yes", to continue playing.
  2. "No", to quit the application.

#### Lessons Learned:
- I had an issue with the program not executing instructions as expected given the instruction logic. When running the program through the Debugger, the program behaved as expected. However, when running it live as a Java Application it was skipping over some key data and causing unexpected issues. After some research, I identified that the issue was due to the Java Runtime Environment's (JRE) Just-In-Time (JIT) compiler. After refactoring the code to force a hard update on a variable's state, the issue was resolved.

#### Technologies Used:

Java {

- Object Oriented Design (OOD), Object Oriented Programming (OOP)
- Enums
- Custom utility class (MenuBuilder)
- Try/Catch Blocks, Error streams
- toString, hashcode, equals
- Access modifiers
- Instantiation
- Constructors / Overloaded Constructors
- Multiple classes
- Objects
- Getters/Setters
- Collections
- Unicode characters (Boxes)
- Methods
- Scanners
- Switches
- For/For-Each/Do-While Loops
- If/Else statements
- Method Overloading
- Overriding
- Interfaces
- Abstract Classes
- Abstraction
- Polymorphism
- Inheritance
- Encapsulation

}
