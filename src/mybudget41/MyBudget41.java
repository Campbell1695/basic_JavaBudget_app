/* 
 *   Big update 5.0
 * - add a whole new graphics interface
 * - add buttons, bubble slots etc.
 * - listeners and events
 * - motivational quotes shown randomly
 *   start at min: 10 max: 100
 */

/*
 *   Update 4.3 
 *  (Post-Feedback Update)
 * - add catch exceptions for the entire program
 * - allow for spacing with strings
 * - figure out whats next
 * - if there's change left over from the user's income let the user
 *   know so that they will have the option to put it into a free spend
 *   area or choose to add the remainder into one of the other accounts
 */

/*
 *   Update 4.2
 * - do something with the change
 * - make sure the user is sastified after each display
 * - decide if you want to budget for a week/bi-week or month
 */

/*
 *   Update 4.11
 * - add catch exceptions
 * - Clean up statements
 * - Display percentages
 * - Add custom method doubles
 * - Display options up/down not side by side
 * - Rearrange a few of the statements so it looks cleaner
 * - Fix the pick 1,2 or 3 statement so it works correctly
 * - Add the exceptions to catch mistakes
 */
package mybudget41;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Reef Daddy
 * Version 4.1
 * Start:      8/29/17
 * Last update 8/31/17 - 3112 
 * Lines After +0
 */

public class MyBudget41 
{
    private static final DecimalFormat money   = new DecimalFormat("$0.00");
    private static final DecimalFormat percent = new DecimalFormat("0.0%");
    private static final Scanner       kb      = new Scanner(System.in);
        
    private static int choice;                                                  // Used for all the user's choices
    
    private static int n    = 0;                                                // Counter for choices        
    private static int sure = 0;                                                // Used after choice to make sure    
    
    private static double bi;                                                   // Converts totalCash to bi-weekly income
    private static double totalCash;
                                                                                // Used in method Needs, Wants and Savings
    private static double pTNeeds;                                              // Percent and add trackers
    private static double aTNeeds;                                              // for the Needs, Wants, and Savings
    private static double pTWants;                                                 
    private static double aTWants;              
    private static double pTSavings;            
    private static double aTSavings;            
                                                                                // used in method Fixed Expenses
    private static double pTFE;                                                 // Percent and add trackers 
    private static double aTFE;                                                 // for Fixed Expenses
    private static double pTM;                                                  
    private static double aTM;                                                  
                                                                                // used in method custom
    // Add custom method doubles
    
    private static String base;                                                 // Week, Bi-Week or Month
    private static String bases;                                                // Weekly, Bi-Weekly or Monthly
    private static String rule;                                                 // Which rule the user picked
    
    public static void main(String[] args) 
    {
        System.out.println("Hello welcome to MyBudget4.1!!\nThis program will "
                           + "help you with setting up your budget to help "
                           + "prevent you from falling into debt and/or living "
                           + "paycheck to paycheck.");
        System.out.println("You will set your budget based on percentages and/or"
                           + " the dollar amounts that you choose.\nExamples will "
                           + "be given to help smooth this process.\n");                
      do{
                        
         try{                                
                System.out.println("Do you want to set up your budget based on "
                                   + "Weekly, Bi-Weekly or Monthly bases?");
                System.out.println("(1)Weekly\n(2)Bi-Weekly\n(3)Monthly");
                choice = kb.nextInt();
                if(choice > 3|| choice < 0)
                {
                    System.out.println("\nINVALID OPTION!\n");
                kb.nextLine();
                }
            }        
            catch (InputMismatchException x) 
            {
                System.out.println("\nINVALID OPTION!\n");
                kb.nextLine();
                n++;
                
            }            
            if  (choice == 1)
            {
                do
                {
                    // only appears when you enter and option that isn't a number
                    if(n>0)
                    {
                        System.out.println("\nPlease enter 1, 2 or 3 to continue!"
                                           + "\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice+" "
                                           + "(Weekly) do you wish to continue "
                                           + "\n(1)Yes\n(2)Choose another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up"
                                       + " on a Weekly bases");
                    base  = "week";
                    bases = "weekly";
                    
                    System.out.println("How much did you make this "+base);
                    totalCash = kb.nextDouble();
                    bi        = totalCash*2.0;
                }if (sure == 2)
                {
                    choice = 4;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }if (choice == 2)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice+" "
                                           + "(Bi-Weekly) do you wish to continue "
                                           + "\n(1)Yes\n(2)Choose Another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up "
                                       + "on a Bi-Weekly bases");
                    base  = "bi-week";
                    bases = "bi-weekly";
                    
                    System.out.println("How much did you make this "+base);
                    totalCash = kb.nextDouble();
                    bi        = totalCash;                    
                }if (sure == 2)
                {
                    choice = 4;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }
            
            }if (choice == 3)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                   
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice+
                                           " (Monthly) do you wish to continue?"
                                           + "\n(1)Yes\n(2)Choose Another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);               
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up "
                                       + "on a Monthly bases");
                    base  = "month";
                    bases = "monthly";
                    
