package JYBTestFallback;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dafycredit.giveu.test.base.Test_Unit;
import com.dafycredit.giveu.test.service.RunUnit_Service;
import com.dafycredit.giveu.test.service.TestXmlParse_Service;

public class P2P_PPM_Mobile_SeriesB32 {
	
	private static RunUnit_Service runService;
		
	@BeforeTest
	public void stup() throws Exception{
		Test_Unit testunit = TestXmlParse_Service.parse("src/main/java/JYBTestFallback/P2P_PPM_Mobile_SeriesB32.xml");
		runService = new RunUnit_Service(testunit);
		System.out.println("-----------------------------------【P2P_PPM模式下兜底(三十二)用户购买手机系列B产品的测试场景点】-----------------------------------");
	}
		
	@Test
	public void Precondition() throws Exception{
		runService.runCase("前置条件");
		runService.TestReportRemarks("验证在数据库中,执行对应SQL语句,可以正常执行成功");
	}

	@Test
	public void case1() throws Exception{
		runService.runCase("case1");
		runService.TestReportRemarks("验证在新建订单界面,选择输入对应产品信息,点击下一步按钮后,可以正常进入产品列表界面");
	}
	
	@Test
	public void case2() throws Exception{
		runService.runCase("case2");
		runService.TestReportRemarks("验证在产品列表界面,选择对应产品信息,点击下一步按钮后,可以正常进入商品信息界面");
	}
	
	@Test
	public void case3() throws Exception{
		runService.runCase("case3");
		runService.TestReportRemarks("验证在商品信息界面,选择输入对应商品信息,点击下一步按钮后,可以正常进入客户信息界面");
	}
	
	@Test
	public void case4() throws Exception{
		runService.runCase("case4");
		runService.TestReportRemarks("验证在客户信息界面,上传输入对应客户身份证正反面照片信息,点击生成订单按钮后,可以正常进入基本信息界面");
	}
	
	@Test
	public void case5() throws Exception{
		runService.runCase("case5");
		runService.TestReportRemarks("验证在基本信息界面,选择输入对应客户基本信息,点击下一步按钮后,可以正常进入单位信息界面");
	}
	
	@Test
	public void case6() throws Exception{
		runService.runCase("case6");
		runService.TestReportRemarks("验证在单位信息界面,选择输入对应客户单位信息,点击下一步按钮后,可以正常进入联系人填写界面");
	}
	
	@Test
	public void case7() throws Exception{
		runService.runCase("case7");
		runService.TestReportRemarks("验证在联系人填写界面,选择输入对应客户联系人信息,点击下一步按钮后,可以正常进入绑定银行卡界面");
	}
	
	@Test
	public void case8() throws Exception{
		runService.runCase("case8");
		runService.TestReportRemarks("验证在绑定银行卡界面,输入对应客户银行卡信息,点击下一步按钮后,可以正常进入其他信息界面");
	}
	
	@Test
	public void case9() throws Exception{
		runService.runCase("case9");
		runService.TestReportRemarks("验证在其他信息界面,输入对应客户其他信息,点击下一步按钮后,可以正常进入芝麻信用认证界面");
	}
	
	@Test
	public void case_10() throws Exception{
		runService.runCase("case_10");
		runService.TestReportRemarks("验证在芝麻信用认证界面,点击跳过认证按钮后,可以正常跳过认证并进入运营商授权认证界面");
	}
	
	@Test
	public void case_11() throws Exception{
		runService.runCase("case_11");
		runService.TestReportRemarks("验证在运营商授权认证界面,点击跳过认证按钮后,可以正常跳过认证并进入影像证明界面");
	}
		
	@Test
	public void case_12() throws Exception{
		runService.runCase("case_12");
		runService.TestReportRemarks("验证在影像证明界面,上传对应客户影像证明照片,点击确认提交按钮后,可以正常弹出请输入登录密码,以验证身份界面");
	}
	
	@Test
	public void case_13() throws Exception{
		runService.runCase("case_13");
		runService.TestReportRemarks("验证在请输入登录密码,以验证身份界面,输入对应用户登录密码,点击确认按钮后,可以正常提交合同并进入成功提交界面");
	}
	
	@Test
	public void case_14() throws Exception{
		runService.runCase("case_14");
		runService.TestReportRemarks("验证在成功提交界面,点击查看订单按钮后,可以正常进入订单列表-审核中列界面");
	}
	
	@AfterTest
	public static void And(){
		runService.close();
	}
}
