package Util;

import javax.swing.JOptionPane;

public class Helper {
public static void showMsg(String str) {
	String msg;
	switch(str) {
	case "fill":
		msg = "Zəhmət olmasa Fin Kod və Şifrəni daxil edin!";
		break;
	default:
		msg = str;	
		
	}
	JOptionPane.showMessageDialog(null, msg, "Diqqət!", JOptionPane.INFORMATION_MESSAGE);
}
}
