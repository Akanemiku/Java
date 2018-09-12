package BookStore;

//ͼ��ҵ����(ҵ��㾡����д��ӡ(�����д))
//������ͼ���Լ�ͼ������Ļ�������
public class BookBiz{
	
	//���ͼ��ֿ���Datas.BookStore������ͼ�����ĸ���
	public int getBookCount(){
		int count = 0;
		for(Book book :  Datas.BookStore){
			if(book == null) break;
			count++;
		}
		return count;
	}
	public int getBookCount(Book ...books){
		int count = 0;
		for(Book book :  Datas.BookStore){
			if(book == null) break;
			count++;
		}
		return count;
	}
	
	//�������ͼ�������õ�ͼ��ֿ�(����)��ȥ
	public boolean addBook(Book book){
		int bookCount = getBookCount();
		if(Datas.BookStore.length == bookCount){
			return false;
		}
		//����ֿⲻ�����ͽ������ͼ������������������һ��λ��(��һ����nullλ��)
		Datas.BookStore[bookCount] = book;
		return true;
	}
	
	//ɾ�������ͼ�����
	public boolean delBook(Book book){
		int bookCount = getBookCount();
		int delIndex = -1;	//Ҫɾ��Ԫ�ص��±�
		for(int i=0;i<bookCount;i++){
			//if(book.getBookId().equals(Datas.BookStore[i].getBookId())){
			if(book.equals(Datas.BookStore[i])){	
				delIndex = i;
				break;
			}
		}
		if(delIndex == -1){
			return false;//û���ҵ�Ҫɾ����Ԫ��ʱ��ֱ�ӽ�������������false
		}
		//ִ������ɾ����·
		for(int i=delIndex;i<bookCount;i++){
			Datas.BookStore[i] = Datas.BookStore[i+1];
		}
		//�����һ��Ԫ����Ϊnull
		Datas.BookStore[bookCount-1] = null;
		return true;
	}
	
	//ͨ��ͼ��id���Ҷ�Ӧ��ͼ�����
	public Book findById(String bookId){
		int bookCount = getBookCount();
		for(int i=0;i<bookCount;i++){
			if(bookId.equals(Datas.BookStore[i].getBookId())){
				return Datas.BookStore[i];
			}
		}
		return null;
	}
	
	//Ϊ�ֿ������е�ͼ�����ӿ��
	public boolean inStore(String bookId,int count){
		Book book = findById(bookId);
		//�������bookId������
		if(null == book){
			return false;
		}
		//���ӿ��(���ô���)
		book.setCount(book.getCount() + count);
		return true;
	}
	
	//���ֿ����п�����
	public boolean outStore(String bookId,int count){
		Book book = findById(bookId);
		if(null == book){
			return false;
		}
		if(book.getCount() < count){
			return false;
		}
		book.setCount(book.getCount() - count);
		return true;
	}
}
