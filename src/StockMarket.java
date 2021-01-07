import java.io.*;
import java.math.BigDecimal;

/**
 * Stock Market is a database that simulates an actual Stock Market. 
 * You will be prompted to enter your name, date, and money. Then a menu
 * be displayed to access all the functions of the database. With the abilities of
 * being able to modify the stock values or to purchase the stocks as a user and have
 * a receipt processed after a purchase. Displaying a informative list of the stocks,
 * or to display your total stocks bought or the amount of money you have left. Plus
 * many more features!
 * 
 * @author Kalvin Kao & Jascigan Jeyakumar
 * @version 1.0 Build 9000 June 15, 2012.
 */

public class StockMarket {
  private static int stocksbought = 0;
  private static double StockPrice[] = { 571.17, 568.50, 86.59, 67.53, 28.90, 27.00 };
  private static int StockAvail[] = 
  {(int) (Math.random() * 1000 + 1), 
    (int) (Math.random() * 1000 + 1), 
    (int) (Math.random() * 1000 + 1),
    (int) (Math.random() * 1000 + 1),
    (int) (Math.random() * 1000 + 1),
    (int) (Math.random() * 1000 + 1)};
  
  public static void main(String[] args) throws IOException {
    
    InputStreamReader inStream = new InputStreamReader(System.in);
    BufferedReader stdin = new BufferedReader(inStream);
    
    String inData, name, date;
    double money = 0;
    int menu, a = 1;
    
    String CompanyName[] = { "Apple", "Google", "McDonalds", "Wal-Mart", "Microsoft", "Facebook" };
    
    
    System.out.println("Please enter your name.");
    inData = stdin.readLine();
    name = (inData);
    System.out.println(" Please enter the date.");
    inData = stdin.readLine();
    date = (inData);
    while (a != 0) {
      try {
        System.out.println(" Please enter the amount of money you have.");
        inData = stdin.readLine();
        money = Double.parseDouble(inData);
        money = round(money, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("\nHello " + name + ". Welcome to the KJ Stock Market. Today is " + date + ". You have $" + money);
        a = 0;
      } catch (NumberFormatException ex) {
        System.out.println("\n" + ex.getMessage() + " is not a numeric value.\n");
      }
    }
    
    while (1 == 1) {
      System.out.println("\nKJ Stock Market");
      System.out.println("1. Company stock prices.        2. Modify stock prices.");
      System.out.println("3. Purchase stocks.             4. Show maximum stocks purchasable by user.");
      System.out.println("5. Amount of stocks purchased.  6. Show money left.");
      System.out.print("\nYour choice is: ");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      try {
        menu = Integer.parseInt(in.readLine());
        switch (menu) {
          case 1:
            listStockPrice(CompanyName);
            break;
          case 2:
            modifyStocks(CompanyName);
            break;
          case 3:
            money = purchaseStocks(CompanyName, name, date, money);
            break;
          case 4:
            maxStocks(CompanyName, money);
            break;
          case 5:
            System.out.println("\nYou have bought a total of " + stocksbought + " stocks.");
            break;
          case 6:
            System.out.println("\nYou have $" + money);
            break;
          default:
            System.out.println("Invalid entry!");
            break;
        }
      } catch (NumberFormatException ex) {
        System.out.println(ex.getMessage() + " is not a numeric value.");
      }
    }
  }
  
  /**
   * listStockPrice - by Kalvin Kao.
   * Takes the company names, stock prices, and stocks available and
   * displays a list of all the company names, stock prices, and stocks
   * available.
   * 
   * @param CompanyName Name of the companies
   * 
   */
  
  public static void listStockPrice(String CompanyName[]) {
    System.out.println("\nCompany          Stock Prices          Stocks Available");
    System.out.println(CompanyName[0] + "\t       $" + StockPrice[0] + "\t        " + StockAvail[0]);
    System.out.println(CompanyName[1] + "\t       $" + StockPrice[1] + "\t        " + StockAvail[1]);
    System.out.println(CompanyName[2] + "\t       $" + StockPrice[2] + "\t        " + StockAvail[2]);
    System.out.println(CompanyName[3] + "\t       $" + StockPrice[3] + "\t        " + StockAvail[3]);
    System.out.println(CompanyName[4] + "\t       $" + StockPrice[4] + "\t        " + StockAvail[4]);
    System.out.println(CompanyName[5] + "\t       $" + StockPrice[5] + "\t        " + StockAvail[5]);
  }
  
  /**
   * modifyStocks - by Jascigan Jeyakumar.
   * Takes the company names and stock prices, prompts
   * the user to choose from a list of companies to change
   * the stock values.
   * 
   * @param CompanyName Name of the companies
   * 
   * 
   */
  
  public static void modifyStocks(String CompanyName[]) throws IOException {
    String inData;
    int menu, a = 1;
    
    while (a != 0) {
      System.out.println("\nPlease select a company to change the stock price.");
      System.out.println("1. " + CompanyName[0]);
      System.out.println("2. " + CompanyName[1]);
      System.out.println("3. " + CompanyName[2]);
      System.out.println("4. " + CompanyName[3]);
      System.out.println("5. " + CompanyName[4]);
      System.out.println("6. " + CompanyName[5]);
      System.out.println("7. Return to Main Menu\n");
      
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      InputStreamReader inStream = new InputStreamReader(System.in);
      BufferedReader stdin = new BufferedReader(inStream);
      
      try {
        menu = Integer.parseInt(in.readLine());
        switch (menu) {
          
          case 1:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[0]+ " for the price of $"+ inData + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              StockPrice[0] = Double.parseDouble(inData);
              StockPrice[0] = round(StockPrice[0], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 2:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[1]+ " for the price of "+ inData + ".");
            
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno2 = (in.readLine());
            if (yesORno2.equalsIgnoreCase("yes")) {
              StockPrice[1] = Double.parseDouble(inData);
              StockPrice[1] = round(StockPrice[1], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yesORno2.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 3:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[2]+ " for the price of "+ inData + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno3 = (in.readLine());
            if (yesORno3.equalsIgnoreCase("yes")) {
              StockPrice[2] = Double.parseDouble(inData);
              StockPrice[2] = round(StockPrice[2], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yesORno3.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 4:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[3]+ " for the price of "+ inData + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yes = (in.readLine());
            if (yes.equalsIgnoreCase("yes")) {
              StockPrice[3] = Double.parseDouble(inData);
              StockPrice[3] = round(StockPrice[3], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yes.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 5:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[4] + " for the price of "+ inData + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno5 = in.readLine();
            if (yesORno5.equalsIgnoreCase("yes")) {
              StockPrice[4] = Double.parseDouble(inData);
              StockPrice[4] = round(StockPrice[4], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yesORno5.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 6:
            
            System.out.println("\nPlease enter the new price: ");
            inData = stdin.readLine();
            System.out.println("\nAre you sure you want to change the stock price from "+ CompanyName[5]+ " for the price of "+ inData + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno1 = (in.readLine());
            if (yesORno1.equalsIgnoreCase("yes")) {
              StockPrice[5] = Double.parseDouble(inData);
              StockPrice[5] = round(StockPrice[5], 2, BigDecimal.ROUND_HALF_UP);
              break;
            } else if (yesORno1.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 7:
            a = 0;
            break;
          default:
            System.out.println("Invalid entry!");
            break;
        }
      } catch (NumberFormatException ex) {
        System.out.println(ex.getMessage() + " is not a numeric value.");
        
      }
    }
  }
  
/**
   * maxStocks - by Jascigan Jeyakumar.
   * Uses the money that was entered by the user
   * and divides it by the StockPrice, 
   * from the company the user had chosen
   * and returns the maximum amount of stocks
   * the user can purchase.
   * 
   * @param CompanyName Name of the companies
   * 
   * 
   */

  public static void maxStocks(String CompanyName[], double money) throws IOException {
    int menu, a = 1;
    double max;
    
    while (a != 0) {
      System.out.println("\nPlease select a company.");
      System.out.println("1. " + CompanyName[0]);
      System.out.println("2. " + CompanyName[1]);
      System.out.println("3. " + CompanyName[2]);  
      System.out.println("4. " + CompanyName[3]);  
      System.out.println("5. " + CompanyName[4]);     
      System.out.println("6. " + CompanyName[5]);    
      System.out.println("7. Return to Main Menu\n");
      
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      try {
        menu = Integer.parseInt(in.readLine());
        switch (menu) {
          case 1:
            max= money/ StockPrice[0];
            max= Math.round(max);
            System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[0]); 
            break; 
          case 2:
            max= money/ StockPrice[1];
            max= Math.round(max);
       System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[1]); 
            break;
          case 3:
            max= money/ StockPrice[2];
            max= Math.round(max);
           System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[2]);
            break;
          case 4: 
           max= money/ StockPrice[3];
           max= Math.round(max);
            System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[3]);
            break;           
           case 5:         
            max= money/ StockPrice[4];
            max= Math.round(max);
           System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[4]);
            break;        
          case 6:
          max= money/ StockPrice[5];
          max= Math.round(max);
        System.out.println("\nYou can buy " +max+ " stocks from " +CompanyName[5]);
            break;
          case 7:
            a = 0;
            break;
          default:
            System.out.println("Invalid entry!");
            break;
        }
      } catch (NumberFormatException ex) {
        System.out.println(ex.getMessage() + " is not a numeric value.");
      }
      }
    }
  
  /**
   * purchaseStocks - by Kalvin Kao. 
   * Takes the company name, user's name, the date, user's money, total
   * stocks bought, and the stock prices. Then it will allow the user to
   * select from a list of companies to buy a stock from and then print 
   * a receipt containing the user's name, the date, stock price, total stocks
   * bought, their money before the purchase and money after the purchase.
   * The program also deducts one stock from the stocks available after a purchase.
   * Purchasing a stock and displaying a receipt with your name, the date, 
   * total stocks bought, stock price, money before purchase and money after purchase.
   * 
   * @param CompanyName Name of the companies
   * @param name Name of the user
   * @param date The date
   * @param money The user's money
   * 
   * @return The list of companies, stock prices, and stocks available.
   */
  
  public static double purchaseStocks(String CompanyName[], String name, String date, double money) throws IOException {
    int menu, a = 1;
    while (a != 0) {
      System.out.println("\nPlease select a company to purchase stocks from.");
      System.out.println("1. " + CompanyName[0]);
      System.out.println("2. " + CompanyName[1]);
      System.out.println("3. " + CompanyName[2]);
      System.out.println("4. " + CompanyName[3]);
      System.out.println("5. " + CompanyName[4]);
      System.out.println("6. " + CompanyName[5]);
      System.out.println("7. Return to Main Menu\n");
      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
      try {
        menu = Integer.parseInt(in.readLine());
        switch (menu) {
          case 1:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[0]+ " for the price of "+ StockPrice[0] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            String yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[0] && StockAvail[0]>0) {
                double moneybefore = money;
                money = money - StockPrice[0];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[0]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[0]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 2:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[1]+ " for the price of "+ StockPrice[1] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[1] && StockAvail[1]>0) {
                double moneybefore = money;
                money = money - StockPrice[1];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[1]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[1]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 3:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[2]+ " for the price of "+ StockPrice[2] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[2] && StockAvail[2]>0) {
                double moneybefore = money;
                money = money - StockPrice[2];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[2]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[2]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 4:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[3]+ " for the price of "+ StockPrice[3] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[3] && StockAvail[3]>0) {
                double moneybefore = money;
                money = money - StockPrice[3];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[3]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[3]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 5:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[4]+ " for the price of "+ StockPrice[4] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[4] && StockAvail[4]>0) {
                double moneybefore = money;
                money = money - StockPrice[4];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[4]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[4]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
            
          case 6:
            
            System.out.println("\nAre you sure you want to purchase a stock from "+ CompanyName[5]+ " for the price of "+ StockPrice[5] + ".");
            System.out.println("Yes / No ?");
            new BufferedReader(new InputStreamReader(System.in));
            yesORno = (in.readLine());
            if (yesORno.equalsIgnoreCase("yes")) {
              if (money >= StockPrice[5] && StockAvail[5]>0) {
                double moneybefore = money;
                money = money - StockPrice[5];
                money = round(money, 2, BigDecimal.ROUND_HALF_UP);
                stocksbought++;
                StockAvail[5]--;
                System.out.println("\nReceipt:\nName: " + name
                                     + "\nDate: " + date
                                     + "\nTotal Stocks Bought: " + stocksbought
                                     + "\nStock Price: $" + StockPrice[5]
                                     + "\nMoney Before Purchase: $"
                                     + moneybefore + "\nMoney After Purchase: $"
                                     + money + "\n");
                break;
              } else {
                System.out.println("You do not have enough money or there are no more stocks left.");
                break;
              }
            } else if (yesORno.equalsIgnoreCase("no")) {
              break;
            } else
              System.out.print("\nPlease enter only 'Yes' or 'No'.\n");
            break;
          case 7:
            a = 0;
            break;
          default:
            System.out.println("Invalid entry!");
            break;
        }
      } catch (NumberFormatException ex) {
        System.out.println(ex.getMessage() + " is not a numeric value.");
      }
    }
    return money;
  }
  public static double round(double unrounded, int precision, int roundingMode)
  {
    BigDecimal bd = new BigDecimal(unrounded);
    BigDecimal rounded = bd.setScale(precision, roundingMode);
    return rounded.doubleValue();
  }
  
}