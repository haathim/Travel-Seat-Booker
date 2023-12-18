import scala.io.StdIn.readInt

object seating{

 val noOfRows = 10
 val noOfColoumns = 5
 val noOfTrips = 5
 var bookedSeats = Array.fill(noOfRows, noOfColoumns, noOfTrips)(true);

//Display the available seats for a given journey
 def showAvaiableSeatsForTrip(tripStart: Int, tripEnd: Int): Unit = {
    var seatingAvailability = seatAvailability(tripStart, tripEnd)
    println()
    println("CURRENTLY AVAILABBLE SEATS FOR REQUESTED TRIP..")
    println("(1 --> Available), (0 --> Not Available)...")
    println()
    printf("       ")
    for(j<-0 until noOfColoumns){
        printf("%4c%d", 'C', j)
        
    }
    print("\n")
    println("---------------------------------------------------")
    for(i<-0 until noOfRows){
        printf("%4c%d |", 'R', i)
        for(j<-0 until noOfColoumns){
            if(seatingAvailability(i)(j)){
                printf("%5d", 1)
            }
            
            else{
                printf("%5d", 0)
            }
        }
        println()
    }
 }
 
 //calculates the available seats for a given journey
 def seatAvailability(tripStart: Int, tripEnd: Int): Array[Array[Boolean]] = {
    var seats = Array.fill(noOfRows, noOfColoumns)(true)
    for(i<-0 until noOfRows; j<-0 until noOfColoumns){
        for(k<-tripStart until tripEnd){
            seats(i)(j) = seats(i)(j) && bookedSeats(i)(j)(k-)
        }
        
    }

    return seats
 }

 //books available seat for a given journey
 def bookSeats(tripStart: Int, tripEnd: Int, seatRow: Int, seatColoumn: Int): Boolean = {
    for(i<-tripStart until tripEnd){
        bookedSeats(seatRow)(seatColoumn)(i) = false
    }
     return true
 }
 
 //checks if a given seat is valid and is avaiable for booking
 def isValidSeat(tripStart: Int, tripEnd: Int, seatRow: Int, seatColoumn: Int): Boolean = {
    if(seatRow >= noOfRows || seatColoumn >= noOfColoumns) {
        return false
    }
    var seatingAvailability = seatAvailability(tripStart, tripEnd)
    if(seatingAvailability(seatRow)(seatColoumn)) return true else return false     
 }

//Main program
 def main(args: Array[String]): Unit = {

    println("Welcome to Airline Resevation System!")
    println("This is our trip routes with stops,")
    println("0. Colombo --> 1. Jaffna --> 2. Kandy --> 3. Trincomalee --> 4.Galle --> 5. Puttalam")
    
    println("Please input your Start and Destination when requested in order to view available seats.....")

    var mainLoopFlag = true
    while(mainLoopFlag){
        println("Please input Start No as shown above....")
        var source = readInt()
        println("Please input Destination No as shown above...")
        var destination = readInt()
        var flag = true
        while(flag){
            if(source >= 0 && source <= noOfTrips && destination >= 0 && destination <= noOfTrips && destination > source){
                flag = false
            }
            else{
                println("Please enter valid Source and destination....") 

                println("Please input Start No as shown above....")
                source = readInt()
                println("Please input Destination No as shown above...")
                destination = readInt()
            }
        }
        showAvaiableSeatsForTrip(source, destination)

        println("Please Enter no of seats to book...")
        val noOfSeats = readInt()
        
        var i = 0
        while(i < noOfSeats){
            println("Please take Rows and Coloumns as starting from 0...")
            println("Please enter Row number of seat..")
            val rowNumber = readInt()
            println("Please enter Cloumn number of seat..")
            val colNumber = readInt()
            if(isValidSeat(source, destination, rowNumber, colNumber)){
                bookSeats(source, destination, rowNumber, colNumber)
                i = i + 1
            }
            else{
                println("Error! you have input unavaibale seat number. Booking not successfull!, Enter again")
            }
            showAvaiableSeatsForTrip(source, destination)
        }
        println("To Continue booking press 1, to exit press 0.")
        var input = readInt()
        if (input != 1) mainLoopFlag = false
    }
   
 }   
}
