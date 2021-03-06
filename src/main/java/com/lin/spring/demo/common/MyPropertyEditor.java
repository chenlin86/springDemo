package com.lin.spring.demo.common;

import java.beans.PropertyEditorSupport;

import com.lin.spring.demo.bean.User;

/**
 * 属性编辑器的接口
 * 
 * @author chenlin
 *
 */
public class MyPropertyEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User u = new User();
		String[] textArray = text.split(",");
		u.setName(textArray[0]);
		u.setAge(Integer.parseInt(textArray[1]));
		this.setValue(u);
	}

	public static void main(String[] args) {
		MyPropertyEditor editor = new MyPropertyEditor();
		editor.setAsText("张三,10");
		System.out.println(editor.getValue());
	}

}
