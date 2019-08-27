
/**  
 * @Title: Md5Tool.java
 * @Package com.fjt.util
 * @Description: TODO(用一句话描述该文件做什么)
 * @author fujiantao
 * @date 2019年8月21日 下午4:28:49 
 * @version V1.0  
 */

package com.fjt.util;

import java.security.MessageDigest;

/**
 * @ClassName: Md5加密工具
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author fujiantao
 * @date 2019年8月21日
 *
 */

public class Md5Tool {

	public final static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };

		try {
			// 输入的字符串转换成字节数组
			byte[] strTemp = s.getBytes();
			// 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			// 计算md5函数
			mdTemp.update(strTemp);
			// 转换并返回结果，也是字节数组，包含16个元素
			byte[] md = mdTemp.digest();
			int j = md.length;
			// new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
			char str[] = new char[j * 2];
			// 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	/*public static void main(String[] args) {
		System.out.println(Md5Tool.MD5("123"));
	}*/

}
