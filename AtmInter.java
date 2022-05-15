import java.util.Scanner;

class BankAcc{
	String name;
	String userName;
	String password;
	String accNo;
	float bal=100000f;
	int trans=0;
	String transHist="";
	
	//if the person does not have an account registration is done in register method
	public void register(){
		Scanner sc=new Scanner(System.in);
		System.out.print("\n Enter Your Name : ");
		this.name=sc.nextLine();
		System.out.print("\n Enter User Name : ");
		this.userName=sc.nextLine();
		System.out.print("\n Enter Your Password : ");
		this.password=sc.nextLine();
		System.out.print("\n Enter Your Account Number : ");
		this.accNo=sc.nextLine();
		System.out.println("\nRegistration Completed... Kindly login");
	}
	//to login 
	public boolean login(){
		boolean isLogin=false;
		Scanner sc=new Scanner(System.in);
		while(!isLogin){
			System.out.println("\nEnter Your Username : ");
			String Username=sc.nextLine();
			if(Username.equals(userName)){
				while(!isLogin){
					System.out.print("\n Enter Your Password : ");
					String Password=sc.nextLine();
					if(Password.equals(password)){
						System.out.print("\nLogin Successful");
						isLogin=true;
					}
					else{
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else{
				System.out.println("\nUsername not found");
			}
		}
		return isLogin;
	}
	public void withDraw(){
		System.out.println("\nEnter the amount to withdraw: ");
		Scanner sc=new Scanner(System.in);
		float amt=sc.nextFloat();
		try{
			if(bal>=amt){
				trans++;
				bal-=amt;
				System.out.println("\nWithdrawal id done Successfully");
				String str=amt+"Rs Withdrawed\n";
				transHist=transHist.concat(str);
			}
			else{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e){
		}
	}
	public void Deposit(){
		System.out.print("\nEnter amount to deposit: ");
		Scanner sc=new Scanner(System.in);
		float amt=sc.nextFloat();
		try{
			if(amt<=100000f){
				trans++;
				bal+=amt;
				System.out.println("\nSuccessfully Deposited");
				String str=amt+"Rs Deposited\n";
				transHist=transHist.concat(str);
			}
			else{
				System.out.println("\nSorry! Limit is 100000.00");
			}
		}
		catch(Exception e){
		}
	}
	public void transfer(){
		Scanner sc=new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name : ");
		String receipent=sc.nextLine();
		System.out.print("\nEnter amount to transfer: ");
		float amount=sc.nextFloat();
		
		try{
			if(bal>=amount){
				if(amount<=50000f){
					trans++;
					bal-=amount;
					System.out.println("\nSuccessfully Transferred to "+receipent);
					String str=amount+"Rs Transferred to"+receipent+"\n";
					transHist=transHist.concat(str);
				}
				else{
					System.out.println("\nSorry!! Limit is 50000.00");
				}
			}
			else{
				System.out.println("\nInsufficient Balance");
			}
		}
		catch(Exception e){
		}
	}
					
	public void checkBal(){
		System.out.println("\n"+bal+"Rs");
	}
	public void transHistory(){
		if(trans==0){
			System.out.println("\nEmpty");
		}
		else{
			System.out.println("\n"+transHist);
		}
	}
}
public class AtmInter{
	public static int takeIntegerInput(int limit){
		int ip=0;
		boolean flag=false;
		while(!flag){
			try{
				Scanner sc =new Scanner(System.in);
				ip=sc.nextInt();
				flag=true;
				
				if(flag && ip>limit || ip<1){
					System.out.println("Choose the number between 1 to " +limit);
					flag=false;
				}
			}
			catch(Exception e){
				System.out.println("Enter only Integer value");
				flag=false;
			}
		};
		return ip;
			
	}
	public static void main(String args[]){
		System.out.println("\n********WELCOME TO XYZ ATM MACHINE********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.println("Enter Your Choice : ");
		int choice=takeIntegerInput(2);
		
		if(choice==1){
			BankAcc b=new BankAcc();
			b.register();
			while(true){
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter Your Choice : ");
				int ch=takeIntegerInput(2);
				if(ch==1){
					if(b.login()){
						System.out.println("\n\n********WELCOME BACK "+b.name+" ********\n");
						boolean isFinished=false;
						while(!isFinished){
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice: ");
							int c=takeIntegerInput(6);
							switch(c){
								case 1 :
								b.withDraw();
								break;
								case 2:
								b.Deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBal();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isFinished=true;
								break;
							}
						}
					}
				}
				else{
					System.exit(0);
				}
			}
		}
		else{
			System.exit(0);
		}
	}
}
					
						

						