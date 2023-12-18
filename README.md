# Travel-Seat-Booker

## Problem Statement

The challenge is to create a seat booking system for an airplane that travels through multiple destinations, including Colombo, Jaffna, Kandy, Trincomalee, Galle, and Puttalam. The journey follows the specific order:

- Colombo → Jaffna → Kandy → Trincomalee → Galle → Puttalam

The airplane has a total of 50 seats, arranged in 10 rows and 5 columns per trip, and there are 5 trips in total. The goal is to manage seat bookings for all trips and provide customers with an interface to reserve available seats.

## Solution Overview

To address this problem in Scala, we implemented a seat booking solution using a multidimensional array of dimension 3. The 3D array is conceptualized as an array of 2D arrays, where each 2D array represents the seating grid for a specific trip.

The dimensions of the array are defined as follows:
- Rows (i): 10
- Columns (j): 5
- Trips (k): 5

Here, 'i' and 'j' represent the number of rows and columns, respectively, and 'k' represents the number of trips undertaken.

## Code Implementation

The main code file for this solution is `seating.scala`. To build and execute the code, follow these steps:


## Usage
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/haathim/Travel-Seat-Booker/tree/main
   cd Travel-Seat-Booker
   
2. **Build and Run:**
    ```bash
    scalac seating.scala
    scala Seating
    
