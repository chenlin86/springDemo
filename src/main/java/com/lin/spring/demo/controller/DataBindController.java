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
	 * 当接收的参数为基本类型时，必须传递数字值，否则会无法访问。也可以通过@RequestParam对接收参数进行重命名来获取参数值
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
	 * 当接收的参数为包裝类，可以接收null值和数字值。
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
	 * 当接收的参数为数组，可以接收null值和数字值。
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
	 * 基本对象的数据绑定。 http://localhost:18080/springDemo/object?name=zhangsan&age=10
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
	 * 基本对象的数据绑定,多对象同属性时，如果没有前缀绑定，默认给每个对象对传递该值。
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

	// Controller在加载的时候，会先加载数据前缀绑定的，当有请求来的时候先执行绑定处理
	@InitBinder("user")
	public void initUser(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("user.");
	}

	@InitBinder("admin")
	public void initAdmin(WebDataBinder webDataBinder) {
		webDataBinder.setFieldDefaultPrefix("admin.");
	}

	/**
	 * list集合参数传递，需要有一个将list的属性放入对象中进行获取
	 * http://localhost:18080/springDemo/list?users
	 * [0].name=lucy&users[1].name=zhangsan
	 * http://localhost:18080/springDemo/list
	 * ?users[0].name=lucy&users[1].name=zhangsan&users[21].name=lily
	 * 注意：当list参数进行传递时候,下标最好连续，否则会出现很多空对象
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
	 * set集合参数传递，需要有个将set的属性放入对象中进行获取，并且set需要进行初始化，才可以使用
	 * http://localhost:18080/springDemo
	 * /set?users[0].name=lucy&users[1].name=zhangsan
	 * 当初始化的元素个数不足的时候，会提示InvalidPropertyException异常
	 * http://localhost:18080/springDemo
	 * /set?users[0].name=lucy&users[1].name=zhangsan&users[20].names=lily
	 * 另外，set集合在处理数据的时候，也有问题。当set判断内容重复的时候，也会直接报错
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
	 * map参数传递，需要有个将map的属性放入对象中进行获取
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
	 * json参数接收，需要在接收参数前边添加@RequestBody，并添加jackson-databind解析包
	 * http://localhost:18080/springDemo/json 并注意设置Content-Type:application/json
	 * {"name":"zhangsan"
	 * ,"age":10,"contactInfo":{"phone":"010","address":"北京市"}}
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
	 * xml参数接收，需要在接收参数前追加@RequestBody，并添加spring-oxm包进行解析
	 * 并需要在接收对象类上添加@XmlRootElement标记，可接收对象属性的get方法上添加@XmlElement
	 * http://localhost:18080/springDemo/xml 并注意设置Content-Type: application/xml
	 * <?xml version="1.0" encoding="UTF-8"?> <admin> <name>张三</name>
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
	 * 字符转换类型参数，需啊事先开启mvc:converter
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
	 * 类型为日期的参数传递,需要事先注册一个日期绑定，绑定的方式有两种： 第一种：局部绑定，直接使用initBinder绑定即可；
	 * 第二种：全局绑定，直接在mvc :annotation-driven中指定conversion-service即可
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

	// 此处绑定的注册属于局部的处理，只有在当前controller有效
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
