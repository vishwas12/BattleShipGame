Running the application

1) Execute the main method the GameSimulator class.
2) Follow the steps by providing the input for game to start.
3) Sample input (Input expected to in the given format)
 	5 E
	2
	Q 1 1 A1 B2
	P 2 1 D4 C3
	A1 B2 B2 B3
	A1 B2 B3 A1 D1 E1 D4 D4 D5 D5
	
--------------------------------------------------------------------------------------------------------

Assumptions

The only assumption I have taken is that the user will always provide the correct input
	
---------------------------------------------------------------------------------------------------------
	
Components

Game object will be responsible for creating the Players
Each Player will be having its board which will the having Ship.
Each Player will also be having the list of Weapons
Ship will consist of Cells which will decide whether the ship has been hit or not.

----------------------------------------------------------------------------------------------------------

 
Design
Ship Factory and Weapon Factory has been used to get the correct type of Ship/Weapon.In future if any other type of Ship or Weapon is introduced this can be handled by the factory.
The Players are communicating with each other by the help of Observer Pattern.Here I have made both the players as Subject and the Game object has subscribed to the player.Any activity performed by the player will get updated to the game where we can decide the control flow

------------------------------------------------------------------------------------------------------------

Test Case 1:

Please enter all the details
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 B3
A1 B2 B3 A1 D1 E1 D4 D4 D5 D5

	Player-1 fires a missile with target A1 which got miss.
	Player-2 fires a missile with target A1 which got hit.
	Player-2 fires a missile with target B2 which got miss.
	Player-1 fires a missile with target B2 which got hit.
	Player-1 fires a missile with target B2 which got miss.
	Player-2 fires a missile with target B3 which got miss.
	Player-1 fires a missile with target B3 which got miss.
	Player-2 fires a missile with target A1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target D1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target E1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target D4 which got hit.
	Player-2 fires a missile with target D4 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target D5 which got hit.
	Player-2 has won the game
	
-------------------------------------------------------------------------------------------------
	
Test Case 2:

Please enter all the details
5 E
2
Q 1 1 A1 B2
P 2 1 D4 C3
A1 B2 B2 B3
A1 B2 B3 A1 D1 E1 D4 D4 A1 A1

	Player-1 fires a missile with target A1 which got miss.
	Player-2 fires a missile with target A1 which got hit.
	Player-2 fires a missile with target B2 which got miss.
	Player-1 fires a missile with target B2 which got hit.
	Player-1 fires a missile with target B2 which got miss.
	Player-2 fires a missile with target B3 which got miss.
	Player-1 fires a missile with target B3 which got miss.
	Player-2 fires a missile with target A1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target D1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target E1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target D4 which got hit.
	Player-2 fires a missile with target D4 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target A1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 fires a missile with target A1 which got miss.
	Player-1 has no more missiles left to launch
	Player-2 has no more missiles left to launch
	There is peace now