                    System.out.println("How much did you make this "+base+"?");
                    totalCash = kb.nextDouble();
                    bi        = totalCash*0.5;
                }if (sure == 2)
                {
                    choice = 4;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }
            }            
        }while(choice > 3 || choice < 1);               
        if       ((bi > 0)   &&(bi <= 500))
        {
            System.out.println("\nNo Problem! Anything's possible with a little "
                               + "finese.\n");
        }else if ((bi > 500) &&(bi <= 1000))
        {
            System.out.println("\nOk! Lets work with what we got.\n");
        }else if ((bi > 1000)&&(bi <= 4000))
        {
            System.out.println("\nCool! We have some room to work here.\n");
        }else if ((bi > 4000)&&(bi <= 8000))
        {
            System.out.println("\nGreat! Lets get to saving.\n");
        }else
        {
            System.out.println("\nAwesome! This should be easy.\n");
        }                
     do{         
            if(n>0)
            {
                System.out.println("Please enter 1, 2 or 3 ONLY to continue!\n\n");
                n=0;
            }
            try
            {
                System.out.println("This program offers three differnt ways to set up a "
                           + "budget.");
                System.out.println("Which way do you wish to set up your budget?");
                System.out.println("(1). Needs, Wants and Savings rule");
                System.out.println("(2). Fixed expenses rule ");
                System.out.println("(3). Custom rule");
                choice = kb.nextInt();                
            }        
            catch (InputMismatchException x) 
            {
                System.out.println("Invalid option!\n\n");
                kb.nextLine();
                n++;
            }
            if  (choice == 1)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice
                                           + ".\n(Needs, Wants and Savings rule) "
                                           + "\nWith this rule you will seperate "
                                           + "your expenses into three catgories."
                                           + "\nDo you wish to continue?"
                                           + "\n(1)Yes\n(2)Choose another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("Invalid option!\n\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up "
                                       + "using the Needs, Wants and Savings rule");
                    rule = "Needs, Wants and Savings rule";
                    nws();
                }if (sure == 2)
                {
                    choice = 4;
                    n       = 0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }if  (choice == 2)
            {
                do
                {
                    // only appears when you enter and option that isn't a number
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice
                                           + ".\n(Fixed expenses rule)"
                                           + "\nWith this rule you set asside "
                                           + "money for your fixed exenses. "
                                           + "\nFixed expenses are expenses that "
                                           + "stay the same every bill cycle. "
                                           + "\nThe remaining expenses will be "
                                           + "set after."
                                           + "\nDo you wish to continue?"
                                           + "\n(1)Yes\n(2)Choose another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nInvalid option!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up "
                                       + "using the Fixed expenses rule");
                    rule = "Fixed income rule";
                    fixed();
                }if (sure == 2)
                {
                    choice = 4;
                    n       = 0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }if  (choice == 3)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice
                                           + ".\n(Custom rule)/nWith this rule "
                                           + "you will assign dollar amounts"
                                           + " and/or percentages to your liking."
                                           + "\nDo you wish to continue?"
                                           + "\n(1)Continue\n(2)Choose another\n"
                                           + "(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set your budget up "
                                       + "using the Custom rule");
                    rule = "Custom rule";
                    custom();
                }if (sure == 2)
                {
                    choice = 4;
                    n       = 0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }            
        }while(choice > 3 || choice < 1);
    }
    private static void nws()
    {
        double mT = totalCash;                                                  // Money tracker
 
        int nC = 0;                                                             // Need counter 
        int wC = 0;                                                             // Wants counter 
        int sC = 0;                                                             // Savings counter 
        int needs;                  
        int wants;                 
        int savings;                  
              
        System.out.println("You've chosen to set up your budget under a "+bases+
                           " bases.\nDuring this "+base+" you've made "
                           +money.format(totalCash)+".");
        System.out.println("Now lets begin setting up our budget.\nHow many "
                           + "needs do you have in your budget?"
                           + "\nExamples of needs are bills like rent and "
                           + "mortgage.\nAs well as groceries, gas or "
                           + "transportion money.");
        needs = kb.nextInt();
        
        String [] needsNames     = new String [needs];
        Double [] needsAmounts   = new Double [needs];
        
        System.out.println("Now lets list the names and amounts for each expense.");
        if (needs > 0)
        {              
            for (int i = 0; i <needsNames.length; i++)
            {             
                kb.nextLine();
                System.out.println("What is the name of need number "+(i+1)+ ":");
                needsNames[i] = kb.nextLine();

               
                
                System.out.println("What is the amount assciated with this "
                                   + "expense?");
                needsAmounts[i] = kb.nextDouble();
                
                mT = mT-needsAmounts[i];
                aTNeeds = aTNeeds+needsAmounts[i];
                pTNeeds = (aTNeeds/totalCash);
                System.out.println(money.format(mT)+" Remaining.");
                System.out.println(money.format(aTNeeds)+" Used.");
            }           
        }
        
        System.out.println("How many wants?\n"
                           +"Examples of wants are things that aren't nesscary "
                           +"to live, like shopping or weekend money.");
        wants = kb.nextInt();
        
        String [] wantsNames     = new String [wants];
        Double [] wantsAmounts   = new Double [wants];
        
        System.out.println("Now lets list the names and amounts for each wants.");
                                  
        if (wants > 0)
        {          
            for (int i = 0; i <wantsNames.length; i++)
            {
                System.out.println("What is the name of want number " +(i+1)+ ":");
                wantsNames[i] = kb.next();                 
                System.out.println("What is the amount assciated with this want?");
                wantsAmounts[i] = kb.nextDouble();
                
                mT = mT-wantsAmounts[i];
                aTWants = aTWants+wantsAmounts[i];
                pTWants = (aTWants/totalCash);
                System.out.println(money.format(mT)+" Remaining.");
                System.out.println(money.format(aTWants)+" Used.");
            }
        }
        
        System.out.println("Savings?" 
                           +"Examples of savings are anything that you plan to "
                           +"save for short to long term, a new car or a "
                           +"trip somewhere.");
        savings = kb.nextInt();
        
        String [] savingsNames   = new String [savings];
        Double [] savingsAmounts = new Double [savings];
        
        System.out.println("Now lets list the names and amounts for each saving.");
                         
        
        if (savings > 0)
        {          
            for (int i = 0; i <savingsNames.length; i++)
            {
                System.out.println("What is the name of savings number "+(i+1)+ ":");
                savingsNames[i] = kb.next();                 
                System.out.println("What is the amount assciated with this saving?");
                savingsAmounts[i] = kb.nextDouble();
                mT = mT-savingsAmounts[i];
                
                aTSavings = aTSavings+savingsAmounts[i];
                pTSavings = (aTSavings/totalCash);
                System.out.println(money.format(mT)+" Remaining");
                System.out.println(money.format(aTSavings)+" Used.");
                
            }
        }
        
        System.out.println("Name:\t\t\tAmount:\t\t\tType:");
        
        if (needs > 0)
        {
          do{
                System.out.println(needsNames[nC]+ "\t\t\t" 
                                   +money.format(needsAmounts[nC])+"\t\t\tBills");
                nC++;
            }while(needs > nC);
        }
        if (wants > 0)
        {
          do{
                System.out.println(wantsNames[wC]+ "\t\t\t" 
                             +money.format(wantsAmounts[wC])+ "\t\t\tExpenses");
                wC++;
            }while(wants > wC);
        }
        if (savings > 0)
        {
          do{
                System.out.println(savingsNames[sC]+ "\t\t\t" 
                               +money.format(savingsAmounts[sC])+ "\t\t\tSavings");
                sC++;
            }while(savings > sC);
        }
        
        
        System.out.println("Needs percent equals "  +percent.format(pTNeeds));
        System.out.println("Wants percent equals "  +percent.format(pTWants));
        System.out.println("Savings percent equals "+percent.format(pTSavings));
    }
    private static void fixed()
    {
        double mT  = totalCash;                                                 // money tracker
        int    fEC = 0;                                                         // fix expense counter
        int    mEC = 0;                                                         // miscellouns counter
        int fixedExpense;                     
        int miscellaneousExpense;                      
        
        System.out.println("You've chosen to set up your budget under a "+bases+
                           " bases.\nDuring this "+base+" you've made "
                           +money.format(totalCash)+".");
        System.out.println("Now lets begin setting up your budget.\nHow many "
                           + "fixed expenses do you want in your budget?"
                           + "\nExamples of fixed expenses are bills that "
                           + "happen periodically and stay the same amount. ");
        fixedExpense = kb.nextInt();
        
        String [] fixedExpenseNames     = new String [fixedExpense];
        Double [] fixedExpenseAmounts   = new Double [fixedExpense];
        
        System.out.println("Now lets list the names and amounts for each fixed "
                           +"expense.");
       
        if (fixedExpense > 0)
        {      
            for (int i = 0; i <fixedExpenseNames.length; i++)
            {                
                System.out.println("What is the name of expense number " +(i+1)+ ":");
                fixedExpenseNames[i] = kb.next();                
                System.out.println("What is the amount assciated with this expense?");
                fixedExpenseAmounts[i] = kb.nextDouble();  
                
                mT = mT-fixedExpenseAmounts[i];
                aTFE = aTFE+fixedExpenseAmounts[i];
                pTFE = (aTFE/totalCash);
                System.out.println(money.format(mT)+" Remaining");
                System.out.println(aTFE);
            }   
        }
        System.out.println("Name:\t\t\tAmount:");
        
        if (fixedExpense > 0)
        {
          do{
                System.out.println(fixedExpenseNames[fEC]+ "\t\t\t" 
                                   +money.format(fixedExpenseAmounts[fEC]));
                fEC++;
            }while(fixedExpense > fEC);
        }
        
        System.out.println("You have "+money.format(mT)+" left to budget.\n "
                           + "Your Fixed Expenses used "+percent.format(pTFE)
                           + " of your total income.");
        System.out.println("Do you want to finish the rest of your budget using"
                           + " dollar amounts or by using percentages?");
     
      do{
            if(n>0)
            {
                System.out.println("Please enter 1, 2 or 3 ONLY to continue!\n\n");
                n=0;
            }            
         try{                                
                System.out.println("(1)Dollar Amounts (2)Percentages");
                choice = kb.nextInt();                
            }        
            catch (InputMismatchException x) 
            {
                System.out.println("\nINVALID OPTION!\n");
                kb.nextLine();
                n++;
            }            
            if  (choice == 1)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice+" "
                                           + "(Dollar Amounts) do you wish to "
                                           + "continue?\n(1)Yes\n(2)Choose another"
                                           + "\n(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nInvalid option!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen to set up the rest of "
                                       + "your budget using dollar amounts.");
                    // new method here
                    System.out.println("You have "+money.format(mT)+" left in your "
                                       + "budget to work with");
                    System.out.println("How many miscellaneous expenses do you "
                                       + "have remaining?\nThis is anything "
                                       + "else that you would have to spend "
                                       + "money on.");
                    miscellaneousExpense = kb.nextInt();
        
                    String [] miscellaneousNames   = 
                                            new String [miscellaneousExpense];
                    
                    Double [] miscellaneousAmounts = 
                                            new Double [miscellaneousExpense];
        
                    System.out.println("Now lets list the names and amounts for"
                                       +" each miscellaneous expense.");
       
                    if (miscellaneousExpense > 0)
                    {            
                        for (int i = 0; i <miscellaneousNames.length; i++)
                        {                
                            System.out.println("What is the name of "
                                               + "miscellaneous expense number " 
                                               +(i+1)+ ":");
                            miscellaneousNames[i] = kb.next();
                            
                            System.out.println("What is the amount assciated "
                                               + "with this miscellaneous "
                                               + "expense?");
                
                            miscellaneousAmounts[i] = kb.nextDouble();                
                            mT = mT - miscellaneousAmounts[i];
                            aTM = aTM+miscellaneousAmounts[i];
                            pTM = (aTM/totalCash);
                            System.out.println(money.format(mT)+" Remaining");
                            System.out.println(aTM);
                        }   
                    }
        
                    System.out.println("Name:\t\t\tAmount:\t\t\tType:");
          
                    if (fixedExpense > 0)
                    {
                      do{
                            System.out.println(fixedExpenseNames[fEC]+ "\t\t\t" 
                                               +money.format(fixedExpenseAmounts[fEC])
                                               +"\t\t\tFixed Expense");
                            fEC++;
                        }while(fixedExpense > fEC);
                    }
                    if (miscellaneousExpense > 0)
                    {
                      do{
                            System.out.println(miscellaneousNames[mEC]+ "\t\t\t" 
                                               +money.format(miscellaneousAmounts[mEC])
                                               +"\t\t\t Miscellaneous Expense");
                            mEC++;
                        }while(miscellaneousExpense > mEC);
                    }
                }if (sure == 2)
                {
                    choice = 4;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }if (choice == 2)
            {
                do
                {
                    // only appears when you enter and option that isn't a number
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen option "+choice
                                           +"(Percentages) do you wish to "
                                           +"continue?\n(1)Yes\n(2)Choose another"
                                           +"\n(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nInvalid option!\n");
                        kb.nextLine();
                        n++;
                    }
                }while (sure > 3 || sure < 1);
                
                if  (sure == 1)
                { 
                    System.out.println("\nYou Have chosen to set up the rest of "
                                       + "your budget using Percentages.");
                    System.out.println("You have "+money.format(mT)+" left in "
                                       + "your budget to work with.");
                    System.out.println("How many miscellaneous expenses do you "
                                       + "have remaining?\nThis is anything "
                                       + "else that you would have to spend "
                                       + "money on.");
                    miscellaneousExpense = kb.nextInt();
                    
                    double remainingCash = mT;
                                                           
                    String [] miscellaneousNames     = 
                                              new String [miscellaneousExpense];
                    
                    Double [] miscellaneousAmounts   = 
                                              new Double [miscellaneousExpense];
                    
                    Double [] miscellaneousPercents  = 
                                              new Double [miscellaneousExpense];

                    System.out.println("Now lets list the names and percents for"
                                       +" each miscellaneous expense.");
                    
                    if (miscellaneousExpense > 0)
                    {            
                        for (int i = 0; i <miscellaneousNames.length; i++)
                        {
                            double decimal;
                
                            System.out.println("What is the name of miscellaneous"
                                               +" expense number " +(i+1)+ ":");
                            miscellaneousNames[i] = kb.next();
                
                            System.out.println("What is the percent assciated "
                                               +"with this miscellaneous expense?");
                            miscellaneousPercents[i] = kb.nextDouble();
                
                            decimal = miscellaneousPercents[i]/100;
                            miscellaneousAmounts[i] = decimal*remainingCash;
               
                            mT = mT-miscellaneousAmounts[i];
                            aTM = aTM+miscellaneousAmounts[i];
                            pTM = (aTM/totalCash);
                            System.out.println(money.format(mT)+" Remaining");
                            System.out.println(aTM);
                        }   
                    }
                     
                    System.out.println("Name:\t\t\tAmount:\t\t\tType:");
                    fEC = 0;
        
                    if (fixedExpense > 0)
                    {
                      do{
                            System.out.println(fixedExpenseNames[fEC]+ "\t\t\t" 
                                               +money.format(fixedExpenseAmounts[fEC])
                                               +"\t\t\tFixed Expense");
                            fEC++;
                        }while(fixedExpense > fEC);
                    }
                    if (miscellaneousExpense > 0)
                    {
                      do{
                            System.out.println(miscellaneousNames[miscellaneousExpense]
                                               + "\t\t\t" 
                                               +money.format(miscellaneousAmounts[miscellaneousExpense])
                                               +"\t\t\t"
                                               +"Miscellaneous Expense");
                            mEC++;
                        }while(miscellaneousExpense > mEC);
                    }
                }if (sure == 2)
                {
                    choice = 4;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }
            }
        }while(choice > 2 || choice < 1);
    }
    private static void custom()
    {
        double mT = totalCash;
        
        String name1, name2, name3, name4, name5;
        int n1C,n2C,n3C,n4C,n5C;
        int dn1C = 0,dn2C = 0,dn3C = 0,dn4C = 0,dn5C = 0;
        
        System.out.println("You've chosen to set up your budget under a "+bases
                           +" bases.\nDuring this "+base+" you've made "
                           +money.format(totalCash));
      do{
            if(n>0)
            {
                System.out.println("Please enter 1, 2 or 3 ONLY to continue!\n\n");
                n=0;
            }            
         try{                                
                System.out.println("How many categories do you want to separate "
                                   + "your budget in max 5: min 1:");
                System.out.println("(1) (2) (3) (4) (5)");
                choice = kb.nextInt();                
            }        
            catch (InputMismatchException x) 
            {
                System.out.println("\nInvalid option!\n");
                kb.nextLine();
                n++;
            }            
            if  (choice == 1)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen "+choice
                                           +" category Do you wish to continue"
                                           +"\n(1)Yes\n(2)Choose another\n"
                                           +"(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen one category to set "
                                       + "up your budget");
             
                  do{
                        if(n>0)
                        {
                            System.out.println("Please enter 1, 2 or 3 ONLY to "
                                               + "continue!\n\n");
                            n=0;
                        }            
                     try{
                            System.out.println("Do you want to set up your "
                                               +"budget using percents or dollar"
                                               +" amounts?\n(1)Dollar Amounts\n"
                                               +"(2)Percentages");
                            choice = kb.nextInt();                
                        }        
                        catch (InputMismatchException x) 
                        {
                            System.out.println("Invalid option!\n\n");
                            kb.nextLine();
                            n++;
                        }            
                        if  (choice == 1)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Dollar Amounts)"
                                                       +" Do you wish to continue?"
                                                       +" \n(1)Yes\n(2)Choose "
                                                       +" another\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }                    
                            }while (sure > 3 || sure < 1);                
                            if  (sure == 1)
                            {
                                System.out.println("You Have chosen to set up "
                                                   +"the rest of your budget "
                                                   +"using dollar amounts.\n"
                                                   + "What is the name of your "
                                                   + "category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name1+".");
                                n1C = kb.nextInt();
        
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name1+".");
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1+".");
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray1[i]+"?");
                
                                    doubleArray1[i] = kb.nextDouble();                
                                    mT = mT - doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining.");
                                    System.out.println(aTM);
                                }   
                                }
        
                                System.out.println("Name:\t\t\tAmount:\t\t\t"
                                                   +"Category:");
        
                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+ "\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                    dn1C++;
                                }while(n1C > dn1C);
                                }      
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }                
                        }if (choice == 2)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Percentages) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Chose another"
                                                       +"\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }
                            }while (sure > 3 || sure < 1);
                
                            if  (sure == 1)
                            { 
                                System.out.println("What is the name of your "
                                                   +"category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the "
                                                   + "category "+name1);
                                n1C = kb.nextInt();
        
                                double remainingCash = mT;
                    
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                Double [] percentArray1  = new Double [n1C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name1+".");
                    
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {
                                    double decimal;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray1[i] = kb.nextDouble();
                
                                    decimal = percentArray1[i]/100;
                                    doubleArray1[i] = decimal*remainingCash;
               
                                    mT = mT-doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                     
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");

                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+"\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                   
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }
                        }
                    }while(choice > 2 || choice < 1);
                }if (sure == 2)
                {
                    choice = 6;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }                
            }if  (choice == 2)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           +"\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen "+choice
                                           +" categories Do you wish to continue"
                                           +"\n(1)Yes\t(2)Chose another\t"
                                           +"(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen two categories to set "
                                       +"up your budget.");
                    System.out.println("Do you want to set up your budget using "
                                       + "percents or dollar amounts?");
                  do{
                        if(n>0)
                        {
                            System.out.println("Please enter 1, 2 or 3 ONLY to "
                                               + "continue!\n\n");
                            n=0;
                        }            
                     try{                                
                            System.out.println("(1)Dollar Amounts\n(2)Percentages");
                            choice = kb.nextInt();                
                        }        
                        catch (InputMismatchException x) 
                        {
                            System.out.println("\nInvalid option!\n");
                            kb.nextLine();
                            n++;
                        }            
                        if  (choice == 1)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Dollar Amounts) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose "
                                                       +"another\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }                    
                            }while (sure > 3 || sure < 1);                
                            if  (sure == 1)
                            {
                                System.out.println("\nYou Have chosen to set up "
                                                   +"your budget using dollar "
                                                   +"amounts.");
                    
                                System.out.println("What is the name of your 1st"
                                                   + "category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name1+".");
                                n1C = kb.nextInt();
                                
                                System.out.println("What is the name of your 2nd"
                                                   +"category?");
                                name2 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name2+".");
                                n2C = kb.nextInt();
        
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name1+".");
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray1[i]+".");
                
                                    doubleArray1[i] = kb.nextDouble();                
                                    mT = mT - doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name2+".");
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray2[i]);
                                    doubleArray2[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
        
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");
        
                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+ "\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+ "\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }                
                        }if (choice == 2)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Percentages) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose another"
                                                       +"\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }
                            }while (sure > 3 || sure < 1);
                
                            if  (sure == 1)
                            { 
                                System.out.println("What is the name of your 1st"
                                                   +"category.");
                                name1 = kb.next();
                                
                                System.out.println("What is the name of your 2nd"
                                                   +"category.");
                                name2 = kb.next();
                    
                                System.out.println("How many expenses are in the "
                                                   +"category "+name1+".");
                                n1C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   +"category "+name2+".");
                                n2C = kb.nextInt();
        
                                double remainingCash = mT;
                    
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                Double [] percentArray1  = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                Double [] percentArray2  = new Double [n2C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name1+".");
                    
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {
                                    double decimal;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray1[i] = kb.nextDouble();
                
                                    decimal = percentArray1[i]/100;
                                    doubleArray1[i] = decimal*remainingCash;
               
                                    mT = mT-doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense in "
                                                   + "category"+name2);
                                
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {
                                    double decimal2;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name2);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray2[i] = kb.nextDouble();
                
                                    decimal2 = percentArray2[i]/100;
                                    doubleArray2[i] = decimal2*remainingCash;
               
                                    mT = mT-doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                     
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");

                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+"\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1); 
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+"\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);    
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }
                        }
                    }while(choice > 2 || choice < 1);
                }if (sure == 2)
                {
                    choice = 6;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }
            }if(choice == 3)
            {
               do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("You have chosen "+choice
                                           +" categories Do you wish to continue"
                                           +"?\n(1)Yes\n(2)Choose another\n"
                                           +"(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen three categories to set "
                                       +"up your budget.");
                    System.out.println("Do you want to set up your budget using "
                                       +"percents or dollar amounts?");
                  do{
                        if(n>0)
                        {
                            System.out.println("Please enter 1, 2 or 3 ONLY to "
                                               + "continue!\n\n");
                            n=0;
                        }            
                     try{                                
                            System.out.println("(1)Dollar Amounts\n(2)Percentages");
                            choice = kb.nextInt();                
                        }        
                        catch (InputMismatchException x) 
                        {
                            System.out.println("\nInvalid option!\n");
                            kb.nextLine();
                            n++;
                        }            
                        if  (choice == 1)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Dollar Amounts) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose "
                                                       +"another\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }                    
                            }while (sure > 3 || sure < 1);                
                            if  (sure == 1)
                            {
                                System.out.println("\nYou Have chosen to set up "
                                                   +"your budget using dollar "
                                                   +"amounts.");
                    
                                System.out.println("What is the name of your 1st"
                                                   +"category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name1);
                                n1C = kb.nextInt();
                                
                                System.out.println("What is the name of your 2nd"
                                                   +"category?");
                                name2 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name2);
                                n2C = kb.nextInt();
                                
                                System.out.println("What is the name of your 3rd"
                                                   +"category?");
                                name3 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name3);
                                n3C = kb.nextInt();
        
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
        
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense "
                                                   + "in category"+name1);
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray1[i]);
                
                                    doubleArray1[i] = kb.nextDouble();                
                                    mT = mT - doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name2+".");
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray2[i]);
                                    doubleArray2[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense "
                                                   + "in category"+name3+".");
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray3[i]);
                                    doubleArray3[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
        
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");
        
                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+ "\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+ "\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+ "\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }                
                        }if (choice == 2)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Percentages) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose another"
                                                       +"\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }
                            }while (sure > 3 || sure < 1);
                
                            if  (sure == 1)
                            { 
                                System.out.println("What is the name of your 1st"
                                                   + "category?");
                                name1 = kb.next();
                                
                                System.out.println("What is the name of your 2nd"
                                                   + "category?");
                                name2 = kb.next();
                                
                                System.out.println("What is the name of your 3rd"
                                                   + "category?");
                                name3 = kb.next();
                    
                                System.out.println("How many expenses are in the "
                                                   + "category "+name1);
                                n1C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name2);
                                n2C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name3);
                                n3C = kb.nextInt();
        
                                double remainingCash = mT;
                    
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                Double [] percentArray1  = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                Double [] percentArray2  = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
                                Double [] percentArray3  = new Double [n3C];
        
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense in "
                                                   + "category"+name1);
                    
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {
                                    double decimal;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray1[i] = kb.nextDouble();
                
                                    decimal = percentArray1[i]/100;
                                    doubleArray1[i] = decimal*remainingCash;
               
                                    mT = mT-doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name2+".");
                                
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {
                                    double decimal2;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name2);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray2[i] = kb.nextDouble();
                
                                    decimal2 = percentArray2[i]/100;
                                    doubleArray2[i] = decimal2*remainingCash;
               
                                    mT = mT-doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name3+".");
                                
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {
                                    double decimal3;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray3[i] = kb.nextDouble();
                
                                    decimal3 = percentArray3[i]/100;
                                    doubleArray3[i] = decimal3*remainingCash;
               
                                    mT = mT-doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                     
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");

                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+"\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                   
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+"\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                   
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+"\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                   
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }
                        }
                    }while(choice > 2 || choice < 1);
                }if (sure == 2)
                {
                    choice = 6;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                } 
            }if(choice == 4)
            {
               do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen "+choice
                                           +" categories. Do you wish to continue"
                                           +"?\n(1)Yes\n(2)Choose another\n"
                                           +"(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("\nYou Have chosen four categories to set "
                                       + "up your budget.");
                    System.out.println("Do you want to set up your budget using "
                                       + "percents or dollar amounts?");
                  do{
                        if(n>0)
                        {
                            System.out.println("Please enter 1, 2 or 3 ONLY to "
                                               + "continue!\n\n");
                            n=0;
                        }            
                     try{                                
                            System.out.println("(1)Dollar Amounts\n(2)Percentages");
                            choice = kb.nextInt();                
                        }        
                        catch (InputMismatchException x) 
                        {
                            System.out.println("\nInvalid option!\n");
                            kb.nextLine();
                            n++;
                        }            
                        if  (choice == 1)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("You have chosen option "
                                                       +choice+" (Dollar Amounts) "
                                                       +"do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose "
                                                       +"another\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }                    
                            }while (sure > 3 || sure < 1);                
                            if  (sure == 1)
                            {
                                System.out.println("You Have chosen to set up "
                                                   +"your budget using dollar "
                                                   +"amounts.");
                    
                                System.out.println("What is the name of your 1st"
                                                   +"category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name1+"?");
                                n1C = kb.nextInt();
                                
                                System.out.println("What is the name of your 2nd"
                                                   +"category?");
                                name2 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name2+"?");
                                n2C = kb.nextInt();
                                
                                System.out.println("What is the name of your 3rd"
                                                   +"category?");
                                name3 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name3+"?");
                                n3C = kb.nextInt();
                                
                                System.out.println("What is the name of your 4th"
                                                   + "category?");
                                name4 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name4+"?");
                                n4C = kb.nextInt();
        
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
                                String [] stringArray4   = new String [n4C];
                                Double [] doubleArray4   = new Double [n4C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name1+".");
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray1[i]);
                
                                    doubleArray1[i] = kb.nextDouble();                
                                    mT = mT - doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name2+".");
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray2[i]);
                                    doubleArray2[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense "
                                                   + "in category"+name3+".");
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray3[i]);
                                    doubleArray3[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense "
                                                   + "in category"+name4+".");
                                if (n4C > 0)
                                {            
                                for (int i = 0; i <stringArray4.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name4);
                                    stringArray4[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray4[i]);
                                    doubleArray4[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray4[i];
                                    aTM = aTM+doubleArray4[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
        
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");
        
                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+ "\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+ "\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+ "\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                                if (n4C > 0)
                                {
                              do{
                                    System.out.println(stringArray4[dn4C]+ "\t\t\t" 
                                                       +money.format(doubleArray4[dn4C])
                                                       +"\t\t\t"+name4);
                                    dn4C++;
                                }while(n4C > dn4C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }                
                        }if (choice == 2)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Percentages) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose another"
                                                       +"\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }
                            }while (sure > 3 || sure < 1);
                
                            if  (sure == 1)
                            { 
                                System.out.println("What is the name of your 1st"
                                                   +"category?");
                                name1 = kb.next();
                                
                                System.out.println("What is the name of your 2nd"
                                                   +"category?");
                                name2 = kb.next();
                                
                                System.out.println("What is the name of your 3rd"
                                                   +"category?");
                                name3 = kb.next();
                                
                                System.out.println("What is the name of your 4th"
                                                   +"category?");
                                name4 = kb.next();
                    
                                System.out.println("How many expenses are in the "
                                                   + "category "+name1+".");
                                n1C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name2+".");
                                n2C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name3+".");
                                n3C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name4+".");
                                n4C = kb.nextInt();
        
                                double remainingCash = mT;
                    
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                Double [] percentArray1  = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                Double [] percentArray2  = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
                                Double [] percentArray3  = new Double [n3C];
                                String [] stringArray4   = new String [n4C];
                                Double [] doubleArray4   = new Double [n4C];
                                Double [] percentArray4  = new Double [n4C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name1+".");
                    
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {
                                    double decimal;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray1[i] = kb.nextDouble();
                
                                    decimal = percentArray1[i]/100;
                                    doubleArray1[i] = decimal*remainingCash;
               
                                    mT = mT-doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense in "
                                                   + "category"+name2+".");
                                
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {
                                    double decimal2;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name2);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray2[i] = kb.nextDouble();
                
                                    decimal2 = percentArray2[i]/100;
                                    doubleArray2[i] = decimal2*remainingCash;
               
                                    mT = mT-doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense in "
                                                   + "category"+name3);
                                
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {
                                    double decimal3;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray3[i] = kb.nextDouble();
                
                                    decimal3 = percentArray3[i]/100;
                                    doubleArray3[i] = decimal3*remainingCash;
               
                                    mT = mT-doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                if (n4C > 0)
                                {            
                                for (int i = 0; i <stringArray4.length; i++)
                                {
                                    double decimal4;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name4);
                                    stringArray4[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray4[i] = kb.nextDouble();
                
                                    decimal4 = percentArray4[i]/100;
                                    doubleArray4[i] = decimal4*remainingCash;
               
                                    mT = mT-doubleArray4[i];
                                    aTM = aTM+doubleArray4[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                     
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");

                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+"\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                   
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+"\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                   
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+"\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                   
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                                if (n4C > 0)
                                {
                              do{
                                    System.out.println(stringArray4[dn4C]+"\t\t\t" 
                                                       +money.format(doubleArray4[dn4C])
                                                       +"\t\t\t"+name4);
                                   
                                    dn4C++;
                                }while(n4C > dn4C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }
                        }
                    }while(choice > 2 || choice < 1);
                }if (sure == 2)
                {
                    choice = 6;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                } 
            }if(choice == 5)
            {
                do
                {
                    if(n>0)
                    {
                        System.out.println("Please enter 1, 2 or 3 to continue!"
                                           + "\n\n");
                        n=0;
                    }                    
                    try
                    {
                        System.out.println("\nYou have chosen "+choice
                                           +" categories Do you wish to continue"
                                           +"\n(1)Yes\n(2)Choose another\n"
                                           +"(3)End");
                        sure = kb.nextInt();
                        n++;
                    }catch (InputMismatchException x) 
                    {
                        System.out.println("\nINVALID OPTION!\n");
                        kb.nextLine();
                        n++;
                    }                    
                }while (sure > 3 || sure < 1);                
                if  (sure == 1)
                {
                    System.out.println("You Have chosen five categories to set "
                                       +"up your budget.");
                    System.out.println("Do you want to set up your budget using "
                                       +"percents or dollar amounts?");
                  do{
                        if(n>0)
                        {
                            System.out.println("Please enter 1, 2 or 3 ONLY to "
                                               + "continue!\n\n");
                            n=0;
                        }            
                     try{                                
                            System.out.println("(1)Dollar Amounts\n(2)Percentages");
                            choice = kb.nextInt();                
                        }        
                        catch (InputMismatchException x) 
                        {
                            System.out.println("\nInvalid option!\n");
                            kb.nextLine();
                            n++;
                        }            
                        if  (choice == 1)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       +"to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Dollar Amounts) "
                                                       +"do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose "
                                                       +"another\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }                    
                            }while (sure > 3 || sure < 1);                
                            if  (sure == 1)
                            {
                                System.out.println("You have chosen to set up "
                                                   +"your budget using dollar "
                                                   +"amounts.");
                    
                                System.out.println("What is the name of your 1st"
                                                   + "category?");
                                name1 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name1+"?");
                                n1C = kb.nextInt();
                                
                                System.out.println("What is the name of your 2nd"
                                                   + "category?");
                                name2 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name2+"?");
                                n2C = kb.nextInt();
                                
                                System.out.println("What is the name of your 3rd"
                                                   + "category?");
                                name3 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name3+"?");
                                n3C = kb.nextInt();
                                
                                System.out.println("What is the name of your 4th"
                                                   + "category?");
                                name4 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name4+"?");
                                n4C = kb.nextInt();
                                
                                System.out.println("What is the name of your 5th"
                                                   + "category?");
                                name5 = kb.next();
                    
                                System.out.println("How many expenses are in the"
                                                   +" category "+name5+"?");
                                n5C = kb.nextInt();
        
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
                                String [] stringArray4   = new String [n4C];
                                Double [] doubleArray4   = new Double [n4C];
                                String [] stringArray5   = new String [n5C];
                                Double [] doubleArray5   = new Double [n5C];
        
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name1+".");
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray1[i]);
                
                                    doubleArray1[i] = kb.nextDouble();                
                                    mT = mT - doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name2);
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray2[i]);
                                    doubleArray2[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name3+".");
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       +"assciated with "
                                                       +stringArray3[i]);
                                    doubleArray3[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name4+".");
                                if (n4C > 0)
                                {            
                                for (int i = 0; i <stringArray4.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name4);
                                    stringArray4[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray4[i]);
                                    doubleArray4[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray4[i];
                                    aTM = aTM+doubleArray4[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense "
                                                   +"in category"+name5+".");
                                if (n5C > 0)
                                {            
                                for (int i = 0; i <stringArray5.length; i++)
                                {                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name5);
                                    stringArray5[i] = kb.next();
                
                                    System.out.println("What is the amount "
                                                       + "assciated with "
                                                       +stringArray5[i]);
                                    doubleArray5[i] = kb.nextDouble();
                                    
                                    mT = mT - doubleArray5[i];
                                    aTM = aTM+doubleArray5[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
        
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");
        
                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+ "\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+ "\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+ "\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                                if (n4C > 0)
                                {
                              do{
                                    System.out.println(stringArray4[dn4C]+ "\t\t\t" 
                                                       +money.format(doubleArray4[dn4C])
                                                       +"\t\t\t"+name4);
                                    dn4C++;
                                }while(n4C > dn4C);
                                }
                                
                                if (n5C > 0)
                                {
                              do{
                                    System.out.println(stringArray5[dn5C]+ "\t\t\t" 
                                                       +money.format(doubleArray5[dn5C])
                                                       +"\t\t\t"+name5);
                                    dn5C++;
                                }while(n5C > dn5C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }                
                        }if (choice == 2)
                        {
                            do
                            {
                                if(n>0)
                                {
                                    System.out.println("Please enter 1, 2 or 3 "
                                                       + "to continue!\n\n");
                                    n=0;
                                }                    
                                try
                                {
                                    System.out.println("\nYou have chosen option "
                                                       +choice+" (Percentages) "
                                                       +"Do you wish to continue?"
                                                       +"\n(1)Yes\n(2)Choose another"
                                                       +"\n(3)End");
                                    sure = kb.nextInt();
                                    n++;
                                }catch (InputMismatchException x) 
                                {
                                    System.out.println("\nInvalid option!\n");
                                    kb.nextLine();
                                    n++;
                                }
                            }while (sure > 3 || sure < 1);
                
                            if  (sure == 1)
                            { 
                                System.out.println("What is the name of your 1st"
                                                   + "category?");
                                name1 = kb.next();
                                
                                System.out.println("What is the name of your 2nd"
                                                   + "category?");
                                name2 = kb.next();
                                
                                System.out.println("What is the name of your 3rd"
                                                   + "category?");
                                name3 = kb.next();
                                
                                System.out.println("What is the name of your 4th"
                                                   + "category?");
                                name4 = kb.next();
                                
                                System.out.println("What is the name of your 5th"
                                                   + "category?");
                                name5 = kb.next();
                    
                                System.out.println("How many expenses are in the "
                                                   + "category "+name1+"?");
                                n1C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name2+"?");
                                n2C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name3+"?");
                                n3C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name4+"?");
                                n4C = kb.nextInt();
                                
                                System.out.println("How many expenses are in the "
                                                   + "category "+name5+"?");
                                n5C = kb.nextInt();
        
                                double remainingCash = mT;
                    
                                String [] stringArray1   = new String [n1C];
                                Double [] doubleArray1   = new Double [n1C];
                                Double [] percentArray1  = new Double [n1C];
                                String [] stringArray2   = new String [n2C];
                                Double [] doubleArray2   = new Double [n2C];
                                Double [] percentArray2  = new Double [n2C];
                                String [] stringArray3   = new String [n3C];
                                Double [] doubleArray3   = new Double [n3C];
                                Double [] percentArray3  = new Double [n3C];
                                String [] stringArray4   = new String [n4C];
                                Double [] doubleArray4   = new Double [n4C];
                                Double [] percentArray4  = new Double [n4C];
                                String [] stringArray5   = new String [n5C];
                                Double [] doubleArray5   = new Double [n5C];
                                Double [] percentArray5  = new Double [n5C];
        
                                System.out.println("Now lets list the names and "
                                                   + "amounts for each expense in "
                                                   + "category"+name1+".");
                    
                                if (n1C > 0)
                                {            
                                for (int i = 0; i <stringArray1.length; i++)
                                {
                                    double decimal;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name1);
                                    stringArray1[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray1[i] = kb.nextDouble();
                
                                    decimal = percentArray1[i]/100;
                                    doubleArray1[i] = decimal*remainingCash;
               
                                    mT = mT-doubleArray1[i];
                                    aTM = aTM+doubleArray1[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name2);
                                
                                if (n2C > 0)
                                {            
                                for (int i = 0; i <stringArray2.length; i++)
                                {
                                    double decimal2;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name2);
                                    stringArray2[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray2[i] = kb.nextDouble();
                
                                    decimal2 = percentArray2[i]/100;
                                    doubleArray2[i] = decimal2*remainingCash;
               
                                    mT = mT-doubleArray2[i];
                                    aTM = aTM+doubleArray2[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name3);
                                
                                if (n3C > 0)
                                {            
                                for (int i = 0; i <stringArray3.length; i++)
                                {
                                    double decimal3;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name3);
                                    stringArray3[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray3[i] = kb.nextDouble();
                
                                    decimal3 = percentArray3[i]/100;
                                    doubleArray3[i] = decimal3*remainingCash;
               
                                    mT = mT-doubleArray3[i];
                                    aTM = aTM+doubleArray3[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name4+".");
                    
                                if (n4C > 0)
                                {            
                                for (int i = 0; i <stringArray4.length; i++)
                                {
                                    double decimal4;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name4);
                                    stringArray4[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray4[i] = kb.nextDouble();
                
                                    decimal4 = percentArray4[i]/100;
                                    doubleArray4[i] = decimal4*remainingCash;
               
                                    mT = mT-doubleArray4[i];
                                    aTM = aTM+doubleArray4[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                                
                                System.out.println("Now lets list the names and "
                                                   +"amounts for each expense in "
                                                   +"category"+name5+".");
                                
                                if (n5C > 0)
                                {            
                                for (int i = 0; i <stringArray5.length; i++)
                                {
                                    double decimal5;
                
                                    System.out.println("What is the name of "
                                                       +"expense number "+(i+1)
                                                       +": in category"+name5);
                                    stringArray5[i] = kb.next();
                
                                    System.out.println("What is the percent "
                                                       +"assciated with this "
                                                       +"expense?");
                                    percentArray5[i] = kb.nextDouble();
                
                                    decimal5 = percentArray5[i]/100;
                                    doubleArray5[i] = decimal5*remainingCash;
               
                                    mT = mT-doubleArray5[i];
                                    aTM = aTM+doubleArray5[i];
                                    pTM = (aTM/totalCash);
                                    System.out.println(money.format(mT)
                                                       +" Remaining");
                                    System.out.println(aTM);
                                }   
                                }
                     
                                System.out.println("Name:\t\t\tAmount:\t\t\tCategory:");

                                if (n1C > 0)
                                {
                              do{
                                    System.out.println(stringArray1[dn1C]+"\t\t\t" 
                                                       +money.format(doubleArray1[dn1C])
                                                       +"\t\t\t"+name1);
                                   
                                    dn1C++;
                                }while(n1C > dn1C);
                                }
                                
                                if (n2C > 0)
                                {
                              do{
                                    System.out.println(stringArray2[dn2C]+"\t\t\t" 
                                                       +money.format(doubleArray2[dn2C])
                                                       +"\t\t\t"+name2);
                                   
                                    dn2C++;
                                }while(n2C > dn2C);
                                }
                                
                                if (n3C > 0)
                                {
                              do{
                                    System.out.println(stringArray3[dn3C]+"\t\t\t" 
                                                       +money.format(doubleArray3[dn3C])
                                                       +"\t\t\t"+name3);
                                   
                                    dn3C++;
                                }while(n3C > dn3C);
                                }
                                
                                if (n4C > 0)
                                {
                              do{
                                    System.out.println(stringArray4[dn4C]+"\t\t\t" 
                                                       +money.format(doubleArray4[dn4C])
                                                       +"\t\t\t"+name4);
                                   
                                    dn4C++;
                                }while(n4C > dn4C);
                                }
                                
                                if (n5C > 0)
                                {
                              do{
                                    System.out.println(stringArray5[dn5C]+"\t\t\t" 
                                                       +money.format(doubleArray5[dn5C])
                                                       +"\t\t\t"+name5);
                                   
                                    dn5C++;
                                }while(n5C > dn5C);
                                }
                                
                            }if (sure == 2)
                            {
                                choice = 6;
                                n=0;
                                System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                            }if  (sure == 3)
                            {
                                System.out.println("\n\nPROGRAM END!!!\n\n");
                                System.exit(0);
                            }
                        }
                    }while(choice > 2 || choice < 1);
                }if (sure == 2)
                {
                    choice = 6;
                    n=0;
                    System.out.println("\n\nOK LETS TRY AGAIN\n\n");
                }if  (sure == 3)
                {
                    System.out.println("\n\nPROGRAM END!!!\n\n");
                    System.exit(0);
                }
            }                
        }while(choice > 5 || choice < 1);
    }
}
