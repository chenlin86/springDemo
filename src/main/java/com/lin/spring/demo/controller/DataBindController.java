package com.lin.spring.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.spring.demo.bean.Admin;
import com.lin.spring.demo.bean.ListUserForm;
import com.lin.spring.demo.bean.MapUserForm;
import com.lin.spring.demo.bean.SetUserForm;
import com.lin.spring.demo.bean.User;

@Controller
public class DataBindController {

	/**
	 * �����յĲ���Ϊ��������ʱ�����봫������ֵ��������޷����ʡ�Ҳ����ͨ��@RequestParam�Խ��ղ�����������������ȡ����ֵ
	 * http://localhost:18080/springDemo/baseType?age=10
	 * 
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "baseType")
	@ResponseBody
	public String baseType(@RequestParam("xage") int age) {
		return "age:" + age;
	}

	/**
	 * �����յĲ���Ϊ���b�࣬���Խ���nullֵ������ֵ��
	 * http://localhost:18080/springDemo/array?name=lucy&name=merry
	 * 
	 * @param age
	 * @return
	 */
	@RequestMapping(value = "baseType2")
	@ResponseBody
	public String baseType(Integer age) {
		return "age:" + age;
	}

	/**
	 * �����յĲ���Ϊ���飬���Խ���nullֵ������ֵ��
	 * http://localhost:18080/springDemo/baseType2?age=10
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "array")
	@ResponseBody
	public String array(String[] name) {
		StringBuffer buf = new StringBuffer();
		for (String item : name) {
			buf.append(item).append(" ");
		}
		return "names:" + buf.toString();
	}

	/**
	 * ������������ݰ󶨡� http://localhost:18080/springDemo/object?name=zhangsan&age=10
	 * http
	 * ://localhost:18080/springDemo/object?name=zhangsan&age=10&contactInfo.
	 * phone=15911111111
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "object")
	@ResponseBody
	public String object(User user) {
		return "obj:" + user;
	}

	/**
	 * ������������ݰ�,�����ͬ����ʱ�����û��ǰ׺�󶨣�Ĭ�ϸ�ÿ������Դ��ݸ�ֵ��
	 * http://localhost:18080/springDemo/objectSamePro?name=zhangsan&age=10
	 * http:
	 * //localhost:18080/springDemo/objectSamePro?user.name=lucy&admin.name=
	 * zhangsan&age=10
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "objectSamePro")
	@ResponseBody
	public String objectSamePro(User user, Admin admin) {
		return "obj:" + user + "  " + admin;
	}

	// Controller�ڼ��ص�ʱ�򣬻��ȼ�������ǰ׺�󶨵ģ�������������ʱ����ִ�а󶨴���
	@InitBinder("user")
	public void initUser(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("user.");
	}

	@InitBinder("admin")
	public void initAdmin(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("admin.");
	}

	/**
	 * list���ϲ������ݣ���Ҫ��һ����list�����Է�������н��л�ȡ
	 * http://localhost:18080/springDemo/list?users
	 * [0].name=lucy&users[1].name=zhangsan
	 * http://localhost:18080/springDemo/list
	 * ?users[0].name=lucy&users[1].name=zhangsan&users[21].name=lily
	 * ע�⣺��list�������д���ʱ��,�±�����������������ֺܶ�ն���
	 * 
	 * @param listUserForm
	 * @return
	 */
	@RequestMapping(value = "list")
	@ResponseBody
	public String list(ListUserForm listUserForm) {
		return "listSize:" + listUserForm.getUsers().size() + "listUserForm:"
				+ listUserForm;
	}

