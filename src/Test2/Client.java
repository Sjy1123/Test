package Test2;
import Test.Hotel;
import java.util.Scanner;
public class Client {

	public static void main(String[] args) {
		
		Hotel hotel = new Hotel("xialideng");//����Hotel����
		System.out.println("��ӭ����ס"+hotel.getHotelname()+"�Ƶ�");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);//�½�����
		System.out.println("����������ָ�");
		String command = scn.next();//����ĵ�һ����
		String roomNo;//���巿���
		//ͨ��whileѭ������Hotel��Room��������ķ���
		while(!command.equalsIgnoreCase("quit")){//����quit�˳�
			
			if(command.equalsIgnoreCase("search")){//����search������searchByNo����
				String para = scn.next();//�ڶ�������
				if(para.equals("all"))
					hotel.searchAll();//����searchAll����
				else
					hotel.searchByNo(para);//����searchByNo����
				}
			else if(command.equalsIgnoreCase("in")){//��ѯ��סϵͳ
				roomNo = scn.next();//�ͷ����
				String name = scn.next();//�ͻ�����
				int res = hotel.checkIn(roomNo, name);//������ס����
				if(res == 1)
					System.out.println(name+"�ɹ���ס��");
				else if(res == 2)
					System.out.println("�ÿͷ��Ѿ��п����ˣ�");
				else if(res ==3)
					System.out.println("�ͷ�����������");
				}
			else if(command.equalsIgnoreCase("out")){//��ѯ�˷�����
				roomNo = scn.next();//��ѯ�ڶ����ʷ����
				int res = hotel.checkout(roomNo);//����checkout����
				if(res == 1)
					System.out.println(roomNo+"�ɹ��˷���");
				else if(res == 2)
				    System.out.println("�ÿͷ�û�п��ˣ�");
				else if(res == 3)
					System.out.println("�ͷ�����������");
					}
			else //û���ҵ�����Ҫ�ķ���
				System.out.println("û�и�ָ�");
			System.out.println("����������ָ�");
			command = scn.next();//ѭ��������������
		}
		System.out.println("��ӭ���´ι���"+hotel.getHotelname());
		System.exit(0);
	}
	

}
