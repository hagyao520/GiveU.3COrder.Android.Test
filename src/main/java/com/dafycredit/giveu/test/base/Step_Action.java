package com.dafycredit.giveu.test.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.WebElement;

import com.dafycredit.giveu.test.handler.CheckAction_Handler;
import com.dafycredit.giveu.test.handler.ClickAction_Handler;
import com.dafycredit.giveu.test.handler.DBAction_Handler;
import com.dafycredit.giveu.test.handler.RecordAction_Handler;
import com.dafycredit.giveu.test.handler.SlideAction_Handler;
import com.dafycredit.giveu.test.handler.WaitAction_Handler;
import com.dafycredit.giveu.test.util.Appium_Util;

import io.appium.java_client.android.AndroidDeviceActionShortcuts;

public enum Step_Action {
	
    GET("get", "访问网站"){
		@Override
		public void run(Test_Step step) {
			step.getDriver().get(step.getValue());
		}
	},

    SET("set", "设置值到全局"){
		@Override
		public void run(Test_Step step) throws Exception {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">" + Appium_Util.localmap.toString());
			step.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			if(StringUtils.isBlank(step.getDetails().get("key")))
				throw new Exception("set操作必须设置保存结果的键值，供后续操作使用，例子为details='key:credit'！");
			String value = Appium_Util.getElement(step).getText();
			Appium_Util.localmap.put(step.getDetails().get("key").toUpperCase(), value);
//			System.out.println("SrepAction: " + Appium_Util.localmap.toString());
		}
	},
    
    INPUT("input", "Appium默认输入"){
		@Override
		public void run(Test_Step step) throws Exception {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			step.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement e = Appium_Util.getElement(step);
			e.clear();
			e.sendKeys(Appium_Util.parseStringHasEls(step.getValue()));	
		}
	},
    
    INPUT_ADB("input-adb", "adb指令输入"){
		@Override
		public void run(Test_Step step) throws Exception {
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			step.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			Appium_Util.getElement(step).click(); 
			Runtime.getRuntime().exec("adb shell input text "+step.getValue());
		}
	},
    
    SCROLL_TO("scroll-to","滚动"){
		@Override
		public void run(Test_Step step) throws Exception {
			step.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			step.getDriver().scrollToExact(step.getValue()).click();
		}
	},
    

    ClEAR("clear", "清除"){
		@Override
		public void run(Test_Step step) throws Exception{   
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			step.getDriver().manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
			WebElement e = Appium_Util.getElement(step);
			e.clear();	
        }
	},
    
    
    AndroidKeycode("akc", "模拟Android系统按键操作,例如：KEYCODE_HOME 3"){
		@Override
        public void run(Test_Step step) throws InterruptedException{
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
 	        ((AndroidDeviceActionShortcuts) step.getDriver()).
 	        	pressKeyCode(Integer.valueOf(step.getDetails().get("key")));
 	            Thread.sleep(600);
		}
    },
    
    RETURN("return", "模拟Android系统返回操作,可返回多次"){
		@Override
        public void run(Test_Step step) throws InterruptedException{
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			int Num = Integer.valueOf(step.getDetails().get("num"));
			for (int i = 0; i < Num; i++) {  
				step.getDriver().navigate().back(); 
	        }
		}
    },
    
    WindowsCmd("cmd", "执行Windows系统的cmd命令"){
		@Override
        public void run(Test_Step step) throws InterruptedException{
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			Runtime runtime=Runtime.getRuntime();
	        try{
	            runtime.exec(step.getValue());  
	        }
	        catch(Exception e){	
	        }
	        Thread.sleep(500);
		}
    },

    OpenNotificationBar("opennb", "打开Androud系统通知栏"){
		@Override
        public void run(Test_Step step){
			System.out.println("『正常测试』开始执行: " + "<" +step.getDesc() + ">");
			step.getDriver().openNotifications();
		}
    },
      
    CHECK("check", "检查界面元素值", CheckAction_Handler.class),
    CHECK_VIEW("check-view", "检查View界面元素content-desc值", CheckAction_Handler.class),
    CHECK_LIST("check-list", "检查本地缓存的list中的元素", CheckAction_Handler.class),
    
    WAIT_FORCED("wait-forced", "强制等待", WaitAction_Handler.class),
    WAIT_IMPLICIT("wait-implicit", "隐性等待", WaitAction_Handler.class),
    
    CLICK("click", "点击", ClickAction_Handler.class),
    CLICK_OK("click-ok", "点击弹出框_确定", ClickAction_Handler.class),
    CLICK_CANCEL("click-cancel", "点击弹出框_取消", ClickAction_Handler.class),
    
    START_RECORD("start-record", "开始录制视频",RecordAction_Handler.class),
    END_RECORD("end-record", "结束录制视频",RecordAction_Handler.class),
    PNLL_RECORD("pull-record", "上传录制的视频",RecordAction_Handler.class),
    MOVE_RECORD("move-record", "移动录制的视频",RecordAction_Handler.class),
    
    SLIDE("slide", "自定义滑动", SlideAction_Handler.class),
    SLIDE_UP("slide-up", "向上滑动", SlideAction_Handler.class),
    SLIDE_DOWN("slide-down", "向下滑动", SlideAction_Handler.class),
    SLIDE_LEFT("slide-left", "向左滑动", SlideAction_Handler.class),
    SLIDE_RIGHT("slide-right", "向右滑动", SlideAction_Handler.class),
    
	DB_QUERY("db-query", "数据库查询", DBAction_Handler.class),
    DB_UPDATE("db-update", "数据库更新", DBAction_Handler.class),
    DB_DELETE("db-delete", "数据库删除", DBAction_Handler.class),
    DB_INSERT("db-insert", "数据库插入", DBAction_Handler.class),
	DB_PROCEDURE("db-procedure", "数据库存储过程", DBAction_Handler.class),
	
	DB_QUERYM("db-querym", "数据库查询", DBAction_Handler.class),
    DB_UPDATEM("db-updatem", "数据库更新", DBAction_Handler.class),
    DB_DELETEM("db-deletem", "数据库删除", DBAction_Handler.class),
    DB_INSERTM("db-insertm", "数据库插入", DBAction_Handler.class),
	DB_PROCEDUREM("db-procedurem", "数据库存储过程", DBAction_Handler.class);
	
    private String key;

    private String desc;

    private Class<?> handler;

    private static Map<String,Step_Action> map;

    static{
        map = new HashMap<String,Step_Action>();
        for(Step_Action action : Step_Action.values()){
            map.put(action.key(), action);
        }
    }

    private Step_Action(String key, String desc, Class<?> handler) {
        this(key, desc);
        this.handler = handler;
    }

    private Step_Action(String key, String desc) {
        this.key = key;
        this.desc = desc;
    }

    public static Step_Action action(String name){
        return map.get(name);
    }

    public String key(){
        return this.key;
    }

    public String desc(){
        return this.desc;
    }

    public Class<?> handler(){
        return this.handler;
    }
    
    public void run(Test_Step step) throws Exception{
    	
    }
}
