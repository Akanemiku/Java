package BookStore;

import java.util.Scanner;

//ͼ��ϵͳ�Ľ���
public class BookView{
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView(){
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		
		System.out.println("***************************************");
		System.out.println("\t��ӭʹ��ͼ�����ϵͳ");
		System.out.println("\t1����¼\t\t2���˳�ϵͳ");
		System.out.println("***************************************");
		System.out.println("��ѡ��");
		String choice = input.next();
		if("1".equals(choice)){
			//ִ�е�¼����
			//��֤�ɹ�������ʾ���˵�
			System.out.println("��¼������δʵ�֣�Ĭ���ѵ�¼");
			for(;;)
			showMainView();
		}else {
			System.out.println("ͼ��ϵͳ�ѳɹ��˳�����ӭ���ٴ�ʹ��");
			System.exit(0);
		}
	}
	public void showMainView(){
		System.out.println("\nͼ�����ϵͳ >> ���˵�");
		System.out.println("1���鿴����ͼ��\t2������ͼ��\t3��ɾ��ͼ��\t4�����\t5������\t6������ͼ��\t7���˳�");
		System.out.println("��ѡ��");
		String choice = input.next();
		switch(choice){
			case "1":
				showBooks(Datas.BookStore);
				break;
			case "2":
				showAddNewBookView();
				showBooks(Datas.BookStore);
				break;
			case "3":
				showDelOldBookView();
				showBooks(Datas.BookStore);
				break;
			case "4":
				showInStoreView();
				showBooks(Datas.BookStore);
				break;
			case "5":
				showOutStoreView();
				showBooks(Datas.BookStore);
				break;
			case "6":
				break;
			default:
				showExitView();
				System.out.println("��ӭ���ٴ�ʹ�ñ�ϵͳ");
				System.exit(0);
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
	
	public Book showInStoreView() {
		System.out.println("\nͼ�����ϵͳ >> ���");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		Book inStoreBook = bookBiz.findById(bookId);
		if(inStoreBook == null){
			System.out.println("���ڲ���Ų����ڣ����������룡");
			inStoreBook = showInStoreView();
		}else {
			System.out.println("�������������");
			int inStoreNum = input.nextInt();
			bookBiz.inStore(bookId,inStoreNum);
			System.out.println("���ɹ���");
		}
		return inStoreBook;
	}
	
	public Book showOutStoreView() {
		System.out.println("\nͼ�����ϵͳ >> ����");
		System.out.println("�ڲ���ţ�");
		String bookId = input.next();
		Book outStoreBook = bookBiz.findById(bookId);
		if(outStoreBook == null){
			System.out.println("���ڲ���Ų����ڣ����������룡");
			outStoreBook = showOutStoreView();
		}else {		
			System.out.println("�������������");
			int outStoreNum = input.nextInt();
			if(false == bookBiz.outStore(bookId,outStoreNum))
				System.out.println("���ʧ��");
			System.out.println("����ɹ���");
		}
		return outStoreBook;
	}
	
	public void showBooks(Book ...BookArray){
		System.out.println("�ڲ����\t����\t���");
		int bookCount = bookBiz.getBookCount(BookArray);
		for(int i=0;i<bookCount;i++){
			System.out.printf("%s\t%s\t%d\n",BookArray[i].getBookId(),BookArray[i].getBookName(),BookArray[i].getCount());
		}
	}
	
	public void showExitView(){
		System.out.println("�㡭�����Ҫ�뿪�");
		try {
			Thread.sleep(1500);
			System.out.println("��Ҫ�뿪����ò��ã�");
			Thread.sleep(1600);
			System.out.println("�����˺�������ʣ����һ�����ˡ���");
			Thread.sleep(1700);
			System.out.println("��֪���ģ�����ܺڣ������޾������һ�����������ɴ�������");
			Thread.sleep(2000);
			System.out.println("���ԡ�����Ҫ������һ���ˣ����𡭡���");
			Thread.sleep(2000);
		}catch(InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		System.out.print("�����롭��  ");
		String exitNum = input.next();
		System.out.println("ϵͳ��⵽�쳣�������˳�");
	}
}