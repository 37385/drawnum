package legacy;
import java.util.Scanner;

public class input {
	static  long in() {
		try (Scanner sca = new Scanner(System.in)) {
			String str;
			str= sca.nextLine();
			switch (str) {
			case "a":
			System.out.println("����");
			System.out.println("�汾��0.2.2_preview");
			System.out.println("���ߣ�37385@github.com");
			return 0;
			case "d":
			SaveData.Del();
			System.out.println("��ɾ�������ļ�!");
			return 0;
			case "/n":
			return 1;
			default:
			try {
				return Long.parseLong(str);
				} catch (Exception e) {
					System.out.println("����");
					System.out.println("����һ���Գ�ȡ����\n �س�Ĭ������һ��\n ��q�˳�����cɾ�������õ������ļ�"); 
				return 0;
				}
			}
		}
	}
}
