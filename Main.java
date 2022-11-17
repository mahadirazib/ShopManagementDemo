
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("\nStarting application...\n");
        
        Scanner inp = new Scanner(System.in);
        Shop shop1 = new Shop();
        
        boolean check = true;
        
        while(check){
            System.out.println("\n1: About product. \n2: About Staff. \n3: About Customer. \n4: Billing. \n5: Exit \n");
            System.out.print("Chose an Option: ");
            
            int option = inp.nextInt();
            
            if(option == 1){
                shop1.aboutProduct();
            }else if(option == 2){
                shop1.aboutStaff();
            }else if(option == 3){
                shop1.aboutCustomer();
            }else if(option == 4){
                shop1.billing();
            }else{
                check = false;
            }
        }
        
        System.out.print("\n Start again \n");
        
    }
}



class Shop{
    
    int countProduct = 0;
    product[] products;

    int countStaff = 0;
    staff[] staffs;

    int countCustomer = 0;
    customer[] customers;
    
    public Shop(){
        this.products = new product[1000];
        this.staffs = new staff[100];
        this.customers = new customer[1000];
    }
    
    Scanner inp = new Scanner(System.in);
    int selectProduct;
    
    void aboutProduct(){
        System.out.println("1: Add new product. \n2: Display All. \n3: Set an Offer. \n4: Remove Offer. \n5: Change Price.");
        System.out.print("Choose an option: ");
        
        int opt = inp.nextInt();

        switch(opt){
            case 1:
                
                System.out.print("Enter Name: ");
                String a =  inp.next();
                
                System.out.print("Enter Price: ");
                float b =  inp.nextFloat();
                
                System.out.print("Enter Inset Date: ");
                String c =  inp.next();
                
                System.out.print("Enter Expire Date: ");
                String d =  inp.next();
                
                this.products[this.countProduct] = new product(a, b, c, d);
                System.out.println("New product added. Name: " + products[this.countProduct].name + " and product id is " + (countProduct + 1));
                this.countProduct++;
                
                break;
                
            case 2:
                if(countProduct<1){
                    System.out.print("No product to show\n");
                }
                for(int i=0; i<countProduct; i++){
                    System.out.println(i+1 + ": " + this.products[i].name + "-> " + this.products[i].price);
                }
                break;
                
            case 3:
                System.out.print("Product id: ");
                this.selectProduct = inp.nextInt();
                if((selectProduct-1)>=0 && (selectProduct-1)<this.countProduct){
                    System.out.print("What pascentage: ");
                    int percent = inp.nextInt();
                    this.products[selectProduct-1].setOffer(percent);
                    System.out.println("Discount added to " + selectProduct + " (" + products[selectProduct-1].name + ")" );
                }else{
                    System.out.println("Invalid input.");
                }
                
                break;
            
            case 4:
                System.out.print("Product id: ");
                this.selectProduct = inp.nextInt();
                if((selectProduct-1)>=0 && (selectProduct-1)<this.countProduct){
                    this.products[selectProduct-1].removeOffer();
                    System.out.println("Discount removed from " + selectProduct + " (" + products[selectProduct-1].name + ")" );
                }else{
                    System.out.println("Invalid input.");
                }
                break;
                
            case 5:
                System.out.print("Which Product: ");
                this.selectProduct = inp.nextInt();
                if((selectProduct-1)>=0 && (selectProduct-1)<this.countProduct){
                    System.out.print("Insert new price: ");
                    int price = inp.nextInt();
                    this.products[selectProduct-1].changeMainPrice(price);
                    System.out.println("The real price of " + selectProduct + " (" + products[selectProduct-1].name + ") is " + this.products[selectProduct-1].realPrice + " now." );
                }else{
                    System.out.println("Invalid input.");
                }
                break;

            default:
                System.out.println("invalid input");
            
        }
        


    }
    
