package draw;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main {
	
	public static boolean isloading = false;
	public static Array array;
	public static Array array_Rep;
	public static DrawGUI drawGUI;
	public static Config config;
	public static Event event = new Event();
	
	public static void main(String[] args) {
		if (!(args.length==0)) {
			legacy.Main.main();
		} else {
			isloading = true;
			(new ThreadDiag("���Ժ�")).start();
			config = new ObjectLoader("DATA").getConfig();
			System.out.println("minValue:"+config.minValue+"  maxValue:"+ config.maxValue);
			loadNum();
			isloading = false;
				SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					drawGUI =new DrawGUI();
				}
			});
		 }
	}
	public static void loadNum() {
		try {
			if (!config.repeatable) {
			if (array==null) {
				array = new Array(config.minValue, config.maxValue);
			}
		}else {
			array_Rep = new Array(config.minValue, config.maxValue);
		}
		} catch (Throwable e) {
			System.err.println("Create an array error");
			e.printStackTrace();
			new File("DATA").delete();
			JOptionPane.showMessageDialog(null,"�������"+e.toString(),"���",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}
}

class ThreadDiag extends Thread
{

    private String messages = "";//��ʾ�����ʾ��Ϣ
    private JFrame parentFrame = null;//��ʾ��ĸ�����
    private JDialog clueDiag = null;// ���߳��������С���ʾ��

    private Dimension dimensions = Toolkit.getDefaultToolkit().getScreenSize();
    private int width = dimensions.width / 4, height = 60;
    private int left = 0, top = 0;

    public ThreadDiag(String messages)
    {

        this.messages= messages;
        initDiag();//��ʼ����ʾ��
    }

    protected void initDiag()
    {
        clueDiag = new JDialog(parentFrame,"���",true);
        clueDiag.setCursor(new Cursor(Cursor.WAIT_CURSOR));
        JPanel testPanel = new JPanel();
        JLabel testLabel = new JLabel(messages);
        clueDiag.getContentPane().add(testPanel);
        testPanel.add(testLabel);
        (new DisposeDiag()).start();//�����ر���ʾ���߳�
    }

    public void run()
    {
//        ��ʾ��ʾ��
        left = (dimensions.width - width)/2;
        top = (dimensions.height - height)/2;
        clueDiag.setSize(new Dimension(100,100));
        clueDiag.setLocation(left, top);
        clueDiag.setVisible(true);
    }

    class DisposeDiag extends Thread
    {
        public void run()
        {
            try
            {
            	while (Main.isloading) {
            		sleep(100);
				}
            	
            }catch(Exception e){
                System.out.println("Exception:" + e);
            }
            clueDiag.dispose();//�ر���ʾ��
        }
    } 
}