package list_address_book;

import java.util.ArrayList;
import java.util.List;

public class AddressListHandler {

	private List<Address> addressList = new ArrayList<>();

	public void create(String name, String phoneNumber, String address) {
		Address addr = new Address();
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
		addressList.add(addr);
	}

	public void update(int index, String name, String phoneNumber, String address) {
		Address addr = addressList.get(index);
		addr.setName(name);
		addr.setPhoneNumber(phoneNumber);
		addr.setAddress(address);
	}

	public void delete(int index) {
		addressList.remove(index);
	}

	public void read(int index) {
		Address addr = addressList.get(index);
		System.out.println("이름 : " + addr.getName());
		System.out.println("전화번호 : " + addr.getPhoneNumber());
		System.out.println("주소 : " + addr.getAddress());
	}
	
	/**
	 * 전통적 for이용
	 */
	public void readAllFor() {
		for (int i = 0; i < addressList.size(); i++) {
			read(i);
		}
	}
	
	/**
	 * foreach이용
	 */
	public void readAllForeach() {
		for (Address addr : addressList) {
			System.out.println("이름 : " + addr.getName());
			System.out.println("전화번호 : " + addr.getPhoneNumber());
			System.out.println("주소 : " + addr.getAddress());
		}
	}
	
	/**
	 * list의 foreach이용
	 */
	public void readAllListForeach() {
		addressList.forEach((addr)->{
		System.out.println("이름 : " + addr.getName());
		System.out.println("전화번호 : " + addr.getPhoneNumber());
		System.out.println("주소 : " + addr.getAddress());
		});
	}
	

	public static void main(String[] args) {
		AddressListHandler handler = new AddressListHandler();
		handler.create("이유", "010", "인천");
		handler.create("유나", "011", "설");
		handler.create("이나", "012", "천안");
		
//		handler.read(0);
//		handler.read(1);
//		handler.read(2);
//		
//		handler.update(2, "유나리", "011111", "서울");
//		handler.read(2);
//		handler.delete(2);
		
		System.out.println("readAllFor");
		handler.readAllFor();
		System.out.println("readAllForeach");
		handler.readAllForeach();
		System.out.println("readAllListForeach");
		handler.readAllListForeach();
	}

}
