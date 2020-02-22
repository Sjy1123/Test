package Test2;
import Test.Hotel;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {
		
		Hotel hotel = new Hotel("xialideng");//调用Hotel属性
		System.out.println("欢迎您入住"+hotel.getHotelname()+"酒店");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);//新建输入
		System.out.println("请输入您的指令：");
		String command = scn.next();//输入的第一个词
		String roomNo;//定义房间号
		//通过while循环调用Hotel和Room属性里面的方法
		while(!command.equalsIgnoreCase("quit")){//输入quit退出
			
			if(command.equalsIgnoreCase("search")){//调用search方法和searchByNo方法
				String para = scn.next();//第二个单词
				if(para.equals("all"))
					hotel.searchAll();//调用searchAll方法
				else
					hotel.searchByNo(para);//调用searchByNo方法
				}
			else if(command.equalsIgnoreCase("in")){//查询入住系统
				roomNo = scn.next();//客房编号
				String name = scn.next();//客户姓名
				int res = hotel.checkIn(roomNo, name);//调用入住方法
				if(res == 1)
					System.out.println(name+"成功入住！");
				else if(res == 2)
					System.out.println("该客房已经有客人了！");
				else if(res ==3)
					System.out.println("客房编号输入错误！");
				}
			else if(command.equalsIgnoreCase("out")){//查询退房方法
				roomNo = scn.next();//查询第二个词房间号
				int res = hotel.checkout(roomNo);//调用checkout方法
				if(res == 1)
					System.out.println(roomNo+"成功退房！");
				else if(res == 2)
				    System.out.println("该客房没有客人！");
				else if(res == 3)
					System.out.println("客房编号输入错误！");
					}
			else //没有找到您需要的服务
				System.out.println("没有该指令！");
			System.out.println("请输入您的指令：");
			command = scn.next();//循环结束重新输入
		}
		System.out.println("欢迎您下次光临"+hotel.getHotelname());
		System.exit(0);
	}
	

}
