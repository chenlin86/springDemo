package com.lin.spring.demo.common.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.number.CurrencyFormatter;

/**
 * ��ʽ��
 * 
 * @author chenlin
 *
 */
public class FormateTest {

	@Test
	public void test1() throws ParseException {
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		// ����С�������λ
		currencyFormatter.setFractionDigits(2);
		// ��������
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);
		Assert.assertEquals(new BigDecimal("123.13"),
				currencyFormatter.parse("��123.125", Locale.CHINA));
	}

	@Test
	public void test2() throws ParseException {
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		// ����С�������λ
		currencyFormatter.setFractionDigits(2);
		// ��������
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);
		Assert.assertEquals(("��123.00"),
				currencyFormatter.print(123, Locale.CHINA));
	}
}
