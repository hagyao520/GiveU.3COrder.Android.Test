package com.dafycredit.giveu.test.handler;

import java.util.concurrent.TimeUnit;

import com.dafycredit.giveu.test.base.Test_Step;
import com.dafycredit.giveu.test.util.Appium_Util;

/**
 * <br>处理界面上的点击操作，即如果当前操作为点击，<br/>
 * 则选中脚本中配置的节点，并执行点击操作</br>
 *
 * @author  102051
 * @email   mengxiw@dafycredit.com
 * @date    2017年7月26日 上午10:27:26
 * @version 1.0
 * @since   1.0
 */
public class ClickAction_Handler {
	
	/**
	 * <br>点击操作</br>
	 *
	 * @param step
	 * @throws Exception 
	 */
	public void click(Test_Step step) throws Exception{ 
		try {
			 System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			 step.getDriver().manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
			 Appium_Util.getElement(step).click(); 
			 Thread.sleep(600);	 
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
}
