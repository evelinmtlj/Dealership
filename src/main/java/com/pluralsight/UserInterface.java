package com.pluralsight;

public class UserInterface {
    //call the methods

    public static void displayMainMenu(){

        String mainMenu = """
                                 *************************************
                                *     Welcome to the Main Screen   *
                                **************************************
                              1 - Find vehicles within a price range
                              2 - Find vehicles by make / model
                              3 - Find vehicles by year range
                              4 - Find vehicles by color
                              5 - Find vehicles by mileage range
                              6 - Find vehicles by type (car, truck, SUV, van)
                              7 - List ALL vehicles
                              8 - Add a vehicle
                              9 - Remove a vehicle
                              99 - Quit
                               
                """;
        while (true) {
            System.out.println(mainMenu);
            int choice =ConsoleHelper.promptForInt("Enter your choice");

            switch (choice) {
                case 1:
                    //method
                    break;
                case 2:
                    //method
                    break;
                case 3:
                    //method
                    break;
                case 4:
                    //method
                    break;
                case 5:
                    //method
                    break;
                case 6:
                    //method
                    break;
                case 7:
                    //method
                    break;
                case 8:
                    //method
                    break;
                case 9:
                    //method
                    break;
                case 99:
                    System.out.println("GOODBYE PLEASE VISIT US AGAIN ");
                   return;

                default:
                    System.out.println("Invalid number please try again: ");
                    break;
            }
        }
    }


    //methods
    private static void getPriceRequest(){

    }

    private static void getByMakeModel(){

    }

    private static void getByYearRequest(){

    }
    private static void getByColorRequest(){

    }

   private static void getByMileageRequest(){

    }

    private static void getByVehicleTypeRequest(){

    }

    private static void getAllVehiclesRequest(){
        // we list
    }

    private static void addVehicleRequest(){

    }

    private static void removeVehicleRequest(){

    }


}
