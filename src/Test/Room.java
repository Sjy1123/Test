package Test;
public class Room {
	/***
	 * Room���һЩ���÷���
	 */
	private String id;//���巿���
	private String customerName;//��������
	//
	public Room(){
		
	}
	
	public String getId() {//����getId����
		return id;
	}
	
	public void setId(int floor,int number) {//��ʼ������ı��
		
		this.id = (floor>=10?floor+"":"0"+floor)+(number>=10?number+"":"0"+number);
		//��λ�������ֳ������֣�ǰ��λһ���֣�����λһ���֣���һ���ִ��������ӿգ�С��ʮǰ����㣬�ڶ�������Ȼ��
		
		}
	
	public String getCustomerNmae() {//get������������
		return customerName;
	}
	
	public void setCustomerNmae(String customerNmae) {//set������ֵ����������
		this.customerName = customerNmae;
	}

	public boolean in(String customerName){//��סϵͳ
		if(this.customerName==null){			//��ѯ����
			this.customerName = customerName;
			return true;
		}
		else
			return false;
		}
	
	public boolean out(){//�˷�ϵͳ
		if(this.customerName == null)//��ѯ����
			return false;
		else{
			this.customerName = null;
			return true;
			}
	}

}
