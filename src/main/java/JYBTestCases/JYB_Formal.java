package JYBTestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.TestXmlParse_Service;

public class JYB_Formal {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	private void stup() throws Exception{
		Test_Unit testunit = TestXmlParse_Service.parse2("src/main/java/JYBTestCaseXml/JYB_Formal.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【即有宝生产环境试运行测试】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在Android中,首次安装启动即有宝APP后,引导页显示正常且可以滑动至最后一页");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在引导页最后一页界面,点击开始体验按钮后,可以正常进入登录界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在登录界面,输入正确的账号和密码,已连接网络和开启GPS定位权限时,点击登录按钮后,可以正常登录并进入设置解锁密码界面");
	}

	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在新建订单界面,选择输入对应产品信息,点击下一步按钮后,可以正常进入产品列表界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在产品列表界面,点击保险/权益包费用选项后,可以正常打开网页协议,且内容显示正确");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在商品信息界面,选择输入对应商品信息,点击手机健康/延保费用选项后,可以正常打开网页协议,且内容显示正确");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在绑定银行卡界面,点击查看支持银行按钮,可以正常打开支持银行卡列表界面,且内容显示正确");
	}
	
	@Test
	public void case8() throws Exception{
		runService.runCase("case8");
		runService.TestReportRemarks("验证在短信征信授权界面,点击征信授权协议按钮后,可以正常打开征信授权协议,且内容显示正确");
	}
	
	@Test
	public void case9() throws Exception{
		runService.runCase("case9");
		runService.TestReportRemarks("验证在订单详情界面,点击底部对应的合同协议后,可以正常打开,且内容显示正确");
	}
	
	@Test
	public void case_10() throws Exception{
		runService.runCase("case_10");
		runService.TestReportRemarks("验证在我的界面,点击我的通知选项后,可以正常打开,且内容显示正确");
	}
	
	@Test
	public void case_11() throws Exception{
		runService.runCase("case_11");
		runService.TestReportRemarks("验证在我的界面,点击我的通知选项后,可以正常打开,且内容显示正确");
	}
	
	@Test
	public void case_12() throws Exception{
		runService.runCase("case_12");
		runService.TestReportRemarks("验证在我的界面,点击晨星荟选项后,可以正常打开,且内容显示正确");
	}
	
	@Test
	public void case_13() throws Exception{
		runService.runCase("case_13");
		runService.TestReportRemarks("验证在我的界面,点击我的门店选项,选择对应时间段后,可以正常搜索出门店数据");
	}
	
	@Test
	public void case_14() throws Exception{
		runService.runCase("case_14");
		runService.TestReportRemarks("验证在我的界面,点击推广钱包选项后,可以正常显示对应二维码");
	}
		
	@Test
	public void case_15() throws Exception{
		runService.runCase("case_15");
		runService.TestReportRemarks("验证在我的界面,点击签到按钮,输入和上传对应备注和照片,点击提交签到按钮后,可以正常签到成功");
	}
	
	@AfterTest
	public void TearDown(){
		runService.close();
	}
}
