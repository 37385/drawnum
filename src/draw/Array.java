package draw;
import java.util.ArrayList;

public class Array extends ArrayList<Integer> {
	/**
	 * 
	 */
	java.security.SecureRandom rand =new java.security.SecureRandom();
	private static final long serialVersionUID = 1L;
	private int minValue;
//	private int maxValue;

	public Array(int minValue,int maxValue){
		super(maxValue-minValue);
//		this.maxValue = maxValue;
		this.minValue = minValue;
		int size = maxValue-minValue;
		System.out.println("The size of array to load is:"+size);
		for(int i=1;i<=size;i++){
			this.add(Integer.valueOf(i));
		}
		System.out.println("Load array done!");
		try {
			get((int) (this.size()*rand.nextDouble()));
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public Integer getInt(int index) {
		try {
			int temp = this.get(index);
			this.remove(index);
			return temp+minValue;
		} catch (Exception e) {
			return null;
		}

	}
	public Integer getInt_without_index() {
		return getInt((int) (this.size()*rand.nextDouble()));
	}
}