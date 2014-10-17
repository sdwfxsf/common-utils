/**
 * 
 */
package com.baidu.unbiz.common.convert.array;

import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrb;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrd;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrf;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arri;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrl;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arro;
import static com.baidu.unbiz.common.convert.ConverterTestHelper.arrs;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.baidu.unbiz.common.convert.ConverterManager;

/**
 * 
 * @author <a href="mailto:xuchen06@baidu.com">xuc</a>
 * @version create on 2014年9月22日 下午2:27:34
 */
public class DoubleArrayConverterTest {

	@Test
	public void toConvert() {
		DoubleArrayConverter doubleArrayConverter = (DoubleArrayConverter) ConverterManager.lookup(double[].class);

		assertEq(arrd(1.73), doubleArrayConverter.toConvert(Double.valueOf(1.73)));
		assertEq(arrd(1.73, 10.22), doubleArrayConverter.toConvert(arrd(1.73, 10.22)));
		assertEq(arrd(1.0, 7.0, 3.0), doubleArrayConverter.toConvert(arri(1, 7, 3)));
		assertEq(arrd(1.0, 7.0, 3.0), doubleArrayConverter.toConvert(arrl(1, 7, 3)));
		assertEq(arrd(1.0, 7.0, 3.0), doubleArrayConverter.toConvert(arrf(1, 7, 3)));
		assertEq(arrd(1.0, 0.0, 1.0), doubleArrayConverter.toConvert(arrl(true, false, true)));
		assertEq(arrd(1.0, 7.0, 3.0), doubleArrayConverter.toConvert(arrb(1, 7, 3)));
		assertEq(arrd(1.0, 7.0, 3.0), doubleArrayConverter.toConvert(arrs(1, 7, 3)));
		assertEq(arrd(1.73, 10.22), doubleArrayConverter.toConvert(arrs("1.73", "10.22")));
		assertEq(arrd(1.73, 10.22), doubleArrayConverter.toConvert(arrs(" 1.73 ", " 10.22 ")));
		assertEq(arrd(1.73, 10), doubleArrayConverter.toConvert(arro("1.73", Integer.valueOf(10))));
		assertEq(arrd(1.73, 10), doubleArrayConverter.toConvert("1.73 \n 10"));
	}

	private void assertEq(double[] arr1, double[] arr2) {
		assertEquals(arr1.length, arr2.length);
		for (int i = 0; i < arr1.length; i++) {
			assertEquals(arr1[i], arr2[i], 0.0001);
		}
	}
}
