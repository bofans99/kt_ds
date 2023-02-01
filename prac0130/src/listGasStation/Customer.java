package listGasStation;

public class Customer {
	
	private Fuel fuel;
	private int money;
	
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		this.fuel = fuel;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	@Override
	public String toString() {
		return "Customer [fuel=" + fuel + ", money=" + money + "]";
	}
	/**
	 * 주유소에서 연료를 구입한다.
	 * @param gasStation 주유소
	 * @param type 연료종류 gasolin,disel,lpg
	 * @param stock 구매량
	 */
	public void buy(GasStation gasStation, String type, int stock) {
		//1.type 연료를 stock만큼 구매할 돈이 있는지 확인
		if(ischeckMoney(type, stock)) {
			boolean sellResult = gasStation.sell(type, stock);
			if(sellResult) {
				//1-1. (돈있고)연료가 있다면 연료의 잔량을 stock만큼 증가시킴
				int fuelStock = fuel.getStock();
				fuelStock += stock;
				fuel.setStock(fuelStock);
				
				int money = 0;
				if(type.equals("gasolin")) {
					money = (int) (Street.GASOLIN_PRICE*stock);
				}else if(type.equals("disel")) {
					money = (int) (Street.DISEL_PRICE*stock);
				}else if(type.equals("lpg")) {
					money = (int) (Street.LPG_PRICE*stock);
				}
				//지불
				this.pay(gasStation, money);
			}else {
				//1-3. (돈있고) 연료가 없다면 "연료 부족. 구매 불가." 출력 종료
				System.out.println("연료 부족. 구매 불가");
			}
		}else {
			//1-2. 돈이 없다면 "잔고 부족. 구매 불가"출력 종료
			System.out.println("잔고 부족. 구매 불가");
		}
	}
	
	/**
	 * 주유소에 돈을 지불한다.
	 * @param gasStation 주유소
	 * @param money
	 */
	private void pay(GasStation gasStation, int money) {
		gasStation.addMoney(money);
		this.money -= money;
	}
	
	/**
	 * 주유하기에 충분한 돈을 가지고 있는지 확인
	 * @param type 연료종류 gasolin,disel,lpg
	 * @param stock 구매량
	 * @return 주유할돈 있으면 true 없으면false
	 */
	private boolean ischeckMoney(String type, int stock) {
		boolean result = false;
		if(type.equals("gasolin")) { 
			result = Street.GASOLIN_PRICE * stock <= this.money;
		}else if(type.equals("disel")) { 
			result = Street.DISEL_PRICE * stock <= money;
	 	}else if(type.equals("lpg")) { 
	 		result = Street.LPG_PRICE * stock <= money;
	 	} 
		
		return result;
	}

}
