package legacy;
import java.util.*;

public class Main
{
 public static void main()
 { 
 System.out.println("�汾��0.2.1_preview");
 Scanner scanner =new Scanner(System.in);
 java.security.SecureRandom RAND =new java.security.SecureRandom();
 boolean iswhile=true;
 int size=1;
 int RenShu=0;
 String line;
 if(SaveData.isexist()){
 size =SaveData.Load();
 System.out.println("�Ѷ�ȡ�����ļ������ֵ:"+size);
 }else{
 System.out.println("�����ļ�������,���������ֵ");
 size = scanner.nextInt();
 SaveData.Save(size);
 scanner.nextLine();
 }
 MyArray my =new MyArray(size);
 System.out.println("����һ���Գ�ȡ����\n �س�Ĭ������һ��\n ��q�˳�����cɾ�������õ������ļ�"); 
 while(iswhile){

 line =scanner.nextLine();
 if(line.equals("")){
 RenShu=1;
 }else if(line.equals("q")){
 break;
 }else if(line.equals("c")){
 SaveData.Del();
 System.out.println("��ɾ�������ļ�!");
 break;
 }else {
 RenShu=Integer.parseInt(line);
 }

 
 for(;RenShu>0;RenShu--){
 int random = (int) (my.size()*RAND.nextDouble() );
 //System.out.println(my.get(random));
 LJXOutput.Output(((Integer)my.get(random)).intValue());
 my.remove(random);
 if(my.size()==0){
 System.out.println("�ѳ���������");
 iswhile=false;
 break;
 }
 
 };
 }
 scanner.close();
}
}