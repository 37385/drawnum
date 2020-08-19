package draw;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Event implements ActionListener,WindowListener,WindowStateListener{
	
	int windowState = 0;
	
	ArrayList<String> arrayList = new ArrayList<String>();
	public Event() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().equals("settings")) {
	//	System.out.println("settings");
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new SettingsGUI();
			}
		});
		}
		if(e.getActionCommand().equals("draw")) {
		//	System.out.println("draw");
			onDraw();
		}
		if (e.getActionCommand().equals("reset")) {
			//delete file
			new File("DATA").delete();
			System.exit(0);
//			Runtime.getRuntime().addShutdownHook(new Thread() {
//				public void run() {
//					String restartCmdString="javaw -jar "+System.getProperty("java.class.path");
//					
//				}
//			});
	//	System.out.println(System.getProperty("java.class.path"));
		}
	}

	private void onDraw() {
		Integer getInteger = Main.array.getInt_without_index();
			if (!(getInteger == null)) {
				arrayList.add(0,(arrayList.size()+1)+":"+ getInteger.toString());
				Main.drawGUI.setJScrollPaneContent(arrayList.toArray(new String[arrayList.size()]));
			}
			Main.drawGUI.setText(getInteger);
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO �Զ����ɵķ������
		this.onClose();
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO �Զ����ɵķ������
		
	}

	void onClose() {
		if (!(windowState == 6)) {
			Main.config.shape = Main.drawGUI.getBounds();
		}
		new ObjectLoader("DATA").saveConfig(Main.config);
	}

	@Override
	public void windowStateChanged(WindowEvent e) {
		// TODO �Զ����ɵķ������
		windowState = e.getNewState();
	}
	
}
