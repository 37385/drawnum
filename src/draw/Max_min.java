package draw;

import javax.swing.JOptionPane;

public class Max_min {
	static boolean isMinCurrect=false;
	static boolean isMaxCurrect=false;
	static String minValueinfoString = "��������Сֵ(����)";
	static String maxValueinfoString = "���������ֵ(����)";
	static String minrangesString = "";
	static String maxrangesString = "";
	static int[] rang = {0,0};
	public Max_min() {
	}
	
	public static int[] getRange() {
		while(!isMinCurrect) {
			minrangesString =JOptionPane.showInputDialog(null,minValueinfoString , "���",JOptionPane.PLAIN_MESSAGE );
			try {
				rang[0] =Integer.parseInt(minrangesString);
				isMinCurrect=true;
				
			} catch (Exception e) {
				minValueinfoString="��Сֵ����";
				}
			}
		while(!isMaxCurrect) {
			maxrangesString=JOptionPane.showInputDialog(null,maxValueinfoString, "���",JOptionPane.PLAIN_MESSAGE );	
			try {
				rang[1] =Integer.parseInt(maxrangesString);
				isMaxCurrect=true;
				
			} catch (Exception e) {
				minValueinfoString="���ֵ����";
				}
			}

			if (rang[0]>rang[1]) {
				System.err.println("Max_min: ��Сֵ�����Ѿ���");
				int temp = rang[1];
				rang[1] = rang[0];
				rang[0] = temp;
			}
		isMinCurrect=false;
		isMaxCurrect=false;
		return rang;
	}	
}
