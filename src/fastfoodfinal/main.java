package fastfoodfinal;
import java.util.Iterator;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class main {
	public static String currentbranch;
      public static void main(String[] args) throws ClassNotFoundException {
        try{
      // Open the file for reading the serialized object
         FileInputStream fin = new FileInputStream("branchlist.ser");
         ObjectInputStream oit = new ObjectInputStream(fin);
         // Deserialize the object
         BranchList B = (BranchList) oit.readObject();
         // Close the ObjectInputStream
         oit.close();
         
      // Open the file for reading the serialized object
         FileInputStream fin1 = new FileInputStream("stafflist.ser");
         ObjectInputStream oit1 = new ObjectInputStream(fin1);
         // Deserialize the object
         StaffList A = (StaffList) oit1.readObject();
         // Close the ObjectInputStream
         oit1.close();
         
      // Open the file for reading the serialized object
         FileInputStream fin2 = new FileInputStream("paymentlist.ser");
         ObjectInputStream oit2 = new ObjectInputStream(fin2);
         // Deserialize the object
         PaymentMethods C = (PaymentMethods) oit2.readObject();
         // Close the ObjectInputStream
         oit2.close(); 
         
      // Open the file for reading the serialized object
         FileInputStream fin3 = new FileInputStream("ordercounter.ser");
         ObjectInputStream oit3 = new ObjectInputStream(fin3);
         // Deserialize the object
         int D = (int) oit3.readObject();
         // Close the ObjectInputStream
         oit3.close(); 
         Order.ordercounter=D;
         
         /*StaffList A = new StaffList();
         GeneralStaff kumar = new GeneralStaff("Kumar Blackmore", 'M', 32, "kumarB", "NTU", 'S', "password");
         GeneralStaff alexei = new GeneralStaff("Alexei", 'M', 25, "Alexei", "NTU", 'M', "password");
         GeneralStaff tom = new GeneralStaff("Tom Chan", 'M', 56, "TomC", "JP", 'M', "password");
         GeneralStaff alice = new GeneralStaff("Alice Ang", 'F', 27, "AlicaA", "JE", 'M', "password");
         GeneralStaff mary = new GeneralStaff("Mary Lee", 'F', 44, "MaryL", "JE", 'S', "password");
         GeneralStaff justin = new GeneralStaff("Justin Loh", 'M', 49, "JustinL", "JP", 'S', "password");
         Admin boss = new Admin("Boss", 'F', 62, "boss", "ADMIN", 'A', "password");
         
         A.addStaff(kumar);
         A.addStaff(alexei);
         A.addStaff(tom);
         A.addStaff(alice);
         A.addStaff(mary);
         A.addStaff(justin);
         A.addStaff(boss);
 
             //branch
         BranchList B = new BranchList();
         Branch ntu = new Branch("NTU");
         Branch jp = new Branch("JP");
         Branch je = new Branch("JE");
         B.addBranch(je);
         B.addBranch(jp);
         B.addBranch(ntu);
 
         Food fries = new Food("FRIES", 3.2, "side");
         Food threepc = new Food("3PC SETMEAL", 9.9, "set meal");
         Food cajun = new Food("CAJUN FISH", 5.6, "burger");
         Food cole = new Food("COLE SLAW", 2.7, "side");
         Food chicn = new Food("CHICKEN NUGGET", 6.9, "side");
         Food pepsi = new Food("PEPSI", 2.10, "drink");
 
         ntu.getBranchMenu().addItem(fries);
         ntu.getBranchMenu().addItem(threepc);
         ntu.getBranchMenu().addItem(chicn);
         jp.getBranchMenu().addItem(cajun);
         jp.getBranchMenu().addItem(chicn);
         je.getBranchMenu().addItem(cole);
         je.getBranchMenu().addItem(threepc);
         je.getBranchMenu().addItem(pepsi);
 
         PaymentMethods C = new PaymentMethods();
         C.addPaymentMethods("CARD");
         C.addPaymentMethods("PAYNOW");
         C.addPaymentMethods("CASH"); 
         int D = 1; */


		 /**
         * The main entry point for the Fastfood Management System. 
         * Handles data loading, allows interface changes, basic menu navigation, and branch selection.
         */
        Scanner scanner = new Scanner(System.in);
        int sel =0;
        int choice;
        int have = 0;

		
        while (sel != 3){
            choice = 0;
            String mainbranchs = "";
            System.out.println("\nWelcome to the Fastfood Management System\n");
			
			/**
			 * Branch Selection
			 */
			System.out.println("Branch: "+currentbranch);
            System.out.println("1:Staff Login\n2:Customer Login\n3:Exit\n");
            sel = scanner.nextInt();
            scanner.nextLine();

			if (sel == 1)
			{
				B.displayBranchList();
			}

			else if (sel == 2)
			{
 				B.displayBranchListcustomer();
			}

			if (sel != 3)
			{
            System.out.println("Type your branch:\n");
            //String mainbranchs = scanner.next();
            if (scanner.hasNext()) {
              mainbranchs = scanner.next();}
            else {
              scanner.nextLine(); // Clear the buffer (optional)
              System.err.println("Invalid input: Please enter an integer.");}
			}
			
            mainbranchs = mainbranchs.toUpperCase();
            Branch tempbranch = new Branch("Temp");
            for (Branch fbranch : B.getBranchList()) {
            	have = 0;
            	if(fbranch.getBranchName().equals(mainbranchs)){
                tempbranch = fbranch;
                currentbranch=fbranch.getBranchName();
                have=1;
                break;}}
            if(have==0 && sel!=3) {
            	System.out.println("Branch does not exist, try again");
            	continue;}
			
		    /**
			 * GeneralStaff Interface
			 */
            switch(sel){
                case 1: {
                char role = 'N';
                GeneralStaff tempstaff = new GeneralStaff("staff", 'N', 0, "staff", "NIL", 'S', "password");
                System.out.println("Please enter your LoginID:");
                String staffID = scanner.next();
                for (GeneralStaff staff : A.getStaffList()) {
                	have=0;
                	if(staff.getStaffLoginID().equals(staffID) && staff.getBranchName().equals(currentbranch)) {
                		have=1;
                		break;}
                	else if(staff.getStaffLoginID().equals(staffID) && staff.getRole()=='A') {
                		have=1;
                		break;}}
                if(have==0) {
                	 System.out.println("You are at the Wrong Branch:");
                	 continue;}
                System.out.println("Please enter your Password:");
                String pw = scanner.next();
                
                boolean loginSuccessful = false;
                for (GeneralStaff staff : A.getStaffList()) { 
                  if (staff.getStaffLoginID().equals(staffID) && staff.getpass().equals(pw)){
                      loginSuccessful = true;
                      staff = staff.checkLogin(staffID, pw, A);
                      tempstaff = staff;
                      role = tempstaff.getRole();}}

                  if (loginSuccessful == true){
                    String branchX = tempstaff.getBranchName();
                        switch(Character.toUpperCase(role)){
							/**
							 * Admin Interface
							 */
                          case 'A':{
                          System.out.println("Welcome Admin\n");
                          // enter Admin interface 
                          int asel = 0;                         
                          while (asel != 10)
                          {
                            System.out.println("What would you like to do?\n1:Add, edit, or remove Staff accounts.\n2:Display staff list (filter: branch, role, gender, age).");
                            System.out.println("3:Assign managers to each branch within the quota constraint.\n4:Promote a staff to Branch manager.\n5:Transfer a staff/manager among branches.");
                            System.out.println("6:Add/remove payment method.\n7:Open/close branch.\n8:Change Admin Password\n9:Add or Remove branch\n10:Exit\n");
                            asel = scanner.nextInt();
                            switch(asel)
                            {
                              case 1:{
                              System.out.println("1:Add, 2:Edit or 3:Remove?");
                              int selaer = scanner.nextInt();

                              	switch(selaer)
                              	{
                              	case 1:{
                              		System.out.println("Add Staff (Enter name, Gender, Age, LoginID, Branch, Role)");
                              		Admin.addStaffAccount(A);
                              		break;}

                              	case 2:{
                              		System.out.println("Type Name to edit");
                              		Admin.editStaffAccount(A);
                              		break;}

                              	case 3:{
                              		System.out.println("Type Name to remove");
                              		Admin.removeStaffAccount(A);
                              		break;}

                              	default:
                              		System.out.println("Wrong input, please try again!");
                              		break;}
                              
                              break;}
                      
                              case 2:{
                            	  System.out.println("Display By:\n1:Branch\n2:Role\n3:Gender\n4:Age\n");
                            	  int filt = scanner.nextInt();
                            	  switch(filt){
                            	  		case 1:{
                            	  			System.out.println("Type Branch");
                            	  			String filtbr = scanner.next();
                            	  			filtbr = filtbr.toUpperCase();
                            	  			A.displayfilterbranch(filtbr);
                            	  			break;}

                            	  		case 2:{
                            	  			System.out.println("Type Role");
                            	  			char filtr = scanner.next().charAt(0);
                            	  			filtr = Character.toUpperCase(filtr);
                            	  			A.displayfilterrole(filtr);
                            	  			break;}

                            	  		case 3:{
                            	  			System.out.println("Type Gender");
                            	  			char filtg = scanner.next().charAt(0);
                            	  			filtg = Character.toUpperCase(filtg);
                            	  			A.displayfiltergender(filtg);
                            	  			break;}

                            	  		case 4:{
                            	  			System.out.println("Start Age");
                            	  			int filtaa = scanner.nextInt();
                            	  			System.out.println("End Age");
                            	  			int filtab = scanner.nextInt();
                            	  			A.displayfilterage(filtaa, filtab);
                            	  			break;}

                            	  		default:{
                            	  			System.out.println("Wrong input, please try again!");
                            	  			break;}}
                            	  break;}

                              case 3:{
                            	  System.out.println("Type branch for assigning");
                            	  String abranch = scanner.next();
                            	  abranch = abranch.toUpperCase(); 
                            	  System.out.println("Type Name to assign as manager");
                            	  scanner.nextLine();
                            	  String assign = scanner.nextLine();
                            	  Admin.assignBranchManagersToBranches(B, abranch, A, assign);
                            	  break;}
                              case 4:{
                            	  System.out.println("Type branch for promoting");
                            	  String pbranch = scanner.next();
                            	  pbranch = pbranch.toUpperCase(); 
                            	  System.out.println("Type Name to promote to manager");
                            	  scanner.nextLine();
                            	  String promote = scanner.nextLine();
                            	  Admin.promoteToBranchManager(B, pbranch, A, promote);
                            	  break;}

                              case 5:{
                            	  System.out.println("1: Transfer General Staff\n2: Transfer Branch Manager");
                            	  int choice1 = scanner.nextInt();
                            	  switch(choice1){
                            	  		case 1:{
                            	  			System.out.println("Type branch for transfering to");
                            	  			String tbranch = scanner.next();
                            	  			tbranch = tbranch.toUpperCase(); 
                            	  			System.out.println("Type Name to transfer");
                            	  			scanner.nextLine();
                            	  			String transfer = scanner.nextLine();
                            	  			Admin.transferGeneralStaff(tbranch,A,transfer);
                            	  			break;}

                            	  		case 2:{
                            	  			System.out.println("Type branch for transfering to");
                            	  			String tbranch = scanner.next();
                            	  			tbranch = tbranch.toUpperCase(); 
                            	  			System.out.println("Type Name to transfer");
                            	  			scanner.nextLine();
                            	  			String transfer = scanner.nextLine();
                            	  			Admin.transferBranchManager(B, tbranch, A, transfer);                       	  			
                            	  			break;}
                            	  		default:{
                            	  			break;}}
                            	  break;}

                              case 6:{
                            	  Admin.addRemovePaymentMethod(C);
                            	  break;}

                              case 7:{
                            	  B.displayBranchList();
                            	  System.out.println("Select branch");
                            	  String opencloseb = scanner.next();
                            	  opencloseb = opencloseb.toUpperCase();
                            	  System.out.println("1: Open Branch\n2: Close Branch");
                            	  int openclose = scanner.nextInt();
                            	  switch(openclose){
                            	  		case 1:{
                            	  			Admin.OpenBranch(opencloseb,B);
                            	  			break;}

                            	  		case 2:{
                            	  			Admin.CloseBranch(opencloseb,B);
                            	  			break;}
                            	  		default:{
                            	  			break;}}
                            	  break;}

                              case 8:{
                            	  System.out.println("Type new password");
                            	  String set = scanner.next();
                            	  tempstaff.setpass(set);
                            	  break;}

                              case 9:{
								System.out.println("1:Add Branch\n2:Remove Branch");
								int arb = scanner.nextInt();
								switch(arb){
									case 1:{
										System.out.println("Type Branch Name to add");
										String ab = scanner.next().toUpperCase();

										boolean branchExists = false;
										for (Branch existingBranch : B.getBranchList()) {
											if (existingBranch.getBranchName().equals(ab)) {
												branchExists = true;
												break;
											}
										}

										if (!branchExists) {  // Add only if it doesn't exist
											Branch temp = new Branch(ab); 
											B.addBranch(temp);
											Admin.CloseBranch(ab,B);
											System.out.println("Branch " + temp.getBranchName() + " added\n");
										} else {
											System.out.println("Branch " + ab + " already exists.\n");
										}break;}

									case 2:{
										int rbhave = 0;
										System.out.println("Type Branch Name to remove");
										String rb = scanner.next().toUpperCase();

										// Using Iterator for safe removal
										Iterator<Branch> iterator = B.getBranchList().iterator();
										while (iterator.hasNext()) {
											Branch existingBranch = iterator.next();
											if (existingBranch.getBranchName().equals(rb)) {
												iterator.remove(); // Safe removal using Iterator
												System.out.println("Branch " + rb + " removed\n");
												rbhave = 1;
												break; // Can break since removal is done
											}
										}

										if (rbhave == 0) { 
											System.out.println("Branch does not exist, try again\n");
										} 
										break; }
									default:{
									break;}}
							
                              break;}
								
							  case 10:{
								break;
							  }
							 
                              
                              default:{
                            	  System.out.println("Wrong Option");
                            	  break;}}}
                                 
                        	  break;}

							/**
							* Staff Interface
							*/
                          case 'S':{
                          System.out.println("Welcome Staff\n");
                          int ssel = 0;                         
                          while (ssel != 5)
                          {   
                            System.out.println("What would you like to do?\n1:Display orders.\n2:View the details of a particular order.\n3:Process order.\n4:Change Staff Password\n5:Exit");
                            ssel = scanner.nextInt();
                            switch(ssel)
                            {
                              case 1:{
                            	  System.out.println("What orders would you like to view?\n1:New Orders.\n2:Orders awaiting collection.\n3:Completed orders\n4:Cancelled Orders");
                                  int aer = scanner.nextInt();
                            	  switch(aer){
                      	  				case 1:{
                      	  					GeneralStaff.displayneworder(B, branchX);
                      	  					break;}

                      	  				case 2:{
                      	  					GeneralStaff.displayreadyorder(B, branchX);
                      	  					break;}

                      	  				case 3:{
                      	  					GeneralStaff.displaycompletedorder(B, branchX);
                      	  					break;}
                      	  				case 4:{
                      	  					GeneralStaff.displaycancelledorder(B, branchX);
                      	  					break;}
                      	  				default:{
                      	  					break;}}
                            	  
                            	  break;}

                              case 2:{
                            	  GeneralStaff.showorderdetails(B, branchX);			
                            	  break;}

                              case 3:{
                            	  GeneralStaff.processorder(B, branchX);
                            	  break;}

                              case 4:{
                            	  System.out.println("Type new password");
                            	  String set = scanner.next();
                            	  tempstaff.setpass(set);
                            	  break;}

                              case 5:{
                            	  break;}

                              default:{
                            	  System.out.println("Wrong input, please try again!");
                            	  break;}}}
                          break;} 
								
						  /**
							 * Manager Interface
							 */
                          case 'M':{
                          System.out.println("Welcome Manager\n");
                          int msel = 0;                         
                          while (msel != 7)
                          {   
                            System.out.println("What would you like to do?\n1:Display orders.\n2:View the details of a particular order.\n3:Process order.\n4:Display the staff list in the branch supervised by the manager\n5:Add, edit, or remove menu\n6:Change Manager Password\n7:Exit\n");
                            msel = scanner.nextInt();
                            switch(msel)
                            {
                              case 1:{
                            	  System.out.println("What orders would you like to view?\n1:New Orders.\n2:Orders awaiting collection.\n3:Completed orders\n4:Cancelled Orders");
                                  int aer = scanner.nextInt();
                            	  switch(aer){
                      	  				case 1:{
                      	  					GeneralStaff.displayneworder(B, branchX);
                      	  					break;}

                      	  				case 2:{
                      	  					GeneralStaff.displayreadyorder(B, branchX);
                      	  					break;}

                      	  				case 3:{
                      	  					GeneralStaff.displaycompletedorder(B, branchX);
                      	  					break;}
                      	  				case 4:{
                      	  					GeneralStaff.displaycancelledorder(B, branchX);
                      	  					break;}
                      	  				default:{
                      	  					break;}}
                            	  
                            	  break;}

                              case 2:{
                            	  GeneralStaff.showorderdetails(B,branchX);
                            	  break;}

                              case 3:{
                            	  GeneralStaff.processorder(B,branchX);
                            	  break;}

                              case 4:{
                            	  String branchN = tempstaff.getBranchName();
                            	  A.displayfilterbranch(branchN);
                            	  break;}

                              case 5:{
                            	  System.out.println("1:Add food\n2:Edit food\n3:Remove food\n");
                            	  int aer = scanner.nextInt();
                            	  Branch nfbranch = new Branch("Temp");
                            	  Food tempfood = new Food();
                            	  for (Branch fbranch : B.getBranchList()) {
                            		  if(fbranch.getBranchName().equals(tempstaff.getBranchName())){
                            			  nfbranch = fbranch;}}

                            	  switch(aer){
                            	  		case 1:{
                            	  			BranchManager.addtoMenu(nfbranch);
                            	  			break;}

                            	  		case 2:{
                            	  			BranchManager.editMenu(nfbranch);
                            	  			break;}

                            	  		case 3:{
                            	  			BranchManager.removefromMenu(nfbranch);
                            	  			break;}
                            	  		default:{
                            	  			break;}}
                            	  break;}
                                

                              case 6:{
                            	  System.out.println("Type new password");
                            	  String set = scanner.next();
                            	  tempstaff.setpass(set);
                            	  break;}

                              case 7:{
                            	  break;}

                              default:{
                            	  System.out.println("Wrong input, please try again!");
                            	  break;}}}
                            
                        
                          break;}
      
                          default:{
                          System.out.println("Wrong input, please try again!");
                          break;}}}
                                                                                 
                                   
                 
                else{ 
                  System.out.println("Invalid Credentials");
                  break;}                 
                break;}
                
            /**
			* Customer Interface
			*/   
            case 2:{
            	for (Branch branches : B.getBranchList()) {
                	have=0;
                	if(branches.getBranchName().equals(currentbranch) && branches.getIsOpen()==false) {
                		have=1;
                		break;}}
                if(have==1) {
                	System.out.println("Branch is closed, sorry\n");
                	break;}
                	
                
            	System.out.println(currentbranch);
                System.out.println("Welcome to the "+currentbranch+" branch\n");
                Customer customer = new Customer("Alice", 'F', 25);
                Menu menu = tempbranch.getBranchMenu();
                // Displaying menu items

                while (choice !=5 && choice!=2){
                    customer.displayMenuItems(menu);
                    System.out.println("What do you want to order?\n");
                    System.out.println("1:New Order/Edit Current Order\n2:Checkout\n3:Check Order Status\n4:Collect Food\n5:Exit\n");
                    choice = scanner.nextInt();
                    scanner.nextLine();

                    switch(choice){
                    // Adding, editing, and deleting menu items
                    	case 1:{
                    		System.out.println("1:Add item\n2:Edit Order\n3:Delete item\n4:Add remarks\n");
                    		int sel2 = scanner.nextInt();
                    		switch(sel2){
                    			case 1:{
                    				customer.addItemToOrder(menu);
                    				break;}
                    			case 2:{
                    				customer.editOrderItem();
                    				break;}
                    			case 3:{
                    				customer.deleteOrderItem();
                    				break;}
                    			case 4:{
                    				System.out.println("Enter remarks: ");
                    				scanner.nextLine();
                    				String remark = scanner.nextLine();
                    				customer.GetOrder().setDescription(remark);
                    				break;}
                    			default:{
                    				System.out.println("Wrong input, please try again!");
                    				break;}}
                    	break;}

                    	case 2:{
                    		if(customer.GetOrder().calculateprice()==0.0) {
                    			System.out.println("No items in Order, unable to check out");
                    			System.out.println("Please add at least 1 item to order:");
                    			continue;}
                    		// Choosing between takeaway or dine-in
                    		customer.chooseTakeawayOrDineIn();
                    		// Checking out the cart
                    		customer.checkoutCart(tempbranch.getBranchOrders());
                    		// Making payment
                    		C.displayPaymentMethods();
                    		C.makePayment();
                    		// Printing receipt
                    		customer.printReceipt();
                    		// Collecting food
                    		//customer.collectFood();
                    		Order.ordercounter++;
                    	break;}

                    	case 3:{
                    		customer.checkorderstatus(tempbranch.getBranchOrders());
                    		break;}

                    	case 4:{
                    		customer.collectFood(tempbranch.getBranchOrders());
                    		break;}

                    	case 5:{
                    		break;}

                    	default:{ 
                    		System.out.println("Wrong Option");
                    		break;}}}}

            case 3:{
            	break;}

            default:{
            	System.out.println("Wrong Option");
            	break;}}}
          
          D=Order.ordercounter;  
          FileOutputStream fout = new FileOutputStream("branchlist.ser");
          FileOutputStream fout2 = new FileOutputStream("stafflist.ser");
          FileOutputStream fout3 = new FileOutputStream("paymentlist.ser");
          FileOutputStream fout4 = new FileOutputStream("ordercounter.ser");
          CustomObjectWriter  oot = new CustomObjectWriter (fout);
          CustomObjectWriter  oot2 = new CustomObjectWriter (fout2);
          CustomObjectWriter  oot3 = new CustomObjectWriter (fout3);
          CustomObjectWriter  oot4 = new CustomObjectWriter (fout4);
          
       oot.writeObject(B);
       // Flush and close the ObjectOutputStream //A is staff. B is branch, C is payment
       oot.flush();
       oot.close();
       
       oot2.writeObject(A);
       // Flush and close the ObjectOutputStream
       oot2.flush();
       oot2.close();
       
       oot3.writeObject(C);
       // Flush and close the ObjectOutputStream
       oot3.flush();
       oot3.close();
       
       oot4.writeObject(D);
       // Flush and close the ObjectOutputStream
       oot4.flush();
       oot4.close();
      
    

        }catch (IOException e) {
    System.err.println("An error occurred during serialization/deserialization: " + e.getMessage());}
      }
}
                
                




