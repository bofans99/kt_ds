package address_book;

/**
 * 주소를 최대 5개만 저장할 수 있는 주소록
 * @author Yn
 *
 */
public class AddressArrayHandler {

	//배열의 정의방법
	//타입[] 변수명 = new 타입[몇개?];
	//int[] arrays = new int[5];
	private Address[] addressArray = new Address[5];
	
	public void create(int index, String name, String phoneNumber, String address) {
		addressArray[index] = new Address();
		addressArray[index].setName(name);
		addressArray[index].setPhoneNumber(phoneNumber);
		addressArray[index].setAddress(address);
	}
	
	public void update(int index, String name, String phoneNumber, String address) {

		addressArray[index].setName(name);
		addressArray[index].setPhoneNumber(phoneNumber);
		addressArray[index].setAddress(address);
	}
	
	public void delete(int index) {
		addressArray[index] = null;
	}
	
	public void read(int index) {
		
		System.out.println(addressArray[index]);
	}
	
	
	public static void main(String[] args) {
		// [ 0 ] [ 1 ] [ 2 ] [ 3 ] [ 4 ]
		AddressArrayHandler handler = new AddressArrayHandler();
		handler.create(0, "0이", "011", "인1천");
		handler.create(1, "1이", "012", "인2천");
		handler.create(2, "2이", "013", "인3천");
		handler.create(3, "3이", "014", "인4천");
		handler.create(4, "4이", "015", "인5천");
		handler.read(3);
		
		
		handler.update(3,"변경","000","설");
		handler.read(3);
		handler.delete(3);
		handler.read(3);
	}

}
