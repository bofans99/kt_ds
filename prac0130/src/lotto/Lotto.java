package lotto;

public class Lotto {
	private static int[] lottoArray = new int[6];
	
	public void printFor1() {
		for (int i = 0; i < lottoArray.length; i++) {
			if(i+1==lottoArray.length) {
				System.out.println(lottoArray[i]);
			}else {
				System.out.print(lottoArray[i]+",");
			}
		}
	}
	public void printFor2() {//index가 있는 전통적인 for문
		for (int index = 0; index < lottoArray.length ; index++) {
				//System.out.println("index: "+ (index+1) + "=" +lottoArray[index+1]);
				if(index%2 != 0) {//홀수만출력
					System.out.println("index:"+ index + " = " +lottoArray[index]);
				}
		}
	}
	public void printForeach() {//성능이 빠른 foreach
		for (int number : lottoArray) {
			System.out.println("번호는 " + number);
		}
	}
	public void printSplit() {//split으로 문장 출력
		String string = "요조 작가님의 문장을 읽으며 느꼈던 해방감이 기억나요. 전 오랫동안 내 것이 없다고 여겨왔어요. 곁에 있는 좋아하는 어른들과 닮고 싶은 친구들을 남몰래 따라 하느라 분주했거든요. 다들 자신만의 빛나는 무언가를 쌓아가고 있는데 한발 늦게 남들을 따라 하느라 분주한 내가 한심하게 느껴지기도 했고요. 그래서 저는 따라쟁이 요조 작가님을 또 따라하기로 마음먹은 거예요.";
		String[] wA = string.split(" ");
		for (int i = 0; i < wA.length; i++) {
			int len = wA[i].length();//split으로 나눈 단어의 length값 할당
			if(len>=3) {//단어길이가 3이상일때
				System.out.println(wA[i]);	
			}
		}
	}
	public static void main(String[] args) {
		lottoArray[0] = 5;
		lottoArray[1] = 15;
		lottoArray[2] = 27;
		lottoArray[3] = 34;
		lottoArray[4] = 36;
		lottoArray[5] = 41;
		Lotto lo = new Lotto();
		lo.printFor1();
		lo.printFor2();
		lo.printForeach();
		lo.printSplit();
	}
}
