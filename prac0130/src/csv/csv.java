package csv;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class csv {
	public static void main(String[] args) {
		//파일을 받아온다
		try {
			List<String> csv = Files.readAllLines(Paths.get("C:\\Users\\User\\Desktop\\점수1.csv"));
			
			//라인별로 반복한다.
			for(int i =0; i<csv.size();i++) {
				if(i==0) { continue;}//과목,점수,등급 라인건너뛰기
				
				//라인을 "," 로 분리한다.
				String[] strArr = csv.get(i).split(",");
				
				//분리된 단어를 반복하여 출력한다.
				/*for (String w : strArr) { System.out.println(w); }*/
				System.out.println(strArr[0]+"과목의 점수는"
							+strArr[1]+"점이고 등급은"
							+strArr[2]+"이다");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
