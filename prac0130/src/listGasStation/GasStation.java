package listGasStation;

import java.util.ArrayList;
import java.util.List;

public class GasStation {

	private List<Fuel> fuelList;
	private int money;
	
	public GasStation() {//생성자
		fuelList = new ArrayList<>();
		fuelList.add(new Fuel("gasolin", 5000));
		fuelList.add(new Fuel("disel", 3000));
		fuelList.add(new Fuel("lpg", 1000));
		
		setMoney(1000000);
	}
	
	public GasStation(List<Fuel> fuelList) {
		super();
		this.fuelList = fuelList;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}

	
	/**
	 * 판매
	 * @param type 연료종류 gasolin,disel,lpg
	 * @param stock 판매량
	 * @return 
	 */
	public boolean sell(String type, int stock) {
		boolean result = false;
		
		//1.tpye 연료가 stock만큼 존재하는지 확인
		if(ischeckStock(type, stock)) {
			result = true;
			
			//1-1.연료가 충분하면 type 연료 잔량을 stock만큼 줄인다.
			for (Fuel fuel : fuelList) {
				if(fuel.getType().equals(type)) {
					int fuelStock = fuel.getStock();
					fuelStock = fuelStock - stock;
					fuel.setStock(fuelStock);
				}
			}
		}else {
			result = false;
			//1-2.연료가 부족하면 "연료부족" 출력 후 메소드종료
			System.out.println(type+"연료부족");
		}
		
		return result;
	}
	
	/**
	 * 수입
	 * @param money 구매가격
	 */
	public void addMoney(int money) {
		this.money += money;
	}
	
	/**
	 * type 연료가 stock만큼 주유가능한지 확인
	 * @param type 연료종류
	 * @param stock 주유량
	 * @return 연료량이 stock이상이면 true, 아니면false
	 */
	private boolean ischeckStock(String type, int stock) {
		//boolean result = false;
		for (Fuel fuel : fuelList) {
			if(fuel.getType().equals(type)) {
				//result = fuel.getStock() >= stock;	
				//break; 아래 리턴이나 브레이크 둘중하나사용 
				return fuel.getStock() >= stock;	
			}
		}
		return false;
	}

}