	/**
	 * set���ϲ������ݣ���Ҫ�и���set�����Է�������н��л�ȡ������set��Ҫ���г�ʼ�����ſ���ʹ��
	 * http://localhost:18080/springDemo
	 * /set?users[0].name=lucy&users[1].name=zhangsan
	 * ����ʼ����Ԫ�ظ��������ʱ�򣬻���ʾInvalidPropertyException�쳣
	 * http://localhost:18080/springDemo
	 * /set?users[0].name=lucy&users[1].name=zhangsan&users[20].names=lily
	 * ���⣬set�����ڴ������ݵ�ʱ��Ҳ�����⡣��set�ж������ظ���ʱ��Ҳ��ֱ�ӱ���
	 * http://localhost:18080/springDemo
	 * /set?users[0].name=lucy&users[1].name=lucy
	 * 
	 * @param setUserForm
	 * @return
	 */
	@RequestMapping(value = "set")
	@ResponseBody
	public String set(SetUserForm setUserForm) {
		return "setSize:" + setUserForm.getUsers().size() + "setUserForm:"
				+ setUserForm;
	}

	/**
	 * map�������ݣ���Ҫ�и���map�����Է�������н��л�ȡ
	 * http://localhost:18080/springDemo/map?users[%27x%27].name=lucy&user[%27x%
	 * 27].age=10&users[%27y%27].name=lucy
	 * 
	 * @param mapUserForm
	 * @return
	 */
	@RequestMapping(value = "map")
	@ResponseBody
	public String map(MapUserForm mapUserForm) {
		return "mapSize:" + mapUserForm.getUsers().size() + "mapUserForm:"
				+ mapUserForm;
	}

	/**
	 * json�������գ���Ҫ�ڽ��ղ���ǰ�����@RequestBody�������jackson-databind������
	 * http://localhost:18080/springDemo/json ��ע������Content-Type:application/json
	 * {"name":"zhangsan"
	 * ,"age":10,"contactInfo":{"phone":"010","address":"������"}}
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "json")
	@ResponseBody
	public String json(@RequestBody User user) {
		return "user:" + user;
	}

	/**
	 * xml�������գ���Ҫ�ڽ��ղ���ǰ׷��@RequestBody�������spring-oxm�����н���
	 * ����Ҫ�ڽ��ն����������@XmlRootElement��ǣ��ɽ��ն������Ե�get���������@XmlElement
	 * http://localhost:18080/springDemo/xml ��ע������Content-Type: application/xml
	 * <?xml version="1.0" encoding="UTF-8"?> <admin> <name>����</name>
	 * <age>10</age> </admin>
	 * 
	 * @param admin
	 * @return
	 */
	@RequestMapping(value = "xml")
	@ResponseBody
	public String xml(@RequestBody Admin admin) {
		return "admin:" + admin;
	}

	/**
	 * �ַ�ת�����Ͳ������谡���ȿ���mvc:converter
	 * http://localhost:18080/springDemo/converter?bool=on
	 * 
	 * @param bool
	 * @return
	 */
	@RequestMapping(value = "converter")
	@ResponseBody
	public String converter(Boolean bool) {
		return "boolean:" + bool.toString();
	}

	/**
	 * ����Ϊ���ڵĲ�������,��Ҫ����ע��һ�����ڰ󶨣��󶨵ķ�ʽ�����֣� ��һ�֣��ֲ��󶨣�ֱ��ʹ��initBinder�󶨼��ɣ�
	 * �ڶ��֣�ȫ�ְ󶨣�ֱ����mvc :annotation-driven��ָ��conversion-service����
	 * http://localhost:18080/springDemo/date?date=2016-12-11
	 * 
	 * @param date
	 * @return
	 */
	@RequestMapping(value = "date")
	@ResponseBody
	public String date(Date date) {
		return "date:" + date.toString();
	}

	// �˴��󶨵�ע�����ھֲ��Ĵ���ֻ���ڵ�ǰcontroller��Ч
	@InitBinder("date")
	public void initDate(WebDataBinder webDateBinder) {
		webDateBinder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd"), true));
	}

	@RequestMapping(value = "date2")
	@ResponseBody
	public String date2(Date date2) {
		return "date:" + date2.toString();
	}

}
