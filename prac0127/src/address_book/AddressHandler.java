package address_book;

public class AddressHandler {
	
	private Address address1;
	
	/**
	 * 주소록 추가
	 */
	public void create() {
		address1 = new Address();//인스턴스화
		address1.setName("이유나");
		address1.setPhoneNumber("01090281");
		address1.setAddress("인천");
	}
	public void update() {
		address1.setName("유나");
	}
	public void delete() {
		address1 = null;
	}
	public void read() {
		System.out.println("이름:"+address1.getName());
		System.out.println("번호:"+address1.getPhoneNumber());
		System.out.println("주소:"+address1.getAddress());
	}

	public static void main(String[] args) {
		AddressHandler handler = new AddressHandler();
		handler.create();
		handler.read();
		handler.update();
		handler.read();
		handler.delete();
		handler.read();
		
	}
	

}
