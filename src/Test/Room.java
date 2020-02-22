package Test;
public class Room {
	/***
	 * Room类的一些调用方法
	 */
	private String id;//定义房间号
	private String customerName;//定义姓名
	//
	public Room(){
		
	}
	
	public String getId() {//调用getId方法
		return id;
	}
	
	public void setId(int floor,int number) {//初始化房间的编号
		
		this.id = (floor>=10?floor+"":"0"+floor)+(number>=10?number+"":"0"+number);
		//四位房间数分成两部分，前两位一部分，后两位一部分，第一部分大于零后面加空，小于十前面加零，第二部分亦然。
		
		}
	
	public String getCustomerNmae() {//get方法返回姓名
		return customerName;
	}
	
	public void setCustomerNmae(String customerNmae) {//set方法赋值姓名给参数
		this.customerName = customerNmae;
	}

	public boolean in(String customerName){//入住系统
		if(this.customerName==null){			//查询姓名
			this.customerName = customerName;
			return true;
		}
		else
			return false;
		}
	
	public boolean out(){//退房系统
		if(this.customerName == null)//查询姓名
			return false;
		else{
			this.customerName = null;
			return true;
			}
	}

}