    void aboutStaff(){
        System.out.println("1: Add new staff. \n2: Display All. \n3: Add Bonus. \n4: Remove Bonus");
        System.out.print("Choose an option: ");
        int opt = inp.nextInt();
        
        int employee;
        float parcent;
        
        switch (opt){
            case 1:
                System.out.print("Enter Name: ");
                inp.nextLine();
                String a =  inp.nextLine();
                        
                System.out.print("Enter age: ");
                int b =  inp.nextInt();
                        
                System.out.print("Enter Mobile Number: ");
                String c =  inp.next();
                inp.nextLine();
                
                System.out.print("Enter Address: ");
                String d =  inp.nextLine();
                
                System.out.print("Enter Designation: ");
                String e =  inp.nextLine();
                
                System.out.print("Enter Salary: ");
                float f =  inp.nextFloat();
                
                this.staffs[this.countStaff] = new staff(a, b, c, d, e, f);
                System.out.println("New employee added. Name: " + staffs[this.countStaff].name + " and employee id: " + (countStaff + 1) );
                this.countStaff++;
                
                break;
                
            case 2:
                if(this.countStaff<1){
                    System.out.print("No employee to show\n");
                }
                for(int i=0; i<countStaff; i++){
                    System.out.println( i+1 + ": " + this.staffs[i].name + " (" + this.staffs[i].designation + "). " + " Salary: " + (this.staffs[i].salary+this.staffs[i].bonus));
                }
                break;
            
            case 3:
                System.out.print("Employee id: ");
                employee = inp.nextInt();
                if( (employee-1)>=0 && (employee-1)<this.countStaff){
                    System.out.print("How much in parcentage: ");
                    parcent = inp.nextInt();
                    
                    this.staffs[employee-1].addBonus(parcent);
                    
                    System.out.println(parcent + "% bonus added to the employee No. " + employee + " (" + this.staffs[employee-1].name + ")");
                }else{
                    System.out.println("Invalid input");
                }

                break;
            
            case 4:
                System.out.print("Employee id: ");
                employee = inp.nextInt();
                
                if( (employee-1)>=0 && (employee-1)<this.countStaff){
                    this.staffs[employee-1].removeBonus();
                    System.out.println("Bonus removed from the employee No. " + employee + " (" + this.staffs[employee-1].name + ")");
                }else{
                    System.out.println("Invalid input");
                }
                break;
            
            default:
                System.out.println("invalid input");
        }
        
    }

    void aboutCustomer(){
        System.out.println("1: Add new customer. \n2: Display All customers. \n3: Update Membership level.");
        System.out.print("Choose an option: ");
        int opt = inp.nextInt();
        
        switch (opt){
            case 1:
                System.out.print("Enter Name: ");
                inp.nextLine();
                String a =  inp.nextLine();
                        
                System.out.print("Enter age: ");
                int b =  inp.nextInt();
                        
                System.out.print("Enter Mobile Number: ");
                String c =  inp.next();
                inp.nextLine();
                
                System.out.print("Enter Address: ");
                String d =  inp.nextLine();
                
                System.out.print("Enter Membership level: ");
                int e =  inp.nextInt();

                
                this.customers[this.countCustomer] = new customer(a, b, c, d, e);
                System.out.println("New customer added. Name: " + customers[this.countCustomer].name + " and customer id: " + (countCustomer + 1) );
                this.countCustomer++;
                
                break;
                
            case 2:
                if(this.countCustomer<1){
                    System.out.print("No customer to show\n");
                }
                for(int i=0; i<countCustomer; i++){
                    System.out.println( i+1 + ": " + this.customers[i].name + " ( level " + this.customers[i].membershipLevel + ", reward point: " + this.customers[i].rewardPoint +")." );
                }
                break;
            
            case 3:
                System.out.print("Customer id: ");
                int customer = inp.nextInt();
                
                if( (customer-1)>=0 && (customer-1)<this.countCustomer ){
                    
                    System.out.print("Updated level (1 to 3): ");
                    int upLev = inp.nextInt();
                    
                    if((upLev <= 3) && (upLev>=1) ){
                        this.customers[customer-1].updateMembershipLevel(upLev);
                        System.out.println("Customer " + this.customers[customer-1].name + " (id " + customer + ") is now LEVEL " + upLev );
                    }else{
                        System.out.println(upLev + " can not be a level.");
                    }
                    
                }else{
                    System.out.println("Invalid input");
                }

                break;
            
            default:
                System.out.println("invalid input");
                
                
        }
        
    }
    
