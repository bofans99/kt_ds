package listGasStation;

public class Street {
	//리터당 연료가격 가솔린,디젤,LPG
	public static final double GASOLIN_PRICE = 1569.67;
	public static final double DISEL_PRICE = 1651.15;
	public static final double LPG_PRICE = 1039.35;
	
	public static void main(String[] args) {
		GasStation gas = new GasStation();
		
		Fuel customerFuel = new Fuel("disel",50);
//		customerFuel.setType("disel");
//		customerFuel.setStock(50);

		Customer cust = new Customer();
		cust.setFuel(customerFuel);
		cust.setMoney(1000000);
		
		System.out.println("구매자가 디젤을 50L구매함");
		cust.buy(gas, "disel", 50);
	}
}
