package one_to_one_pan_controller;

import java.util.Scanner;

import one_to_one_pan_dao.PanCrud;
import one_to_one_pan_dao.PersonCrud;
import one_to_one_pan_dto.PanCard;
import one_to_one_pan_dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Person person = new Person();
		PersonCrud personCrud = new PersonCrud();
		PanCard panCard = new PanCard();
		PanCrud panCrud = new PanCrud();
		boolean condition = true;
		do {
			System.out.println("1-->Person");
			System.out.println("2-->Pancard");
			System.out.println("3-->Exit");
			System.out.print("Enter your choice : ");
			int choice = scanner.nextInt();
			switch(choice) {
			case 1 : {
				boolean flag = true;
				do {
					System.out.println("______Press______");
					System.out.println("1-->Insert person");
					System.out.println("2-->Update person");
					System.out.println("3-->Delete person");
					System.out.println("4-->Fetch a person");
					System.out.println("5-->Fetch all person");
					System.out.println("6-->Exit");
					System.out.print("Enter your choice : ");
					int choice1 = scanner.nextInt();
					switch(choice1) {
					case 1 : {
						System.out.print("Enter your id : ");
						int id = scanner.nextInt();
						System.out.print("Enter your name : ");
						String name = scanner.next();
						System.out.print("Enter your phone number : ");
						long phone = scanner.nextLong();
						System.out.print("Enter your job : ");
						String job = scanner.next();
						System.out.print("Enter your address : ");
						String address = scanner.next();
						System.out.print("Enter pan id : ");
						int pid = scanner.nextInt();
						panCard.setPanId(pid);
						person.setId(id);
						person.setName(name);
						person.setPhone(phone);
						person.setJob(job);
						person.setAddress(address);
						person.setPanCard(panCard);
						personCrud.insertPerson(person);
					}
					break;
					case 2 : {
						System.out.print("Enter the id : ");
						int uid = scanner.nextInt();
						System.out.print("Enter the name : ");
						String uname = scanner.next();
						personCrud.updatePerson(uname,uid);
					}
					break;
					case 3 : {
						System.out.print("Enter the id : ");
						int id = scanner.nextInt();
						personCrud.deletePerson(id);
					}
					break;
					case 4 : {
						System.out.print("Enter the id :");
						int id = scanner.nextInt();
						personCrud.fetchPerson(id);
					}
					break;
					case 5 : {
						personCrud.fetchAllPerson();
					}
					break;
					case 6 : {
						flag = false;
					}
					}
				}while(flag);
			}
			break;
			case 2 : {
				boolean flag1 = true;
				do {
					System.out.println("______Press______");
					System.out.println("1-->Insert Pancard");
					System.out.println("2-->Update Pancard");
					System.out.println("3-->Delete Pancard");
					System.out.println("4-->Fetch a Pancard");
					System.out.println("5-->Fetch all Pancard");
					System.out.println("6-->Exit");
					System.out.print("Enter your choice : ");
					int choice2 = scanner.nextInt();
					switch(choice2) {
					case 1 : {
						System.out.print("Enter pan id : ");
						int id = scanner.nextInt();
						System.out.print("Enter name as in pan : ");
						String panName = scanner.next();
						System.out.print("Enter your address : ");
						String address = scanner.next();
						panCard.setPanId(id);
						panCard.setPanAddress(address);
						panCard.setPanName(panName);
						panCrud.insertPan(panCard);
					}
					break;
					case 2 : {
						System.out.print("Enter the pan id : ");
						int uid = scanner.nextInt();
						System.out.print("Enter the pan name : ");
						String uname = scanner.next();
						System.out.print("Enter the pan address");
						String panAddress = scanner.next();
						panCrud.updatePancard(uid,uname,panAddress);
					}
					break;
					case 3 : {
						System.out.print("Enter the id : ");
						int id = scanner.nextInt();
						panCrud.deletePancard(id);
					}
					break;
					case 4 : {
						System.out.print("Enter the id :");
						int id = scanner.nextInt();
						panCrud.fetchPan(id);
					}
					break;
					case 5 : {
						panCrud.fetchAllPan();
					}
					break;
					case 6 : {
						flag1 = false;
					}
					}
				}while(flag1);
			}
			break;
			case 3 : {
				condition = false ;
			}
			}
		}while(condition);
		System.out.println("Thank you... Visit again...!!");
		
	}
}