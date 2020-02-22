package Test;
public class Hotel {
	/***
	 * Hotel类的一些调用方法
	 */
	private String hotelname="喜来登";//给其赋值
	private Room[][] rooms;//定义房间编号的数组
	public static final int HEIGHT = 6;//行
	public static final int WIDTH = 12;//列
	
	public Hotel(String string){//被调用的Hotel函数
		rooms = new Room[HEIGHT][WIDTH];//初始化房间的编号使其里面为空
		for(int i=0;i<HEIGHT;i++){
			for(int j=0;j<WIDTH;j++){
				rooms[i][j] = new Room();
				rooms[i][j].setId(i+1, j+1);//调用setId方法进行初始化房间编号
			}
			
		}
		
	}
	
	public String getHotelname() {//get方法返回取值
		return hotelname;
	}
	
	public void setHotelname(String hotelname) {//set方法给成员赋值
		this.hotelname = hotelname;
	}
	
	public void searchAll(){//输出全部房间信息
		for(int i=0;i<HEIGHT;i++){			
			for(int j=0;j<WIDTH;j++)
				System.out.print(rooms[i][j].getId()+"\t");//输出第一行房间号
			System.out.println();//换行
			for(int j=0;j<WIDTH;j++){
				String name=rooms[i][j].getCustomerNmae();
				if(name==null)
					System.out.print("\t");
				else
					System.out.println(name+"\t");//输出第二行的房间姓名
				}
			System.out.println();
			for(int j=0;j<8*WIDTH;j++){
				System.out.print("_");
			}
			System.out.println();
		}
	}
	
	public void searchByNo(String roomNo){//查询房间有无客人居住
		if(testRoomNO(roomNo)){
			int height = Integer.parseInt(roomNo.substring(0,2));//解析前两位房间号
			int width  = Integer.parseInt(roomNo.substring(2,4));//解析后两位房间号
			System.out.println(rooms[height-1][width-1].getCustomerNmae() == null?"该房没有客人":roomNo+":"+rooms[height-1][width-1].getCustomerNmae());
		    }
		else
			System.out.println("没有这个客房！");
	}
	
    public int checkIn(String roomNO,String customer){//入住系统
	    if(testRoomNO(roomNO)==true){
	    	int floor = Integer.parseInt(roomNO.substring(0, 2));//截取前两位
			int num = Integer.parseInt(roomNO.substring(2, 4));//截取后两位
			if(rooms[floor-1][num-1].in(customer))
				return 1;//入住成功
			else
				return 2;//房间有客人
				   	
	    }
	    else
	    	return 3;//编号输入错误
		
	}
    
    public int checkout(String roomNo){//退房系统
    	if(testRoomNO(roomNo)){
    		int height = Integer.parseInt(roomNo.substring(0,2));//截取前两位
			int width  = Integer.parseInt(roomNo.substring(2,4));//截取后两位
			if(rooms[height-1][width-1].out())
				return 1;//退房成功
			else
				return 2;//该房间没有人
    	}
    	else
			return 3;//没有这个房间
    	
    }

    private boolean testRoomNO(String roomNO){//验证这个房间是否存在
		int floor = Integer.parseInt(roomNO.substring(0, 2));
		int num = Integer.parseInt(roomNO.substring(2, 4));
		if((floor>=1&&floor<=HEIGHT)&&(num>=1&&num<=WIDTH)){
			return true;
		}
		else
			return false;
		
	}

}
