package Util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Helper {
	public static void optionPaneChangeButtonText() {
		UIManager.put("OptionPane.cancelButtonText", "Imtina");
		UIManager.put("OptionPane.okButtonText", "Yaxşı");
		UIManager.put("OptionPane.yesButtonText", "Bəli");
		UIManager.put("OptionPane.noButtonText", "Xeyr");
	}
public static void showMsg(String str) {
	optionPaneChangeButtonText();
	String msg;
	switch(str) {
	case "fill":
		msg = "Zəhmət olmasa bütün xanaları doldurun!";
		break;
	case "success" :
		msg = "Əməliyyat uğurla yerinə yetirildi!";
		break;
	default:
		msg = str;	
		
	}
	JOptionPane.showMessageDialog(null, msg, "Diqqət!", JOptionPane.INFORMATION_MESSAGE);
}
public static boolean confirm(String str) {
	optionPaneChangeButtonText();
	String msg;
	switch (str) {
	case "sure" :
		msg = "Bu əməliyyatı yerinə yetirməyə əminsiniz?";
		break;
	default:
		msg = str;
		break;
	}
	int res = JOptionPane.showConfirmDialog(null, msg, "Diqqət!", JOptionPane.YES_NO_OPTION);
	if(res == 0) {
		return true;
	} else {
		return false;
	}
}
}
