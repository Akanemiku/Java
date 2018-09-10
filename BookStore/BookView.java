package BookStore;

import java.util.Scanner;

//ͼ��ϵͳ�Ľ���
public class BookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("***********************");
		System.out.println("\t��ӭʹ��ͼ�����ϵͳ");
		System.out.println("\t1����¼\t\t2���˳�ϵͳ");
		System.out.println("***********************");
		System.out.println("��ѡ��");
		String choice = input.next();
		if("1".equals(choice)){
			//ִ�е�¼����
			//��֤�ɹ�������ʾ���˵�
			System.out.println("��¼������δʵ�֣�Ĭ���ѵ�¼");
			showMainView();
		}
		System.out.println("ͼ��ϵͳ�ѳɹ��Ƴ�����ӭ�ٴ�ʹ��");
	}
	public void showMainView(){
		System.out.println("\nͼ�����ϵͳ >> ���˵�");
		System.out.println("1������ͼ��\t2��ɾ��ͼ��\t3���鿴����ͼ��\t4������ͼ��\t5�����\t6������\t7���˳�");
		System.out.println("��ѡ��");
		String choice = input.next();
		switch(choice){
			case "1":
				showAddNewBookView();
				showBooks(Datas.BookStore);
			break;
			case "2":
				showDelOldBookView();
			break;
			case "3":
			break;
			case "4":
			break;
		}
	}
	
	public Book showAddNewBookView() {
		System.out.println("\nͼ�����ϵͳ >> ����ͼ��");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		//��Ҫ��֤�û�����ı���Ƿ����
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null){//�������ͼ��
			newBook = new Book();
			newBook.setBookId(bookId);
			System.out.print("���ƣ�");
			newBook.setBookName(input.next());
			System.out.print("��棺");
			newBook.setCount(input.nextInt());
			
			bookBiz.addBook(newBook);//����ͼ��ҵ����󣬽�������ͼ�������ӵ�ͼ��ֿ���
		}else {//ͼ���Ѵ���
			System.out.println("���ڲ�����Ѵ��ڣ����������룡");
			newBook = showAddNewBookView();//���µ��ñ����������û��ٴ����� - �ݹ����
		}
		return newBook;
	}
	
	public Book showDelOldBookView() {
		System.out.println("\nͼ�����ϵͳ >> ɾ��ͼ��");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		Book delBook = bookBiz.findById(bookId);
		if(delBook == null) {
			System.out.println("���ڲ���Ų����ڣ����������룡");
			delBook = showDelOldBookView();
		}else {
			bookBiz.delBook(delBook);
		}
		return delBook;
	}
	
	public void showBooks(Book ...BookArray){
		System.out.println("�ڲ����\t����\t���");
		int bookCount = bookBiz.getBookCount(BookArray);
		for(int i=0;i<bookCount;i++){
			System.out.printf("%s\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}
	}
}