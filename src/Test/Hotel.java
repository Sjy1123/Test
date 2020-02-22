package Test;
public class Hotel {
	/***
	 * Hotel���һЩ���÷���
	 */
	private String hotelname="ϲ����";//���丳ֵ
	private Room[][] rooms;//���巿���ŵ�����
	public static final int HEIGHT = 6;//��
	public static final int WIDTH = 12;//��
	
	public Hotel(String string){//�����õ�Hotel����
		rooms = new Room[HEIGHT][WIDTH];//��ʼ������ı��ʹ������Ϊ��
		for(int i=0;i<HEIGHT;i++){
			for(int j=0;j<WIDTH;j++){
				rooms[i][j] = new Room();
				rooms[i][j].setId(i+1, j+1);//����setId�������г�ʼ��������
			}
			
		}
		
	}
	
	public String getHotelname() {//get��������ȡֵ
		return hotelname;
	}
	
	public void setHotelname(String hotelname) {//set��������Ա��ֵ
		this.hotelname = hotelname;
	}
	
	public void searchAll(){//���ȫ��������Ϣ
		for(int i=0;i<HEIGHT;i++){			
			for(int j=0;j<WIDTH;j++)
				System.out.print(rooms[i][j].getId()+"\t");//�����һ�з����
			System.out.println();//����
			for(int j=0;j<WIDTH;j++){
				String name=rooms[i][j].getCustomerNmae();
				if(name==null)
					System.out.print("\t");
				else
					System.out.println(name+"\t");//����ڶ��еķ�������
				}
			System.out.println();
			for(int j=0;j<8*WIDTH;j++){
				System.out.print("_");
			}
			System.out.println();
		}
	}
	
	public void searchByNo(String roomNo){//��ѯ�������޿��˾�ס
		if(testRoomNO(roomNo)){
			int height = Integer.parseInt(roomNo.substring(0,2));//����ǰ��λ�����
			int width  = Integer.parseInt(roomNo.substring(2,4));//��������λ�����
			System.out.println(rooms[height-1][width-1].getCustomerNmae() == null?"�÷�û�п���":roomNo+":"+rooms[height-1][width-1].getCustomerNmae());
		    }
		else
			System.out.println("û������ͷ���");
	}
	
    public int checkIn(String roomNO,String customer){//��סϵͳ
	    if(testRoomNO(roomNO)==true){
	    	int floor = Integer.parseInt(roomNO.substring(0, 2));//��ȡǰ��λ
			int num = Integer.parseInt(roomNO.substring(2, 4));//��ȡ����λ
			if(rooms[floor-1][num-1].in(customer))
				return 1;//��ס�ɹ�
			else
				return 2;//�����п���
				   	
	    }
	    else
	    	return 3;//����������
		
	}
    
    public int checkout(String roomNo){//�˷�ϵͳ
    	if(testRoomNO(roomNo)){
    		int height = Integer.parseInt(roomNo.substring(0,2));//��ȡǰ��λ
			int width  = Integer.parseInt(roomNo.substring(2,4));//��ȡ����λ
			if(rooms[height-1][width-1].out())
				return 1;//�˷��ɹ�
			else
				return 2;//�÷���û����
    	}
    	else
			return 3;//û���������
    	
    }

    private boolean testRoomNO(String roomNO){//��֤��������Ƿ����
		int floor = Integer.parseInt(roomNO.substring(0, 2));
		int num = Integer.parseInt(roomNO.substring(2, 4));
		if((floor>=1&&floor<=HEIGHT)&&(num>=1&&num<=WIDTH)){
			return true;
		}
		else
			return false;
		
	}

}