    void billing(){
        boolean check = true;
        int opt, id, quantity, totalAmount=0;
        
        while(check){
            System.out.println("\n1.Calculate price. \n2: Generate invoice");
            System.out.print("Choose an option: ");
            opt = inp.nextInt();
            
            if(opt==1){
                System.out.print("product id: ");
                id = inp.nextInt();
                if((id-1)>=0 && (id-1)<this.countProduct){
                    System.out.print("Quantity: ");
                    quantity = inp.nextInt();
                    totalAmount += this.products[id-1].price*quantity;
                }else{
                    System.out.print("Product does not exist.");
                }
                
            }else if(opt==2){
                System.out.println("\n1: Registered customer. \n2: Not Registered customer.");
                System.out.print("Chose an option: ");
                
                opt = inp.nextInt();
                if(opt==1){
                    System.out.print("Customer id: ");
                    int customer = inp.nextInt();
                    if((customer-1)>=0 && (customer-1)<this.countCustomer){
                        this.customers[customer-1].addRewardpoint((totalAmount/100));
                        int customerLevel = this.customers[customer-1].membershipLevel;
                        if(customerLevel==1){
                            System.out.println("Total amount is: " + (totalAmount - (totalAmount/100)*10));
                        }else if(customerLevel==2){
                            System.out.println("Total amount is: " + (totalAmount - (totalAmount/100)*15));
                        }else if(customerLevel==3){
                            System.out.println("Total amount is: " + (totalAmount - (totalAmount/100)*20));
                        }
                        
                    }else{
                        System.out.println("Invalid input");
                        continue;
                    }
                    
                }else if(opt==2){
                    System.out.println("Total amount is: " + totalAmount);
                }
                
                check = false;
            }
        }
        
    }
    
    
    
}




class product{
    String name;
    float price=0;
    String insertDate;
    String expireDate;
    float realPrice;
    
    public product(String nam, float pric, String insDate, String expDate){
        this.name = nam;
        this.realPrice = pric;
        this.price = realPrice;
        this.insertDate = insDate;
        this.expireDate = expDate;
    }
    
    void setOffer(int percent){
        this.price = this.realPrice - (this.realPrice/100)*percent;
    }

    void removeOffer(){
        this.price = this.realPrice;
    }
    
    void changeMainPrice(int price){
        this.realPrice = price;
    }
    
}

class person{
    String name;
    int age;
    String contactNumber;
    String address;
    public person(String n, int ag, String num, String add){
        this.name = n;
        this.age = ag;
        this.contactNumber = num;
        this.address = add;
    }
}

class staff extends person{
    String designation;
    float salary;
    float bonus=0;
    
    public staff(String n, int ag, String num, String add, String des, float sal){
        super(n, ag, num, add);
        this.designation = des;
        this.salary = sal;
    }
    
    
    void addBonus(float parcent){
        this.bonus = (this.salary/100)*parcent;
    }
    
    void removeBonus(){
        this.bonus = 0;
    }
    
}

class customer extends person{
    
    int membershipLevel = 0;
    int rewardPoint = 0;
    
    public customer(String n, int ag, String num, String add, int memLev ){
        super(n, ag, num, add);
        this.membershipLevel = memLev;
    }
    
    void addRewardpoint(int point){
        this.rewardPoint = point;
    }
    
    void updateMembershipLevel(int level){
        this.membershipLevel = level; 
    }
    
    
}

