#Algorithms

This part of the katas will be used to go over data structures and algorithms. Most of these topics, I haven't touched since in school. However; I think it would be a good opportunity to mix them into my code katas. 

##SOLID
1. S: Single Responsibility Principle
	A class should have only a single responsibility (i.e. only one potential change in the software's specification should be able to affect the specification of the class)

2. O: Open/Closed Principle
	Software entities should be open for extension, but closed for modification

3. L: Liskov Substitution Principle
	Objects in a program should be replaceable with instances of their subtypes without altering the correctness of the program (Design by Contract)

4. I: Interface Segregation Principle
	Many client-specific interfaces are better than one general all-purpose interface

5. Dependency Inversion Principle
	One should Depend upon Abstractions. Do not depend upon concretions. 

##Possible Questions
1.    Given a price rules of parking and start time and end time of parking. Calculate the price (Below is the table of price rule) Come up with data structure you can store these price rules PriceRule

	Price Rules:
	On Weekday      On Weekend
	Hours   Price       Hours       Price
	0 – 2      $5           0 – 2          $8
	2 – 6      $10         2 – 6         $13
	6 – 12    $15         6 – 12        $18
	12 – 24  $20        12 – 24      $25
	Architecture for a system which shows the parking spaces available near customers’ location in a mobile app.